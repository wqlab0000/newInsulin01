import java.util.Scanner;

public class InsulinPump {

    
    
    public static double gluReading0;// Glucose reading is set to 0 for next reading
    public static double gluReading1;// Previous glucose reading
    public static double gluReading2;// Current glucose reading

    public static double safeMin=77; //Safe minimum glucose level for this diabete patient
    public static double safeMax=250;//Safe maximum glucose level for this diabete patient
    public static double basalDose = 0.5; // basal dose of insulin
    public static double bolusDose;// bolus dose of insulin
    public static double maxSingleDose=10;//Maximum single insulin dose
    public static double remainAmount=100;// Insulin Pump Reservoir remaining insulin amount ml
    public static double updatedRemainAmount;


    public static double insulinDose=0;
    
    public static double dose=0;
    
    
    
    
   
    public static void stepInsulinPump()
    {

        gluReading0 = 120;
        gluReading1 = 100;


    while(true){
//            System.out.println("check glucose level? Input y for yes");
//            Scanner s=new Scanner(System.in);
//            String checking=s.nextLine();

//            if(checking.equals("y"))
//            {

                System.out.println("Enter your glucose level");
                Scanner s1=new Scanner(System.in);
                int gluReading2=s1.nextInt();
                //System.out.println( gluReading2);

                /*Glucose reading is low*/
                if (gluReading2 < safeMin)
                {
                    insulinDose = 0;
                    System.out.println(dose+" Glucose is too low");
                }

                /*Glucose is within safe range*/
                else if (gluReading2 >= safeMin && gluReading2 <= safeMax)
                {
                    
                    insulinDose = basalDose;

                }

                /*Glucose is High*/
                else if (gluReading2 > safeMax)
                {
                    insulinDose = (gluReading2 - gluReading1) / 50;
                    System.out.println("Glucose is High");
                    //insulinDose = bolusDose;

                }

                if (insulinDose <= maxSingleDose)
                {
                    dose = insulinDose;
                    System.out.println("Suggested Dose: "+ dose+"mL");
                    //InsulinP.InsulinPump.deliverInsulin(dose);
                }
                //If the single dose computed is too high
                else
                {
                     dose = maxSingleDose;
                     System.out.println(dose);
                     System.out.println("Suggested Dose: "+ dose+"mL");
                     System.out.println("single dose is too high");

                }
//
                if (dose > 0)
                {
                    //Display to the user the dose delivered
                    System.out.println("Dose Delivered after check: " + dose+"mL");
                }


                        gluReading0=gluReading1;
                        gluReading1=gluReading2;
                        gluReading2=0;

                        System.out.println("Previous Glucose Reading is: "+gluReading0);
                        System.out.println("Current Glucose Reading is: "+gluReading1);
                     //   System.out.println("Glucose Reading set to 0 for next reading: "+gluReading2);

                getInsulinPumpStatus();

            }

        
        }
//
//}


    public static void getInsulinPumpStatus() // Insulin left over
    {
        updatedRemainAmount=(remainAmount-dose);
        remainAmount=updatedRemainAmount;
        
        System.out.println("Insulin left: " + remainAmount + "mL");
        
        if (remainAmount <=0)
        {
            System.out.println("WARNING: New insulin pump reservoir needed");
        }
        else if (remainAmount > 0)
        {
            System.out.println( "Insulin Pump Reservoir State: Good");
            
        }
        
        
        }
        
    }
    
    


