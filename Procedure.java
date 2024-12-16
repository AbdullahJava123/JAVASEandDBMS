package dbmsPrograms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Procedure 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
      
      Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
      CallableStatement cs=con.prepareCall("{call studentInsert2(?,?,?,?,?,?,?,?,?)}");
      System.out.println("Enter StuId: ");
      int stuid=sc.nextInt();
      cs.setInt(1, stuid);
      
      System.out.println("Enter RollNo: ");
      int rollNo=sc.nextInt();
      cs.setInt(2, rollNo);
      sc.nextLine();
      
      System.out.println("Enter Name: ");
      String name=sc.nextLine();
      cs.setString(3, name);
      
      System.out.println("Enter Branch: ");
      String branch=sc.nextLine();
      cs.setString(4, branch);
      
      System.out.println("Enter Hno: ");
      int hno=sc.nextInt();
      cs.setInt(5,hno);
      sc.nextLine();
      
      System.out.println("Enter city: ");
      String city=sc.nextLine();
      cs.setString(6,city);
      
      System.out.println("Enter pin no: ");
      int pNo=sc.nextInt();
      cs.setInt(7, pNo);
      sc.nextLine();
      
      System.out.println("Enter mid: ");
      String mid=sc.nextLine();
      cs.setString(8, mid);
      
      System.out.println("Enter phno: ");
      long phno=sc.nextLong();
      cs.setLong(9, phno);
      
      int x=cs.executeUpdate();
      if(x>0)
      {
    	  System.out.println("One Record Inserted Successfully");
      }
      else
      {
    	  System.out.println("Operation fail");
      }
      
	}
	catch(Exception e)
	{
		e.getStackTrace();
	}
	}
}
