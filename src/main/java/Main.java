import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String CHROMEDRIVER_PATH = "/home/davit/IdeaProjects/simple_automation1/src/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",CHROMEDRIVER_PATH  );
        WebDriver driver = new ChromeDriver();
        AmazonPage page = new AmazonPage(driver);
        page.Search("Laptop");
        int count = 1;
        for (int i=1; i<=3; i++) {
            List<Product> products = page.GetSearchedProducts();
            System.out.println("\n"+products.size()+" elements was taken from page " + i+"\n");
            for (Product elem : products) {
                if (elem.GetPrice()<500 && elem.GetPrice()>0)
                    System.out.println((count++)+". "+elem.GetName() + " ===== " + elem.GetPrice()+"$");

            }
            page.NextPage();
        }
    }
}
