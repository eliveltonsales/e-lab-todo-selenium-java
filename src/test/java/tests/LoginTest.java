package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Base;
import pages.LoginPage;
import pages.TodoPage;

public class LoginTest extends Base {

    LoginPage loginPage;
    TodoPage todoPage;

    @BeforeMethod
    public void startTest(){
        startDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void validLoginTest(){
        todoPage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        Assert.assertTrue(todoPage.getPageUrl().contains(("todo")));
    }

    @Test
    public void invalidLoginTest(){
        Assert.assertEquals(loginPage.invalidLogin(), "Invalid Credentials!");
    }

    @AfterMethod
    public void finishTest(){
        driver.quit();
    }

}
