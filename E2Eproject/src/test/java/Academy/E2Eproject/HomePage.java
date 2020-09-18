package Academy.E2Eproject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;



public class HomePage extends base {
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		//driver.get(prop.getProperty("url")); 
//here we not keeping url in public,@beforetest bcz again url should invoke for 2nd user so i kept in mthd only
	}

@Test(dataProvider="getData")

	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
	//again url should invoke for 2nd user so i kept in mthd only
	driver.get(prop.getProperty("url"));
//here we hv 2ways to access the methods of other class 1)inheritance(with Extends keyword)
//2)creating obj to tht class and invoke methods of it
	//creating obj for login page to access tht mthds in our homepage and passing driver to give life
	LandingPage l=new LandingPage(driver);
	//clicking on login button

	l.getlogin().click();
	LoginPage lp=new LoginPage(driver);
	//lp.getEmail().sendKeys("tejaswi"); by mentioning String values in tht mthd so we call those Username without hardcoding
	lp.getEmail().sendKeys(Username);
//	lp.getPassword().sendKeys("12345");
	lp.getPassword().sendKeys(Password);
	System.out.println(text);
	lp.getLogin().click();

	}
//closing browser after every testcase
@AfterTest
public void closedown()
{
	driver.close();
}

@DataProvider
public Object[][] getData()
{
//ROw stands for how many different data types test should run
//column Stands for how many values per each test
//when array size is 2 tht means array starts from 0,1
//when we sending 3 value tht means we have to mention in array 3	
	Object[][] data=new Object[2][3];
//0th row
	data[0][0]="nonrestricteduser@cw.com";
	data[0][1]="123456";
	data[0][2]="Resctricted user";
//1st row 
	data[1][0]="Restricteduser@qw.com";
	data[1][1]="456789";
	data[1][2]="Non restricted user";
	 
	return data;
}
}