package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtilities;
import com.sevenmartsupermarket.utilities.PageUtilities;

public class AdminUserPage {
	WebDriver driver;
	PageUtilities pageutility;
	GeneralUtilities generalutilitiy = new GeneralUtilities();
	@FindBy(xpath="(//h4[@class='card-title'])[2]")
	WebElement adminuserpagetitle;
	

	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	WebElement adminbutton;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement newbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newUserAdd;
	// webelements for inputting data
	@FindBy(xpath = "//input[@id='un']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select [@id='user_type']")
	WebElement staff;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submitnewuser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement usernamesearch;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertype;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement searchuserbutton;
    @FindBy(xpath="//span[@id='res']")
    WebElement searchResultNotFound;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement getuserData;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody//tr[1]//td")
	WebElement nameElements;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageUserCreation;

	// deactivate
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	private List<WebElement> usertablenamelist;

	// List users
	@FindBy(xpath = "//tbody//tr//td[1]")
	List<WebElement> listAllUsers;

	// delete user
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deletebutton;
	// edit user
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editbutton;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
    private WebElement updatebutton;
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void adminUserClick() {
		adminbutton.click();
	}
	public String getTextOfAdminUser()
	{
		return adminuserpagetitle.getText();
		
	}

	public void newButtonClick() {
		newUserAdd.click();
	}

	public void getUserNameClick() {
		username.sendKeys("kiran");
	}

	public void getpasswordClick() {
		password.sendKeys("Kiran");
	}

	public void getStaffType() {
		Select select = new Select(staff);
		select.selectByIndex(5);
		select.selectByValue("Delivery Boy");

	}

	public void savenewuser() {
		submitnewuser.click();
	}
	public void updateButtonClick()//edit user details and update
	{
		updatebutton.click();	
	}

	public void searchUser() {
		searchButtton.click();
	}

	public void searchUsername(String username) {
		usernamesearch.sendKeys(username);
	}

	public void searchUserType(String userType) {
		usertype.sendKeys(userType);

	}
	public String searchUserResult()
	{
		return searchResultNotFound.getText();
	}
	
	

	public void searchClick() {
		searchuserbutton.click();
	}

	public String verifyUserdata() {
		return getuserData.getText();
	}

	public void deleteUser()

	{
		deletebutton.click();
	}

	public void editButtonClick() {
		editbutton.click();

	}

	public void listAllUsers() {
		for (WebElement e1 : listAllUsers)
			System.out.println(e1.getText());

	}

	public String getTextAlertMessage() {
		String a = alertMessageUserCreation.getText();
		return a;
	}

	public void saveUser(String username, String password, String usertype) {
		enterUserName(username);
		enterPassword(password);
		selectUserType(usertype);
		saveButtonElement.click();
	}

	public void deactivateUser(String name) {
		pageutility = new PageUtilities(driver);
		List<String> namelist = new ArrayList<String>();
		int a = usertablenamelist.size();
		namelist = generalutilitiy.gettextOfelements(usertablenamelist);
		// System.out.println(namelist);
		int index = 0;
		for (index = 0; index < namelist.size(); index++) {
			if (namelist.get(index).equals(name)) {
				index++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//table//tr[" + index + "]//td[5]//a[1]"));
		pageutility.scrollAndClick(deactivateButton);

	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUserType(String text) {
		// pageutility.select_ByVisibleText(userTypeDropdown, text);
		userTypeDropdown.sendKeys(text);
	}
}
