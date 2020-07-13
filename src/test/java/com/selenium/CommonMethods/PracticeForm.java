package com.selenium.CommonMethods;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeForm extends CommonMethods {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		Properties prop = Initialize();
		LaunchBrowser(driver);
		EntryDetails(driver, prop);
		SubmitForm(driver, prop);
		getscreenshot(driver, "D:\\ConfirmationMsg.png");
	}

}
