package com.book_manage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	//鍔犺浇鏁版嵁搴撻┍鍔�-->鏁版嵁搴撹繛鎺�-->鎵цSql璇彞-->杩斿洖缁撴灉璁板綍闆�
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		try{
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/book_manage_system?useUnicode=true&characterEncoding=UTF-8&useSSL = false&serverTimezone = GMT","root","useroot");
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
//	public static Connection getCon() {
//		String url="jdbc:mysql://127.0.0.1:3306/book_manege_system?useUnicode=true&characterEncoding=UTF-8";
//		String username="root";
//		String password="root";
//		try {
//			Connection conn=DriverManager.getConnection(url, username, password);
//			return conn;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}	
//	}

}
