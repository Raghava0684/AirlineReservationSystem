package airlines;


import java.sql.*;

public class Database {

	public Connection conn;
	public Statement stmt;
	
	public Database() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "root");
			stmt = conn.createStatement();
			
//			System.out.println("Connection");
		} 
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new Database();
	}

}

