package qa;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pages.PracticeSite1PageExcel;
import com.test.pages.WelcomePage;
import com.test.qa.base.TestBase;
import com.test.util.TestUtil;

public class PracticeSite1TestExcel extends TestBase {	
	
	PracticeSite1PageExcel ps1t;
	WelcomePage welcome;
	String sheetName ="form";
	
	TestUtil util;
	
	public PracticeSite1TestExcel()
	
	{
		super();
		
	}
	
	@BeforeClass
	public void setUp()
	
	{
		initialization();
		ps1t= new PracticeSite1PageExcel();
		welcome = new WelcomePage();
		ps1t=welcome.practice1();
		util = new TestUtil();
	}
	
	@Test
	public void validateForm()
	{
		ps1t.selectForm();
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		String title = ps1t.pageTitle();
		Assert.assertEquals(title, "Welcome to the Test Site");
	}
	
	@DataProvider	
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider ="getCRMTestData",priority=2)
	public void fillFormData(String usname ,String usphone ,String usemail, String uscountry,String uscity, String ususrname ,String uspswd)
	{
		ps1t.fillForm(usname,usphone,usemail,uscountry,uscity,ususrname,uspswd);
	}
	
	@Test(priority=3)
	public void validateSubmit() throws InterruptedException
	{
		ps1t.submitform();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=4)
	public void validateAlert()
	{
		String alerttext = ps1t.alertreceived();
		System.out.println(alerttext);
		Assert.assertEquals(alerttext,"This is just a dummy form, you just clicked SUBMIT BUTTON");
	}
	
	
	
	 /*@AfterClass
	public void tearDown()
	{
		driver.close();
	} */
	
	
	

} 
