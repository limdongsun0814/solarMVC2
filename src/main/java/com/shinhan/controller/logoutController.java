package com.shinhan.controller;

import java.util.Map;

public class logoutController implements CommonController{

	@Override
	public String execute(Map<String, Object> data) {
		String page = "/project1/index.jsp";
		data.put("alert", "로그아웃되었습니다");
		data.put("redirect", "send");
		return page;
	}
}
