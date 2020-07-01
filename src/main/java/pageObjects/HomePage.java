package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	
	By Search = By.xpath("//*[@id='container']//form//input[@type='text']");
	By SelectProduct = By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	By SearchAll = By.cssSelector("svg");
	By profile=By.cssSelector("div._2aUbKa");
	
	
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}



	public WebElement  SearchforanItem()
	{
	 	return driver.findElement(Search);
		
	}
	
	public Cart  SelectItem()
	{
	  driver.findElement(SelectProduct).click();
	  Cart crt= new Cart(driver);
	  return crt;
		
	}

	public WebElement  SearchforAll()
	{
	 	return driver.findElement(SearchAll);
		
	}
	
	public WebElement  ProfileName()
	{
	 	return driver.findElement(profile);
		
	}
}

