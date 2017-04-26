package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.support.PageFactory.*;

/**
 * Created by mpa on 4/12/2017.
 */
public class LoginTest {

    private final WebDriver driver;

    public LoginTest (WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "what")
    public WebElement searchField;

    @FindBy (id = "where")
    public WebElement searchLocation;

    @FindBy (id = "fj")
    public WebElement buttonFindJob;


    public LoginTest openMainPage(String urlOpenPage){
        driver.get(urlOpenPage);
        initElements(driver, this);
        return this;
    }

    public LoginTest addSearchData(String what, String where) throws InterruptedException {
        searchField.sendKeys(what);
        searchLocation.sendKeys(where);
        buttonFindJob.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public String getCheckSearchTitle() {
        return driver.getTitle();
    }

    public String getCheckSearchCount() {
        return driver.findElement(By.id("searchCount")).getText();
    }

    public LoginTest uploadYourCV() throws InterruptedException {
        //click upload link
        driver.findElement(By.linkText("Upload your CV")).click();
        return this;
    }

    public LoginTest uploadOrCreateCV(boolean boolUpload){
        if (boolUpload == true) {
            driver.findElement(By.xpath(".//label[@data-tn-element='uploadResumeBtn']")).click();
        } else {
            driver.findElement(By.xpath(".//button[@data-tn-element='createResumeBtn']")).click();
        }
        return this;

    }

    public LoginTest fillMailFields(String strMail){
        driver.findElement(By.xpath("//input[@label='Email Address']")).sendKeys(strMail);
        driver.findElement(By.xpath("//input[@label='Re-type Email Address']")).sendKeys(strMail);
        driver.findElement(By.xpath("//div[@class='splash-button']")).click();
        return this;
    }


    public String getErrorMessage(){
        //Emails do not match.
        return driver.findElement(By.xpath("//div[@class='subtitle alert-danger']")).getText();
    }


    public String getHelpErrorMessage(){
        //Please enter a valid email address.
        //WebElement node = driver.findElement(By.xpath("//div[@data-reactid='.0.1.3.0.0.1.0']"));
        return driver.findElement(By.xpath("//div[@data-reactid='.0.1.3.0.0.1.0']")).findElement(By.xpath("//span[@class='help-block']")).getText();
    }

    public void waitElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    public void fluentWaitElement(WebDriver driver, WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement((By) element);
            }
        });
    }
}
