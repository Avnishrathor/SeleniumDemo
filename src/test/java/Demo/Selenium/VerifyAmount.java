package Demo.Selenium;


import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Cart;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.GetProductNameFromExcel;
import utilities.NewWindow;

public class VerifyAmount extends Base{
	
	 public WebDriver driver;
	 public static Logger log=LogManager.getLogger(Base.class.getName());

@BeforeTest
	
	
	public void intialize() throws IOException
	
	{
		driver=initializeDriver();
		driver.get(pr.getProperty("URL"));
		log.info("Browser is loaded");
		}

	@Test

	public void nevigateToHome() throws IOException, InterruptedException
	{
	

		LandingPage lp =new LandingPage(driver);
		driver.manage().window().maximize();
		LoginPage login=lp.getLogin();
		login.getEnterMobile().sendKeys(pr.getProperty("MobileNo"));
		login.GetPassword().sendKeys(pr.getProperty("Password"));
		login.GetLogin().click();
		

		HomePage hp=new HomePage(driver);
		
		GetProductNameFromExcel gd= new GetProductNameFromExcel();
		
		//Get The product name from the excel data 
		
		 String name=gd.getItem("MOBILE");
		System.out.println(name);
		hp.SearchforanItem().sendKeys(pr.getProperty("Product"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement click =driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
		click.sendKeys(Keys.ENTER);

		Cart crt=hp.SelectItem();
		NewWindow nw= new NewWindow(driver); 
		nw.swithToWindow();
			
			crt.AddToCart().click();
			
			driver.close();
			Thread.sleep(100);


		nw.swithToMainWindow();
		crt.CheckMyCart().click();
		
		
	}
	
	@AfterTest

	public void tearDown()
		{
		driver.close();
		}


}
