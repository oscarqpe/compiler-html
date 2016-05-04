package com.citec.Compiler.Html;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public  class ConnectionManager {
	static Connection c ;
    public static void GetConnection() {
        //Connection c = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/capitan?user=root&password=sistemas");
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
    public static boolean PruebaQuery(List<Solution> solutions) throws SQLException {
    	//Connection con = GetConnection();
    	try {
    		c.setAutoCommit(false);
    		for (Solution solution : solutions) {
    			String query = "INSERT INTO `solutions` (page_id,user_id, answer_id,similitud) VALUES ("+solution.getPage_id()+","+ solution.getUser_id()+"," + solution.getAnswer_id() + ", " +solution.getSimilitud()+");";
    			PreparedStatement psQuery = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    			//psQuery.execute();
    			
    			Integer idSolution = psQuery.executeUpdate();
    			
    			ResultSet rsSolution = psQuery.getGeneratedKeys();
    			if (rsSolution.next()){
    				idSolution = rsSolution.getInt(1);
    			}
    			System.out.println("Size Desc: " + solution.getRecomedaciones().size());
    			for (Recommendation rec : solution.getRecomedaciones()) {
    				System.out.println("Description: " + rec.getDescription());
    				String query_ = "INSERT INTO recommendations (description, solution_id) VALUES ('" + rec.getDescription() + "', " + idSolution + ");";
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
}