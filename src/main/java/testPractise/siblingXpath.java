package testPractise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class siblingXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		System.out
//				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
	}

}
