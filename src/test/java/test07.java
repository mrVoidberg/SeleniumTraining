import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
public class test07 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test7(){

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("login")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//li[@id='app-']/a/span[@class='name']"));
        for (int i=0;i<elements.size(); i++)
        {
            driver.findElements(By.xpath("//li[@id='app-']/a/span[@class='name']")).get(i).click();
            List<WebElement> elements2 = driver.findElements(By.xpath("//li[@id='app-']/ul//a/span[@class='name']"));
            for (int j=0;j<elements2.size(); j++){
                driver.findElements(By.xpath("//li[@id='app-']/ul//a/span[@class='name']")).get(j).click();
                driver.findElement(By.xpath("//h1"));
            }

        }
                
    }


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}