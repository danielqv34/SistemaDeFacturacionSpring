package com.dqv.controller;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by ezequ on 10/18/2016.
 */

/**
 * @author DanielQuiroz
 *         Motivo: Clase de configuracion Hibernate y Data Source
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
@PropertySource({"classpath:dbFacturacion.properties"})
public class HibernateConfig {

    @Autowired
    private Environment environment;

    private Properties properties() {
        Properties properties = new Properties();
        properties.put("facturacion.show_sql", environment.getRequiredProperty("facturacion.show_sql"));
        properties.put("facturacion.dialect", environment.getRequiredProperty("facturacion.dialect"));
        properties.put("facturacion.format_sql", environment.getRequiredProperty("facturacion.format_sql"));
        return properties;

    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("facturacion.driveClassName");
        dataSource.setUrl("facturacion.url");
        dataSource.setUsername("facturacion.user");
        dataSource.setPassword("facturacion.pass");
        return dataSource;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setHibernateProperties(this.properties());
        sessionFactoryBean.setDataSource(this.dataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"com.dqv.entities"});
        return sessionFactoryBean;
    }


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
