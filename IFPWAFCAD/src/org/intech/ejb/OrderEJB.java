package org.intech.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.intech.j2ee.beans.Order;

/**
 * Session Bean implementation class SubjectsEJB
 */
@Stateless
@LocalBean
public class OrderEJB {

	@Resource(lookup = "jdbc/IFPWAFCAD")
	DataSource dataSource;

	public void insertOrder(Order order) {

		try (Connection connection = dataSource.getConnection()) {
		    String sql = "INSERT INTO orders (i,j,k,date) VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, order.getI());
			statement.setInt(2, order.getJ());
			statement.setInt(3, order.getK());
			statement.setDate(4, new java.sql.Date(order.getDate().getTime()));
			statement.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
