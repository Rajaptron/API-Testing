package Com.np.qa.Testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.np.qa.Base.TestBase;
import Com.np.qa.Pages.Homepage;

/**
 * 
 * @author raj.agrawal
 *
 */

public class HomepageTest extends TestBase {

	public static Homepage hp;
	
	public HomepageTest() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		initialization();
	   hp = new Homepage();
	    
	}
	
	@Test
	
	public void HomepageTitle() {
		String HomepageTitle =Homepage.Homepagetitle();
		Assert.assertEquals(HomepageTitle, "Promotional Products and Articles with Your Brand | National Pen IE");
		
	}
	
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();

	}
	
	

}
