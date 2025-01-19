package trs;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopify {
    public static void main(String[] args) {
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Open Shopify Admin Panel
            driver.get("https://assesment2025.myshopify.com/admin");
            driver.manage().window().maximize();
            Thread.sleep(1000);

            // Step 2: Login
            WebElement emailField = driver.findElement(By.id("account_email"));
            emailField.sendKeys("shruthi72000@gmail.com");
            emailField.submit();
            Thread.sleep(3000);

            WebElement passwordField = driver.findElement(By.id("account_password"));
            passwordField.sendKeys("Janu@25@");
            passwordField.submit();
            Thread.sleep(8000);

            // Step 3: Navigate to Apps and Pumper App
           // driver.findElement(By.linkText("Apps")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Apps')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.partialLinkText("Pumper Bundles Quantity")).click();
            Thread.sleep(8000);

            WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'app-iframe')]")));
            driver.switchTo().frame(iframeElement);
         // Step 4: Create a Bundle Offer
            WebElement createOfferButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Create offer']]")));
            createOfferButton.click();
            driver.switchTo().defaultContent();
           
            WebElement iframeElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'app-iframe')]")));
            driver.switchTo().frame(iframeElement2);
            
            WebElement createBundle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Create a Bundle']]")));
            createBundle.click();
            System.out.println("Clicked button");
            driver.switchTo().defaultContent();
            
           
            
            WebElement iframeElement3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'app-iframe')]")));
            driver.switchTo().frame(iframeElement3);

            // Fill out the bundle offer details
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("offerName")));
            
            WebElement activateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Activate']]")));
            activateButton.click();
            System.out.println("Bundle Offer activated Successfully!");

            /*
            WebElement addProductButton = driver.findElement(By.id("add-product"));
            addProductButton.click();

            // Save the bundle
            WebElement saveButton = driver.findElement(By.id("save-bundle"));
            saveButton.click();

            System.out.println("Bundle Offer Created Successfully!");*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}