package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
