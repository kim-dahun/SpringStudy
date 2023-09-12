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

public class AppConfig {

	public MemberService memberService() {
		
		return new MemberServiceImpl(memberRepository());
		
	}

	public MemberRepository memberRepository() {

		return new MemoryMemberRepository();

	}

	public OrderService orderService() {
		
		return new OrderServiceImpl(memberRepository(), discountPolicy());
		
	}

	public DiscountPolicy discountPolicy(){

		return new RateDiscountPolicy();

	}
	
	
}
