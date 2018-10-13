/**
 * 
 */
package appiumtry;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;

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
	
	public void takeScreenshot(final String filename) throws IOException {
		  String destDir = "screenshots";
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  new File(destDir).mkdirs();
		  String destFile = dateFormat.format(new Date()) + ".png";
		  FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));

		   /* for AWS
	       String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
	       File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	       return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", filename)));
	    */
	    }
	
	@Test
	public void test() throws InterruptedException, IOException {
		System.out.println("---START---");

		WebElement inptexts = driver.findElementById("editText");
		WebElement inpbutton = driver.findElementById("button");
		
		inptexts.sendKeys("abc");
		Thread.sleep(1000);
		inpbutton.click();
		
		WebElement outtexts = driver.findElementById("textView");
		assertEquals("abc",outtexts.getText());
		System.out.println("---FINISH---");
		 
        takeScreenshot("Top Page");// snapshot
        
		Thread.sleep(1000);
		//assertEquals(1 + 1, 2);		
	}
	

}
