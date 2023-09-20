package com.selfstudy.springtheory.discount;

import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000;
	
	@Override
	public int discount(Member member, int price) {
		if(member.getGrade()==Grade.VIP) {
			
			return discountFixAmount;
			
		}
		
		return 0;
	}

}
