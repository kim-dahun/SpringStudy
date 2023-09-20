package com.selfstudy.springtheory.order;

import com.selfstudy.springtheory.discount.DiscountPolicy;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


	private final MemberRepository memberRepository; // 여러 개의 하위 클래스가 존재할 때 원하는 객체가 있는 Bean의 이름(별도 설정하지 않았다면 Bean에 등록한 메서드 혹은 필드 변수명)을 지정하게 되면 해당 클래스를 주입함.


	//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//	@Qualifier("mainDiscountPolicy") // 여러 하위 클래스가 담긴 Bean 중 해당 이름으로 지정된 빈을 주입함.
	private final DiscountPolicy discountPolicy;



//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

//	@Autowired // 일반 메서드 주입
//	public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//
//	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {

		Member member = memberRepository.findById(memberId);

		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
