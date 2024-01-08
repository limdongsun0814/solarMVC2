package com.shinhan.controller;

import java.util.Map;

import com.shinhan.model.Service;

public class powerPlantInsertController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page = "";

		String powerPlantName = (String) data.get("powerPlantName");
		String powerPlantMax = (String) data.get("powerPlantMax");
		String powerPlantWhere = (String) data.get("powerPlantWhere");
		Service service = new Service();
		boolean result = service.발전소_insert_service(powerPlantName,powerPlantMax,powerPlantWhere);
		if (result) {
			data.put("alert", powerPlantName + "이 등록이 완료되었습니다.");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		} else {// http://localhost:9999
			data.put("alert", powerPlantName + "이 등록이 실패했습니다.");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		}
		return page;
	}
}
