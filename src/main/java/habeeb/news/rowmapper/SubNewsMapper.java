package habeeb.news.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import habeeb.news.models.News;
import habeeb.news.models.SubNews;

public class SubNewsMapper implements RowMapper<SubNews>{

	@Override
	public SubNews mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SubNews news = new SubNews();
		
		news.setSubDescription(rs.getString("description"));
		news.setSubHeading(rs.getString("heading"));
		news.setSubImage(rs.getString("image"));
		return news;
	}
}
