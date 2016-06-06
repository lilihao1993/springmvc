<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
   <head>
		<meta charset="utf-8">
		<link href="../css/bootstrap.min.css" rel="stylesheet"> 
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/jquery.min.js" ></script>

	</head>
   <style type="text/css">
	   #file {
		   position: relative;
		   text-align: right;
		   -moz-opacity: 0;
		   filter: alpha(opacity : 0);
		   opacity: 0;
		   z-index: 1;
	   }
   </style>
	<body>
	<div class="container text-center" >
		<div>
			<c:if test="${fileError!=null}" >
				${fileError}
			</c:if>
		</div>
		<form method="post" action="upload" enctype="multipart/form-data">
			<div class="group col-md-offset-1">

				<div class="row col-md-11" >
						<div class="group col-md-4" style="border: 1px solid saddlebrown;">
							<input class="btn btn-default" id="file" name="file" type="file" style="background: white">
						</div>
						<div class="group col-md-1" >
							<button class="btn btn-default" id="tj">提交</button>
						</div>
				</div>
			</div>
		</form>
		<div class="group col-md-offset-10">
				<button class="btn btn-default"><a href="download">下载用户列表</a></button>
		</div>
		<table class="table table-bordered table-hover">
			<tr  class="info" style="height:4px">
				<td class="font-weight"><b>id</b></td>
				<td class="font-weight"><b>姓名</b></td>
				<td class="font-weight"><b>年龄</b></td>
				<td class="font-weight"><b>职业</b></td>
				<td>
					<a href="select">
						<button class="btn default col-md-3">新增员工</button>
					</a>
				</td>
			</tr>

				<c:forEach var="staff" items="${staffList}" varStatus="st">
					<tr>
						<td>${st.count}</td>
						<td>${staff.name}</td>
						<td>${staff.age}</td>
						<td>${staff.job}</td>
						<td>
							<div>
								<a href="delete?id=${staff.id}"><button class="btn default col-md-2">删除</button></a>
								<a href="select?id=${staff.id}"> <button class="btn default col-md-2 col-md-offset-2">修改</button></a>
							</div>
						</td>
					</tr>
				</c:forEach>

		</table>

	</div>
	</body>
	<script type="text/javascript">

	</script>
</html>