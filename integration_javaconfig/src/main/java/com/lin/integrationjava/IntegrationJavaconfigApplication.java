package com.lin.integrationjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * java dsl 官方文档：https://docs.spring.io/spring-integration/docs/5.0.9.RELEASE/reference/html/java-dsl.html
 *
 * @author lin
 * @date 2018年10月21日
 */
@Controller
@SpringBootApplication
@EnableWebMvc
@EnableAsync
@EnableIntegration
public class IntegrationJavaconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationJavaconfigApplication.class, args);
    }
}
