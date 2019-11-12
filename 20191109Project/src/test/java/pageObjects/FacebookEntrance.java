package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.PageBase;

public class FacebookEntrance extends PageBase {

	/*-----------url section----------------*/
	private String url = "https://www.facebook.com/";

	// --------- elements ----------
	// driver.findElement(By. id name, xpath, css, linkedText, partlinklecte,
	// className,))
	// pagefactory:
	@FindBy(id = "email")
	@CacheLookup
	WebElement loginEmail;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement loginPw;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	private WebElement loginBtn;

	// input[@id="u_0_f"]
	@FindBy(xpath = "//input[@id='u_0_f']")
	@CacheLookup
	private WebElement firstN;

	// --------- constructor --------

	public FacebookEntrance() {
		// super(driver);
		PageFactory.initElements(driver, this);
		driver.get(url);

	}

	// --------- functions and assertions -------

	public FacebookEntrance enterEmailPasswordToLogin(String email, String password) {
		// logger.info();
		loginEmail.clear();
		loginEmail.sendKeys(email);
		loginPw.clear();
		loginPw.sendKeys(password);
		loginBtn.click();
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return this;
	}

	public FacebookEntrance assertLoginFail() {

		String actualText = driver.findElement(By.xpath("//a[contains(text(), 'Forgot Password?')]")).getText();

		// String actualText = recover2.getText();

		String expectText = "Forgot Password?";

		Assert.assertEquals(expectText, actualText);

		return this;

	}

}
