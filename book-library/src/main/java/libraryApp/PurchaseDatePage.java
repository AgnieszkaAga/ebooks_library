package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseDatePage extends AbstractPage{

    @FindBy(css="input[name=purchase-date]")
    static WebElement purchaseDateField;

    @FindBy(css="button[name=submit-button]")
    static WebElement addCopyButton;

    public PurchaseDatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addingCopy(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addCopyButton));
        addCopyButton.click();
    }
}
