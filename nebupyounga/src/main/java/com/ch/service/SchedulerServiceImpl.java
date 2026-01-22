package com.ch.service;

import java.util.HashSet;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import com.ch.common.TestJob;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	private Scheduler s = null;

	@Override
	public void startScheduler() throws Exception {
		SchedulerFactory sf = new StdSchedulerFactory();
		s = sf.getScheduler();
		
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class).build();
		CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger()
											.withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?")) 		//2초마다 실행
											.forJob(jobDetail)
											.build();
		Set<Trigger> set1 = new HashSet<>();
		set1.add(trigger);

		s.scheduleJob(jobDetail,set1,false);

	
		s.start();
	
	}

	// Service 부분
	@Override
	public void endScheduler() throws Exception {
	    if (s != null) {
	        s.shutdown(); // 또는 s.destroy(); (Spring 객체인 경우)
	        s = null; 
	    }
	}
}
