public class InsulinPump{
    
    private double insulinDose;
    private double basal_rate=0.5;
    private double bolus_rate=3.0;
    private double no_rate=0;
    private double glucoseLevel;
   

    Patient patient1 = new Patient();
   
    public double bolusInsulin(){

        insulinDose = bolus_rate;
        return insulinDose;
    }
    
    public double basalInsulin(){
        patient1.glucose();
        insulinDose = basal_rate;
        return insulinDose;
    }
    
    public double noInsulin(){
        patient1.glucose();
        insulinDose = no_rate;
        return insulinDose;
    }

    public InsulinPump(){
        this.patient1 = patient1;
        }
    
    public void stepInsulinPump(double insulinDose){
        patient1.setInsulinDose(insulinDose);// Insulinpump give insulin dose to patient.
       
      }

    
    public double getInsulinDose(){
        return insulinDose;
    }
    
    public double setInsulinDose(double insulinDose) {
        this.insulinDose = insulinDose;
        return insulinDose;
    }

    
    
}

