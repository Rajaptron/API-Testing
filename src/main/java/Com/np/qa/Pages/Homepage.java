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
	
	@FindBy(xpath="//div[@id='desktopUserInfo']/a") static WebElement Signin;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[1]/div[1]/a/div") static WebElement Cat1tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[1]/div[3]/a/div") static WebElement Cat2tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[1]/div[5]/a/div") static WebElement Cat3tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[1]/div[7]/a/div") static WebElement Cat4tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[2]/div[1]/a/div") static WebElement Cat5tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[2]/div[3]/a/div") static WebElement Cat6tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[2]/div[5]/a/div") static WebElement Cat7tile;
	
	@FindBy(xpath="//div[@class='visual-nav']/div[2]/div[7]/a/div") static WebElement Cat8tile;
	
	
	
	//******************************Methods (Here is Page respective methods)**********************************
	
	public static String Homepagetitle() {
		String Homepagetitle =driver.getTitle();
		return Homepagetitle;	
	}
	
   public static String Category1(){
	   Cat1tile.click();
	   String Cat1tiletitle= driver.getTitle();
	   return Cat1tiletitle;
   }
	
   public static String Category2(){
	   Cat2tile.click();
	   String Cat2tiletitle= driver.getTitle();
	   return Cat2tiletitle;
   }
	
   public static String Category3(){
	   Cat3tile.click();
	   String Cat3tiletitle= driver.getTitle();
	   return Cat3tiletitle;
   }
	
   public static String Category4(){
	   Cat4tile.click();
	   String Cat4tiletitle= driver.getTitle();
	   return Cat4tiletitle;
   }
	
   public static String Category5(){
	   Cat5tile.click();
	   String Cat5tiletitle= driver.getTitle();
	   return Cat5tiletitle;
   }
	
   public static String Category6(){
	   Cat6tile.click();
	   String Cat6tiletitle= driver.getTitle();
	   return Cat6tiletitle;
   }
   
   public static String Category7(){
	   Cat7tile.click();
	   String Cat7tiletitle= driver.getTitle();
	   return Cat7tiletitle;
   } 
   
   public static String Category8(){
	   Cat8tile.click();
	   String Cat8tiletitle= driver.getTitle();
	   return Cat8tiletitle;
   } 
   
   
   
   
}
