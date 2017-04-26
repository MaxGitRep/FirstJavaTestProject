package TestNG;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

/**
 * Created by mpa on 4/18/2017.
 */
public class UploadCV {

    private String BROWSER_NAME = "firefox";
    private String MAIN_URL_ADDRESS = "http://indeed.co.uk";
    private String URL_CREATE_CV = MAIN_URL_ADDRESS + "/resume";
    private String BAD_MAIL_ADDRESS = "mailgmail.com";
    private String MAIL_ADDRESS = "mail@gmail.com";

    @Test
    public void UploadCVAndCheckErrors() throws Exception {
        System.out.println("Start");
        //Prepare test
        PrepareTest prepare_test = new PrepareTest();
        WebDriver startBrowser = prepare_test.startBrowser(BROWSER_NAME);
        //Open
        LoginTest checkUploadCVFunctionality = new LoginTest(startBrowser).openMainPage(MAIN_URL_ADDRESS)
                .uploadYourCV()
                .uploadOrCreateCV(false) //click Create CV
                .fillMailFields(MAIL_ADDRESS);
        //Check
        //assertEquals(checkUploadCVFunctionality.getErrorMessage(), "Emails do not match.");
        assertEquals(checkUploadCVFunctionality.getHelpErrorMessage(), "Please enter a valid email address.", "Checking not valid Error:");
        //quit
        prepare_test.quitBrowser();
        System.out.println("Finish");

    }

    @AfterMethod
    public void getResults (ITestResult result){
        if (ITestResult.FAILURE==result.getStatus()){
            //send result or/and get screenshot
            System.out.println("Test FAILED! "+result.getName());
        }

    }


}
