/**
 * Created by DanKillen on 26/12/2022
 * Following the Elf's instructions for the second column,
 * what would your total score be if everything goes exactly
 * according to your strategy guide?
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2
{


   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day2input.txt");
      BufferedReader buffer = new BufferedReader(input,1);
      String numStr;
      char a, b;
      while ((numStr = buffer.readLine()) != null)
      {
         a = numStr.charAt(0);
         b = numStr.charAt(2);
         new RSP(a,b);
      }
      System.out.print(RSP.score);
   }

   /**
    * Created by laptop on 25/12/2022
    * UPDATE COMMENTS ABOUT PROGRAM HERE
    **/

   public static class RSP {
      public static int score;
      int [][] matrix = {{4,1,7},
                         {8,5,2},
                         {3,9,6}};

      public RSP(char a, char b)
      {
         int i = -1;
         int j = -1;

         if (a == 'A')
         {
            j = 0;
         }
         if (a == 'B')
         {
            j = 1;
         }
         if (a == 'C')
         {
            j = 2;
         }
         if (b == 'X')
         {
            if (a == 'A')
            {
               i = 2;
            }
            else if(a == 'B')
            {
               i = 0;
            }
            else
            {
               i = 1;
            }
         }
         if (b == 'Y')
         {
            if (a == 'A')
            {
               i = 0;
            } else if (a == 'B')
            {
               i = 1;
            } else
            {
               i = 2;
            }
         }
         if (b == 'Z')
         {
            if (a == 'A')
            {
               i = 1;
            }
            else if(a == 'B')
            {
               i = 2;
            }
            else
            {
               i = 0;
            }
         }
         score += matrix[i][j];
      }
   }
}
