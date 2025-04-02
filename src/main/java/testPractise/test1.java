package testPractise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class test1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

		List<Object> price = veggies.stream().filter(s -> s.getText().contains("Apple")).map(s -> getVeggiesPrice(s))
				.collect(Collectors.toList());
		price.forEach(s->System.out.println(s));

	}

	private static Object getVeggiesPrice(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
		// return null;
	}
}
