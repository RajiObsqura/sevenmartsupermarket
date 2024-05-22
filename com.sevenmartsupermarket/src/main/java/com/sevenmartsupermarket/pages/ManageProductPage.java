package com.sevenmartsupermarket.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtilities;
import com.sevenmartsupermarket.utilities.PageUtilities;

public class ManageProductPage {
	WebDriver driver;
	PageUtilities pageutility;
	GeneralUtilities generalutilitiy = new GeneralUtilities();

	@FindBy(xpath = "(//a[@class='small-box-footer'])[5]")
	WebElement manageproductbutton;
	@FindBy(xpath = "(//div[@class='card-header'])[2]")
	WebElement listProductHeader;
	
	@FindBy(xpath="//i[@class=' fa fa-search']")
	WebElement searchforproductbutton;
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement titleOfItem;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchItemButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement tabledata;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void manageProductButtonclick() {
		manageproductbutton.click();
	}
	public void searchForProductClick()
	{
		searchforproductbutton.click();
	}
	public void searchElementTitle()
	{
		titleOfItem.sendKeys("Biriyani");
	}
	public void searchForProductitem()
	{
		searchItemButton.click();
	}
	public String  verifyTableItemdata()
	{
		return tabledata.getText();
		
	}
	
		
		
	}


