package Com.np.qa.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Com.np.qa.Base.TestBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestUtil extends TestBase {

	public static WebDriver driver;

	public TestUtil() throws IOException {
		super();

	}

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 300;

	// ***********************EXCCEL DATA***************************

	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	// *************************************FILE SELECTION**************************
	public static void javarobotfileselection() {

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	// *******************************PAGE SCROLL
	// Down*******************************

	public static void Pagescroll(int a) throws AWTException {
		for (int i = 0; i < a; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	}

	// *****************************PAGE SCROLL UP*******************************

	public static void Pagescrollup(int a) throws AWTException {
		for (int i = 0; i < a; i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}
	}

	// ************************************PARSE DATA************************

	public static int parsedata(String y) {

		String value = y;
		String value1 = value.replaceFirst("\\.0*$", "");
		String intValue = value1.replaceAll("[^0-9]", "");
		// System.out.println(intValue);
		int i = Integer.parseInt(intValue);
		return i;
	}

	// ********************************String to Float*********************

	public static float stringtofloat(String x) {
		String s = x;
		float f = Float.parseFloat(s);
		return f;
	}

	/***************************************************************************************
	 * This function is used to highlight element on GUI where the current and
	 * previous action has been performed.
	 * 
	 * @param element
	 **************************************************************************************/
	public static void ElementHighlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');", element);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].setAttribute('style', 'background:yellow;
		// border:2px solid red;');", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Reports.fail("",e.toString());
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'border: solid 2px green ');",
				element);
	}

	/***************************************************************************************
	 * This function will give you System date time in string format
	 * 
	 * @return This function will return date time in String format.
	 **************************************************************************************/
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		String[] parts = founddate.split(" ");
		String[] appenderpart1 = parts[0].split("/");
		String appender = appenderpart1[1] + "-" + appenderpart1[2] + "-" + appenderpart1[0];
		return appender;
	}

	/***************************************************************************************
	 * This function will give you System date time in string format
	 * 
	 * @return This function will return date time in String format.
	 **************************************************************************************/
	public static String getDatetime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String founddate = dateFormat.format(date);
		// System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48

		String[] parts = founddate.split(" ");
		// String part1 = parts[0]; // 004
		String[] appenderpart1 = parts[0].split("/");
		String[] appenderpart2 = parts[1].split(":");
		String appender = appenderpart1[1] + appenderpart1[2] + appenderpart2[0] + appenderpart2[1] + appenderpart2[2];
		// System.out.println(appender);
		return appender;
	}

	// *******************************PAGE End*******************************
	/***************************************************************************************
	 * This function will down the page at end
	 * 
	 * @return This function will footer values
	 **************************************************************************************
	 */
	public static void Pageend() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
	}

	// *******************************PAGE UP*******************************
	/***************************************************************************************
	 * This function will down the page at end
	 * 
	 * @return This function will footer values
	 **************************************************************************************/

	public static void Pageup() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);
	}

	// ***************************File Selection************************************
	/**
	 * This function will select the image of file from system memory
	 * 
	 * @return this function will return file selection
	 * @throws AWTException
	 * 
	 */
	public static void uploadfile(String url) throws AWTException {

		StringSelection ss = new StringSelection(url);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// ***********************Page Scroll On Top****************************
	/**
	 * Page Scroll On Top
	 * 
	 */

	public static void Pagehome() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);
	}

	// *****************************InsideDiv Popup
	// scroll******************************
	/**
	 * By this method we can scroll the Popup page
	 * 
	 */

	public static void popupscroll(WebElement ordersMultiShippingdialog) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollTop = arguments[1];", driver.findElement(By.xpath("xpath")));

	}

	 /* 
	 * **********************************ScreenShot****************************
	 * 
	 */

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	
	
}
