package com.headshow.common.tools.aop;

import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.exception.PhantomException;
import com.headshow.common.utils.json.JsonUtils;
import com.headshow.service.backinterfacemanage.SapApiLogAopService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/23 15:40
 * @desc 接口管理切面.
 */
@Aspect
@Component
public class SapApiLogAop {

    @Resource
    SapApiLogAopService sapApiLogAopService;
    @Resource
    ExceptionManager exceptionManager;

    //注解切入点
    @Pointcut("@annotation(com.headshow.common.tools.annotation.SapApiLog)")
    public void sapApiLog() {
    }

    @Around("sapApiLog()")
    public Object doBefore(ProceedingJoinPoint pjp) {
        //当前时间
        LocalDateTime date = LocalDateTime.now();
        //获取客户端ip
        String ip = getIp();
        //获取URL地址
        String url = getUrl(pjp);
        //获取请求方法名
        String className = getClassName(pjp);
        //获取该方法的id
        Integer id = sapApiLogAopService.queryByOpenName(className);
        // result的值就是被拦截方法的返回值
        Object result = new Object();
        if (verdictIp(ip).equals("no")) {
            throw exceptionManager.createByCode("INTE_IP_0001");
        }
        if (id == null) {
            throw exceptionManager.createByCode("INTE_METH_0001");
        }
        try {
            //保存请求参数 调用结果 当前时间 调用时间  ip地址   状态到日志
            //请求参数
            String args = getArgs(pjp);
            //调用时间
            LocalDateTime now = LocalDateTime.now();
            // 正常调用结果
            result = pjp.proceed();
            //正常 NORMAL("正常"),ERRO("异常");
            String status = "NORMAL";
            //结束时间
            LocalDateTime overDate = LocalDateTime.now();
            String time = countTime(date, overDate);
            sapApiLogAopService.saveInterfaceManagerDetail(args, result.toString(), now, time, ip, status, id, url);
            return result;
        } catch (Throwable throwable) {
            //保存请求参数 调用时间  ip地址 调用结果 到日志
            //请求参数
            String args = getArgs(pjp);
            //调用时间
            LocalDateTime now = LocalDateTime.now();
            //异常结果
            result = throwable.toString();
            String info = (String) result;
            //异常 NORMAL("正常"),ERRO("异常");
            String status = null;
            PhantomException exception = null;
            if (info.equals("javax.validation.ConstraintViolationException")) {
                //处理校验异常
                ConstraintViolationException e = (ConstraintViolationException) throwable;
                String code = e.getConstraintViolations().stream().limit(1).map(vio -> vio.getMessageTemplate())
                        .collect(Collectors.toList()).get(0);
                exception = exceptionManager.createByCode(code);
                status = "NORMAL";
            }
            if (info.substring(0, 1).equals("{") && info.substring(info.length() - 1, info.length()).equals("}")) {
                //处理自定义异常
                exception = JsonUtils.jsonToBean(info, PhantomException.class);
                status = "NORMAL";
            }
            //结束时间
            LocalDateTime overDate = LocalDateTime.now();
            String time = countTime(date, overDate);
            //记录到接口管理中
            if (exception != null) {
                sapApiLogAopService.saveInterfaceManagerDetail(args, exception.toString(), now, time, ip, status, id, url);
                //抛出异常
                throw exceptionManager.createByCode(exception.getCode());
            } else {
                //证明是系统异常
                status = "ERRO";
                sapApiLogAopService.saveInterfaceManagerDetail(args, info, now, time, ip, status, id, url);
            }
            return result;
        }
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc .ipd段判断
     */
    private String verdictIp(String ip) {
        //获取id
        List<Integer> ids = sapApiLogAopService.urlByIp(ip);
        if (ids != null && ids.size() != 0) {
            for (Integer id : ids) {
                Integer count = sapApiLogAopService.urlById(id, ip);
                if (count != null) {
                    return "yes";
                }
            }
        }
        return "no";
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc .时间计算
     */
    private String countTime(LocalDateTime startTime, LocalDateTime overTime) {
        long start = startTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long over = overTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long a = over - start;
        return String.valueOf(a);
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc .获取请求路径
     */
    private String getUrl(JoinPoint pjp) {
        //获取方法名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //访问路径
        List<Annotation> annotations = Arrays.asList(signature.getMethod().getDeclaredAnnotations())
                .stream()
                .filter(annotation -> annotation.annotationType() == RequestMapping.class)
                .collect(Collectors.toList());
        String requestPath = annotations.size() >= 1
                ? signature.getMethod().getAnnotation(RequestMapping.class).value()[0] : "";
        return requestPath;
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc .获取请求Url
     */
    private String getIp() {

        //获取请求者的ip
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * @author LF--liufang@maxrocky.com
     * @desc .获取方法名
     */
    private String getClassName(JoinPoint pjp) {
        String methodName = pjp.getSignature().getName();
        return methodName;
    }


    /**
     * @author LF--liufang@maxrocky.com
     * @desc .请求参数
     */
    private String getArgs(JoinPoint point) {
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i] + ":" + point.getArgs()[i].toString() + "; ");
        }

        return sb.toString();
    }

}


