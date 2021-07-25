package habeeb.news.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.User;
import habeeb.news.rowmapper.CountMapper;
import habeeb.news.rowmapper.LoginMapper;

@Repository
public class SignupLoginDao {

	@Autowired
	JdbcTemplate template;
	public int signUp(User user) {
		// TODO Auto-generated method stub
		/*
		 * String sql = "SELECT email FROM user where user.email="+user.getEmail();
		 * List<String> items = template.query(sql, new UserMapper()); // return items;
		 * if(items.size()==1) { return 0; }
		 */
		String sql = "INSERT INTO user(name,email,password) VALUES(?,?,?)";
		
        int ret =   template.update(sql,user.getName(),user.getEmail(),user.getPassword());
		/*
		 * for(int i: user.getUserSubscribedCategories()) { String
		 * sql2="insert into user_subscribed_category(userPk,categoryPk) values(?,?)";
		 * template.update(sql2,user.getEmail(),i); }
		 */
        return ret;
        //		
//        return "user already exist";
	}

	public User checkPassword(User user) {
		// TODO Auto-generated method stub

		String query = "select count(email) as quantity from user where email=? and password=?";
//		template.
        int item = (int)template.queryForObject(query,new Object[]{user.getEmail(),user.getPassword()},Integer.class);
        if(item==1) {

        	
        	query = "select name, email, superAdmin from user where email=?";
        	User outputUser=(User)template.queryForObject(query,new String[] {user.getEmail()},new LoginMapper());
        	outputUser.setOutput(1);
        	query="select count(id) from user_access where userPk=?";
        	int admin = (int)template.queryForObject(query,new Object[]{user.getEmail()},Integer.class);
        	outputUser.setAdmin((admin>0)?1:0);
        	return outputUser;
        }else {
        	User outputUser = new User();
        	outputUser.setOutput(0);
        	return outputUser;
        }
//		return outputUser;
	}

	public boolean userAlreadyExist(User user) {
		// TODO Auto-generated method stub
		String sql = "select count(email) as quantity from user where email=?";
		int m1 = (int)template.queryForObject(sql,new Object[] {user.getEmail()},new CountMapper());
		return m1==1 ? true: false;
	}

}
