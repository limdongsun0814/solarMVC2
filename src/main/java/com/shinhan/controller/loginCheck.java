package com.shinhan.controller;

import java.util.Map;

import com.shinhan.dto.empDTO;
import com.shinhan.model.Service;

public class loginCheck implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		Service service = new Service();
		String id=(String)data.get("id");
		String password =(String) data.get("password");
		String page="";
		System.out.println(id+" "+password);
		boolean loginCheck=service.login_check_service(id, password);
		if(loginCheck) {
			empDTO emp=service.getUser(id);
			data.put("redirect","send");
			data.put("empInfo",emp);
			page = "/project1/home.do";
			
		}else {
			data.put("redirect","forword");
			data.put("alert", "아이디와 비밀번호가 틀려습니다.");
			page="/index.jsp";
		}
		return page;
	}

}
