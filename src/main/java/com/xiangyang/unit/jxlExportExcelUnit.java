package com.xiangyang.unit;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.CellView;
import jxl.JXLException;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class jxlExportExcelUnit {
	public static void createXlsxExcel(OutputStream os,String title,List<?> head,List<?> content)throws IOException,JXLException {
		System.out.println(content.size() +"===============================");
		WritableWorkbook book = Workbook.createWorkbook(os);
		//将标题设置为宋体，18号 加粗
		WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD);
		WritableCellFormat wcfTitle = new WritableCellFormat(titleFont);
		wcfTitle.setAlignment(Alignment.CENTRE);
		
		CellView navCellView = new CellView();
		navCellView.setAutosize(true);//设置自动大小
		navCellView.setSize(20);
		int iMaxLines = 60000;//每个sheet的最大条数
	    int totalLines = content.size(); //总条数
	    int page = totalLines / iMaxLines; //页数  
	    System.out.println("page="+page);  
	    int lastLines = totalLines % iMaxLines;//尾页要写的行数  
		if(totalLines == 0){
			return;
		}
		if(page >= 1 && lastLines > 0){
			page = page + 1;
		}
		if(page == 0){
			page = 1;
		}
		//合并标题单元格
		
		/*WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 11, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
		 WritableCellFormat wcf_title = new WritableCellFormat(wf_title); // 单元格定义  
         wcf_title.setBackground(jxl.format.Colour.WHITE); // 设置单元格的背景颜色  
         wcf_title.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式  
         wcf_title.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK);*/
		for(int p =0;p<page;p++){
			if(p==1){
				System.out.println();
			}
			WritableSheet sheet = book.createSheet("page"+p, p);
			int startRows = 0;
			int endRows = 0;
			if(p==0){
				startRows = 0;  
				if (page == 1) {
					endRows= totalLines-1;//如果是第一页 最后一行就是 总条数减去一
				} else {
					endRows = (p + 1) * iMaxLines -1; //否则就是当前页*最大条数减去1
				} 
			}else {  
                startRows = p * iMaxLines;  
                if (p == page - 1) {  
                    endRows = totalLines -1;  
                } else {  
                    endRows = (p + 1) * iMaxLines -1;  
                }  
            } 
			System.out.println("head:"+head.size());
			sheet.mergeCells(0, 0, head.size()-1, 0);
			List<Object> lastPageValue = new ArrayList<>();//保存每页的数据  
			for(int i=startRows;i<=endRows;i++){
				if(content.get(i) == null){
					continue;
				}
				System.out.println(content.get(i).toString());
				lastPageValue.add(content.get(i));
			}
			Label labTitle = new Label(0, 0, title, wcfTitle);  
	        sheet.addCell(labTitle);  
	        // head  
            WritableFont wfHead = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);  
            WritableCellFormat wcfHead = new WritableCellFormat(wfHead);  
            for (int i=0; i<head.size(); i++) {  
                Label labHead = new Label(i, 1, (String)head.get(i), wcfHead);  
                sheet.addCell(labHead);  
            }
            //Content
            if(!content.isEmpty() && content.size()>0){
            	if(content.get(0) instanceof Map){
            		// list中是Map  
                    for (int i=0; i<lastPageValue.size(); i++) {  
                        System.out.println(i);  
                        Map<?,?> m = (Map<?,?>) lastPageValue.get(i);  
                        Set<?> s = m.keySet();  
                        Iterator<?> itr = s.iterator();  
                        for (int j=0; itr.hasNext(); j++) {  
                            Object key = itr.next();  
                            try {  
                                Label labData = new Label(j, i+2, m.get(key).toString());  
                                sheet.addCell(labData);  
                            } catch (NullPointerException e){}  
                        }  
                    }  
            	}if (content.get(0) instanceof List) {  
                    // list中是list  
                    for (int i=0; i<lastPageValue.size(); i++) {  
                        List<?> lst = (List<?>) lastPageValue.get(i);  
                        for (int j=0; j<lst.size(); j++) {  
                            try {  
                                Label labData = new Label(j, i+2, lst.get(j).toString());  
                                sheet.addCell(labData);  
                            } catch (NullPointerException e){}  
                        }  
                    }  
                } else if (content.get(0) instanceof Object[]) {  
                    // list中是数组  
                    for (int i=0; i<lastPageValue.size(); i++) {  
                        Object[] obj = (Object[]) lastPageValue.get(i);  
                        for (int j=0; j<obj.length; j++) {  
                            try {  
                                Label labData = new Label(j, i+2, obj[j].toString());  
                                //System.out.println(obj[j]);  
                                sheet.addCell(labData);  
                            } catch (NullPointerException e){}  
                        }  
                    }  
                } else {  
                      
                }
            }
           
		}
		 book.write();
 	    book.close();
	}
}
