package hanss_rh_framework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hanss_rh_framework.pageObjects.android.AspirationPage;
import hanss_rh_framework.pageObjects.android.ProfilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Profile2 extends BaseTestInnergy {
	@Test(dataProvider= "getData", groups = "Smoke")
	public void profilePage(HashMap<String, String> input) throws InterruptedException {

		AspirationPage aspire = new AspirationPage(driver);

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(255));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_0_READY__']/android.view.ViewGroup/android.widget.ImageView")));

		String universalLinkforExplore = "https://d-portal-innergy.azurewebsites.net/applinks/ExploreStack";
		String universalLinkforMeditate ="https://d-portal-innergy.azurewebsites.net/applinks/MeditateStack";
		String universalLinkforMembershipPage ="https://d-portal-innergy.azurewebsites.net/applinks/MembershipConversionView";
		String universalLinkforProfile = "https://d-portal-innergy.azurewebsites.net/applinks/ProfileStack";
		String universalLinkforHome = "https://d-portal-innergy.azurewebsites.net/applinks/HomeStack";
		 driver.get(universalLinkforProfile);
		 
		 WebDriverWait waitp = new WebDriverWait(driver, Duration.ofSeconds(395));
			waitp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Downloads']")));

		ProfilePage profile = new ProfilePage(driver);
//   driver.get(universalLinkforProfile);
//   driver.get(universalLinkforMeditate);
	
		profile.swipeAction(profile.Downloads, "left");
		profile.swipeAction(profile.Checkins, "left");

		profile.swipeAction(profile.Reminders, "left");
		profile.swipeAction(profile.History, "left");
		
		
		
        driver.get(universalLinkforExplore);
        WebDriverWait waitExplore = new WebDriverWait(driver, Duration.ofSeconds(395));
		waitExplore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			"//android.widget.TextView[@text='Explore']")));

	profile.selectSearchtoExplore();
		 WebDriverWait waitsearch = new WebDriverWait(driver, Duration.ofSeconds(395));
			waitsearch.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.widget.TextView[@text='Search']")));
	profile.searchContent(input.get("Content1"));
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
	WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Showing\")"));
	Thread.sleep(5000);
	assert element.isDisplayed();
	
	    profile.selectSearchtoExplore();
		driver.pressKey(new KeyEvent(AndroidKey.CLEAR));
	     
		profile.searchContent(input.get("Content2"));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		WebElement search2 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Showing\")"));
		Thread.sleep(5000);
		assert search2.isDisplayed(); 
        
   	profile.selectSearchtoExplore();
   	driver.pressKey(new KeyEvent(AndroidKey.CLEAR));
   	driver.hideKeyboard();
	profile.selectSearchtoExplore();

driver.get(universalLinkforHome);
WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(395));
wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		"//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_0_READY__']/android.view.ViewGroup/android.widget.ImageView")));
driver.get(universalLinkforExplore);
WebDriverWait waitExploreP = new WebDriverWait(driver, Duration.ofSeconds(395));
waitExploreP.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	"//android.widget.TextView[@text='Explore']")));

profile.selectSearchtoExplore();



   	
    WebDriverWait waitrecent = new WebDriverWait(driver, Duration.ofSeconds(395));
	waitrecent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		"//android.widget.TextView[@text='RECENT']")));
   	Thread.sleep(2000);
   	profile.TrendingDance.click();
   	Thread.sleep(2000);
   	//android.widget.TextView[@text="RECENT"]
	/*		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Featured For You\"));"));
		// android.widget.TextView[@text="See All"]
		// android.widget.TextView[@text="See All" and @index="0"] featured
		// android.widget.TextView[@text="See All"])[2] sparks
		// android.widget.TextView[@text="See All"] seasonal
		// android.widget.TextView[@text="See All"])[1] aspiration1
		// android.widget.TextView[@text="See All"])[2] aspiration2
		// android.widget.TextView[@text="See All"])[3] aspiration3
		// com.horcrux.svg.SvgView remove from continue 3 dots class

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Reflections\"));"));
//aspire.openMoodCheckinFromHome(); mood checkin home
		WebDriverWait waitforMoodCheckinLoad = new WebDriverWait(driver, Duration.ofSeconds(180));
		waitforMoodCheckinLoad.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Grateful']")));

		aspire.selectGratefulMood();
		aspire.selectTagAbilitytoServe();
		aspire.selectTagFamily();
		aspire.addaNoteForMoodCheckin("grateful for good health");
		aspire.saveMyMoodCheckin();
		WebDriverWait waitforViewHistory = new WebDriverWait(driver, Duration.ofSeconds(40));
		waitforViewHistory.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Recommended For You']")));

//aspire.clickViewHistoryMood();
//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"When would you like to check-in?\"));"));
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
*/
		/*
		 * WebElement frame =
		 * driver.findElement(By.className("android.widget.FrameLayout"));
		 * driver.switchTo().frame(frame); WebElement button =
		 * driver.findElement(By.id("profilebutton_id")); button.click();
		 * driver.switchTo().defaultContent();
		 */
	}

	// android.widget.TextView[@text="Logout"]
	// com.horcrux.svg.SvgView
	@BeforeMethod(alwaysRun = true)
	public void preSetup() {
		AspirationPage aspire = new AspirationPage(driver);
		aspire.setAppActivity();

	}
	@DataProvider
	public Object getData() throws IOException {
		List<HashMap<String, String>> data = getJasonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\testData\\userData.json");
		return new Object[][] { { data.get(0) } };
//	return new Object[][] {{data.get(0)},{data.get(1)}, {data.get(2)} };
		// return new Object[][] {{" ","",""},{" ","",""} };

	}
	

}
