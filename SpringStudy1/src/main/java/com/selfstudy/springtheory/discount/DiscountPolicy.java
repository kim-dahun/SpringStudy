package com.selfstudy.springtheory.discount;

import com.selfstudy.springtheory.member.Member;

public interface DiscountPolicy {

	
	/**
	 * 
	 * @param member 회원 등급 조회에 필요한 회원 객체
	 * @param price 할인 전 가격
	 * @return 할인 대상 금액
	 */
	int discount(Member member, int price);
	
}
