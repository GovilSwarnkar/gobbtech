import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Examp3
{
	public static void main(String a[])
	{
		
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000");
	       
		   Statement st = con.createStatement();
		   long t1 = System.currentTimeMillis();
		   
		   for(int i=0;i<2000;i++)
		   {
		   st.addBatch("insert into Student values(1,'shiv',99.99)");
		   }
		   st.executeBatch();
	   long t2 = System.currentTimeMillis();
	   
	   System.out.println("time for Statement object = " + (t2-t1));
	   con.commit();
	   con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}