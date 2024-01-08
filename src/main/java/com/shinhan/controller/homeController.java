package com.shinhan.controller;

import java.util.Map;

public class homeController implements CommonController{

	@Override
	public String execute(Map<String, Object> data) {
		String page="/view/home.jsp";
		data.put("redirect","forword");
		
		return page;
	}

}
