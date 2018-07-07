package com.headshow.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "file-exception.properties", encoding = "UTF-8")
@Component
public class FileLoadExceptionProperties {

}
