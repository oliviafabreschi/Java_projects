/*
* Name: Olivia Fabreschi
* LTU username: olifab-1
* Replit link: https://replit.com/@D0017D-H22/Exam-2023-01-12-oliviaFa#Main.java
*/

/* What you can use? You can use String class, Math Class, Date Class.
   What you cannot use? No Arraylists, No Vectors and related such classes that have inbuilt ability to sort and rearrange items.
*/
import java.util.Scanner;
class Main
{
  private static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) 
  {

    //declare variables for main
    //arrays
    String[][] courses = new String[10][2];

    String[][] evaluation = new String[10][5]; 
    
    double[][] averages = new double[10][4]; 
    
    //variables
    int numOfCourses = 0; 
    int noOfEvaluations = 0;
    int selection = 0;
    int iterations = 0;
    int iterationsEv = 0;
  
    String courseCode = "";
    String courseCode1 = "";
    String courseName = "";
    String inputExamination = "";
    String inputContents = "";
    String inputTeacher = "";
    String courseCodetoCHECK = "";

    boolean OK = false;

    //main menu
    menu();
    //get number from menu selection
    //user input that then directs to other methods
     while(true)
        {
          selection = input();
          if (selection == 1 ) // Register new course
            {

              //get course code
              System.out.printf("Enter course code:");
              
              courseCode = inputCourseCheck();
              //ADD CHECK TO SEE IF IT EXISTS ALREADY
              
              //if (iterations >0)
             // {
                courseCode = codeCheckTwo(courses, courseCode, iterations);
             // }


              if (!courseCode.equals(""))
              {
              
                    //get course name
                    System.out.printf("Enter course name:%n");
                    courseName = inputStr();
    
                    //add both to array for string
                    addCourses(courses, courseCode, courseName, iterations);
                    //print line saying course was added
                    System.out.printf("Course %s: %s was added!%n", courseCode, courseName);
                    iterations += 1;
              }
               
             }
          if (selection == 2 )// Register evaluation score
            { 
              //get code and check if it exists compared to array
              System.out.printf("Enter course code:%n");
              courseCode = checkCourseCode(courses, iterations);

              if (!courseCode.equals(""))
              {
                //if OK 
              System.out.printf("%nEnter your evaluation score for course %s%n", courseCode); 
              
              //get score for teacher
              System.out.printf("Teacher: ");
              inputTeacher = inputCourse();
    
              
               //get score for course content
              System.out.printf("Course contents: ");
              inputContents= inputCourse();
  

              //get score for examination
               //get score for course content
              System.out.printf("Examination: ");
              inputExamination = inputCourse();
              

              //add all 3 to int array to save info 
              addtoArray(evaluation, inputTeacher, inputContents, inputExamination, iterations, iterationsEv, courseCode);


              //print confirmation
              System.out.printf("Your evaluation was registered, thank you!");
              iterationsEv += 1;
                
              }
          

              
              
            } 
          if (selection == 3 ) //Print evaluation summary for a course
            {
              System.out.printf("Enter course code:%n");
              courseCode = checkCourseCode(courses, iterations);

              if (!courseCode.equals(""))
              {
                int[][] arrayInt = new int[10][4]; 
                
              noOfEvaluations = printEvaluation(evaluation, iterations, iterationsEv, courseCode);
               //parse them to int 
               
               //parse to int to get the array of ints for calculation
               arrayInt = makeArrayInt(arrayInt, evaluation, iterations, iterationsEv, courseCode, noOfEvaluations);
                
              //calculations for average score
               averages = calculations(averages, arrayInt, iterationsEv, iterations, noOfEvaluations);

              //print average scores
              }

              
            } 
          if (selection == 4 ) //Print course list (sorted by course code)
            {
              printCourseSorted(courses, iterations, averages);
              

              
            } 
          if (selection == 5 ) //Print course list (sorted by evaluation score)
            {
              printCourse(courses, iterations, averages);
              
            } 
    
        }
      
    }
    
            
  
