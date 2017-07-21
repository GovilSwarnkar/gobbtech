import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Examp4
{
	public static void main(String a[])
	{
		
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000");
            
			PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?)");
			long t1 = System.currentTimeMillis();
			
		      for(int i=0;i<2000;i++)
			  {
				  ps.setInt(1,4);
				  ps.setString(2,"ram");
				  ps.setFloat(3,77.98f);
				  ps.addBatch();
			  }
			  ps.executeBatch();
		long t2 = System.currentTimeMillis();
		
		System.out.println("time for PreparedStatement object = " +(t2-t1));
		con.commit();
		con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		}
}