package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class account {
	private long amount ;
	String sql;
	int n;
	public int checkAmount() throws ClassNotFoundException, SQLException {
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/csnm";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt = conn.createStatement();
		sql="SELECT balance FROM account";
		ResultSet rs = stmt.executeQuery(sql);
		int id = rs.getInt("balance");
		return id;
		
		
	}
	public int withdraw(int n) throws ClassNotFoundException, SQLException
	{
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/csnm";
		Connection conn = DriverManager.getConnection(url,"root","");
		Statement stmt = conn.createStatement();
		sql="UPDATE account SET balance = "+n+"WHERE name = Võ Hồng Nga";
		int result = stmt.executeUpdate(sql);
		 return result;

	}
	public boolean trans(long n) {
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(true) {
			amount = amount-n;
			return true;
		}
		return false;
		
	}
	public boolean add(long n) {
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		amount += n;
		return true;
	}
	public long getAmount() {
		return this.amount;
	}
	public void setAmount(long n) {
		this.amount = n;
	}
}
