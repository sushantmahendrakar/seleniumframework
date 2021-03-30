package com.bs.actiondriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.bs.base.BaseClass;




public class ActionDriver extends BaseClass {
	
	public void selByIndex(WebElement ele,int index) {
		Select select11=new Select(ele);
		select11.selectByIndex(index);
	}
public void selByVisibleText(WebElement ele,String text) {
	Select select11=new Select(ele);
	select11.selectByVisibleText(text);
}
public void mouseHoverByJavaScript(WebElement ele) {
	
	
	WebElement mo = ele;
	String javaScript = "var evObj = document.createEvent('MouseEvents');"
			+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
			+ "arguments[0].dispatchEvent(evObj);";
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript(javaScript, mo);
}
public void mouseover(WebDriver driver, WebElement ele) {
	
	
	new Actions(getDriver()).moveToElement(ele).build().perform();
}
public String screenShot(WebDriver driver, String filename) {
String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

try {
FileUtils.copyFile(source, new File(destination));
} catch (Exception e) {
e.getMessage();
}

return destination;
}
public void upload() throws IOException, InterruptedException {
	
	
	String home=System.getProperty("user.dir");
	Thread.sleep(3000);


	Runtime.getRuntime().exec(home+"\\uploadexefile\\cmsfileuploadimagenew.exe");
	

	

	Thread.sleep(3000);
}
public void uploadmsg() throws IOException, InterruptedException {
	
	
	String home1=System.getProperty("user.dir");
	Thread.sleep(3000);
	Runtime.getRuntime().exec("C:\\Users\\Amaze Inc Lap 03\\git\\DigitalCplusA\\DigitalCplusA\\uploadexefile\\FileUploadmsg123.exe");
	
	Thread.sleep(3000);
}
}

