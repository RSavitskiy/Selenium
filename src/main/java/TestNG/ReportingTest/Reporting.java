package TestNG.ReportingTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.fail;

public class Reporting {
//    http://www.javapetra.com/

//    @Test
//    public void login() {
//        System.out.println("login");
//    }
//
//    @Test
//    public void logout(){
//        Assert.assertEquals("TEST","test");
//
//    }
//

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.wikipedia.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testWikiTitle() throws Exception {
        driver.get(baseUrl + "");
        assertEquals("Wikipedia", driver.getTitle());
    }

    @Test
    public void testWikiLogo() throws Exception {
        driver.get(baseUrl + "");
        assertEquals("", driver.findElement(By.cssSelector("div.central-featured-logo")).getText());
    }


    @Test
    public void testWikiSearch() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
        driver.findElement(By.id("searchButton")).click();
        assertEquals("Selenium is a chemical element with symbol Se and atomic number 34. " +
                "It is a nonmetal with properties that are intermediate between those of its" +
                " periodic table column-adjacent chalcogen elements sulfur and tellurium." +
                " It rarely occurs in its elemental state in nature, or as pure ore compounds. " +
                "Selenium (Greek σελήνη selene meaning \"Moon\") was discovered in 1817 by Jöns " +
                "Jacob Berzelius, who noted the similarity of the new element to the" +
                " previously known tellurium (named for the Earth).", driver.findElement(By.cssSelector("p")).getText());
    }


    @Test
    public void testWikiLink() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        assertEquals("Wikipedia", driver.findElement(By.linkText("Wikipedia")).getText());
        driver.findElement(By.linkText("Wikipedia")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.partialLinkText("Internet encyclopedia"))) break;

            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

    }


    @Test
    public void testWikiNoElement() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (!driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Google[\\s\\S]*$")) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

    }


    @Test
    public void testWikiNoResults() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys("@@@@@@@");
        driver.findElement(By.id("searchButton")).click();
        assertEquals("There were no results matching the query.", driver.findElement(By.cssSelector("p.mw-search-nonefound")).getText());
    }

    @Test
    public void testWikiLanguages() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*in English[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Русский")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*на русском языке[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("日本語")).click();
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*ウィキペディア[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Italiano")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Benvenuti[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Português")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*em português[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Español")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*en español\\.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Deutsch")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]* Artikel in deutscher [\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Français")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*articles en français[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("中文")).click();

        try {
            assertEquals("维基百科，自由的百科全书", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("Polski")).click();

        try {
            assertEquals("Wikipedia, wolna encyklopedia", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @Test
    public void testWikiProjectImage() throws Exception {
        driver.get(baseUrl + "/");
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wiktionary']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikidata']")));
        assertTrue(isElementPresent((By.cssSelector("img[src*='Wikivoyage']"))));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikinews']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikispecies']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Commons']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikiquote']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikisource']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='MediaWiki']")));
        assertTrue(isElementPresent(By.cssSelector("img[src*='Wikibooks']")));
        assertTrue(isElementPresent((By.cssSelector("img[src*='Wikiversity']"))));
        assertTrue(isElementPresent((By.cssSelector("img[src*='Meta-logo']"))));
    }

    @Test
    public void testWikiSearshPoland() throws Exception {
        driver.get(baseUrl + "/");
        new Select(driver.findElement(By.id("searchLanguage"))).selectByVisibleText("Polski");
        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys("Warszawa");
        driver.findElement(By.name("go")).click();
        assertEquals(true, driver.getPageSource().contains("miasto stołeczne Warszaw"));

    }

    @Test
    public void testWikiNotLogIn() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("wpLoginAttempt")).click();
        try {
            assertEquals("Log in", driver.findElement(By.id("firstHeading")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("wpName1")).click();
        driver.findElement(By.id("wpName1")).clear();
        driver.findElement(By.id("wpName1")).sendKeys("testuser");
        driver.findElement(By.id("wpLoginAttempt")).click();

        try {
            assertEquals("Login error", driver.findElement(By.cssSelector("strong")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("wpPassword1")).clear();
        driver.findElement(By.id("wpPassword1")).sendKeys("testpass");
        driver.findElement(By.cssSelector("#wpLoginAttempt")).click();

        try {
            assertEquals("Login error", driver.findElement(By.cssSelector("strong")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testWikiLogIn() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.partialLinkText("English")).click();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("wpName1")).clear();
        driver.findElement(By.id("wpName1")).sendKeys("Testwikilogin123");
        driver.findElement(By.id("wpPassword1")).clear();
        driver.findElement(By.id("wpPassword1")).sendKeys("user123");
        driver.findElement(By.id("wpLoginAttempt")).click();
        assertTrue(isElementPresent(By.cssSelector("a[href*='Testwikilogin123']")));
        driver.findElement(By.linkText("Log out")).click();
        driver.close();
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
