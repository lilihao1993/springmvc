package UserTest;

import cn.springmvc.model.Staff;
import common.Upload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Test1 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("F:\\员工列表.xls");
        Upload upload = new Upload();
        List<Staff>  staffs = upload.readExcelStaff(inputStream);
        for (Staff staff: staffs){
            System.out.println(staff.toString());
        }

    }
}
