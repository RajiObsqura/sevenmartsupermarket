package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtilities;


public class ManageProductTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ManageProductPage manageproductpage;
	//private WebDriver driver;
	
	@Test
	public void manageproductclick()
	{  
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		manageproductpage=new ManageProductPage(driver);
		manageproductpage.manageProductButtonclick();
	}
    
	@Test
	public void searchItem()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		manageproductpage=new ManageProductPage(driver);
		manageproductpage.manageProductButtonclick();
		manageproductpage.searchForProductClick();
		manageproductpage.searchElementTitle();
		manageproductpage.searchForProductitem();
		String actualItemName=manageproductpage.verifyTableItemdata();
		String expectedItemName="Biriyani P1142 Combo";
		Assert.assertEquals(actualItemName, expectedItemName);
	}
	@Test
public void deleteItem()
{
	loginpage = new LoginPage(driver);
	loginpage.login();
	homepage = new HomePage(driver);
	manageproductpage=new ManageProductPage(driver);
	manageproductpage.manageProductButtonclick();
}



}
