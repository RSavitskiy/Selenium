package WorkWithCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownMenu {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.rediff.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='signin_info']/a[2]")).click();
        WebElement day = driver.findElement(By.xpath(".//*[contains(@name,'DOB_Day')]"));

        List<WebElement> listDay = day.findElements(By.tagName("option"));
        System.out.println(listDay.size());


        for (int i = 0; i < listDay.size(); i++) {
            String element = listDay.get(i).getAttribute("value");
            if (element.equals("15")) {
                listDay.get(i).click();
            }
        }
        WebElement month = driver.findElement(By.xpath(".//*[contains(@name,'DOB_Month')]"));
        List<WebElement> listMonth = month.findElements(By.tagName("option"));
        System.out.println(listMonth.size());

        for (int i = 0; i < listMonth.size(); i++) {
            String element = listMonth.get(i).getAttribute("value");
            if (element.equals("08")) {
                listMonth.get(i).click();
            }
        }

        WebElement year = driver.findElement(By.xpath(".//*[contains(@name,'DOB_Year')]"));
        List<WebElement> listYear = year.findElements(By.tagName("option"));
        System.out.println(listDay.size());

        for (int i = 0; i < listYear.size(); i++) {
            String element = listYear.get(i).getAttribute("value");
            if (element.equals("1995")) {
                listYear.get(i).click();
            }
        }

        driver.close();
    }

}
