package com.selfstudy.springtheory.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class statefulServiceTest {

    @Test
    @DisplayName("가격 비교")
    void statefulServiceTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        statefulService statefulService1 = ac.getBean(statefulService.class);
        statefulService statefulService2 = ac.getBean(statefulService.class);

        int price1 = statefulService1.order("A",10000);
        int price2 = statefulService2.order("B",20000);





//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
        Assertions.assertThat(price1).isNotEqualTo(price2);
    }

    static class TestConfig{

        @Bean
        public statefulService statefulService(){

            return new statefulService();

        }

    }

}
