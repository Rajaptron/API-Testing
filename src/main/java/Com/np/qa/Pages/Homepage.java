package Com.np.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.np.qa.Base.TestBase;

/**
 * 
 * @author raj.agrawal
 *
 */

public class Homepage extends TestBase {
    public static Homepage hp;
	public Homepage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	//************************Object Repository(All in objects repo) ***************************
	
	@FindBy(xpath="//div[@class='logo']/a/img") static WebElement logo;
	
	@FindBy(xpath="") static WebElement Signin;
	
	
	
	//******************************Methods (Here is Page respective methods)**********************************
	
	public static String Homepagetitle() {
		String Homepagetitle =driver.getTitle();
		return Homepagetitle;	
	}
	
	
	
}
