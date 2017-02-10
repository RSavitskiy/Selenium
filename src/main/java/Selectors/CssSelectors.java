package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


// add some  locators in this class

public class CssSelectors {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='pt-login']")).click();
        driver.navigate().back();


//        Absolute way
//        driver.findElement(By.cssSelector("html body div div form input"))

//        Relative way
//        driver.findElement((By.cssSelector("input")));

//        Search directly child
//        driver.findElement(By.cssSelector("div > a"));

//        Search all child
//        driver.findElement(By.cssSelector("div a"));

//        Search by class
//        driver.findElement(By.cssSelector("input.classname"));
//        or
//        driver.findElement(By.cssSelector(".classname"));

//        Search by html teg
//        driver.findElement(By.cssSelector("img[alt='Previous']"));

//        Search by beginning of line
//        driver.findElement(By.cssSelector("header[id^='page-']"));

//        Search by ending of line
//        driver.findElement(By.cssSelector("header[id$='page-']"));

//        Search by any symbols
//        driver.findElement(By.cssSelector("header[id*='page-']"));


//        # - shot value id
        driver.findElement(By.cssSelector("#pt-login")).click();
//        or
//        driver.findElement(By.cssSelector("input#pt-login))


        driver.findElement(By.cssSelector(" ")).click();


        driver.quit();
    }
}
