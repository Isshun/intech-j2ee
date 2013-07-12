package fr.intech.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.intech.ejb.VolumeEJB;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/VolumeServlet")
public class VolumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	protected VolumeEJB volumeEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/volume.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("radius") == null)
			throw new IllegalArgumentException();

		double r = Double.parseDouble(request.getParameter("radius"));
		
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/volume.jsp");
		request.setAttribute("volume", volumeEJB.fromSphere(r) );
		request.setAttribute("radius", r );
	    rd.forward(request, response);
	}

}
