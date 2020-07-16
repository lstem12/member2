package com.member.lib.service;

import java.util.List;
import java.util.Map;

public interface LentService {
	Map<String, Object> insertLent(Map<String,Object> lent);
	Map<String, Object> updateLent(Map<String,Object> lent);
	Map<String, Object> deleteLent(int lNum);
	List<Map<String,Object>> selectLentList(Map<String,Object> lent);
	Map<String,Object> selectLent(int lNum);
}
