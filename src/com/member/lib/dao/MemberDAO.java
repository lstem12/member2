package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface MemberDAO {
	int insertMember(Map<String,Object> member);
	int updateMember(Map<String,Object> member);
	int deleteMember(int mNum);
	List<Map<String,Object>> selectMemberList(Map<String,Object> member);
	Map<String,Object> selectMember(int mNum);
}
