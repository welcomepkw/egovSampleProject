package com.sample.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TSample extends Default {

	private Integer id;
	@NotNull(message="필수입력입니다.")
	@Size(min=2, max=10, message="2자이상 10자 이하로 입력하세요.")
	private String text1;
	@NotNull(message="필수입력입니다.")
	@Size(min=2, max=10, message="2자이상 10자 이하로 입력하세요.")
	private String text2;
	private Date createDate;
}
