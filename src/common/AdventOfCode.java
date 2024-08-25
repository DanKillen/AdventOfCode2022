package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Daniel Killen on 27/03/2023
 * UPDATE COMMENTS ABOUT PROGRAM HERE
 **/
public class AdventOfCode
{
   public static BufferedReader readInFile(String input) throws FileNotFoundException
   {
      FileReader fr = new FileReader(input + ".txt");
      BufferedReader buffer = new BufferedReader(fr);
      return buffer;
   }
}
