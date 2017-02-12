package TestNG.ReportingTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WikiTest {

    private WebDriver driver;
    private String baseUrl = "https://www.wikipedia.org/";

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void wikiTitle() {
        driver.get(baseUrl);
        assertEquals("Wikipedia", driver.getTitle());
    }

    @Test
    public void wikiLogo() {
        driver.get(baseUrl);
        assertEquals(true, driver.findElement(By.xpath(".//*[contains (@src,'logo-v2.png')]")).isDisplayed());
    }

    @Test
    public void wikiSearch() {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='searchInput']")).sendKeys("selenium");
        driver.findElement(By.xpath(".//*[@id='search-form']//button")).click();
        assertEquals("Selenium — это инструмент для тестирования Web-приложений.",
                driver.findElement(By.xpath(".//*[@id='mw-content-text']/p[contains(text(),'— это инструмент для тестирования')]")).getText());
    }

    @Test
    public void wikiLinks() {

        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='js-link-box-ru']")).click();

        try {
            assertEquals(driver.getTitle(), "Википедия — свободная энциклопедия");
        } catch (Throwable t) {
            System.out.println("Russian language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-ja']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipe");
        } catch (Throwable t) {
            System.out.println("Japanese language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-es']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipedia, la enciclopedia libre");
        } catch (Throwable t) {
            System.out.println("Spanish language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-it']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipedia, l'enciclopedia libera");
        } catch (Throwable t) {
            System.out.println("Italian language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-pt']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipédia, a enciclopédia livre");
        } catch (Throwable t) {
            System.out.println("Portugal language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-en']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");
        } catch (Throwable t) {
            System.out.println("English language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-de']']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipedia – Die freie Enzyklopädie");
        } catch (Throwable t) {
            System.out.println("German language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-fr']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipédia, l'encyclopédie libre");
        } catch (Throwable t) {
            System.out.println("France language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-zh']']")).click();
        try {
            assertEquals(driver.getTitle(), "维基百科，自由的百科全书");
        } catch (Throwable t) {
            System.out.println("Korean language don't work");
        }
        driver.navigate().back();

        driver.findElement(By.xpath(".//*[@id='js-link-box-pl']")).click();
        try {
            assertEquals(driver.getTitle(), "Wikipedia, wolna encyklopedia");
        } catch (Throwable t) {
            System.out.println("Polish language don't work");
        }
        driver.navigate().back();

    }

    @Test
    public void wikiProjectImage() {
        driver.get(baseUrl);
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Commons')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikibooks')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikiversity')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikisource')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikivoyage')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikinews')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wikispecies')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Wiktionary')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'MediaWiki')]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath(".//div[contains(@class,'Meta')]")).isDisplayed());
    }

    @Test
    public void logIn() {
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='js-link-box-ru']")).click();
        driver.findElement(By.xpath(".//*[@id='pt-login']/a")).click();
        driver.findElement(By.xpath(".//*[@id='wpName1']")).sendKeys("Roman Savitsky");
        driver.findElement(By.xpath(".//*[@id='wpPassword1']")).sendKeys("PAss123456");
        driver.findElement(By.xpath(".//*[@id='wpLoginAttempt']")).click();
        assertEquals("Roman Savitsky",driver.findElement(By.xpath(".//*[text()='Roman Savitsky']")).getText());
        driver.findElement(By.xpath(".//*[@id='pt-logout']/a")).click();
    }

    @Test(dataProvider = "wikiRegister")
    public void negativeLogIn(Object obj){
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='js-link-box-ru']")).click();
        driver.findElement(By.xpath(".//*[@id='pt-login']/a")).click();
        driver.findElement(By.xpath(".//*[@id='wpName1']")).sendKeys(obj[0][0]);
        driver.findElement(By.xpath(".//*[@id='wpPassword1']")).sendKeys("PAss123456");
        driver.findElement(By.xpath(".//*[@id='wpLoginAttempt']")).click();
        assertEquals("Roman Savitsky",driver.findElement(By.xpath(".//*[text()='Roman Savitsky']")).getText());
        driver.findElement(By.xpath(".//*[@id='pt-logout']/a")).click();





    }

    @DataProvider(name="wikiRegister")
    private Object[][]testData(){
        Object[][]obj=new Object[2][2];
        obj[0][0]="";
        obj[0][1]="PAss123456";
        obj[0][2]="Roman Savitsky";
        obj[1][0]="";
        obj[1][1]="";
        obj[1][2]="";
return obj;
    }

//    PAss123456




    @AfterSuite
    public void closePage() {
        driver.close();
    }

}



