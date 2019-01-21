import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.util.InputMismatchException;
import org.junit.runner.RunWith;

RunWith(Patient.class)
Cucumber.Options(
format = {"pretty", "json:target/"},
features = {"src/insulinPump/"})

@Given("^insulin pump is turned on$")
public class Patient {
    
    
@Given ("insulin pump delivers basal rate of insulin")

    private int glucose;
    private double basal_rate=0.5;
    private double bolus_rate;
   
    InsulinPump insulinPump1 = new InsulinPump();
    InsulinPump insulinPump2 = new InsulinPump();
    InsulinPump insulinPump3 = new InsulinPump();
    InsulinPump insulinPump4 = new InsulinPump();

 

    public int readGlucose() {
        
        clock1.stepClock();
        return glucose;
       
    }

    
@When("^patient intake food and blood glucose level is greater than n (\\d+)$")
    public void foodIntake() {
        
        insulinPump1.changeToBolus();//food intake insulin dose change to bolus.    
       
    }
    
    
 @Then("^insulin pump deliver bolus rate of insulin$")   
    
    
    public void exercise(){
        insulinPump2.stepInsulinPump();
    }
    
    
    public void stepPatient(int glucose){
        if (glucose > 250) {
        
        insulinPump3.stepInsulinPump();

        
        
        }
        
        if(glucose <= 250){
            
        insulinPump4.stayBasal();
        }
        
    }
    
     
}
}
