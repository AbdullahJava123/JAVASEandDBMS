package dbmsPrograms;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student 
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   while(true)
	   {
	   try
	   {
		   
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
	   PreparedStatement ps=con.prepareStatement("insert into studentTwo values(?,?,?,?,?)");
	   System.out.println("Enter Student Id: ");
	   int id=sc.nextInt();
	   ps.setInt(1, id);
	   sc.nextLine();
	   System.out.println("Enter Student Name: ");
	   String name=sc.nextLine();
	   ps.setString(2, name);
	   System.out.println("Enter Address: ");
	   String add=sc.nextLine();
	   ps.setString(3, add);
	   System.out.println("Enter Mobile no: ");
	   Long number=sc.nextLong();
	   ps.setLong(4, number);
	   System.out.println("Enter Student Marks: ");
	   int marks=sc.nextInt();
	   ps.setInt(5, marks);
	   int c=ps.executeUpdate();
	   if(c>0)
	   {
		   System.out.println("Data inSerted ");
	   }
	   else
	   {
		   System.out.println("Unable to Update data");
	   }
	   }
	   catch(Exception e)
	   {
		   e.getStackTrace();
	   }
	   }
   }
}
