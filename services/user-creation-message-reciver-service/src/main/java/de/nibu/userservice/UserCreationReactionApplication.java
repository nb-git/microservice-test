package de.nibu.userservice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.retry.annotation.EnableRetry;

import javax.sql.DataSource;

@SpringBootApplication
@EnableEurekaClient
@EnableRetry
public class UserCreationReactionApplication {

    /**
     *
     */
    @Order(Ordered.HIGHEST_PRECEDENCE)
    private class RetryableDataSourceBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName)
                throws BeansException {
            if (bean instanceof DataSource) {
                bean = new de.nibu.userservice.RetryableDataSource((DataSource)bean);
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName)
                throws BeansException {
            return bean;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(UserCreationReactionApplication.class, args);
    }

    @Bean
    public BeanPostProcessor dataSouceWrapper() {
        return new RetryableDataSourceBeanPostProcessor();
    }
}
