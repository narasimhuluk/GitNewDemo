package NKTechnology.Tests;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test1 {

	public class Brokerlinks {
		static String url = "http://www.rahulshettyacademy.com/AutomationPractice";
		static WebDriver driver;

	@Test public void validateBrokenLinks() throws MalformedURLException, IOException 
	{ 
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get(url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//List<WebElement> links= driver.findElements(By.tagName("a"));
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sf =new SoftAssert();
		for(WebElement link: links) 
		{ 
			String url=link.getDomProperty("href");
		System.out.println(url); 
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD"); conn.connect(); 
		int responsecode =conn.getResponseCode(); 
		System.out.println(responsecode); 
		sf.assertTrue(responsecode<400,"The link with Text"+link.getText()+" is broken with code:" +responsecode); } 
		sf.assertAll(); }
	}
}
