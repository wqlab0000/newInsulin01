import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.util.InputMismatchException;
import java.util.InputMismatchException;
import org.junit.runner.RunWith;

RunWith(InsulinPump.class)
Cucumber.Options(
format = {"pretty", "json:target/"},
features = {"src/insulinPump/"})


@Given("^insulin pump is turned on$")
public class InsulinPump{
    private double insulinDose;
    private double basal_rate=0.5;
    private double bolus_rate;
    private String insulinpump;
    
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();

    Clock clock1 = new Clock();
    Clock clock2 = new Clock();


    

@Given ("^insulin pump delivers basal rate of insulin$")

    public int glucose;

 
    private boolean bolus;

  

@When("^patient's blood glucose level is greater than n (\\d+)$")
    
    public void stepInsulinPump(){
        patient1.readGlucose();//read glucose from patient
        if (glucose > 250) {
            changeToBolus();
        
       insulinDose = bolus_rate;
        
        
        }
        else
        {
            insulinDose = basal_rate;

        }
    

   }



@Then("^insulin pump status change to deliver bolus rate of insulin$")

    public void changeToBolus() {
        bolus = true;
        insulinDose = bolus_rate = (glucose - 144)/50;

    }
    
    public void stayBasal() {
        bolus = false;
        insulinDose = basal_rate;
        
    }

    public void setInsulinpump(String insulinpump) {
         this.insulinpump = insulinpump;
    }
    
    
    

  
    public String getInsulinpump() {
        return insulinpump;
    }
    
}
