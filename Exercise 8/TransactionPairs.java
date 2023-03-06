package jdbc;

import java.sql.*;

public class TransactionPairs {
	public static void main(String args[]) {
		Connection connection = null;
		Statement statement;
		PreparedStatement updateSales;
		PreparedStatement updateTotal;
		String updateString = "update COFFEES set SALES = ? where COF_NAME like ?";
		String updateStatement = "update COFFEES set TOTAL = TOTAL + ? where COF_NAME like ?";
		String query = "select COF_NAME, SALES, TOTAL from COFFEES";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/ace2023", "root", "Pass@123");
			updateSales = connection.prepareStatement(updateString);
			updateTotal = connection.prepareStatement(updateStatement);
			int[] salesForWeek = { 175, 150, 60, 155, 90 };
			String[] coffees = { "Colombian", "French_Roast", "Espresso", "Colombian_Decaf", "French_Roast_Decaf" };
			int len = coffees.length;
			connection.setAutoCommit(false);
			for (int i = 0; i < len; i++) {
				updateSales.setInt(1, salesForWeek[i]);
				updateSales.setString(2, coffees[i]);
				updateSales.executeUpdate();
				updateTotal.setInt(1, salesForWeek[i]);
				updateTotal.setString(2, coffees[i]);
				updateTotal.executeUpdate();
				connection.commit();
			}
			updateSales.close();
			updateTotal.close();

			connection.setAutoCommit(true);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String c = rs.getString("COF_NAME");
				int s = rs.getInt("SALES");
				int t = rs.getInt("TOTAL");
				System.out.println(c + " " + s + " " + t);
			}
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			if (connection != null) {
				try {
					System.err.println("Transaction is being rolled back");
					connection.rollback();
				} catch (SQLException excep) {
					System.err.print("SQLException: ");
					System.err.println(excep.getMessage());
				}
			}
		}
	}
}