<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit product</title>
<!-- BootStrap CDN link to get the support of BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet"><!-- This is java script validation code location -->
<script src="formvalidation.js"></script>
</head>
<body>
	<form method="post" action="UpdateServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
		<div class="container mt-5 text-center">
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proId">PRODUCT ID:</label>
		<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingproduct.proId}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proName">PRODUCT NAME:</label>
		<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingproduct.proName}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proPrice">PRODUCT PRICE:</label>
		<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingproduct.proPrice}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proBrand">PRODUCT BRAND:</label>
		<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingproduct.proBrand}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proMadeIn">PRODUCT MADE IN:</label>
		<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingproduct.proMadeIn}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proMnfgDate">PRODUCT MNFG DATE:</label>
		<input type="date" class="form-control-sm" id="proMnfgDate" name="proMnfgDate" value="${existingproduct.proMnfgDate}" required>
		</div>
		
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proExpDate">PRODUCT EXP DATE:</label>
		<input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingproduct.proExpDate}" required>
		</div>
		
		 
		<div class="form-group">
		<label class="font-italic font-weight-bold" for="proImage">Current PRODUCT IMAGE:</label>
		<img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" alt="product Image"
						style="max-width:100px; max-height:100px;">
		<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingproduct.proImage)}"/>
		</div>
		
		<div class="form-group">
			<label class="font-italic font-weight-bold" for="newProImage">New product image:</label>
			<input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">	
		</div>
		<div>
		<input type="submit" class="btn btn-primary" value="Update">
		</div>
		</div>
	</form>


</body>
</html>