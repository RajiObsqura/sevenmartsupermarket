package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;



public class ManageLocationTest extends Base
{
	LoginPage loginpage;
	HomePage homepage;
	ManageLocationPage managelocationpage;
	
	@Test 
		public void managelocationClick()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.manageLocationButtonclick();
	
	}
	
	@Test
	public void VerifyaddLocation()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.manageLocationButtonclick();
		managelocationpage.newButtonClick();
		managelocationpage.addNewLocation();
		System.out.println("TeXT");
		//managelocationpage.alertCheckForAddLocation();
		String actualAlertText=managelocationpage.alertCheckForAddLocation();
		String expectedAlertText="Location Created Successfully";
		Assert.assertEquals(actualAlertText, expectedAlertText);
	}
}
