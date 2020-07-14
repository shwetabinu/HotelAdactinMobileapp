package com.adactin.Mobileapphoteladactin1.util;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

//import static adactin.urbest.testscripts;
import static com.adactin.Mobileapphoteladactin1.base.BaseClass.testDataExcelFileName;
/**
 * Performs operations on the Excel file entries
 *
 *
 */
public class ExcelUtil {
	//Main Directory of the project
	public static final String currentDir = System.getProperty("user.dir");
	

	//Location of Test data excel file
	public static String testDataExcelPath = null;

	//Excel WorkBook
	private static XSSFWorkbook excelWBook;

	//Excel Sheet
	private static XSSFSheet excelWSheet;

	//Excel cell
	private static XSSFCell cell;

	//Excel row
	private static XSSFRow row;

	//Row Number
	public static int rowNumber;

	//Column Number
	public static int columnNumber;
	
	//public static String username,password,location,hotellist,expected_hotel,expected_location,
	//hotel,room_nu,arr_date,dep_dat,dayno,room_ty,apr,cpr,fname,lname,addr,ccn,cctype,ccexpiry,cvv,booked_id,
	//ord_id;

	//Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}

	public static int getRowNumber() {
		return rowNumber;
	}

	public static void setColumnNumber(int pColumnNumber) {
		columnNumber = pColumnNumber;
	}

	public static int getColumnNumber() {
		return columnNumber;
	}

	/**
	 * This method has two parameters: "Test data excel file name" and "Excel sheet name"
	 * @param sheetName
	 * @throws Exception
	 */
	
	public static void setExcelFileSheet(String sheetName) throws Exception {
		//Setting the TestData file path
		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			testDataExcelPath = currentDir + "//src//test//resources//";
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			testDataExcelPath = currentDir + "\\src\\test\\resources\\";
		}
		try {
			// Open the Excel file and sheet
			FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This method reads the test data from the Excel cell.
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @throws Exception
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			//Getting cell data in RowNum and ColNum
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);			
			DataFormatter formatter = new DataFormatter();
			//Assigning cell data to a variable
			String cellData = formatter.formatCellValue(cell);
			Log.info(cellData);
			//Returning cell data
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

	/**
	 * This method takes row number as a parameter and returns the data of given row number.
	 * @param RowNum
	 * @return
	 * @throws Exception
	 */
	public static XSSFRow getRowData(int RowNum) throws Exception {
		try {
			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}
	
	/**
	 * Method returns the row/ column number where the @param text is present
	 * @param index_type r if row is to be determined, c if column index is to be determined
	 * @param text
	 * @return Integer: row/column index
	 */
	public static int readExcel(char index_type,String text)
	{
		int rn=0;
		int cn=0;
		Iterator<Row> rowIterator = excelWSheet.iterator();
		while (rowIterator.hasNext()) 
		{
			Row row = rowIterator.next();
			//For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) 
			{
				Cell cell = cellIterator.next();
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(cell);
				//Checking if the cell data matches the text in the parameter
				if(cellData.equalsIgnoreCase(text))
					{
					//assigning the corresponding row and column index
					rn= cell.getRowIndex();
					cn=cell.getColumnIndex();
					}
				
				else
					continue;
			}

		}
		
		//returning row/column index depending on index type
		if(index_type=='r')
			return rn;
		else if(index_type=='c')
			return cn;
		else
			return 0;
		
	}
	
	/*public void readExpectedData(int rno)
	{
		
		try {
			int hotelindex=ExcelUtil.readExcel('c', "Hotels");	
			expected_hotel=ExcelUtil.getCellData(rno, hotelindex);
			int location_index=ExcelUtil.readExcel('c', "Location");
			expected_location=ExcelUtil.getCellData(rno, location_index);
			int room_no=ExcelUtil.readExcel('c', "Number of Rooms");
			room_nu=ExcelUtil.getCellData(rno, room_no);
			int arrdate_index=ExcelUtil.readExcel('c', "Check-in Date");
			arr_date=ExcelUtil.getCellData(rno, arrdate_index);
			int dep_index=ExcelUtil.readExcel('c', "Check-out Date");
			dep_dat=ExcelUtil.getCellData(rno, dep_index);
			int dayno=ExcelUtil.readExcel('c', "Check-out Date");
			
			
		}catch(Exception e)
		{
			Log.error("Error occurred while reading expected data from the test data file");
		}
		
	}*/

	/**
	 * This method gets excel file, row and column number and set a value to the that cell.
	 * @param value
	 * @param RowNum
	 * @param ColNum
	 * @throws Exception
	 */
	public static void setCellData(String value, int RowNum, int ColNum) throws Exception {
		try {
			//Retrieves the cell in the given row and column
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				//Creating new cell if null and setting cell value
				cell = row.createCell(ColNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Writing into the file
			FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
