package com.shinhan.controller;

import java.util.Map;

import com.shinhan.model.Service;

public class deptInsertController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page = "";

		String 부서이름 = (String) data.get("deptName");
		System.out.println("부서이름"+부서이름);
		Service service = new Service();
		boolean result = service.dept_insert_service(부서이름);
		if (result) {
			data.put("alert",  부서이름 + "이 등록이 완료되었습니다");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		} else {// http://localhost:9999
			data.put("alert",  부서이름 + "이 등록이 실패했습니다.");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		}
		return page;
	}
}
