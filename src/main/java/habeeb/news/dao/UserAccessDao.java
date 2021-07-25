package habeeb.news.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.Access;
import habeeb.news.rowmapper.AccessMapper;
import habeeb.news.rowmapper.CountMapper;

@Repository
public class UserAccessDao {

	@Autowired
	JdbcTemplate template;

	public boolean accessAlreadyExist(Access access) {
		// TODO Auto-generated method stub
		String query = "select count(id) as quantity from user_access where userPk=? and categoryPk=? and countryPk=?";
//		template.
        int count = (int)template.queryForObject(query,new Object[]{access.getEmail(),access.getCategoryPk(),access.getCountryPk()},new CountMapper());
		return count==1?true:false;
	}

	public void revokeAccess(Access access) {
		// TODO Auto-generated method stub
		String query = "delete from user_access where userPk=? and categoryPk=? and countryPk=?";
		template.update(query,access.getEmail(),access.getCategoryPk(),access.getCountryPk());
		
	}

	public void giveAccess(Access access) {
		// TODO Auto-generated method stub
		String query = "insert into user_access(userPk,categoryPk,countryPk) values(?,?,?)";
		template.update(query,access.getEmail(),access.getCategoryPk(),access.getCountryPk());
	}

	public List<Access> getAllAccess() {
		// TODO Auto-generated method stub
		String query = "select ua.userPk, ua.categoryPk, ua.countryPk, cat.name as category, co.name as country from user_access as ua, category as cat, country as co where ua.categoryPk=cat.id and ua.countryPk=co.id";
		List<Access> access = template.query(query, new AccessMapper());
		return access;
	}
	public List<Access> getAllAccessOfAnUser(String email) {
		// TODO Auto-generated method stub
		String query = "select ua.userPk, ua.categoryPk, ua.countryPk, cat.name as category, co.name as country from user_access as ua, category as cat, country as co where ua.categoryPk=cat.id and ua.countryPk=co.id and ua.userPk=?";
		List<Access> access = template.query(query,new Object[] {email}, new AccessMapper());
		return access;
	}
}
