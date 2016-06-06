package cn.springmvc.service;


import java.util.List;

import cn.springmvc.model.Login;

public interface LoginService {
	 
    public List<Login>  selectSysUserList()throws Exception;
    
    /**
     * 描述: 获取单个用户 .
     * @author lilihao
     * @date 2016年5月9日 
     * @return
     */
    public Login selectUser(Login login)throws Exception;
}