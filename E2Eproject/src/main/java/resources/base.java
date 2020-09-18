package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

//i make driver,properties as public bcz i hv to use these in other classes by inheritance by using keyword extends	
	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ANU\\eclipse-workspaceNew\\E2EProject\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	 driver = new ChromeDriver();
		
		//Execute in chrome driver
	}
	else if(browserName.equals("firefox"))
	
	//else if(browserName.equals("firefox"))
	{
		driver=new FirefoxDriver();
	//Execute in firefox driver
	}
	else if (browserName.equals("IE"))
	{
	//Execute in internet explorer
}
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
return driver;
	}
}