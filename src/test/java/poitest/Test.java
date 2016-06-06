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
 * ����: Poi������ .<br>
 * @author lilihao
 * @date 2016��4��30��
 */
public class Test {
	public static void main(String[] args) throws Exception{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet =wb.createSheet("Ա���б�ҳ");//����ҳ��
		//���ڴ������head����
		List<String> list = new ArrayList<String>();
		list.add("���");
		list.add("����");
		list.add("����");
		list.add("����");
		//����xls���head����
		setHead(wb.createCellStyle(),sheet.createRow(0),list);
		//���þ�������
		setData(sheet,createStaffList());
		FileOutputStream file = new FileOutputStream("D:\\�û��б�.xls");
		wb.write(file);
		file.close();
		System.out.println("����excel�ɹ�����");
	}
	
	/**
	 * 
	 * ����: ���ڲ���excel���head .
	 * @author lilihao
	 * @date 2016��4��30��
	 */
	public static void setHead(CellStyle style ,Row row,List<String> list){
		for(int i=0, j=list.size() ;i<j ; i++){
			 Cell cell = row.createCell(i);
			 cell.setCellValue(list.get(i));
		}
	}
	
	/**
	 * ����: ����ģ������ .
	 * @author lilihao
	 * @date 2016��4��30�� 
	 * @return
	 */
	public static List<Staff> createStaffList(){
		List<Staff> list = new ArrayList<Staff>();
		Staff staff = new Staff(1,"����","20","����ʦ");
		Staff staff1 = new Staff(2,"����","28","���ʦ");
		Staff staff2 = new Staff(3,"����","25","����ͷ");
		list.add(staff);
		list.add(staff1);
		list.add(staff2);
		return list;
	}
	
	/**
	 * 
	 * ����: ���ڴ����������� .
	 * @author lilihao
	 * @date 2016��4��30�� 
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

