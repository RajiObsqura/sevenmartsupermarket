package com.sevenmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtilities(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

	}

	public void selectBYIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

	public void selectBYValue(WebElement element, String value) {
		Select select = new Select(element);
		// select.deselectByIndex(index);

	}

	public void acceptByValue() {
		driver.switchTo().alert().accept();

	}

	public void scrollIntoElement() {

	}

	public void dismissAlert() {

	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}

	}

	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
