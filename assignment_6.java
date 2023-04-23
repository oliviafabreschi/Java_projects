/**
* A program that works as a simple cash register system. In the program it is possible to add / remove articles, sell articles and present sales history.
*
* 1. Variable set up and inut of numbers, checking for validity
* 2. Loops to go through reading of input
* 3. Calling methods according to input number  
* 4. Each method does different task
* 5. Continues to loop until nr 7 for exit is pressed
*
* @author Olivia Fabreschi, olifab-1@student.ltu.se */



import java.util.Scanner;
import java.util.Date;
import java.util.Arrays;
 
public class Main 
{
    private static Scanner keyboard = new Scanner(System.in);
   
  public static void main(String[] args) 
    {
      //declare and initiate variables
      int inputChoice = 0;
      int inputInput = 0;
      int intSize = 10;
      int[][]articles = new int[intSize][3];
      int[][]sales = new int[1000][3];
      Date[]salesDate = new Date[1000];
      int noOfArticles = 0;
      int serialNumberInput = 0;
      int articleNo = 1000;
      int articleInput = 0;
      int nrOfItemsSold = 0;
      
      
      
      
      welcome();

      //loop to ensure able to select options
      do
      {
      inputChoice = menu();

      //decision based on choice input number
          if (inputChoice ==1)
          {
            
           
            //add articles
            System.out.println("Number of items to insert");
            //input acquired
            noOfArticles = input();
            
           // System.out.println("Nr of articles inserted: " + noOfArticles);
            articles = checkFull(articles, noOfArticles);
            
            articles = insertArticles(articles, articleNo, noOfArticles);
            
            
           // System.out.println("MAIN noOfarticles : " + noOfArticles);
           // System.out.println("MAIN articles length/method result: " + articles.length);
            articleNo = articleNo + noOfArticles;
            if (articles.length>1)
                sortArrayArticles(articles);
            
          }
  
          if (inputChoice ==2)
          {//remove articles
            
                removeArticle(articles);   
             
          }
         if (inputChoice ==3)
          {//show articles
            System.out.println("Showing articles in array");
            if (articles.length>1)
                sortArrayArticles(articles);
            printArticles(articles);
          }
         if (inputChoice ==4)
          {//sell
             System.out.println("Selling the articles as we speak.");
             sellArticle(sales, salesDate, articles);
          }
         if (inputChoice ==5)
          {//order history
            System.out.println("this is the order history:");
            printSales(sales, salesDate);
          }
         if (inputChoice ==6)
          {//sort order history table
            System.out.println("Sorting the sales.");
            sortedTable(sales, salesDate);
          }
         if (inputChoice ==7)
          {//end
           System.out.println("Exiting program");
          System.exit(0);
          } 
      } while (true);
        

      //for input choice, redirect to correct method
     // input(choice);
 
    }

