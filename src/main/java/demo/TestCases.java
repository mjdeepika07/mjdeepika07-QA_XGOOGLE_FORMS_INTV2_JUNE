package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.Test;
// import org.testng.Assert;


public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        //WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    //@Test
    public void TC_01_navigateToGoogleFormUrl() throws InterruptedException{

        System.out.println("Start Test case: TC_01_navigateToGoogleFormUrl");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(5000);
        System.out.println("End Test case: TC_01_navigateToGoogleFormUrl");
    }

    // //@Test
    // public void TC_02_enterName()throws InterruptedException{
        
    //     System.out.println("Start Test case: TC_02_enterName");
    //     WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
    //     String userName = "Deepika MJ";
    //     wrapperMethod_SendKeys(driver, weName, userName);
    //     System.out.println("End Test case: TC_02_enterName");



    // }

    //@Test
    // public void TC_03_whyAutomation() throws InterruptedException{

    //     System.out.println("Start Test case: TC_03_whyAutomation");
    //     long epochTime = System.currentTimeMillis()/1000;
    //     WebElement weWhyAutomation = driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
    //     String whyAutomationAnswer = "I want to be the best QA Engineer! "+epochTime;
    //     wrapperMethod_SendKeys(driver, weWhyAutomation, whyAutomationAnswer);
    //     System.out.println("End Test case: TC_03_whyAutomation");

    // }

    // public void TC_04_howMuchAutomationExp(){

    //     System.out.println("Start Test case: TC_04_howMuchAutomationExp");
    //     List<WebElement> weyearsOfAutomationExpOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']"));
    //     String inputAutomationExp = "0 - 2";
    //     wrapperMethod_ChooseAutomationExp(driver, weyearsOfAutomationExpOptions, inputAutomationExp);

    //     System.out.println("End Test case: TC_04_howMuchAutomationExp");



    // }




    // public void wrapperMethod_SendKeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{

    //     webelement.sendKeys(inputString);
    //         Thread.sleep(5000);

    // }

}
