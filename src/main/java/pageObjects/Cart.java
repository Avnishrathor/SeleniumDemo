package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
	public WebDriver driver;
	
	
	By addtoCart = By.cssSelector("button._2AkmmA._2Npkh4._2MWPVK");
	By CheckCart = By.cssSelector("svg._2fcmoV path._2JpNOH");
	
	
	
	
	public Cart(WebDriver driver) {
		this.driver=driver;
		
	}



	public WebElement  AddToCart()
	{
	 	return driver.findElement(addtoCart);
		
	}
	

	
	public WebElement  CheckMyCart()
	{
	 	return driver.findElement(CheckCart);
		
	}
	
	

}

