<%@page import="com.pavan.servlets.ProductDao" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<title>Product List</title>
	<link rel="stylesheet" 
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
		
	<body>
	<div>
	<h1 class="text text-success text-center">List of Available Products</h1>
	</div>
	
	<div>
		<a class="btn btn-success"
		href="product.html"> Save Product
		</a>
	</div>
	
	<div>
			<input type="text" placeholder="Search"/>
	</div>
	
	<div>
	<c:if test="${SaveResult==1}">
		<h1 class="text-danger text-center">
			Data Inserted Successfully
		</h1>
	</c:if>
	</div>
	
	<div>
	<c:if test="${deleteresult==1}">
		<h1 class="text-danger text-center">
			Data Deletion Successfull
		</h1>
	</c:if>
	</div>
	
	<div>
	<c:if test="${deleteresult==0}">
		<h1 class="text-danger text-center">
			Data Deletion Fail
		</h1>
	</c:if>
	</div>
		<table class="table table-bordered table-striped">
		<thead class="thead-dark">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Cost</th>
			<th>Product Brand</th>
			<th>Made IN</th>
			<th>Manufacture Date</th>
			<th>ExpiryDate</th>
			<th>Image</th>
			<th>Actions</th>
			<th>Audio</th>
			<th>Video</th>			
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="product" items="<%= ProductDao.findAll()%>">
			<tr>
				<td>${product.proId}</td> 	
				<td>${product.proName}</td>
				<td>${product.proPrice}</td>
				<td>${product.proBrand}</td>
				<td>${product.proMadeIn}</td>
				<td>${product.proMnfgDate}</td>
				<td>${product.proExpDate}</td>
				<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="product Image"
						style="max-width:100px; max-height:100px;">
				</td>
				<td> 
					<a class="btn btn-primary" href="./DeleteServlet?proId=${product.proId}">Delete</a>
					<a class="btn btn-primary" href="./EditServlet?proId=${product.proId}">Edit</a>
				</td>
				<td> 
					<audio controls>
						<source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mpeg">
					</audio>
				</td>
				<td> 
					<video controls width="320" height="240">
						<source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4">
					</video>
				</td>		
			</tr>
		</c:forEach>
		
		</tbody>
		</table>
	</body>
</html>