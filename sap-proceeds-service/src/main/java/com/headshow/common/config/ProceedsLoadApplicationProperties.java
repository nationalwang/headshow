package com.headshow.common.config;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author beyondLi
 */
@PropertySource(value = "application-proceeds.properties")
@Component
public class ProceedsLoadApplicationProperties {

}
