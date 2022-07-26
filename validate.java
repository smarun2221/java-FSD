package mailvalidation;
import java.util.Scanner;
public class validate {
	public static void main(String[] args) {
		String mail[]= {"udhaya@gmail.com","hello",
				"shanthi@gmail.com","murali@gmail.com","arun@gmail.com"};
		String  s = "hello";
		boolean x= false;
		Scanner scan=new Scanner(System.in);
		System.out.print("enter the mail id:");
		String name=scan.nextLine();
		//System.out.println(name.length());
		for (int i = 0; i < mail.length; i++) {  
            if(name.equals(mail[i])) {  
                 x = true; 
                 break;  
            }  
        }  
        if(x)  
            System.out.println(" String is available at index ");  
        else  
            System.out.println(s +" String is not available in the array");  
	}
}


