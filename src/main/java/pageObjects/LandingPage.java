package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;


	By signin =By.className("_3Ep39l");




	public LandingPage(WebDriver driver) {
		this.driver=driver;

	}



	public LoginPage  getLogin()
	{
		 driver.findElement(signin);
		 LoginPage login= new LoginPage(driver);
		 return login;

	}

}

