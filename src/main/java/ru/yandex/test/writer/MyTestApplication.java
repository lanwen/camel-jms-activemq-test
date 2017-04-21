package ru.yandex.test.writer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
public class MyTestApplication {
    public static void main(String... args) {
        SpringApplication.run(MyTestApplication.class, args);
    }

    @Configuration
    public static class CamelRoutes extends RouteBuilder {

        @Override
        public void configure() throws Exception {
            from("activemq:queue:to-write?asyncConsumer=true").to("log:debug");
        }
    }
}
