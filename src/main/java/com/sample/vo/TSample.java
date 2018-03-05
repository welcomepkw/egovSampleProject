package com.sample.vo;

import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TSample extends Default {

	private Integer id;
	@Size(min=2, max=10, message="2자이상 10자 이하로 입력하세요.")
	private String text1;
	@Size(min=2, max=10, message="2자이상 10자 이하로 입력하세요.")
	private String text2;
	private Date createDate;
}
