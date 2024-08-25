package AoC2022;
/**
 * Created by Dan Killen on 28/12/2022
 * How many characters need to be processed before the first start-of-message
 * marker is detected?
 **/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.exit;

public class Day6
{
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day6input.txt");
      BufferedReader buffer = new BufferedReader(input);
      String signal = buffer.readLine();
      int counter = 0;
      counter += 13;
      String check1;
      char[] check;
      for (int x = 0; x < (signal.length()); x++)
      {
         check1 = (signal.substring(x, x + 14));
         check = check1.toCharArray();
         boolean is_unique = true;
         for (int i = 0; i < 14; i++)
         {
            for (int j = i + 1; j < 14; j++)
            {
               // if a character is repeated
               if (check[i] == check[j])
               {
                  // set boolean variable to false
                  is_unique = false;
                  break;

               }
            }
        }
         counter++;
         if (is_unique)
         {
            System.out.println(counter);
            System.out.println(check);
            exit(1);
         }
      }

      System.out.print(counter);
      exit(2);


   }}