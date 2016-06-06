package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.StaffDAO;
import cn.springmvc.model.Staff;
import cn.springmvc.service.StaffService;

/**
* @ClassName: StaffServiceImpl
* @Description: 员工service实现
* @author 黎力豪
* @date 2016年4月24日 下午1:25:17
*
 */

@Service
public class StaffServiceImpl implements StaffService{
	/**
	* @Title: selectSysStaffList
	* @Description: 获取员工列表
	* @param @return    设定文件
	* @return List<Staff>    返回类型
	* @throws
	 */
	@Autowired
	private StaffDAO staffDao;
	
	public  List<Staff> selectStaffList()throws Exception{
		
		return staffDao.selectStaffList() ;
		
	}
	
	/**
	 * 获取单个员工信息
	 */
	public Staff selectStaff(int id) throws Exception{
		
		return staffDao.selectStaff( id);
	}
	
	/**
	 * 增加员工信息
	 */
	public void addStaff(Staff staff) throws Exception{
		staffDao.addStaff(staff);
		
	}
	
	/**
	 * 更新员工信息
	 */
	public void modifyStaff(Staff staff) throws Exception{
		staffDao.modifyStaff(staff);
	}
	
	/**
	 * 删除员工信息
	 */
	public void deleteStaff(int id) throws Exception{
		staffDao.deleteStaff(id);
	}
}
