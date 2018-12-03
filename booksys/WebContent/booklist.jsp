<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booklist</title>
</head>
<body>
<table border="1px">
	<tr>
		<td>序号</td>
		<td>书籍名称</td>
		<td>作者</td>
		<td>出版社</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page}" var="p">
	<tr>
	    <td>${p.book_id}</td>
		<td>${p.book_name}</td>
		<td>${p.author}</td>
	
		<td>${p.press}</td>
		<td><a href="CartServlet?book_id=${p.book_id}">添加</a></td>
	</tr>
	</c:forEach>

</table>	
</body>
</html>