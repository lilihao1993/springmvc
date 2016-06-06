package poitest;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.springmvc.model.Staff;

/**
 * 
 * 描述: Poi测试类 .<br>
 * @author lilihao
 * @date 2016年4月30日
 */
public class Test {
	public static void main(String[] args) throws Exception{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet =wb.createSheet("员工列表页");//创建页码
		//用于创建表格head数据
		List<String> list = new ArrayList<String>();
		list.add("序号");
		list.add("姓名");
		list.add("年龄");
		list.add("工作");
		//设置xls表格head数据
		setHead(wb.createCellStyle(),sheet.createRow(0),list);
		//设置具体数据
		setData(sheet,createStaffList());
		FileOutputStream file = new FileOutputStream("D:\\用户列表.xls");
		wb.write(file);
		file.close();
		System.out.println("到处excel成功！！");
	}
	
	/**
	 * 
	 * 描述: 用于测试excel表格head .
	 * @author lilihao
	 * @date 2016年4月30日
	 */
	public static void setHead(CellStyle style ,Row row,List<String> list){
		for(int i=0, j=list.size() ;i<j ; i++){
			 Cell cell = row.createCell(i);
			 cell.setCellValue(list.get(i));
		}
	}
	
	/**
	 * 描述: 创造模拟数据 .
	 * @author lilihao
	 * @date 2016年4月30日 
	 * @return
	 */
	public static List<Staff> createStaffList(){
		List<Staff> list = new ArrayList<Staff>();
		Staff staff = new Staff(1,"张三","20","建筑师");
		Staff staff1 = new Staff(2,"李四","28","会计师");
		Staff staff2 = new Staff(3,"王五","25","包工头");
		list.add(staff);
		list.add(staff1);
		list.add(staff2);
		return list;
	}
	
	/**
	 * 
	 * 描述: 用于创建具体数据 .
	 * @author lilihao
	 * @date 2016年4月30日 
	 * @param wb
	 * @param list
	 */
	public static void setData(Sheet sheet,List<Staff> list){
		for(int i=1, j=list.size() ; i<=j ; i++){
			Staff staff = list.get(i-1);
			 Row row = sheet.createRow(i);
			Cell id = row.createCell(0);
			id.setCellValue(String.valueOf(staff.getId()));
			Cell name = row.createCell(1);
			name.setCellValue(staff.getName());
			Cell age = row.createCell(2);
			age.setCellValue(staff.getAge());
			Cell job = row.createCell(3);
			job.setCellValue(staff.getJob());
		}
	}
	
	
}

