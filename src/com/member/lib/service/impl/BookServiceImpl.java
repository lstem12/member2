package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.dao.impl.BookDAOImpl;
import com.member.lib.service.BookService;



public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();
	@Override
	public Map<String, Object> insertBook(Map<String, Object> book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.insertBook(book);
		rMap.put("msg", (result==1)?"도서입력성공":"도서입력실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.updateBook(book);
		rMap.put("msg", (result==1)?"도서수정성공":"도서수정실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteBook(int bNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.deleteBook(bNum);
		rMap.put("msg", "책정보 삭제성공");
		if(result!=1) {
		rMap.put("msg", "책정보 삭제실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> book) {
		return bookDAO.selectBookList(book);
	}

	@Override
	public Map<String, Object> selectBook(int bNum) {
		return bookDAO.selectBook(bNum);
	}

	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		Map<String, Object> map = new HashMap<>();
//		map.put("b_title", "컴퓨터활용능력");
//		map.put("b_author", "견본");
//		map.put("b_desc", "시험볼떄 좋음");
//		System.out.println(bookService.insertBook(map));
		
//		map.put("b_title", "나무");
//		map.put("b_author", "베르베르");
//		map.put("b_desc", "재밌음");
//		map.put("b_num", 25);
//		System.out.println(bookService.updateBook(map));
		
//		List<Map<String, Object>> bookList = bookService.selectBookList(map);
//		for(Map<String, Object> book:bookList) {
//			System.out.println(book);
//		}
		
		//System.out.println(bookService.selectBook(21));
	
		System.out.println(bookService.deleteBook(41));
	}
}
