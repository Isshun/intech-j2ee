package fr.intech.ejb;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 * Session Bean implementation class SingletonEJB
 */
@Singleton
@LocalBean
//@Startup
public class SystemReportManager {

	@Resource
	TimerService mService;
	
    @PostConstruct
    private void Init() {
    	if (mService.getTimers() != null) {
    		for (Timer timer: mService.getTimers()) {
    			if (timer.getInfo() != null) {
        			if (timer.getInfo().equals("dummyTimer2.1") || timer.getInfo().equals("dummyTimer2.2")) {
        				timer.cancel();
        			}
    			}
    		}
    	}
    	
    	mService.createCalendarTimer(
    			new ScheduleExpression().hour("*").minute("*").second("*/2"),
    			new TimerConfig("dummyTimer2.1", true));
    	mService.createCalendarTimer(
    			new ScheduleExpression().hour("*").minute("*").second("*/3"),
    			new TimerConfig("dummyTimer2.2", true));
    }
    
    //@Timeout
    public void hit(Timer timer) {
    	if (timer.getInfo().equals("dummyTimer2.1")) {
    		System.out.println(timer.toString());
    		System.out.println(getClass().getName() + ": " + new Date());
    	}
    }
    
}
