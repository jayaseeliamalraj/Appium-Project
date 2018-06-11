package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.wrapper.CommonPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class CheckOutPage extends CommonPage{
	
	private static CheckOutPage CheckOutPage;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Deliver to this address')]")
	private MobileElement DeliverToThisAddrBtn;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='existingCvvNum']")
	private MobileElement cvvNum;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='continueButton']")
	private MobileElement continueBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Place Your Order and Pay')]")
	private MobileElement placeYourOrderAndPay;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='in.amazon.mShop.android.shopping:id/action_bar_burger_icon' and @content-desc='Navigation panel, button, double tap to open side panel']")
	private MobileElement menuFlyout;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Settings button. Double tap for links to change country, sign out, and more.']")
	private MobileElement Settings;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sign out')]")
	private MobileElement SignOut;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2' and @text='Sign Out']")
	private MobileElement SignOut_popup;
	
	public synchronized static CheckOutPage get() {
		if (CheckOutPage == null) {
			CheckOutPage = new CheckOutPage();
		}
		return CheckOutPage;
	}
	
	private void Decorator() {
		PageFactory.initElements(
				new AppiumFieldDecorator(((AppiumDriver) GetDriver()), new TimeOutDuration(15, TimeUnit.SECONDS)),
				this);
	}
	
/* This method will check out the selected  product */
	
	public void checkOut(){
		
		Decorator();
		try{
			
			mobileAction.FuncClick(DeliverToThisAddrBtn, "Deliver to this Address");
			mobileAction.FuncSendKeys(cvvNum, getTestdata("CVVNumber"));
			Thread.sleep(10000);
			mobileAction.FuncClick(continueBtn, "Continue Button");
			if(mobileAction.verifyElementIsPresent(placeYourOrderAndPay)){
				mobileAction.verifyElementIsDisplayed(placeYourOrderAndPay, "Place Your Order And Pay");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Sign_out(){
		Decorator();
		try{
			mobileAction.FuncClick(menuFlyout, "menu");
			mobileAction.FuncClick(Settings, "Settings");
			mobileAction.FuncClick(SignOut,"Sign out clicked");
			mobileAction.FuncClick(SignOut_popup, "sign out popup");
		}catch(Exception e){
		e.printStackTrace();
	}
	}
}
