package com.member.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.BookService;
import com.member.lib.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();

	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(str);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String str = "";
		if ("/book/list".equals(uri)) {
			List<Map<String, Object>> bookList = bookService.selectBookList(null);
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-list");
			rd.forward(request, response);
			return;
		} else if ("/book/view".equals(uri)) {
			String b_num = request.getParameter("b_num");
			if (b_num == null || "".equals(b_num.trim())) {
				throw new ServletException("나가");
			}
			int bNum = Integer.parseInt(b_num);
			Map<String, Object> book = bookService.selectBook(bNum);
			request.setAttribute("book", book);
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-view");
			rd.forward(request, response);
			return;
		} else {
			str = "잘못들어오셨습니다.";
		}
		doProcess(response, str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if ("/book/insert".equals(uri)) {
			String bTitle = request.getParameter("b_title");
			String bAuthor = request.getParameter("b_author");
			String bDesc = request.getParameter("b_desc");
			Map<String, Object> book = new HashMap<>();
			book.put("b_title", bTitle);
			book.put("b_author", bAuthor);
			book.put("b_desc", bDesc);
			Map<String, Object> rMap = bookService.insertBook(book);
			doProcess(response, rMap.toString());
		}else if ("/book/update".equals(uri)) {
			String bTitle = request.getParameter("b_title");
			String bAuthor = request.getParameter("b_author");
			String bDesc = request.getParameter("b_desc");
			String b_num = request.getParameter("b_num");
			int bNum = Integer.parseInt(b_num);
			Map<String, Object> book = new HashMap<>();
			book.put("b_title", bTitle);
			book.put("b_author", bAuthor);
			book.put("b_desc", bDesc);
			book.put("b_num", bNum);
			Map<String, Object> rMap = bookService.updateBook(book);
			doProcess(response, rMap.toString());
		} else if ("/book/delete".equals(uri)) {
			int bNum = Integer.parseInt(request.getParameter("b_num"));
			doProcess(response, bookService.deleteBook(bNum).toString());
		}

	}

}
