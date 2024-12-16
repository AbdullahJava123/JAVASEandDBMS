package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetriveStudent 
{
  public static void main(String[] args)
  {
	  Scanner sc=new Scanner(System.in);
	  try
	  {
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
	  PreparedStatement ps=con.prepareStatement("select * from studentTwo");
	  ResultSet rs=ps.executeQuery();
//	  System.out.println("=========Get Student By ID=========");
//	  PreparedStatement ps1=con.prepareStatement("select * from studentTwo where stuid=?");
//	  ResultSet rs1=ps1.executeQuery();
//	  System.out.println("Enter Id");
//	  int id=sc.nextInt();
//	  ps1.setInt(1, id);
	  while(rs.next())
	  {
		  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4)+" "+rs.getInt(5));
	  }
//	  while(rs1.next())
//	  {
//		  System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getLong(4)+" "+rs1.getInt(5));
//	  }
	  }
	  catch(Exception e)
	  {
		 e.getStackTrace();
	  }
  }
}
