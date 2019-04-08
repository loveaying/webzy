package cn.hw.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hw.oa.service.ProductService;
import product.NewProduct;

//只要继承了HttpServlet,则就可以接受 Http请求（GET,POST）
//@开头的java中是注解，此处用来标识当前Servlet类的地址
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

private ProductService productService =new ProductService();

//	doPOST请求只能处理POST提交
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		if(type.equals("save")) {
//	        客户端提交给客户端的操作都被封装在request中
//		1.通过request 获取前端数据，并封装在newProduct对象中
		NewProduct newProduct=new NewProduct();
		newProduct.setName(request.getParameter("name"));
		String price = request.getParameter("price");
//	       把字符串转化成double
		newProduct.setPrice(Double.parseDouble(price));
		newProduct.setRemark(request.getParameter("remark"));
//		2.Servlet---Service---Dao 最终完成数据库的入库
		productService.save(newProduct);
//		3.跳转到查询页面
		response.sendRedirect("/web/query.jsp");
	}else if (type.equals("query")){
//        1、request从前端获取数据
        String keyword=request.getParameter("keyword");
//      2、把数据封装交给SERVICE某个方法
       ArrayList<NewProduct> proList=productService.queryByName(keyword);
//      3、重定向
       request.setAttribute("proList", proList);
//     response.sendRedirect("/web/query.jsp");
//     请求的转发
       RequestDispatcher requestDispatcher=request.getRequestDispatcher("/query.jsp");
       requestDispatcher.forward(request, response);
	}else if (type.equals("getById")){
	int id=Integer.parseInt(request.getParameter("id"));
	NewProduct product=productService.getById(id);
	request.setAttribute("product", product);
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update.jsp");
	requestDispatcher.forward(request, response);
	}else if (type.equals("update")) {
		
	}
	else {
		System.out.println("删除操作");
		int pid=Integer.parseInt(request.getParameter("pid"));
		productService.delete(pid);
	}
		
}
	
//	doGet请求只能处理get提交
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
       this.doPost(request, response);
	}	
}
