package com.selenium.CommonMethods;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleAssignRough extends CommonMethods {

	public static void main(String args[]) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		Properties prop = Initialize();
		LaunchBrowser(driver);
		
		driver.findElement(By.xpath(prop.getProperty("Elements"))).click();
		Actions action = new Actions(driver);
		pageDown("xpath", prop.getProperty("BtnTextVal"), driver);
		Button("xpath", prop.getProperty("BtnTextVal"), driver);
		action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
		action.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();

// ----------------------------------------------link=----------------------------------------
		
		pageDown("xpath", prop.getProperty("LinkVal"), driver);
		Link("xpath", prop.getProperty("LinkVal"), driver);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links: " + links.size());
		System.out.println("List of links available in the page:");
		for (int i = 1; i <= links.size(); i = i + 1)
		{
			System.out.println(links.get(i).getText());
			if (i == (links.size() - 1)) {
				Link("id", prop.getProperty("FirstLink"), driver);
				Thread.sleep(3000);
				String originalHandle = driver.getWindowHandle();
				for (String handle : driver.getWindowHandles()) {
					if (!handle.equals(originalHandle)) {
						driver.switchTo().window(handle);
						driver.close();
					}
				}
				driver.switchTo().window(originalHandle);
				break;
			}
		}
		pageDown("xpath", prop.getProperty("UpandDown"), driver);

//-----------------------Upload and Download----------------------------------------

		Link("xpath", prop.getProperty("UpandDown"), driver);
		Link("text", prop.getProperty("DownloadVal"), driver);
		Thread.sleep(3000);
		UploadFile(driver, prop, "C:\\Users\\user-pc\\UploadFile.txt");
		WebElement Path = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));
		System.out.println("File path is : " + Path.getText());

//-----------------------Dynamic Properties-----------------------------------------

		pageDown("xpath", prop.getProperty("DynaProp"), driver);
		Link("xpath", prop.getProperty("DynaProp"), driver);

		List<WebElement> ListOfButtons = driver.findElements(By.tagName("button"));
		System.out.println("Waiting for 5 seconds");
		Thread.sleep(3000);
		System.out.println("Total no of buttons: " + (ListOfButtons.size() - 1));
		System.out.println("List of buttons available in the page:");
		for (int i = 1; i <= ListOfButtons.size(); i = i + 1)
		{
			System.out.println(ListOfButtons.get(i).getText());
			if (i == (ListOfButtons.size() - 1)) {
				break;
			}
		}

//----------------------Frames and Windows--------------------------------------------
		pageDown("xpath", prop.getProperty("FrameWin"), driver);
		Link("xpath", prop.getProperty("FrameWin"), driver);
		Thread.sleep(3000);
		Link("xpath", prop.getProperty("Frames"), driver);
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText());
		driver.switchTo().defaultContent();

//-----------------------Modal dialogs------------------------------------------------
		pageDown("xpath", prop.getProperty("ModalDial"), driver);
		Link("xpath", prop.getProperty("ModalDial"), driver);
		Link("xpath", prop.getProperty("SmallModal"), driver);
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-content']")).getText());
		Link("id", prop.getProperty("ClseBtn"), driver);

//-----------------------Widgets--Tabs----------------------------------------------------
		pageDown("xpath", prop.getProperty("Widgets"), driver);
		Link("xpath", prop.getProperty("Widgets"), driver);
		pageDown("xpath", prop.getProperty("TabsEle"), driver);
		Link("xpath", prop.getProperty("TabsEle"), driver);

		List<WebElement> ListOfTabs = driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		System.out.println("Total no of Tabs: " + (ListOfTabs.size() - 1));
		System.out.println("List of tabs available in the page:");
		for (int i = 1; i <= ListOfTabs.size(); i = i + 1) {
			System.out.println(ListOfTabs.get(i).getText());
			if (i == (ListOfTabs.size() - 1)) {
				Link("xpath", prop.getProperty("TabOrigin"), driver);
				break;
			}
		}

//-----------------------Tool Tips------------------------------------------------------
		pageDown("xpath", prop.getProperty("ToolTips"), driver);
		Link("xpath", prop.getProperty("ToolTips"), driver);
		ToolTip(driver, prop, prop.getProperty("ToolTipBtn"), prop.getProperty("ToolTipField"));

//------------------------Menu----------------------------------------------------------
		pageDown("xpath", prop.getProperty("Menu"), driver);
		Link("xpath", prop.getProperty("Menu"), driver);
		Thread.sleep(3000);
		WebElement mainMenu = driver.findElement(By.xpath(prop.getProperty("Menu_2")));
		WebElement SubMenu = driver.findElement(By.xpath(prop.getProperty("submenuxpath")));
		WebElement Course = driver.findElement(By.xpath(prop.getProperty("SubMenu1")));
		Thread.sleep(3000);

		action.moveToElement(mainMenu).perform();
		action.moveToElement(SubMenu).perform();
		Thread.sleep(1000);
		action.moveToElement(Course).click().perform();
		Thread.sleep(3000);

//------------------------Select---------------------------------------------------------
		pageDown("xpath", prop.getProperty("SelectMenu"), driver);
		Link("xpath", prop.getProperty("SelectMenu"), driver);
		Select("xpath", driver, prop, prop.getProperty("SelectOld"), prop.getProperty("SelectOldValue"));
		Link("xpath", prop.getProperty("SelectOption"), driver);
		Select("xpath", driver, prop, prop.getProperty("SelectOption"), prop.getProperty("SelectOptionValue"));
		Select("xpath", driver, prop, prop.getProperty("SelectTitle"), prop.getProperty("SelectTitleValue"));

//-------------------------Interactions---------------------------------------------------
		pageDown("xpath", prop.getProperty("Interactions"), driver);
		Link("xpath", prop.getProperty("Interactions"), driver);
		Link("xpath", prop.getProperty("Resizeable"), driver);
		Resizeable(driver, prop, prop.getProperty("ResizeableBtn"));

//----------------------------drag and drop------------------------------------------------
		DragandDrop(driver, prop, prop.getProperty("DraggableEle"), prop.getProperty("DroppableEle"));

	}
}
