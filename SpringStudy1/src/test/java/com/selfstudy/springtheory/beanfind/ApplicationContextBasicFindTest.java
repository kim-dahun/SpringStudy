package com.selfstudy.springtheory.beanfind;

import com.selfstudy.springtheory.AppConfig;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // getBean(이름, 타입) -> 해당 빈을 조회할 수 있음.

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){

        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX(){


        assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("XXXXX", MemberService.class));

    }

}
