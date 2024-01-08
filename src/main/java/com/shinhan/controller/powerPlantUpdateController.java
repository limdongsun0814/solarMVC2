package com.shinhan.controller;

import java.util.Map;

import com.shinhan.dto.deptDTO;
import com.shinhan.dto.위치_DTO;
import com.shinhan.model.Service;

public class powerPlantUpdateController implements CommonController {

	@Override
	public String execute(Map<String, Object> data) {
		String page="";
		String method = (String)data.get("method");
		Service service = new Service();
		if(method.equalsIgnoreCase("get")) {
			//powerPlantUpdate.jsp
			page = "/view/powerPlantUpdate.jsp";
			data.put("powerPlant", service.get_위치_table_service());
			data.put("redirect", "forword");
		}else {
			위치_DTO powerPlant = new 위치_DTO();
			String powerPlantId = (String)data.get("powerPlantId");
			String max_str =(String) data.get("powerPlantMax");
			powerPlant.set발전소_ID(Integer.parseInt(powerPlantId));
			powerPlant.set건물_이름((String)data.get("powerPlantName"));
			powerPlant.set주소((String)data.get("powerPlantWhere"));
			powerPlant.set최대_발전량(Integer.parseInt(max_str));
			System.out.println(powerPlant);
			boolean result = service.UpdatepowerPlant(powerPlant);
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
