package insightglobal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CheckLogin {
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
		 
	 }
	 @Test(priority=3)
	 public void login() {
		String Login =  driver.findElement(By.xpath("/html/body/header/div/nav/div/ul/li[1]/a")).getText();
		Assert.assertEquals(Login, "Log in");
		
	 }
	 @AfterTest
	 public void afterTest() {
		 driver.quit();
	 }
}
