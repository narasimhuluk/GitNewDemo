package testPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.findElement(By.id("alertbtn")).click();
		// driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("narasimha");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().getText();
		System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	}

}
