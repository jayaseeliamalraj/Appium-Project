package com.wrapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {
	
	public static AppiumDriver<WebElement> driver;
	
	public AppiumDriver<WebElement> getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}



	public AppiumDriver<WebElement> launchApp(){
		try{
			String File ="MobileData.Properties";
			FileInputStream file;
					file = new FileInputStream(File);
				Properties	prop = new Properties();
					prop.load(file);
					
					System.out.println(prop.getProperty("url"));
				
			 DesiredCapabilities capabilities = new DesiredCapabilities();
		     capabilities.setCapability("udid",prop.getProperty("udid"));
		     capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
		     capabilities.setCapability("platformName",prop.getProperty("platformName"));
		     capabilities.setCapability("platformVersion",prop.getProperty("platformVersion"));
		     capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("appPath"));
		     capabilities.setCapability("appPackage",prop.getProperty("appPackage"));
		     //capabilities.setCapability(MobileCapabilityType.NO_RESET, prop.getProperty("noReset"));
		     capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
		     System.out.println("To start");
		     driver =  new AndroidDriver<WebElement>(new URL(prop.getProperty("url")),capabilities);
			return driver;	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
