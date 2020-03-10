package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WrapperClass {
	protected WebDriver driver;
	public void launchApplication(String browser,String url) {
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "G:\\selenium\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.get(url);
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\BLTuser.BLT1026\\eclipse-workspace\\Be.Cognizant\\src\\test\\resources\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
		
		
		}
		catch(WebDriverException e) {
			System.out.println("browser could not be launched");
			
		}
	}
		public void screenshot ( String path ) throws IOException{
			
			TakesScreenshot ts=((TakesScreenshot)driver);
			File Source=ts.getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(Source, new File(path));
			
		}
	
	public void quit() {
		driver.close();
	}

}
