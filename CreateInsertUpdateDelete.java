package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class CreateInsertUpdateDelete 
{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	System.out.println("==============Create Table================");
	System.out.println("1) Enter 1 to CREATE table: ");
	System.out.println("2) Enter 2 to INSERT in table: ");
	System.out.println("3) Enter 3 to UPDATE table: ");
	System.out.println("4) Enter 4 to DELETE ROW: ");
	System.out.println("Enter a number: ");
	int no=sc.nextInt();
	if(no==1)
	{
		createTable();
	}
	else if(no==2)
	{
		insertInTable();
	}
	else if(no==3)
	{
		updateTable();
	}
	else if(no==4)
	{
		deleteFromTable();
	}
	else
	{
		System.out.println("Invalid Input");
	}
}

public static  void deleteFromTable() 
{
	Scanner sc=new Scanner(System.in);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("delete from school  where StuId=?" );
		System.out.println("Enter Id to delete data: ");
		int id=sc.nextInt();
		ps.setInt(1,id);
		int k=ps.executeUpdate();
		if(k>0)
    	{
    		System.out.println("One row deleted");
    	}
    	else
    	{
    		System.out.println("Delete operation failed");
    	}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void updateTable() {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("Update school set  StuName=?,StuAge=?,StuGrade=? where StuId=?" );
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("Enter age: ");
		int age=sc.nextInt();
		System.out.println("Enter Grade: ");
		char grade=sc.next().charAt(0);
		System.out.println("Enter Id to make changes: ");
		int id=sc.nextInt();
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, grade);
		ps.setInt(4, id);
		int k=ps.executeUpdate();
		if(k>0)
    	{
    		System.out.println("One row updated");
    	}
    	else
    	{
    		System.out.println("Update failed");
    	}
	}
	catch(Exception e)
	{
		e.getStackTrace();
	}
	
}
public static void insertInTable() {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		PreparedStatement ps=con.prepareStatement("insert into school values(?,?,?,?)");
		System.out.println("Enter StuId: ");
		int sid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("Enter age: ");
		int age=sc.nextInt();
		System.out.println("Enter Grade: ");
		char grade=sc.next().charAt(0);
		ps.setInt(1, sid);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, String.valueOf(grade));
		int k=ps.executeUpdate();
		if(k>0)
    	{
    		System.out.println("One row inserted");
    	}
    	else
    	{
    		System.out.println("Insert operation failed");
    	}
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void createTable() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
		Statement st=con.createStatement();
		st.execute("create table school(StuId number(20),StuName varchar2(20),StuAge number(5),StuGrade varchar2(2))");
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
}
}
