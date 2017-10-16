package com.xiangyang.unit;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;


import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class test {
	@SuppressWarnings("rawtypes")
	public static void exportExcel( Object objIn,Object objOut) {
        try {
        //取得response HttpServletResponse
        HashMap hmOut = (HashMap)objOut;
        HashMap hmIn = (HashMap)objIn;
        HttpServletResponse response=(HttpServletResponse)hmIn.get("response");
        //设置table列名
        String excelName =(String)hmIn.get("excelName");
        String[] excelNameArray = excelName.split(",");
        
        
        //取得key
        String[] excelKeyArray = (String[])hmOut.get("excelKey");
        
        OutputStream os = response.getOutputStream();// 取得输出流   
            response.reset();// 清空输出流  

            response.setHeader("Content-disposition", "attachment; filename="+new String("Book1".getBytes("GB2312"),"8859_1")+".xls");// 设定输出文件头   
            response.setContentType("application/msexcel");// 定义输出类型 
            
            WritableWorkbook wwb = Workbook.createWorkbook(os); // 建立excel文件   
        
            WritableSheet ws = wwb.createSheet("Sheet1", 10);        // 创建一个工作表

            //    设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,
                    UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            WritableCellFormat wcf = new WritableCellFormat(wf);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
            wcf.setAlignment(Alignment.CENTRE); 
            ws.setRowView(0, 500);

            //    填充数据的内容
            int len=((String[])hmOut.get(excelKeyArray[0])).length;
            //设置列头名
        for (int j=0;j<excelKeyArray.length;j++){
           ws.addCell(new Label(j, 0, excelNameArray[j], wcf));
        }
        //设置内容
        wcf = new WritableCellFormat();
            for (int i = 0; i <len; i++){
            for (int j=0;j<excelKeyArray.length;j++){
               ws.addCell(new Label(j, i+1, ((String[])hmOut.get(excelKeyArray[j]))[i], wcf));
            }
            }

            wwb.write();
            wwb.close();

        } catch (IOException e){
        } catch (RowsExceededException e){
        } catch (WriteException e){}
    }
}
