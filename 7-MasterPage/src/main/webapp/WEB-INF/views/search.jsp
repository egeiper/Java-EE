<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Jumbotron Template for Bootstrap</title>
	<c:import url="/css"></c:import>
  </head>
  <body>

	<c:import url="/navbar"></c:import>
    <main role="main">
      <div class="container">
		
		<c:if test="${ not empty cls }">
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">crid</th>
		      <th scope="col">cname</th>
		      <th scope="col">cname</th>
		      <th scope="col">cphone</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:forEach items="${ cls }" var="item" >
			    <tr>
			      <th scope="row">${ item.crid }</th>
			      <td>${ item.cname }</td>
			      <td>${ item.cname }</td>
			      <td>${ item.cphone }</td>
			    </tr>
		    </c:forEach>
		    
		  </tbody>
		</table>
		</c:if>

      </div>
    </main>
    <c:import url="/footer"></c:import>
	<c:import url="/js"></c:import>
    
  </body>
</html>
    