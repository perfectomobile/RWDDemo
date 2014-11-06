package GridExe;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.MobileDOMAutomationType;

public class firefox {
	public static void main(String[] args) {

		String url = "http://127.0.0.1:5555/wd/hub";
		if (args.length == 1) {
			url = args[0] ;  
			System.out.println("url :"+url);
			
		}
		try {
			rematePerfecto( );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static void Remote(String url) throws Exception {
		// WebDriver webdriver = new  FirefoxDriver();

		DesiredCapabilities capability = DesiredCapabilities.firefox();
		
		 
		
		 
		
 		URL selurl = new URL("http://54.186.57.183:5555/wd/hub");
  		//
 	//	URL selurl = new URL(url);

		
		//java -jar selenium-server-standalone-2.41.0.jar -hub 
	//	URL selurl = new URL("http://127.0.01:4444/wd/hub");

		WebDriver webdriver = new RemoteWebDriver(selurl, capability);


		// And now use this to visit Google
		webdriver.get("https://agentfocus.sfbli.com/GoQuote/Default.aspx");
		//  webdriver.get("google.com");
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


		// set gender
		webdriver.findElement(By.xpath("//*[@class=\"ui-btn-text\" and text()=\"Female\"]")).click();
		// re-press to see if there is any error 
		webdriver.findElement(By.xpath("//*[@class=\"ui-btn-text\" and text()=\"Female\"]")).click();

		// set the age
		webdriver.findElement(By.xpath("//*[@id=\"slider-age\"]")).clear();
		webdriver.findElement(By.xpath("//*[@id=\"slider-age\"]")).sendKeys("25");		   

		// clear and set value 
		webdriver.findElement(By.xpath("//*[@id=\"number-amount\"]")).clear();
		webdriver.findElement(By.xpath("//*[@id=\"number-amount\"]")).sendKeys("400");

		// waiver on off , start point = off press on off
		// ****
		// start off click on on 
		// webdriver.findElement(By.xpath("//*[@id=\"wp\"]/div/div[2]/div/span[1]")).click();
		// error This WebElement is not visisble and may not be clicked.
		// ***
		webdriver.findElement(By.xpath("//*[@id=\"wp\"]/div/div[2]/div/span[2]")).click();

		// better xpath [1] - on  

		//    webdriver.findElement(By.xpath("//*[@id=\"rider\"]//*[@role=\"img\"][1]")).click();


		//togel
		webdriver.findElement(By.xpath("//*[@id=\"rider\"]//*[@role=\"img\" and @style=\"width: 100%;\"]")).click();

		webdriver.findElement(By.xpath("//*[@id=\"rider\"]//*[@role=\"img\" and @style=\"width: 100%;\"]")).click();

	}
	
	public static void rematePerfecto()
	{
		
		MobileDriver PMdriver = new MobileDriver();
		IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");
		device.open();
		WebDriver webdriver = device.getDOMDriver("carmax.com");

		RemoteWebDriver wb = (RemoteWebDriver)webdriver;
		wb.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		// We could use any driver for our tests...
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// ... but only if it supports javascript
		capabilities.setJavascriptEnabled(true);
		
 		// Get a handle to the driver. This will throw an exception
		
		// if a matching driver cannot be located
		WebDriver driver = new RemoteWebDriver(capabilities);
 
		driver.get("http://www.google.com");
	}

	public static void perfecto (boolean pm)
	{
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
	//	URL selurl = new URL("http://localhost:4444/wd/hub");

//		WebDriver webdriver = new RemoteWebDriver(selurl, capability);

		RemoteWebDriver webdriver ;
		if (pm) 
		{
			MobileDriver PMdriver = new MobileDriver();

			IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");
			device.open();
			webdriver = (RemoteWebDriver)device.getDOMDriver("carmax.com");
			webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		}
		else
		{
			webdriver = new FirefoxDriver();
			webdriver.get("http://m.carmax.com");
		}




		webdriver.findElement(By.xpath("//*[@class=\"icon-menu\"]")).click();
		webdriver.findElement(By.xpath("//*[@class='ui-btn-text']//*[text()=\"Calculators\"]")).click();

		// get the full list 


		List<WebElement> objList =webdriver.findElements(By.xpath("//*[@class=\"home-nav ui-listview\"]//*[@class=\"ui-link-inherit\"]"));
		for (int i = 0 ; i <objList.size() ; i++)
		{
			WebElement item = objList.get(i);
			System.out.println("****"+item.getText());
		}
		// press the first one 
		objList.get(1).click();;


		webdriver.findElement(By.xpath("(//input[@id=\"payment\"])[1]")).sendKeys("100");
		webdriver.findElement(By.xpath("(//input[@id=\"apr\"])[1]")).sendKeys("2.6");
		webdriver.findElement(By.xpath("(//input[@id=\"submit\"])[1]")).click();

	}

}
