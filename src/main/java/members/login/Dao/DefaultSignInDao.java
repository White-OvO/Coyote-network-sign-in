package members.login.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;
import members.login.entity.SignIn;

@Component
@Slf4j


public class DefaultSignInDao implements SignInDao{

	@Autowired
	
	private NamedParameterJdbcTemplate jdbcTempalte;
	
	
	@Override
	
	public List<SignIn> fetchAllSignIn() { 
		
		
		log.info("In signIn dao layer, fetch all signed in members");
		
		String sql =  ""
				+ "SELECT *"
				+ "FROM signIn";
		Map<String, Object> params = new HashMap<> ();
		return  jdbcTempalte.query(sql,  params, new RowMapper<>() {
			@Override
			public SignIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return SignIn.builder()
					
						.date(rs.getInt("date"))
						.studentNumber(rs.getInt("student_number"))
						.studentName(rs.getString("student_name"))
						.description(rs.getString("description"))
						.build();
		
	}});
	
		
	}
	
	@Override
	public SignIn createSignIn(int date, int studentNumber, String studentName, String description) {
			SqlParams params = new SqlParams();
			KeyHolder keyHolder = new GeneratedKeyHolder();
			   log.debug("DAO: date={}, student_number={}, student_name={}, description={} ",
				        date, studentNumber, studentName, description);

	 // @formatter:off
    params.sql = ""
        + "INSERT INTO sign_in ("
        + "date, student_number, student_name, description"
        + ") VALUES ("
        + ":date, :student_number, :student_name, :description)";
    // @formatter:on
    
    
    
    
    
    
    params.source.addValue("date", date);
	params.source.addValue("student_number", studentNumber);
// 						params.source.addValue("item_number",itemNumber);
	params.source.addValue("student_name", studentName);
	params.source.addValue("description", description);
	
	
	
	
	
	   jdbcTempalte.update(params.sql, params.source, keyHolder);
				return SignIn.builder()
						.date(date)
						.studentNumber(studentNumber)
						.studentName(studentName)
						.description(description)
				     	.build();
}
	
	
	class SqlParams {
		
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	/*
	 * @Override
public SignIn updateSignIn(int date, int studentNumber, String studentName, String descripton) {
	// TODO Auto-generated method stub
	return null;
}
	 * 
	 * 
	 */
	
	@Override
	public SignIn updateSignIn(int signInId, SignIn updatedSignIn) {
			String sql = ""
					+ "UPDATE sign_In"
					+" SET "
					+" date = :new_date "
					+" student_Number = :new_student_Number "
					+" student_Name = :new_Student_Name "
					+" descrition = :new_description "
					+"WHERE sign_in_id = :sign_In_id ";
			
			
			
			
			Map<String, Object> params = new HashMap<>();
			//params.put("inventory_id", inventoryId);
			//params.put("inventory_id",inventory_Id);
			params.put("date",updatedSignIn.getDate());            ///////////////////////////////// confirm this is correct
			params.put("student_number", updatedSignIn.getStudentNumber());
			params.put("student_name", updatedSignIn.getStudentName());
			params.put("description", updatedSignIn.getDescription());
			
			
			
			if (jdbcTempalte.update(sql,params) == 0) {
				throw new NoSuchElementException("failed to update member");
			}
			return SignIn.builder() 
					.date(updatedSignIn.getDate())
					.studentNumber(updatedSignIn.getStudentNumber())////////
					.studentName(updatedSignIn.getStudentName())////////
					.description(updatedSignIn.getDescription())//////////
					.build();/////
		}
	
	

@Override
public void deleteSignIn(int signInId) {
	String sql = ""
			+ "DELETE FROM Sign_in "
			+ "WHERE sign_in_id = :sign_in_id";
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("sign_in_id", signInId);
		if (jdbcTempalte.update(sql, params) == 0) throw new NoSuchElementException();

}






}