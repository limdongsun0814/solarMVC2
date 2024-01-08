package com.shinhan.controller;

import java.util.Map;

import com.shinhan.dto.deptDTO;
import com.shinhan.model.Service;

public class deptUpdateController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page="";
		String method = (String)data.get("method");
		Service service = new Service();
		if(method.equalsIgnoreCase("get")) {
			page = "/view/deptUpdate.jsp";
			data.put("deptList", service.get_dept_table_service());
			data.put("redirect", "forword");
		}else {
			deptDTO dept = new deptDTO();
			String deptId = (String)data.get("deptId");
			dept.set부서_id(Integer.parseInt(deptId));
			dept.set부서_이름((String)data.get("deptName"));
			System.out.println(dept);
			boolean result = service.UpdateDept(dept);
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
