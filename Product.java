package dbmsPrograms;
import java.util.Scanner;
import java.sql.*;

public class Product {
@SuppressWarnings("resource")
public static void main(String[] args)
{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
	PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?)");
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter ID of Product: ");
	  int id=sc.nextInt();
	  ps.setInt(1, id);
	  sc.nextLine();
	  System.out.println("Enter Name of the product: ");
	  String name=sc.nextLine();
	  ps.setString(2,name);
	  System.out.println("Enter Product Price: ");
	  int price=sc.nextInt();
	  ps.setInt(3, price);
	  System.out.println("Enter Product Quantity: ");
	  int qty=sc.nextInt();
	  ps.setInt(4, qty);
	  int c=ps.executeUpdate();
	  if(c>0)
	  {
	  System.out.println("One record Inserted");
	  }
	  else
	  {
		  System.out.println("Not Inserted");
	  }
	}
	catch(Exception e)
	{
		e.getStackTrace();
	}

	
}
}
