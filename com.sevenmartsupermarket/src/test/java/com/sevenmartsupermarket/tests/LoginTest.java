package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {

	LoginPage loginpage;
	HomePage homepage;

	@Test
	public void verifyUserLogin() {

		loginpage = new LoginPage(driver);
		loginpage.login();
	}

	@Test

	public void getUserName() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test

	public void invalidLoginTest() {
		loginpage = new LoginPage(driver);
		loginpage.login("Raji", "raji");
		

	}
	@Test
	public void logout()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		loginpage.logoutuser();
	}
	

}
