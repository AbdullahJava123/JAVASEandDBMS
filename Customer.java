package dbmsPrograms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Scanner;

public class Customer 
{
    public static void main(String[] args) throws SQLException
    {
    	Scanner sc=new Scanner(System.in);
    	boolean tr=true;
    	while(tr)
    	{
    	System.out.println("=======Customer=======");
    	System.out.println("Enter 1 to Register user: ");
    	System.out.println("Enter 2 to login: ");
    	System.out.println("Enter 3 to exit");
    	System.out.println("Enter a number: ");
    	int no=sc.nextInt();
    	switch(no)
    	{
    	case 1:register();break;
    	case 2:login();break;
    	case 3:tr=false;break;
    	default: System.out.println("Invalid Input");
    	}
    	}
    }



	private static void register() 
	{
		Scanner sc=new Scanner(System.in);	
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			System.out.println("Enter Id: ");
			int id=sc.nextInt();
			ps.setInt(1, id);
			sc.nextLine();
			
			System.out.println("Enter Name: ");
			String name=sc.nextLine();
			ps.setString(2, name);
			
			System.out.println("Enter password: ");
			long passwrd=sc.nextLong();
			ps.setLong(3,passwrd);
			sc.nextLine();
			
			System.out.println("Enter MailId: ");
			String mailid=sc.nextLine();
			ps.setString(4, mailid);
			
			System.out.println("Enter phNo: ");
			long phno=sc.nextLong();
			ps.setLong(5, phno);
			ps.executeUpdate();
			System.out.println("One row updated");
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
	private static void login() 
	{
		Scanner sc=new Scanner(System.in);
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			PreparedStatement ps=con.prepareStatement("select * from customer where name=? and password=?");
			
			System.out.println("Enter Name: ");
			String name=sc.nextLine();
			ps.setString(1, name);
			
			System.out.println("Enter password: ");
			long passwrd=sc.nextLong();
			ps.setLong(2,passwrd);
			ResultSet rs=ps.executeQuery();
			if (!rs.isBeforeFirst()) {    
	            System.out.println("LogIn Failed");
	        } 
			else
			{
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getLong(5));
				if((name.equals(rs.getString(2))) && passwrd==rs.getLong(3))
				{
					System.out.println("Login Successfull");
					boolean tr=true;
					while(tr)
					{
					System.out.println("Insert 1 to print table data: ");
					System.out.println("Insert 2 to update Table: ");
					System.out.println("Insert 3 to delete from table: ");
					System.out.println("Insert 4 to exit ");
					System.out.println("Enter a number: ");
					int no=sc.nextInt();
					    switch(no)
					     {
					       case 1: printTable();break;
					       case 2: updateTable();break;
					       case 3: deleteFromTable();break;
					       case 4:tr=false;break;
					       default:System.out.println("Invalid Input");
					     }
					}
				}
//				else
//				{
//					System.out.println("LogIn Failed");
//				}
			}
			}
			
			
			
				
			
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	private static void deleteFromTable() 
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			PreparedStatement ps=con.prepareStatement("delete from  customer  where name like ?");
			ps.setString(1, "s%");
			int no=ps.executeUpdate();
			System.out.println("no: "+no);
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
	}

	private static void updateTable() 
	{
		Scanner sc=new Scanner(System.in);
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			PreparedStatement ps=con.prepareStatement("Update customer set MAILID=?,PHNO=?  where customerid=?");
			System.out.println("Enter MailId: ");
			String mailid=sc.nextLine();
			ps.setString(1, mailid);
			
			System.out.println("Enter phNo: ");
			long phno=sc.nextLong();
			ps.setLong(2, phno);
			
			System.out.println("Enter Id: ");
			int id=sc.nextInt();
			ps.setInt(3, id);
			ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	private static void printTable() 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			PreparedStatement ps=con.prepareStatement("select * from customer");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getLong(5));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
//private static void login() throws SQLException 
//{
//	Scanner sc=new Scanner(System.in);
//	try 
//	{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
//		PreparedStatement ps=con.prepareStatement("select count(*) from customer where name=?,password=?");
//		ResultSet rs=ps.executeQuery();
//		ResultSetMetaData rm=rs.getMetaData();
//		int c=rm.getColumnCount();
//		
//		System.out.println("Enter Name: ");
//		String name=sc.nextLine();
//		ps.setString(1, name);
//		
//		System.out.println("Enter password: ");
//		long passwrd=sc.nextLong();
//		ps.setLong(2,passwrd);
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getLong(5));
//		}
//		
//		boolean nm=false;
//		boolean pass=false;
//		for(int i=1;i<=c;i++)
//		{
//			if(name.equals(rs.getString(2)))
//			{
//				nm=true;
//			}
//			if(passwrd==rs.getLong(3))
//			{
//				pass=true;
//			}
//		}
//		if(nm==true && pass==true)
//		{
//			ps.executeQuery("select * from customer");
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getLong(5));
//			}
//			ps.executeUpdate("Update customer set mailid=?,phno=? where where customerid=?");
//			System.out.println("Enter MailId: ");
//			String mailid=sc.nextLine();
//			ps.setString(1, mailid);
//			
//			System.out.println("Enter phNo: ");
//			long phno=sc.nextLong();
//			ps.setLong(2, phno);
//			
//			System.out.println("Enter Id: ");
//			int id=sc.nextInt();
//			ps.setInt(3, id);
//			
//			ps.executeUpdate("delete from  customer  where name=s%");
//			ps.executeQuery("select * from customer where ");
//			while(rs.next())
//			{
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getLong(5));
//			}
//			ps.executeUpdate();
//		}
//		else
//		{
//			System.out.println("LogIn Failed");
//		}
//		
//	} 
//	catch (Exception e) 
//	{
//		
//		e.printStackTrace();
//	}
//	
//}