package Demo.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	Properties pr;
	public WebDriver initializeDriver() throws IOException
	{
		pr= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\recources\\data.properties");
		pr.load(fis);
		String browserName=pr.getProperty("browser");

		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\recources\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		case "firefox":
			System.out.println("Please add firefox driver");
			break;

		case "ie":
			System.out.println("Please add ie driver");
			break;
		default:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\recources\\chromedriver.exe");
			driver= new ChromeDriver();


		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}


	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=  (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\Screenshots\\"+testCaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destination));
		return destination;
	}

}
