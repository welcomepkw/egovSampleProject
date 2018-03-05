package com.sample.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.SampleMapper;
import com.sample.vo.TSample;

@Service
public class SampleService {

	@Autowired
	private SampleMapper sampleMapper;
	
	public int insertSample(TSample arg) throws SQLException{
		return sampleMapper.insertSample(arg);
	}
	
	public int updateSample(TSample arg) throws SQLException{
		return sampleMapper.updateSample(arg);
	}
	
	public List<TSample> getSample(TSample arg) throws SQLException{
		return sampleMapper.getSample(arg);
	}
}
