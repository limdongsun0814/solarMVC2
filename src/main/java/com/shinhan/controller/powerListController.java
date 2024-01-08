package com.shinhan.controller;

import java.util.ArrayList;
import java.util.Map;

import com.shinhan.dto.deptDTO;
import com.shinhan.dto.발전DTO;
import com.shinhan.dto.위치_DTO;
import com.shinhan.model.Service;

public class powerListController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page="";
		String method = (String)data.get("method");
		Service service = new Service();
		if(method.equalsIgnoreCase("get")) {
			//powerPlantUpdate.jsp
			page = "/view/powerList.jsp";
			data.put("redirect", "forword");
		}else {
			String powerId = (String)data.get("powerId");
			String firstTime = (String)data.get("firstTime");
			String lastTime = (String)data.get("lastTime");
			ArrayList<발전DTO> powerList = service.get_발전_table_service(powerId, firstTime, lastTime);
			data.put("powerList", powerList);
			page = "/view/powerList.jsp";
			data.put("redirect", "forword");
		}
		return page;
	}

}
