package com.shinhan.controller;

import java.util.ArrayList;
import java.util.Map;

import com.shinhan.dto.JobDTO;
import com.shinhan.dto.deptDTO;
import com.shinhan.dto.empDTO;
import com.shinhan.model.Service;

public class jobListController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		Service service = new Service();
		String page ="";
		
		ArrayList<JobDTO> JobList = service.get_job_table_service();
		data.put("jobList", JobList);
		data.put("redirect", "forword");
		page = "/view/jobList.jsp";
		return page;
	}

}
