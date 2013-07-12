package org.intech.j2ee.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.intech.j2ee.beans.Order;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "OrderQueue", lookup = "OrderQueue")
	private Queue mQueue;

	@Inject
	private JMSContext jmsContext;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		response.setContentType("text/html;charset=UTF-8");
		
		jmsContext.createProducer().send(mQueue, new Order(1234, 12, 50));
	
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
