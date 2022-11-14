package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import static java.time.LocalDateTime.now;

public class TodoPage extends Base {

    @FindBy(id="txtTask")
    WebElement txtTask;
    @FindBy(id="btnAdd")
    WebElement btnAdd;
    @FindBy(id="cboFilter")
    WebElement cboFilter;
    @FindBy(className="btnDone")
    WebElement btnDone;
    @FindBy(className="btnDelete")
    List<WebElement> btnDelete;

    public TodoPage(){
        PageFactory.initElements(driver,this);
    }
    
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public int createTask(int taskCount){
        for (int index = 0; index < taskCount; index++) {
            txtTask.sendKeys(now().toString());
            btnAdd.click();
        }
        return btnDelete.size();
    }

    public int deleteTask(int taskCount){
        for (int index=0;index<taskCount;index++) {
            btnDelete.get(index).click();
        }
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.numberOfElementsToBe(By.className("btnDone"),0));
        return btnDelete.size();
    }
    
    public Boolean getTaskText(){
        return txtTask.getAttribute("value").length() == 0;
    }


}
