package com.selfstudy.springtheory.autowired;

import com.selfstudy.springtheory.AutoAppConfig;
import com.selfstudy.springtheory.discount.DiscountPolicy;
import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    @DisplayName("")
    void findAllBean(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        
        Member member = new Member(1L, "userA", Grade.VIP);
        
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");

        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);

    }

    @Component
    static class DiscountService{

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String,DiscountPolicy> policyMap, List<DiscountPolicy> policies){

            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policy Map = " + policyMap);
            System.out.println("policies = " + policies);

        }

        public int discount(Member member, int i, String discountCode) {

            DiscountPolicy discountPolicy =  policyMap.get(discountCode);

            return discountPolicy.discount(member, i);

        }
    }

}
