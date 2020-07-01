package utilities;



import java.util.Set;

import org.openqa.selenium.WebDriver;

public class NewWindow {
	
	
	public WebDriver driver;
	String parentWindow;
	
	public void swithToWindow()
	{    parentWindow= driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		    
		}
	}
		
		public NewWindow (WebDriver driver)
		{
			this.driver=driver;
		}
			
		
		public void swithToMainWindow()
		{
			driver.switchTo().window(parentWindow);
		}

}
