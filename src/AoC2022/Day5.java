package AoC2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by laptop on 27/12/2022
 * UPDATE COMMENTS ABOUT PROGRAM HERE
 **/
public class Day5
{
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day5input.txt");
      BufferedReader buffer = new BufferedReader(input);
      String[] arr = new String[9];
      for (int i = 0; i < 8; i++)
      {
         //for (int j = 0; j < 8; j++)
         //{
            String line = buffer.readLine();
            for (int c = 1, p = 0; c < 35; c += 4, p++ )
               if (line.charAt(c) != ' ')
               {
                  char intro = line.charAt(c);
                  arr[p] += intro;
               }
      }
      for (int i = 0; i < 9; i++)
      {
         StringBuilder sb = new StringBuilder(arr[i]);
         arr[i] = sb.reverse().toString();
         arr[i] = arr[i].substring(0,arr[i].length()-4);
         System.out.println(arr[i]);
      }
      String line = buffer.readLine();
      line = buffer.readLine();
      int amount, origin, dest;

      for (int x = 0; x < 600; x++)
      {
         if ((line = buffer.readLine()) != null)
         {
            if (Character.isDigit(line.charAt(6)))
            {
               amount = Integer.parseInt(line.substring(5, 7));
               origin = Integer.parseInt(line.substring(13, 14));
               dest = Integer.parseInt(line.substring(18, 19));
            } else
            {
               amount = Integer.parseInt(line.substring(5,6));
               origin = Integer.parseInt(line.substring(12, 13));
               dest = Integer.parseInt(line.substring(17, 18));
            }

            origin = origin - 1;
            dest = dest - 1;

            //for (int loops = 0; loops < amount; loops++)
            //{
               String trim = arr[origin].substring(arr[origin].length()-amount,arr[origin].length());
               arr[origin] = arr[origin].substring(0, (arr[origin].length()-amount));
               arr[dest] += trim;
            //}
         }
         else
         {
            for (int f = 0; f < 9; f++)
            System.out.print(arr[f]);
         }
      }
      System.out.println("=======================");
      for (int i = 0; i < 9; i++)
      {
         System.out.println(i + 1 + " : " + arr[i]);
      }
   }
}

