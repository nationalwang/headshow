package com.headshow.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "funds-identity.properties", encoding = "UTF-8")
@Component
public class IdentityLoadExceptionProperties {

}
