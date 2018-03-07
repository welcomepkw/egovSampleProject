package com.sample.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.common.exception.BadReqeustException;
import com.sample.service.SampleService;
import com.sample.vo.TSample;

/**
 * CRUD sample controller
 * @author v.kwpark
 *
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

	Logger logger = LogManager.getLogger(SampleController.class); 
	
	@Autowired
	private SampleService sampleService;
	
	/**
	 * get data
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(
				Model model
			) throws SQLException{
		
		// get data from DB
		List<TSample> datas = sampleService.getSample(null);
		
		// send data to view
		model.addAttribute("datas", datas);
		
		return "sample/list";
	}
	
	/**
	 * create page
	 * @return
	 */
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public String create(){
		return "sample/create";
	}
	
	/**
	 * create process
	 * @param tSample
	 * @return
	 * @throws SQLException 
	 * @throws BadReqeustException 
	 */
	@RequestMapping(value="/createPS.do", method=RequestMethod.POST)
	public String createPS(
				@ModelAttribute @Valid TSample tSample
				, BindingResult bindingResult
			) throws SQLException, BadReqeustException{
		
		if(bindingResult.hasErrors()){
			// server side validation check
			for(ObjectError error : bindingResult.getAllErrors()){
				logger.debug(error.getDefaultMessage());
			}
			
			throw new BadReqeustException("bad request");
		}
		
		// set create date
		tSample.setCreateDate(new Date());
		
		// if insert success then resultCnt is 1
		int resultCnt = sampleService.insertSample(tSample);
		if(resultCnt < 1){
			logger.debug("insert error");
			throw new SQLException("insert result cnt error");
		}
		
		// mybatis 에서 데이터 입력시 시퀀스 조회 하여 id 생성 후 parameter 로 던진 tSample VO 의 id 컬럼에 셋함. return 받지 않더라도 사용 가능
		int newSeqId = tSample.getId();
		logger.debug(newSeqId);
		
		// redirect to list
		return "redirect:/sample/list.do";
		
	}
	
	/**
	 * update page
	 * @param tSample
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String update(
				@ModelAttribute TSample tSample
				, Model model
			) throws Exception{
		
		// id validate
		if(tSample.getId() == null){
			throw new Exception("id empty");
		}
		
		// get data
		List<TSample> datas = sampleService.getSample(tSample);
		
		// data size check
		if(datas == null || datas.size() <= 0){
			throw new NoSuchElementException("emtpy data");
		}
		
		
		model.addAttribute("data", datas.get(0));
		return "sample/update";
	}
	
	@RequestMapping(value="/updatePS.do", method=RequestMethod.POST)
	public String updatePS(
				@ModelAttribute @Valid TSample tSample
				, BindingResult bindingResult
			) throws SQLException, BadReqeustException{
		
		if(bindingResult.hasErrors()){
			// server side validation check
			for(ObjectError error : bindingResult.getAllErrors()){
				logger.debug(error.getDefaultMessage());
			}
			
			throw new BadReqeustException("bad request");
		}
		
		// if update success then resultCnt is update row count numbers
		int resultCnt = sampleService.updateSample(tSample);
		if(resultCnt < 1){
			logger.debug("update error");
			throw new SQLException("update result cnt error");
		}
		
		
		// redirect to list
		return "redirect:/sample/list.do";
	}
}
