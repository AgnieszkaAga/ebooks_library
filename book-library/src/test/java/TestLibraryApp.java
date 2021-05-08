import libraryApp.LoginPage;
import libraryApp.RentsHistoryPage;
import libraryApp.TitlesPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLibraryApp {
    WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    TitlesPage titlesPage = new TitlesPage(driver);
    RentsHistoryPage rentsHistoryPage = new RentsHistoryPage(driver);


    @Before
    public void testSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://ta-ebookrental-fe.herokuapp.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testLoginPage() {
        loginPage.loginToSystem(driver);
    }

    @Test
    public void testLoginWithEmptyPassword() {
        loginPage.loginWithEmptyPassword(driver);
        WebElement alert = driver.findElement(By.className("alert__content"));
        Assert.assertTrue(alert.isDisplayed());
    }

    @Test
    public void testAddingFunction() {
        loginPage.loginToSystem(driver);
        titlesPage.addNewTitle(driver);
        titlesPage.addNewItemAndRent(driver);
    }
    @Test
    public void testAddingAndDeleting() {
        loginPage.loginToSystem(driver);
        titlesPage.addNewTitle(driver);
        titlesPage.addNewItemAndRent(driver);
        rentsHistoryPage.deleteAllRents(driver);
    }
}
