package UserTest;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class Test {
	public static void main(String[] args) throws Exception{
		Workbook wb = new HSSFWorkbook();
		FileOutputStream file = new FileOutputStream("D:用户列表.xls");
		wb.write(file);
		file.close();
	}
	
}
