package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import product.NewProduct;

public class ProductDao extends BaseDao{

	// 插入
	public void save(NewProduct npro) {
		String sql="insert into product (name,price,remark) values (?,?,?)";
		super.update(sql, new Object[] {npro.getName(),npro.getPrice(),npro.getRemark()});
	}

	// 更新
	public void update(NewProduct nPro0) {
		String sql="update product set name=?,price=?,remark=? where id=?";
		super.update(sql, new Object[] {nPro0.getName(),nPro0.getPrice(),nPro0.getRemark(),nPro0.getId()});
	}

	// 删除
	public void delete(int id) {
		String sql="delete from product where id = ?";
		super.update(sql, new Object[] {id});
	}

	// 查询有两种，根据name/price查询
	public NewProduct getById(int id) {
		// 1.获取Connetion对象
		Connection conn2 = JdbcUtils.getConnection();
		// 2.创建PreparedStatement对象进行预编译SQL语句
		try {
			PreparedStatement pre = conn2.prepareStatement("select * from product where id= ?");
			// 3.根据参数的类型进行赋值操作
			pre.setInt(1, id);
			// 4.根据select正常应一条记录（记录--对象）
			ResultSet rs = pre.executeQuery();
			NewProduct npro1 = null;
			if (rs.next()) {
				npro1 = new NewProduct();
				// 说明查询结果有记录，应创建一个对象来保存当前记录
				npro1.setId(rs.getInt("id"));
				npro1.setName(rs.getString("name"));
				npro1.setPrice(rs.getDouble("price"));
				npro1.setRemark(rs.getString("remark"));
			}
			// 5.关闭连接
			// 6.返回查询的对象（如果没有查询到则返回Null）
			return npro1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("2.关闭数据库连接都会执行....");
			JdbcUtils.closeDbConn(conn2);
		}
	}

	public ArrayList<NewProduct> queryByName(String name) {
		Connection conn3 = JdbcUtils.getConnection();
		PreparedStatement pre;
		try {
			pre = conn3.prepareStatement("select * from product where name like ?");
			pre.setString(1, "%" + name + "%");
			ResultSet rs2 = pre.executeQuery();
			ArrayList<NewProduct> proList = new ArrayList<NewProduct>();
			while (rs2.next()) {
				// 每条记录都是一个Product对象
				NewProduct npro2 = new NewProduct();
				npro2.setId(rs2.getInt("id"));
				npro2.setName(rs2.getString("name"));
				npro2.setPrice(rs2.getDouble("price"));
				npro2.setRemark(rs2.getString("remark"));
				npro2.setDate(rs2.getDate("date"));
				proList.add(npro2);
			}
			return proList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("3.关闭数据库连接都会执行....");
			JdbcUtils.closeDbConn(conn3);
			;
		}

	}

	public static void main(String[] args) {
		ProductDao pDao = new ProductDao();
		// 插入测试
		// pDao.save("华为手机", 6688,"测试一下");
		NewProduct nPro = new NewProduct();
		nPro.setName("oppo2");
		nPro.setPrice(3000);
		nPro.setRemark("插入测试");
		pDao.save(nPro);
		// 更新测试
		NewProduct nPro0 = new NewProduct();
		nPro0.setName("oppo2");
		nPro0.setPrice(3000);
		nPro0.setRemark("更新测试");
		nPro0.setId(13);
		pDao.save(nPro0);
		// 删除测试
    	pDao.delete(4);
		// 单个查询测试
		System.out.print(pDao.getById(13));
		// 多个查询测试
		ArrayList<NewProduct> proList = pDao.queryByName("oppo");
		for (NewProduct temp : proList) {
			System.out.println(temp);
		}
	}
}
