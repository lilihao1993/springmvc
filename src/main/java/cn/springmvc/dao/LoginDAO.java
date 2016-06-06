package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Login;
public interface LoginDAO {
	 /**
	  * 描述: 获取用户集合.
	  * @author lilihao
	  * @date 2016年5月9日 
	  * @return
	  */
    public List<Login> selectSysUserList() throws Exception;
    
    /**
     * 获取单个用户
     */
    public Login selectUser(Login login) throws Exception;
}