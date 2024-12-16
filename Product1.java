package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Product1 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("---------Retail Shop--------");
		boolean tORf=true;
		while(tORf)
		{
			System.out.println("Enter 1 to Insert productdetails into product table.");
			System.out.println("Entre 2 to Retrieve productdetails in forward direction");
			System.out.println("Enter 3 to Retrieve productdetails in reverse direction.");
			System.out.println("Enter 4 to exit");
			System.out.println("Enter a number: ");
			int no=sc.nextInt();
		switch(no)
		{
		case 1:Insert();break;
		case 2:prodForw();break;
		case 3:prodRev();break;
		case 4:tORf=false; break;
		default: System.out.println("Invalid Input");
		}
		}
	}
	public static void Insert()
	{
		Scanner sc=new Scanner(System.in);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("insert into product1 values(?,?,?,?)");
		
		System.out.println("Enter Id: ");
		int id=sc.nextInt();
		ps.setInt(1, id);
		sc.nextLine();
		
		System.out.println("Enter ProdName: ");
		String name=sc.nextLine();
		ps.setString(2, name);
		
		System.out.println("Enter Price: ");
		int price=sc.nextInt();
		ps.setInt(3, price);
		
		System.out.println("Enter Quantity: ");
		int qty=sc.nextInt();
		ps.setInt(4, qty);
		
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("One row updated");
		}
		else
		{
			System.out.println("Operation Failed");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public static void prodForw()
	{
	try 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("select * from product1");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public static void prodRev()
	{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("select * from product1 order by productId desc");
		ResultSet rs=ps.executeQuery();
		//String query = "SELECT * FROM your_table ORDER BY your_column DESC";
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
