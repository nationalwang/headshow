package com.headshow.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "proceeds-exception.properties", encoding = "UTF-8")
@Component
public class ProceedsLoadExceptionProperties {

}
