package libraryApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TitlesPage extends AbstractPage{

    @FindBy(css = "li[id*=\"title-\"]")
    private List<WebElement> titlesCatalog;

    @FindBy(css = ".show-copies-btn")
    static List<WebElement> showCopiesButton;

    @FindBy(css = ".edit-btn")
    static WebElement editTitleButton;

    @FindBy(css = ".remove-btn")
    static WebElement removeTitleButton;

    @FindBy(css = "button[name='add-title-button']")
    static WebElement addTitleButton;

    private AddTitlePage addTitlePage;
    private TitlesPage titlesPage;
    private ListOfCopiesPage listOfCopiesPage;

    public TitlesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addNewTitle(WebDriver driver) {
        WebDriverWait wait= new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addTitleButton));
        addTitleButton.click();
        AddTitlePage addTitlePage = new AddTitlePage(driver);
        addTitlePage.addingNewTitle(driver);
        }

    public void addNewItemAndRent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(showCopiesButton.get(0)));
        showCopiesButton.get(0).click();
        ListOfCopiesPage listOfCopiesPage = new ListOfCopiesPage(driver);
        listOfCopiesPage.addingNewItem(driver);
        RentsHistoryPage rentsHistoryPage = new RentsHistoryPage(driver);
        rentsHistoryPage.addRent(driver);
        }
}
