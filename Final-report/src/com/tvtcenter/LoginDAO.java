package com.tvtcenter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;





public class LoginDAO {
	
	PreparedStatement state = null;
	private String dbcpResourceName = null;
	private Connection conn = null;
	
	public LoginDAO(String dbcpResourceName) {
		this.dbcpResourceName = dbcpResourceName;
	}
	
	public LoginDAO() {
		// TODO Auto-generated constructor stub
	}

	private void connectDB() throws ClassNotFoundException, SQLException {
		try {
			DataSource ds = (DataSource)(new InitialContext()).lookup("java:comp/env/" + dbcpResourceName);
			conn = ds.getConnection();	

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}
		
	}
	private void disconnectDB() throws SQLException {
		if(state!=null) {
			state.close();
			state = null;
		}
		if(conn!= null) {
			conn.close();
			conn = null;
		}
	}
	
	public LoginDO getLoginData(String id) throws SQLException, ClassNotFoundException {
		LoginDO logindo = null;
		
		connectDB();
		
		String sql = "select * from tvtdata where id = '" + id +"'";
		state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery(sql);
		
	
			if(rs.next()) {
				logindo = new LoginDO();
				logindo.setId(rs.getString("id"));
				logindo.setPassword(rs.getString("password"));
				logindo.setName(rs.getString("name"));
				logindo.setBirth(rs.getString("birth"));
				logindo.setEmail(rs.getString("email"));
				logindo.setRole(rs.getString("Role"));
				
			}
			
		rs.close();

		disconnectDB();
		return logindo;
	}
	
	public List<TestResultDO> getScoreDatas(String id) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;
		ArrayList<TestResultDO> rlist = null;
	
		connectDB();
		
		String sql = "select * from scoredata where id='" + id +"'";
		state = conn.prepareStatement(sql);
		rs = state.executeQuery(sql);
		
		if(rs.isBeforeFirst()) {
			rlist = new ArrayList<TestResultDO>();
			while(rs.next()) {
				TestResultDO rdo = new TestResultDO();
				rdo.setId(rs.getString("id"));
				rdo.setScore(rs.getInt("score"));
				rdo.setNumber(rs.getInt("numberOfTest"));
				rlist.add(rdo);

			}
		}
		
		if (rs != null) rs.close();
		disconnectDB();
		return rlist;
	}
	public TestResultDO getScoreData(String id, int numberOfTest) throws SQLException, ClassNotFoundException {
		TestResultDO rdo = null;
		
		connectDB();
		
		String sql = "select * from scoredata where id = '" + id +"' and numberOfTest =" +  numberOfTest;
		state = conn.prepareStatement(sql);
		ResultSet rs = state.executeQuery(sql);
		
	
			if(rs.next()) {
				rdo = new TestResultDO();
				rdo.setId(rs.getString("id"));
				rdo.setScore(rs.getInt("Score"));
				rdo.setNumber(rs.getInt("NumberOfTest"));
			}
			
		rs.close();

		disconnectDB();
		return rdo;
	}
	
	
	public int insertLoginData(LoginDO data) throws ClassNotFoundException, SQLException {
		connectDB();
		
		String sql = String.format("insert into TVTDATA(id,password,name,birth,EMAIL,Role) values ('%s','%s','%s','%s','%s','%s')"
				,data.getId(),data.getPassword(), data.getName(), data.getBirth(), data.getEmail(), data.getRole());
		state = conn.prepareStatement(sql);
		int result = state.executeUpdate(sql);
		
		disconnectDB();
		
		return result;
	}
	
	public QuestionDO getQuestion(int id,int numberOfTest) throws ClassNotFoundException, SQLException {
		QuestionDO qt = null;
		
		
			
			connectDB();
			
			String sql = String.format("select * from question_tbl%d where id = %d",numberOfTest,id);
			state = conn.prepareStatement(sql);
			ResultSet rs = state.executeQuery(sql);
			
			if (rs.next()) {
				qt = new QuestionDO();
				qt.setId(rs.getInt("id"));
				qt.setQuestion(rs.getString("question"));
				qt.setItems(rs.getString("items").split("/"));
				String[] scoresStr = rs.getString("scores").split("/");
				int[] scores = new int[scoresStr.length];
				for (int i=0; i<scoresStr.length; i++) {
					scores[i] = Integer.parseInt(scoresStr[i]);
				}
				qt.setScores(scores);
			}
			disconnectDB();

			return qt;
	}
	public int insertScore(TestResultDO data) throws ClassNotFoundException, SQLException {
		connectDB();
		
		String sql = String.format("insert into ScoreDATA(id,score,numberOfTest) values ('%s', %d, %d)",data.getId(),data.getScore(),data.getNumber());
		state = conn.prepareStatement(sql);
		int result = state.executeUpdate(sql);
		
		disconnectDB();
		
		return result;
	}
	
	
	
}
