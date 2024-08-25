package AoC2022;

import java.io.*;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day1
{
   static void sort(int[] arr)
   {
      int n = arr.length;

      for (int i = 0; i < n-1; i++)
      {
       int max =  i;
       for (int j = i+1; j < n; j++)
       {
         if (arr[j]> arr[max])
         {
            max = j;
         }
         int temp = arr[max];
         arr[max] = arr[i];
         arr[i] = temp;
       }
      }
   }
   static void printArray(int[] arr)
   {
      for (int j : arr)
      {
         System.out.println(j);
      }
   }
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day1input.txt");
      BufferedReader buffer = new BufferedReader(input);
      //Scanner scanner = new Scanner(new File("day1input.txt"));
      int[] totals = new int[500];
      int i = 0;
      String numStr;
      while ((numStr = buffer.readLine()) != null)
         {
            if (numStr.compareTo("") != 0)
            {
               int num = Integer.parseInt(numStr);
               totals[i] += num;
            }
            else
            {
               i++;
            }
         }
      buffer.close();
      input.close();

      int[] finalTotals = new int[i + 1];
      System.arraycopy(totals, 0, finalTotals, 0, i + 1);
      sort(finalTotals);
      printArray(finalTotals);

      int total = finalTotals[0] + finalTotals[1] + finalTotals[2];
      System.out.print(total);
   }
}

