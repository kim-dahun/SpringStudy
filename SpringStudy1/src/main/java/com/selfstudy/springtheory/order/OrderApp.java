package com.selfstudy.springtheory.order;

import com.selfstudy.springtheory.AppConfig;
import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		AppConfig app = new AppConfig();
//
//		MemberService memberService = app.memberService();
//		OrderService orderService = app.orderService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		long memberId = 1L;
		memberService.join(new Member(memberId,"memberA",Grade.VIP));
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		System.out.println("order = " + order);
		System.out.println(order.calculatePrice());
	}

}
