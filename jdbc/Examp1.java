import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Examp1
{
	
	public static void main(String a[])
	{
		
		try{
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000");
		        
			  Statement st = con.createStatement();
			  int i = st.executeUpdate("insert into Student values(1,'shiv',99.99)");
			  System.out.println(" no of row inserted = " + i);
		     
			     con.commit();
				 con.close();
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}