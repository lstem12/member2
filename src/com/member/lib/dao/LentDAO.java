package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface LentDAO {
	int insertLent(Map<String,Object> lent);
	int updateLent(Map<String,Object> lent);
	int deleteLent(int lNum);
	List<Map<String,Object>> selectLentList(Map<String,Object> lent);
	Map<String,Object> selectLent(int lNum);
}
