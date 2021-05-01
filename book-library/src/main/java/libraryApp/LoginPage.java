package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(css ="#login")
    static WebElement loginField;

    @FindBy(css ="#password")
    static WebElement passwordField;

    @FindBy(css ="#login-btn")
    static WebElement loginButton;

    @FindBy(css = ".alert__content")
    static WebElement alertMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public TitlesPage loginToSystem(WebDriver driver) {
        PageFactory.initElements(driver, LoginPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys("agnieszka");
        passwordField.sendKeys("agapass");
        loginButton.click();
        TitlesPage titlesPage = new TitlesPage(driver);
        return titlesPage;
    }

    public void loginWithEmptyPassword(WebDriver driver) {
        PageFactory.initElements(driver, LoginPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys("agnieszka");
        loginButton.click();
    }
}
