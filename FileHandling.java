package iostreams;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	public static void main(String args[]) {
		char[] array = new char[60];
		Scanner sc= new Scanner(System.in);  
		System.out.println("\t\tFile Handling\n1.Reading the file\n2.Writing the file\n3.Appending the file");  
		  System.out.print(" Enter Your choice: ");  
		  int a= sc.nextInt(); 
		  switch (a)
		  {
		  case 1:
		  {
			  try {
			      
			      FileReader input = new FileReader("E:/File.txt");
			      input.read(array);
			      System.out.println("The file is READ and it contains:");
			      System.out.println(array);
			      input.close();
			    }
			    catch(Exception e) {
			      e.getStackTrace();
			    }
			  break;
		  }
		  case 2:
		  {
			  System.out.print("Enter a string to write: ");
			  Scanner sc1= new Scanner(System.in);  
			  String data= sc1.nextLine();       
			  //String data = "(Written) Good morning all";
			    
			    try {
			      FileWriter output = new FileWriter("E:/File.txt");
			      output.write(data);
			      System.out.println("Data is written to the file.");
			      output.close();
			    }
			    catch (Exception e) {
			      e.getStackTrace();
			    }
			    break;
		  }
		  case 3:
		  {
			  System.out.print("Enter a string to Append: ");
			  Scanner sc2= new Scanner(System.in);  
			  String data= sc2.nextLine();     
			  try {
			         
			         File f1 = new File("E:/File.txt");
			         if(!f1.exists()) {
			            f1.createNewFile();
			         }

			         FileWriter fileWritter = new FileWriter(f1,true);
			         BufferedWriter bw = new BufferedWriter(fileWritter);
			         bw.write(data);
			         bw.close();
			         System.out.println("Done");
			      } catch(IOException e){
			         e.printStackTrace();
			      }
		  }
		  }
	}
}

