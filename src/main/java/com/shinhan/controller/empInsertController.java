package com.shinhan.controller;

import java.util.Map;

import com.shinhan.model.Service;

public class empInsertController implements CommonController {
	static String 이름;
	static String 이메일;
	static String 전화번호;
	static String 서버_id;
	static String 서버_password;
	
	@Override
	public String execute(Map<String, Object> data) {
		String page = "";
		String method = (String)data.get("method");
		if(method.equalsIgnoreCase("get")) {
			page = "/view/empInsert.jsp";
			data.put("redirect", "forword");
		}else {
			이름=(String)data.get("이름");
			이메일=(String)data.get("이메일");
			전화번호=(String)data.get("전화번호");
			서버_id=(String)data.get("서버_id");
			서버_password=(String)data.get("서버_password");
			
			Service service = new Service();
			boolean emailCheck = service.Duplicate_check_service("이메일",이메일);
			boolean phoneCheck = service.Duplicate_check_service("전화번호",전화번호);
			boolean idCheck = service.Duplicate_check_service("서버_ID",서버_id);
			if(emailCheck) {
				data.put("alert", "이메일 중복입니다");
				page = "/view/empInsert.jsp";
				data.put("redirect", "forword");
				put(data);
				return page;
			}
			if(phoneCheck) {
				data.put("alert", "전화 번호 중복입니다");
				page = "/view/empInsert.jsp";
				data.put("redirect", "forword");
				put(data);
				return page;
			}
			if(idCheck) {
				data.put("alert", "아이디 중복입니다");
				page = "/view/empInsert.jsp";
				data.put("redirect", "forword");
				put(data);
				return page;
			}
			System.out.println("이름 "+이름+"이메일 "+이메일+"전화번호 "+전화번호+"서버_id "+서버_id+"서버_password "+서버_password);
			boolean signInResult=service.sign_up_service(이름, 이메일, 전화번호, 서버_id, 서버_password);
			if(signInResult) {
				data.put("alert", 이름+"님 등록이 완료되었습니다.");
				page = "/project1/index.do";
				data.put("redirect", "send");
			}else {//http://localhost:9999
				data.put("alert", "모든 값을 입력하세요.");
				page = "/view/empInsert.jsp";
				data.put("redirect", "forword");
				put(data);
			}
		}
		return page;
	}
	private void put(Map<String, Object> data) {
		data.put("이름",이름);
		data.put("이메일",이메일);
		data.put("전화번호",전화번호);
		data.put("서버_id",서버_id);
		data.put("서버_password",서버_password);
	}
}
