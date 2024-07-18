package hanss_rh_framework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import hanss_rh_framework.pageObjects.android.ProductCatalogue;
import hanss_rh_framework.pageObjects.android.CartPage;
import hanss_rh_framework.pageObjects.android.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
@Test
public class eCommerce_tc6_final_Hybrid_Framework extends BaseTestInnergy {
	public void FillForm() throws InterruptedException 
	{
		FormPage formPage = new FormPage(driver);
		formPage.setNameField("Rahul Hanss");
		formPage.setGender("Female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm(); 
ProductCatalogue productCatalogue= new ProductCatalogue(driver);
productCatalogue.addItemToCardByIndex(0);
productCatalogue.addItemToCardByIndex(0);
//productCatalogue.goToCartPage();
CartPage cartPage = productCatalogue.goToCartPage();
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		//taking the Products present in the Cart into a List of WebElements and naming this list as productPricesinCart
double totalSum = cartPage.getProductsSum();	
double displayFormattedSum = cartPage.getTotalAmountDisplayed();		
Assert.assertEquals(totalSum, displayFormattedSum);
cartPage.acceptTermsConditions();
cartPage.submitOrder();
//		List<WebElement> productPricesinCart =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	//	int count = productPricesinCart.size();//saves the count i.e, the number of items present in cart 
	//	double totalSum = 0; // taking double because decimal cannot be store in integer var, decimals can be in stored double
	//	for(int i = 0; i< count; i++)//iterating through the list and capturing amount of each productPricesinCart
	//	{
	//	String amountString = productPricesinCart.get(i).getText();	//grabbing price with $ text from the 
	//	//amountString.substring(1);//to remove $ we are taking the amount from 2nd index onwards i.e., from substring(1).
	//	Double price = Double.parseDouble(amountString.substring(1));//converting string to double using parsedouble
	//	totalSum = totalSum + price; //160.97 + 120 = 280.97

	//	}//System.out.print(totalSum);
	//	String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	//	//Double displayFormattedSum = Double.parseDouble(displaySum.substring(1));
	//	Double displayFormattedSum = getFormattedAmount(displaySum);
		//System.out.print(displayFormattedSum);

	//	Assert.assertEquals(totalSum, displayFormattedSum);
	//	WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	//	longPressAction(ele);
	//	driver.findElement(By.id("android:id/button1")).click();
	//	driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();//when using className to work on any element, use AppiumBy. instead of By.
	//	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);	

		 Set<String> contexts =driver.getContextHandles(); //here after we have clicked on purchase button then the google page
		 //opens, upon opening the google page, we now have two contexts(one for App and 2nd one for the WebPage, we need to
		 //know the context names for both the App & WebPage to use any of the two.
		for(String contextName : contexts)
		{System.out.println(contextName);}
		//NATIVE_APP
		//WEBVIEW_chrome
		//WEBVIEW_com.androidsample.generalstore
		driver.context("WEBVIEW_com.androidsample.generalstore");//now we the appium has access to browser also.
		driver.findElement(By.name("q")).sendKeys("rahul");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP"); 
	}
	
}
