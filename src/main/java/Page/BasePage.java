
package Page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


	
	public void waitforElement(WebDriver driver, int timeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds); 
		//WebDriverWait wait = new WebDriverWait(driver, 3); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public int randomNumGenerator() {
		Random rnd = new Random();
		int randomNum = rnd.nextInt(999);
		return randomNum;
	}

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
}
