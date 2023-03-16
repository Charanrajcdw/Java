package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	public DBUtility() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	
	public static Connection getConnection() {
		Connection con=threadLocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost/daoProject","root","Pass@123");
				con.setAutoCommit(false);
				threadLocal.set(con);
				return con;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		else {
			return con;
		}
	}
	
	public static void closeConnection(Exception e) {
		Connection con=threadLocal.get();
		if(con!=null) {
			try {
				if(e==null)
					con.commit();
				else
					con.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}finally {
				try {
					con.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				threadLocal.remove();
			}
		}
	}
}
