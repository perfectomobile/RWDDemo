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


public class Paychex extends BasicTest{




	public Paychex(WebDriver driver, String browser, boolean isMobileDevice) {
		super(driver, browser, isMobileDevice);
	}

	public void execTest()
	{
		System.out.println("***  START **** "+_exePlatform);

		_driver.get("http://www.paychex.com");
		_driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		takeScreenShot(_exePlatform+"First Page",_driver);

		WebElement item  = _driver.findElement(By.xpath(".//*[@id='txtEmployees']"));
		item.sendKeys("300");
		_driver.findElement(By.xpath(".//*[@id='imgSubmit']")).click();

		takeScreenShot(_exePlatform+"_300Emp",_driver);
		_driver.quit();
		 
	}



}
