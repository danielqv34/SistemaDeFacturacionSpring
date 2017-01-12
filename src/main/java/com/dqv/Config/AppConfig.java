package com.dqv.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by ezequ on 10/22/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.dqv.*"})
@Import(value = {HibernateConfig.class,WebConfig.class})
public class AppConfig {
}
