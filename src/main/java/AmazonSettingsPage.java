import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonSettingsPage {
    WebDriver driver;
    By language = By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i");
    By currency = By.xpath("//*[@id=\"icp-currency-dropdown-selected-item-prompt\"]/span/span/span");
    By clp = By.xpath("//*[@id=\"icp-currency-dropdown_2\"]/span");

    By saveBtn = By.xpath("//*[@id=\"icp-save-button\"]/span/input");
    public AmazonSettingsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void changeLanguage() throws InterruptedException{
        driver.findElement(language).click();
        Thread.sleep(4000);
    }

    public void changeCurrency () throws InterruptedException {
        driver.findElement(currency).click();
        Thread.sleep(3000);
        driver.findElement(clp).click();
        Thread.sleep(3000);
        driver.findElement(saveBtn).click();
    }
}
