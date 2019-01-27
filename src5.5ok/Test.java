    public class Test{
    
    public static void main(String[] args) {
        Patient patient1 = new Patient();
        patient1.setGlucoseLevel(133);

        
        InsulinPump insulinPump1 = new InsulinPump();
       


        if(patient1.getGlucoseLevel()>250){
            insulinPump1.getInsulinDose();
            patient1.glucose();
            patient1.insulin();
            System.out.println(patient1.getGlucoseLevel());
            System.out.println(insulinPump1.bolusInsulin());
            
        }
        
       else if(patient1.getGlucoseLevel()<=140){
           patient1.glucose();
           patient1.insulin();
           System.out.println(patient1.getGlucoseLevel());
           System.out.println(insulinPump1.noInsulin());

        }
        else{
            patient1.glucose();
            patient1.insulin();
            System.out.println(patient1.getGlucoseLevel());
            System.out.println(insulinPump1.basalInsulin());
        }


    
}
        
        
}
