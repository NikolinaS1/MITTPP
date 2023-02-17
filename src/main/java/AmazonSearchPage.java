import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchPage {
    WebDriver driver;
    By sorting = By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]");
    By newestArrivals = By.xpath("//*[@id=\"s-result-sort-select_4\"]");
    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortProducts() {
        driver.findElement(sorting).click();
        driver.findElement(newestArrivals).click();
    }
    public void chooseProduct() {
        List<WebElement> li = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        li.get(0).click();
    }
}
