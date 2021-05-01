package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTitlePage extends AbstractPage {

    @FindBy(css = "input[name=title]")
    static WebElement newTitleField;

    @FindBy(css = "input[name=author]")
    static WebElement newAuthorField;

    @FindBy(css = "input[name=year]")
    static WebElement newYearField;

    @FindBy(css = "button[name=submit-button]")
    static WebElement addTitleButton;

    private static TitlesPage titlesPage;
    private static LoginPage loginPage;
    private static AddTitlePage addTitlePage;


    public AddTitlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addingNewTitle(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(newTitleField));
        newTitleField.sendKeys("The English Patient");
        newAuthorField.sendKeys("Michael Ondaatje");
        newYearField.sendKeys("2002");
        addTitleButton.click();
    }
}