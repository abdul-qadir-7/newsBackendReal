package habeeb.news.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.Subscription;

@Repository
public class SubscriptionDao {

	@Autowired
	JdbcTemplate template;

	public void subscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		String query = "insert into user_subscribed_category(userPk,categoryPk) values(?,?)";
		template.update(query,subscription.getEmail(),subscription.getCategoryPk());
	}
	public boolean isSubscribed(Subscription subscription) {
		// TODO Auto-generated method stub
		String query = "select count(id) from user_subscribed_category where userpk=? and categoryPk=?";
		int subscribed=(int)template.queryForObject(query,new Object[] {subscription.getEmail(),subscription.getCategoryPk()},Integer.class);
		return subscribed==1?true:false;
	}
	public void unSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		String query = "delete from user_subscribed_category where userPk=? and categoryPk=?";
		template.update(query,subscription.getEmail(),subscription.getCategoryPk());
	}
}
