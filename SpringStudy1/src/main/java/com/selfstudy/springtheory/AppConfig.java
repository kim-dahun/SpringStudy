package com.selfstudy.springtheory;

import com.selfstudy.springtheory.discount.DiscountPolicy;
//import com.selfstudy.springtheory.discount.FixDiscountPolicy;
import com.selfstudy.springtheory.discount.RateDiscountPolicy;
import com.selfstudy.springtheory.member.MemberRepository;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;
import com.selfstudy.springtheory.member.MemoryMemberRepository;
import com.selfstudy.springtheory.order.OrderService;
import com.selfstudy.springtheory.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		
		return new MemberServiceImpl(memberRepository());
		
	}

	@Bean
	public MemberRepository memberRepository() {

		return new MemoryMemberRepository();

	}

	@Bean
	public OrderService orderService() {
		
		return new OrderServiceImpl(memberRepository(), discountPolicy());
		
	}

	// Bean 어노테이션 사용 시 스프링 컨테이너에 모두 등록됨.
	@Bean
	public DiscountPolicy discountPolicy(){

		return new RateDiscountPolicy();

	}
	
	
}
