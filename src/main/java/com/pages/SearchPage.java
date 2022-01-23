package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.GetData;

public class SearchPage {
	
	WebDriver driver;
	String value = "";
	GetData get;
	
	@FindBy(xpath="//span[contains(text(),'Get It in')]//preceding-sibling::div//label")
    WebElement chBox_GetIn;
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    WebElement text_FirstValue;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyFirstValue()
	{
		if(!chBox_GetIn.isSelected()){
			chBox_GetIn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		value = text_FirstValue.getText();
		System.out.println("1st value:"+value);
	}
	
	public void clickFirstValue(){
		text_FirstValue.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
