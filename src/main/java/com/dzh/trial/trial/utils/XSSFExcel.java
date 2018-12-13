package com.dzh.trial.trial.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XSSFExcel{
    public static Map<String, ArrayList<String>> readExcelData(String dataPath) throws IOException {
        InputStream is = new FileInputStream(dataPath);

        XSSFWorkbook wb;
        wb = new XSSFWorkbook(is);

        XSSFSheet sheet = wb.getSheetAt(0); // 获取第一个sheet表

        XSSFRow rowData;
        Map<String, ArrayList<String>> resultData = new HashMap<String, ArrayList<String>>();
        String trans_key = null;
        String item;

        for (int i = sheet.getTopRow(); i < sheet.getLastRowNum() + 1; i++) {
            rowData = sheet.getRow(i);
            if (i == sheet.getTopRow()) {
                continue; //标题不读入
            }

            ArrayList<String> trans_item = new ArrayList<String>();

            for (int j = rowData.getFirstCellNum(); j < rowData.getLastCellNum(); j++) {

                if (j == rowData.getFirstCellNum()) {
                    trans_key = rowData.getCell(j).toString();
                } else {
                    item = rowData.getCell(j).toString();
                    trans_item.add(item);
                }
            }
            resultData.put(trans_key, trans_item);
        }

        is.close();

        return resultData;
    }

    public static void main(String[] args) {
        System.out.println(Instant.now().getEpochSecond());

    }
}
