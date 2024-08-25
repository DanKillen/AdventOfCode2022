package AoC2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day2
{
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("2023day2inputEX.txt");
      BufferedReader buffer = new BufferedReader(input);
      final int RED = 12, GREEN = 13, BLUE = 14;
      int  greenGame = 0, redGame= 0, blueGame = 0, gameNumber = 0, totalLength = 0, continuousGamePower = 0;
      String cubeStr;
      String[][] wholeSet = new String[101][];
      while ((cubeStr = buffer.readLine()) != null)
      {
         gameNumber++;
         String trimCubeStr = cubeStr.substring(cubeStr.indexOf(':') + 1);
         trimCubeStr = trimCubeStr.replaceAll(" blue", "b");
         trimCubeStr = trimCubeStr.replaceAll(" red", "r");
         trimCubeStr = trimCubeStr.replaceAll(" green", "g");
         Pattern pattern = Pattern.compile(";");
         Matcher matcher = pattern.matcher(trimCubeStr);
         int count = 1;
         while (matcher.find()) {
            count++;
         }
         String[] games = new String[count];
         count = 0;
         while (trimCubeStr.contains(";"))
         {
            int endPoint = trimCubeStr.indexOf(';');
            games[count++] = (trimCubeStr.substring(0, endPoint));
            trimCubeStr = trimCubeStr.substring(endPoint + 1);
         }
         games[count] = (trimCubeStr);
         wholeSet[gameNumber] = games;
      }
      for (int i = 0; i < wholeSet.length; i++)
      {
         if (wholeSet[i] == null)
         {

         }
         else
         {
            for (int j = 0; j < wholeSet[i].length; j++)
            {

               String game = wholeSet[i][j];
               for (int k = 0; k < game.length(); k++)
               {
                  if (Character.isDigit(game.charAt(k)) && Character.isDigit(game.charAt(k + 1)))
                  {
                     int i1 = Character.getNumericValue(game.charAt(k)) * 10;
                     i1 += Character.getNumericValue(game.charAt(k + 1));
                     if (game.charAt(k + 2) == 'b')
                     {
                        if (blueGame < i1)
                        {
                           blueGame = i1;
                        }
                     }
                     if (game.charAt(k + 2) == 'r')
                     {
                        if (redGame < i1)
                        {
                           redGame = i1;
                        }
                     }
                     if (game.charAt(k + 2) == 'g')
                     {
                        if (greenGame < i1)
                        {
                           greenGame = i1;
                        }
                     }
                     k = k + 2;
                  }
                  else if (Character.isDigit(game.charAt(k)))
                  {
                     int i1 = Integer.parseInt(String.valueOf(game.charAt(k)));
                     if (game.charAt(k + 1) == 'b')
                     {
                        if (blueGame < i1)
                        {
                           blueGame = i1;
                        }
                     }
                     if (game.charAt(k + 1) == 'r')
                     {
                        if (redGame < i1)
                        {
                           redGame = i1;
                        }
                     }
                     if (game.charAt(k + 1) == 'g')
                     {
                        if (greenGame < i1)
                        {
                           greenGame = i1;
                        }
                     }
                     k = k + 1;
                  }
               }
            }
            int gamePower = redGame * blueGame * greenGame;
            continuousGamePower += gamePower;
            if (redGame <= RED && blueGame <= BLUE && greenGame <= GREEN)
            {
               totalLength += i;
            }
            redGame = 0;
            blueGame = 0;
            greenGame = 0;
         }

      }
      System.out.println(continuousGamePower);
   }

}

