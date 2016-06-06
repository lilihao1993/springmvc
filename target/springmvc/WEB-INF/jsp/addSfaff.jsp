<%@ page  pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
	<head>
		<meta charset="utf-8">
		<link href="../css/bootstrap.min.css" rel="stylesheet"> 
		<script src="../js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container text-center" >
		<form action="add" class="form" method="post">
			<div class="form-group ">
				<label>姓名：</label>
				<input type="text" placeholder="" name="name" ></input>
			</div>
			
			<div class="form-group">
				<label>年龄：</label>
				<input type="text" placeholder="" name="age" ></input>
			</div>
			
			<div class="form-group">
				<label>职业：</label>
				<input type="text" placeholder="" name="job"></input>
			</div>
			<div class="form-group">
				<button class="btn btn-default">添加员工</button>
			</div>
			
		</form>
	</div>
	</body>
</html>