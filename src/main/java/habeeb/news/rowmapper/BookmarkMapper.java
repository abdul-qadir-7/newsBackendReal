package habeeb.news.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import habeeb.news.models.News;

public class BookmarkMapper implements RowMapper<News>{

	@Override
	public News mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		News news = new News();
		news.setNewsPk(rs.getInt("id"));
		news.setHeading(rs.getString("heading"));
		news.setImage(rs.getString("image"));
		news.setDescription(rs.getString("description"));
		return news;
	}

}
