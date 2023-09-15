package com.selfstudy.springtheory.singleton;

import com.selfstudy.springtheory.AppConfig;
import com.selfstudy.springtheory.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마다 객체를 생성

        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println(memberService);
        System.out.println(memberService2);

        // memberService != memberService2;
        Assertions.assertThat(memberService).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        // same / == 객체 참조 주소가 같은 지 비교하는 것
        // equals / equals 메서드 overidding 결과값을 비교.

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출할 때마다 객체를 생성

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println(memberService);
        System.out.println(memberService2);

        // memberService != memberService2;
        Assertions.assertThat(memberService).isSameAs(memberService2);

    }
}
