package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class NewTest {

  	WebDriver driver;
  @Test
  public void f() {
	// Step 1: load the chrome driver
	    System.setProperty("webdriver.chrome.driver", "E:\\Mphasis\\Phase 2\\Jar Files\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver(); // this intializes the chrome web browser
	  //Setting the driver to chrome driver
	  	  driver = new ChromeDriver();
	  	  String url = "https://www.google.com";
	  	  driver.get(url);
	  	  //Capturing the title and validating if expected is equal to actual
	  	  String expectedTitle = "Google";
	  	  String actualTitle = driver.getTitle();
	  	  Assert.assertEquals(actualTitle, expectedTitle);
	    
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Starting the browser session");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Closing the browser session");
  	  driver.quit();
  }

}
