public class Patient {
    private double glucoseLevel=140;
    
    private double insulinDose=0.5;
    

    
    public double readGlucoseLevel() {
        return glucoseLevel;
    }
    
    public double readPatientInsulin() {
        return insulinDose;
    }
    
    public static boolean foodIntake()
    {
        return true;
    }

    public static boolean exercise()
    {
        return true;
    }
   
    public void setFoodIntake(double glucoseLevel)
    {
        glucoseLevel=250;
        glucoseLevel++;
    }
    
    public void setExercise(double glucoseLevel)
    {
        glucoseLevel--;
    }
   
    
    public void setInsulinDose(double insulinDose) {
        insulinDose ++;
    }
    
    
    public void stepPatient(){
        readPatientInsulin();
        readGlucoseLevel();
    }
    
    public double setGlucoseLevel(double glucoseLevel){
        this.glucoseLevel=glucoseLevel;
        readGlucoseLevel();
        return glucoseLevel;
    }
    
    
    
    
   
}
