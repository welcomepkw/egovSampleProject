package com.sample.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 스케줄러 테스트 서비스
 * @author v.kwpark
 *
 */
@Service
public class SchedulerService {

	Logger logger = LogManager.getLogger(SchedulerService.class);
	
	/**
	 * @scheduled 는 cron, fixedDelay, fixedRate 사용가능
	 * cron : crontab과 동일
	 * fixedDelay : 이전에 실행된 Task의 종료시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.(밀리세컨드 단위)
	 * fixedRate : 이전에 실행된 Task의 시작시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.(밀리세컨드 단위)
	 * 
	 * 기본 thread-pool 은 1개이다. 추가 설정이 필요할 경우 context-scheduler.xml 파일 수정.
	 **/
	@Scheduled(cron="*/30 * * * * *") 
	public void scheduleTest(){
		logger.debug("********** scheduleTest start **********");
		
		logger.debug("********** scheduleTest end **********");
	}
}
