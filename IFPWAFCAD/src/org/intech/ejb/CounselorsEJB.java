package org.intech.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.intech.j2ee.beans.CounselorDetail;

/**
 * Session Bean implementation class SubjectsEJB
 */
@Stateless
@LocalBean
public class CounselorsEJB {

	@Resource(lookup = "jdbc/IFPWAFCAD")
	DataSource dataSource;

	public CounselorDetail get(int id) {
		CounselorDetail c = new CounselorDetail();

		try (Connection connection = dataSource.getConnection()) {
		    String sql = "SELECT * FROM Subject, Counselor WHERE Counselor.counselor_id = Subject.counselor_idfk AND Subject.subject_id = ? LIMIT 1";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				c.setDescription(rs.getString("description"));
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
				c.setNickName(rs.getString("nick_name"));
				c.setMemberSince(rs.getDate("member_since"));
				c.setTelephone(rs.getString("telephone"));
				c.setEmail(rs.getString("email"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return c;
	}

}
