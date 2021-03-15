
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Page.AddCustomerPage;
import Page.BasePage;
import Page.Contactsvalidation;
import Page.DashboardPage;
import Page.Datadeletepage;
import Page.ListcontactpageValidation;
import Page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest extends BasePage {

	WebDriver driver;
	String enterName;
	
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String fullName = exlread.getCellData("AddContctInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContctInfo", "CompanyName", 2);
	String emailField = exlread.getCellData("AddContctInfo", "Email", 2);
	String phoneField = exlread.getCellData("AddContctInfo", "Phone", 2);
	String addressField = exlread.getCellData("AddContctInfo", "Address", 2);
	String cityField = exlread.getCellData("AddContctInfo", "City", 2);
	String countryField = exlread.getCellData("AddContctInfo", "Country", 2);
	String stateField = exlread.getCellData("AddContctInfo", "State", 2);
	String zipField = exlread.getCellData("AddContctInfo", "Zip", 2);
	String currencyField = exlread.getCellData("AddContctInfo", "Currency", 2); //
	// String GROUP_FIELD = exlread.getCellData("AddContctInfo","Group", 2);
	String PASSWORD_FIELD = exlread.getCellData("AddContctInfo", "Password", 2);
	String CONFIRM_PASSWORD_FIELD = exlread.getCellData("AddContctInfo", "ConfirmPasword", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		enterName = fullName + randomNumGenerator();
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterusername(userName); // userName is a variable to read it from our excel.
		loginpage.enterpassword(password);
		loginpage.logininbutton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardHeader();

		AddCustomerPage addcustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);

		addcustomerPage.clickOncustomerButton();
		addcustomerPage.clickOnAddCustomerButton();

		addcustomerPage.Full_NameField(enterName);
		addcustomerPage.CompanyField(companyName);
		addcustomerPage.Email_Field(emailField);
		addcustomerPage.PHONE_FIELD(phoneField);
		addcustomerPage.ADDRESS_FIELD(addressField);
		addcustomerPage.CITY_FIELD(cityField);
		addcustomerPage.COUNTRY_FIELD(countryField);
		addcustomerPage.STATE_FIELD(stateField);
		addcustomerPage.ZIP_FIELD(zipField);
		addcustomerPage.CURRENCY_FIELD(currencyField); //
		// addcustomerPage.GROUP_FIELD(GROUP_FIELD);
		addcustomerPage.PASSWORD_FIELD(PASSWORD_FIELD);
		addcustomerPage.CONFIRM_PASSWORD_FIELD(CONFIRM_PASSWORD_FIELD);
		addcustomerPage.SIGNIN_FIELD(); // Contactsvalidation.Summary_Field();
		Contactsvalidation contactsvalidation1 = PageFactory.initElements(driver, Contactsvalidation.class);
		contactsvalidation1.Summary_Field();
		contactsvalidation1.LIST_CUSTOMER();

		ListcontactpageValidation customerpagevalid = PageFactory.initElements(driver, ListcontactpageValidation.class);
		customerpagevalid.newcustomerpage();
		
		Datadeletepage Datadeletepage1 = PageFactory.initElements(driver, Datadeletepage.class);
		Datadeletepage1.verifyEnteredName(enterName);
		
		Datadeletepage1.deleteokbutton();
	}
}
// addcustomerPage.LIST_CUSTOMER(); Contactsvalidation1.LIST_CUSTOMER(); } }
