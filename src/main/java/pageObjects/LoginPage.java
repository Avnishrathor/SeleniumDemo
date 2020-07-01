package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	By mobileno= By.cssSelector("input._2zrpKA._1dBPDZ");
	By password =By.cssSelector("input._2zrpKA._3v41xv._1dBPDZ");
	By login= By.cssSelector("button._2AkmmA._1LctnI._7UHT_c");

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}



	public WebElement  getEnterMobile()
	{
	 	return driver.findElement(mobileno);
		
	}
	

	
	public WebElement  GetPassword()
	{
	 	return driver.findElement(password);
		
	}
	
	public WebElement GetLogin()
	{
	 	return driver.findElement(login);
		
	}

}

