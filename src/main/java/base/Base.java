package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	public WebDriver initializationDriver() throws IOException {
		//Properties prop= new Properties();
		prop= new Properties();
		FileInputStream fis=new FileInputStream("D:\\AUTOMATION\\Maven Project\\FreeCRM\\src\\main\\java\\config\\Config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\Maven Project\\FreeCRM\\src\\main\\java\\drivers\\\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\Maven Project\\FreeCRM\\src\\main\\java\\drivers\\geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION\\Maven Project\\FreeCRM\\src\\main\\java\\drivers\\IEDriverServer.exe");
			//WebDriver driver = new InternetExplorerDriver();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
