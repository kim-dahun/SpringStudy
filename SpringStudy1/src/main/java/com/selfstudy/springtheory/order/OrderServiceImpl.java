package com.selfstudy.springtheory.order;

import com.selfstudy.springtheory.discount.DiscountPolicy;
import com.selfstudy.springtheory.discount.FixDiscountPolicy;
import com.selfstudy.springtheory.discount.RateDiscountPolicy;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberRepository;
import com.selfstudy.springtheory.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;

//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {

		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {

		Member member = memberRepository.findById(memberId);

		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
