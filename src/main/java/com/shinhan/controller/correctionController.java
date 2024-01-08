package com.shinhan.controller;

import java.util.Map;

import com.shinhan.dto.empDTO;
import com.shinhan.model.Service;

public class correctionController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page= "";
		String method = (String)data.get("method");
		if(method.equalsIgnoreCase("get")) {
			page = "/view/empDetail.jsp";
			data.put("redirect", "forword");
		}else {
			data.put("redirect", "forword");
			Service service = new Service();
			empDTO emp = (empDTO)data.get("emp");
			System.out.println(emp);
			boolean result = service.UpdateEmp(emp);
			if(result) {
				data.put("alert", "개인 정보 수정이 완료되었습니다.");
				page="/home.do";
			}else {
				data.put("alert", "개인 정보 수정이 실패했습니다.");
				page="/view/empDetail.jsp";
			}
		}
		return page;
		
	}
	
}
