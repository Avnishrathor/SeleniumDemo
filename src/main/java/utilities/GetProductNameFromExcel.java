package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
public class GetProductNameFromExcel  
{
	public static String getItem(String key) throws IOException
	{
		Map<String,String> testData = new LinkedHashMap<>();
		try {
			FileInputStream fis = new FileInputStream("F:\\Avnish\\eclipse-workspace\\Selenium\\TESTDATA.xlsx");
			Workbook workbook = (Workbook) new HSSFWorkbook();
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					cell.setCellType(CellType.STRING);

					testData.put(cell.getStringCellValue(),cellIterator.next().getStringCellValue());


					Set<Entry<String, String>> set= testData.entrySet();

					for(Entry<String, String> item:set){



						if(item.getKey().equals(key))
						{

							return (item.getValue());
						}
						else
						{
							return ("Product is not present in query sheet");
						}

					}
				}

			}

			fis.close();
		} 

		catch (Exception e)
		{
			e.printStackTrace();
		}
		return key;

	}

}
