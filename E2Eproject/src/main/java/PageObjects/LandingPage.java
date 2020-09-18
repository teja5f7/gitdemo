package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
By signin=	By.cssSelector("a[href*='sign_in']");
By title=By.xpath("//*[text()='Featured Courses']");
By NavBar=By.linkText("Contact");

public LandingPage(WebDriver driver) {
	this.driver=driver;
}


public WebElement getlogin()
{
return driver.findElement(signin);
}
public WebElement gettitle()
{
return driver.findElement(title);
}
public WebElement getNavigationBar()
{
return driver.findElement(NavBar);
}

}