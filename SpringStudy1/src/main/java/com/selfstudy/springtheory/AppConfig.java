package com.selfstudy.springtheory;

import com.selfstudy.springtheory.discount.DiscountPolicy;
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
// Configuration 애너테이션이 싱글톤을 보장해줌.
// 보장해주는 방식은 CGLIB 이라는 라이브러리를 사용해서 바이트 코드 변환을 실행함.
// 이 실행의 결과는 AppConfig 클래스 자체는 Container에 등록되지 않고, AppConfig를 상속하는
// 별개의 객체를 만들고 해당 객체의 하위 코드를 조작하여 Singleton 방식이 유지될 수 있도록 변환함.
// 결국 getBean() 메서드를 통해 컨테이너로부터 AppConfig를 불러오면 AppConfig가 아닌 조작된 객체의 인스턴스가 불러와짐.
public class AppConfig {

	@Bean
	public MemberService memberService() {
		System.out.println("Call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
		
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("Call AppConfig.memberRepository");
		return new MemoryMemberRepository();

	}

	@Bean
	public OrderService orderService() {
		System.out.println("Call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
//		return null;
	}

	// Bean 어노테이션 사용 시 스프링 컨테이너에 모두 등록됨.
	@Bean
	public DiscountPolicy discountPolicy(){

		return new RateDiscountPolicy();

	}
	
	
}
