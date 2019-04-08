package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import jdk.nashorn.internal.ir.CatchNode;
// 此类是数据库连接的工具类,主要用来连接数据库，和关闭连接
public class JdbcUtils {

	// 静态块,仅仅执行一次
	static {
		System.out.println(".......");
		// 加载数据库的使用说明书(数据库驱动)
		// forName系统提供的静态方法,类直接调用。它的功能是根据类全名来加载相关资源
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 通过名字加载驱动
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// 此方法用来实现数据库的连接,并且返回连接对象
	public static Connection getConnection() {
		// 采用Java提供的工具类来连接数据库
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			System.out.println("连接成功...");
			return conn;
		} catch (SQLException e) {
			// 如果出錯會自動跳轉到catch语句，进行异常处理...
			System.out.println("连接异常...");
			throw new RuntimeException(e);
		}
	}


//	关闭数据库连接
	public static void closeDbConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	// 编写一个main方法测试数据库的连接
	public static void main(String[] args) {
		Connection con1 = JdbcUtils.getConnection();
		Connection con2 = JdbcUtils.getConnection();
		System.out.println(con1);
		System.out.println(con2);
	}
}