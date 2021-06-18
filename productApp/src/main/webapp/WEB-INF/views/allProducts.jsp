<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head> <%@page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> All Products</h2>
<ul>
<c:forEach var="product" items="${products}">
  <li>${product.name} , ${product.price}, -- ${product.quantity} </li>


</c:forEach>
</ul>

</body>
</html>