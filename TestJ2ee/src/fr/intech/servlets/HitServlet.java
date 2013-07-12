package fr.intech.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.intech.ejb.SingletonEJB;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/HitServlet")
public class HitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	protected SingletonEJB singletonEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		singletonEJB.hit();
		response.getWriter().println(singletonEJB.getHits());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
