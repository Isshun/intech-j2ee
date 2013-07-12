package org.intech.j2ee.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.intech.ejb.CounselorsEJB;
import org.intech.ejb.StatsEJB;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	protected CounselorsEJB mCounselors;
	
	@EJB
	protected StatsEJB mStats;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("subject_id") == null)
			throw new IllegalArgumentException();

		int id = Integer.parseInt(request.getParameter("subject_id"));

		mStats.add(id);
		
	  	request.setAttribute("counselorDetails", mCounselors.get(id));

	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/response.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
