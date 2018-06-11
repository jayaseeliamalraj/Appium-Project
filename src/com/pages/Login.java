package com.pages;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.wrapper.CommonPage;
import com.wrapper.LaunchApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import io.appium.java_client.pagefactory.iOSFindBy;


public class Login extends CommonPage{
	
	private static Login Login;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Already a customer? Sign In']")
	private MobileElement alreadyACustomerSignIn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Welcome']")
	private MobileElement welcome;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
	private MobileElement userName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	private MobileElement password;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@reource-id='auth-signin-show-password-checkbox']")
	private MobileElement showPasswordTrue;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@reource-id='auth-signin-show-password-checkbox' and @checked='false']")
	private MobileElement showPasswordFalse;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
	private MobileElement loginBtn;
	
	
	public synchronized static Login get() {
		if (Login == null) {
			Login = new Login();
		}
		return Login;
	}
	


	private void Decorator() {
		PageFactory.initElements(
				new AppiumFieldDecorator(((AppiumDriver) GetDriver()), new TimeOutDuration(15, TimeUnit.SECONDS)),
				this);

	}
	
	public void login() {

		Decorator();
		try{
			Thread.sleep(10000);
			
			System.out.println("Entered in login Page");
			Thread.sleep(10000);
			mobileAction.FuncClick(alreadyACustomerSignIn, "Already A Customer Sign In");
			Thread.sleep(10000);
			mobileAction.verifyElementIsDisplayed(welcome ,"Welcome");
			/*if(mobileAction.verifyElementIsPresent(showPasswordFalse)){
				mobileAction.FuncClick(showPasswordFalse, "Show Password");
				System.out.println("Clicked on the Check Box");
			}else{
				mobileAction.FuncClick(showPasswordTrue, "Show Password");
				System.out.println("Clicked on the Check Box True");
			}*/
			mobileAction.FuncSendKeys(userName, getTestdata("Username"));
			mobileAction.FuncSendKeys(password, getTestdata("Password"));
			mobileAction.FuncHideKeyboard();
			mobileAction.FuncClick(loginBtn, "Login");
			Thread.sleep(10000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
}
