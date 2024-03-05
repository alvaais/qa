package qa;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.test.pages.PracticeSite1PageExcel;
import com.test.pages.PracticeSite2Page;
import com.test.pages.WelcomePage;
import com.test.qa.base.TestBase;


//Modified the existing test case to push to git ....no other change
//dummy
//dummy


public class WelcomePageTest extends TestBase {
	Logger log = Logger.getLogger(WelcomePageTest.class);
	WelcomePage welcome;
	
	PracticeSite1PageExcel pcsite1;
	PracticeSite2Page pcsite2;
	
	
	
	public WelcomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	
	public void setUp()
	{
		log.info("Launching browser");
		initialization();
		welcome = new WelcomePage();
		log.info("page launched successfully");
	}
	
	@Test(priority=1)
	public void validatePageTitle()
	{
		log.info("validating page title");
		String title = welcome.validatePageTitle();
		Assert.assertEquals(title, "Get Online Selenium Certification Course | Way2Automation");
	}
	
	@Test(priority=2)
	public void validatePracticeSite1() throws InterruptedException
	{
		log.info("validating PracticeSite1");
		pcsite1 = welcome.practice1();
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void validatePracticeSite2() throws InterruptedException
	{
		log.info("validating PracticeSite2");
		pcsite2 = welcome.practice2();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
		log.info("Browser closed successfully");
	}

}
