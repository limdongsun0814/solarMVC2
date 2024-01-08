package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//부서 테이블 DTO 클래스 입니다. 롬복이 없는 경우 getter, setter를 꼭 설정해주세요
public class deptDTO {
	private int 부서_id;
	private String 부서_이름;
	
}
