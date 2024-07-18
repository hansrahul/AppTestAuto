package hanss_rh_framework;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import hanss_rh_framework.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class BaseTestInnergy extends AppiumUtils{
	
	public AndroidDriver driver;
	//public AppiumDriverLocalService service;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String AndroidDeviceName = prop.getProperty("AndroidDeviceName");
		
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		
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
	options.setDeviceName(AndroidDeviceName);
	options.setCapability("autoDismissAlerts", true);
	options.setCapability("autoGrantPermissions", true);
	options.setCapability("autoAcceptAlerts", true);
	//options.setDeviceName("rh_pixel");
//	options.setChromedriverExecutable("C:\\Users\\Aanisha_Sethi\\Downloads\\mongosh-2.2.4-win32-x64\\chromedriver.exe");
//options.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\app-release495.apk");
	options.setCapability("appPackage", "com.rstar.innergy");
	options.setCapability("appActivity", "com.rstar.innergy.MainActivity");
	options.setCapability("noReset", true);;
//	driver = new AndroidDriver(new URL(ipAddress+":"+port), options);
	driver = new AndroidDriver(new URL("http://"+ipAddress+":"+port), options);
	//driver.terminateApp("com.rstar.innergy");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  try {
          // Example: Clicking "Allow" button on the notifications popup
          driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
      } catch (Exception e) {
          // Handle exception if notifications popup is not present
          System.out.println("Notifications popup not found or already handled.");
      }
 } 
	//@AfterMethod
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
	 //   driver.terminateApp("com.rstar.innergy");
		driver.quit();
		//service.stop();
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000)); 	
	}
	
}
