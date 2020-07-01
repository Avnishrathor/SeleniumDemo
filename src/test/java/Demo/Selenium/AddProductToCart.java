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
import utilities.NewWindow;

public class AddProductToCart extends Base{
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
		HomePage hp=new HomePage(driver);
		
		//pass the item in search box
		
		hp.SearchforanItem().sendKeys(pr.getProperty("Product"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement click =hp.SearchforanItem();
		click.sendKeys(Keys.ENTER);
		
       // Select the item 
		Cart crt=hp.SelectItem();	
		NewWindow nw= new NewWindow(driver); 
		
		//Switch to child window once item got selected
		nw.swithToWindow();

		// Add item to the cart
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
