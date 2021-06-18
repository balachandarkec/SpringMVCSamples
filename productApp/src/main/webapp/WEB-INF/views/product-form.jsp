<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>

<h2>Add New Product!</h2>

<form action="addProduct" method="post">
<label for="name">Product Name :</label>
<input name="name" type="text" />
<label for="price">Product Price :</label>
<input name="price" type="text" />
<label for="quantity" > Quantity:</label>
<input name="quantity" type="text" />
<br />

<input type="submit" value="Add Product">


</form>



</body>
</html>