      //Presents the menu
  static void welcome()
  {
  System.out.printf("1. Add items %n"
                      + "2. Remove items  %n"
                      + "3. Show items  %n"
                      + "4. Sell item %n"
                      + "5. Order history %n"
                      + "6. Sort order history table %n"
                      + "7. End  %n");   
    
  }

//presents menu, takes in selection of menu choice
   public static int menu()
  {
    int choice = 0;
    int value;
    
    while (true) 
    {
      System.out.print("\n> Your choice: ");
      if (keyboard.hasNextInt())
      { 
        value = keyboard.nextInt();
        //check that value is int and between 1-7
        if (value <8 && value > 0)
        {
            choice = value;
            break;
        }
        else 
        {
         System.out.printf("Number to be between 1-7 \n");
          break;
        }
      }
      else if (keyboard.next().equalsIgnoreCase("q")) 
      {
         System.out.printf("Needs to be a number between 1-7 \n");
         break;
      }
          
      else 
      {
        System.out.printf("Needs to be a number between 1-7 \n");
        //value = -1;
        break;
      }
      
    }  
    return choice;
  }
//read in the input from the user for the article content
   public static int input()
  {
    System.out.print("Input: ");
    int input = 0;
     while (true)
    {
       if (keyboard.hasNextInt())
       { 
          input = keyboard.nextInt();
          break;
       }
       else
       {   
          System.out.println("Must be an integer");
          break;
       } 
     } 
   return input;
  }
  //insert articles into array
   public static int[][] insertArticles (int[][]articles, int articleNumber, int noOfArticles)
  {
    //Adds the specified number of items in the matrix after first checking that the number of vacancies is sufficient. Each item is added to the first vacant position. 

    int noOfUnits = 0;
    int price = 0;
    int minUnits = 1;
    int maxUnits = 10;
    int minPrice= 100;  
    int maxPrice = 1000;  
    int vacancies = 0;
    

     for (int j = 0; j < articles.length; j++)   
          {
            if (articles[j][0] == 0)
              {
                vacancies++;
              }
            
          }
    // System.out.println(" articles length IA METHOD " + articles.length);
     //System.out.println(" nr of vacancies IA METHOD " + vacancies);
          
         for (int i = 0; i < (articles.length); i++)                    
           {
            if (articles[i][0] == 0)
            {
                  noOfUnits = (int)(Math.random()*(maxUnits-minUnits+1)+minUnits); 
                  price = (int)(Math.random()*(maxPrice-minPrice+1)+minPrice); 
                  articles [i][0] = articleNumber++;
                  articles [i][1] = noOfUnits;
                  articles [i][2] = price;
                  System.out.print(articles[i][0] + ", ");
                  System.out.print(articles[i][1] + ", ");
                  System.out.print(articles[i][2] + ", \n");
             }
           }


    return articles;
  }

  

  
    public static int[][] checkFull (int[][] articles, int noOfArticles)   
   {
       //check if array will fit number of articles or if it needs to be expanded

     //integer with length of FULL array AS IT IS
      int articlesLength = articles.length;
      int vacancies = 0;

     for (int j = 0; j < articles.length; j++)   
          {
            if (articles[j][0] == 0)
              {
                vacancies++;
              }
          }
         
   // System.out.println(" number of vacancies before" + vacancies);
   // System.out.println(" articles length BEFORE " + articlesLength);
    int filledLength = (articlesLength-vacancies);
      //expand array articles, if INPUT OF ARTICLES is longer than the nr of vacancies
      if (noOfArticles > vacancies)
      {
        int[][]articlesArray = new int[noOfArticles+filledLength][3];
         
          for(int i = 0; i < (articlesLength) ; i++)
            for (int j = 0; j < 3; j++)  
                if (articles[i][0] != 0)
                {
                  articlesArray[i][j] = articles[i][j];
                }
        articles = articlesArray;
       // System.out.println(" number of vacancies AFTER " + vacancies);
      }//beginning for when vacancies is 10
      else if ((vacancies==10 ) && (articlesLength == 10))
      {
        
        int[][]articlesArray = new int[noOfArticles+filledLength][3];
         
          for(int i = 0; i < (articlesLength) ; i++)
            for (int j = 0; j < 3; j++)  
              if (articles[i][j] != 0)
              {
                articlesArray[i][j] = articles[i][j];
              }
        articles = articlesArray;
       // System.out.println(" number of vacancies AFTER second one " + vacancies);
       
      }
     
      else //noOfArticles less than vacancies
      {
       // filledLength = (articlesLength-(vacancies-noOfArticles));
        
        int[][]articlesArray = new int[noOfArticles+filledLength][3];
          for(int i = vacancies; i < (articles.length) ; i++)
            for (int j = 0; j < 3; j++)  
           //  if (articles[i][0] != 0)
              {
                articlesArray[i][j] = articles[i][j];

                //printing for visual demonstration
                System.out.print(articlesArray[i][0] + ", ");
                System.out.print(articlesArray[i][1] + ", ");
                System.out.print(articlesArray[i][2] + ", \n");
              }

         
        articles = articlesArray;
        //System.out.println("filledlength AFTER third one " + filledLength);
        //System.out.println(" number of vacancies AFTER " + vacancies);
        
        
       }
     // System.out.println(" articles length AFTER " + articles.length);
     // System.out.println(" number of vacancies AFTER " + vacancies);
    return articles;   
   }

  
    //displays articles
  public static void printArticles (int[][] articles)
  {
    //doesnt display if nothing there to display

    // if (articles == null)
    //     {
    //        System.out.print("Nothing to show yet");
    //     } 
    
    // for(int i = 0; i < articles.length ; i++)
    //   {
    //     if (articles[i][0] == 0)
    //     {
    //        System.out.print("Nothing to show yet");
    //     } 2
    //     else
    //      break;  
    //   }

    
      for (int i = 0; i < articles.length; i++)   
      { 
        System.out.print(articles[i][0] + ", ");
        System.out.print(articles[i][1] + ", ");
        System.out.println(articles[i][2] + " ");
      }
    }  
  
     
    //removes article
  public static void removeArticle (int[][]articles)
  {//if nothing to remove, show message
    int serialNumberInputOrig = 0;
    int serialNumberInput = 0;
    System.out.println("Enter serial nr of item to be removed: ");
    serialNumberInputOrig = input();
    

 //  if ((serialNumberInput < 1000) || (serialNumberInput >(2000)))
 //    {
 //       System.out.println("Must be serial number. Back to main menu");
 // }
 //   else
 //               //input acquired

    // to find if article nr exists 
     for (int k = 0; k < (articles.length); k++)
       {
         if (articles [k][0] == serialNumberInputOrig)
           {
              serialNumberInput =  serialNumberInputOrig;
           }
       }

           
   int articlesLength = articles.length;
   int vacancies = 0;

     for (int j = 0; j < articles.length; j++)   
          {
            if (articles[j][0] == 0)
              {
                vacancies++;
              }
          }
         
    int filledLength = (articlesLength-vacancies);
    int checker = 0;
     outerloop:    
     for (int i = 0; i < articlesLength; i++)   
        for (int j = 0; j < articles[0].length; j++)   
        {  
          if (filledLength == 0)
           {
             checker = 1;
             break outerloop;
             
           }
            
           else
             while (articles [i][0] == serialNumberInput)
              {
                 articles [i][0] = 0;
                 articles [i][1] = 0;
                 articles [i][2] = 0; 
                 checker = -1;
                 break outerloop;

              }
         
        }


    if (serialNumberInput ==  0)
       System.out.println("NOTHING to remove yet");
    else if (checker >0)
      System.out.println("Nothing to remove yet");
    else
       System.out.print("Item removed");
  

  }




  
public static void sortArrayArticles(int[][]articles)
  {
    int temp[];

    boolean swap=true;
    while(swap)

     
       for (int i = 0; i < (articles.length); i++)   
         for (int j = 1; j < (articles.length); j++)  
          for (int k = 0; k < (3); k++)
            {
              swap=false;
              if(articles[j-1][0] > articles[j][0] ) 
                 {      //swap elements if not in order
                     temp = articles[j-1];    
                     articles[j-1] = articles[j];    
                     articles[j] = temp;   
                     swap=true;
                  }   

              
            }
              


  } 
    
