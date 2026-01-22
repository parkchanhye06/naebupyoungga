package com.ch.service;

public interface SchedulerService {
	void startScheduler () throws Exception;  //스케쥴러 시작
	void endScheduler() throws Exception; 	//스케쥴러 종료
}
