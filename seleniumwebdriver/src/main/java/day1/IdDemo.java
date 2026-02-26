package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdDemo{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open Sauce Demo
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            
            // Login with standard user
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            // Print page title after login
            System.out.println("Page Title: " + driver.getTitle());
            
            // Wait a bit to see the result
            Thread.sleep(3000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}