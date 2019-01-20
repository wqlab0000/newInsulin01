//import java.util.*;
//import java.math.*;
//import static java.lang.System.out;
//import java.util.InputMismatchException;



//Given("^insulin pump is turned on$")

public class Clock extends Thread{
    InsulinPump insulinPump1 = new InsulinPump();
    Patient patient1 = new Patient();


    private int second; //@ in _time;
    //@ private invariant 0 <= read;
    private int read; //@ in _time;
    private /*@ spec_public @*/ double insulinDose;
    private /*@ spec_public @*/ double basal_rate=0.5;

   // private static double startTime = System.currentTimeMillis();


//When("^insulin pump glucose reading level time is setted$")
   
    

    public /*@ pure @*/ int getSecond(){
        return second=0;
        
    }



//Then("^insulin pump reads glucse every n (\\d+) seconds$")

    public void stepClock() {
        //startTime = System.currentTimeMillis();
        getSecond();

        if (second > 300){
            second -= 300;

            patient1.readGlucose();
            insulinPump1.stepInsulinPump();
        }
    }
        
        // Every 5 mins (300 seconds) check if patient glucose level is over 250 mg/dl
        // if not keep basal rate, if over change to bolus.

       
}



