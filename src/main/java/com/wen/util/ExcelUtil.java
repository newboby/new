package com.wen.util;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/24.
 */
public class ExcelUtil {
    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

    public static void inputXls(String string) throws IOException {
        FileInputStream in=new FileInputStream(string);
        Workbook  wk=new HSSFWorkbook(in);
        Sheet sheetAt = wk.getSheetAt(0);
        System.out.println(sheetAt.getRow(0).getCell(0));

    }
    public static void main(String[] args) throws IOException {
//        HSSFWorkbook text = getHSSFWorkbook("text", new String[]{"id", "name"}, new String[][]{{"1", "xx"}, {"1", "xx"}, {"1", "xx"}, {"1", "xx"}}, new HSSFWorkbook());
////        OutputStream o=new FileOutputStream("aa.xls");
//        FileOutputStream out = new FileOutputStream("D:\\code\\new\\workbook.xls");
//        text.write(out);
//
//        out.close();
//        inputXls("D:\\code\\new\\workbook.xls");
    }
}
