package com.citec.Compiler.Html;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.org.apache.bcel.internal.classfile.Code;


public  class ConnectionManager {
	static Connection c ;
	// Funcion que devuelve una lista 
    class ColumnInfo extends Object {

        public String columnName;
        public int columnType;

        public ColumnInfo(String columnName, int columnType) {
            this.columnName = columnName;
            this.columnType = columnType;
        }
    }
    public static void GetConnection() {
        //Connection c = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitan?user=root&password=sistemas");
            //c = DriverManager.getConnection("jdbc:mysql://107.170.22.36:3306/capitan?user=root&password=qwerty123");
        } catch (SQLException e) {
        	System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        //return c;
    }
    public static boolean saveSingleAnalisis(Solution ast, Solution lev) throws SQLException {
	//Connection con = GetConnection();
	System.out.println("SAVE SOLUTIONS...");
	try {
		c.setAutoCommit(false);
		// delete 
		String queryDelete = "delete from solutions where page_id = " + ast.getPage_id() + " and user_id = " + ast.getUser_id() + " and answer_id = " + ast.getAnswer_id();
		PreparedStatement psQueryDelete = c.prepareStatement(queryDelete, Statement.RETURN_GENERATED_KEYS);
		psQueryDelete.execute();
		
		String query = "INSERT INTO `solutions` (page_id,user_id, answer_id,similitud_levenshtein, similitud_ast) VALUES ("
					+ ast.getPage_id()+","
					+ ast.getUser_id()+"," 
					+ ast.getAnswer_id() + ", " 
					+ lev.getSimilitud_levenshtein() + ", "
					+ ast.getSimilitud_ast() + ");";
		
		PreparedStatement psQuery = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		//psQuery.execute();
		
		Integer idSolution = psQuery.executeUpdate();
		
		ResultSet rsSolution = psQuery.getGeneratedKeys();
		if (rsSolution.next()){
			idSolution = rsSolution.getInt(1);
		}
	//	System.out.println("SAVE RECOMMENDATIONS");
	//	System.out.println("Size Desc: " + solution.getRecomedaciones().size());
		for (Recommendation rec : ast.getErrors()) {
	//		System.out.println("Description: " + rec.getDescription());
			String query_ = "";
				query_ = "INSERT INTO errors (line_number, description, solution_id) VALUES (" + rec.getLineNumber() + ",'" + rec.getDescription() + "', " + idSolution + ");";
			
			PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
			psQuery_.execute();
		}
		for (String s : ast.getRecommendations()) {
			String query_ = "";
				query_ = "INSERT INTO recommendations (unit, solution_id) VALUES ('" + s + "'," + idSolution + ");";
			System.out.println("Recomm: " + query_);
			PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
			psQuery_.execute();
		}
		for (Recommendation rec : lev.getErrors()) {
	//		System.out.println("Description: " + rec.getDescription());
			String query_ = "";
				query_ = "INSERT INTO errors (line_number, description, solution_id) VALUES (" + rec.getLineNumber() + ",'" + rec.getDescription() + "', " + idSolution + ");";
			
			PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
			psQuery_.execute();
		}
		for (String s : lev.getRecommendations()) {
			String query_ = "";
				query_ = "INSERT INTO recommendations (unit, solution_id) VALUES ('" + s + "'," + idSolution + ");";
			System.out.println("Recomm: " + query_);
			PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
			psQuery_.execute();
		}
		c.commit();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		c.rollback();
		e.printStackTrace();
		/*if (con != null && !con.isClosed()){
			con.close();
			System.out.println("Connection closed.");
		}*/
		return false;
	}
	/*if (c != null && !c.isClosed()){
		c.close();
		System.out.println("Connection closed.");
	}*/
	return true;
    }
    public static boolean PruebaQuery(List<Solution> solutions, int datos) throws SQLException {
    	//Connection con = GetConnection();
    	System.out.println("SAVE SOLUTIONS...");
    	try {
    		c.setAutoCommit(false);
    		System.out.println("SOLUTIONS; " + solutions.size());
    		for (Solution solution : solutions) {
    			//System.out.println("PAGEID: " + solution.getPage_id());
    			//System.out.println("USERID: " + solution.getUser_id());
    			//System.out.println("ANSWID: " + solution.getAnswer_id());
    			String query = ""; 
    			if (datos == 1) {
    				query = "INSERT INTO `solutions` (page_id,user_id, answer_id,similitud_levenshtein) VALUES ("
    						+ solution.getPage_id()+","
    						+ solution.getUser_id()+"," 
    						+ solution.getAnswer_id() + ", " 
    						+ solution.getSimilitud_levenshtein()+");";
    			}
    			else {
    				query = "UPDATE sintetics set similitud_levenshtein = " + solution.getSimilitud_levenshtein() 
    						+ " where id = " + solution.getUser_id();
    			}
    			
    			PreparedStatement psQuery = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    			//psQuery.execute();
    			
    			Integer idSolution = psQuery.executeUpdate();
    			
    			ResultSet rsSolution = psQuery.getGeneratedKeys();
    			if (rsSolution.next()){
    				idSolution = rsSolution.getInt(1);
    			}
    		//	System.out.println("SAVE RECOMMENDATIONS");
    		//	System.out.println("Size Desc: " + solution.getRecomedaciones().size());
    			for (Recommendation rec : solution.getErrors()) {
    		//		System.out.println("Description: " + rec.getDescription());
    				String query_ = "";
    				if (datos == 1)
    					query_ = "INSERT INTO errors (line_number, description, solution_id) VALUES (" + rec.getLineNumber() + ",'" + rec.getDescription() + "', " + idSolution + ");";
    				else
    					query_ = "INSERT INTO errors (line_number, description, sintetic_id) VALUES (" + rec.getLineNumber() + ",'" + rec.getDescription() + "', " + solution.getUser_id() + ");";
    				System.out.println("Errors: " + query_);
    				PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
    				psQuery_.execute();
    			}
    			for (String s : solution.getRecommendations()) {
    				String query_ = "";
    				if (datos == 1)
    					query_ = "INSERT INTO recommendations (unit, solution_id) VALUES ('" + s + "'," + idSolution + ");";
    				else 
    					query_ = "INSERT INTO recommendations (unit, sintetic_id) VALUES ('" + s + "'," + solution.getUser_id() + ");";
    				System.out.println("Recomm: " + query_);
    				PreparedStatement psQuery_ = c.prepareStatement(query_, Statement.RETURN_GENERATED_KEYS);
    				psQuery_.execute();
    			}
			}
			
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			c.rollback();
			e.printStackTrace();
			/*if (con != null && !con.isClosed()){
				con.close();
				System.out.println("Connection closed.");
			}*/
			return false;
		}
    	/*if (c != null && !c.isClosed()){
			c.close();
			System.out.println("Connection closed.");
		}*/
    	return true;
    }
    public static boolean UpdateSimilitudAST(List<Solution> solutions, int datos) throws SQLException {
    	//Connection con = GetConnection();
    	try {
    		c.setAutoCommit(false);
    		for (Solution solution : solutions) {
    			
    			String query = "";
    			if (datos == 1)
    				query = "UPDATE `solutions` SET similitud_ast = " + solution.getSimilitud_ast() + " where page_id = " 
    						+ solution.getPage_id() + " and answer_id = " + solution.getAnswer_id() + " and user_id = " + solution.getUser_id();
    			else
    				query = "UPDATE `sintetics` SET similitud_ast = " + solution.getSimilitud_ast() + " where id = " 
    						+ solution.getUser_id();
    			PreparedStatement psQuery = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    			//psQuery.execute();
    			
    			Integer idSolution = psQuery.executeUpdate();
    			
    			ResultSet rsSolution = psQuery.getGeneratedKeys();
    			if (rsSolution.next()){
    				idSolution = rsSolution.getInt(1);
    			}
    			
			}
			
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			c.rollback();
			e.printStackTrace();
			/*if (con != null && !con.isClosed()){
				con.close();
				System.out.println("Connection closed.");
			}*/
			return false;
		}
    	/*if (c != null && !c.isClosed()){
			c.close();
			System.out.println("Connection closed.");
		}*/
    	return true;
    }
    public static List<CodeEntity> getSolutions() throws SQLException {
    	List<CodeEntity> solutions = new ArrayList<CodeEntity>();
    	
    	
    	try {
    		c.setAutoCommit(false);
    		
    		String query = "SELECT pages.id, pages.id, pages.unit_id, pages.solution " + 
    				"FROM pages " + 
    				"INNER JOIN units u ON u.id = pages.unit_id " + 
    				"INNER JOIN courses ON courses.id = u.course_id " + 
    				"WHERE (pages.page_type = 'editor' and pages.selfLearning = 0 and pages.solution <> '') ";
			
    		Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            	CodeEntity code = new CodeEntity();
            	code.setPageId(rs.getInt("id"));
            	code.setUserId(rs.getInt("unit_id"));
            	String result = rs.getString("solution");
            	//String s1= StrManager.eraserChar(0, result);
            	//String s2= StrManager.eraserChar(s1.length()-1, s1);
            	String sTemp = result != null ? result.replace("\"\"","\"") : "";
            	code.setCode(sTemp);
            	solutions.add(code);
            }
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			c.rollback();
			e.printStackTrace();
			/*if (con != null && !con.isClosed()){
				con.close();
				System.out.println("Connection closed.");
			}*/
			return null;
		}
    	
