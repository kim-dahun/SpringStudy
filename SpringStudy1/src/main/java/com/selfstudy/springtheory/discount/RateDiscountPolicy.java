package com.selfstudy.springtheory.discount;

import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;

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
