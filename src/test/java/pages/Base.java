package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties properties;

    public Base() {
        try {
            properties = new Properties();
            FileInputStream prop = new FileInputStream("src/test/java/util/.properties");
            properties.load(prop);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void startDriver(){
        try {
            properties = new Properties();
            FileInputStream prop = new FileInputStream("src/test/java/util/.properties");
            properties.load(prop);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver","src/test/java/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }
}