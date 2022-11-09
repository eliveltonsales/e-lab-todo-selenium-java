package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{

    @FindBy(id="txtUsername")
    WebElement txtUsername;

    @FindBy(id="txtPassword")
    WebElement txtPassword;

    @FindBy(id="btnLogin")
    WebElement btnLogin;

    @FindBy(id="btnHelp")
    WebElement btnHelp;

    @FindBy(className = "loginfail")
    WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public TodoPage login(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return new TodoPage();
    }

    public String invalidLogin(){
        txtUsername.sendKeys("fail");
        txtPassword.sendKeys("fail");
        btnLogin.click();
        return errorMessage.getText();
    }

}
