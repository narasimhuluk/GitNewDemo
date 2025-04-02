package testPractise;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsUsage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//		// click on column
//		driver.findElement(By.xpath("//tr/th[1]")).click();
//		// capture all the webelements into list
//		Thread.sleep(5000);
		List<WebElement> vegNames = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
//		// capture the text of all webelements into new list
//		List<String> orgionalList = vegNames.stream().map(s -> s.getText()).collect(Collectors.toList());
//		orgionalList.stream().forEach(s->System.out.println(s));
//		// sort the original list od the step3
//
//		List<String> sortedList = orgionalList.stream().sorted().collect(Collectors.toList());
//		sortedList.stream().forEach(s->System.out.println(s));
//		// compare original list vs sorted list
//		
//		Assert.assertTrue(orgionalList.equals(sortedList));
//		
		// scan the name column with gettext ->Rice->print price of rice
		List<Object> prices;
		do {
		
			prices = rows.stream().filter(s -> s.getText().contains("Wheat")).map(s -> getVeggiesPrice(s))
					.collect(Collectors.toList());
			prices.forEach(s -> System.out.println(s));

			if (prices.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (prices.size() < 1);
	}

	private static Object getVeggiesPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
