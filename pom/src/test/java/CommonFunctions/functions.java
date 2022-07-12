package CommonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class functions {
	public static WebDriver driver;
	public static Properties prop;
	Logger log= Logger.getLogger(functions.class);
	public Properties loadPropertyFile() throws IOException  {
		// to read the property file

		FileInputStream fis = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fis);
		return prop;
	}
	@BeforeSuite	
	public void launchBrowser() throws IOException {
		log.info("Test starts");
		log.info("Loading the property files");
		PropertyConfigurator.configure("log4j.properties");
		loadPropertyFile();
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			log.info("launching Chrome Browser");
			driver=new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			log.info("Launching the Firfox browser");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		log.info("Navigating to the Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
        

	}
	@AfterSuite
	public void tearDown() {
		log.info("Execution finished.Closing the browser");
driver.quit();

	}
}
