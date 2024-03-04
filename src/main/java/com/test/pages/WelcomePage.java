package com.test.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class WelcomePage extends TestBase {
	
	@FindBy(xpath="//li[@id='menu-item-27617']//a[@class='menu-link']//span[@class='menu-text' and text()='Resources']")
	WebElement resource;
	
	@FindBy(xpath = "//li[@id='menu-item-27618']//span[text()='Practice Site 1']")
    WebElement site1;
	
	@FindBy(xpath= "//li[@id='menu-item-27619']//span[text()='Practice Site 2']")
	WebElement site2;
	
public WelcomePage()
{
	PageFactory.initElements(driver, this);	
	
	}

public String validatePageTitle()
{
	return driver.getTitle();
	
}

public PracticeSite1PageExcel practice1()




{
	resource.click();
	Actions action= new Actions(driver);	
	action.moveToElement(site1).build().perform();
	site1.click();
	
	return new PracticeSite1PageExcel();
	
	
}

public PracticeSite2Page practice2()
{
	resource.click();
	Actions action= new Actions(driver);	
	action.moveToElement(site2).build().perform();
	site2.click();
	return new PracticeSite2Page();
}
}
