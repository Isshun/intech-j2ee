package org.intech.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.intech.j2ee.beans.Order;
import org.intech.j2ee.beans.Report;

/**
 * Session Bean implementation class SingletonEJB
 */
@Singleton
@LocalBean
//@Startup
public class SystemReportManager {

	@Resource
	TimerService 	mTimerService;
	
	@Resource(name = "MailQueue", lookup = "MailQueue")
	private Queue mQueue;

	@Inject
	private JMSContext jmsContext;
	
	@EJB
	protected StatsEJB mStats;
	
	@EJB
	ReportEJB mReportEJB;
	
    @PostConstruct
    private void Init() {
    	if (mTimerService.getTimers() != null) {
    		for (Timer timer: mTimerService.getTimers()) {
    			if (timer.getInfo() != null) {
        			if (timer.getInfo().equals("EmailTimer")) {
        				timer.cancel();
        			}
    			}
    		}
    	}
    	
    	mTimerService.createCalendarTimer(
    			new ScheduleExpression().hour("*").minute("*/1").second("0"),
    			new TimerConfig("EmailTimer", true));
    }
    
    @Timeout
    public void hit(Timer timer) {
    	if (timer.getInfo().equals("EmailTimer")) {
    		System.out.println("Send report");
    		
    		List<Order> orders = mReportEJB.getOrders();
    		
    		StringBuilder sb = new StringBuilder();
    		for (Order order : orders) {
				sb.append(String.format("Order: %d, %d, %d", order.getI(), order.getJ(), order.getK()));
			}
    		
    		jmsContext.createProducer().send(mQueue, new Report(sb.toString()));
    	}
    }
    
}
