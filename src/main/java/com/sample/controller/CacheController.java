package com.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.service.CacheService;
import com.sample.vo.TSample;

@Controller
@RequestMapping("/cache")
public class CacheController {

	@Autowired 
	private CacheService cacheService;
	
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public @ResponseBody List<TSample> test(
				@ModelAttribute TSample tSample
				, HttpServletResponse response
			) throws SQLException, IOException{
		
		List<TSample> datas = cacheService.cacheSample(tSample.getId());
		
		return datas;
		
	}
}
