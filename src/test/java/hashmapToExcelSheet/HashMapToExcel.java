package hashmapToExcelSheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {
	public static void main(String[] args) throws IOException {
		
		 XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("student data");
			 Map<String,String> data=new HashMap<String,String>();
			 data.put("101", "sheereesh");
			 data.put("102", "ramesh");
			 data.put("103", "shakeer");
			 data.put("104", "praveen");
			

			int rowno=1;
			for(Map.Entry<String, String> entry:data.entrySet()) {
				XSSFRow row=sheet.createRow(rowno++);
				row.createCell(0).setCellValue((String)entry.getKey());
				row.createCell(1).setCellValue((String)entry.getValue());
			}
			FileOutputStream fos=new FileOutputStream( ".\\target\\student.xlsx");
			workbook.write(fos);
			fos.close();
			
			
		}
}
