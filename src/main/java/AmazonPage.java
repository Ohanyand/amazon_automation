import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class AmazonPage {
    WebDriverWait wait;

    private WebDriver _driver ;
    public AmazonPage(WebDriver driver){
        this._driver = driver;
        this._driver.get("https://www.amazon.com");
        this.wait = new WebDriverWait(this._driver, 30);
    }
    public void Search(String searchText){

        this._driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText, Keys.ENTER);
    }
    public void NextPage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class = 'a-pagination']/li[@class = 'a-last']"))).click();


    }
    public   List<Product> GetSearchedProducts(){



       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-index=21]")));//Waiting for last element
        List<WebElement> productElems = this._driver.findElements(By.cssSelector(".s-result-item.s-asin"));
        List<Product> result = new ArrayList<Product>();

        for (WebElement element:productElems) {
            String name = element.findElement(By.cssSelector(".a-section .a-size-mini a span")).getText();
            float price = 0f;
            try {
                price = Float.parseFloat(element.findElement(By.cssSelector(".a-price .a-price-whole")).getText().replace("," ,""));
            }catch (Exception e)   {}
            result.add(new Product(name,price));
        }
        return result.size() != 0 ? result :  null;
    }


}
