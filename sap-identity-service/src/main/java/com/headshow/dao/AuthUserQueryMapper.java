package com.headshow.dao;

import com.headshow.entity.dto.AuthUserLoginDTO;
import com.headshow.entity.po.AuthUserPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author linlangleo
 * @desc 用户操作 Mapper
 * @date 2018-09-02 11:40
 **/
public interface AuthUserQueryMapper {

    @Select(value = "select a.name, a.pwd from auth_user AS a left join auth_user_info as b on a.id = b.user_id" +
                    " where a.name = #{login.name} and a.pwd = #{login.password} and b.is_delete = #{login.isDelete}")
    AuthUserPO getLoginUser(@Param("login") AuthUserLoginDTO login);
}
