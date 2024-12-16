package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudentTwo 
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter 1 to update and 2 to delete: ");
    	int no=sc.nextInt();
    	if(no==1)
    	{
    		update();
    	}
    	else if(no==2)
    	{
    		delete();
    	}
    	else
    	{
    		System.out.println("Invalid Input");
    	}
    	sc.close();
    }
    public static void update()
    {
    	
    	try
    	{
    		Scanner sc=new Scanner(System.in);
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
    	PreparedStatement ps=con.prepareStatement("update product set  name=? , price=? , qty=? where id=?");
    	System.out.println("======UPDATE PRODUCT TABLE=======");
    	System.out.println("Enter name: ");
    	String name=sc.nextLine();
    	ps.setString(1, name);
    	System.out.println("Enter Price: ");
    	int price=sc.nextInt();
    	ps.setInt(2, price);
    	System.out.println("Enter Quantity: ");
    	int qty=sc.nextInt();
    	ps.setInt(3,qty);
    	System.out.println("Enter ID: ");
    	int id=sc.nextInt();
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
    public static void delete()
    {
    	//Scanner sc=new Scanner(System.in);
    	try
    	{
    		Scanner sc=new Scanner(System.in);
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
    	PreparedStatement ps1=con.prepareStatement("delete from product where id=?");
    	System.out.println("======DELETE FROM TABLE=======");
    	System.out.println("Enter id to delete: ");
    	int id=sc.nextInt();
    	ps1.setInt(1, id);
    	int k1=ps1.executeUpdate();
    	if(k1>0)
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
}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class UpdateStudentTwo {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter 1 to update and 2 to delete: ");
//        int no = sc.nextInt();
//        if (no == 1) {
//            update();
//        } else if (no == 2) {
//            delete();
//        } else {
//            System.out.println("Invalid Input");
//        }
//
//        sc.close();
//    }
//
//    public static void update() {
//        try (Scanner sc = new Scanner(System.in);
//             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abdulla", "abdoracle")) {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            PreparedStatement ps = con.prepareStatement("update product set name=?, price=?, qty=? where id=?");
//
//            System.out.println("======UPDATE PRODUCT TABLE=======");
//            System.out.println("Enter name: ");
//            String name = sc.nextLine();
//            ps.setString(1, name);
//
//            System.out.println("Enter Price: ");
//            int price = sc.nextInt();
//            ps.setInt(2, price);
//
//            System.out.println("Enter Quantity: ");
//            int qty = sc.nextInt();
//            ps.setInt(3, qty);
//
//            System.out.println("Enter ID: ");
//            int id = sc.nextInt();
//            ps.setInt(4, id);
//
//            int rowsAffected = ps.executeUpdate();
//            System.out.println(rowsAffected + " rows updated.");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void delete() {
//        try (Scanner sc = new Scanner(System.in);
//             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abdulla", "abdoracle")) {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            PreparedStatement ps = con.prepareStatement("delete from product where id=?");
//
//            System.out.println("======DELETE FROM TABLE=======");
//            System.out.println("Enter id to delete: ");
//            int id = sc.nextInt();
//            ps.setInt(1, id);
//
//            int rowsAffected = ps.executeUpdate();
//            System.out.println(rowsAffected + " rows deleted.");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
