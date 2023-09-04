package com.selfstudy.springtheory.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.selfstudy.springtheory.AppConfig;
import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;

public class OrderServiceTest {

	private MemberService memberservice;
	
	private OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		
		AppConfig app = new AppConfig();
		
		memberservice = app.memberService();
		orderService = app.orderService();
		
	}
	
	@Test
	void createOffer() {
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberservice.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
	
}
