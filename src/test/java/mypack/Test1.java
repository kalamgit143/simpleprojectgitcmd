package mypack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1
{
	RemoteWebDriver driver;
	@Test(priority=1)
	public void method1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test(priority=2)
	public void method2()
	{
		driver.get("http://www.google.co.in");
		if(driver.getCurrentUrl().contains("https"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false); //it stops execution
		}
		Reporter.log("Site is opened");
	}
	@Test(priority=3)
	public void method3()
	{
		SoftAssert sa=new SoftAssert();
		if(driver.getTitle().equals("Google"))
		{
			sa.assertTrue(true);
		}
		else
		{
			sa.assertTrue(false); //it continues execution
		}
		driver.close();
		sa.assertAll();
	}

}
