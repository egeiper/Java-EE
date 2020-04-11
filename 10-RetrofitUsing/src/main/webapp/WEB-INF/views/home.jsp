<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:if test="${  not empty ls }">
	<c:forEach items="${ls }" var="item">
		<h1>${ item.productName }</h1>
	</c:forEach>
</c:if>

</body>
</html>
