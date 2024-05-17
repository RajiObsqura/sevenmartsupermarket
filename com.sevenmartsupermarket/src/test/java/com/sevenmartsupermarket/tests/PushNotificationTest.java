package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotification;
import com.sevenmartsupermarket.utilities.ExcelReader;
public class PushNotificationTest extends Base
{
	LoginPage loginpage;
	PushNotification pushnotificationpage;
	ExcelReader excelread=new ExcelReader();
	
	HomePage homepage;
	@Test
	public void pushnotificationClick() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.pushNotificationClick();
		pushnotificationpage=new PushNotification(driver);
		
	}
	@Test
	public void verifySendNotification() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.pushNotificationClick();
		pushnotificationpage=new PushNotification(driver);
		pushnotificationpage.sendNotification("its a title", "its a description");
		boolean displayed=pushnotificationpage.alert_PushCloseButtonDisplayed();
		Assert.assertTrue(displayed);
		
		excelread.setExcelFile("PushNotificationExcel", "Notification"); //workbookname, sheetName
		String title = excelread.getCellData(1, 0);
		String description = excelread.getCellData(1, 1);
		
		pushnotificationpage.sendNotification(title, description);
		String actualAlertMsg= pushnotificationpage.verifyAlertMsg();
		String expectedAlertMsg="Message send successfully";
		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMsg));
		
	}

}
