package Com.np.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import Com.np.qa.Utils.TestUtil;
import Com.np.qa.Base.TestBase;

/**
 * 
 * @author raj.agrawal
 *
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	// public static Logger log = Logger.getLogger(TestBase.class); //Log 4j Connector

	public TestBase() throws IOException {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Com\\np\\qa\\Config\\config.properties");
			prop.load(ip);
		    } 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		// log.info("****************************** Starting test cases execution*****************************************");
		
		String browsername = prop.getProperty("browser");

		// *************Without headless*************

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Com\\np\\qa\\testdata\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		// *******************With headless***************

		else if (browsername.equals("chromeheadless")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\" + "main\\java\\Com\\np\\qa\\testdata\\chromedriver.exe");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--window-size=1920x1080");
			driver = new ChromeDriver(chromeOptions);
		}

		else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Com\\np\\qa\\testdata\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
