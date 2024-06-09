package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.text.DateFormatter;

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

    /*
     * Pseudo code
     * Get all the available experience options into a list of webelements 'weyearsOfAutomationExpOptions' using the Locator xpath : //div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']
     * Store one experience value to a string 'inputAutomationExp' 
     * Call the wrapper method 'wrapperMethod_ChooseAutomationExp' and pass 'weyearsOfAutomationExpOptions' and 'inputAutomationExp' along with driver object
     * 
     */
    public void TC_04_howMuchAutomationExp() throws InterruptedException{

        System.out.println("Start Test case: TC_04_howMuchAutomationExp");
        List<WebElement> weyearsOfAutomationExpOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String inputAutomationExp = "6 - 10";
        wrapperMethod_ChooseAutomationExp(driver, weyearsOfAutomationExpOptions, inputAutomationExp);

        System.out.println("End Test case: TC_04_howMuchAutomationExp");

    }

    /*
     * Pseudo Code
     * Get all the available Skill options into a list of webelements 'weskillsLearntOptions' using the Locator xpath : //div[@class='eBFwI']
     * Store group of skills learnt in a string array 'inputSkillsLearntStrArray'
     * Call the wrapper method 'wrapperMethod_SelectSkillsLearnt' and pass 'weskillsLearntOptions' and 'inputSkillsLearntStrArray' along with driver object
     */

    public void TC_05_skillsLearntAtCrio() throws InterruptedException{

        System.out.println("Start Test case: TC_05_skillsLearntAtCrio");
        List<WebElement> weskillsLearntOptions = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        String[] inputSkillsLearntStrArray = {"Java","Selenium","TestNG"};

        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //scroll into the view to find the desired web element.
        js.executeScript("arguments[0].scrollIntoView(true);",weskillsLearntOptions.get(0));

        wrapperMethod_SelectSkillsLearnt(driver, weskillsLearntOptions, inputSkillsLearntStrArray);

        System.out.println("End Test case: TC_05_skillsLearntAtCrio");

    }

    

    /*
     * Pseudo code
     * Get all the avaialble titles from the dropdown list and store them in List of webelements 'weTitlesToBeAddressed' using the locator xpath: //div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']
     * Store the desired title in 'desiredTitleStr'
     * Call the 'wrapperMethod_SelectDesiredTitle' method by passing the 'weTitlesToBeAddressed', 'desiredTitleStr' along with driver
     */
    public void TC_06_titleToBeAddressed() throws InterruptedException{

        System.out.println("Start Test case: TC_06_titleToBeAddressed");
        List<WebElement> weTitlesToBeAddressed = driver.findElements(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']"));
        String desiredTitleStr = "Mrs";
        wrapperMethod_SelectDesiredTitle(driver, weTitlesToBeAddressed, desiredTitleStr);
        Thread.sleep(2000);
        System.out.println("End Test case: TC_06_titleToBeAddressed");

    }

    /*
     * Pseudo code
     * Call a wrapper method to send the seven days before current date in 'dd/MM/yyyy' format
     */
    public void TC_07_dateSevenDaysAgo() throws InterruptedException{

        System.out.println("Start Test case: TC_07_dateSevenDaysAgo");
        Thread.sleep(10000);
        wrapperMethod_getCurrentDateMinusSeven(driver);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_07_dateSevenDaysAgo");


    }



    //Wrapper method to send keys to the input field
    public void wrapperMethod_SendKeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{

        webelement.sendKeys(inputString);
            Thread.sleep(5000);

    }

    //Wrapper method to choose the number of years of automation experience
    public void wrapperMethod_ChooseAutomationExp(ChromeDriver driver, List<WebElement> weyearsOfAutomationExpOptions, String inputAutomationExp) throws InterruptedException{
        
        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //For each option 
        for(WebElement eachYearOfAutomationExp : weyearsOfAutomationExpOptions){
            //If the experience is same as that of the input experience
            if(eachYearOfAutomationExp.getText().equals(inputAutomationExp)){
                //System.out.println("The exp selected is : "+eachYearOfAutomationExp.getText());
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

    //Wrapper method to select the various skills learnt at crio
    public void wrapperMethod_SelectSkillsLearnt(ChromeDriver driver, List<WebElement> weskillsLearntOptions, String[] inputSkillsLearntStrArray) throws InterruptedException{
    
        //For each skill available(outer for each loop), iterate all the learnt skills passed as input(inner for each loop)
        for(WebElement weEachSkillLearnt : weskillsLearntOptions){
            for(String eachInputSkillLearnt : inputSkillsLearntStrArray){
            //If the available skill is same as that of the input skill learnt
                if(weEachSkillLearnt.getText().equals(eachInputSkillLearnt)){
                    //System.out.println("The skill learnt is : "+weEachSkillLearnt.getText());
                    //Get the associated checkbox of the input skill learnt
                    WebElement weSelectSkillLearnt = driver.findElement(By.xpath("//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd' and @aria-label='"+eachInputSkillLearnt+"']"));
                    //Select the select box
                    weSelectSkillLearnt.click();
                    //Wait till the selection is completed
                    Thread.sleep(2000);
                    
                }
            }

        }

    }

    
    //Wrapper method to select the desired input title
    public void wrapperMethod_SelectDesiredTitle(ChromeDriver driver, List<WebElement> weTitlesToBeAddressed, String desiredTitleStr) throws InterruptedException{
        //Search and Click on the Titles drop down
        WebElement weClickChoose = driver.findElement(By.xpath("(//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R'])[1]"));
        weClickChoose.click();
        
        //For each listed title
        for(WebElement weEachTitle : weTitlesToBeAddressed){
            
            //If the available title is same as that of the desired input title
            if(weEachTitle.getAttribute("data-value").equals(desiredTitleStr)){
                //wait for the element to be clickable . without wait got exception: Element not interactable
                WebElement weTitleToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option' and @data-value='"+desiredTitleStr+"']")));
                //Select the select box
                weTitleToClick.click();
                break;
                
            }
            

        }

    }

    //Wrapper method to send the seven days before current date as input in 'dd/MM/yyyy' format
    public void wrapperMethod_getCurrentDateMinusSeven(ChromeDriver driver){

        //Get the local date using LocalDate.now() method and store it in a LocalDate variable
        LocalDate date = LocalDate.now();

        //Use the DateTimeFormatter.ofPattern("dd/MM/yyyy") method to the desired date format and store it in DateTimeFormatter variable
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Use LocalDate.minusDays() method to subtract the desired days from the current date to get the new date
        LocalDate newdate = date.minusDays(7);

        //Locate the webElement using Locator xpath : (//input[@class='whsOnd zHQkBf'])[2]
        WebElement weCalendar = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));

        // //Scroll down to find the desired element using JavascriptExecutor
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", weCalendar);
        
        //Convert the new date into desired date format using newdate.format(dateFormatter) 
        //and again convert to String using toString() method
        weCalendar.sendKeys(newdate.format(dateFormatter).toString());

    }









}











