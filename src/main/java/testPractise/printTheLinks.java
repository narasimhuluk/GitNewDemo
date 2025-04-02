package testPractise;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printTheLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		footer.findElements(By.tagName("a")).size();
		System.out.println(footer.findElements(By.tagName("a")).size());

		WebElement firstRow = footer.findElement(By.cssSelector("td:nth-child(1) ul"));
		firstRow.findElements(By.tagName("a")).size();
		System.out.println(firstRow.findElements(By.tagName("a")).size());

		for (int i = 1; i < firstRow.findElements(By.tagName("a")).size(); i++) {
			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			firstRow.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
			Thread.sleep(5000);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Title of the page is : "+driver.getTitle());
		}
	}

}
