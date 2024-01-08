package com.shinhan.controller;

import java.util.ArrayList;
import java.util.Map;

import com.shinhan.dto.JobDTO;
import com.shinhan.dto.deptDTO;
import com.shinhan.dto.empDTO;
import com.shinhan.dto.위치_DTO;
import com.shinhan.model.Service;

public class powerPlantListController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		Service service = new Service();
		String page ="";
		
		ArrayList<위치_DTO> powerPlantList = service.get_위치_table_service();
		data.put("powerPlantList", powerPlantList);
		data.put("redirect", "forword");
		page = "/view/powerPlantList.jsp";
		return page;
	}

}
