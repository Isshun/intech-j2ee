package org.intech.mdb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.intech.MailerService;
import org.intech.ejb.ReportEJB;
import org.intech.j2ee.beans.Report;

@MessageDriven(
	mappedName = "MailQueue",
	activationConfig = {
		@ActivationConfigProperty(
				propertyName = "detinationType",
				propertyValue = "javax.jms.Queue"
				),
		@ActivationConfigProperty(
				propertyName = "detinationName",
				propertyValue = "MailQueue"
				)
	}
)

public class MailListener implements MessageListener {

	MailerService 	mMailService;
	
	@Resource
	private MessageDrivenContext mContext;

    @PostConstruct
    private void Init() {
    	mMailService = new MailerService();
    }
    
	@Override
	public void onMessage(Message message) {
		System.out.println("MailListener: receive message");
		try {
			ObjectMessage obj = (ObjectMessage) message;
			Report report = (Report) obj.getObject();
			sendMail(report.getMessage());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void sendMail(String report) {
		if (mMailService != null) {
    		try {
				mMailService.sendMessage("alexis.lauper@gmail.com", "report", report);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}


}
