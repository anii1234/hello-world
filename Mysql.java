import java.sql.*;
import java.io.*;

class Mysql
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url="jdbc:mysql://localhost:3307/school?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs=stmt.executeQuery("select * from student");
			
			System.out.println("name   |  rollno  ");
			while(rs.next())
			{
				String n=rs.getString("name");
				int r=rs.getInt("rollno");
				System.out.println(n+"\t"+r);
			}
			Console c=System.console();
			int roll;
			String nam;
			System.out.println("enter name");
			nam=c.readLine();
			
			System.out.println("enter rollno");
			roll=Integer.parseInt(c.readLine());
			
			String insert_query="insert into student(name,rollno)"+"values('"+nam+"',"+roll+")";
			
			stmt.execute(insert_query);
			
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n\nException:\n"+e.getMessage());
		}
	}
}