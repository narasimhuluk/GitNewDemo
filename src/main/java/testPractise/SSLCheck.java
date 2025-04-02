package testPractise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ChromeOptions op = new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\intense\\eclipse-workspace\\Tests\\screenshot.png"));
	}

}
