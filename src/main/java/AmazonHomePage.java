import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    WebDriver driver;
    By searchField = By.name("field-keywords");
    By all = By.xpath("//*[@id=\"nav-hamburger-menu\"]/i");
    By electronics = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]/a");
    By headphones = By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[9]/a");

    By settings = By.xpath("//*[@id=\"icp-nav-flyout\"]/span");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String product) {
        driver.findElement(searchField).sendKeys(product);
        driver.findElement(searchField).submit();
    }

    public void checkAll () throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(all).click();
        Thread.sleep(4000);
        driver.findElement(electronics).click();
        Thread.sleep(4000);
        driver.findElement(headphones).click();
    }

    public void changeSettings () {
        driver.findElement(settings).click();
    }
}
