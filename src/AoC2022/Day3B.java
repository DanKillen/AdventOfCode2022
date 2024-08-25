package AoC2022; /**
 * Created by DanKillen on 26/12/2022
 * Find the item type that corresponds to the badges of each three-Elf group.
 * What is the sum of the priorities of those item types?
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.Arrays;

import static java.lang.Character.isUpperCase;

public class Day3B
{
   public static char findItem(int length1, int length2, int length3, char[] ch1, char[] ch2, char[] ch3)
   {
      for (int i = 0; i < length1; i++)
      {
         for (int j = 0; j < length2; j++)
         {
            if (ch1[i] == ch2[j])
            {
               for (int k = 0; k < length3; k++)
               {
                  if (ch1[i] == ch3[k])
                  {
                     return ch1[i];
                  }
               }
            }
         }
      }
      return 'a';
   }
   public static int FindPoints(char c)
   {
      if (isUpperCase(c))
      {
         return (int)c - 38;
      }
      else
      {
         return (int)c - 96;
      }
   }
   public static int StringToPoints(String input1, String input2, String input3)
   {
      int length1 = input1.length();
      int length2 = input2.length();
      int length3 = input3.length();
      char[] ch1 = input1.toCharArray();
      char[] ch2 = input2.toCharArray();
      char[] ch3 = input3.toCharArray();
      char item = findItem(length1, length2, length3, ch1, ch2, ch3);
      return FindPoints(item);
   }
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day3input.txt");
      BufferedReader buffer = new BufferedReader(input);
      int[] totals = new int[500];
      Arrays.fill(totals,0);
      int item = 0;
      String Str;
      int w = 0;
      while ((Str = buffer.readLine()) != null)
      {
         String Str2 = buffer.readLine();
            String Str3 = buffer.readLine();
            totals[w] = StringToPoints(Str,Str2,Str3);
            w++;
      }
      for (int p = 0; p < w; p++)
      {
         item += totals[p];
      }
      System.out.print(item);
   }
}
