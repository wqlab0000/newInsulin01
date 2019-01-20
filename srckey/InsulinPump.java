//import java.util.*;
//import java.math.*;
//import static java.lang.System.out;
//import java.util.InputMismatchException;
//import java.util.InputMismatchException;
//import org.junit.runner.RunWith;

//RunWith(InsulinPump.class)
//Cucumber.Options(
//format = {"pretty", "json:target/"},
//features = {"src/insulinPump/"})


//Given("^insulin pump is turned on$")
public class InsulinPump{
    private /*@ spec_public @*/ double insulinDose;
    private /*@ spec_public @*/ double basal_rate=0.5;
    private /*@ spec_public @*/ double bolus_rate;
    private /*@ spec_public @*/ String insulinpump;
    
    Patient patient1 = new Patient();
    Patient patient2 = new Patient();

    Clock clock1 = new Clock();
    Clock clock2 = new Clock();


    
    /*@ public invariant glucose >= 70;
      @
      @*/

//Given ("^insulin pump delivers basal rate of insulin$")

    public /*@ spec_public @*/ int glucose;

    /*@ public invariant glucose <= 250 ==> !bolus &&
      @                  glucose > 250 ==> bolus;
      @*/
    private /*@ spec_public @*/ boolean bolus;

    /*@ requires glucose >= 0;
      @ ensures glucose == \old(glucose) + glucose;
      @ assignable glucose, bolus;
      @*/
    
    

//When("^patient's blood glucose level is greater than n (\\d+)$")
    
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



    /*@ requires glucose > 250;
      @ ensures bolus;
      @ assignable bolus;
      @
      @
      @*/
    

//Then("^insulin pump status change to deliver bolus rate of insulin$")

    public void changeToBolus() {
        bolus = true;
        insulinDose = bolus_rate = (glucose - 144)/50;

    }
    
    public void stayBasal() {
        bolus = false;
        insulinDose = basal_rate;
        
    }

    /*@ ensures this.insulinpump == insulinpump;
      @ assignable this.insulinpump;
      @*/
    public void setInsulinpump(String insulinpump) {
         this.insulinpump = insulinpump;
    }
    
    
    

    /*@ ensures \result == insulinpump;
      @*/
    public /*@ pure @*/ String getInsulinpump() {
        return insulinpump;
    }
    
}
