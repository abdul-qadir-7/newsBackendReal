package habeeb.news.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import habeeb.news.models.Access;

public class AccessMapper implements RowMapper<Access>{

	@Override
	public Access mapRow(ResultSet rs, int rowNum) throws SQLException {
		/*
		 * Access user = new User(); user.setName(rs.getString("name"));
		 * user.setEmail(rs.getString("email"));
		 * user.setSuperAdmin(rs.getInt("superAdmin")); return user;
		 */
		Access user = new Access();
		user.setEmail(rs.getString("userPk"));
		user.setCategory(rs.getString("category"));
		user.setCategoryPk(rs.getInt("categoryPk"));
		user.setCountry(rs.getString("country"));
		user.setCountryPk(rs.getInt("countryPk"));
		return user;
		
	}
}
