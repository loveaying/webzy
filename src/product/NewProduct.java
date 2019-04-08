package product;


import java.sql.Date;




public class NewProduct extends Object {
private int id;
private String name;
private double price;
private String remark;
private Date date ;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "NewProduct [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
			+ "]";
}


/*public void save(String name, double price, String remark) {
		Connection conn = JdbcUtils.getConnection();
		try {
			PreparedStatement pre = conn.prepareStatement("insert into product(name,price,remark) value(?,?,?)");
			pre.setString(1, name);
			pre.setDouble(2, price);
			pre.setString(3, remark);
			pre.executeUpdate();
			System.out.println("插入成功....");
		} catch (SQLException e) {
			System.out.println("插入异常....");
			throw new RuntimeException(e);
		} finally {
			System.out.println("关闭数据库连接都会执行....");
			JdbcUtils.closeDbConn(conn);
		}
	}
*/

	/*public static void main(String[] args) {
		NewProduct  newPro =new NewProduct();
		newPro.name="OPPO2";
		newPro.price=4000;
		newPro.remark="欧珀2";
		newPro.save(newPro);
	}
	*/
}
