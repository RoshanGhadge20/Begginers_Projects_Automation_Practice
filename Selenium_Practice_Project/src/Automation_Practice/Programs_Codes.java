package Automation_Practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Programs_Codes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Admin/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Initializing chromeDriver
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		String Page_title = driver.getTitle();
		// System.out.println(Page_title);
		if (Page_title.equalsIgnoreCase("Automation Testing Practice")) {
			System.out.println("Page title is getting matches");
		}

		// Navigating through each field
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Roshan Ghadge");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("roshanghadge20@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8767003565");
		driver.findElement(By.id("textarea")).sendKeys("ABCDEFG");

		driver.findElement(By.xpath("//input[@id='male']")).click();

		// scrolling the webpage using selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// Working with check-boxes
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		driver.findElement(By.xpath("//input[@id='monday']")).click();

		// Working with drop-downs
		WebElement drp_down = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select se = new Select(drp_down);
		se.selectByVisibleText("India");

		driver.findElement(By.xpath("//option[contains(text(),'Yellow')]")).click();

		// Working with Calender Controls
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'15')]")).click();

		String Home = Keys.chord(Keys.CONTROL, Keys.RETURN);

		// Working with WebTables-Pagination Table
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).click();
		driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]")).click();

		driver.findElement(By.xpath("//*[@id=\"blog-pager\"]/a")).sendKeys(Home);

		// working with right hand side controls
		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("demo");
		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();

		// New Browser Window
		driver.findElement(By.xpath("//button[contains(text(),'New Browser Window')]")).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		// JS Alerts
		driver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button[3]")).click();
		driver.switchTo().alert().sendKeys("Roshan Ghadge");
		driver.switchTo().alert().accept();

		String txt = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if (txt.contains("Roshan Ghadge")) {
			System.out.println("Test Case is passed");
		}

		// Working with double click function
		Actions act = new Actions(driver);
		// System.out.println("Double click");
		WebElement double_click = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
		act.doubleClick(double_click).perform();

		String field_text = driver.findElement(By.xpath("//input[@id='field2']")).getText();
		if (field_text.contains("Hello World!")) {
			System.out.println("Double click operation is passed");
		}

		// Drag & drop of element
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropped = driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(draggable, dropped);

		// Working with Sliders
		WebElement slide = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		act.dragAndDropBy(slide, 0, 50);

//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Working with resizable of box
		WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		act.clickAndHold().moveByOffset(0, 15);

		// Working with footer part of website
		driver.findElement(By.xpath("//a[contains(text(),'mariusFM77')]")).sendKeys(Home);

		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(0));

		System.out.println("End of Program Execution");
		Thread.sleep(3000);
		driver.quit();
	}

}