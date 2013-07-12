package org.intech.j2ee.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.intech.ejb.SubjectsEJB;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Welcome")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	protected SubjectsEJB subjectsEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
	    
	    request.setAttribute("subjects", subjectsEJB.getAll() );
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
