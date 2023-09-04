package com.selfstudy.springtheory;

import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import com.selfstudy.springtheory.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppConfig app = new AppConfig();
		
		MemberService memberService = app.memberService();
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		System.out.println("Member name = " + member.getName());
		System.out.println("find Member name = " + findMember.getName());
		
		
	}

}
