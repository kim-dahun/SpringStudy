package com.selfstudy.springtheory;

import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {

		
		AppConfig app = new AppConfig();
		
		MemberService memberService = app.memberService();
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		System.out.println("Member name = " + member.getName());
		System.out.println("find Member name = " + findMember.getName());
		
		// 인텔리제이 설치 완료 커밋되는지 체크
	}

}
