package com.test.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try{
			prop= new Properties();
			FileInputStream fi = new FileInputStream("C:\\Users\\aisha\\eclipse-workspace\\qa\\src\\main\\java\\com\\test\\config\\config.properties");
			prop.load(fi);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aisha\\eclipse-workspace\\SeleniumWebDriver2\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
		
			System.out.println("firefox driver");
		}
				
			
	
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT_TIME));
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.get(prop.getProperty("url"));
	
}
}
