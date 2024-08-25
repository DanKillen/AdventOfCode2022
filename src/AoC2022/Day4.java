package AoC2022;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Dan Killen on 26/12/2022
 * In how many assignment pairs do the ranges overlap?
 **/
public class Day4
{   public static void main(String[] args) throws IOException
{
   final int TOTAL = 2000;
   FileReader input = new FileReader("day4input.txt");
   FileReader input2 = new FileReader("day4input.txt");
   FileWriter output = new FileWriter("day4output.txt");
   BufferedReader buffer = new BufferedReader(input);
   BufferedReader buffer2 = new BufferedReader(input2);

   String Str;
   int i = 0;
   int a1, a2, b1, b2;
   String[] space = new String[TOTAL];
   String intro;

   while ((Str = buffer.readLine()) != null)
   {
      Scanner scanner = new Scanner(Str);
      scanner.useDelimiter("[-,\\n]");
      while (scanner.hasNext())
      {
         {
         a1 = scanner.nextInt();
         a2 = scanner.nextInt();
         b1 = scanner.nextInt();
         b2 = scanner.nextInt();
         }

      for (int j = a1; j <= a2; j++)
      {
         intro = "," + j +",";
         space[i] += intro;
      }
      space[i]=space[i].substring(4);
      i++;
      for (int k = b1; k <= b2; k++)
      {
         intro = "," + k + ",";
         space[i] += intro;
      }
      space[i]=space[i].substring(4);
      i++;
   }
   }

   String search;
   String search2;
   int tally = 0;
   for (int x = 0; x < TOTAL; x+=2)
   {
      Str = buffer2.readLine();
      output.append(Str);
      search = space[x];
      search2 = space[x + 1];
      String start1 = search.substring(0,3);
      String end1 = search.substring(search.length()-3);
      String start2 = search2.substring(0,3);
      String end2 = search2.substring(search2.length()-3);

         if (search2.contains(start1) || search2.contains(end1))
         {
            tally++;
            output.append("y\n");
         } else if (search.contains(start2) || search.contains(end2))
         {
            tally++;
            output.append("Y\n");
         } else
         {
            output.append("\n");
         }
         System.out.println(start1 + "-" + end1 + "," + start2 + "-" + end2);
      }

   input.close();
   output.close();
   System.out.println(tally);
//for (int k = 0; k < TOTAL; k++)
   //System.out.println(space[k]);
}
}
