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
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class DeepLinks extends BaseTestInnergy {
	@Test(dataProvider = "getData", groups = "Smoke")
	public void SelectAspirations(HashMap<String, String> input) throws InterruptedException {
	

		AspirationPage aspire = new AspirationPage(driver);

		// int c=input.size();
		// System.out.println(c);
		// aspire.selectAspiration(input.get("Aspiration1"));
		// aspire.selectAspiration(input.get("Aspiration2"));
		// aspire.selectAspiration(input.get("Aspiration3"));
		// driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
//String enka= driver.findElement(By.xpath("//android.view.ViewGroup[@index='3']")).getAttribute("enabled");
//Assert.assertEquals(enka, "false");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(280));
		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Happiness']")));
		for (int i = 1; i <= 3; i++) {
			System.out.println(input.get("Aspiration" + i + ""));
			aspire.selectAspiration(input.get("Aspiration" + i + ""));
			// driver.findElement(By.xpath("//android.widget.TextView[@text='Be
			// Happy']")).click();
		}
		aspire.ContinueOnAspirationSelectionScreen();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(180));
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Signup']")));
		aspire.readTermsAndConditions();
		
		Thread.sleep(2000);	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		aspire.ClickonLoginFromSignup();
		// android.widget.TextView[@text="Login"]
		//aspire.EnterLoginEmail("rahulhans995@gmail.com");
		aspire.EnterSignupEmail(input.get("SignupUserEmail"));
		aspire.ClickonSignupFromLogin();
		
		aspire.ClickonLoginFromSignup();
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait11.until(ExpectedConditions.attributeContains(
				driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")), "text", "Login"));
		aspire.EnterLoginEmail(input.get("LoginUserEmail"));
	//	aspire.EnterLoginEmail("vankatveralli@gmail.com");
		aspire.ContinueOnLoginScreen();
		WebDriverWait waitotp = new WebDriverWait(driver, Duration.ofSeconds(180));
		waitotp.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='textInput'][1]")));
		aspire.EnterLoginOTP();
		aspire.ContinueOnOTPScreen();
	//	Thread.sleep(20000);
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(395));
		wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_0_READY__']/android.view.ViewGroup/android.widget.ImageView")));
	
		aspire.swipeAction(aspire.HomeCarouselSlide1, "left");
		aspire.swipeAction(aspire.HomeCarouselContent1, "left");
		aspire.swipeAction(aspire.HomeCarouselContent2, "left");
		aspire.swipeAction(aspire.HomeCarouselContent3, "left");
		aspire.swipeAction(aspire.HomeCarouselContent4, "left");
		aspire.swipeAction(aspire.HomeCarouselContent5, "right");
		aspire.swipeAction(aspire.HomeCarouselContent4, "right");
		aspire.swipeAction(aspire.HomeCarouselContent3, "right");
		aspire.swipeAction(aspire.HomeCarouselContent2, "right");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Trending\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Featured For You\"));"));
		//android.widget.TextView[@text="See All"]
		//android.widget.TextView[@text="See All" and @index="0"] featured
		//android.widget.TextView[@text="See All"])[2] sparks
		//android.widget.TextView[@text="See All"]  seasonal
		//android.widget.TextView[@text="See All"])[1] aspiration1
		//android.widget.TextView[@text="See All"])[2] aspiration2
		//android.widget.TextView[@text="See All"])[3] aspiration3
     	//	com.horcrux.svg.SvgView   remove from continue 3 dots class
		
	
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Reflections\"));"));
//aspire.openMoodCheckinFromHome(); mood checkin home
		    WebDriverWait waitforMoodCheckinLoad = new WebDriverWait(driver, Duration.ofSeconds(180));
		    waitforMoodCheckinLoad.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Grateful']")));
	
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
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"When would you like to check-in?\"));"));
		Thread.sleep(10000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
		 Set<String> contexts =driver.getContextHandles();
		 for(String contextName : contexts)
		 { System.out.println(contextName);}

	
/*		 WebElement frame = driver.findElement(By.className("android.widget.FrameLayout"));
		 driver.switchTo().frame(frame);
		 WebElement button = driver.findElement(By.id("profilebutton_id"));
	        button.click(); 
	       driver.switchTo().defaultContent();
*/
	}

	// 00000000-0000-01ee-ffff-ffff00000023
	// elementId
//	00000000-0000-03f2-ffff-ffff00000245 mood
//00000000-0000-03f2-ffff-ffff0000025a grat
	
	//android.widget.TextView[@text="Logout"]
	//com.horcrux.svg.SvgView
	@BeforeMethod(alwaysRun = true)
	public void preSetup() {
		AspirationPage aspire = new AspirationPage(driver);
		aspire.setAppActivity();

	}
	@DataProvider
	public Object getData() throws IOException {
		List<HashMap<String, String>> data = getJasonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\testData\\eInnergy.json");
		return new Object[][] { { data.get(0) } };
//	return new Object[][] {{data.get(0)},{data.get(1)}, {data.get(2)} };
		// return new Object[][] {{" ","",""},{" ","",""} };

	}
	

	
}
