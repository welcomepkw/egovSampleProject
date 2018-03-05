package com.sample.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.SampleMapper;
import com.sample.vo.TSample;

@Service
public class CacheService {

	@Autowired
	private SampleMapper sampleMapper;
	
	public List<TSample> cacheSample(int id) throws SQLException{
		return sampleMapper.cacheSample(id);
	}
}
