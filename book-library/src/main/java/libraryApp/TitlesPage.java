package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlesPage extends AbstractPage{

    @FindBy(css = ".show-copies-btn")
    static WebElement showCopiesButton;

    @FindBy(css = ".edit-btn")
    static WebElement editTitleButton;

    @FindBy(css = ".remove-btn")
    static WebElement removeTitleButton;

    @FindBy(css = "button[name='add-title-button']")
    static WebElement addTitleButton;
    private AddTitlePage addTitlePage;
    private TitlesPage titlesPage;

    public TitlesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addNewTitle(WebDriver driver) {
        PageFactory.initElements(driver, TitlesPage.class);
        WebDriverWait wait= new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addTitleButton));
        addTitleButton.click();
        AddTitlePage addTitlePage = new AddTitlePage(driver);
        addTitlePage.addingNewTitle(driver);
        }
}
