package steps;


import cucumber.api.Scenario;
import cucumber.api.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class ScenarioHooks {

    @Before
    public void setUp(){
        //maximize the window
        //setup environment
    }

    @After
    public void tearDown(Scenario scenario){

        try{
               if(scenario.isFailed()){
                    //this is the code to take a screenshot
                final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }

        }catch(Exception e){
            System.out.println("Exception happened while running tearDown: " + e.getMessage());
        }

        Driver.closeDriver();
    }
}
