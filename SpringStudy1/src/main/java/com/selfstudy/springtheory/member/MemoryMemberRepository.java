package com.selfstudy.springtheory.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	
	
	@Override
	public Member findById(long memberId) {
		// TODO Auto-generated method stub
		return store.get(memberId);
	}
	
	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		store.put(member.getId(), member);
	}
	
}
