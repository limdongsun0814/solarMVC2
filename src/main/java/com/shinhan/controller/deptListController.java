package com.shinhan.controller;

import java.util.ArrayList;
import java.util.Map;

import com.shinhan.dto.deptDTO;
import com.shinhan.dto.empDTO;
import com.shinhan.model.Service;

public class deptListController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		Service service = new Service();
		String page ="";
		
		ArrayList<deptDTO> deptList = service.get_dept_table_service();
		data.put("deptList", deptList);
		data.put("redirect", "forword");
		page = "/view/deptList.jsp";
		return page;
	}

}
