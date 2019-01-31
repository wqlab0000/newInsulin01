public class Patient {
    public double insulinDose;
    private double glucoseLevel;
    public int i;


    
    
    
    public boolean patientFood(){
        return true;
    }
    
    public void setPatientFood(){
        glucoseLevel++;
    }
    
    public boolean patientExercise(){
        return true;
    }
    
    
    public void setPatientExercise(){
        glucoseLevel--;
    }
    
    public void setPatientInsulin() {
       this.insulinDose=insulinDose;
        getPatientInsulin();
        insulinDose++;
       
    }
    
    public double getPatientInsulin(){
        return insulinDose;
    }
    
    public void setGlucoseLevel(double glucoseLevel){
        
        this.glucoseLevel=glucoseLevel;
    }
    
    public double getGlucoseLevel(){
        return glucoseLevel;
    }
   
    public double readGlucoseLevel(){
        getGlucoseLevel();
        return glucoseLevel;

    }
    
    public boolean stepPatient(){
        
        getGlucoseLevel();
        getPatientInsulin();
        
        return true;
        
    }
    
    
    
}