/*
* Main menu for choices
*/
  static void menu()
  {
      System.out.println("----------------------------------");
      System.out.println("# LTU Course Evaluator");
      System.out.println("----------------------------------");
      System.out.println("1. Register new course");
      System.out.println("2. Register evaluation score");
      System.out.println("3. Print evaluation summary for a course");
      System.out.println("4. Print course list (sorted by course code)");
      System.out.println("5. Print course list (sorted by evaluation score))");
      System.out.println("q. End program");
  }

/*
* input menu for choices, returns 1-5
*/
  static int input()
        {
        int choice = 0;
        while (true) 
            {
            //INPUT 
             System.out.print("\n> Your choice: ");
             String input = keyboard.nextLine();
                // Process user input
                if (input.equals("1"))
                {
                  choice = 1;
                  break;
                 }
                 else if (input.equals("2")) 
                 {
                   choice = 2;
                   break;
                 }
                  else if (input.equals("3")) 
                 {
                   choice = 3;
                   break;
                 }
                  else if (input.equals("4")) 
                 {
                   choice = 4;
                   break;
                 }
                  else if (input.equals("5")) 
                 {
                   choice = 5;
                   break;
                 }
                   
                 else if (input.equals("q")) 
                {
                  System.out.println("Exiting program");
                  System.exit(0);
                }
                 else 
                 {
                 System.out.println("Invalid input. Please try again.");
                 }
       
        }
        return choice;
        }  

/*
* input menu for course evaluation only, returns str value between 1-5
*/
   public static String inputCourse()
        {
         String nrInput = "";
          while (true) 
            {
            //input  for int
             String input = keyboard.nextLine();
                // Process user input, check if the input is 1-5
              if (!input.isEmpty() && input.matches("[1-5]"))
                {
                  //save the input as a number
                  nrInput = input;
                  break;
                 }
                 else 
                 {
                   System.out.println("Not a valid input, try again");
                 }
            }
          return nrInput;
        }

/*
* input menu for longer STRINGS only, returns string value
*for use in course name and course code inputs
*/
  public static String inputStr()
        {
         String stringInput = "";
          while (true) 
            {
              //INPUT  for int
                String input = keyboard.nextLine();
                  // Process user input, check if the input strings are not empty
                  if (!input.isEmpty())
                  {
                      //get input 
                      stringInput = input;
                      break;
                  }
                  else 
                  {
                      System.out.println("Not a valid input, try again");
                  }
            
            }
          return stringInput;
        }

/*
* to add course name and code to array
*parameters for input: array of courses, string coursecodes, the code names, and iterations
* returns the array of courses 
*/
  public static String[][] addCourses(String[][] courses, String courseCode,  String codeName, int iterations)
      {
        
         for (int i = iterations; i < (iterations+1); i++) 
            if (courses[i][0]== null)
              {
                courses[i][0] = courseCode;  
                courses[i][1] = codeName; 
              }

        return courses;
      }


/*
* to add course the evaluation numnbers in string format to array
*parameters for input: evluation array, each input of evaluation, iteraitons ofr courses as well as for evaluations, as well as coursecode to match it
* returns the array of course evaluations in string format
*/
public static String[][] addtoArray(String[][]evaluation, String inputTeacher, String  inputContents, String inputExamination, int iterations, int iterationsEv, String courseCode )
  {
    
    for (int i = iterationsEv; i < (iterationsEv+1); i++) 
            //if (evaluation[i][0]== null)
              {
                evaluation[i][0] = inputTeacher;  
                evaluation[i][1] = inputContents; 
                evaluation[i][2] = inputExamination; 
                evaluation[i][3] = courseCode;  //course code for indexing
                       
              }

        return evaluation;

    
  }

