package cn.springmvc.controller;

import cn.springmvc.model.Staff;
import cn.springmvc.service.StaffService;
import common.Constants;
import common.DownLoad;
import common.Upload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
* @ClassName: StaffController
* @Description: 员工Controller
* @author 黎力豪
* @date 2016年4月24日 下午1:27:56
*
*/
@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	/**
	 * 用于查询所有员工信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectList")
	public ModelAndView selectStaffList(ModelAndView model)throws Exception{
		List<Staff> staffList= staffService.selectStaffList();
		model.addObject("staffList",staffList);
		model.setViewName("sfaffList");
		return model;
	}
	
	/**
	 * 获取单个员工
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/select")
	public ModelAndView seleteStaff(ModelAndView model , @RequestParam(required=false) Integer id)throws Exception{
		
		if(id != null){
			Staff staff = staffService.selectStaff(id);
			model.addObject("staff", staff);
			model.setViewName("modify");
			return model;
		}
		model.setViewName("addSfaff");
		return model;
	}
	
	/**
	 * 添加员工
	 * @param model
	 * @param staff
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView addStaff(ModelAndView model,Staff staff)throws Exception{
		System.out.println(staff.getAge());
		staffService.addStaff(staff);
		model.setViewName("redirect:selectList");
		return model;
	}
	
	/**
	 * 修改员工信息
	 * @param model
	 * @param staff
	 * @return
	 */
	@RequestMapping("/modify")
	public ModelAndView modifyStaff(ModelAndView model,Staff staff)throws Exception{
		staffService.modifyStaff(staff);
		model.setViewName("redirect:selectList");
		return model;
	}
	
	/**
	 * 删除员工
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ModelAndView deleteStaff(ModelAndView model,int id)throws Exception{
		staffService.deleteStaff(id);
		model.setViewName("redirect:selectList");
		return model;
	}
	
	/**
	 * 描述: 文件下载 .
	 * @author lilihao
	 * @date 2016年4月30日 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/download")  
	public ResponseEntity<byte[]> download() throws IOException , Exception{  
	    HttpHeaders headers = new HttpHeaders();  
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    //生成文件名称
	    String fileName = "员工列表"+String.valueOf(System.currentTimeMillis())+".xls";
	    headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("utf-8"), "ISO8859-1"));  
	    
	    //1.获取全部员工信息列表
	    List<Staff> staffList= staffService.selectStaffList();
	   
	    Workbook wb = new HSSFWorkbook();
		Sheet sheet =wb.createSheet("员工列表页");//创建页码
		//用于创建表格head数据
		List<String> list = new ArrayList<String>();
		list.add("序号");
		list.add("姓名");
		list.add("年龄");
		list.add("工作");
		//设置xls表格head数据
		DownLoad.setHead(wb.createCellStyle(),sheet.createRow(0),list);
		//设置具体数据
		DownLoad.setData(sheet,staffList);
		//创建字节输出流
		ByteArrayOutputStream  out = new ByteArrayOutputStream();
		
		
		wb.write(out);
		out.close();
		return new ResponseEntity<byte[]>(out.toByteArray(),  
                headers, HttpStatus.CREATED);  		
	}

	/**
	 * Upload string.
	 *文件上传
	 * @param file    the file
	 * @param request the request
	 * @param model   the model
	 * @return the string
	 * @throws IOException the io exception
	 * @since 05.27.2016
	 */
	@RequestMapping("/upload")
	@Transactional(rollbackFor=Exception.class)
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, RedirectAttributes model) throws IOException {
		System.out.println(file.getOriginalFilename());
		if (file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx")){
			InputStream InputStream =  file.getInputStream();
			System.out.println("888888888888");
			Upload upload = new Upload();
			String [] strings = upload.readExcelTitle(InputStream);
			List<String> stringList= Arrays.asList(strings);
			if (!stringList.containsAll(upload.list)){
				model.addFlashAttribute("fileError",Constants.TEMPLATE_FORMAT_ERROR);
				return "redirect:selectList";
			}
			try {
				List<Staff> staffs= upload.readExcelStaff(InputStream);
				for (Staff staff:staffs) {
					staffService.addStaff(staff);
				}
			}catch (Exception e){
				model.addFlashAttribute("fileError",Constants.TEMPLATE_FORMAT_CONTENT_ERROR);
				return "redirect:selectList";
			}
		}else {
			System.out.println("xxxx");
			model.addFlashAttribute("fileError", Constants.File_NAME_ERROR);
		}
		return "redirect:selectList";
	}
}
