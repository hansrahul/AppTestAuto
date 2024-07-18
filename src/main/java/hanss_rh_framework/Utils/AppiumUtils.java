package hanss_rh_framework.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper; 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {
	public AppiumDriverLocalService service;
/*AppiumDriver driver;//AppiumDriver is parent of AndroidDriver and IOS Driver so it will work for both platforms
	public AppiumUtils(AppiumDriver driver)//constructor
	{
	this.driver =driver;
	}*/
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Aanisha_Sethi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress(ipAddress).usingPort(port).build();
				service.start();
				return service;
	}

	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));		
		return price;
	}
	public List<HashMap<String, String>> getJasonData(String jsonFilePath) throws IOException {
		//System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json"),StandardCharsets.UTF_8
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			;
		});
		return data;
	}
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
	wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
}
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//Reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extent report pick file and attach to report
		
		
		
	}
	
}
