import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage {
    WebDriver driver;

    //By deleteTest = By.xpath("//*[@id=\"sc-active-Cd7922ec2-b3c1-4885-9aa8-e8b7db0e1d2c\"]/div/div[1]/span/text()");

    public AmazonCartPage (WebDriver driver) {
        this.driver = driver;
    }

    public void deleteFromCart () {
        driver.findElement(By.xpath("//input[@data-action='delete']")).click();
        System.out.print(driver.findElement(By.xpath("//span[@class='a-size-base']")).getText());
    }
}
