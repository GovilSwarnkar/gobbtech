import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Examp2 
{
	public static void main(String a[])
	{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000"); 
			System.out.println("connection established");    
			
				PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?)");
				Scanner sc = new Scanner(System.in);
				System.out.println("enter roll of student:");
				int rn = sc.nextInt();
				System.out.println("enter name of student:");
				String nm = sc.next();
				System.out.println("enter marks of student:");
				float mks = sc.nextFloat();
				
				ps.setInt(1,rn);
				ps.setString(2,nm);
				ps.setFloat(3,mks);
				
				ps.executeUpdate();
				con.commit();
				con.close();
				
				System.out.println("record is inserted");
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}