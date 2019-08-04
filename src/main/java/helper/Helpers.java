package helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Helpers extends Base {
	
	//explicit wait for visible element
	public static void elementVisible(WebElement element,long timeout) {
		WebDriverWait waitv= new WebDriverWait(driver, timeout);
		waitv.until(ExpectedConditions.visibilityOf(element));
		}
	//explicit wait for clickable element
	public static void elementClickableW(WebElement element,long timeout) {
		WebDriverWait waitc= new WebDriverWait(driver, timeout);
		waitc.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	//explicit wait for frame visibility
	public static void frameVisible(WebElement element, long timeout) {
		WebDriverWait waitf= new WebDriverWait(driver, timeout);
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	}
	
	//click by javascript
	public static void clickByJS(WebElement element) {
		JavascriptExecutor jsc=(JavascriptExecutor)driver;
		jsc.executeScript("argument[0].clicl()", element);
	}
	//java script for scroll down
	public static void scrollByJS(WebElement element) {
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//take Screenshot
	public static void takesScreenShot() throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\AUTOMATION\\Maven Project\\FreeCRM\\screenshot\\screen.jpg"));
		
		
	}

}
