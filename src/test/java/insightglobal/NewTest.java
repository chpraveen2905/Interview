package insightglobal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	

public class NewTest {

		WebDriver driver = new ChromeDriver();
	
 @Test(priority=1)
 public void restaurantsearch() {
	 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.get("https://www.just-eat.co.uk");
	  String Title = driver.getTitle();
	  Assert.assertTrue(Title.contains("Order takeaway online from 20,000+ food delivery restaurants | Just Eat"));
 }
 @Test(priority=2)
 public void search() {
	 driver.findElement(By.xpath("//*[@id='skipToMain']/form/div/div/label/input"))
	 				.sendKeys("AR51 1AA");
	 driver.findElement(By.xpath("//*[@id=\"skipToMain\"]/form/div/button/span")).click();
	 
	 String openrestaurants1 = driver.findElement(By.xpath("//*[@id='skipToMain']/main/div/div[2]/div[2]/div[1]/div/section[1]/a")).getText();
	 String openrestaurants2 = driver.findElement(By.xpath("//*[@id=\'skipToMain\']/main/div/div[2]/div[2]/div[1]/div/section[2]/a")).getText();
	 String openrestaurants3 = driver.findElement(By.xpath("//*[@id=\'skipToMain\']/main/div/div[2]/div[2]/div[1]/div/section[3]/a")).getText();
	 
	 System.out.println(openrestaurants1);
	 System.out.println(openrestaurants2);
	 System.out.println(openrestaurants3);
		  
 }
 @AfterTest
 public void afterTest() {
	 driver.quit();
 }
}
