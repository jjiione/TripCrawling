//package com.ssafy.crawling.config;
//
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "secondaryEntityManagerFactory",
//        basePackages = { "com.ssafy.crawling.repository" }
//)
//public class SecondaryDbConfig {
//
//    @Bean(name = "secondaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("secondaryDataSource") DataSource dataSource
//    ) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.secondary.entity")
//                .persistenceUnit("secondary")
//                .build();
//    }
//}
