package com.sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.service.SampleService;
import com.sample.service.TransactionService;
import com.sample.vo.TSample;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * transaction test
	 * @param tSample
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> test(
				@ModelAttribute TSample tSample
				, HttpServletResponse response
			) throws SQLException, IOException {
		
		try {
			transactionService.transactionTest(tSample);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<TSample> datas = sampleService.getSample(tSample);
		
		Map<String, Object> result = new HashMap<>();
		result.put("paramData", tSample);
		result.put("resultData", datas.get(0));
		
		return result;
	}
}
