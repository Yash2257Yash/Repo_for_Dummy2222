package Practice.testng;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.DataProviderGenericUtility;

public class TotestDATaproviderbwclass 
{
	
	@Test(dataProviderClass =DataProviderGenericUtility .class,dataProvider="Mobiledatafromamazon")
	public void getProductinfo(String BrandName ,String ProductName)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.amazon.in");
		
		//search for the product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		//capture the product info
		if(BrandName.equals("iphone")) {
		String proinfo="//span[text()=\""+ProductName+"\"]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(proinfo)).getText();
		System.out.println(BrandName+ProductName+ price);
		driver.quit();
		}
		else if (BrandName.equals("shirts")) {
		String shirts="//span[text()=\""+ProductName+"\"]/../../../../div[4]/div[2]/div[1]/a/span/span[2]/span[2]";
		String shirtsprice = driver.findElement(By.xpath(shirts)).getText();

		System.out.println(BrandName+ProductName+ shirtsprice);
		driver.quit();
		}
	}


	
	
}



