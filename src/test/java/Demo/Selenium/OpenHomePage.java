package Demo.Selenium;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


public class OpenHomePage extends Base{
    public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	
	
	public void intialize() throws IOException
	
	{
		driver=initializeDriver();
		driver.get(pr.getProperty("URL"));
		log.info("Driver is installed");
		}
	

	@Test

	public void nevigateToHome() throws IOException, InterruptedException
	{

		

		LandingPage lp =new LandingPage(driver);
		LoginPage login=lp.getLogin();
		login.getEnterMobile().sendKeys(pr.getProperty("MobileNo"));
		login.GetPassword().sendKeys(pr.getProperty("Password"));
		login.GetLogin().click();
		driver.manage().window().maximize();
		Thread.sleep(100);
		HomePage hp=new HomePage(driver);
		String wb =hp.ProfileName().getText();
	    Assert.assertEquals(wb, "Avnish");

	}
@AfterTest

public void tearDown()
	{
	driver.close();
	}


}
