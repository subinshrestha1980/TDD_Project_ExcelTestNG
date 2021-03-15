
package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) { // Constructor relationship with the webdriver (webdriver.driver)of login
		// // and the addcustomer driver global variable)
		this.driver = driver;
	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_REGION_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTY_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"currency\"]")
	WebElement CURRENCY_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"group\"]")
	WebElement GROUP_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSOWORD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cpassword\"]")
	WebElement CONFIRM_PASSWORD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SIGNIN_LOCATOR;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "List Customers")
	WebElement LIST_CUSTOMER_BUTTON; // Interactive Methods

	public void clickOncustomerButton() {
		waitforElement(driver, 3, CUSTOMER_FIELD_LOCATOR);
		CUSTOMER_FIELD_LOCATOR.click();
	}

	public void clickOnAddCustomerButton() {
		waitforElement(driver, 3, ADD_CUSTOMER_FIELD_LOCATOR);
		ADD_CUSTOMER_FIELD_LOCATOR.click();

	}
	String enterName;
	public void Full_NameField(String name) {
		waitforElement(driver, 3, FULL_NAME_FIELD_LOCATOR);
		int randomNum = randomNumGenerator();
		enterName = name + randomNum;
		FULL_NAME_FIELD_LOCATOR.sendKeys(enterName);
	}

	public void CompanyField(String company) {
		waitforElement(driver, 15, COMPANY_FIELD_LOCATOR); // COMPANY_FIELD_LOCATOR.click();
		selectFromDropdown(COMPANY_FIELD_LOCATOR, company);
	}

	public void Email_Field(String email) {
		int randomNum = randomNumGenerator();
		EMAIL_FIELD_LOCATOR.sendKeys(email + randomNum);
	}

	public void PHONE_FIELD(String phone) {
		int randomNum = randomNumGenerator();
		PHONE_FIELD_LOCATOR.sendKeys(phone + randomNum);
	}

	public void ADDRESS_FIELD(String Address) {
		ADDRESS_LOCATOR.sendKeys(Address);
	}

	public void CITY_FIELD(String City) {
		CITY_LOCATOR.sendKeys(City);
	}

	public void STATE_FIELD(String State) {
		STATE_REGION_LOCATOR.sendKeys(State);
	}

	public void ZIP_FIELD(String ZIP) {
		ZIP_LOCATOR.sendKeys(ZIP);
	}

	public void COUNTRY_FIELD(String country) {
		selectFromDropdown(COUNTY_LOCATOR, country);
	}

	public void CURRENCY_FIELD(String Currency) {
		selectFromDropdown(CURRENCY_LOCATOR, Currency);
		CURRENCY_LOCATOR.click();
	}

	// public void GROUP_FIELD(String batch) { // GROUP_LOCATOR.click();
	// selectFromDropdown(GROUP_LOCATOR, batch); // }

	public void PASSWORD_FIELD(String Password) {
		PASSOWORD_LOCATOR.sendKeys(Password);
	}

	public void CONFIRM_PASSWORD_FIELD(String Confrimpassword) {
		CONFIRM_PASSWORD_LOCATOR.sendKeys(Confrimpassword);
	}

	public void SIGNIN_FIELD() {
		SIGNIN_LOCATOR.click();
	}

	public void LIST_CUSTOMER() {
		waitforElement(driver, 15, LIST_CUSTOMER_BUTTON);
		LIST_CUSTOMER_BUTTON.click();
	}

}
