import java.io.*;
import java.util.Scanner;


/**
 * Created by ${USER} on ${DATE}
 * UPDATE COMMENTS ABOUT PROGRAM HERE
 **/
public class Day1
{
   static void sort(int arr[])
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
   static void printArray(int arr[])
   {
      for (int i = 0; i < arr.length; i++)
      {
         System.out.println(arr[i]);
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
      for (int j = 0; j <= i; j++)
      {
         finalTotals[j] = totals[j];
      }
      sort(finalTotals);
      printArray(finalTotals);

      int total = finalTotals[0] + finalTotals[1] + finalTotals[2];
      System.out.print(total);
   }
}

