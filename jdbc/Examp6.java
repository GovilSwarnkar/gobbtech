import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Examp6
{
	public static void main(String a[])
	{
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000"); 
			  
			  PreparedStatement ps = con.prepareStatement("select * from Student");
			  ResultSet rs = ps.executeQuery();
			  while(rs.next())
			  {
				  System.out.println("roll of student = " +rs.getInt("roll"));
				  System.out.println("name of student = " +rs.getString("name"));
				  System.out.println("marks of student = " +rs.getInt("marks"));
				  System.out.println();
				 }
			con.commit();
			con.close();
				 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}