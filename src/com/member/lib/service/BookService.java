package com.member.lib.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	Map<String, Object> insertBook(Map<String,Object> book);
	Map<String, Object> updateBook(Map<String,Object> book);
	Map<String, Object> deleteBook(int bNum);
	List<Map<String,Object>> selectBookList(Map<String,Object> book);
	Map<String,Object> selectBook(int bNum);
}
