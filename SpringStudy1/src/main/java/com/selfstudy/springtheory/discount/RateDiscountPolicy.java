package com.selfstudy.springtheory.discount;

import com.selfstudy.springtheory.annotation.mainDiscountPolicy;
import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import org.springframework.stereotype.Component;

@Component
//@Primary // 해당 애너테이션이 붙은 클래스를 가장 우선적으로 주입함.
// @Qualifier 애너테이션이 우선순위는 더 높음 ( 왜? 스프링은 기본적으로 자동보다 수정이 우선순위가 높고, 상세하게 설정하는 것이 우선순위가 높음 )
@mainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	
	private int discountPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		
		if(member.getGrade()==Grade.VIP) {
			
			return price * discountPercent/100;
			
		}
		
		return 0;
	}

}
