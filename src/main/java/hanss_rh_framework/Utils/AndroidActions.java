package hanss_rh_framework.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		
		this.driver = driver;
	}
	public void ScrollToText(String text)
	{
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	
	}
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000)); 	
	}
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		canScrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		"left", 100, "top", 100, "width", 200, "height", 200,
		"direction", "down",
		"percent", 3.0
		));
		}while(canScrollMore);
	}
	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"direction", direction,
				"percent", 0.75
			));
	}
	/* public void scrollTabsToLeft() throws UiObjectNotFoundException {
	        UiDevice device = UiDevice.getInstance(getInstrumentation());

	        // Find the HorizontalScrollView containing the tabs
	        UiScrollable tabs = new UiScrollable(new UiSelector()
	                .className("android.widget.HorizontalScrollView"));

	        // Scroll to the left
	        tabs.scrollToBeginning(10); // 10 is the max number of scrolls, adjust as necessary

	        // Optionally, verify the 'Reminders' tab is visible
	        UiObject remindersTab = tabs.getChildByText(new UiSelector()
	                .className("android.widget.TextView"), "Reminders");

	        if (remindersTab.exists()) {
	            remindersTab.click(); // Click the Reminders tab if needed
	        }}
	*/
	
}
