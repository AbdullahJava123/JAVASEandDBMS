package dbmsPrograms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionDbms1
{
	private static Connection con;
	public static void connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			totEmp();
			getNameById(103);
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
		CallableStatement cs=con.prepareCall("{?=call  GETEMPNAME(?)}");
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
}/*
SELECT object_name
    FROM user_objects
    WHERE object_type = 'FUNCTION';

SELECT text
FROM user_source
WHERE name = 'GETTOTALEMPLOYEES'
ORDER BY line;

*/
/*
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionDbms1
{
	private static Connection con;
	public static void connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			totEmp();
			getNameById(103);
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



function getEmpName(empid in Number) return varchar is
empName varchar2(30);
begin
select empname into empName from emp_info where empid=empid;
return empName;
end;

6 rows selected.

SQL> SELECT text
   FROM user_source
   WHERE name = 'GETEMPNAME'
   ORDER BY line;

TEXT
--------------------------------------------------------------------------------
function getTotalEmployees
return number
is
totEmp number;
begin
select count(*) into totEmp from emp_info;
return totEmp;
END;




CREATE OR REPLACE FUNCTION GETEMPNAME(emp_id IN NUMBER) RETURN VARCHAR2 IS
  2    emp_name VARCHAR2(100);
  3    CURSOR emp_cursor IS
  4      SELECT empname FROM emp_info WHERE empid = emp_id;
  5  BEGIN
  6    OPEN emp_cursor;
  7    FETCH emp_cursor INTO emp_name;
  8    IF emp_cursor%FOUND THEN
  9      CLOSE emp_cursor;
 10      RETURN emp_name;
 11    ELSE
 12      CLOSE emp_cursor;
 13      RETURN 'No such employee';
 14    END IF;
 15  EXCEPTION
 16    WHEN NO_DATA_FOUND THEN
 17      RETURN 'No such employee';
 18    WHEN OTHERS THEN
 19      CLOSE emp_cursor;
 20      RETURN 'Error occurred';
 21* END;
*/