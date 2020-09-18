package Academy.E2Eproject;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;



public class validateNavigationBar extends base {
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
	}

@Test
	 
	public void basePageNavigation() throws IOException
	{
	
//here we hv 2ways to access the methods of other class 1)inheritance(with Extends keyword)
//2)creating obj to tht class and invoke methods of it
	//creating obj for login page to access tht mthds in our homepage and passing driver to give life
	LandingPage l=new LandingPage(driver);
	//comparing the text from the webpage with actual text by using assertions
	//Assert.assertEquals(l.gettitle().getText(), "Featured Courses");
	
	//is tht navigationbar displayed or not we r validating by Assert.assertTrue(condition) mthd
	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	//Assert.assertFalse(false);always except false condition

	}
@AfterTest
public void teardown()
{
	driver.close();
}


}