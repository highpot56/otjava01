package ot.otjava01.db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try{
			postgres();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void postgres() throws Exception{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try{
			// 接続
			String uri = "jdbc:postgresql://localhost:5433/testdb1";
			String user = "postgres";
			String password = "Administrator";
			con = DriverManager.getConnection(uri,user,password);
			st = con.createStatement();

			// SQLの発行
			String sql = "select * from T01";
			rs = st.executeQuery(sql);

			while(rs.next()){
				// 1列目の出力
				System.out.println(rs.getString(1));
			}
		}finally{
			rs.close();
			st.close();
			con.close();
		}
	}

}
