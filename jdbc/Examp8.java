import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Examp8
{
	public static void main(String a[])
	{
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000"); 
			  
			  PreparedStatement ps = con.prepareStatement("select * from Student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);             
			  ResultSet rs = ps.executeQuery();
			     rs.last();
		        System.out.println("last record = " +rs.getInt("roll"));
		        System.out.println("first record = " +rs.first());
		        System.out.println("absolute(3) record = " +rs.absolute(3));
		        System.out.println("relative(-2) record = " +rs.relative(-2));
		        System.out.println("relative(2) record = " +rs.relative(2));
		        System.out.println("previous() record = " +rs.previous());
		       /* System.out.println("beforeFirst() record = " +rs.beforeFirst());
		        System.out.println("afterLast() record = " +rs.afterLast());*/
				
			con.commit();
			con.close();
				 
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}