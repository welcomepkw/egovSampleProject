package com.sample.vo;

import lombok.Data;

@Data
public class Default {

	public static final String QUERY_TYPE_CNT = "cnt";
	public static final String QUERY_TYPE_NORMAL = "normal";
	
	private String queryType;
}
