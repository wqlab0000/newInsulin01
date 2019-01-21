import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.util.InputMismatchException;
import org.junit.runner.RunWith;

RunWith(Clock.class)
Cucumber.Options(
format = {"pretty", "json:target/"},
features = {"src/insulinPump/"})



@Given("^insulin pump is turned on$")

public class Clock extends Thread{
    InsulinPump insulinPump1 = new InsulinPump();
    Patient patient1 = new Patient();

    private int second; 
  
    private double insulinDose;
    private double basal_rate=0.5;
    private static double startTime = System.currentTimeMillis();// System current time.


@When("^insulin pump glucose reading level time is setted$")
   
    

    public int getSecond(){
        return second=0;
        
    }



@Then("^insulin pump reads glucse every n (\\d+) seconds$")

    public void stepClock() {
        startTime = System.currentTimeMillis();


        if (second > 300){
            second -= 300;

            patient1.readGlucose();
            insulinPump1.stepInsulinPump();
        }
    }
        
        // Every 5 mins (300 seconds) check if patient glucose level is over 250 mg/dl
        // if not keep basal rate, if over change to bolus.

       
}



