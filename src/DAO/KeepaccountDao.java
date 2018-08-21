package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KeepaccountDao{

public static void DataDAO(String key2 , String key3) {
	// TODO 自動生成されたメソッド・スタブ
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/friends?useSSL=false",
				"root",
				"sukonnbu611");

		String sql = "INSERT INTO keepaccount(income,spending) VALUES(?,?)";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1,key2);
		pstmt.setString(2,key3);

		pstmt.executeUpdate();

	}catch (ClassNotFoundException e){
		System.out.println("JDBCドライバが見つかりません");
		e.printStackTrace();
	} catch (SQLException e){
		System.out.println("DBアクセス時にエラーが発生しました");
		e.printStackTrace();
	}finally {

		try{
			if(pstmt != null){
				pstmt.close();
			}
		} catch(SQLException e){
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();
		}
		try {
			if (con != null){
				con.close();
			}
		} catch (SQLException e){
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();
		}
	}}}