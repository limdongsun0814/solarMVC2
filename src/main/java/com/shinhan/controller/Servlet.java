package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.empDTO;

/**
 * Servlet implementation class Servlet
 *
 * "/project1/empInsert.do"
 */
@WebServlet("*.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static HashMap<String, String> puths;
	static String 이름;
	static String 이메일;
	static String 전화번호;
	static String 서버_id;
	static String 서버_password;

	public Servlet() {
		puths = new HashMap<String, String>();
		puths.put("직원 등록", "/empInsert.do");
		puths.put("비밀 번호 찾기", "/empfindPassword.do");
		puths.put("아이디 찾기", "/empfindID.do");
//		puths.put("아이디 찾기", "/empfindID.do");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get : 읽기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println(request.getServletPath());
		String receivePath = request.getServletPath();
		HttpSession session = request.getSession();
		String page = "";
		CommonController controller = null;
		String method = request.getMethod();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("method", method);
		// 필수 키 redirect,
		switch (receivePath) {
		case "/powerList.do":
			if(method.equalsIgnoreCase("get")) {
				controller = new powerListController();
				
			}else {			
				data.put("powerId", request.getParameter("powerId"));
				data.put("firstTime", request.getParameter("firstTime"));
				data.put("lastTime", request.getParameter("lastTime"));
				controller = new powerListController();
			}
			break;
		case "/powerPlantUpdate.do":
			if(method.equalsIgnoreCase("get")) {
				controller = new powerPlantUpdateController();
				
			}else {
				data.put("powerPlantId", request.getParameter("powerPlantId"));
				data.put("powerPlantName", request.getParameter("powerPlantName"));
				data.put("powerPlantMax", request.getParameter("powerPlantMax"));
				data.put("powerPlantWhere", request.getParameter("powerPlantWhere"));
				controller = new powerPlantUpdateController();
			}
			break;
		case"/jobUpdata.do":
			if(method.equalsIgnoreCase("get")) {
				controller = new jobUpdateController();
				
			}else {
				data.put("jobId", request.getParameter("jobId"));
				data.put("jobName", request.getParameter("jobName"));
				data.put("jobDetail", request.getParameter("jobDetail"));
				controller = new jobUpdateController();
			}
			break;
		case "/deptUpdata.do":
			if(method.equalsIgnoreCase("get")) {
				controller = new deptUpdateController();
				
			}else {
				data.put("deptId", request.getParameter("deptId"));
				data.put("deptName", request.getParameter("deptName"));
				controller = new deptUpdateController();
			}
			break;
		case "/powerPlantInsert.do":
			data.put("powerPlantName", request.getParameter("powerPlantName"));
			data.put("powerPlantMax", request.getParameter("powerPlantMax"));
			data.put("powerPlantWhere", request.getParameter("powerPlantWhere"));
			controller = new powerPlantInsertController();
			break;
		case "/jobInsert.do":
			data.put("jobName", request.getParameter("jobName"));
			data.put("jobDetail", request.getParameter("jobDetail"));
			controller = new jobInsertController();
			break;
		case "/deptInsert.do":
			data.put("deptName", request.getParameter("deptName"));
			controller = new deptInsertController();
			break;
		case "/powerPlantList.do":
			controller = new powerPlantListController();
			break;
		case "/jobList.do":
			controller = new jobListController();
			break;
		case "/deptList.do":
			controller = new deptListController();
			break;
		case "/empList.do":
			System.out.println("empList.do");
			controller = new empListController(); 
			break;
		case "/index.do":
			controller = new IndexController();
			break;
		case "/loginCheck.do":
			data.put("id", request.getParameter("id"));
			data.put("password", request.getParameter("password"));
			controller = new loginCheck();
			break;
		case "/empInsert.do":
			System.out.println("test");
			if (method.equalsIgnoreCase("get")) {
				controller = new empInsertController();
				String alert = (String) session.getAttribute("alert");
				request.setAttribute("alert", alert);
				session.removeAttribute("alert");
				data.put(method, data);
			} else {
				put(data, request);
				System.out.println("post");
				controller = new empInsertController();
				System.out.println("test");
			}
			break;
		case "/empfindPassword.do":
			data.put("userId", request.getParameter("userId"));
			data.put("userEmail", request.getParameter("userEmail"));
			data.put("userPhone", request.getParameter("userPhone"));
			controller = new empFindPasswordController();
			break;
		case "/empfindID.do":
			data.put("userEmail", request.getParameter("userEmail"));
			data.put("userPhone", request.getParameter("userPhone"));
			controller = new empFindIdController();
			break;
		case "/home.do":
			data.put("empInfo", session.getAttribute("empInfo"));
			session.removeAttribute("alert");
			controller = new IndexController();
			break;
		case "/logout.do":
			session.removeAttribute("empInfo");
			controller = new logoutController();
			break;
		case "/correction.do":
			if (method.equalsIgnoreCase("post")) {
				empDTO emp = (empDTO) session.getAttribute("empInfo");
				updataEmp(emp,request);
				data.put("emp", emp);
			}
			controller = new correctionController();
			break;

		}
		System.out.println(data.keySet() + "a");
		page = controller.execute(data);
		System.out.println(data.keySet());

		String redirect = (String) data.get("redirect");
		System.out.println(data.keySet());
		if (redirect.equals("forword")) {
			for (String key : data.keySet()) {
				request.setAttribute(key, data.get(key));
			}
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if (redirect.equals("send")) {
			for (String key : data.keySet()) {
				session.setAttribute(key, data.get(key));
			}
			response.sendRedirect(page);
		}
	}

	private void updataEmp(empDTO emp, HttpServletRequest request) {
		System.out.println("updata"+emp);
		System.out.println("request.getParameter(\"이름\")"+request.getParameter("이름"));
		emp.set이름(request.getParameter("이름"));
		emp.set이메일(request.getParameter("이메일"));
		emp.set전화번호(request.getParameter("전화번호"));
		emp.set부서_이름(request.getParameter("부서_ID"));
		emp.setLogin_ID(request.getParameter("아이디"));
		emp.setLogin_password(request.getParameter("비밀번호"));
		emp.set직무_이름(request.getParameter("직무ID"));
		emp.set퇴직유무(request.getParameter("퇴직유무"));
		System.out.println("updatasad"+emp);
	}

	private void put(Map<String, Object> data, HttpServletRequest request) {
		이름 = request.getParameter("이름");
		이메일 = request.getParameter("이메일");
		전화번호 = request.getParameter("전화번호");
		서버_id = request.getParameter("서버_id");
		서버_password = request.getParameter("서버_password");
		data.put("이름", 이름);
		data.put("이메일", 이메일);
		data.put("전화번호", 전화번호);
		data.put("서버_id", 서버_id);
		data.put("서버_password", 서버_password);
	}

}
