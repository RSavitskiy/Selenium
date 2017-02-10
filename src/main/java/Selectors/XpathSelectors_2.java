package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class XpathSelectors_2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://w3schools.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


//        Absolute path
//        driver.findElement(By.xpath("html/body/div/div/form/input"));

//        Relative path
//        driver.findElement(By.xpath("//input"));

//        Child element
//        driver.findElement(By.xpath("//div/a"));

//        All element
//        driver.findElement(By.xpath("//div//a"));

//        Search element by text
//        driver.findElement(By.xpath(".//*[text()='Первая ссылка']/.."));

//        Search by values attribute
//        driver.findElement(By.xpath("//input[@id='username']"));

//        Search by name attribute
//        driver.findElement(By.xpath("img[@alt]"));

    }
}
