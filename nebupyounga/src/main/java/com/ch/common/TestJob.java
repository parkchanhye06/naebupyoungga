package com.ch.common;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.ch.dao.memberDao;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            // 1. Spring 컨텍스트 가져오기
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            
            // [수정 포인트] 서버 종료 시 ctx가 null이 될 수 있으므로 방어 코드 추가
            if (ctx == null) {
                return; // 컨텍스트가 닫혔다면 작업을 수행하지 않고 종료
            }
            
            // 2. DAO 가져오기
            memberDao mDao = (memberDao) ctx.getBean("memberDaoImpl");

            // [수정 포인트] mDao가 정상적으로 로드되었는지 확인
            if (mDao != null) {
                // 3. 실행 및 결과 출력
                int count = mDao.scheduler(); 
                Date now = new Date();

                System.out.println("Job이 실행됨 : " + now + " / " + count + "명에게 포인트 부여(1점).");
            }
            
        } catch (Exception e) {
            // 서버가 종료되는 과정에서 발생하는 빈(Bean) 조회 에러는 무시하거나 간략하게 출력
            System.err.println("<<< 스케줄러 실행 중 오류 발생 (서버 종료 중일 수 있음) >>>");
            // e.printStackTrace(); // 너무 많은 로그 방지를 위해 필요한 경우에만 주석 해제
        }
    }
}