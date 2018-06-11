package com.wrapper;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;

import com.pages.CheckOutPage;
import com.pages.HomePage;
import com.pages.Login;



public class KeyEvents {

	private enum functionNames {
		
		Login,SearchProduct,CheckOutProduct,AddToCart,Category,BuyNow,Signout,END
		
	}
	
	public void event(String sFunctionname)
			throws IOException, NoSuchElementException, InterruptedException, Exception {

		switch (functionNames.valueOf(sFunctionname)) {
		
		case Login:
			Login.get().login();
			break;
			
		case SearchProduct:
			HomePage.get().search();
			break;
			
		case CheckOutProduct:
			CheckOutPage.get().checkOut();
			break;
			
		case BuyNow:
			HomePage.get().buyNow();
			break;
			
		case AddToCart:
			HomePage.get().addToCart();
			break;
			
		
		case Signout:
			CheckOutPage.get().Sign_out();
			break;
			
		}
	}
}
