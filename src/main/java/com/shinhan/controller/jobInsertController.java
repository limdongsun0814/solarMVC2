package com.shinhan.controller;

import java.util.Map;

import com.shinhan.model.Service;

public class jobInsertController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page = "";

		String jobName = (String) data.get("jobName");
		String jobDetail = (String) data.get("jobDetail");
		Service service = new Service();
		boolean result = service.job_insert_service(jobName,jobDetail);
		if (result) {
			data.put("alert", jobName + "이 등록이 완료되었습니다.");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		} else {// http://localhost:9999
			data.put("alert",  jobName + "이 등록이 실패했습니다.");
			page = "/view/home.jsp";
			data.put("redirect", "forword");
		}
		return page;
	}
}
