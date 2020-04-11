<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" >

<div class="row">
	<div class="col-sm-4">
		<h1>Araba Ekle</h1>
		<form action="carInsert" method="post">
			<input name="title" type="text" class="form-control" placeholder="Başlık" />
			<br/><input name="price" type="number" required="required" class="form-control" placeholder="Fiyat" />
			<br/><input name="img" type="text" class="form-control" placeholder="Resim URL" />
			<br/><input type="submit" value="Kaydet" class="btn btn-success" />
		</form>
	</div>
	<div class="col-sm-8">
		<h1>Araba Listesi</h1>
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Başlık</th>
		      <th scope="col">Fiyat</th>
		      <th scope="col">Resim</th>
		      <th scope="col">Sil</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:if test="${ not empty data }">
		  	<c:forEach items="${ data }" var="item">
			    <tr>
			      <th scope="row">${item.id }</th>
			      <td>${item.title }</td>
			      <td>${item.price }</td>
			      <td>
			      <img src="${item.img }"  width="100" class="img-responsive" />
			      </td>
			      <td>
			      	<a href='<s:url value="/delete/${item.id }"></s:url>' class="btn btn-danger">Sil</a>
			      </td>
			    </tr>
			</c:forEach>
		  </c:if>
		    
		  </tbody>
		</table>
		
	</div>
</div>



</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</html>