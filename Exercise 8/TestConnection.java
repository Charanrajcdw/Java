package jdbc;

import java.sql.*;

class MakeConnection {
	Connection connection;
	Statement statement;
	ResultSet result;

	MakeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ace2023", "root", "Pass@123");
			statement = connection.createStatement();
			
			int output = statement.executeUpdate("create table pradeep(empno integer,ename varchar(20),deptno integer)");
			System.out.println(output);
			
			statement = connection.createStatement();
			int output1 = statement.executeUpdate(" insert into pradeep values (001,'sakre',23)");
			int output2 = statement.executeUpdate(" insert into pradeep values (001,'pradeep',223)");
			int output3 = statement.executeUpdate(" insert into pradeep values (001,'vivek',243)");
			System.out.println(output1+" "+output2+" "+output3);
			
			result = statement.executeQuery("select * from pradeep");
			while (result.next())
				System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class TestConnection {
	public static void main(String args[]) {
		new MakeConnection();
	}
}