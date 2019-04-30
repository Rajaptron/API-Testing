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
	
	@Test(priority=1)
	
	public void HomepageTitle() {
		String HomepageTitle =Homepage.Homepagetitle();
		Assert.assertEquals(HomepageTitle, "Promotional Products, Branded Giveaways, Corporate Gifts, National Pen");
	}
	
	@Test(priority=2)
	
	public void Category1tiletitle() {
	String Penstitle = Homepage.Category1();
	Assert.assertEquals(Penstitle, "Pens and Pencil Sets | National Pen");
	}
	
     @Test(priority=3)
	
	public void Category2tiletitle() {
	String cat2tiletitle = Homepage.Category2();
	Assert.assertEquals(cat2tiletitle, "Personalised & Custom Printed Bags | Branded in Bulk | National Pen IE");
	}
	
     @Test(priority=4)
 	
 	public void Category3tiletitle() {
 	String cat3tiletitle = Homepage.Category3();
 	Assert.assertEquals(cat3tiletitle, "Personalised and Promotional Drinkware | National Pen IE");
 	}
	
     @Test(priority=5)
 	
 	public void Category4tiletitle() {
 	String cat4tiletitle = Homepage.Category4();
 	Assert.assertEquals(cat4tiletitle, "Personalised Lanyards | Custom Lanyards Printing | National Pen IE");
 	}
     
     @Test(priority=6)
 	
 	public void Category5tiletitle() {
 	String cat5tiletitle = Homepage.Category5();
 	Assert.assertEquals(cat5tiletitle, "Personalised Keyrings | Custom Engraved Keyrings | National Pen IE");
 	}
	
     @Test(priority=7)
 	
 	public void Category6tiletitle() {
 	String cat6tiletitle = Homepage.Category6();
 	Assert.assertEquals(cat6tiletitle, "Promotional Electronic Gadgets | National Pen IE");
 	}
	
     @Test(priority=8)
 	
 	public void Category7tiletitle() {
 	String cat7tiletitle = Homepage.Category7();
 	Assert.assertEquals(cat7tiletitle, "Personalised & Embroidered Custom Clothing | National Pen IE");
 	}
     
     @Test(priority=8)
  	
  	public void Category8tiletitle() {
  	String cat1tiletitle = Homepage.Category8();
  	Assert.assertEquals(cat1tiletitle, "Promotional Office Products and Gifts | National Pen IE");
  	} 
     
     
     
     
     
     
	@AfterMethod
	public void teardown() {
		driver.close();

	}
	
	

}
