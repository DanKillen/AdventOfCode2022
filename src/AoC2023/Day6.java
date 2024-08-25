package AoC2023;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day6
{
   static int[] timeEX = { 71530};
   static int[] distanceEX = { 940200};

   static long[] time = { 62737565L};
   static long[] distance = { 644102312401023L};

   public static void main(String[] args) throws IOException
   {
      long[] totalWins = new long[time.length];
      for (int i = 0; i < time.length; i++)
      {
         totalWins[i] = winPossibilities(time[i], distance[i]);
      }
      System.out.println(Arrays.toString(totalWins));
   }

   public static long winPossibilities(Long time, Long distanceToBeat)
   {
      int possibleWins = 0;
      for (int secondsPressed = 1; secondsPressed < time; secondsPressed++)
      {
         long speed = secondsPressed;
         long distanceCovered = speed * (time - secondsPressed);
         if (distanceCovered > distanceToBeat)
         {
            possibleWins++;
         }
      }
      return possibleWins;
   }
}

