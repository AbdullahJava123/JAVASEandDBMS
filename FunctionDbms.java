package dbmsPrograms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionDbms 
{
	private static Connection con;
	public static void connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			totEmp();
			getNameById(101);
		} 
		  catch (Exception e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void totEmp() throws SQLException
	{
		CallableStatement cs=con.prepareCall("{?=call getTotalEmployees}");
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		int totEmp=cs.getInt(1);
		System.out.println("Total Employees: "+totEmp);
	}
	public static void getNameById(int empId) throws SQLException
	{
		CallableStatement cs=con.prepareCall("{?=call  getEmpName(?)}");
		cs.registerOutParameter(1, Types.VARCHAR);
		cs.setInt(2, empId);
		cs.execute();
		String name=cs.getString(1);
		System.out.println("Name of Employee with EMPID "+empId+" is: "+name);
	}
  public static void main(String[] args)
  {
	  connect();
  }
}
