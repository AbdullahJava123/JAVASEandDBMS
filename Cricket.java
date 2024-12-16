package dbmsPrograms;
import java.sql.*;
public class Cricket 
{
  public static void main(String[] args)
  {
	 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","abdulla","abdoracle");
			Statement st=con.createStatement();
//			st.execute("Create table players(playername varchar2(15),jerseyno number(2))");
//			st.executeUpdate("insert into players values('Sravan',12)");
			ResultSet rs=st.executeQuery("select * from players");
			ResultSetMetaData ru=rs.getMetaData();
			int n=ru.getColumnCount();
			for(int i=1;i<=n;i++)
			{
				System.out.print(ru.getColumnName(i)+"\t");
			}
			System.out.println();
			while(rs.next())
			{
				for(int i=1;i<=n;i++)
				{
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			System.out.println("updated");
		}
	 catch (Exception e) {
		e.getStackTrace();
	}
  }
	
}
