package habeeb.news.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import habeeb.news.models.News;
import habeeb.news.models.SubNews;

public class NewsMapper  implements RowMapper<News>{
	@Override
	public News mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		News news = new News();
		
		news.setNewsPk(rs.getInt("id"));
		news.setHeading(rs.getString("heading"));
		news.setDescription(rs.getString("description"));
		news.setImage(rs.getString("image"));
		news.setSubCategoryPk(rs.getInt("subCategoryPk"));
		
		return news;
	}

}
