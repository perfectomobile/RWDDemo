package GridExe;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sun.net.www.content.audio.basic;


public class TestAmexSite extends BasicTest{

	 
	 
	 
	public TestAmexSite(WebDriver driver, String browser, boolean isMobileDevice) {
		super(driver, browser, isMobileDevice);
 	}

	public void execTest()
	{
		System.out.println("***  START **** "+_exePlatform);

		_driver.get("http://www.americanexpress.com");
		_driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		WebElement item  = _driver.findElement(By.xpath("//*[@id='manage']"));
		takeScreenShot(_exePlatform+"Before",_driver);
		_driver.findElement(By.xpath("(//input[@id=\"Username\"])[1]")).sendKeys("uzi");
		takeScreenShot(_exePlatform+"After",_driver);

		// only perfecto mobile support VISUAL
		if (_isMobileDevice)
		{
			switchToContext("VISUAL",_driver);
			_driver.findElement(By.linkText("uzi"));
			switchToContext("WEBVIEW",_driver);
		}

		
		_driver.findElement(By.xpath("(//input[@id=\"Username\"])[1]")).clear();
		_driver.quit();

	}



}
