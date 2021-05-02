package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RentsHistoryPage extends AbstractPage {

    @FindBy(css=".edit-btn")
    static WebElement editRentButton;

    @FindBy(css=".remove-btn")
    static List<WebElement> removeRentButton;

    @FindBy(css="#add-rent-button")
    static WebElement addRentButton;

    public RentsHistoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addRent(WebDriver driver) {
        ListOfCopiesPage listOfCopiesPage = new ListOfCopiesPage(driver);
        listOfCopiesPage.showRentHistory(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(addRentButton));
        addRentButton.click();
        AddRentForm addRentForm = new AddRentForm(driver);
        addRentForm.addingRent(driver);
    }
}