/*
* to create array with ints instead of str for calculations 
* takes in evaluations of strings, returns array with ints instead
*/
  public static int[][] makeArrayInt(int[][]arrayInt, String[][]evaluation, int iterations, int iterationsEv, String courseCode, int noOfEvaluations)
  {
    //int[][]arrayInt = new int[10][4]; 

    for (int i = 0; i < iterationsEv; i++) 
      if (courseCode.equals(evaluation[i][3]))
    {
       arrayInt[i][0] = Integer.parseInt(evaluation[i][0]); //inputTeacher;  
       arrayInt[i][1] = Integer.parseInt(evaluation[i][1]);  //inputContents; 
       arrayInt[i][2] = Integer.parseInt(evaluation[i][2]); //inputExamination; 

    }
    return arrayInt;
}

    

  
/*
* printing courses, sorted by alphabetical course code
* Should include course code, course name, average category scores, as well as the total average scores.
*/
  public static void printCourse(String[][]courses, int iterations, double[][]averages)
  {

    
    //printing
    System.out.println("Code       Name                 Teacher     Contents     Exam     Average ");
    for(int i = 0; i < iterations; i++)
      {
      System.out.print(courses[i][0] + "      ");
      System.out.print(courses[i][1] + "        ");
      System.out.printf("  %.2f", averages[i][0]); //avgTeacher
      System.out.printf("  %.2f", averages[i][1]); //avgContents;
      System.out.printf("  %.2f", averages[i][2]); //avgEvaluation;
      System.out.printf("  %.2f%n", averages[i][3]); //totalAverage;
       }


    
  }

  /*
* printing courses, sorted by alphabetical course code
* Should include course code, course name, average category scores, as well as the total average scores.
*/
  public static void printCourseSorted(String[][]courses, int iterations, double[][]averages)
  {

    //bubble sort for code sorted by code
    for (int i = 0; i < iterations - 1; i++) 
    {
        for (int j = 0; j < iterations - i - 1; j++) 
        {
            if (courses[j][0].compareTo(courses[j + 1][0]) > 0) 
            {
                String[] temp = courses[j];
                courses[j] = courses[j + 1];
                courses[j + 1] = temp;
              //for other items using same index
                double[] tempAverages = averages[j];
                averages[j] = averages[j + 1];
                averages[j + 1] = tempAverages;
            }
        }
    }
    //printing
    System.out.println("Code       Name                 Teacher     Contents     Exam     Average ");
    for(int i = 0; i < iterations; i++)
      {
      System.out.print(courses[i][0] + "      ");
      System.out.printf(courses[i][1] + "             ");
      System.out.printf("  %.2f", averages[i][0]); //avgTeacher
      System.out.printf("  %.2f", averages[i][1]); //avgContents;
      System.out.printf("  %.2f", averages[i][2]); //avgEvaluation;
      System.out.printf("  %.2f%n",averages[i][3]); //totalAverage;
       }


    
  }

   /*
* printing courses, sorted by alphabetical course code
* Should include course code, course name, average category scores, as well as the total average scores.
*/
 
