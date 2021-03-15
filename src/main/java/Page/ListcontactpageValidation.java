package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListcontactpageValidation extends BasePage {

	WebDriver driver;

	public ListcontactpageValidation(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement listofcustomerpage;

	public void newcustomerpage() {
		System.out.println(listofcustomerpage.getText());
		Assert.assertEquals(listofcustomerpage.getText(), "Add Customer", " Add Customer not found");
	}
}
