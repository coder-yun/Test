package com.yun.office;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caiyunwu on 2017/6/26.
 */
public class ExcelUtil {
    public static void main(String[] args) {
        try {
            DataFormatter formatter = new DataFormatter();
            Workbook wb= WorkbookFactory.create(new FileInputStream("E://openelt.xlsx"));
            Sheet sheet = wb.getSheetAt(0);
            List<Map<String, String>> fieldList = new ArrayList<Map<String, String>>();
             for (Row row : sheet) {
                 Map<String, String> map = new HashMap<String, String>();
                 String value=getCellValue(row.getCell(6));
                 System.out.println(value);
//                for (Cell cell : row) {
////                    String text = formatter.formatCellValue(cell);
//                    System.out.println(cell);
//
//                    switch (cell.getCellTypeEnum()) {
//                        case STRING:
//                            System.out.println(cell.getRichStringCellValue().getString());
//                            break;
//                        case NUMERIC:
//                            if (DateUtil.isCellDateFormatted(cell)) {
//                                System.out.println(cell.getDateCellValue());
//                            } else {
//                                System.out.println(cell.getNumericCellValue());
//                            }
//                            break;
//                        case BOOLEAN:
//                            System.out.println(cell.getBooleanCellValue());
//                            break;
//                        case FORMULA:
//                            System.out.println(cell.getCellFormula());
//                            break;
//                        case BLANK:
//                            System.out.println();
//                            break;
//                        default:
//                            System.out.println();
//                    }
//
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        String cellValue = "";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                cellValue = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue().toString();
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
        }
        return cellValue.trim();
    }
}
