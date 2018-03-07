package com.sample.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Default {

	public static final String QUERY_TYPE_CNT = "cnt";
	public static final String QUERY_TYPE_NORMAL = "normal";

	// @jsonIgnore 사용시 @responsebody 에 의해 자동 json 변경 할 경우 json 값에 포함하지 않는다.
	@JsonIgnore
	private String queryType;
}
