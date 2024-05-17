package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;



public class AdminUserTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test
	public void adminUserClick() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
        
	}
	@Test 
	public void addNewUser()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
        adminuserpage.newButtonClick();	
        adminuserpage.getUserNameClick();
        adminuserpage.getStaffType();
        adminuserpage.savenewuser();
        
	}
	@Test(dataProvider = "SearchData", dataProviderClass = DataProviderNew.class)
	
	public void searchUser(String username ,String userType)throws InterruptedException
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.adminUserClick();
		adminuserpage.searchUser();
		adminuserpage.searchUsername(username);
		adminuserpage.searchUserType(userType);
		adminuserpage.searchClick();
	}
	
	}

