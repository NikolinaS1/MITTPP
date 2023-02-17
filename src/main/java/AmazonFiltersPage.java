import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonFiltersPage {
    WebDriver driver;

    By featuredBrands = By.xpath("//*[@id=\"p_89/Apple\"]/span/a/div/label/i");
    By price = By.xpath("//*[@id=\"p_36/1253506011\"]/span/a/span");
    By material = By.xpath("//*[@id=\"p_n_feature_fifteen_browse-bin/23681332011\"]/span/a/div/label/i");

    public AmazonFiltersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void tryFilters () throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(featuredBrands).click();
        Thread.sleep(3000);
        driver.findElement(price).click();
        Thread.sleep(3000);
        driver.findElement(material).click();
        Thread.sleep(3000);
    }

    public void chooseProduct() {
        List<WebElement> li = driver.findElements(By.xpath("//img[@class='s-image']"));
        li.get(0).click();
        System.out.print(driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText());
    }
}
