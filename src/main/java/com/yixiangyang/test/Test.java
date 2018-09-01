package com.yixiangyang.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Test {

	public static void main(String[] args) throws RowsExceededException, WriteException, BiffException, IOException {
		File file = new File("E:/大厦写字楼物业费净租金明细表.xls");
		String filePath = file.getAbsolutePath();
		
		try {
			jxl.Workbook wb =null;    
			InputStream is = new FileInputStream(filePath);
			 wb = Workbook.getWorkbook(is); 
			jxl.write.WritableWorkbook wbe= Workbook.createWorkbook(new File(filePath), wb);//创建workbook的副本
            int sheet_size=wbe.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                WritableSheet sheet  = wbe.getSheet(index);        //获取sheet
                // sheet.getRows()返回该页的总列数
                int rows = sheet.getRows();
                for(int k = 0;k<rows;k++){
                	String cellInfo = sheet.getCell(0, k).getContents();
                	WritableCell cell = sheet.getWritableCell(0, k);//获取第一列的所有单元格
                	jxl.format.CellFormat cf = cell.getCellFormat();//获取第一个单元格的格式
                	jxl.write.Label lbl = null;
                	if(cellInfo.indexOf("172.30.160")>=0){
                		lbl = new jxl.write.Label(1, k, "172.30.160.0/24");
                	}
                	else{
                		String cellInfo1 = sheet.getCell(1, k).getContents();
                		lbl=new jxl.write.Label(1, k, cellInfo1);
                	}
                	 lbl.setCellFormat(cf);                          //将修改后的单元格的格式设定成跟原来一样
                     sheet.addCell(lbl);
                }
            }
            wbe.write();                                            //将修改保存到workbook
            wbe.close();           
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
