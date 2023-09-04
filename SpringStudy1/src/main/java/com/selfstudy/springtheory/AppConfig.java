package com.selfstudy.springtheory;

import com.selfstudy.springtheory.discount.RateDiscountPolicy;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;
import com.selfstudy.springtheory.member.MemoryMemberRepository;
import com.selfstudy.springtheory.order.OrderService;
import com.selfstudy.springtheory.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService() {
		
		return new MemberServiceImpl(new MemoryMemberRepository());
		
	}
	
	public OrderService orderService() {
		
		return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
		
	}
	
	
	
}
