package WorkWithCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://www.tripadvisor.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='rdoFlights']/img")).click();
        driver.findElement(By.xpath(".//*[@id='metaFlightTo']")).sendKeys("Грац, Австралия (GRZ-Талернхоф)");
        driver.findElement(By.xpath(".//*[@id='metaCheckInSpan']/div")).click();

        String date = "1-апрель 2017";
        String splitter[] = date.split(("-"));
        String checkInMonth_year = splitter[1];
        String checkInDay = splitter[0];

        driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[1]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='overlayInnerDiv']/div/div[1]/span[2]")).click();
        Thread.sleep(2000);
        selectDate(checkInDay, checkInMonth_year);


        driver.findElement(By.xpath(".//*[@id='checkOut']")).click();

        date = "25-апрель 2017";
        splitter = date.split(("-"));
        String checkOutMonth_year = splitter[1];
        String checkOutDay = splitter[0];

        selectDate(checkOutDay, checkOutMonth_year);

        driver.findElement(By.xpath(".//*[@id='SUBMIT_VRS']")).click();


        driver.quit();

    }

    private static void selectDate(String someDay, String mounth_year) {
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@class='caption'] "));
        for (int i = 0; i < elements.size(); i++) {
//            System.out.println(elements.get(i).getText());
//            selecting the month
            if (elements.get(i).getText().equals(mounth_year)) {
//             selecting the date
                List<WebElement> days = driver.findElements(By.xpath(".//div[@class='calendar']/div[@class='month'][" + i + 1 + "]/table/tbody/tr/td/a"));
                for (WebElement day : days) {
//                    System.out.println(day.getText());
                    if (day.getText().equals(someDay)) {
                        day.click();
                        return;
                    }
                }
            }
        }
    }
}
