package com.crm.generic.Baseutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.FileUtilityforcliniq;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseTest {
	public WebDriver driver = null;

	public FileUtilityforcliniq flib = new FileUtilityforcliniq();
	public WebDriverUtility wlib = new WebDriverUtility();

	@BeforeSuite
	public void BeforeSuite() {

	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "Smoke Test", "Regression Test" })
	public void BeforeClass(@Optional("chrome") String browser) throws Throwable {
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		driver = wlib.browserselect(BROWSER);

		// UtilityclassObject.setDriver(driver);

		System.out.println("executed BeforeClass====Launch the brow");
	}

	@BeforeMethod

	public void executeBefore() throws Throwable {
		

	}

	@AfterMethod
	public void executeAfter() {
	}

	@AfterClass
	public void Afterclass() {
		wlib.quitwindow(driver);
	}

	@AfterSuite
	public void AfterSuite() {
	}

}
