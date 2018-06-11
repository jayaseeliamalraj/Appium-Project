package com.wrapper;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MobileAction {
	
	AppiumDriver<WebElement> appiumDriver1;
	
	
	public AppiumDriver<WebElement> GetMobileActionDriver(){
		appiumDriver1=LaunchApp.driver;
		return appiumDriver1;
	}

	/**
	 * This method will look for an element on the screen to be clickable within
	 * the given timeout and then click over the element.
	 * 
	 * 
	 */
	public void FuncClick(MobileElement objElement, String text)
			throws InterruptedException, IOException, NoSuchElementException {
		try {

			WebDriverWait wait = new WebDriverWait(GetMobileActionDriver(), 15L);
			wait.until(ExpectedConditions.visibilityOf(objElement));

			objElement.click();
			System.out.println("Clicked on the element: "+text);

		} catch (Exception e) {
			System.err.println("Test Case failed");
			e.printStackTrace();
			
		}
	}

	public void FuncSendKeys(MobileElement objElement, String sTextToSend)
			throws InterruptedException, IOException, TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(GetMobileActionDriver(), 10L);
			wait.until(ExpectedConditions.elementToBeClickable(objElement));
			objElement.clear();
			objElement.sendKeys(new CharSequence[] { sTextToSend });
			
			System.out.println("Value Entered: " +sTextToSend);
			
		} catch (IllegalArgumentException e) {		
			throw e;
		} catch (TimeoutException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void verifyElementIsDisplayed(WebElement mobileElement, String expectedText) throws IOException { // @Author
		
		try {
		WebDriverWait wait = new WebDriverWait(GetMobileActionDriver(), 10L);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
		
		mobileElement.isDisplayed();
		
		System.out.println("Element is Displayed: "+expectedText);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	public void FunctionSwipe(String Direction, int swipeTime, int Offset) throws IOException {
		try {

			Dimension size;
			size = ((AppiumDriver) GetMobileActionDriver()).manage().window().getSize();
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.20);
			int startx = size.width / 2;
			if (Direction.equalsIgnoreCase("Up")) {
				((MobileDriver) GetMobileActionDriver()).swipe(startx, starty - Offset, startx, endy, swipeTime);
			} else if (Direction.equalsIgnoreCase("Down")) {
				((MobileDriver) GetMobileActionDriver()).swipe(startx, endy + Offset, startx, starty, swipeTime);
			} else if (Direction.equalsIgnoreCase("Right")) {
				starty = size.height / 2;
				endy = size.height / 2;
				startx = (int) (size.width * 0.10);
				int endx = (int) (size.width * 0.90);
				((MobileDriver) GetMobileActionDriver()).swipe(startx + Offset, starty, endx, endy, swipeTime);
			} else if (Direction.equalsIgnoreCase("Left")) {
				starty = size.height / 2;
				endy = size.height / 2;
				startx = (int) (size.width * 0.90);
				int endx = (int) (size.width * 0.10);
				((MobileDriver) GetMobileActionDriver()).swipe(startx - Offset, starty, endx, endy, swipeTime);
			}

		} catch (Exception e) {
			throw e;
		}

	}

	public void FuncHideKeyboard() throws IOException {

		try {
			// ((AppiumDriver) GetDriver()).navigate().back();
			(GetMobileActionDriver()).hideKeyboard();
			System.out.println("Keyboard hided");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException occured while while closing keyboard, but ignor it");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean verifyElementIsPresent(WebElement elementToFind) {

		try {
			if (elementToFind.isDisplayed()) {

				return true;
			} else {

				return false;

			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public String FuncGetTextByxpath(String xpathEle)
		{
		String sEleText = "";
		 {
		try {
		sEleText = GetMobileActionDriver().findElement(By.xpath(xpathEle)).getText();
		} catch (Exception e) {
		
		e.printStackTrace();
		
		}
		} 
		try {
		sEleText = GetMobileActionDriver().findElement(By.xpath(xpathEle)).getAttribute("label");
		} catch (Exception e) {
		try {
		sEleText = GetMobileActionDriver().findElement(By.xpath(xpathEle)).getAttribute("value");
		} catch (Exception e1) {
		try {
		sEleText = GetMobileActionDriver().findElement(By.xpath(xpathEle)).getAttribute("name");
		} catch (Exception e2) {
		
		e2.printStackTrace();
		}
		}
		}
		
		return sEleText;
		}
	

	
	/**
	 * This method will click over a particular coordinate the number of times
	 * it has been specified with a delay of 80 ms between each click.
	 * 
	 *
	 */
	public void FuncClickCoordinates(int x, int y, int clickCount) throws Exception {
		try {
			int i = 0;
			TouchAction action = new TouchAction(((MobileDriver) GetMobileActionDriver()));
			while (i < clickCount) {
				action.tap(x, y).perform();

				i++;
				Thread.sleep(80);
			}
			
		} catch (IllegalArgumentException e) {
			
			throw e;
		} catch (NoSuchElementException n) {
			
			throw n;
		} catch (Exception e) {
			throw e;
		}
	}
	
	

}