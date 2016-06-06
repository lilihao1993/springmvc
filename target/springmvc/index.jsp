<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		 <link href="css/bootstrap.min.css" rel="stylesheet"> 
		 <script src="js/bootstrap.min.js"></script> 
		 <script src="js/jquery.min.js" ></script>
	</head>
<body>
<h2>Hello World!</h2>
	<div class="container text-center" >
		<form action="login" class="form" method="post">
			<div class="row">
				<div class="form-group">
					<p class="info">${error}</p>
				</div>
			</div>
			<div class="row" >
				<div class="form-group ">
					<label>用户名：</label>
					<input type="text" placeholder="请输入用户名" name="username" style="margin:0 80px 0 0 "></input>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label>密码：</label>
					<input type="text" placeholder="请输入密码" name="password" style="margin:0 60px 0 0 "></input>
				</div>
			</div>
			<div class="row">
				
	    		<div class="form-group col-md-4 col-md-offset-4">
	    			<label> 验证码:</label> 	         
    				<input name="key" type="text" id="kaptcha" maxlength="4"  />               
        			<img src="captcha-image.do" width="60" height="30" id="kaptchaImage"  style="margin-bottom: -3px"/>   
	    		</div>
			</div>
			<div class="row">
				<div class="form-group">
					<button class="btn btn-default">登陆</button>
				</div>
			</div>
			
		</form>
	</div>
</body>
	<script type="text/javascript">      
        $(function(){           
            $('#kaptchaImage').click(function () {//生成验证码  
             $(this).hide().attr('src', 'captcha-image?' + Math.floor(Math.random()*100) ).fadeIn(); })      });   
        
     </script> 
</html>
