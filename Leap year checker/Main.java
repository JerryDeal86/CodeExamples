import java.util.Scanner;
class Main 
{

  public static void main(String args[])
  {
    Scanner input = new Scanner(System.in);
      
    int yearCheck = 0;
    int userInput = 0;
    boolean validInput = false;
    int yearAmount = 0;
    

    System.out.printf("How many years do you want to check(must be between 1 and 5?\n");
    yearAmount = input.nextInt();
    
    while(yearAmount < 1 || yearAmount > 5)
    {
      System.out.printf("\nInvalid Entry, Selection must be between 1 and 5.\n");
      yearAmount = input.nextInt();
    }


    while(yearAmount != 0)
    {
      while(validInput == false || yearAmount !=0)
      {
          
        System.out.printf("\nEnter a year from 1500 to 2019: ");
        userInput = input.nextInt();
        if(userInput <= 1499 || userInput >= 2020)
        {
          System.out.printf("\nThis year cannot be checked.\n");
          validInput = false;
          yearAmount = yearAmount - 1;
        }
        else
        {
          validInput = true;

          if((userInput % 4) == 0)
            yearCheck ++;
          else
            yearCheck = yearCheck - 1;

              
          if((userInput % 100) != 0)
            yearCheck++;
          else
            if((userInput % 400) == 0)
              yearCheck ++;
            else
              yearCheck = yearCheck - 1;

          if(yearCheck > 0)
            System.out.printf("This is a leap year.");
            
          if(yearCheck <= 0)
            System.out.printf("This is not a leap year.");
          
          yearAmount = yearAmount - 1;
        }
      }
    }
  }
}