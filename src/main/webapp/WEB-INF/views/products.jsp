<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Available Products</h1>
<ul>
    <c:forEach var="product" items="${products}">
        <li>${product.title} - ${product.cost} UAH</li>
    </c:forEach>
</ul>
</body>
</html>
