public class Patient {
    
    
    private double glucoseLevel=180;
    
    private double glucoseLevelChange=0.2;
    private double glucoseNew;

    private final double GLUCOSE_MODIFIER = 0.02;
    private double glucoseMaxRate=1.2;

    
    private double insulinDose=0.5;
    private double insulinNew;
    private final double INSULIN_MODIFIER = 0.03;
    private double insulinMaxRate=1.2;
   
    
    
    public Patient(){
        glucoseLevel=100;
    }
    public double foodIntakeGlucose()
    {
        return glucoseLevel;
    }
    public double exerciseGlucose()
    {
        return glucoseLevel;
    }
    
    
    public double stepPatient(){
        glucose();
        insulin();

        // Limits that the blood glucose level does not exceed the maximum and drops below the minimum

    if(glucoseLevel <= 10.0){
            glucoseLevel = 10.0;

        }else if (glucoseLevel > 400.0)
        {
        glucoseLevel = 400.0;
        }

        return glucoseLevel;
    }

    /* Increases blood glucose when maximum glucose increase rate is greater than 0.
    and when the negative value of the new glucose is lower than the maximum rate of increase in glucose.*/
    public void glucose()
    {
        if (glucoseMaxRate >=0 && -glucoseNew < glucoseMaxRate){

            // Increases blood glucose when new glucose is added
            // The difference between maximum and new glucose ranges from 0 and increases
            glucoseLevel += glucoseMaxRate - Math.abs(glucoseNew);
             // glucose Modifier serves to determine the amount of new glucose.
            glucoseNew -= GLUCOSE_MODIFIER;
        }
            // When there is no new blood glucose, then glucoseMaxSpeed and sugarNew are placed at zero
        else
        {
            glucoseMaxRate = 0;
            glucoseNew = 0;
        }
    }

    
    
    /* The value is such that it takes at least 30 minutes to get down to 1mg in a decilitre of blood
 (for testing when it stops falling and in an uncertain zone it is)  */
    public void insulin()
    {
        glucoseLevelChange -= 0.03;

        /* Reduces blood sugar when new insulin comes in
         The difference between maximum and new insulin ranges from 0 and increases*/
        if (insulinMaxRate >= 0 && -insulinDose < insulinMaxRate)
        {
            //Reduces blood glucose when a new amount of sugar comes in

            glucoseLevel -= insulinMaxRate - Math.abs(insulinDose);
            /* INSULIN_MODIFIER is used to determine the amount of new insulin.
            initially increases due to sudden insulin delivery and then decreases with the above formula */
            insulinDose -= INSULIN_MODIFIER;
        }/* When there is no insulin in the blood then insulinMaxRate ​​and insulin are placed at zero*/
        else
        {
            insulinMaxRate = 0;
            insulinDose = 0;
        }
    }

    
    public boolean setFoodIntake()
    {
        return true;
    }
    
    

    public boolean setExercise()
    {
        return true;
    }
    
    // Accepted insulin dose
    public void setInsulinDose(double insulinDose) {
        insulinMaxRate = (double) insulinDose / 2;
        insulinDose = insulinMaxRate;
    }
    
    //Blood glucose level
    
    public double getGlucoseLevel() {
        return glucoseLevel;
    }
    
    public double setGlucoseLevel(double glucoseLevel){
        this.glucoseLevel=glucoseLevel;
        getGlucoseLevel();
        return glucoseLevel;
    }
    
   
    
     
}
