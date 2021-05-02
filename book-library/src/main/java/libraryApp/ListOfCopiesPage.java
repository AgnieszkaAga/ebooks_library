package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ListOfCopiesPage extends AbstractPage{

    @FindBy(css ="li[id*=\"item-\"]")
    private List<WebElement> itemList;

    @FindBy(css = ".show-rents-btn")
    static List<WebElement> showHistoryButton;

    @FindBy(css = ".edit-btn")
    static List<WebElement> editItemButton;

    @FindBy(css = ".remove-btn")
    static List<WebElement> removeItemButton;

    @FindBy(css = "#add-item-button")
    static WebElement addNewItemButton;

    public ListOfCopiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addingNewItem(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewItemButton));
        addNewItemButton.click();
        PurchaseDatePage purchaseDatePage = new PurchaseDatePage(driver);
        purchaseDatePage.addingCopy(driver);
    }

    public void showRentHistory(WebDriver driver) {
        showHistoryButton.get(0).click();
    }
}
