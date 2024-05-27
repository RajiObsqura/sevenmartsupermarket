package com.sevenmartsupermarket.tests;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.DataProviders.DataProviderNew;
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
		String actual = adminuserpage.getTextOfAdminUser();
		String expected="Admin Users";
		Assert.assertEquals(actual,expected);
		
		
        
	}
	@Test( groups=("smoke"),retryAnalyzer = com.sevenmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyNewUserCreation()
	{
		//ScreenShotCapture screenshotcapture=new ScreenShotCapture();
		loginpage = new LoginPage(driver);
		loginpage.login();
		//homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
        adminuserpage.newButtonClick();	
        excelread.setExcelFile("UserCreationData", "UserData");
        String username = excelread.getCellData(2, 0);
        username=username+GeneralUtilities.getRandomFullName();
       // screenshotcapture.takeScreenshot(driver, "screenshot1");
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
		//Boolean verifyText=adminuserpage.searchUserResult().equalsIgnoreCase(".........RESULT NOT FOUND.......");
		//assertFalse(verifyText);
		//screenshotcapture.takeScreenshot(driver, "screenshot1");
		
	}//listeners-interface whether testcase passed or failed
	
	@Test(dataProvider = "SearchDataNew", dataProviderClass = DataProviderNew.class)
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
		String expectedUserName="Rakhee";
		Assert.assertEquals(actualUserName, expectedUserName);
		
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
	@Test (groups="smoke")
	public void VerifylistNames()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.listAllUsers();
	}
	
	@Test (groups={"sanity","first"})
	public void verifyDeactivationFunctionality() 
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.deactivateUser("ee1");
		driver.switchTo().alert().accept();
		String actual = adminuserpage.getTextAlertMessage();
		String expected = "User Status Changed Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
	}
	@Test 
	public void VerifydeleteUser()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		 adminuserpage.newButtonClick();
		excelread.setExcelFile("UserDeleteData", "AddUser");
		String username = excelread.getCellData(2, 0);
		//username=username+GeneralUtilities.getRandomFullName();
        String password = excelread.getCellData(2, 1);
		String usertype = excelread.getCellData(2, 2);
		adminuserpage.saveUser(username, password, usertype); 
		//searching created user
		adminuserpage.searchUser();
		excelread.setExcelFile("UserDeleteData", "SearchData");
		String username1 = excelread.getCellData(1, 0);
		String usertype1 = excelread.getCellData(1, 1);
		adminuserpage.searchUsername(username1);
		adminuserpage.searchUserType(usertype1);
		adminuserpage.searchClick();
		adminuserpage.deleteUser();
		driver.switchTo().alert().accept();
		String actual = adminuserpage.getTextAlertMessage();
		String expected = "User Deleted Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
		
	}
	@Test
	public void editUser()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		 adminuserpage.newButtonClick();
		excelread.setExcelFile("UserEditData", "UserAdd");
		String username = excelread.getCellData(2, 0);
		username=username+GeneralUtilities.getRandomFullName();
        String password = excelread.getCellData(2, 1);
		String usertype = excelread.getCellData(2, 2);
		adminuserpage.saveUser(username, password, usertype); 
		//searching created user
		adminuserpage.searchUser();
		excelread.setExcelFile("UserEditData", "UserSearch");
		//String username1 = excelread.getCellData(1, 0);
		
		String usertype1 = excelread.getCellData(1, 1);
		adminuserpage.searchUsername(username);
		adminuserpage.searchUserType(usertype1);
		adminuserpage.searchClick();
		//edit user 
		// new
		adminuserpage.editButtonClick();
		excelread.setExcelFile("UserEditData","UserEdit");
		String username3 = excelread.getCellData(1, 0);
		String password3=excelread.getCellData(1, 1);
		String usertype3= excelread.getCellData(1, 2);
		adminuserpage.updateButtonClick();
		String actual = adminuserpage.getTextAlertMessage();
		String expected = "User Updated Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
	}
	
	}
	
	

