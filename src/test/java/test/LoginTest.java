
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.DashboardPage;
import Page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);

	@Test
	public void validusershouldbeabletoLogin() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterusername(userName);
		loginPage.enterpassword(password);
		loginPage.logininbutton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardHeader();

		BrowserFactory.tearDown();
	}
}
