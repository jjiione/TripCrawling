//package com.ssafy.crawling.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "primaryEntityManagerFactory",
//        basePackages = { "com.ssafy.crawling.repository" }
//)
//public class PrimaryDbConfig {
//    @Primary
//    @Bean(name = "primaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("primaryDataSource") DataSource dataSource
//    ) {
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.primary.entity")
//                .persistenceUnit("primary")
//                .build();
//    }
//}
