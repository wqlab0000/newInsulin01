import java.util.*;
import java.math.*;
import java.util.Scanner;
import static java.lang.System.out;
import java.util.InputMismatchException;

public class Test{
    
    public static void main(String[] args) {
        
        Patient patient1 = new Patient();
        InsulinPump insulinPump1 = new InsulinPump();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Glucose level：");
        int glucose = sc.nextInt();
        System.out.println("Insulin dose：");
        float dose = sc.nextFloat();
       
        System.out.println("Information is shown below：");
        System.out.println("Glucose level is："+glucose+"\n"+"Insulin dose："+dose);
      System.out.println("Glucose level should be over 70");
        
        
       
    }
}
