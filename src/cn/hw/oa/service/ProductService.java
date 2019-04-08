package cn.hw.oa.service;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import cn.hw.oa.dao.ProductDao;
import product.NewProduct;

//业务逻辑层（java类），以后会添加购物车的业务逻辑代码
public class ProductService {
//	执行完业务逻辑层后还需要调用数据库访问层入库
	private ProductDao productDao =new ProductDao();
	
	public void save(NewProduct newProduct) {
		productDao.save(newProduct);
	}

	public void update(NewProduct newProduct) {
		productDao.update(newProduct);
	}
	
	public NewProduct getById(int id) {
		return productDao.getById(id);
	}
	
	public void delete(int id) {
		productDao.delete(id);
	}
	
	public ArrayList<NewProduct> queryByName(String name) {
		return productDao.queryByName(name);
	}
}
