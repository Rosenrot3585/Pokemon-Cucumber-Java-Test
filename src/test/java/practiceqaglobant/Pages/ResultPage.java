package practiceqaglobant.Pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "mw-page-title-main")
    private WebElement resultPageTitle;

    public boolean isTitleCorrect(String title){
        waitForElementToBeVisible(resultPageTitle);
        return resultPageTitle.isDisplayed() &&
                resultPageTitle.getText().equalsIgnoreCase(title);
    }

}
