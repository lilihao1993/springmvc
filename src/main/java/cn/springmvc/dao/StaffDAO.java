package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Staff;

/**
* @ClassName: StaffDao
* @Description: 员工Dao
* @author 黎力豪
* @date 2016年4月24日 下午1:21:51
*
 */
public interface StaffDAO {
	/**
	* @Title: selectSysStaffList
	* @Description: 获取员工列表
	* @param @return    设定文件
	* @return List<Staff>    返回类型
	* @throws
	 */
	 public List<Staff> selectStaffList() throws Exception;
	 
	 /**
	  * 获取单个员工信息
	  * @return
	  */
	 public Staff  selectStaff( int id) throws Exception;
	 
	 /**
	  * 增加员工
	  * @param staff
	  */
	 public void addStaff(Staff staff)throws Exception;
	 
	 /**
	  * 更新员工
	  * @param staff
	  */
	 public void modifyStaff(Staff staff)throws Exception;
	 
	 /**
	  * 删除员工
	  * @param id
	  */
	 public void deleteStaff(int id)throws Exception;
}
