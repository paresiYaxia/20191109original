package testCases.regression;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import base.TestBase;
import pageObjects.FacebookEntrance;

public class FacebookLoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {

		// setting system property so system would know where our actual driver is
		// located
		// String driverpath = System.getProperty("user.dir") +
		// "/src/test/resources/drivers/chromedriver";
		String driverpath = "/Users/Elif/eclipse-workspace/facebook/src/test/resources/drivers/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverpath);

		// Launch Chrome
		driver = new ChromeDriver();

		// set up implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();
	}

	@Test
	public void loginAttemptTest() {

		// testdata
		String email = "paresiTest@gmail.com";
		String password = "Email@test";

		FacebookEntrance f1 = new FacebookEntrance();
		f1.enterEmailPasswordToLogin(email, password).assertLoginFail();

	}

}
