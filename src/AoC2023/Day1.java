package AoC2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day1
{
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("2023day1input.txt");
      BufferedReader buffer = new BufferedReader(input);
      int  totalLines = 0, ones = 0, tens = 0, totalTens = 0, totalOnes = 0;
      String numStr;
      while ((numStr = buffer.readLine()) != null)
         {
            numStr = numberConverter(numStr);
            tens = 0;
            ones = 0;
            boolean tensFilled = false;
            for (int i = 0; i < numStr.length(); i++)
            {
               if (Character.isDigit(numStr.charAt(i)))
               {
                  if (!tensFilled)
                  {
                     tens = Character.getNumericValue(numStr.charAt(i));
                     ones = Character.getNumericValue(numStr.charAt(i));
                     tensFilled = true;
                  }
                  else
                  {
                     ones = Character.getNumericValue(numStr.charAt(i));
                  }
               }
            }
            totalTens += tens;
            totalOnes += ones;
            totalLines++;
         }
      buffer.close();
      input.close();

      System.out.println("Total Lines = " + totalLines);
      System.out.println("total tens: " + totalTens);
      System.out.println("total ones: " + totalOnes);
      System.out.println(50780 + 4945);
      System.out.println("Answer: " + ((totalTens * 10) + totalOnes));

   }

   public static String numberConverter(String numStr) {
      char[] numStrArray = numStr.toCharArray();
      for (int i = 0; i < numStr.length(); i++)
      {
         if (numStrArray[i] == 'o' && numStr.length() > i + 1)
         {
            if (numStrArray[i+1] == 'n' && numStrArray[i+2] == 'e')
            {
               numStrArray[i] = '1';
            }
         }
         if (numStrArray[i] == 't' && numStr.length() > i + 1)
         {
            if (numStrArray[i+1] == 'w' && numStrArray[i+2] == 'o')
            {
               numStrArray[i] = '2';
            }
            if (numStr.length() > i + 3)
            {
            if (numStrArray[i+1] == 'h' && numStrArray[i+2] == 'r'
            && numStrArray[i+3] == 'e' && numStrArray[i+4] == 'e')
            {
               numStrArray[i] = '3';
            }
            }
         }
         if (numStrArray[i] == 'f' && numStr.length() > i + 2)
         {
            if (numStrArray[i+1] == 'o' && numStrArray[i+2] == 'u' && numStrArray[i+3] == 'r')
            {
               numStrArray[i] = '4';
            }
            if (numStr.length() > i + 2)
            {
               if (numStrArray[i + 1] == 'i' && numStrArray[i + 2] == 'v'
                       && numStrArray[i + 3] == 'e')
               {
                  numStrArray[i] = '5';
               }
            }
         }
         if (numStrArray[i] == 's' && numStr.length() > i + 1)
         {
            if (numStrArray[i + 1] == 'i' && numStrArray[i + 2] == 'x')
            {
               numStrArray[i] = '6';
            }
            if (numStr.length() > i + 3)
            {
               if (numStrArray[i + 1] == 'e' && numStrArray[i + 2] == 'v'
                       && numStrArray[i + 3] == 'e' && numStrArray[i + 4] == 'n')
               {
                  numStrArray[i] = '7';
               }
            }
         }
            if (numStrArray[i] == 'e' && numStr.length() > i + 3)
            {
               if (numStrArray[i + 1] == 'i' && numStrArray[i + 2] == 'g'
                       && numStrArray[i + 3] == 'h' && numStrArray[i + 4] == 't')
               {
                  numStrArray[i] = '8';
               }
            }
            if (numStrArray[i] == 'n' && numStr.length() > i + 2)
            {
               if (numStrArray[i + 1] == 'i' && numStrArray[i + 2] == 'n'
                       && numStrArray[i + 3] == 'e')
               {
                  numStrArray[i] = '9';
               }
            }
      }
      String finished = new String(numStrArray);
      System.out.println(finished);
      return finished;
   }
}

