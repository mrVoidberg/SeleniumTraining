import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
public class test08 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test8(){

        driver.get("http://localhost/litecart/en/");
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@title,'Duck') and @class='link']"));
        for (WebElement e: elements)
        {
            List<WebElement> sticer=e.findElements(By.xpath(".//div[contains(@class,'sticker')]"));
            if (sticer.size()==1){
                System.out.println(sticer.size());
                Assert.assertTrue(true);
            }
            if (sticer.size()>1){
                Assert.assertTrue(false);
            }

        }

    }


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}