import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage {
    WebDriver driver;

    public AmazonCartPage (WebDriver driver) {
        this.driver = driver;
    }

    public void deleteFromCart () {
        driver.findElement(By.xpath("//input[@data-action='delete']")).click();
        System.out.print(driver.findElement(By.xpath("//span[@class='a-size-base']")).getText());
    }
}
