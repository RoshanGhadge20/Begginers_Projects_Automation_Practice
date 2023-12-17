package Swag_Labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swag_lab_Website_automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		System.out.println(driver.getTitle());
		
		//Entering Credentials
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		

		//Add to card functionality
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'1')]")).click();
		
		//Remove from card functionality
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();
		
		//Continue Shopping
		driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		
		System.out.println("End of Program Execution");
		Thread.sleep(3000);
		driver.quit();
		
	}

}
