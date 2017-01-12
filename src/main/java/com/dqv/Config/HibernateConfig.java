package com.dqv.Config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
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
@PropertySource(value = {"classpath:dbFacturacion.properties"})
public class HibernateConfig {

    @Autowired
    private Environment environment;

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("facturacion.dialect", environment.getRequiredProperty("facturacion.dialect"));
        properties.put("facturacion.show_sql", environment.getRequiredProperty("facturacion.show_sql"));
        properties.put("facturacion.format_sql", environment.getRequiredProperty("facturacion.format_sql"));
        return properties;

    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("facturacion.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("facturacion.url"));
        dataSource.setUsername(environment.getRequiredProperty("facturacion.user"));
        dataSource.setPassword(environment.getRequiredProperty("facturacion.pass"));
        return dataSource;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
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
