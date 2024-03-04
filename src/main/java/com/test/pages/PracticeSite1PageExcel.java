package com.test.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.qa.base.TestBase;

public class PracticeSite1PageExcel extends TestBase{
	
		
	@FindBy(xpath="//input[@type='text' and @name ='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@type='tel' and @name ='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@type='email' and @name ='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@type='text' and @name ='city']")
	WebElement city;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[6]/input")
	WebElement uname;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[7]/input")
	WebElement pswd;
	
	@FindBy(xpath="//select[@name ='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@type='submit']//parent::div[@class='span_1_of_4']//preceding-sibling::div//p[text() = 'Already Have an Account? | ']")
	WebElement submit;
	
	@FindBy(xpath="//p[@id='alert']")
	WebElement alertval;
	
	public PracticeSite1PageExcel()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle()
	{
	
		return driver.getTitle();
	}
	
	public void selectForm()
	{
		driver.findElement(By.xpath("//div[@id='load_box']"));
	}
	
	public void fillForm(String usname ,String usphone ,String usemail, String uscountry,String uscity, String ususrname ,String uspswd)
	{
		name.sendKeys(usname);
		phone.sendKeys(usphone);
		email.sendKeys(usemail);
		Select select = new Select(country);
		select.selectByVisibleText(uscountry);
		city.sendKeys(uscity);
		pswd.sendKeys(uspswd);
		uname.sendKeys(ususrname);
	}
  
  public void submitform()
  {
	  submit.click();
	  
	  
  }
	
  public String alertreceived()
  {
	/*  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert); */
	
	  return alertval.getText();
  }
  
  public void selectCountry(String countryname)
  {
	  
	/*  List<WebElement> countrylist = driver.findElements(By.tagName("option"));
	  for(int i=0;i<countrylist.size();i++)
	  {
		System.out.println("List of countries are" +countrylist.get(i).getText());  
	  } */
	  Select select = new Select(country);
	  select.selectByValue(countryname);
	  
  }
	
	
	
	

	
	
	
	
	

} 
