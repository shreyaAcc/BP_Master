package Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	 
	public static XSSFSheet ExcelWSheet;

	 public static XSSFWorkbook ExcelWBook;

	 public static XSSFCell Cell;

	 public static XSSFRow Row;
	 public static String URL;
	 public static String Portal;
	 public static String Username;
	 public static String Password;
	 public static String SUSERNAME;
	 public static String SACCESS_KEY;
	 
	  public static void setExcelFile(String Path,String SheetName) 
	  {
	
	  try {
		  FileInputStream fis=new FileInputStream(Path);
		  ExcelWBook=new XSSFWorkbook(fis);
		  ExcelWSheet=ExcelWBook.getSheet(SheetName);

	  }
	  catch (FileNotFoundException e) { 
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 }
	  
	  
	  
	  public static void getCellData() throws Exception{

	 //Find number of rows in excel file
		  int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
  
		  //Create a loop over all the rows of excel file to read it

		    for (int i = 0; i < rowCount+1; i++) {
		        Row = ExcelWSheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < Row.getLastCellNum(); j++) {

		            //Print Excel data in console
		        	
		        	 Cell = ExcelWSheet.getRow(0).getCell(j);
		        	 
		        	try 
		        	{
		          if(Cell.getStringCellValue().equals("Portal"))
		           {
		        	  Portal=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		        	  
		           } 
		          if(Cell.getStringCellValue().equals("URL"))
		           {
		        	  
		        	   URL=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		        	  
		           } 
		         
		          if(Cell.getStringCellValue().equals("Username"))
		           {
		        	   Username=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		           } 
		         
		          if(Cell.getStringCellValue().equals("Password"))
		           {
		        	  Password=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		           } 
		          if(Cell.getStringCellValue().equals("SauceLabID"))
		           {
		        	  SUSERNAME=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		           } 
		          if(Cell.getStringCellValue().equals("SACCESS_KEY"))
		           {
		        	  SACCESS_KEY=ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue();
		           } 
		        }
		        
		        	catch(Exception e)
		        	{
		        		
		        	}
		    }
	  }
	  }
}
	  
	   
 
		    







