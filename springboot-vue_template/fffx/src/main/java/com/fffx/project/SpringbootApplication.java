package com.fffx.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/*Spring Boot 会自动加载 spring.datasource.* 相关配置，数据源就会自动注入到 sqlSessionFactory 中，
sqlSessionFactory 会自动注入到 Mapper 中*/
@MapperScan("com.fffx.project.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
