package hashmapToExcelSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/target/student.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(fis);
	XSSFSheet	sheet=workBook.getSheet("student data");
	int rows=sheet.getLastRowNum();
	Map<String,String> data=new HashMap<String,String>();
	
	for(int r=0;r<=rows;r++) {
		String key=sheet.getRow(r).getCell(0).getStringCellValue();
		String value=sheet.getRow(r).getCell(1).getStringCellValue();
		data.put(key,value);
	}
	
	for(Map.Entry entry:data.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
	
	
	}

}
