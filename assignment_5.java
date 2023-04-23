/**
* A program that uses methods to input various calculations
*
* 1. Variable set up and inut of numbers, checking for validity
* 2. Loops to go through reading of input until q is pressed
* 3. Calling methods and printing
* 4. Second round of loops for input
* 5. Second round of calling methods and printing
*
* @author Olivia Fabreschi, olifab-1@student.ltu.se */
  
import java.util.Scanner;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class Main 
{
  private static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) 
  {

  //Declare variables for main

    int inputRadius = 0;
    int inputHeight = 0;
    int inputNominator;
    int inputDenominator;  
    float returnBasarea;
    float returnHypotenusa;
    float returnMantelyta; 
    float returnVolym;
    int[] returnParts = new int[3];
    int[] array1 = new int[3];
    int[] array2 = new int[3];
    int gcdInput1 = 0;
    int gcdInput2 = 0;
    int gcdReturnA = 0;
 
    
    welcome();

    //loop to get the input to go to the calculation methods. It gets the results back and prints the results. if the method input() sends back a -1 the loop is broken
    do
    {
      inputRadius = input();
      if (inputRadius == -1)
      {
        break;
      }
      inputHeight = input();
      if (inputHeight == -1)
      {
        break;
      }
      
      returnBasarea = area(inputRadius);
      returnHypotenusa = pythagoras(inputRadius, inputHeight);
      returnMantelyta = area(inputRadius, inputHeight, returnHypotenusa);
      returnVolym = volume(inputRadius, inputHeight);
      System.out.printf("r = " + inputRadius + " h = " + inputHeight + "%n");
      System.out.printf("Basytans area:\t  %2.2f%n", returnBasarea); 
      System.out.printf("Mantelytans area:  %2.2f%n", returnMantelyta); 
      System.out.printf("Volum:\t\t %2.2f%n%n", returnVolym);   
    } while (true);

    System.out.printf("------------------------------------%n"
                      + "# Test of fraction methods%n"
                       + "Enter numbers to test, or q to exit%n"
                      + "------------------------------------%n"
                      + "> ");   
    
    //loop to get values for nominator and denominator and sends for calculations. if the method input() sends back a -1 the loop is broken and the program ends.

    do
    {
      inputNominator = input();
      if (inputNominator == -1)
      {
        break;
      }
      inputDenominator = input();
      if (inputDenominator == -1)
      {
        break;
      }
    
    array1 = fraction(inputNominator, inputDenominator);

    // System.out.println("\ntest array ONE"); 
    
    // for(int i = 0; i <3 ; i++)
    // {
    //   System.out.print(array1[i]+ " ");  
    // }
    
     // finding int values to go into gcd method
     for (int i = 1;i <2 ; i++)
     { 
       gcdInput1 = array1[i];
     }
    
      for (int i = 2;i <3 ; i++)
     { 
       gcdInput2 = array1[i];
     }

    gcdReturnA = gcd(gcdInput1, gcdInput2);
   // System.out.println("this is A: " + gcdReturnA);  
    //for loop for array 1, have array index 1-2 to be divided by a from the gcd
    for(int i = 1; i <3 ; i++)
    {
      if (array1[i] != 0)
     {
        array1[i] = array1[i]/gcdReturnA;
        returnParts = array1;
      }
      else
        returnParts = array1;
      
    }
  
    //    System.out.println("test array"); 
    
    // for(int i = 0; i <3 ; i++)
    // {
    //   System.out.print(array1[i]+ " ");  
    // }
  System.out.print(inputNominator + "/" + inputDenominator+" = ");
   printFraction(returnParts);     
 
    } while (true);
    

    System.out.printf("------------------------------------%n"
                      + "Ending program");
  

  
  }

 //welcome message
  static void welcome() 
  {
    System.out.println("------------------------------------");
    System.out.println("# Test of area and volume methods");
     System.out.println( "Enter numbers to test, or q to move on");

    System.out.println("------------------------------------");
    System.out.print("> ");   
  }

  //method input to validadate input and return int input
  public static int input()
  {
    int input = 0;
    int number;
  
     while (true) 
    {
     // System.out.print("Please enter the numbers for input, followed by q to move on: ");
      
      if (keyboard.hasNextInt())
      {
         number = keyboard.nextInt();
         input = Math.abs(number);
         break;
      }
      else if (keyboard.next().equalsIgnoreCase("q")) 
      {
         input = -1;
         break;
      }
      else
        {
           System.out.printf("Needs to be nr or end with \"q\". \n");
        }
    }  
  return input;
    
  }

  //calculate base area
  public static float area(int radius)
  {
  float basarea = (float)(Math.PI * Math.pow(radius, 2));
  return basarea;
  }
