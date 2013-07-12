package org.intech.j2ee.servlets;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

/**
 * Base Servlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
          InitialContext context = new InitialContext();
          DataSource dataSource = (DataSource) context.lookup("jdbc/IFPWAFCAD");
          connection = dataSource.getConnection();
        } catch (NamingException e) {
          e.printStackTrace();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return connection;
      }

}
