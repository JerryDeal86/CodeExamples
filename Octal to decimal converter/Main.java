
import java.util.Scanner;

class Main
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    boolean validInput = false;
    int userInput = 0;
    int a = 0;
    int solution = 0;

    
    while(validInput == false)
    {
      System.out.printf("Enter a number no greater than 8 digits: ");
      userInput = input.nextInt();
      
      if(userInput <= -1 || userInput >= 99999999)
      {
        System.out.printf("Re-enter a non-negative number no greater than 8 digits:\n");
        validInput = false;
      }
      else
      {
        a = userInput;
        validInput = true;
      }
    }

    tool.conversion( a, solution, userInput);

  }
}
class tool
{
  public static void conversion( int a, int solution, int userInput)
  {
    int b = 0;
    int c = 1;
      
    while(a != 0)
      {
        b = a % 10;
        a = a / 10;
        solution = solution + (b * c);
        c = c * 8;
      }
    System.out.printf("\nYour octal number %d is %07d in decimal", userInput, solution);
  }
}

