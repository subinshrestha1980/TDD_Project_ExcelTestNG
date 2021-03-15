
package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	} // Element Library

	// @FindBy(how=How.XPATH, using = //
	// "/html/body/section/div/div[1]/div[2]/div/h2");

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), ' Dashboard ')]")
	WebElement DASHBOARD_HEADER_FIELD;

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMER_FIELD_LOCATOR;

	@FindBy(how = How.LINK_TEXT, using = "Add Customer")
	WebElement ADD_CUSTOMER_LOCATOR;

	// @FindBy(how = How.XPATH, using ="//*[@id=\"summary\"]") //WebElement
	// ValidationSummary;

	// Interactive Methods
	public void validateDashBoardHeader() {
		waitforElement(driver, 5, DASHBOARD_HEADER_FIELD);
		System.out.println(DASHBOARD_HEADER_FIELD.getText());
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), "Dashboard", "Dashboard Page Not Found !!");
	}

	public void clickonCustomerButton() {
		CUSTOMER_FIELD_LOCATOR.click();
	}

	public void clickonAddOnCustomerButton() {
		ADD_CUSTOMER_LOCATOR.click();
	}

	// public void Summary_Field() { waitforElement(driver, 10, ValidationSummary);
	// Assert.assertEquals(ValidationSummary.getText(), "Summary", "Summary not
	// found"); }

}
