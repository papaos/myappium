/**
 * 
 */
package appiumtry;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author MyPC
 *
 */
public class testcase2 {
	static public AndroidDriver<AndroidElement> driver = null;
	static public WebDriverWait wait;
	
	static DesiredCapabilities dc = new DesiredCapabilities();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
			dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");
			
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "002618609390");
	        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1");

		    dc.setCapability(MobileCapabilityType.APP, "C:\\MyPj\\Myapp\\MyFirstApp\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
			dc.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.example.myfirstapp");
	       
	        try {
	        	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
	        }catch (Exception e1) {
	            System.out.println("Exception has been handled" + e1);
	        }
	        driver.setLogLevel(Level.INFO);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if(driver != null)
		{
			driver.quit();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println("---START---");

		WebElement inptexts = driver.findElementById("editText");
		WebElement inpbutton = driver.findElementById("button");
		
		inptexts.sendKeys("abc");
		Thread.sleep(1000);
		inpbutton.click();
		
		WebElement outtexts = driver.findElementById("textView");
		assertEquals("abc",outtexts.getText());
		System.out.println("---FINISH---");
		Thread.sleep(1000);
		//assertEquals(1 + 1, 2);		
	}

}
