package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

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

    //@Test
    public void TC_02_enterName()throws InterruptedException{
        
        System.out.println("Start Test case: TC_02_enterName");
        WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
        String userName = "Crio Learner";
        wrapperMethod_SendKeys(driver, weName, userName);
        System.out.println("End Test case: TC_02_enterName");



    }

    /*
     * Pseudo code:
     * Get the epoch time
     * Concatenate the input string with the epoch time
     * Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
     * Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
     */
    //@Test
    public void TC_03_whyAutomation() throws InterruptedException{
        try{

        System.out.println("Start Test case: TC_03_whyAutomation");
        //Get the epoch time
        long epochTime = System.currentTimeMillis()/1000;
        //Concatenate the input string with the epoch time
        String whyAutomationAnswer = "I want to be the best QA Engineer! "+epochTime;
        //Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
        WebElement weWhyAutomation = driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
        //Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
        wrapperMethod_SendKeys(driver, weWhyAutomation, whyAutomationAnswer);
        System.out.println("End Test case: TC_03_whyAutomation");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void TC_04_howMuchAutomationExp() throws InterruptedException{

        System.out.println("Start Test case: TC_04_howMuchAutomationExp");
        List<WebElement> weyearsOfAutomationExpOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String inputAutomationExp = "6 - 10";
        wrapperMethod_ChooseAutomationExp(driver, weyearsOfAutomationExpOptions, inputAutomationExp);

        System.out.println("End Test case: TC_04_howMuchAutomationExp");



    }

    //Wrapper method to send keys to the input field
    public void wrapperMethod_SendKeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{

        webelement.sendKeys(inputString);
            Thread.sleep(5000);

    }

    //Wrapper method to choose the number of years of automation experience
    public void wrapperMethod_ChooseAutomationExp(ChromeDriver driver, List<WebElement> weyearsOfAutomationExpOptions, String inputAutomationExp) throws InterruptedException{

        // for(WebElement we : weyearsOfAutomationExpOptions){

        //     System.out.println(we);
        // }
        
        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //For each option 
        for(WebElement eachYearOfAutomationExp : weyearsOfAutomationExpOptions){
            //If the experience is same as that of the input experience
            if(eachYearOfAutomationExp.getText().equals(inputAutomationExp)){
                System.out.println("The exp selected is : "+eachYearOfAutomationExp.getText());
                //Get the associated radio button of the desired exp option
                WebElement weSelectYearsOfExpOption = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//div[@class='Od2TWd hYsg7c' and @data-value='"+inputAutomationExp+"']"));
                js.executeScript("arguments[0].scrollIntoView(true);",weSelectYearsOfExpOption);
                //Click the radio button
                weSelectYearsOfExpOption.click();
                //Wait till the selection is completed
                Thread.sleep(2000);
                

            }

        }

    }

}




