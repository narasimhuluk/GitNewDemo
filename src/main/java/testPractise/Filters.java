package testPractise;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Banana";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys(input);
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> veddieSize = veggies.stream().filter(v -> v.getText().contains(input))
				.collect(Collectors.toList());
		System.out.println(veggies.size());
		System.out.println(veddieSize.size());
		Assert.assertEquals(veggies.size(), veddieSize.size());

	}

}
