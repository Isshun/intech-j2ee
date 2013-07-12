package org.intech.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class ReportEJB {

	@Resource(lookup = "jdbc/IFPWAFCAD")
	DataSource dataSource;

	public List<Order> getOrders() {

		List<Order> orders = new ArrayList<Order>();
		
		try (Connection connection = dataSource.getConnection()) {
		    String sql = "SELECT i, j, k, date FROM orders";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int i = rs.getInt("i");
				int j = rs.getInt("j");
				int k = rs.getInt("k");
				Date date = rs.getDate("date");
				
				orders.add(new Order(i, j, k, date));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return orders;
	}

}
