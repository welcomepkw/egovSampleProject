package com.sample.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import com.sample.vo.TSample;

public interface SampleMapper {

	public int insertSample(TSample arg) throws SQLException;
	
	public int updateSample(TSample arg) throws SQLException;
	
	public List<TSample> getSample(TSample arg) throws SQLException;

	@Cacheable(value="sampleCache")
	public List<TSample> cacheSample(@Param("id") int id) throws SQLException; 
}
