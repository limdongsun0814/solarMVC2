package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.Service;

/**
 * Servlet implementation class empInsertServlet
 */
//@WebServlet("/empInsert.do")
public class empInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("들어옴");
		RequestDispatcher rd = request.getRequestDispatcher("/view/empInsert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String 이름=request.getParameter("이름");
		String 이메일=request.getParameter("이메일");
		String 전화번호=request.getParameter("전화번호");
		String 서버_id=request.getParameter("서버_id");
		String 서버_password=request.getParameter("서버_password");
		
		Service service = new Service();
		boolean emailCheck = service.Duplicate_check_service("이메일",이메일);
		boolean phoneCheck = service.Duplicate_check_service("전화번호",전화번호);
		boolean idCheck = service.Duplicate_check_service("서버_ID",서버_id);
		if(emailCheck) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('이메일 중복입니다'); location.href='/project1/empInsert.do'</script>");
			return;
		}
		if(phoneCheck) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('전화 번호 중복입니다'); location.href='/project1/empInsert.do'</script>");
			return;
		}
		if(idCheck) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('아이디 중복입니다'); location.href='/project1/empInsert.do'</script>");
			return;
		}
//		sign_up_service(name_str, email_str,phone_number_str
//				,login_id_str,login_password_str);
		
		boolean signInResult=service.sign_up_service(이름, 이메일, 전화번호, 서버_id, 서버_password);
		if(signInResult) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('"+이름+"님 등록이 완료되었습니다.'); location.href='/project1/index.jsp'</script>");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>alert('모든 값을 입력하세요.'); location.href='/project1/empInsert.do'</script>");
		}
		
	}
}
