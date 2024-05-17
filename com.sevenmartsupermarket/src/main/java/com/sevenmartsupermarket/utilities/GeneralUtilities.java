package com.sevenmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtilities {
	public String get_attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public List<String> gettextOfelements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

	public String getCssProperties(WebElement element, String css) {
		return element.getCssValue(css);
	}
	public static String getRandomFullName() {
		Faker faker=new Faker();
		return faker.name().fullName();
	}
	public boolean isTextContains(WebElement element,String expectedText)
	{
		return element.getText().contains(expectedText);
	}
}
