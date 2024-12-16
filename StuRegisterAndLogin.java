package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class StuRegisterAndLogin 
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("==========STUDENT INFORMATION===========");
	   System.out.println("Enter 1 To Register New Student ");
	   System.out.println("Enter 2 To LOGIN");
	   System.out.println("Enter a number to proceed: ");
	   int no=sc.nextInt();
	   switch(no)
	      {
	   case 1: insertStudent(); break;
	   
	   case 2: findStudentInDB();break;
	   
	   
		default:   System.out.println("Invalid Input");
		   
	      }
	}
   
private static void findStudentInDB() 
{
	Scanner sc=new Scanner(System.in);
	try 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("select count(*) from studentdetails where rollno=? and name=?");
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rm=rs.getMetaData();
		int co=rm.getColumnCount();
		System.out.println("Enter RollNo: ");
		int rollno=sc.nextInt();
		ps.setInt(1, rollno);
		sc.nextLine();
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		ps.setString(2, name);
		while(rs.next())
		{
			boolean rn=false;
			boolean nm=false;
			for(int i=1;i<=co;i++)
			{
				if(rollno==rs.getInt(i))
				{
					rn=true;
				}
				if(name.equals(rs.getString(2)))
				{
					nm=true;
				}
			}
			if(rn==true && nm==true)
			{
				ps.executeQuery("select count(*) from studentdetails where percentage>60 ");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getLong(5));
				}
				ps.executeUpdate("update studentdetails set mailId=?,phno=? where rollno=?");
				System.out.println("Enter mailId: ");
				String mailId=sc.nextLine();
				ps.setString(1, mailId);
				System.out.println("Enter phno: ");
				long phno=sc.nextLong();
				ps.setLong(2, phno);
				System.out.println("Enter Id to make changes: ");
				int rollno1=sc.nextInt();
				ps.setInt(3, rollno1);
			
				
			}
			else
			{
				System.out.println("Wrong Rollno or Name Entered");
			}
			
		}
		
	} 
	catch (Exception e) 
	{
		
		e.printStackTrace();
	}
	
	
}

private static void insertStudent() 
{
	Scanner sc=new Scanner(System.in);
	try 
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("insert into studentdetails values(?,?,?,?,?)");
		System.out.println("Enter roll number: ");
		int rollno=sc.nextInt();
		ps.setInt(1, rollno);
		sc.nextLine();
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		ps.setString(2, name);
		System.out.println("Enter Percentage: ");
		int perc=sc.nextInt();
		ps.setInt(3, perc);
		sc.nextLine();
		System.out.println("Enter mail Id: ");
		String mailId=sc.nextLine();
		ps.setString(4, mailId);
		System.out.println("Enter phone no: ");
		long phno=sc.nextLong();
		ps.setLong(5, phno);
		ps.executeUpdate();
	} 
	catch (Exception e) 
	{
		
		e.printStackTrace();
	}
	
}
}
