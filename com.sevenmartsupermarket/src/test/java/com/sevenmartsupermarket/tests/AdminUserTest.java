package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtilities;
import com.sevenmartsupermarket.utilities.ScreenShotCapture;



public class AdminUserTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;
	ExcelReader excelread = new ExcelReader();

	@Test
	public void adminUserClick() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
        
	}
	@Test 
	public void verifyNewUserCreation()
	{
		ScreenShotCapture screenshotcapture=new ScreenShotCapture();
		loginpage = new LoginPage(driver);
		loginpage.login();
		//homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
        adminuserpage.newButtonClick();	
        excelread.setExcelFile("UserCreationData", "UserData");
        String username = excelread.getCellData(2, 0);
        username=username+GeneralUtilities.getRandomFullName();
        screenshotcapture.takeScreenshot(driver, "screenshot1");
        String password = excelread.getCellData(2, 1);
		String usertype = excelread.getCellData(2, 2);
		adminuserpage.saveUser(username, password, usertype); 
		String actual = adminuserpage.getTextAlertMessage();
		String expected = "User Created Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
		
       
        
	}
	@Test(dataProvider = "NewSearchData", dataProviderClass = DataProviderNew.class)
	
	public void searchUser(String username ,String userType)throws InterruptedException
	{
		//ScreenShotCapture screenshotcapture=new ScreenShotCapture();
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.searchUser();
		adminuserpage.searchUsername(username);
		adminuserpage.searchUserType(userType);
		adminuserpage.searchClick();
		//screenshotcapture.takeScreenshot(driver, "screenshot1");
		
	}//listeners-interface whether testcase passed or failed
	
	@Test(dataProvider = "NewSearchData", dataProviderClass = DataProviderNew.class)
	public void verifyUser(String username ,String userType)throws InterruptedException
	{
		
		loginpage = new LoginPage(driver);
		loginpage.login();
		//homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.searchUser();
		adminuserpage.searchUsername(username);
		adminuserpage.searchUserType(userType);
		adminuserpage.searchClick();
		 
		String actualUserName=adminuserpage.verifyUserdata();
		String expectedUserNmae="tomy";
		Assert.assertEquals(actualUserName, expectedUserNmae);
		
	}
	@Test
	public void verifyCreatedUserLogin() //create user-login-logout-login and check whether same newly created user login
	
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		String userName = GeneralUtilities.getRandomFullName();
		String passWord = GeneralUtilities.getRandomFirstName();
		String userTypes="Staff";
		adminuserpage.newButtonClick();	
		adminuserpage.saveUser(userName, passWord, userTypes);
		
		homepage.logout();
		loginpage.login(userName, passWord);
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName=userName;
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	
	}
	@Test
	public void listNames()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.listAllUsers();
	}
	
	@Test
	public void verifyDeactivationFunctionality() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.deactivateUser("Trump");
	}
	}
	
	

