package hanss_rh_framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;
	//public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
//Start Appium Server from cmd auto code start code not working so, blocking this code
	/*Map<String, String> env = new HashMap<String, String>(System.getenv());
	env.put("ANDROID HOME", "C:\\Users\\rSTAR_User.DESKTOP-510IN1N\\AppData\\Local\\Android\\Sdk") ;
	env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-20\\bin") ;*/
	
/*service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\rSTAR_User.DESKTOP-510IN1N\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
	.withIPAddress("127.0.0.1").usingPort(4723).build();
  service.start();
*/		
	/*AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\rSTAR_User.DESKTOP-510IN1N\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();*/
  
//code to start server
//AndroidDriver , IOSDriver
//Appium code -> Appium Server -> Mobile
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("rh_pixel");
	options.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\ApiDemos-debug.apk");
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 } 
	@AfterMethod
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//service.stop();
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
	
	
}
