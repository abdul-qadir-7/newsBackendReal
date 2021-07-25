package habeeb.news.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.HomeNews;
import habeeb.news.models.News;
import habeeb.news.models.SubNews;
import habeeb.news.rowmapper.BookmarkMapper;
import habeeb.news.rowmapper.CountMapper;
import habeeb.news.rowmapper.NewsMapper;
import habeeb.news.rowmapper.SubNewsMapper;

@Repository
public class NewsDao {

	@Autowired
	JdbcTemplate template;

	public void add(News news) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO news(countryPk,subCategoryPk,heading,image,description,addedBy) VALUES(?,?,?,?,?,?)";
		template.update(sql, news.getCountryPk(), news.getSubCategoryPk(), news.getHeading(), news.getImage(), news.getDescription(),
				news.getEmail());
		sql = "select id as quantity from news where countryPk=? and subCategoryPk=? and heading=? and description=? and addedBy=?";// think about this
		int id = (int) template.queryForObject(sql,
				new Object[] { news.getCountryPk(), news.getSubCategoryPk(), news.getHeading(), news.getDescription(), news.getEmail() }, new CountMapper());
		List<SubNews> list = news.getSubNews();
		for (SubNews item : list) {
			sql = "INSERT INTO sub_news(newsPk,heading,image,description) VALUES(?,?,?,?)";
			template.update(sql, id, item.getSubHeading(),item.getSubImage(), item.getSubDescription());

		}
	}

	public void delete(News news) {
		// TODO Auto-generated method stub
		String sql = "update news set softDeleted=1 , deletedBy=? where id=?";
		template.update(sql,new Object[] {news.getEmail(),news.getNewsPk()});
		sql ="update sub_news set softDeleted=1 , deletedBy=? where newsPk=?";
		template.update(sql,new Object[] {news.getEmail(),news.getNewsPk()});
	}

	public News getNews(String email, int id) {
		// TODO Auto-generated method stub
		String query = "select heading,image,description from sub_news where newsPk=?";
		List<SubNews> subNewsList = template.query(query, new Object[] {id}, new SubNewsMapper());
		query="select id,heading,description,image,subCategoryPk from news where id=?";
		News news = template.queryForObject(query, new Object[] {id},new NewsMapper());
		
		news.setSubNews(subNewsList);
		query="select count(id) from user_bookmark where newspk=? and userPk=?";
		int bookmarked = template.queryForObject(query, new Object[] {id,email},Integer.class);
		news.setBookmarked(bookmarked==1?true:false);
		return news;
	}

	public List<News> getAllCategoryNews(int categoryPk, int countryPk) {
		// TODO Auto-generated method stub
		String sql ="select id,heading,description,image from news where countryPk in (?,5) and subCategoryPk in (select id from sub_category where categoryPk=?)";
		return template.query(sql,new Object[] {countryPk, categoryPk}, new BookmarkMapper());
//		return new List<News>;
//		return null;
	}

	public List<News> getAllSubCategoryNews(int subCategoryPk, int countryPk) {
		// TODO Auto-generated method stub
		String sql ="select id,heading,description,image from news where subCategoryPk=? and countryPk in (?,5)  ";
		return template.query(sql,new Object[] {subCategoryPk, countryPk}, new BookmarkMapper());
//		return new List<News>;
//		return null;
	}

	public HomeNews getHomePageNews(int countryPk) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM news as ne where ne.countryPk in (5,?) and ne.subCategoryPk in (select id from news.sub_category where categoryPk=?) order by id desc limit 4";
		HomeNews news = new HomeNews();
		news.setTopNews(template.query("select * from news where countryPk in (5,?) order by id desc limit 3",new Object[] {countryPk}, new BookmarkMapper()));
		news.setLatestGadgets(template.query(sql,new Object[] {countryPk,1}, new BookmarkMapper()));
		news.setLatestB2btech(template.query(sql,new Object[] {countryPk,2}, new BookmarkMapper()));;
		news.setLatestResourceLib(template.query(sql,new Object[] {countryPk,3}, new BookmarkMapper()));;
		return news;
	}

}
