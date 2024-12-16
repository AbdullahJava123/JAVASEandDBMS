package dbmsPrograms;

//import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage 
{
  public static void main(String[] args)
  {
	  Scanner sc=new Scanner(System.in);
	  try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("insert into Player_info values(?,?,?,?)");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Mohd Abdullah Ansari\\OneDrive\\Pictures\\133592170576116274.jpg");
		System.out.println("Enter Id: ");
		int id=sc.nextInt();
		ps.setInt(1, id);
		sc.nextLine();
		
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		ps.setString(2, name);
		
		System.out.println("Enter Dob: ");
		String dob=sc.nextLine();
		ps.setString(3, dob);
		
		System.out.println("Enter pImage: ");
		String img=sc.nextLine();
		ps.setString(4, img);
		
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("One row inserted");
		}
		else
		{
			System.out.println("Operation fail");
		}
	} 
	  catch (Exception e) 
	  {
		
		e.printStackTrace();
	}
  }
}
