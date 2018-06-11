package com.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import com.wrapper.CommonPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

public class HomePage extends CommonPage{

	private static HomePage HomePage;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='in.amazon.mShop.android.shopping:id/rs_search_src_text']")	
	private MobileElement search;

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apple iPhone 7 (Jet Black, 128GB)']")
	private MobileElement product;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='buyNow_feature_div']")
	private MobileElement buyNowBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='add-to-cart-button']")
	private MobileElement addToCart;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cart']")
	private MobileElement cartBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@NAF='true'and @index='0']")
	private MobileElement quantityBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='dropdown1_1'and @text='2']")
	private MobileElement selectQuantity;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save for later']")
	private MobileElement saveLater;
	
	
	public synchronized static HomePage get() {
		if (HomePage == null) {
			HomePage = new HomePage();
		}
		return HomePage;
	}
	
	private void Decorator() {
		PageFactory.initElements(
				new AppiumFieldDecorator(((AppiumDriver) GetDriver()), new TimeOutDuration(15, TimeUnit.SECONDS)),
				this);

	}
	
	public void search(){
		
		Decorator();
		try{
			
			Dimension size = CL.getDriver().manage().window().getSize();
			int height=size.height;
			int width= size.width;
			int ht=(int) (height-(height*0.05));
			int wdth=(int) (width-(width*0.1));
			
			
			Thread.sleep(5000);
			
			mobileAction.FuncClick(search, "search");
			mobileAction.FuncSendKeys(search, getTestdata("ProductName"));
			mobileAction.FuncClickCoordinates(wdth,ht , 1);
			
			Thread.sleep(10000);
//			String productName = "//android.widget.TextView[@text='"+getTestdata("ProductName")+"')]";
//			MobileElement product = (MobileElement) CL.getDriver().findElement(By.xpath(productName));
//			mobileAction.FuncSwipeWhileElementNotFoundByxpath(productName, false, 10, "Down");
			mobileAction.FuncClick(product, "Apple");

			Thread.sleep(10000);
			//mobileAction.FunctionSwipe("up", 200, 200);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	
	public void buyNow(){
		Decorator();
		try{
			Thread.sleep(5000);

			mobileAction.FunctionSwipe("up", 200, 200);
			mobileAction.FunctionSwipe("up", 200, 200);

		String buyNow="//android.view.View[@resource-id='buyNow_feature_div']";
		
		mobileAction.FuncClick(buyNowBtn, "Buy Now");
		Thread.sleep(20000);
		CL.getDriver().navigate().back();
	}catch(Exception e){
		
		e.printStackTrace();
	}
}
	
	
	public void addToCart(){
		
		Decorator();
		try{
			
			mobileAction.FunctionSwipe("up", 200, 200);
			mobileAction.FunctionSwipe("up", 200, 200);
			
			mobileAction.FuncClick(addToCart, "Add to cart");
			Thread.sleep(5000);
			mobileAction.FuncClick(cartBtn, "cart Button");
			Thread.sleep(10000);
			mobileAction.FuncClick(quantityBtn, "Quantity");
			Thread.sleep(3000);
			mobileAction.FuncClick(selectQuantity, "Select Quantity");
			Thread.sleep(8000);
			mobileAction.FuncClick(saveLater, "Save for Later");
			
		
	}catch(Exception e){
		
		e.printStackTrace();
	}
}
	

	
}
