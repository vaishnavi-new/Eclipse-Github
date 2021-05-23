package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaApp 
{
	public static WebDriver driver;
	
	public static void highLighter(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",ele);
		
	}
public static void main(String[] args) throws InterruptedException, AWTException 
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	 driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.myntra.com/");
	
	WebElement womenText = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
	highLighter(womenText);
	System.out.println(womenText.getText());
	Actions builder=new Actions(driver);
	builder.moveToElement(womenText).build().perform();
	
	
	WebElement ethinWear = driver.findElement(By.xpath("(//a[text()='Ethnic Wear'])[1]"));
	highLighter(ethinWear);
	Actions builder1=new Actions(driver);
	builder1.moveToElement(ethinWear).click().build().perform();
	//int i=1;
	WebElement imgClick = null;
	for (int i = 1; i <=5; i++)
	{
		imgClick = driver.findElement(By.xpath("(//div[@class='product-sliderContainer'])["+i+"]"));
		 highLighter(imgClick); Actions builder3=new Actions(driver);
		 builder3.contextClick(imgClick).build().perform();
		 System.out.println(i);
		 Robot robot = new Robot(); 
		 robot.keyPress(KeyEvent.VK_DOWN);
		 robot.keyPress(KeyEvent.VK_ENTER)
		 ;
		 
		 Thread.sleep(100);
		
	}
		
		  
		 //robot.keyPress(KeyEvent.VK_DOWN);

		
	//WebElement imgClick = driver.findElement(By.xpath("(//div[@class='product-sliderContainer'])[1]"));
	
	//imgClick.click();
	
	
		 
		
		 
	
		
		  
		  //robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		  //robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		  
		 
	  System.out.println("Done");
	  
	  Set<String> windowHandles = driver.getWindowHandles();
	  List<String> arrayList = new ArrayList<String>(windowHandles);
		/*
		 * //arrayList.addAll; System.out.println(arrayList);
		 * System.out.println(arrayList.size()); String secondWindow=arrayList.get(1);
		 * 
		 */
	  System.out.println(arrayList.size());
	  driver.switchTo().window(arrayList.get(1));
	//  driver.close();
	System.out.println("Close the first window");
	System.out.println(arrayList.size());
	driver.switchTo().window(arrayList.get(0));
	driver.close();
	
}
}
