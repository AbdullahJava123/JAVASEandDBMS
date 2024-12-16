package dbmsPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

public class DataProduct 
{
     public static void main(String[] args)
     {
    	 try {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
    	 PreparedStatement ps=con.prepareStatement("select * from product");
    	 ResultSet rs=ps.executeQuery();
    	 ResultSetMetaData rm=rs.getMetaData();
    	 int c=rm.getColumnCount();
    	 for(int i=1;i<=c;i++)
    	 {
    		 System.out.print(rm.getColumnName(i)+"\t");
    	 }
    	 System.out.println();
    	 while(rs.next())
    	 {
    		 for(int i=1;i<=c;i++)
    		 {
    			 System.out.print(rs.getString(i)+"\t");
    		 }
    		 System.out.println();
    	 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.getStackTrace();
    	 }
    	 
     }
}
