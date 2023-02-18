package commonact;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {

    private static HSSFWorkbook workbook;

    private static HSSFSheet sheet;

    // private static HSSFCell cell;
    public ReadExcelFile(String excelfilePath) {
        try {
            File s = new File(excelfilePath);
            FileInputStream stream = new FileInputStream(s);
            workbook = new HSSFWorkbook(stream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getData(int sheetnumber, int row, int column) {
        DataFormatter formatter = new DataFormatter();
        sheet = workbook.getSheetAt(sheetnumber);
        HSSFCell data = sheet.getRow(row).getCell(column);
        return formatter.formatCellValue(data);
    }
}