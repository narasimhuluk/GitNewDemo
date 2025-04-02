package testPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrollPages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");

		List<WebElement> amount = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum = 0;
		for (int i = 0; i < amount.size(); i++) {
			sum = sum + Integer.parseInt(amount.get(i).getText());
		}
		String totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		System.out.println(totalAmount);
		System.out.println(sum);
		Assert.assertEquals(sum, Integer.parseInt(totalAmount));
	}

}
