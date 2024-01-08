package com.shinhan.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.Service;

/**
 * Servlet implementation class empfindID
 */
//@WebServlet("/empfindID.do")
public class empfindID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empfindID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:9999/project1/empfindID.do?userName=testuserEmailtestuserPhonetest
		request.setCharacterEncoding("utf-8");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		System.out.println(userEmail+" "+userPhone);
		Service service = new Service();
		String userId=service.find_id_service(userEmail, userPhone);
		if(userId==null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('일치하는 아이디는 없습니다.'); location.href='/project1/'</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('아이디는 "+userId+"입니다.'); location.href='/project1/'</script>");
		}
		//find_id_service
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
