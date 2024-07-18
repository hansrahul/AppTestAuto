package hanss_rh_framework.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import hanss_rh_framework.Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends AndroidActions {
	AndroidDriver driver;

	public ProfilePage(AndroidDriver driver)// constructor
	{
		super(driver); // as the parent class is having driver too, it calls constructor with driver
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// initElements is called only once at the start, all the locators which we will
		// create below,
		// at once they will be
		// does construction of the objects for all the below mentioned elements
	}

	// driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul
	// Hanss");
	// creating the above locator information and using from this file in all the
	// required places dynamically
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore']")
	public WebElement ExplorePage;

	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='search.key']")
	public WebElement SearchtoExplore;

	public void selectSearchtoExplore() {
		SearchtoExplore.click();
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Nutrition']")
	public WebElement TrendingNutrition;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Fitness']")
	public WebElement TrendingFitness;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Dance']")
	public WebElement TrendingDance;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Meditation']")
	public WebElement TrendingMeditation;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sleep']")
	public WebElement TrendingSleep;
	
	public void searchContent(String content) {
		SearchtoExplore.sendKeys(content);
		driver.hideKeyboard();
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='RECENT']")
	public WebElement RecentSearch;
	
	
	
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	// driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	// driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();

	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setGender(String gender) {
		if (gender.contains("Female"))
			femaleOption.click();
		else
			maleOption.click();
	}

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryChooseDropdownMenu;
	// driver.findElement(By.id("android:id/text1")).click();//clicked on DropDown
	// for the select country

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Argentina']")
	private WebElement countryNameArgentina;
	// driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

	public void setCountrySelection(String countryName) {
		countryChooseDropdownMenu.click();
		ScrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	// driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	public void submitForm() {
		shopButton.click();
	}

	public void setActivity() {
		// adb shell dumpsys window | find "mCurrentFocus"
		// mCurrentFocus=Window{bf44795 u0
		// com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}
		// mCurrentFocus=Window{47df82c u0
		// com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}
		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);

	}

	public void selectAspiration(String Aspiration) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + Aspiration + "']")).click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement ContinueButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in']")
	private WebElement Login;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up']")
	private WebElement Signup;

	public void ClickonLoginFromSignup() {
		Login.click();
	}

	public void ClickonSignupFromLogin() {
		Signup.click();
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Email']")
	private WebElement LoginEmail;

	public void EnterLoginEmail(String LoginUserEmail) {
		LoginEmail.sendKeys(LoginUserEmail);
	}
	public void EnterSignupEmail(String SignupUserEmail) {
		LoginEmail.sendKeys(SignupUserEmail);
	}
//	(//android.widget.EditText[@resource-id="textInput"])[6]
	public void setAppNActivity() {
		// adb shell dumpsys window | find "mCurrentFocus"
		// mCurrentFocus=Window{ffb8fb1 u0
		// com.rstar.innergy.qa/com.rstar.innergy.qa.MainActivity}
		// mCurrentFocus=Window{bf44795 u0
		// com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}
		// mCurrentFocus=Window{47df82c u0
		// com.androidsample.generalstore/com.androidsample.generalstore.MainActivity}

		/*
		 * Activity activity1 = new Activity("com.google.android.permissioncontroller",
		 * "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity");
		 * driver.startActivity(activity1); try { // Example: Clicking "Allow" button on
		 * the notifications popup
		 * driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click(
		 * ); } catch (Exception e) { // Handle exception if notifications popup is not
		 * present
		 * System.out.println("Notifications popup not found or already handled."); }
		 */
		setAppActivity();
	}

	public void ContinueOnAspirationSelectionScreen() {
		ContinueButton.click();
	}

	public void ContinueOnLoginScreen() {
		ContinueButton.click();
	}

	public void setAppActivity() {
		Activity activity = new Activity("com.rstar.innergy", "com.rstar.innergy.MainActivity");
		//driver.startActivity(activity);

		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent", "com.rstar.innergy/com.rstar.innergy.MainActivity"));
			
	}

	public void EnterLoginOTP() {

		for (int d = 1; d <= 6; d++) {
			driver.findElement(By.xpath("(//android.widget.EditText[@resource-id='textInput'])[" + d + "]"))
					.sendKeys("1");
		}
	}

	public void ContinueOnOTPScreen() {
		ContinueButton.click();

	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_0_READY__']/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]")
	public WebElement HomeCarouselSlide1;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_1_READY__']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	public WebElement HomeCarouselContent1;
	//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.View
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_2_READY__']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
	public WebElement HomeCarouselContent2;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_3_READY__']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	public WebElement HomeCarouselContent3;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_4_READY__']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	public WebElement HomeCarouselContent4;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"__CAROUSEL_ITEM_5_READY__\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	public WebElement HomeCarouselContent5;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@elementId='00000000-0000-0476-ffff-ffff000002a1']")
	public WebElement MoodCheckinHome;

	public void openMoodCheckinFromHome() {
		MoodCheckinHome.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Grateful']")
	public WebElement GratefulMood;

	public void selectGratefulMood() {
		GratefulMood.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ability to serve']")
	public WebElement TagAbilitytoServe;

	public void selectTagAbilitytoServe() {
		TagAbilitytoServe.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Family']")
	public WebElement TagFamily;

	public void selectTagFamily() {
		TagFamily.click();
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='AddNotes.Input']")
	public WebElement AddaNote;

	public void addaNoteForMoodCheckin(String note) {
		AddaNote.sendKeys(note);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='AddNote.Button']")
	public WebElement SaveMood;

	public void saveMyMoodCheckin() {
		SaveMood.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
	public WebElement TermsandConditions;

	public void readTermsAndConditions() {
		TermsandConditions.click();
		scrollToEndAction();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View History']")
	public WebElement ViewHistoryMood;

	public void clickViewHistoryMood() throws InterruptedException {
		ViewHistoryMood.click();
		System.out.println("mood history viewed");Thread.sleep(22000);
	}

	// android.view.ViewGroup[@resource-id="AddNote.Button"]
	// android.widget.TextView[@text="Family"]
@AndroidFindBy(xpath= "//android.widget.TextView[@text='Downloads']")
public WebElement Downloads;

@AndroidFindBy(xpath= "//android.widget.TextView[@text='Check-ins']")
public WebElement Checkins;
//android.widget.TextView[@text='Check-ins']

@AndroidFindBy(xpath= "//android.widget.TextView[@text='Reminders']")
public WebElement Reminders;

@AndroidFindBy(xpath= "//android.widget.TextView[@text='History']")
public WebElement History;


}
