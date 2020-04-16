package com.lxf.Jxl;

//import java.awt.Label;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;

//import jxl.CellType;

//import jxl.write.WritableCell;
//import jxl.write.WritableWorkbook;
//add by yyl 2017-06-30
public class ExcelOperater {
	public static void main(String[] args) {
		jxl.Workbook readwb=null;
		//讀取excel中的內容
		try{
			InputStream instream= new FileInputStream("D:/安邦康爱特定恶性肿瘤疾病保险现金价值表.xls");
			jxl.write.WritableWorkbook wwb= Workbook.createWorkbook(new java.io.File("D:/10年交费期间.xls"));
			readwb=Workbook.getWorkbook(instream);
			Sheet[] readSheets=readwb.getSheets();
//			for (int k = 0; k < readSheets.length; k++) {
				Sheet readSheet=readwb.getSheet(2);
				//获取Sheet表中所包含的总列数   
				int rsColumns=readSheet.getColumns();
				//获取Sheet表中所包含的总行数   
				int rsRows=readSheet.getRows();
				String sheetName=readSheet.getName();
				jxl.write.WritableSheet ws=wwb.createSheet(sheetName,0);//第一个参数为工作簿的名称，第二个参数为页数
				int rowTemp=1;
				int yearAgeRowNum=0;
				jxl.write.Label label2=new jxl.write.Label(0,0, "chargePeriodd");
				jxl.write.Label label3=new jxl.write.Label(1,0, "policyAge");
				jxl.write.Label label4=new jxl.write.Label(2,0, "sex");
				jxl.write.Label label5=new jxl.write.Label(3,0, "Age");
				jxl.write.Label label6=new jxl.write.Label(4,0, "Endcsv");
//				ws.addCell(label1);
				ws.addCell(label2);
				ws.addCell(label3);
				ws.addCell(label4);
				ws.addCell(label5);
				ws.addCell(label6);
				for (int i = 2; i < rsRows; i++) {
					for(int j=4;j < 110;j++){
						if(readSheet.getCell(0,i).getContents().equals("10")){
							//if(cell!=null && cell.getContents()!=null && i>1 &&!cell.getContents().equals("")){
						 	Cell chargePreiod=readSheet.getCell(0,i);
						    Cell age=readSheet.getCell(1,i);
						    String sex=readSheet.getCell(2,i).getContents();
						    if(sex!=null && sex.equals("M")){
						    	sex="0";
						    }else if(sex!=null && sex.equals("F")){
						    	sex="1";
						    }
						    //保单年度
						    String policyYear=readSheet.getCell(j,1).getContents();
						    Cell Endcsv=readSheet.getCell(j,i);
							jxl.write.Label label7=new jxl.write.Label(0,rowTemp,chargePreiod.getContents());
							jxl.write.Label label8=new jxl.write.Label(2,rowTemp, sex);
							jxl.write.Label label9=new jxl.write.Label(3,rowTemp, age.getContents());
							jxl.write.Label label10=new jxl.write.Label(4,rowTemp, Endcsv.getContents()); 
							jxl.write.Label label11=new jxl.write.Label(1,rowTemp, policyYear);
							if(Endcsv.getContents()==null || Endcsv.getContents().equals("")){
								continue;
							}
							ws.addCell(label7);
							ws.addCell(label8);
							ws.addCell(label9);
							ws.addCell(label10);
							ws.addCell(label11);
							rowTemp=rowTemp+1;
						}
					}
				}
			//}

			//写入Excel对象  
			wwb.write();
			wwb.close();
			//判断单元格的类型, 做出相应的转化
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			readwb.close();
		}
		System.out.println("讀取成功");

	}
}