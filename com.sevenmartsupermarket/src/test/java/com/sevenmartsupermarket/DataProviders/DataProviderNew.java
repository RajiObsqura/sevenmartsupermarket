package com.sevenmartsupermarket.tests;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelReader;

  public class DataProviderNew {
 ExcelReader excelread=new ExcelReader();
	
 

   @DataProvider(name="SearchData")
	public Object[][] searchdetails()
	{
	return new Object [][] {{"raj","db"},{"tomy","admin"}};
		
	}
   
   //this dataprovider is used to read data from the excel .so need to create a ExcelReader object and that object calls the excel sheet .we nned to give the matrix size in our sheet.
   @DataProvider(name="NewSearchData")
	public Object[][] searchdetailsNew()
	{
	
		excelread.setExcelFile("UserCreationData","SearchDataWithExcel");
		return excelread.getMultidimentionalData(2,2);
	}
	
}
 
  
