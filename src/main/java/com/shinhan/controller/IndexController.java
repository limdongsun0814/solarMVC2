package com.shinhan.controller;

import java.util.Map;

public class IndexController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		
		String page = "";
		if(data.get("empInfo")==null) {
			data.put("redirect", "send");
			page="/project1/index.jsp";
		}else {
			data.put("redirect", "forword");
			page="/view/home.jsp";
			
		}
		return page;
	}

}
