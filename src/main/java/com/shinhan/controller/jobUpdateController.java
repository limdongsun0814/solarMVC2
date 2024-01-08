package com.shinhan.controller;

import java.util.Map;

import com.shinhan.dto.JobDTO;
import com.shinhan.dto.deptDTO;
import com.shinhan.model.Service;

public class jobUpdateController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page="";
		String method = (String)data.get("method");
		Service service = new Service();
		System.out.println("=============");
		if(method.equalsIgnoreCase("get")) {
			page = "/view/jobUpdate.jsp";
			data.put("jobList", service.get_job_table_service());
			data.put("redirect", "forword");
		}else {
			JobDTO job = new JobDTO();
			String jobId = (String)data.get("jobId");
			job.set직무_ID((Integer.parseInt(jobId)));
			job.set직무_이름((String)data.get("jobName"));
			job.set직무_내용((String)data.get("jobDetail"));
			System.out.println(job);
			boolean result = service.UpdateJob(job);
			if(result) {
				data.put("alert", "수정되었습니다.");
			}else {
				data.put("alert", "수정에 실패했습니다.");
			}
			page = "/home.do";
			data.put("redirect", "forword");
		}
		return page;
	}

}