   //array to store sales (integer) [item number, number, sum]
  //and an array (Date) that stores time / date for each sale.
 public static void sellArticle(int[][]sales, Date[] salesDate, int[][]articles)
   {
     int summedPrice = 0;
     int placeHolder = 0;
     int articleNum = 0;

      //input acquired
     System.out.println("Article number to be sold: ");
     int articleNo = input();
     System.out.println("Number of items to be sold: ");
     int quantityNo = input();

     // If there are enough goods in stock, the number of goods is reduced and a sale is registered in the intended matrix (article number, number, sum).
      
    // placeHolder = index of wherever the articlenumber is
     for (int i = 0; i < (articles.length); i++)
       {
         if (articles [i][0] == articleNo)
           {
              articleNum =  articleNo;
              placeHolder =  i;
              //System.out.println("placeholder is " + placeHolder);
           }
        
       }

    // for (int i = 0; i < (articles.length); i++)
    // {
    //     if (articles [placeHolder][1] > quantityNo)
    //          {
    //            quantityNum = quantityNo;
    //            break;
    //          }
    //       else
    //        {
    //            System.out.println("Not enough in stock to sell.");
    //            break;
    //        }
    // }

 if (quantityNo != 0)
    if (articleNum !=  articleNo)
     System.out.println("No article number exists with this nr.");   
     else
     {
       if (articles [placeHolder][1] >= quantityNo)
          {
              articles[placeHolder][1] -= quantityNo;
              summedPrice = articles[placeHolder][2] * quantityNo;
             
               for (int i = 0; i<(sales.length); i++)
                 {
                   if (sales [i][0] ==0)
                     {
                      sales[i][0]=articleNo;
                      sales[i][1]=quantityNo;
                      sales[i][2]=summedPrice;
                      salesDate[i]= new Date();
                      break;
                     }
                  }
              System.out.println("Item sold.");   
            
            }
           else
           System.out.println("Not enough in stock.");   
     }
    
     
      
    
   }

  


 public static void printSales(int[][]sales, Date[] salesDate)
   {
   

    for (int i = 0; i < sales.length; i++)   
       if (sales [i][0] !=0)
      { 
        System.out.print(sales[i][0] + ", ");
        System.out.print(sales[i][1] + ", ");
        System.out.print(sales[i][2] + ", ");
        System.out.println(salesDate[i]+ ", ");
      }

     
   }  

   
   public static void sortedTable(int[][]sales, Date[] salesDate)

  {
    int temp = 0;
    Date temp2 = null;

    boolean swap=true;
    while(swap)
       for (int i = 0; i < (salesDate.length); i++)   
        for (int j = 1; j < (sales.length); j++)  
          for (int k = 0; k < (3); k++)
            {
              swap=false;
              if(sales[j-1][k] > sales[j][k] ) 
                 {    //swap elements if not in order
                     temp = sales[j-1][k];    
                     sales[j-1][k] = sales[j][k];    
                     sales[j][k] = temp;  

                     temp2 = salesDate[j-1];    
                     salesDate[j-1]= salesDate[j];    
                     salesDate[j]= temp2;  

                     swap=true;
                  }   

              
            }
      
         
              


    
  }





}

  
