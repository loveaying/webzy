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
        商品名称：<input type="text" name="name" /><br />
        商品价格：<input type="text" name="price" /><br />
        详细介绍：<textarea name="remark" rows="3" cols=50></textarea><br />
        <button type="submit">提交</button>
        <input type="hidden" name="type" value="save"/>
        </form>
</body>
</html>