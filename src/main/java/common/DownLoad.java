package common;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import cn.springmvc.model.Staff;

public class DownLoad {
	
	
	
	/**
	 * 
	 * 描述: 用于生成excel表格head .
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
			id.setCellValue(String.valueOf(i));
			Cell name = row.createCell(1);
			name.setCellValue(staff.getName());
			Cell age = row.createCell(2);
			age.setCellValue(staff.getAge());
			Cell job = row.createCell(3);
			job.setCellValue(staff.getJob());
		}
	}
	
}
