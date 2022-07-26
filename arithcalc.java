package calculator;
import java.util.Scanner;
public class arithcalc {
	public static void main(String[] args) {
		Scanner a=new Scanner(System.in);
		System.out.println("enter the operation:");
		String oper=a.nextLine();
		System.out.println("enter the 1st number:");
		double num1=a.nextInt();
		System.out.println("enter the 2nd number:");
		double num2=a.nextInt();
		switch(oper) {
			case "+":
				int add=(int)(num1+num2);
				System.out.println("The Adition of "+num1+" and "+num2+" is "+add);
				break;
			case "-":
				int sub=(int)(num1-num2);
				System.out.println("The Subraction of "+num1+" and "+num2+" is "+sub);
				break;
			case "/":
				System.out.println("The division of "+num1+" and "+num2+" is "+(num1/num2));
				break;
			case "*":
				int mul=(int)(num1*num2);
				System.out.println("The Multiplication of "+num1+" and "+num2+" is "+mul);
				break;
			default:
				System.out.println("use the valid operation");
				break;
		}
	}
}


