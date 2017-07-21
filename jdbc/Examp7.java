import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

class Examp7
{
	public static void main(String a[])
	{
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000"); 
			  
			  PreparedStatement ps = con.prepareStatement("select * from Student");
			  ResultSet rs = ps.executeQuery();
			  
			  ResultSetMetaData rsmd = rs.getMetaData();
			  
			  int tot_col = rsmd.getColumnCount();
			  System.out.println("==============================");
              System.out.println("total no of column = " +tot_col);
              System.out.println("==============================");
		
   			  
			  for(int i=1;i<tot_col;i++)
			  {
				  System.out.println("colName = " +rsmd.getColumnName(i));
				  System.out.println("col is nullable or not = " +rsmd.isNullable(i));
				  System.out.println("col Type = " +rsmd.getColumnType(i));
				  System.out.println("==============================");
			  }
			  
			con.commit();
			con.close();
				 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}