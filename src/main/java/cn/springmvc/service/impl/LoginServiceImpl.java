package cn.springmvc.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.LoginDAO;
import cn.springmvc.model.Login;
import cn.springmvc.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{

   @Autowired
   private LoginDAO logindao;

	public List<Login> selectSysUserList() throws Exception{
		
		return logindao.selectSysUserList();
		
	}
	
	/**
	 * 描述: 获取单个用户 .
	 * @author lilihao
	 * @date 2016年5月9日 
	 * @return
	 */
	public Login selectUser(Login login)throws Exception{
		
		return logindao.selectUser(login);
		
	}


}