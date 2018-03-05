package com.sample.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.mapper.SampleMapper;
import com.sample.vo.TSample;

@Service
public class TransactionService {

	
	@Autowired
	private SampleMapper sampleMapper;
	
	/**
	 * 강제 exception 발생시켜 transaction test
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Exception.class, SQLException.class} )
	public int transactionTest(TSample arg) throws Exception{
		int result = sampleMapper.updateSample(arg);
		
		if(true){
			throw new Exception("force exception");
		}
		
		return result;
	}
}
