package org.intech.j2ee.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Subject;

import org.intech.ejb.SubjectsEJB;

/**
 * Servlet implementation class JPAServlet
 */
@WebServlet("/JPAServlet")
public class JPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName="IFPWAFCAD")
	EntityManager em;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypedQuery<Subject> query = em.createNamedQuery("Subject.findAll", Subject.class);
		
		List<Subject> subjects = query.getResultList();
		
		for (Subject s : subjects) {
			response.getWriter().println(String.format("%d: %s", s.getSubjectId(), s.getName()));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
