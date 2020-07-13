package com.selenium.CommonMethods;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreApplication extends CommonMethods {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Properties prop = new Properties();

		prop = Initialize();
		LaunchBrowser(driver);
		Login(driver, prop, prop.getProperty("Myusername"), prop.getProperty("Mypassword"));
		BookStore(driver, prop);
		Profile(driver, prop, prop.getProperty("Myusername"));
		LogOut(driver, prop);
		getscreenshot(driver, "D:\\LogOut.png");
	}

}
