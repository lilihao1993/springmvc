package cn.springmvc.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import cn.springmvc.model.Login;
import cn.springmvc.service.LoginService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private LoginService loginService;
	
	 private Producer captchaProducer = null;  
	  
    @Autowired  
    public void setCaptchaProducer(Producer captchaProducer) {  
        this.captchaProducer = captchaProducer;  
    } 
    
  
   public String index(){
       return "index";
   }
    
   
   @RequestMapping("login")
   public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password ,HttpServletRequest request , String key)throws Exception{
	   /*方式一：
	    * 在参数中用@RequestParam("username")将页面值设置到参数上，
	    */
	   
	   ModelAndView model = new ModelAndView();
	   String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
	   System.out.println(username+","+password);
	   System.out.println("xxxxxxxxxxxxxxxx");
	   Login log = new Login();
	   log.setUsername(username);
	   log.setPassword(password);
	   Login login= loginService.selectUser(log);
	   if(username == null || "".equals(username) || password ==null || "".equals(password)){
		   model.addObject("error", "用户名密码不可为空");
		   model.setViewName("index");
		   return model;
	   }else if(login == null || !login.getPassword().equals(password) || !login.getUsername().equals(username)  ){
		   model.addObject("error","用户名或密码错误");
		   model.setViewName("index");
		   return model;
	   }else if(!kaptchaExpected.equals(key)){
		   model.addObject("error","验证码错误!");
		   model.setViewName("index");
		   return model;
	   }else{
		   if(username!=null && password != null){
			   request.getSession().setAttribute("userName", username);
			   request.getSession().setAttribute("password", password);
		   }
		   model.setViewName("redirect:staff/selectList");
		   return model;
	   }
	   
   }
   
   @RequestMapping("/captcha-image")  
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {  
 
       response.setDateHeader("Expires", 0);  
       // Set standard HTTP/1.1 no-cache headers.  
       response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
       // Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
       response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
       // Set standard HTTP/1.0 no-cache header.  
       response.setHeader("Pragma", "no-cache");  
       // return a jpeg  
       response.setContentType("image/jpeg");  
       // create the text for the image  
       String capText = captchaProducer.createText();  
       // store the text in the session  
       request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
       // create the image with the text  
       BufferedImage bi = captchaProducer.createImage(capText);  
       ServletOutputStream out = response.getOutputStream();  
       // write the data out  
       ImageIO.write(bi, "jpg", out);  
       try {  
           out.flush();  
       } finally {  
           out.close();  
       }  
       return null;  
   }  
}