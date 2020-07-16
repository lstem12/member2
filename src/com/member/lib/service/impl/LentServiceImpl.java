package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {
	private LentDAO lentDAO = new LentDAOImpl();

	@Override
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		int result = lentDAO.insertLent(lent);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg", "대여정보 입력완료");
		if(result!=1) {
			rMap.put("msg", "대여정보 입력실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> lent) {
		int result = lentDAO.updateLent(lent);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "대여정보 수정완료");
		if(result!=1) {
			rMap.put("msg", "대여정보 수정실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLent(int lNum) {
		int result = lentDAO.deleteLent(lNum);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg", "대여정보 삭제완료");
		if(result!=1) {
			rMap.put("msg", "대여정보 삭제실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		return lentDAO.selectLentList(lent);
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {
		return lentDAO.selectLent(lNum);
	}
	
	public static void main(String[] args) {
		LentService lentService = new LentServiceImpl();
		Map<String, Object> map = new HashMap<>();
//		List<Map<String, Object>> lentList = lentService.selectLentList(map);
//		for(Map<String, Object> lent:lentList) {
//			System.out.println(lent);
//		}
		
		//System.out.println(lentService.selectLent(44));
		
//		map.put("m_num", 45);
//		map.put("b_num", 26);
//		System.out.println(lentService.insertLent(map));
		
		//System.out.println(lentService.deleteLent(45));
		
		map.put("m_num", 1);
		map.put("b_num", 1);
		map.put("l_num", 1);
		System.out.println(lentService.updateLent(map));
		
	}

}
