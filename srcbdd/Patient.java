import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.util.InputMismatchException;


//import java.util.InputMismatchException;


//Given("^insulin pump is turned on$")
public class Patient {
    
    
//Given ("insulin pump delivers basal rate of insulin")

    private /*@ spec_public @*/int glucose;
    private /*@ spec_public @*/double basal_rate=0.5;
    private /*@ spec_public @*/double bolus_rate;
   
    InsulinPump insulinPump1 = new InsulinPump();
    InsulinPump insulinPump2 = new InsulinPump();
    InsulinPump insulinPump3 = new InsulinPump();
    InsulinPump insulinPump4 = new InsulinPump();



    Clock clock1 = new Clock();
    Clock clock2 = new Clock();

    
    
    
    

    public int readGlucose() {
        
        clock1.stepClock();
        return glucose;
       
    }

    
//When("^patient intake food and blood glucose level is greater than n (\\d+)$")
    public void foodIntake() {
        
        insulinPump1.changeToBolus();//food intake insulin dose change to bolus.
    
   
        
        
//Then("^insulin pump deliver bolus rate of insulin$")
        
       
    }
    
    
    
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
    
     public void show () {
        //System.out.println("Glucose level is :" glucose + "\n");
}
}
