package com.selenium.CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CommonMethods {

	public static void Button(String Type, String Value, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).click();
			break;
		case "id":
			driver.findElement(By.id(Value)).click();
			break;
		case "text":
			driver.findElement(By.linkText(Value)).click();
			break;
		default:
			break;
		}
	}

	public static void Link(String Type, String Value, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).click();
			break;
		case "id":
			driver.findElement(By.id(Value)).click();
			break;
		case "text":
			driver.findElement(By.linkText(Value)).click();
			break;
		case "name":
			driver.findElement(By.name(Value)).click();
			break;
		default:
			break;
		}

	}

	public static void TextBox(String Type, String Value, String Val, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).clear();
			driver.findElement(By.xpath(Value)).sendKeys(Val);
			break;
		case "id":
			driver.findElement(By.id(Value)).clear();
			driver.findElement(By.id(Value)).sendKeys(Val);
			break;
		case "text":
			driver.findElement(By.linkText(Value)).clear();
			driver.findElement(By.linkText(Value)).sendKeys(Val);
			break;
		default:
			break;
		}
	}

	public static void RadioBtn(String Type, String Value, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).click();
			break;
		case "id":
			driver.findElement(By.id(Value)).click();
			break;
		case "text":
			driver.findElement(By.linkText(Value)).click();
			break;
		default:
			break;
		}
	}

	public static void CheckBox(String Type, String Value, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).click();
			break;
		case "id":
			driver.findElement(By.id(Value)).click();
			break;
		case "text":
			driver.findElement(By.linkText(Value)).click();
			break;
		default:
			break;
		}
	}

	public static void DropDown(String Type, String Value, String Val, WebDriver driver) throws IOException {

		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(Value)).click();
			driver.findElement(By.xpath(Value)).sendKeys(Val);
			driver.findElement(By.xpath(Value)).sendKeys(Keys.TAB);
			break;
		case "id":
			driver.findElement(By.id(Value)).click();
			driver.findElement(By.id(Value)).sendKeys(Val);
			driver.findElement(By.id(Value)).sendKeys(Keys.TAB);
			break;
		case "text":
			driver.findElement(By.linkText(Value)).click();
			driver.findElement(By.linkText(Value)).sendKeys(Val);
			driver.findElement(By.linkText(Value)).sendKeys(Keys.TAB);
			break;
		default:
			break;
		}
	}

	public static void getscreenshot(WebDriver driver, String Path) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(Path));
	}

	public static void pageDown(String Type, String Value, WebDriver driver) throws InterruptedException {

		switch (Type) {
		case "xpath":
			WebElement Element = driver.findElement(By.xpath(Value));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(3000);
			break;
		case "id":
			WebElement Element1 = driver.findElement(By.id(Value));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element1);
			Thread.sleep(3000);
			break;
		case "text":
			WebElement Element2 = driver.findElement(By.linkText(Value));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Element2);
			Thread.sleep(3000);
			break;
		default:
			break;
		}

	}

	public static Properties Initialize() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(
				"D:\\kali\\WorkBench\\ScubaAssignment\\src\\test\\java\\com\\selenium\\CommonMethods\\config.properties");
		prop.load(input);
		return prop;
	}

	public static void DragandDrop(WebDriver driver, Properties prop, String FromEle, String ToEle) throws Exception {
		pageDown("xpath", prop.getProperty("Droppable"), driver);
		Link("xpath", prop.getProperty("Droppable"), driver);
		Thread.sleep(3000);
		WebElement From = driver.findElement(By.xpath(FromEle));
		WebElement To = driver.findElement(By.xpath(ToEle));
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To).build().perform();
		Thread.sleep(3000);

	}

	public static void LaunchBrowser(WebDriver driver) throws Exception {
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	public static void EntryDetails(WebDriver driver, Properties prop) throws Exception {

		driver.findElement(By.xpath(prop.getProperty("Forms"))).click();
		pageDown("xpath", prop.getProperty("PracticeForm"), driver);

		Button("xpath", prop.getProperty("PracticeForm"), driver);
		TextBox("id", prop.getProperty("FirstName"), prop.getProperty("txt_firstName"), driver);
		TextBox("id", prop.getProperty("LastName"), prop.getProperty("txt_latName"), driver);
		TextBox("id", prop.getProperty("emailID"), prop.getProperty("email"), driver);
		RadioBtn("xpath", prop.getProperty("GenderSel"), driver);
		TextBox("id", prop.getProperty("emailID"), prop.getProperty("email"), driver);
		TextBox("id", prop.getProperty("MobNumber"), prop.getProperty("mobileNumber"), driver);
		SelectDate(driver, prop);
		DropDown("id", prop.getProperty("Subject"), prop.getProperty("SubVal"), driver);
		CheckBox("xpath", prop.getProperty("Music"), driver);
		UploadFile(driver, prop, "C:\\Users\\user-pc\\SampleFile.txt");
		TextBox("id", prop.getProperty("CrrentAdrs"), prop.getProperty("CurrentAddress"), driver);
		DropDown("id", prop.getProperty("SelState"), prop.getProperty("StateVal"), driver);
		DropDown("id", prop.getProperty("SelCity"), prop.getProperty("CityVal"), driver);
		getscreenshot(driver, "D:\\PracticeForm.png");
		Reporter.log("All the inputs have been entered");
	}

	public static void UploadFile(WebDriver driver, Properties prop, String Path) throws IOException {
		WebElement uploadElement = driver.findElement(By.xpath(prop.getProperty("UploadVal")));
		uploadElement.sendKeys(Path);
		Reporter.log("File uploaded successfully");
	}

	public static void SubmitForm(WebDriver driver, Properties prop) throws IOException {
		Button("xpath", prop.getProperty("SubmitBtn"), driver);
		String ConfirmationMsg = driver.findElement(By.xpath(prop.getProperty("SubmitConfirmation"))).getText();
		if (ConfirmationMsg.contains("Thanks")) {
			Reporter.log("Form submission is successful");
		} else {
			Reporter.log("Form submission is unsuccessful");
		}

		Reporter.log(ConfirmationMsg);
		Button("xpath", prop.getProperty("CloseBtn"), driver);
	}

	public static void SelectDate(WebDriver driver, Properties prop) throws IOException {

		Button("id", prop.getProperty("DOB"), driver);
		Button("xpath", prop.getProperty("SelectMonth"), driver);
		Select month = new Select(driver.findElement(By.xpath(prop.getProperty("SelectMonth"))));
		month.selectByVisibleText(prop.getProperty("MonthValue"));

		Button("xpath", prop.getProperty("SelectYear"), driver);
		Select year = new Select(driver.findElement(By.xpath(prop.getProperty("SelectYear"))));
		year.selectByVisibleText(prop.getProperty("YearValue"));

		Button("xpath", prop.getProperty("SelectYear"), driver);
		String Se = prop.getProperty("SelectDate") + prop.getProperty("Sdate") + "']";
		Button("xpath", Se, driver);
		String value = driver.findElement(By.id(prop.getProperty("DOB"))).getAttribute("value");
		if (value != null) {
			Reporter.log("Date is selected successfully");
		} else {
			Reporter.log("Date is not selected");
		}

	}

	public static void Resizeable(WebDriver driver, Properties prop, String Value) throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver); 
		WebElement elementToResize = driver.findElement(By.xpath(Value));
		action.clickAndHold(elementToResize).moveByOffset(200, 200).release().build().perform();
	}
	
	public static void ToolTip(WebDriver driver, Properties prop, String ToolTipBtn, String ToolTipField) throws InterruptedException {
		Thread.sleep(2000);
		WebElement ToolTip = driver.findElement(By.id(ToolTipBtn));
		Actions action = new Actions(driver);
		action.moveToElement(ToolTip).perform();
		WebElement ToolTipTxtField = driver.findElement(By.id(ToolTipField));
		action.moveToElement(ToolTipTxtField).perform();
		Thread.sleep(3000);
	}
	
	public static void Login(WebDriver driver, Properties prop, String UserName, String Password) throws Exception {
		Button("xpath", prop.getProperty("BookStoreApp"), driver);
		Thread.sleep(3000);
		Button("xpath", prop.getProperty("LoginBtn"), driver);
		TextBox("id", prop.getProperty("TxtuserName"), UserName, driver);
		TextBox("id", prop.getProperty("TxtpassWord"), Password, driver);
		Button("xpath", prop.getProperty("LoginBtn"), driver);
		Thread.sleep(3000);
		if (UserName.equals((driver.findElement(By.xpath("//label[@id='userName-value']")).getText()))) {
			Reporter.log("Loginn is successful");
		} else {
			Reporter.log("Login is unsuccessful");
		}
	}

	public static String alert(WebDriver driver) {
		String alrt = driver.switchTo().alert().getText();
		System.out.println("Alert msg is :" + alrt);
		driver.switchTo().alert().accept();
		return alrt;
	}

	public static void BookStore(WebDriver driver, Properties prop) throws Exception {
		DropDown("xpath", prop.getProperty("SearchTxtBox"), prop.getProperty("BookName"), driver);
		String Book = prop.getProperty("BookSrchNme") + prop.getProperty("BookName");
		Link("id", Book, driver);
		Thread.sleep(3000);
		getscreenshot(driver, "D:\\BookSelected.png");
		pageDown("xpath", prop.getProperty("AddToBookStoreBtn"), driver);
		Button("xpath", prop.getProperty("AddToBookStoreBtn"), driver);
		Thread.sleep(3000);

		String alr = alert(driver);
		if (alr.contains("already present")) {
			Button("xpath", prop.getProperty("BackToBookStoreBtn"), driver);
			String Book2 = prop.getProperty("BookSrchNme") + prop.getProperty("BookName2");
			Link("id", Book2, driver);
			Thread.sleep(3000);
			getscreenshot(driver, "D:\\NewBookSelected.png");
			pageDown("xpath", prop.getProperty("AddToBookStoreBtn"), driver);
			Button("xpath", prop.getProperty("AddToBookStoreBtn"), driver);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Reporter.log("New book is selected successfully");
		} else {
			Reporter.log("Book is selected successfully");
		}
	}

	public static void Profile(WebDriver driver, Properties prop, String UserName) throws Exception {
		Button("xpath", prop.getProperty("Profile"), driver);
		DropDown("xpath", prop.getProperty("SearchTxtBox"), prop.getProperty("BookName"), driver);
		String Book = prop.getProperty("BookSrchNme") + prop.getProperty("BookName");
		Link("id", Book, driver);
		Thread.sleep(3000);
		pageDown("xpath", prop.getProperty("BackToBookStoreBtn"), driver);
		Button("xpath", prop.getProperty("BackToBookStoreBtn"), driver);

		if (UserName.equals((driver.findElement(By.xpath("//label[@id='userName-value']")).getText()))) {
			Reporter.log("Loginn is successful");
		} else {
			Reporter.log("Login is unsuccessful");
		}
		getscreenshot(driver, "D:\\BookInProfile.png");
	}

	public static void LogOut(WebDriver driver, Properties prop) throws IOException {
		Button("xpath", prop.getProperty("LogoutBtn"), driver);
		if (((driver.findElement(By.xpath("//div[@class='main-header']")).getText())).equals("Login")) {
			Reporter.log("LogOut is successful");
		} else {
			Reporter.log("LogOut is unsuccessful");
		}
	}

	public static void Select(String Type,WebDriver driver, Properties prop, String SelectEle, String SelectValue) {
		switch (Type) {
		case "xpath":
			driver.findElement(By.xpath(SelectEle)).click();
			Select Option = new Select(driver.findElement(By.xpath(SelectEle)));
			Option.selectByVisibleText(SelectValue);
			break;
		case "id":
			driver.findElement(By.id(SelectEle)).click();
			Select Option1 = new Select(driver.findElement(By.xpath(SelectEle)));
			Option1.selectByVisibleText(SelectValue);
			break;
		case "text":
			driver.findElement(By.linkText(SelectEle)).click();
			Select Option2 = new Select(driver.findElement(By.xpath(SelectEle)));
			Option2.selectByVisibleText(SelectValue);
			break;
		default:
			break;
		}
		
    }
	
}
