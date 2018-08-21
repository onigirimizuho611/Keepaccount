package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Keepaccount;

public class KeepaccountDao{

public static void DataDAO(String key2 , String key3) {
	// TODO 自動生成されたメソッド・スタブ
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/keepaccount?useSSL=false",
				"root",
				"sukonnbu611");

		String sql = "INSERT INTO keepaccount(income,spending) VALUES(?,?);";

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
	}}

public static ArrayList<Keepaccount> getAllList() {
	// TODO 自動生成されたメソッド・スタブ
	ArrayList<Keepaccount> resultList = new ArrayList<Keepaccount>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs  = null;

	try {

		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/keepaccount?useSSL=false",
				"root",
				"sukonnbu611");

		String sql = "SELECT * FROM keepaccount;";

		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		while(rs.next() ==true){
			String income = rs.getString("income");
			String spending = rs.getString("spending");

			Keepaccount keepaccount = new Keepaccount(income,spending);

			resultList.add(keepaccount);
		}

	} catch(ClassNotFoundException e){
		System.out.println("JDBCドライバが見つかりません");
		e.printStackTrace();
	} catch(SQLException e){
		System.out.println("DBアクセス時にエラーが発生しました");
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) {
				pstmt.close();
			}
		} catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();
		}
		try {
			if(con != null){
				con.close();
			}
		} catch(SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました");
			e.printStackTrace();
		}
	}
	return resultList;
}}