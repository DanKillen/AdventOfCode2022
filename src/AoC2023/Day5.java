package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day5
{
   public class range
   {
      Long sourceStart;
      Long sourceEnd;
      Long destinationStart;
   }
   public static List<String> readFileAsListOfStrings(String filePath) {
      try {
         return Files.readAllLines(Paths.get(filePath));
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
   public static void main(String[] args) throws IOException
   {
      List<String> lines = readFileAsListOfStrings("2023day5inputEX.txt").stream().filter(l -> !l.isEmpty()).toList();
      String String = "";
      String = String.substring(String.indexOf(':') + 2);
      List<Long> seeds = Arrays.stream(lines.get(0).replace("seeds: ", "").split(" ")).map(Long::parseLong).toList();
      while (!String.isBlank())
      {
         String = String.trim();
         System.out.println(seeds);
         String = String.substring(String.indexOf(' ') + 1);
      }
      System.out.println(String);
      System.out.println(seeds);
//      String dataInput;
//      while ((dataInput = buffer.readLine()) != null)
//      {
//         String yourNumbers = dataInput.substring(dataInput.charAt(':'));
//         int[] yourNumbersInt = new int[10];
//         for (int i = 0, k = 2; i < 10; i++, k = k + 3)
//         {
//            yourNumbersInt[i] = Integer.parseInt(yourNumbers.substring(k, k + 2).replaceAll(" ",""));
//         }
//      }

   }
}

