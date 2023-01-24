/**
 * Created by DanKillen on 26/12/2022
 * Find the item type that appears in both compartments of each rucksack.
 * What is the sum of the priorities of those item types?
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

import static java.lang.Character.isUpperCase;

public class Day3
{
   public static char findItem(int length, char[] ch1, char[] ch2)
   {
      for (int i = 0; i < length/2; i++)
      {
         for (int j = 0; j < length/2; j++)
         {
            if (ch1[i] == ch2[j])
            {
               return ch1[i];
            }
         }
      }
   return 'a';
   }
   public static int FindPoints(char c)
   {
      if (isUpperCase(c))
      {
         return (int) c - 38;
      }
      else
      {
         return (int) c - 96;
      }
   }
   public static int StringToPoints(String input)
   {
      int length = input.length();
      char[] ch = input.toCharArray();
      char[] ch1 = new char[length / 2];
      char[] ch2 = new char[length / 2];
      for (int i = 0; i < length / 2; i++)
      {
         ch1[i] = ch[i];
         ch2[i] = ch[i + (length / 2)];
      }
      char item = findItem(length, ch1, ch2);
      return FindPoints(item);
   }
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day3input.txt");
      BufferedReader buffer = new BufferedReader(input);
      int item = 0;
      String Str;
      while ((Str = buffer.readLine()) != null)
      {
         item += StringToPoints(Str);
      }
      System.out.print(item);
   }
}
