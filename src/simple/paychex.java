package simple;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.TabExpander;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;

public class paychex
{
	public static void main(String[] args)
	{
		start();
		//AndroidDriver();
	}

	public static void start()   {


		// execute the script on browser or mobile 
		// this Selenium scripts can be executed on web browser and phone 
		// the only change is the driver 
		
		
		// for mobile keep it ture for browser set it to false
		boolean mobile = true;
		WebDriver  webdriver;
		if (mobile)
		{
			MobileDriver PMdriver = new MobileDriver();
			IMobileDevice device = PMdriver.getDevice("0149BCA71700D01F");
 		    webdriver = device.getDOMDriver ("http://www.paychex.com");
			
		}
		else
		{
			webdriver = new ChromeDriver();
		}

 
		webdriver.get("http://www.paychex.com");
		webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		WebElement item  = webdriver.findElement(By.xpath(".//*[@id='txtEmployees']"));
		item.sendKeys("300");
		webdriver.findElement(By.xpath(".//*[@id='imgSubmit']")).click();

		webdriver.findElement(By.xpath("(//input[@id=\"pageContent_formsControl_txtFirstname1_txtFirstname\"])[1]")).sendKeys("uzi");
		webdriver.findElement(By.xpath("(//input[@id=\"pageContent_formsControl_txtLastname1_txtLastname\"])[1]")).sendKeys("Eilon");
		webdriver.findElement(By.xpath("(//input[@id=\"pageContent_formsControl_txtPhone1_txtPhone\"])[1]")).sendKeys("55523123112");
		webdriver.findElement(By.xpath("(//input[@id=\"pageContent_formsControl_txtEmail1_txtEmail\"])[1]")).sendKeys("uzie@perfectomobile.com");
		webdriver.findElement(By.xpath("(//input[@id=\"pageContent_formsControl_txtCompany1_txtCompany\"])[1]")).sendKeys("Perfecto Mobile");

		try{
			webdriver.quit();

		}catch (Exception e)
		{
			//	e.printStackTrace();
		}


	}

}