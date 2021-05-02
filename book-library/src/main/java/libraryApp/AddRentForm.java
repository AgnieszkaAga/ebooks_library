package libraryApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRentForm extends AbstractPage{

    @FindBy(css="input[name=customer-name]")
    static WebElement customerNameField;

    @FindBy(css="button[name=submit-button]")
    static WebElement addRentButton;

    public AddRentForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void addingRent(WebDriver driver) {
        customerNameField.sendKeys("Agnieszka");
        addRentButton.click();
    }
}
