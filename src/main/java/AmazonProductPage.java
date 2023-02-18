import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage {
    WebDriver driver;

    By cartBtn = By.xpath("//*[@id=\"add-to-cart-button\"]");
    By successfulAdd1 = By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span");

    By cart1 = By.xpath("//*[@id=\"sw-gtc\"]/span/a");

    By cart2 = By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input");
    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart (String text) throws InterruptedException{
        driver.findElement(cartBtn).click();
        if (driver.findElements(By.xpath("//*[@id=\"sw-atc-details-single-container\"]")).size() != 0) {
            Assert.assertEquals(driver.findElement(successfulAdd1).getText(), text);
            Thread.sleep(4000);
            driver.findElement(cart1).click();
        } else {
            driver.findElement(cart2).click();
        }
    }
}