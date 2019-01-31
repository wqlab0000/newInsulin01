import java.util.Scanner;

public class Main {
    
   
    
    public static void main(String[] args) {
        Main m=new Main();
        m.runInsulinPump();

    }
    
    public  static double insulinDose;
    public  static double basalDose=0.5;
    public  static double bolusDose=5;
    public  static double remainAmount=100;
    public  static double updatedRemainAmount;
    public  static int i;
    Patient patient = new Patient();
    InsulinPump insulinPump = new InsulinPump();

    

    
    public void runInsulinPump(){
        while(true){
        patient.setGlucoseLevel(123);

        
            System.out.println("check glucose level? Input y for yes");
            Scanner s=new Scanner(System.in);
            String checking=s.nextLine();
            
            if(checking.equals("y")){
//            System.out.println("Enter Glucose level");
//            Scanner s1=new Scanner(System.in);
//            double curGluReading=s1.nextInt();
                
            insulinPump.stepInsulinPump();
            if(insulinPump.ReservoirStatus())
            
            if (insulinPump.insulinDose > 0)
                {
                    //Display to the user the dose delivered
                    System.out.println("Dose Delivered after check: " + insulinPump.insulinDose+"mL");
                }
            
            System.out.println("Current Glucose level is: " + patient.getGlucoseLevel());

            
            updatedRemainAmount=(remainAmount-insulinPump.insulinDose);
            remainAmount=updatedRemainAmount;
            
            System.out.println("Insulin left: " + remainAmount + "mL");
            
            if (remainAmount <=0)
            {
                System.out.println("WARNING: New insulin pump reservoir needed");
            }
            else if (remainAmount > 0)
            {
                System.out.println( "Insulin Pump Reservoir State: Good");
                
                if( patient.stepPatient()){
                    
                        patient.getGlucoseLevel();
                    
                   // System.out.println("Current glucose level is:" + patient.getGlucoseLevel());
                        patient.getPatientInsulin();
                    // System.out.println("Current glucose level is:" + patient.getGlucoseLevel());
                    if(patient.patientFood()){
                        patient.setPatientFood();
                    }
                    
                }
                
                
            }
            
     
            
        }
        
        
//        if (patient.patientFood())
//        {
//            patient.setPatientFood();
//            bolusInsulin();
//        }
//
//        if (patient.patientExercise())
//        {
//            patient.setPatientExercise();
//            basalInsulin();
//        }

        
        
        
        }
    
        
    }
    
    public void basalInsulinDose(){
        insulinDose=basalDose;
    }
    public void bolusInsulinDose(){
        insulinDose=bolusDose;
    }
}
