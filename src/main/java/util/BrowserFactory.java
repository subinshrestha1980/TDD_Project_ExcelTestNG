
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String browser;
	static String url; // connecting with config file

	public static void readConfig() {
		Properties prop = new Properties();
		// FileReader //Input Stream //BufferReading //Sacanner - Read the configure //
		// file

		try {
			InputStream input = new FileInputStream("src\\main\\java\\Config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser"); //
			System.out.println("UsedBrowser: " + browser);
			url = prop.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver init() {
		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver", "driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
