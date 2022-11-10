package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.TodoPage;
import java.util.Random;

import static pages.Base.*;

public class TodoTest {

    LoginPage loginPage;
    TodoPage todoPage;
    Random random = new Random();

    @BeforeMethod
    public void startTest(){
        startDriver();
        loginPage = new LoginPage();
        todoPage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }

    @Test
    public void verifyTaskCreated(){
        Assert.assertTrue(todoPage.createTask(random.nextInt(9)+1) > 0);
    }

    @Test
    public void verifyTaskDeleted(){
        Assert.assertEquals(todoPage.deleteTask(todoPage.createTask(random.nextInt((9)+1))), 0);
    }

    @AfterMethod
    public void finishTest(){
       driver.quit();
    }
}