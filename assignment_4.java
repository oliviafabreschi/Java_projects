/**
* A program that handles random numbers through arrays. 
*
* 1. Variable set up and inut of number, checking for validity
* 2. Setting random numbers to the array
* 3. Sorting them according to instructions
* 4. Printing results
*
* @author Olivia Fabreschi, olifab-1@student.ltu.se */

import java.util.Scanner;
import java.text.ParseException;
import javax.swing.JOptionPane; 
import java.util.Random;



class Main 
{
  public static void main(String[] args) 
  {
     //setup, variables and input variables
    Scanner input = new Scanner(System.in);
    int numForArray = 0;
    int number = 0;
    int validNumber = -1;
    Random rd = new Random();

    //int number;
      //loop for input of array length and validity check 
      while (validNumber==-1)
       { 
        System.out.print("How many random numbers in the range 0 - 999 are desired? Input here: ");
         
         while (!input.hasNextInt()) 
            {
                System.out.print("That's not a number! ");
                System.out.print("Try again: ");
                input.next(); 
            }
          
          while (input.hasNextInt())           
            { 
                number = input.nextInt();
                if ((number > 1000) || (number <0))
                {   
                    System.out.println("Number not in range.");
                    break;
                }
                
                else
                { 
                  validNumber= number;
                  System.out.println("\nGreat, number for array is "+validNumber+"."); 
                  break;
                }
            }
        }
    
    //declare constants
    
    int ARRAY_LENGTH = validNumber; 
    // create array
    int[] arrayRandom = new int[ARRAY_LENGTH]; 
   // System.out.println("\nLet's move on, here is the array length: "+ validNumber);
  
    // calculate and store random value for each array element
    //print the numbers in the order of which they were randomized
    
    System.out.println("\nHere is the array with random nrs: ");
    
    for (int i = 0; i < ARRAY_LENGTH; i++) 
    {
      int randomNumber = (int)(Math.random() * 999 + 0);
      arrayRandom[i] = randomNumber; 
      System.out.print(arrayRandom[i] + " "); 
    } 
    
   //rearrange array to be in order of least even integers to largest even integers and then largest odd integers to least odd integers

    int[] odds = new int[arrayRandom.length];
    int[] evens = new int[arrayRandom.length];
    int oddCount = 0;
    int evenCount = 0;
    int temp = 0;
    
    for(int sortedNumber : arrayRandom)
      
      //checking if odd or even thru remainders
    {
        if(sortedNumber % 2 != 0)
        {
            odds[oddCount++] = sortedNumber;
        }
        else
        {
            evens[evenCount++] = sortedNumber;
        }
    }
 
    //sorting the odd and even arrays

   
 //sorting from smallest to largest
        for (int i = 0; i <evenCount; i++) 
        {     
          for (int j = i+1; j <evenCount; j++) 
          {     
              if(evens[i] >evens[j]) 
              {      //swap elements if not in order
                 temp = evens[i];    
                 evens[i] = evens[j];    
                 evens[j] = temp;    
              }     
          }     
        }    
//sorting from largest to smallest
      for (int i = 0; i <oddCount; i++) 
        {     
          for (int j = i+1; j <oddCount; j++) 
          {     
              if(odds[i] < odds[j]) 
              {      //swap elements if not in order
                 temp = odds[i];    
                 odds[i] = odds[j];    
                 odds[j] = temp;    
              }     
          }     
        }    

     
    //print the numbers in the order they are in the array with a punctuation mark between even and odd numbers and the number of even and odd numbers.
    
    System.out.println("\n\nHere are the random numbers arranged: ");

     for(int i = 0 ; i < evenCount ; i++)
    {
        System.out.print(evens[i] + " ");
    }
    
   System.out.print(" - ");
    for(int i = 0 ; i < oddCount ; i++)
    {

      System.out.print(odds[i] + " ");
    }
    
    int total = evenCount + oddCount;
   System.out.print("\n\nOf the above " + total + " numbers, ");
    System.out.print("even numbers: " + evenCount+ ", ");
    System.out.println("odd numbers: " + oddCount);
  
 
  }
  
}