<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示图书</title>
</head>
<body>
<h1 align="center">图书列表</h1>
   <c:if test="${empty(cart.map) }"> 
        您还没添加任何图书
   </c:if>
   <c:if test="${!empty(cart.map) }"> 
       <table border="3" align="center">
       	 <tr>
       	     <td>序号</td>
       	     <td>书籍名称</td>
       	     <td>作者</td>
       	     <td>出版社</td>
       	     <td>数量</td>
       	 </tr>
       	  <c:forEach items="${cart.map}" var="entry">
       	  <tr>
       	  <td>${entry.value.user.book_id}</td>
       	  	  <td>${entry.value.user.book_name}</td>
       	      <td>${entry.value.user.author}</td>
       	     <td>${entry.value.user.press}</td>
       	      <td><input type="text" name="count" value="${entry.value.count}" style="width: 20"/></td>
       	  </tr> 
       	  </c:forEach>
         
       </table>
   </c:if>
</body>
</html>