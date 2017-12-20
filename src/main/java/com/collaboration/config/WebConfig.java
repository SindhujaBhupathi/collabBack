

package com.collaboration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
@EnableWebMvc 
//<mvc:annotation-driven></mvc:annotation-driven>
@ComponentScan(basePackages="com.collaboration")
//<context:component-scan base-package="com.niit"></context:component-scan>
public class WebConfig {
	
}
