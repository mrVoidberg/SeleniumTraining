import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
public class test09 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test9(){

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("login")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='row']"));
        Character lastChar = 'A';
        int i=1;
        List<Integer> N= new ArrayList<>();
        for (WebElement e: elements)
        {
            String country = e.findElement(By.xpath("./td[5]/a")).getAttribute("textContent");
            String zoneNum = e.findElement(By.xpath("./td[6]")).getAttribute("textContent");
            if (!zoneNum.equals("0")){
                N.add(i);
            }
            if (lastChar > country.charAt(0)){
                Assert.assertTrue(false);
            }
            lastChar= country.charAt(0);
            i++;
        }
        for (int n:N){
            driver.findElement(By.xpath("(//td[5]/a)["+n+"]")).click();
            lastChar = 'A';
            List<WebElement> elements2 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]"));
            for (WebElement e: elements2) {
                String zones = e.getAttribute("textContent");
                System.out.println(zones);
                if (!zones.equals("")) {
                    if (lastChar > zones.charAt(0)) {
                        Assert.assertTrue(false);
                    }
                    lastChar = zones.charAt(0);
                }

            }
            driver.findElement(By.xpath("//span[text()='Countries']")).click();
        }
        System.out.println(N);
    }

    public void checkAlpabet(List<WebElement> elements ){

    }


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}