package com.shinhan.controller;

import java.util.Map;
import com.shinhan.model.Service;

public class empFindIdController implements CommonController {
	
	@Override
	public String execute(Map<String, Object> data) {
		String userEmail=(String)data.get("userEmail");
		String userPhone=(String)data.get("userPhone");
		Service service = new Service();
		String userId=service.find_id_service(userEmail, userPhone);
		String page = "";
		if(userId==null) {
//			data.put("alert", "<script>alert('일치하는 아이디는 없습니다.');</script>");
			data.put("alert", "일치하는 아이디는 없습니다.");
			data.put("redirect", "forword");
			page = "/index.jsp";
		}else {
//			data.put("alert", "<script>alert('아이디는"+userId+" 입니다.');</script>");
			data.put("alert", "아이디는"+userId+" 입니다.");
			data.put("redirect", "forword");
			page = "/index.jsp";
		}
		return page;
	}

}
