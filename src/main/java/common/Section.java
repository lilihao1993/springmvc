package common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/30.
 * 切面 控制用户异常登录
 * @author lilihao
 * @since 05.30.2016
 */
@Component
@Aspect
public class Section {

//    Section(){
//        System.out.println("xxxx");
//    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public  void controller(){

    }

    @Before("controller()")
    public ModelAndView beforeSleep() throws Throwable {
        System.out.println("进来切面");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURI();
        ModelAndView modelAndView = new ModelAndView();
        String username  = (String) request.getSession().getAttribute("userName");
        String password  = (String) request.getSession().getAttribute("password");
        if (username == null || "".equals(username) || password ==null || "".equals(password) && !"/login".equals(url) ){
            //session未有值 且不是访问/login路径 则跳转到登录页
            modelAndView.setViewName("index");
            System.out.println("跳转到index");
        }else {
            modelAndView.setViewName(url);
            System.out.println("跳转到非登录页");
        }

        return modelAndView;
    }



//    @After("controller()")
//    public  void after(HttpServletRequest request)  {
//        System.out.println("进入");
//    }


}
