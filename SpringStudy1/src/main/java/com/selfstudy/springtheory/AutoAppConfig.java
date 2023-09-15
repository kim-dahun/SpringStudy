package com.selfstudy.springtheory;

import com.selfstudy.springtheory.member.MemberRepository;
import com.selfstudy.springtheory.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // default scan packaging = 해당 클래스가 있는 패키지와 그 하위 패키지를 모두 탐색.
    basePackages = "com.selfstudy.springtheory",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        )
public class AutoAppConfig {



        @Bean(name = "memoryMemberRepository")
        MemberRepository memberRepository(){

                return new MemoryMemberRepository();

        }

}