    	return solutions;
    }
    
    public static CodeEntity getCodeEntity(int userId, int pageId) throws SQLException {
    	CodeEntity entity = new CodeEntity();
    	
    	
    	try {
    		c.setAutoCommit(false);
    		
    		String query = "";
    			query = "SELECT answers.id, answers.page_id, answers.user_id, answers.result " + 
    				"FROM answers " + 
    				"INNER JOIN pages ON pages.id = answers.page_id " + 
    				"INNER JOIN units ON units.id = pages.unit_id " + 
    				"INNER JOIN courses ON courses.id = units.course_id " + 
    				"WHERE (pages.page_type = 'editor' and pages.selfLearning = 0 and pages.solution <> '' " +
    				" and pages.id = " + pageId + " and answers.user_id = " + userId + ") LIMIT 1";
    		
    		Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            	entity.setAnswerId(rs.getInt("id"));
            	entity.setPageId(rs.getInt("page_id"));
            	entity.setUserId(rs.getInt("user_id"));
            	String result = rs.getString("result");
            	//String s1= eraserChar(0, result);
            	//String s2= eraserChar(s1.length()-1, s1);
            	String sTemp = result != null ? result.replace("\"\"","\"") : "";
            	entity.setCode(sTemp);
            	
            }
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			c.rollback();
			e.printStackTrace();
			/*if (con != null && !con.isClosed()){
				con.close();
				System.out.println("Connection closed.");
			}*/
			return null;
		}
    	
    	return entity;
    }
    public static List<CodeEntity> getSolutionEstudents(int datos) throws SQLException {
    	List<CodeEntity> results = new ArrayList<CodeEntity>();
    	
    	
    	try {
    		c.setAutoCommit(false);
    		
    		String query = "";
    		
    		if (datos == 1) {
    			query = "SELECT answers.id, answers.page_id, answers.user_id, answers.result " + 
    				"FROM answers " + 
    				"INNER JOIN pages ON pages.id = answers.page_id " + 
    				"INNER JOIN units ON units.id = pages.unit_id " + 
    				"INNER JOIN courses ON courses.id = units.course_id " + 
    				"WHERE (pages.page_type = 'editor' and pages.selfLearning = 0 and pages.solution <> '') ";
    		} else {
    			query = "SELECT s.id, s.page_id, s.id as user_id, s.result   " + 
    					"FROM sintetics s   " + 
    					"INNER JOIN pages ON pages.id = s.page_id   " + 
    					"INNER JOIN units ON units.id = pages.unit_id   " + 
    					"INNER JOIN courses ON courses.id = units.course_id   " + 
    					"WHERE (pages.page_type = 'editor' and pages.selfLearning = 0 and pages.solution <> '')";
    		}
    		Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            	CodeEntity code = new CodeEntity();
            	code.setAnswerId(rs.getInt("id"));
            	code.setPageId(rs.getInt("page_id"));
            	code.setUserId(rs.getInt("user_id"));
            	String result = rs.getString("result");
            	//String s1= eraserChar(0, result);
            	//String s2= eraserChar(s1.length()-1, s1);
            	String sTemp = result != null ? result.replace("\"\"","\"") : "";
            	code.setCode(sTemp);
            	results.add(code);
            }
			c.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			c.rollback();
			e.printStackTrace();
			/*if (con != null && !con.isClosed()){
				con.close();
				System.out.println("Connection closed.");
			}*/
			return null;
		}
    	
    	return results;
    }
    public static String eraserChar(int i, String s) {
		String a = s.substring(0, i);
		String b = s.substring(i + 1, s.length());
		return a + b;
	}
}