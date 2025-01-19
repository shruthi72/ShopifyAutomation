package Handson.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopifyAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		try
		{
		//Step 1: Open SHopify Admin Link
		driver.get("https://storehandson.myshopify.com/admin");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Step 2: Login to the account
		WebElement mailField=driver.findElement(By.id("account_email"));
		mailField.sendKeys("suruthisha72@gmail.com");
		mailField.submit();
		Thread.sleep(3000);
		
		WebElement passField=driver.findElement(By.id("account_password"));
		passField.sendKeys("Janu@25@");
		passField.submit();
		Thread.sleep(5000);
		
		//Step 3: Navigate to Pumper App
		driver.findElement(By.xpath("//span[contains(text(),'Apps')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Pumper Bundles Quantity")).click();
		
		WebElement iframeEle=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name,'app-iframe')]")));
		driver.switchTo().frame(iframeEle);
		
		//Step 4: Create Bundle Offer
		WebElement createButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Create new offer']]")));
		createButton.click();
		driver.switchTo().defaultContent();
		
		//WebElement iframeEle1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name,'app-iframe')]")));
		driver.switchTo().frame(iframeEle);
		
		WebElement createBundle=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Create a Bundle']]")));
		createBundle.click();
		driver.switchTo().defaultContent();
		System.out.println("Clicked create a bundle successfully");
		//driver.switchTo().defaultContent();
		
		
		
		driver.switchTo().frame(iframeEle);
        WebElement addProd=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Select Products']]")));
        addProd.click();
		driver.switchTo().defaultContent();
		
		WebElement iframeElement2 = driver.findElement(By.xpath("//iframe[@id='iframe-id']"));
		driver.switchTo().frame(iframeElement2);

		WebElement jeansCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Select: Jeans']//input[@type='checkbox']")));

        // Check if the checkbox is selected
        if (!jeansCheckbox.isSelected()) {
            // Click the checkbox if not already selected
            jeansCheckbox.click();
            
        } else {
            System.out.println("Checkbox was already selected.");
        }
        
        WebElement redmiCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(":r6p:")));

        // Check if the checkbox is selected
        if (!redmiCheckbox.isSelected()) {
            // Click the checkbox if not already selected
        	redmiCheckbox.click();
            
        } else {
            System.out.println("Checkbox was already selected.");
        }
        
        WebElement addClick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Add']]")));
        addClick.click();
		driver.switchTo().defaultContent();

        
		
		
				
		//Step 5:Click Publish
		driver.switchTo().frame(iframeEle);
		 WebElement publishClick=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Publish']]")));
		 publishClick.click();
			driver.switchTo().defaultContent();
			
		
	} catch (Exception e) {
        e.printStackTrace();
    } finally {
    	
        // Close the browser
        driver.quit();
    }
		
		

	}

}
