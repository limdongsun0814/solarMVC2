package com.shinhan.controller;

import java.util.Map;
import com.shinhan.model.Service;

public class empFindPasswordController implements CommonController {
	
	@Override
	public String execute(Map<String, Object> data) {
		String userId=(String)data.get("userId");
		String userEmail=(String)data.get("userEmail");
		String userPhone=(String)data.get("userPhone");
		Service service = new Service();
		String userPassword=service.find_password_service(userEmail, userPhone, userId);
		String page = "";
		if(userPassword==null) {
			data.put("alert", "일치하는 비밀 번호는 없습니다.");
			data.put("redirect", "forword");
			page = "/index.jsp";
		}else {
			data.put("alert", "비밀 번호는 "+userPassword+"입니다.");
			data.put("redirect", "forword");
			page = "/index.jsp";
		}
		return page;
	}
}
