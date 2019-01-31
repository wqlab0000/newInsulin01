 // AB: get rid of this - see below

/* AB:

  There are no ways to initialise the pump.
  There shoukd be constructor methods to initialise it with
  1. settings
  AND
  2. a patient object - see why below
*/
public class InsulinPump {


    /*
       AB: Why 3 here - just need two - current and previous
       Why not call them previousGLucose, currentGlucose?
    */
    public double preGluReading;// Previous glucose reading
    public double curGluReading;// Current glucose reading
    public double savGluReading;// Saving Previous glucose reading
    /*
     AB: All of these parameters are pup settings
     and there should be one or more methods to
     allow a Tester/Main program to set these.

     For now this will do as a temporary measure
    */

    public double basalDose = 0.5; // basal dose of insulin
    public double bolusDose = 3;// bolus dose of insulin
//    public static double remainAmount=100;// Insulin Pump Reservoir remaining insulin amount ml
//    public static double updatedRemainAmount;


    public double insulinDose=0;


    public boolean ReservoirStatus(){
        
        return true;
    }

    public void stepInsulinPump()
    {
        //String glucoseLevel = "";
        Patient patient = new Patient();
        curGluReading = patient.getGlucoseLevel();

        /* AB:

          No -- at each step,
                the pump first copies currentGlucose into previousGLucose
                and then "gets" the patient glucose and puts this
                value into currentGlucose.
        */
//        gluReading0 = 120;
//        gluReading1 = 100;

    /* AB:

      No loop! A pump "step" reads glucose,
      and makes some decisions,
      and then adjusts the insulin dose.
      It then terminates.

      Repeated steps are caused my a main/tester method elsewhere
      that repeatedly calls stepInsulinPump
    */
 //   while(true){
//            System.out.println("check glucose level? Input y for yes");
//            Scanner s=new Scanner(System.in);
//            String checking=s.nextLine();

//            if(checking.equals("y"))
//            {

                /* AB:
                  this method should not be getting user inpiut

                  In fact, this is why you need a patient object
                  even just a dummy one that
                    1. provides a getGlucose method for the pump to call
                    2. It can use Scanner to get that from user, but...

                    In order to automate tests, with or without BDD,
                    you need to have ways for code to setup glucose values.

                    So, provide a patient object that
                    has two static attributes - glucose and insulin
                    with get and set methods for both.

                    the pump will get glucose from patient and set insulin does
                    for patient

                    The user/test-suit/BDD-stuff ("top-level") will get insulin and glucose
                    from patient and set new values as part of testing

                    So, the "top-level" (e.g. Main.java) will
                     1. initialise both patient and pump
                     2. Then do a number of iterations of the following:
                        2a stepInsulinPump
                        2b read effect of pump step by getting
                           both values from patient
                        2c output approriate details
                        2d update patient settings  (a "patient step")
                             patient updates can be either
                             2d(i) drop in glucose and insulin - normal work
                             2d(ii)  drop in insulin, lost doing work
                                     with jump in glucose due to food intake


                */
//                System.out.println("Enter your glucose level");
//                Scanner s1=new Scanner(System.in);
//                int gluReading2=s1.nextInt();
                //System.out.println( gluReading2);
        

                if (patient.getGlucoseLevel() < 250)
                {

                    insulinDose = basalDose;
                    
                    System.out.println("Insulin dose delivered: "+ insulinDose+"mL");

                }

                /*Glucose is High*/
                else if (patient.readGlucoseLevel() > 250)
                {
                    insulinDose = (patient.getGlucoseLevel() - 140)/50;
                    //insulinDose = bolusDose;
                    System.out.println("Glucose is High");

                    
                   System.out.println("Insulin dose delivered: "+ insulinDose+"mL");

                    //insulinDose = bolusDose;

                }
        
        
                     savGluReading = preGluReading;
                     preGluReading = curGluReading;
                     curGluReading = 0;
        
//                        System.out.println(" Glucose Reading is: "+patient.getGlucoseLevel());
        
        
        
                       // System.out.println("Previous Glucose Reading is: "+preGluReading);

                ReservoirStatus();

            }


        }
//
//}

    /* AB:

      What is the status? - it needs a clear definition
     This should return status data to the caller,
     and print stuff out.
    */


//        System.out.println("Insulin left: " + remainAmount + "mL");
//
//        if (remainAmount <=0)
//        {
//            System.out.println("WARNING: New insulin pump reservoir needed");
//        }
//        else if (remainAmount > 0)
//        {
//            System.out.println( "Insulin Pump Reservoir State: Good");
//
//        }
//




