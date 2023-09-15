package com.selfstudy.springtheory.scan;

import com.selfstudy.springtheory.AutoAppConfig;
import com.selfstudy.springtheory.member.MemberRepository;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);

        MemberRepository memberRepository = bean.getMemberRepository();

        System.out.println(memberRepository);


    }


}
