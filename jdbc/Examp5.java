import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Examp5
{
	public static void main(String a[])
	{
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","my_db","ram0000"); 
			  
			  Scanner sc = new Scanner(System.in);
			  System.out.println("choose your choice, 1.update 2.delete");
			  int ch = sc.nextInt();
			 
			  if(ch==1)
			  {
				 PreparedStatement ps = con.prepareStatement("update student set name=?,marks=? where roll=?");
				 System.out.println("enter roll no.:");
				 int rn = sc.nextInt();
				 
				 System.out.println("enter name:");
				 String nm = sc.next();
				 
				 System.out.println("enter makrs");
				 float mks = sc.nextFloat();

				 ps.setString(1,nm);
				 ps.setFloat(2,mks);
				 ps.setInt(3,rn);
				 
				 ps.executeUpdate();
				 
				 System.out.println("update successful.");
				 
			  }else if(ch==2){
				  
			PreparedStatement ps = con.prepareStatement("delete from student where roll=?");
            System.out.println("enter roll no.:");
 			int rn = sc.nextInt();
			ps.setInt(1,rn);
			ps.executeUpdate();
			System.out.println("delete successful.");
				  
				  }else
				  {
					  System.out.println("wrong choice");
				  }
			  
			  
			  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}