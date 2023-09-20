package com.selfstudy.springtheory.Member;

import com.selfstudy.springtheory.AppConfig;
import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

	

	MemberService memberService;


	@BeforeEach
	public void beforeEach() {
		
		AppConfig app = new AppConfig();
		this.memberService = app.memberService();
	}
			
	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		// when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		// then
		Assertions.assertThat(member).isEqualTo(findMember);
		
	}
	
}
