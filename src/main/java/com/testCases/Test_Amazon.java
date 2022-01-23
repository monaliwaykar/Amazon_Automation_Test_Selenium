package com.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.AddtoCartPage;
import com.pages.HomePage;
import com.pages.SearchPage;
public class Test_Amazon {
	
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    AddtoCartPage addToCartPage;
   
       
	@BeforeSuite
	public void launchwebsite()
	{
		//chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\XXXX\Downloads\\Automation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//open website
		driver.get("https://www.amazon.in/");
		//maximize
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=0,enabled=true)
	public void searchProduct() 
	{
		homePage = new HomePage(driver);
		homePage.verifyTitle();
		homePage.selectCategory();
		homePage.enterSearchValue();
	}
	
	@Test(priority=1,enabled=true)
	public void verifyProduct() 
	{
		searchPage = new SearchPage(driver);
		searchPage.verifyFirstValue();
		searchPage.clickFirstValue();
	}
	
	@Test(priority=2,enabled=true)
	public void addToCart() 
	{
		addToCartPage = new AddtoCartPage(driver);
		addToCartPage.addToCart();
		addToCartPage.verifyItemAdded();
	}
	
	@AfterSuite
	public void CloseChrome()
	{
		driver.quit();
	}
	
}
