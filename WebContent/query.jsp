<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){

	$('.btnDel').click(function(){
		alert("test")
		var pid=$(this).attr('lang')
		$.get('/web/ProductServlet',{type:'delete',pid:pid})
		$(this).parents("tr:first").remove()
	})
})
</script>
</head>
<body>
  <!-- http请求只有两种 ，get请求信息时通过url地址传输-->
  <form action="${pageContext.request.contextPath}/ProductServlet" method="get">
    给我搜：<input type="text" name="keyword"/><button type="submit">搜索</button>
  <input type="hidden" name="type" value="query"/>
  </form>
  <c:if test="${not empty requestScope.proList}"> 
  <h3>下面是查询的结果</h3>
  <table border="1"width="600px">
     <tr>
        <th>编号</th>
        <th>商品名</th>
        <th>价格</th>
        <th>备注</th>
        <th>操作</th>
     </tr>
   <c:forEach items="${requestScope.proList}" var="product" varStatus="num">
     <tr>
        <td>${num.count}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.remark}</td>
        <td>
        <button type="button" class="btnDel" lang="${product.id}">AJAX删除</button>
        |<a href="${pageContext.request.contextPath}/ProductServlet?type=getById&id=${product.id}">查询后更新</a></td>
     </tr>
   </c:forEach>
</table>
</c:if>
</body>
</html>