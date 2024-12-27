package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    
    public WebElement managerLink;
    public WebElement newCustomerLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        managerLink = driver.findElement(By.xpath("//ul/li/a[@href=\"Managerhomepage.php\"]"));
        newCustomerLink = driver.findElement(By.xpath("//ul/li/a[@href=\"addcustomerpage.php\"]"));
    }

}
