package com.shinhan.controller;

import java.util.ArrayList;
import java.util.Map;

import com.shinhan.dto.empDTO;
import com.shinhan.model.Service;

public class empListController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		Service service = new Service();
		String page ="";
		ArrayList<empDTO> empList =service.get_emp_table_service();
		data.put("empList", empList);
		data.put("redirect", "forword");
		page = "/view/empList.jsp";
		return page;
	}

}
