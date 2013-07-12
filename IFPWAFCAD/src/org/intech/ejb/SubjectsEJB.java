package org.intech.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class SubjectsEJB
 */
@Stateless
@LocalBean
public class SubjectsEJB {

	@Resource(lookup = "jdbc/IFPWAFCAD")
	DataSource dataSource;

	public Object getAll() {
		Map<Integer, String> mSubjects = new HashMap<Integer, String>();
		try (Connection connection = dataSource.getConnection()) {
			String sql = "SELECT subject_id, name FROM Subject";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				mSubjects.put(rs.getInt("subject_id"), rs.getString("name"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mSubjects;
	}

}
