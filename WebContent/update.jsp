<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 创建一个from表单
    -->
   <form action="${pageContext.request.contextPath}/ProductServlet" method="post">
        商品名称：<input type="text" name="name" value="${requestScope.product.name}"/><br />
        商品价格：<input type="text" name="price" value="${requestScope.product.price}"/><br />
        详细介绍：<textarea name="remark" rows="3" cols=50>${requestScope.product.remark}</textarea><br />
        <button type="submit">更新</button>
        <input type="hidden" name="type" value="update"/>
        <input type="hidden" name="id" value="${requestScope.product.id}"/>
        </form>
</body>
</html>