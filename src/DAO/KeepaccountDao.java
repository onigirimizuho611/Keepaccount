package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Keepaccount;

public class KeepaccountDao {

	 final int a = 1110;

	private static ArrayList<Keepaccount> resultList;
	private static Keepaccount result;

	public static ArrayList<Keepaccount> getAllKeeoaccount() {
		return resultList;
	}

	public static ArrayList<Keepaccount> getAllKeepaccount(){

		Connection con = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		ArrayList<Keepaccount> result = new ArrayList<Keepaccount>();

		try{
			Class.forName("con.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/friends?useSSL=false",
				"root",
				"sukonnbu611");

			String sql = "SELECT * FROM keepaccount";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				int spending = rs.getInt("spending");
				int income = rs.getInt("income");

				Keepaccount keepaccount = new Keepaccount(spending,income);

				result.add(keepaccount);
			}
		} catch (SQLException e) {
			System.out.println("DBアクセスに失敗しました！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません");
			e.printStackTrace();
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生します");
				e.printStackTrace();
			}
			try {
				if( pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DB切断時にエラーが発生しました");
				e.printStackTrace();
			}
			try {
				if( con != null) {
					con.close();
				}
			} catch(SQLException e) {
				System.out.println("DB切断時にエラーが発生しました");
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void InsertKeepaccount(int spending , int income) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/friends?useSSL=false",
					"root",
					"sukonnbu611");

			String sql = "INERT INTO keepaccount(spending,income) VALUES(?,?);";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, spending);
			pstmt.setInt(2, income);

			result = pstmt.executeUpdate();
			System.out.println(result);

		} catch(SQLException e){
			System.out.println("DBアクセスが完了しました");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				 if(pstmt != null){
					 pstmt.close();
				 }
			}catch (SQLException e) {
				System.out.println("DB切断時にエラーが発生しました");
				e.printStackTrace();
			}
		}try{
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("DB切断時にエラーが発生しました");
			e.printStackTrace();
		}

		}
	}
