package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();
	@Override
	public Map<String, Object> insertMember(Map<String, Object> member) {
		int result = memberDAO.insertMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버등록완료");
		if(result!=1) {
			rMap.put("msg", "멤버등록 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateMember(Map<String, Object> member) {
		int result = memberDAO.updateMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "업데이트완료");
		if(result!=1) {
			rMap.put("msg", "업데이트 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMember(int mNum) {
		int result = memberDAO.deleteMember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버삭제완료");
		if(result!=1) {
			rMap.put("msg", "멤버삭제 오류!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		return memberDAO.selectMemberList(member);
	}

	@Override
	public Map<String, Object> selectMember(int mNum) {
		return memberDAO.selectMember(mNum);
	}
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
//		Map<String,Object> rMap = memberService.deleteMember(37);
//		System.out.println(rMap);
		
		Map<String, Object> member = new HashMap<>();
		member.put("m_name", "이름바뀜1");
		member.put("m_id", "change");
		member.put("m_pwd", "9999");
		member.put("m_num", 44);
		Map<String, Object> rMap = memberService.updateMember(member);
		System.out.println(rMap);
		List<Map<String,Object>> memberList = memberService.selectMemberList(member);
		for(Map<String,Object> mem:memberList) {
			System.out.println(mem);
		}
//		List<Map<String,Object>> memberList = memberService.selectMemberList(member);
//		for(Map<String,Object> mem:memberList) {
//			System.out.println(mem);
//		}
		
		//System.out.println(memberService.selectMember(44));
				
	}

}
