package habeeb.news.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.News;
import habeeb.news.rowmapper.BookmarkMapper;

@Repository
public class BookmarkDao {

	@Autowired
	JdbcTemplate template;

	public void add(News news) {
		// TODO Auto-generated method stub
		String sql ="insert into user_bookmark(userPk,newsPk) values(?,?)";
		template.update(sql,new Object[] {news.getEmail(),news.getNewsPk()});
		
	}

	public List<News> getAll(String userPk) {
		// TODO Auto-generated method stub
		String sql ="select ne.id, ne.heading, ne.description, ne.image from news as ne, user_bookmark as bo where bo.newsPk=ne.id and bo.userPk=?";
		return template.query(sql,new Object[] {userPk}, new BookmarkMapper());
		
//		return new List<News>;
	}

	public void remove(News news) {
		// TODO Auto-generated method stub
		String sql = "delete from user_bookmark where userPk=? and newsPk=?";
		template.update(sql,new Object[] {news.getEmail(),news.getNewsPk()});
		
	}
}
