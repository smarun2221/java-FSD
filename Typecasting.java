package phase1_assisted_practice;

public class Typecasting {
	public static void main(String[] args) {
		System.out.println("Implicit Type Casting");
		char K='K';
		System.out.println("Value of K: "+K);
		
		int b=K;
		System.out.println("Value of b: "+b);
		
		float c=K;
		System.out.println("Value of c: "+c);
		
		long d=K;
		System.out.println("Value of d: "+d);
		
		double e=K;
		System.out.println("Value of e: "+e);
				
		System.out.println("Explicit Type Casting");
		
		double x=45.5;
		int y=(int)x;
		System.out.println("Value of x: "+x);
		System.out.println("Value of y: "+y);
	}
}
