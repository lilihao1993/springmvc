package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * .<br>
 * @author lilihao
 * @date 
 */
public class Interceptor extends HandlerInterceptorAdapter  {
   
	
	@Override
	public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
//			
//			 String username = (String)request.getSession().getAttribute("userName");
//             String password = (String)request.getSession().getAttribute("password");
//			 if(username != null && password !=null && !"".equals(username) && !"".equals(password)){
//				 
//				 return false;
//			 }
//			String username = (String)request.getSession().getAttribute("userName");
//			String password = (String)request.getSession().getAttribute("password");
//			 if(username == null && password == null){
//				 response.sendRedirect("/spring/");
//			 }
	
		return true;  
    }  
	
	/**
	 *.
	 * @author lilihao
	 * @date
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
//  @Override
//  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
////	  modelAndView.setViewName("/WEB-INF/jsp/sfaffList.jsp");
////
//		 String username = (String)request.getSession().getAttribute("userName");
//		 String password = (String)request.getSession().getAttribute("password");
//		 System.out.println(username+","+password);
//		 if(username == null && password == null){
//			 System.out.println("������");
//			 response.sendRedirect("/spring/index.jsp");
//		 }
		 
//		 System.out.println(username+","+password);
//    }
  
  /**
   * .
   * @author lilihao
   * @date 2016��5��12�� 
   * @param request
   * @param response
   * @param handler
   * @throws Exception
   */
  @Override
	public void afterConcurrentHandlingStarted(
			HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 String username = (String)request.getSession().getAttribute("userName");
		 String password = (String)request.getSession().getAttribute("password");
		 System.out.println(username+","+password);
		 if(username == null && password == null){
			 System.out.println("������");
			 response.sendRedirect("/index.jsp");
		 }
	  
	}
  
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		
	}
	
}
