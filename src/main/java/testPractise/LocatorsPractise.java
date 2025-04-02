package testPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LocatorsPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("narasimha");
		driver.findElement(By.name("inputPassword")).sendKeys("test");
		driver.findElement(By.className("submit")).click();
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("test");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("test.k@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876512345");
		driver.findElement(By.cssSelector("div button:nth-child(2)")).click();
		String pssword = driver.findElement(By.cssSelector(".infoMsg")).getText().split("'")[1];
		// System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText().split("'")[1]);
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("narasimha");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pssword);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
	    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	    driver.quit();
	}

}
