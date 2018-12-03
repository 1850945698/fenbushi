<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="editProduct2" method="post" >
		<input type="hidden" name="id" value="${user.book_id }" />
	    书籍名称：<input type="text" name="name" value="${user.book_name }"/><br>
	    作者：<input type="text" name="description" value="${suer.author }"/><br>
	    出版社：<input type="text" name="price" value="${user.press }"/><br>
	    <input type="submit" value="修改">
	</form>
</body>
</html>