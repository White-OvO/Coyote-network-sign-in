package members.login.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.tree.RowMapper;

import members.login.entity.SignIn;

@Componet
@Sl4j


public class DefaultSignInDao {

	@Autowired
	
	private NamedParameterJdbcTemplate jdbcTempalte;
	
	
	@Override
	
	public List<SignIn> fetchAllSignIn() { 
		
		
		log.info("In signIn dao layer, fetch all signed in members");
		
		String sql =  ""
				+ "SELECT *"
				+ "FROM signIn";
		Map<String, Object> params = new HashMap<> ();
		return  jdbcTemplate.query(sql,  params, new RowMapper<SignIn>() {
			@Override
			public SignIn mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return SignIn.builder()
						.signInId(rs.getInt("sign_in_id"))
						.date(rs.getInt("date")))
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
	
	
	
	
	
	   jdbcTemplate.update(params.sql, params.source, keyHolder);
				return SignIn.builder()
						.signInId(keyHolder.getKey().intValue())
						.date(date)
						.studentNumber(studentNumber)
						.studebtName(studentName)
						.description(description)
				     	.build();
}
	
	
	class SqlParams {
		
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	
	
	@Override
	public SignIn updateSignIn(
			Date updatedDate,int updatedstudentNumber,String updatedStudentName,
			String updatedDescription) {
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
			params.put("date",updatedDate.int());            ///////////////////////////////// confirm this is correct
			
			
			
			
			if (jdbcTemplate.update(sql,params) == 0) {
				throw new NoSuchElementException("failed to update member");
			}
			return SignIn.builder()	
					//.inventoryId(updatedinventory)
					.date(updatedDate)
					.studentNumber(updatedStudentNumber)////////
					.studentName(updatedStudentmName)////////
					.description(updatedDescription)//////////
					.build();/////
		}
	
	

@Override
public void deleteSignIn(int deleteId) {
	String sql = ""
			+ "DELETE FROM Sign_in "
			+ "WHERE sign_in_id = :sign_in_id";
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("sign_in_id", deleteId);
		if (jdbcTemplate.update(sql, params) == 0) throw new NoSuchElementException();

}




}