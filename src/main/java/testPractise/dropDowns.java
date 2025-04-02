package testPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class dropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> country = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		for (int i = 0; i < country.size(); i++) {
			if (country.get(i).getText().equals("India")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", country.get(i));
			}
		}

//		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
//		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
//		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
//		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
//		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
//		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
//		checkboxes.size();
//		System.out.println("check boxes size is : " + checkboxes.size());
//		Assert.assertEquals(checkboxes.size(), 6);

		// *** Dynamic dropdowns ***
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();

		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("it is enabled");
			Assert.assertTrue(true);
		}

		// **passengers **
//		driver.findElement(By.id("divpaxinfo")).click();
//		WebElement incAdult = driver.findElement(By.id("hrefIncAdt"));
//		for (int i = 1; i <= 4; i++) {
//			incAdult.click();
//		}
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// ** Select classes **
//		WebElement dropdownSelect = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		Select s = new Select(dropdownSelect);
//		s.selectByIndex(2);
//		System.out.println(s.getFirstSelectedOption().getText());
//		s.selectByValue("INR");
//		System.out.println(s.getFirstSelectedOption().getText());
//		s.selectByVisibleText("USD");
//		System.out.println(s.getFirstSelectedOption().getText());

	}

}
