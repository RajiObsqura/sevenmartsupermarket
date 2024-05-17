package com.sevenmartsupermarket.tests;

import org.testng.annotations.DataProvider;

public class DataProviderNew {

	@DataProvider(name="usertypelist")
	public Object[][] usertypelist()
	{
		return new Object [][] {{"staff"}};
	}
	@DataProvider(name="SearchData")
	public Object[][] searchdetails()
	{
		return new Object [][] {{"raj","db"},
			                    {"tomy","admin"}};
	}
}
