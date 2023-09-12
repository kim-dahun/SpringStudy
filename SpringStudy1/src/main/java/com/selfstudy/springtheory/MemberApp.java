package com.selfstudy.springtheory;

import com.selfstudy.springtheory.member.Grade;
import com.selfstudy.springtheory.member.Member;
import com.selfstudy.springtheory.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

	public static void main(String[] args) {

		
//		AppConfig app = new AppConfig();
		
//		MemberService memberService = app.memberService();

		// 컨테이너에 집어 넣은 Bean 들을 모두 관리하도록
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		Member member = new Member(1L,"memberA",Grade.VIP);
		
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		System.out.println("Member name = " + member.getName());
		System.out.println("find Member name = " + findMember.getName());
		
		// 인텔리제이 설치 완료 커밋되는지 체크
	}

}
