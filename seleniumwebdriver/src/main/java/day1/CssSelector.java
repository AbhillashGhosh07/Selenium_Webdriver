package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        try {
        
        // --- STARTS WITH (^=) ---
        // Find elements where attribute STARTS with a value
        driver.findElement(By.cssSelector("input[id^='user']")).sendKeys("standard_user");
        // Finds input with id starting with "user" -> matches "user-name"
        
        // --- ENDS WITH ($=) ---
        // Find elements where attribute ENDS with a value
        driver.findElement(By.cssSelector("input[id$='word']")).sendKeys("secret_sauce");
        // Finds input with id ending with "word" -> matches "password"
        
        // --- CONTAINS (*=) ---
        // Find elements where attribute CONTAINS a value (anywhere)
        driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys("secret_sauce");
        // Finds input with id containing "pass" -> matches "password"
        
        // Click login
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        
        // --- PRACTICAL EXAMPLES ON INVENTORY PAGE ---
        Thread.sleep(2000);
        
        // Find all products whose names contain "Sauce"
        List<WebElement> sauceProducts = driver.findElements(
            By.cssSelector("div[data-test='inventory-item-name'][class*='inventory_item_name']"));
        
        // Find add to cart buttons with specific text
        WebElement backpackButton = driver.findElement(
            By.cssSelector("button[data-test^='add-to-cart'][data-test$='backpack']"));
        
        // Complex example: Find buttons that are NOT disabled
        List<WebElement> enabledButtons = driver.findElements(
            By.cssSelector("button:not([disabled])"));
        
        // Find price elements that contain a decimal
        List<WebElement> prices = driver.findElements(
            By.cssSelector("div[class*='price']:contains('$')")); // Note: :contains is not standard CSS
        
        System.out.println("Enabled buttons: " + enabledButtons.size());
        }
        
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
