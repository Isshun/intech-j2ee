package org.intech.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.intech.ejb.OrderEJB;
import org.intech.j2ee.beans.Order;

@MessageDriven(
	mappedName = "OrderQueue",
	activationConfig = {
		@ActivationConfigProperty(
				propertyName = "detinationType",
				propertyValue = "javax.jms.Queue"
				),
		@ActivationConfigProperty(
				propertyName = "detinationName",
				propertyValue = "OrderQueue"
				)
	}
)

public class OrderListener implements MessageListener {

	@EJB
	private OrderEJB mOrderEJB;
	
	@Resource
	private MessageDrivenContext mContext;
	
	@Override
	public void onMessage(Message message) {
		try {
			ObjectMessage obj = (ObjectMessage) message;
			Order order = (Order) obj.getObject();
			processOrder(order);
		} catch (JMSException e) {
		}
	}

	private void processOrder(Order order) {
		
		System.out.println(String.format("Order: %d %d %d", order.getI(), order.getJ(), order.getK()));
		mOrderEJB.insertOrder(order);
	}

}
