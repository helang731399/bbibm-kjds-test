package com.bbibm.memo.util;

import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@AllArgsConstructor
@Component
public class XLSXtoJSON {

    /**
     * @param excelPath
     * @return ArrayList<String>
     * @throws FileNotFoundException,InvalidFormatException
     * @description: excel文件生成对应的json字符串
     */
    public  ArrayList<String> xlsx_to_json(String excelPath) throws  IOException {
        ArrayList<String> jsonString = new ArrayList<String>();
        //Excel
        Workbook wb = WorkbookFactory.create(new FileInputStream(excelPath));
        //sheet
        Sheet sheet =  wb.getSheetAt(0);
        //标题
        String [] headNames=null;
        //每行
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if(i==0){
                headNames=new String[row.getPhysicalNumberOfCells()];
                //每列
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    headNames[j]=cell.getStringCellValue();
                }
            }else { //构造json
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    String key = headNames[j];
                    cell.setCellType(CellType.STRING);
                    String value=cell.getStringCellValue().replaceAll("[\\n\\r\"]"," ");
                    if(j!=row.getPhysicalNumberOfCells()-1){
                        stringBuilder.append("\"").append(key).append("\"").append(":").append("\"").append(value).append("\"").append(",");
                    }else{
                        stringBuilder.append("\"").append(key).append("\"").append(":").append("\"").append(value).append("\"");
                    }
                }
                stringBuilder.append("}");
                jsonString.add(stringBuilder.toString());
            }
        }
        wb.close();
        return jsonString;
    }
}