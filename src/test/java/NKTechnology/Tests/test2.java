package NKTechnology.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.app.intense.Loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

//		driver.findElement(By.id("userEmail")).sendKeys("narasimhulu3k@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Narasimha@444");
//		driver.findElement(By.id("login")).click();
		
		Loginpage lp=new Loginpage(driver);
		lp.logInApplication("narasimhulu3k@gmail.com", "Narasimha@444");

		List<WebElement> products = driver.findElements(By.xpath("//h5/b"));

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equals("ADIDAS ORIGINAL")) {
				driver.findElements(By.cssSelector(".btn.w-10.rounded")).get(i).click();
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		driver.findElement(By.xpath("//li/button[@type='button']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");

		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item"));

		for (WebElement country : countries) {
			if (country.getText().equals("India")) {
				country.click();
			}
		}

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".action__submit")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(),
				"THANKYOU FOR THE ORDER.");
		driver.quit();

	}

}
