package com.wrapper;


import java.util.HashMap;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class CommonPage {

	public com.wrapper.LaunchApp CL = new com.wrapper.LaunchApp();
	public com.wrapper.MobileAction mobileAction = new com.wrapper.MobileAction();
	public com.wrapper.ReadFromExcel excel = new com.wrapper.ReadFromExcel();
	
	AppiumDriver<WebElement> appiumDriver;
	
		
	/**
	 * This method is used to retrieve the values from excel sheet
	 *
	 * 
	 * 
	 * @param key
	 */

	public String getTestdata(String aColumn) {
		return excel.testData.get(aColumn);
	}
	
	public AppiumDriver<WebElement> GetDriver(){
		appiumDriver=LaunchApp.driver;
		return appiumDriver;
	}
	
}
