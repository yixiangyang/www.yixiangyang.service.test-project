package com.example.testProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiangyang.model.Customer;
import com.xiangyang.unit.jxlExportExcelUnit;

import jxl.JXLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestProjectApplication.class})
public class TestProjectApplicationTests {
	
	@Test
	public void test(){
		try {
			
			//调用
			List<Object> customer = new ArrayList<>();
			for(int i = 1;i<=71000;i++){
				//Customer cust = new Customer("a"+i, "张三"+i, "15138778469", "15138778469", "A", "C", "李四s", "aa", "aa", "ddd", "12");
				Object[]  cust= new Object[7];
				cust[0] = new String(""+i);
				cust[1] = new String("张三"+i);
				cust[2] = new String("15138778469s");
				cust[3] = new String("A");
				cust[4] = new String("C"+i);
				cust[5] = new String("李四"+i);
				cust[6] = new String("aa"+i);
				
				customer.add(cust);
			}
			List<String> head = new ArrayList<>();
			head.add("序号");
			head.add("名字");
			head.add("手机号");
			head.add("类型");
			head.add("流水");
			head.add("类型");
			head.add("流水");
			java.util.Date date=new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String da = sdf.format(date);
			File f= new File("F:/Test/"+da+".xlsx") ; // 声明File对象
			  // 第2步、通过子类实例化父类对象
			OutputStream out = null ; // 准备好一个输出的对象
			try {
				out = new FileOutputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jxlExportExcelUnit.createXlsxExcel(out, "这是标题", head, customer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JXLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("嗨，成功不");
	}
}