//calculate pythagoras 
  public static float pythagoras(int sideA, int sideB)
  {
  float hypotenusa = (float)(Math.sqrt((sideA*sideA)+(sideB*sideB)));
  return hypotenusa;
  }

  //calculate area 
  public static float area(int radius, int height, float hypotenusa)
  {
  float mantelyta = (float)(Math.PI)*radius*hypotenusa;

  return mantelyta;
  }
  
  //calculate volume
  public static float volume(int radius, int height)
  {
    //float volym = (float)((1/3)*(Math.pow(radius, 2)*Math.PI*(height)));
    float volym = (float)(Math.pow(radius, 2)*Math.PI*(height) / 3);
    return volym;        
  }


  //method for fraction
  public static int[] fraction(int nominator, int denominator)
  {
    int quotient = 0;
    int remainder = 0;
    
    if (denominator != 0)
    {  
       quotient = nominator / denominator;
       remainder = nominator % denominator;
    }
   // numbers in case not valid to divise with 0
    else
    {  
        quotient = 0;
        remainder = 0;
        denominator = 0;
    }
    int[] parts = new int[]{quotient, remainder, denominator};

     return parts;

  }
  //calculate the gcd for return
   public static int gcd(int a, int b)
  {
    int bTemp= 0;
    int c;
      while (b > a)
      {
        bTemp = b;
        b = a;
        a = bTemp;
      }
      if (a > b)
        while (b!= 0)
          {
              c = a % b;
              a = b;
              b = c;
          }
     return a;
  }

 //show the fraction
   public static void printFraction(int[] parts)
  {
//if input/nominator/denominator are 0, different messages
    
      if ((parts[0]==0) && (parts[2]!=0))
      {
      //  System.out.println("\nThe parts0 array is: ");
        if (parts[1]!=0)
            System.out.print(parts[1]+ "/"+parts[2]+"\n");
        else 
          System.out.print("error\n");
      }

      else if ((parts[1]==0) && (parts[2]!=0))
      {
      //   System.out.println("\nThe parts1 array is: ");
          System.out.print(parts[0]+"\n");
        
      }

      else if (parts[2]==0)
      {
      //  System.out.print("\nThe parts2 array is: ");
        System.out.print("error\n");
        
      }
      // else if ((parts[0]==0)&&(parts[1]==0)&&(parts[2]==0))
      // {
      //   //System.out.print("\nThe partselse if array is: ");
      //   System.out.print("error\n");
        
      // }

      else
      {
        //System.out.print("\nThe array is: ");
        System.out.print(parts[0]+" " + parts[1]+ "/"+parts[2]+"\n");
      }
  
       
  }

  

  
}
   // numberInt=Integer.parseInt(newString);
   // System.out.println("new int :" + numberInt);

    

  
    //phrase = phrase.Replace(",", "");

    //System.out.print("numberInt: ");
   // System.out.println(numberInt);


    //making array
    // int[] intArray = new int[numberStr.length()-1];

    // for (int i = 0; i< intArray.length; i++)
    // {  
    //   intArray[i] = numberInt;
    //   System.out.println(intArray[i]); 
    //   System.out.println(intArray.length); 
    // } 
    
    // System.out.println(intArray);



    
    // System.out.println(intArray);
    // // int numberInt = Integer.parseInt(numberStr);
    // //REMOVE ANY MISS LETTERS FROM THE NR STRING
    // //MAKE ALL INTEGERS POSITIVE
  
    // System.out.println("this is the nr string AFTER fixing: ");
    // System.out.println(numberStr);
   
        
        // if (val.equals("q") )
      // {
      // System.out.println("Moving to next method");
      // //move to next method
      // }
      // else
    
      // while (numbers == 0)
      // {
      // System.out.print("Input numbers to test here, q to go to next: ");
    
      // if (input.hasNext("^[a-zA-Z]"))
      // {
      // System.out.println("Not a number, try again.");
    
      // }
    
        
       // arrayStr = numberStr.split(" "); // splitting string by spaces
      // System.out.println(arrayStr.length);
        
       
        
       // arrayInt = 0;
        // output ["1","23","456"]
        //System.out.print(numberInt);
        // String qStop = input.findInLine("q");
    
    
        
        // get line that was scanned
        // split the line 2 by 2
        // switch selection starts for proper input
        // go to main to call method to calculate and print the height
    
    
//co