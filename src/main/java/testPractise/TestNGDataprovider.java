package testPractise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataprovider {
	
	@Test
	public void webLogin()
	{
		System.out.println("weblogintest");
		Assert.assertFalse(true);
	}

	@Test(dataProvider="getData")
	public void LoginPage(String data1,String data2) {
		System.out.println(" ");
		System.out.println(data1);
		System.out.println(data2);
		

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];

		obj[0][0] = "test1";
		obj[0][1] = "data1";

		obj[1][0] = "test2";
		obj[1][1] = "data2";

		obj[2][0] = "test3";
		obj[2][1] = "data3";

		return obj;
	}

}
