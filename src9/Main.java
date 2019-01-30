import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        InsulinPump insulinPump = new InsulinPump();

        System.out.println("------------------------------------");
        
       
        System.out.println("Insulin Pump ON");
        
        System.out.println("check glucose level? Input y for yes");
        Scanner s=new Scanner(System.in);
        String checking=s.nextLine();
        if(checking.equals("y"))
        {
        insulinPump.stepInsulinPump();
        
        insulinPump.getInsulinPumpStatus();
        }
      
        
        
        System.out.println("Insulin Pump OFF");

        System.out.println("------------------------------------");
                
                
        
    }
}
