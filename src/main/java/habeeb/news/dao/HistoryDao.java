package habeeb.news.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import habeeb.news.models.News;
@Repository
public class HistoryDao {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
	NamedParameterJdbcTemplate template2;

	public void addHistory(News news) {
		// TODO Auto-generated method stub
		String query = "insert into user_history(userPk,newsPk) values(?,?)";
		template.update(query,news.getEmail(),news.getNewsPk());
		
	}
	//dummy below
		public void blah() {
			// TODO Auto-generated method stub
			List<Integer> al = new ArrayList<>();
			al.add(7);
			al.add(8);
			al.add(9);
			al.add(10);
			String st ="6,7,8,9,10";
			int arr[]= {6,7,8,9,10};

			
			
//			template.execute(query,idsMap);

			String hea = "hea";
			 List<Object[]> employeeIds = new ArrayList<>(); for (Integer id : al) {
			 employeeIds.add(new Object[] { id }); } template.
			 
			 batchUpdate(String.format("update sub_news set description='yes mister' where heading = '%s' and id in (?) ",hea),employeeIds);
			 
			/*
			 * String hea = "hea"; String inSql = String.join(",",
			 * Collections.nCopies(al.size(), "?")); System.out.println(String.
			 * format("update sub_news set description='abdul qadir' where heading = ? and id in (%s)"
			 * ,inSql)); template.update(String.
			 * format("update sub_news set description='abdul qadir' where heading = '%s' and id in (%s)"
			 * ,hea,inSql), al.toArray());
			 */
			//three ways that worked.
			/*
			 * List<Object[]> employeeIds = new ArrayList<>(); for (Integer id : al) {
			 * employeeIds.add(new Object[] { id }); } template.
			 * batchUpdate("update sub_news set description='yes mister' where id in (?)"
			 * ,employeeIds);
			 */
			/*
			 * String inSql = String.join(",", Collections.nCopies(al.size(), "?"));
			 * template.update(String.
			 * format("update sub_news set description='abdul qadir' where id in (%s)",
			 * inSql), al.toArray());
			 */
			/*
			 * String query = "update sub_news set description='yes mister' where id in (:ids)";
			Map idsMap = Collections.singletonMap("ids", al);
			 * template2.execute(query,idsMap,new PreparedStatementCallback() {
			 * 
			 * @Override public Object doInPreparedStatement(PreparedStatement ps) throws
			 * SQLException, DataAccessException { return ps.executeUpdate(); } });
			 */

			
			
		}

}
