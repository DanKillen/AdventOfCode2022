package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Daniel Killen on 24/12/2023
 * UPDATE COMMENTS ABOUT PROGRAM HERE
 **/
public class common
{
   public BufferedReader readFileAsBufferedReader(String filename)
   {
      FileReader input;
         try
         {
            input = new FileReader(filename);
            BufferedReader br = new BufferedReader(input);
            return br;
         } catch (FileNotFoundException e)
         {
            throw new RuntimeException(e);
         }
   }
}
