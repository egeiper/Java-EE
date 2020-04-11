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
<body style="background-image:url('resources/background.jpg')">
<div class="container" >

<div class="row">
	<div class="col-sm-4">
		<h1>Kişi Ekle</h1>
		<form action='<s:url value="cartInsert"></s:url>' method="post">
			
			<div class="form-group">
			    <input required="required" name="cname" type="text" class="form-control"  placeholder="Adı">
  			</div>
  			
  			<div class="form-group">
			    <input required="required"  name="csurname" type="text" class="form-control"  placeholder="Soyadı">
  			</div>
  			<div class="form-group">
			    <input required="required"  name="cmail" type="text" class="form-control"  placeholder="Email">
  			</div>
  			<div class="form-group">
  				<input name="cphone"  required="required"  class="form-control" type='tel' pattern='[0-9]{3}[0-9]{3}[0-9]{4}' maxlength="10"  title='Telefon No: 5556667788 '>
  			</div>
  			<div class="form-group">
			    <input required="required"  name="ctext" type="text" class="form-control"  placeholder="Not Ekle">
  			</div>
  			<div class="form-group">
			    <select name="cid" class="form-control">
			    <c:if test="${ not empty catData }">
			    	<c:forEach items="${catData }"  var="item" >
			    		<option value="${item.cid }">${item.ctitle }</option>
			    	</c:forEach>
			    </c:if>
			    </select>
			  </div>
			  
			<button type="submit" class="btn btn-success">Kaydet</button>
			
		</form>
		
	</div>
	<div class="col-sm-8">
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">İsim</th>
		      <th scope="col">Soyisim</th>
		      <th scope="col">Telefon</th>
		      <th scope="col">Kategori</th>
		      
		      <th scope="col">Mail</th>
		      <th scope="col">Not</th>
		      <th scope="col">İşlem</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:if test="${not empty tableData }">
		  	<c:forEach items="${tableData }" var="item">
			    <tr>
			      <th>${item.crid }</th>
			      <td>${item.cname }</td>
			      <td>${item.csurname }</td>
			      <td>${item.cphone }</td>
			      <td>${item.ctitle }</td>
			         <td>${item.cmail }</td>
			            <td>${item.ctext }</td>
			      <td>
			      	<a href="updatePage/${ item.crid }" class="btn btn-info">Düzenle</a>
			      </td>
			     <td><form action="delete/${item.crid }" method="post">
	<input type="submit" class="btn btn-danger" value="Sil" />
</form></td>
			     
			      
			    </tr>
		    </c:forEach>
		 </c:if>
		    
		    
		  </tbody>
		</table>
	</div>
</div>
<div class="row">

<div class="col sm-3">

</div>
<div class="col sm-3">

</div>
<div class="col sm-3">

</div>
<div class="col sm-3">
<form action="exit" method="get">
	<input type="submit" class="btn btn-danger btn-lg" value="Çıkış" />
</form>
</div>
</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</html>