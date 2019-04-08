package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import product.NewProduct;

public class BaseDao {
	
	protected void update(String sql,Object[] params) {
		Connection conn0 = JdbcUtils.getConnection();
		try {
			PreparedStatement pre = conn0.prepareStatement(sql);
//			pre.setString(1, id);
			for(int i = 0;i < params.length;i++) {
				pre.setObject(i + 1, params[i]);
			}
			pre.executeUpdate();
		} catch (SQLException e) {
			System.out.println("异常....");
			throw new RuntimeException(e);
		} finally {
			System.out.println("0.关闭数据库连接都会执行....");
			JdbcUtils.closeDbConn(conn0);
		}
	}
}
