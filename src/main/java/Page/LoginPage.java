
package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.BrowserFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement USERNAME_FIELD;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_FIELD;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGNIN_BUTTON_FIELD;

	// Interactive actions

	public void enterusername(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}

	public void enterpassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}

	public void logininbutton() {
		SIGNIN_BUTTON_FIELD.click();
	}
}
