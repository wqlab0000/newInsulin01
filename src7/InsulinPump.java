import java.util.Scanner;

public class InsulinPump {
    
    public static void main(String[] args){
        stepPump();
    }
    
    
    static double gluReading0;
    static double gluReading1;
    static double gluReading2;
    
    static double safeMin=60;
    static double safeMax=140;
    static double basalDose = 0.5;
    static double bolusDose=5;
    static double vialAmount=100;
    static double updatedVialAmount;

    
    static double insulinDose=0;
    

    
    public static void stepPump()
    {
        
        gluReading0 = 120;
        gluReading1 = 100;
        
        
        while(true){
            System.out.println("check glucose level? Input y for yes");
            Scanner s=new Scanner(System.in);
            String checking=s.nextLine();
            
            if(checking.equals("y"))
            {
                
                System.out.println("Enter your glucose level");
                Scanner s1=new Scanner(System.in);
                int gluReading2=s1.nextInt();
                //System.out.println(reading2);
                
                /*Glucose reading is low*/
                if (gluReading2 < safeMin)
                {
                    insulinDose = 0;
                    System.out.println(insulinDose+" Glucose is too low");
                }
                
                /*Glucose is within safe range*/
                else if (gluReading2 >= safeMin && gluReading2 <= safeMax)
                {
                    // If Glucose level is stable or falling
                    if (gluReading2 <= gluReading1)
                    {
                        insulinDose = 0.5;
                        System.out.println("Glucose is stable or falling");
                    }
                    // If Glucose level increasing
                    else
                    {
                        // If rate of increase is falling
                        if ((gluReading2 - gluReading1) < (gluReading1 - gluReading0))
                        {
                            insulinDose = 0.5;
                            System.out.print("rate of increase is falling");
                        }
                        // If rate of increase is increasing
                        else if ((gluReading2 - gluReading1) >= (gluReading1 - gluReading0))
                        { System.out.print("rate of increase is increasing");
                            // If insulinDose is rounded to zero, deliver the basal dose.
                            if ((gluReading2 - gluReading1) / 40 == 0)
                            {
                                //set the amount to deliver to the basal dose.
                                insulinDose = basalDose;
                            }
                            else if ((gluReading2 - gluReading1) / 40 > 0)
                            {
                                //Set the amount to deliver
                                insulinDose = (gluReading2 - gluReading1) / 40;
                            }
                        }
                        
                        
                    }
                }
                
                /*Glucose is High*/
                else if (gluReading2 > safeMax)
                {
                    System.out.println("Glucose is High");
                    // If Glucose level increasing
                    if (gluReading2 > gluReading1)
                    {
                        System.out.println("Glucose is High and increasing");
                        // If insulinDose is rounded to zero, deliver the basal dose.
                        if ((gluReading2 - gluReading1) / 40 == 0)
                        {
                            insulinDose = basalDose;
                        }
                        else if ((gluReading2 - gluReading1) / 40 > 0)
                        {
                            //Set the amount to deliver
                            insulinDose = (gluReading2 - gluReading1) / 40;
                        }
                    }
                    // If the Glucose level is stable
                    else if (gluReading2 == gluReading1)
                    {
                        insulinDose = basalDose;
                        System.out.println("Glucose is Stable");
                    }
                    // If the Glucose level is falling
                    else if (gluReading2 < gluReading1)
                    {
                        System.out.println("Glucose level is falling");
                        // If rate of decrease increasing
                        if ((gluReading2 - gluReading1) <= (gluReading1 - gluReading0))
                        {
                            System.out.println("rate of decrease is increasing");
                            insulinDose = basalDose;
                        }
                        // If rate of decrease decreasing
                        else
                        {
                            System.out.println("rate of decrease is decreasing");
                            insulinDose = basalDose;
                        }
                    }
                }
                
                if (insulinDose <= bolusDose)
                {
                    insulinDose = insulinDose;
                    System.out.println("Suggested Dose: "+ insulinDose+"mL");
                    //InsulinPump.deliverInsulin(insulinDose);
                }
                //If the single insulinDose computed is too high
                else
                {
                    insulinDose = bolusDose;
                    System.out.println(insulinDose);
                    System.out.println("single insulinDose is too high");
                    //InsulinPump.deliverInsulin(insulinDose);
                }
                
                if (insulinDose > 0)
                {
                    //Display to the user the insulinDose delivered
                    System.out.println("insulinDose Delivered after check: " + insulinDose+"mL");
                }
                
               
                        gluReading0=gluReading1;
                        gluReading1=gluReading2;
                        gluReading2=0;
                
                        System.out.println("after gluReading0: "+gluReading0);
                        System.out.println("after gluReading1: "+gluReading1);
                        System.out.println("after gluReading: "+gluReading2);
                
                InsulinLeft();// found at bottom, just not working yet.
                
            }
            
            else{
                System.out.println("ended. input error");
                break;
            }
        }
        
    }
   
    
    private static void InsulinLeft() // Insulin left over
    {
        updatedVialAmount=(vialAmount-insulinDose);
        vialAmount=updatedVialAmount;
        
        System.out.println("Insulin leftover: " + vialAmount + "mL");
        
        if (vialAmount <=0)
        {
            System.out.println("WARNING: New insulin vial needed");
        }
        else if (vialAmount > 0)
        {
            System.out.println( "Vial State: Good");
            
        }
        
        
        }
        
    }
    
    


