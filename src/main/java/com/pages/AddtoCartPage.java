package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.GetData;

public class AddtoCartPage {
	
	WebDriver driver;
	GetData get;
	
	@FindBy(id="add-to-cart-button")
    WebElement button_AddtoCart;
	@FindBy(xpath="//div[@id='attachDisplayAddBaseAlert']//span")
    WebElement text_AddedToCart;
	
	public AddtoCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart()
	{
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button_AddtoCart);
		button_AddtoCart.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void verifyItemAdded(){
		if(text_AddedToCart.isDisplayed()){
			System.out.println("Item successfully added to cart!!!!");
		}
	}
	
}