/*
* printing evaluations
*parameters of evaluation array in string format, as well as iteration counts and course code for check
*/
public static int printEvaluation(String[][]evaluation, int iterations, int iterationsEv, String courseCode)
  {

    int noOfEvaluations = 0;

    //printing
    System.out.println("Teacher       Contents       Examination");
    for(int i = 0; i < iterationsEv; i++)
      if (courseCode.equals(evaluation[i][3]))
        {
        System.out.print(evaluation[i][0] + "               ");
        System.out.print(evaluation[i][1] + "               ");
        System.out.println(evaluation[i][2] + " ");
        noOfEvaluations +=1;  
           
         }
    

    
    System.out.printf("%nNumber of evaluations: %d%n", noOfEvaluations);
    return noOfEvaluations;
    
   

    
  }


  /*
* to calculate and print output of calculations in double format 
*parameters for input: double array, numbers from evaluations in int format,  iterations nr
* returns the calculations in dobule format and prints them 
*/
public static double[][] calculations(double[][]averages, int[][]arrayInt, int iterationsEv, int iterations, int noOfEvaluations)
  {
 //declaring local variables
    int sumTeacher = 0;
    int sumContents = 0;
    int sumEvaluation = 0;
    int sumTotal = 0;
    double avgTeacher  = 0.0;
    double avgContents  = 0.0;
    double avgEvaluation  = 0.0;
    double totalAverage = 0.0;

   //looping through for calculation to add
     for (int i = 0; i < (iterationsEv); i++) 
              {
               sumTeacher +=  arrayInt[i][0]; //inputTeacher;  
               sumContents += arrayInt[i][1];  //inputContents; 
               sumEvaluation += arrayInt[i][2]; // inputExamination; 
              }

    //doing average calculations
     avgTeacher = (double)sumTeacher / noOfEvaluations;
     avgContents = (double)sumContents / noOfEvaluations;
     avgEvaluation = (double)sumEvaluation / noOfEvaluations;
     totalAverage = (avgTeacher + avgContents + avgEvaluation) / 3;
    
    //printing results
    System.out.printf("%naverage score%n"); 
    System.out.printf("Teacher: %.2f%n", avgTeacher); 
    System.out.printf("Contents: %.2f%n", avgContents); 
    System.out.printf("Examination: %.2f%n", avgEvaluation); 
    System.out.printf("total average: %.2f%n", totalAverage); 

    //averages for each of the courses in an array
    for (int i = 0; i < (iterations); i++) 
            if (averages[i][0]== 0)
              {
               averages[i][0] = avgTeacher; //inputTeacher;  
               averages[i][1] = avgContents;
               averages[i][2] = avgEvaluation; // inputExamination; 
               averages[i][3] = totalAverage; // total averages
              }


    return averages;
  }


 /*
* checks whether the course code  exists, to be used before adding evaluations 
*parameters for input: array of courses, nr of iterations 
* returns the OK course code  
*/
public static String checkCourseCode(String[][]courses, int iterations)
  {
    
    //first get input
    String okcourseCode = "";
    String courseCode = "";
    int x = 0;

    courseCode = inputStr();
        for (int i = 0; i < (iterations); i++) 
        { 
          if (courseCode!= null && (courses[i][0].equals(courseCode)))
            {
              okcourseCode = courseCode;
              x = 1;
            }
          
          }
      
     if (x == 0)
        {
          System.out.println ("Course code does not exist, try again");
            
         }

     return okcourseCode;  
   }


  /*
* check if course code already exists before inputting new course code in system
*parameters are the array of courses as well as the course code wanting to input
*returns the course code that can be used as OK
*/

  public static String codeCheckTwo(String[][]courses, String courseCode, int iterations)
  {
  
    //first get input
    String okcourseCode = "";
    int x = 0;
    boolean exists = false;

        for (int i = 0; i < (iterations+1); i++) 
        { 
         if (courseCode!= null && (courses[i][0]!= null) && (courses[i][0].equals(courseCode)))
            {
              exists = true;
              break; 
           
            }
          
          }

    if (!exists)
    {
      okcourseCode = courseCode;
    }
      
     else
        {
          System.out.println ("Course already exists, try again");
            
         }

     return okcourseCode;  
   }


   /*
* check if course code input is OK before putting in to the system, must be in specific format
* format: capital letter, 4 digits, capital letter 
*returns the course code that can be used as OK
*/
 public static String inputCourseCheck()
  {

    String courseCode = "";

     while (true) 
            {
            //INPUT  
             courseCode = inputStr();
                // Process user input, check if the input strings are not empty and only contain digits
              if (courseCode.matches("^[A-Z]\\d{4}[A-Z]$"))
                {
                  // accept the inputs
                  break;
                 }
                 else 
                 {
                   System.out.println("Input does not match desired format, try again");
                 }
            }
          return courseCode;

    
    

    
  }

  
  
}

