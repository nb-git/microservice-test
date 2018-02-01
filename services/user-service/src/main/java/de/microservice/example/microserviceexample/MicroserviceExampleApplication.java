package de.microservice.example.microserviceexample;

import de.microservice.example.microserviceexample.user.UserRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.retry.annotation.EnableRetry;

import javax.sql.DataSource;

@SpringBootApplication
@EnableRetry
public class MicroserviceExampleApplication {

    @Autowired
    UserRepository userRepository;

    /**
     *
     */
    @Order(Ordered.HIGHEST_PRECEDENCE)
    private class RetryableDataSourceBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName)
                throws BeansException {
            if (bean instanceof DataSource) {
                bean = new RetryableDataSource((DataSource)bean);
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
        SpringApplication.run(MicroserviceExampleApplication.class, args);
    }

    @Bean
    public BeanPostProcessor dataSouceWrapper() {
        return new RetryableDataSourceBeanPostProcessor();
    }
}
