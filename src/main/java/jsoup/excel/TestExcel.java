package jsoup.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

class TestExcel {

    // 查找不一样的单号
    public static void main(String[] strs) throws EncryptedDocumentException, IOException, InvalidFormatException {
        String filepath = "tongji.xlsx";
        InputStream is = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        if (sheet != null) {
            int rowNos = sheet.getLastRowNum();// 得到excel的总记录条数
            String no = "";
            int count = 0;
            String number = "";
            for (int i = 1; i <= rowNos; i++) {// 遍历行
                Row row = sheet.getRow(i);

                // 人员名称
                Cell cell0 = row.getCell(0);
                cell0.setCellType(CellType.STRING);
                String str0 = cell0.getStringCellValue();

                // 单号
                Cell cell1 = row.getCell(1);
                cell1.setCellType(CellType.STRING);
                String str1 = cell1.getStringCellValue();

                // 借方金额
                Cell cell2 = row.getCell(2);
                cell2.setCellType(CellType.STRING);
                String str2 = cell2.getStringCellValue();

                // 贷方金额
                Cell cell3 = row.getCell(3);
                cell3.setCellType(CellType.STRING);
                String str3 = cell3.getStringCellValue();

                if (!no.equals(str1)) {
                    count = 0;
                } else {
                    count = 1;
                }

                if (count == 0) {
                    no = str1;
                    number = str3;
                    continue;
                }

                if (!str2.equals(number)) {
                    System.out.println("数据不一样的单号：" + str1);
                }
            }
        }
    }
}