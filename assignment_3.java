/**
* The program is a dice game where the goal is to get to 12 through max 3 throws
*
* 1. setup, variables and input variables
* 2. forever loop
* 3. loop for every 3 throws with round calculations
* 4. print results
*
* @author Olivia Fabreschi, olifab-1@student.ltu.se */

  import java.util.Scanner;
  import java.text.ParseException;
  import javax.swing.JOptionPane; 


class Main 
{
  
  public static void main(String[] args) 
  {
    //setup, variables and input variables
    Scanner input = new Scanner(System.in);
    
    System.out.println("\nWelcome to the game 12. You must roll up to 3 dice, to and try to get the sum 12. You can only roll each die once!");
     // Declare and initialize variables to be static
      int win = 0;
      int loss = 0;
      //int winFull = 0;
     // int lossFull = 0;
    { //forever loop
      for (;;)
      {
        // Declare and initialize variables for each iteration
        int throwOne = 0;
        int throwTwo = 0;
        int throwThree = 0;
        int sumOfDice = 0;
        int i = 0;
        int selectionOne= 0;
        int selectionTwo= 0;
        int selectionThree= 0;
  
// || (sumOfDice ==12)
        //loop for every 3 throws or until sum of dice is 12

        {
          while (i < 3)
            {
              System.out.print("\nEnter which dice you want to roll [1,2,3] (exit with q): ");
              String val = input.nextLine();
            //code to check for proper input
              if (val.equals("q") )
                {
                System.out.println("quitting game");
                System.exit(0);
                }
//if system.exit, no need for else if as it doesnt continue.
              
              if (!(val.equals("1")  || val.equals("2") || val.equals("3")))
                {
                System.out.println("\nError. Input should be either 1, 2, 3 or q to quit. ");
                }
              else
             {
              int selection = Integer.parseInt(val);
               //switch selection starts for proper input
                i++;
                switch(selection) 
                {
                  //randomise and sum dice for each throw
                  case 1:
                  //check whether they have rolled this die before
                  if (selectionOne == 0)
                  {
                    throwOne = (int)(Math.random()*6)+1;    
                    sumOfDice = throwOne + throwTwo + throwThree;
                    System.out.print(throwOne +" "+ throwTwo +" "+ throwThree + " ");
                    System.out.print("Sum of dice: ");
                    System.out.println(sumOfDice);
                    selectionOne += 1;
                      if (sumOfDice == 12)
                      {
                        System.out.print("Well done, you won with two dice only");
                        break;
                      }
                  }
                  
                  else
                    System.out.print("\nOnly one dice throw per round allowed.\n");
                    
                    break;
            
                  case 2:  
                  //check whether they have rolled this die before
                  if (selectionTwo == 0)
                  {
                    throwTwo = (int)(Math.random()*6)+1;    
                    sumOfDice = throwOne + throwTwo + throwThree;
                    System.out.print(throwOne +" "+ throwTwo +" "+ throwThree + " ");
                    System.out.print("Sum of dice: ");
                    System.out.println(sumOfDice);
                    selectionTwo += 1;
                  }
                  else
                    System.out.print("\nOnly one dice throw per round allowed.\n");
  
                  break;
                    
                  case 3:   
                  //check whether they have rolled this die before
                  if (selectionThree == 0)
                  {
                    throwThree = (int)(Math.random()*6)+1;    
                    sumOfDice = throwOne + throwTwo + throwThree;
                    System.out.print(throwOne +" "+ throwTwo +" "+ throwThree + " ");
                    System.out.print("Sum of dice: ");
                    System.out.println(sumOfDice);
                    selectionThree += 1;
                  }
                  else
                    System.out.print("\nOnly one dice throw per round allowed.\n");
                    
                  break;
                  //if 1-3 not selected, error message
                  default:
                  System.out.println("You must select either 1-3, or q to cancel!");
        
                }
            }
        //calculate wins based on whether they achieve 12
              if (sumOfDice == 12)
                  win += 1;
              else if (sumOfDice > 12) 
                  loss += 1;
              else 
                  {
                    loss += 0;
                    win += 0;
                  }        
            }
        }
      //output showing wins and next round before repeating
     //   if (sumOfDice < 12) 
    //       loss += 1;
        System.out.println("\ntotal wins: "+ win + " total losses: " +loss + " ");
        System.out.println("Next round!\n");
      
       
            }


    }
  
  }
}
