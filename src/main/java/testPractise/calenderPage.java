package testPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calenderPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		
		String[] expectedValue= {monthNumber,date,year};

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(monthNumber) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		List<WebElement> actualValue = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i=0;i<actualValue.size();i++)
		{
			System.out.println(actualValue.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualValue.get(i).getDomAttribute("value"), expectedValue[i]);
			
		}
	}

}
