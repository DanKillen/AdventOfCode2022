package AoC2023;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day8
{
   public static void main(String[] args) throws IOException
   {
      ArrayList<fork> forks = new ArrayList<fork>();
      String steps = "LRLRLLRRLRRRLRLRRLRLLRRLRRRLRLRLRLRRLRLLRRRLRRRLLRRLRRLRLRRRLLLRRLRLRLRL" +
              "RLRLLRRRLRLRRRLRRRLRRRLRRRLRRRLRRRLRRRLRRLRRRLLRLLRRLRRLRRLRRRLLRLRRLRLRLRRLLRL" +
              "RRRLRRLLRLRLRRRLRRLRRLRRLRLLRLRRRLLLRRRLLLLRRLRRRLLLRRLLRLRLRLLLRRRLLRRRLLLRLRR" +
              "LLRRRLRRRLRLLRRRLRLRLRLLRRLLRRLRRRLRLRRRLRRLRLRRLRRRR";

      String stepsEX = "LR";
      FileReader input;
      {
         try
         {
            input = new FileReader("2023day8input.txt");
            BufferedReader br = new BufferedReader(input);
            String line = br.readLine();
            while (line != null)
            {
               fork fork1 = new fork(line.substring(0, 3), line.substring(7,10),line.substring(12,15));
               forks.add(fork1);
               line = br.readLine();
            }
         } catch (FileNotFoundException e)
         {
            throw new RuntimeException(e);
         }
      }

      System.out.println(followSteps2(steps, forks));

   }

   public static Long followSteps(String steps, ArrayList<fork> forkList)
   {
      String[] names = {"QKA", "VMA", "AAA", "RKA", "LBA", "JMA"};
      //String[] names = {"11A", "22A"};
      int characterIndex = 0;
      Long numberOfSteps = 0L;
      while (names[0].charAt(2) != 'Z' || names[1].charAt(2) != 'Z' || names[2].charAt(2) != 'Z'
            || names[3].charAt(2) != 'Z' || names[4].charAt(2) != 'Z' || names[5].charAt(2) != 'Z')
      {
         for (int i = 0; i < names.length; i++)
         {
            names[i] = findNextFork(names[i], forkList, steps.charAt(characterIndex));
         }
         if (characterIndex + 1 == steps.length())
         {
            characterIndex = 0;

         }
         else
         {
            characterIndex++;
         }
         numberOfSteps++;
         System.out.println(characterIndex);
         System.out.println(steps.length());
         System.out.println(Arrays.toString(names));
      }
      return numberOfSteps;
   }

   public static Long followSteps2(String steps, ArrayList<fork> forkList)
   {
      String[] names = {"QKA", "VMA", "AAA", "RKA", "LBA", "JMA"};
      String name1 = "QKA";
      String name2 = "VMA";
      String name3 = "AAA";
      String name4 = "RKA";
      String name5 = "LBA";
      String name6 = "JMA";
      System.out.println(LCM(name1, forkList, steps));
      System.out.println(LCM(name2, forkList, steps));
      System.out.println(LCM(name3, forkList, steps));
      System.out.println(LCM(name4, forkList, steps));
      System.out.println(LCM(name5, forkList, steps));
      System.out.println(LCM(name6, forkList, steps));
      //String[] names = {"11A", "22A"};
//      int characterIndex = 0;
//      Long numberOfSteps = 0L;
//      while (names[0].charAt(2) != 'Z' || names[1].charAt(2) != 'Z' || names[2].charAt(2) != 'Z'
//              || names[3].charAt(2) != 'Z' || names[4].charAt(2) != 'Z' || names[5].charAt(2) != 'Z')
//      {
//         for (int i = 0; i < names.length; i++)
//         {
//            names[i] = findNextFork(names[i], forkList, steps.charAt(characterIndex));
//         }
//         if (characterIndex + 1 == steps.length())
//         {
//            characterIndex = 0;
//
//         }
//         else
//         {
//            characterIndex++;
//         }
//         numberOfSteps++;
//         System.out.println(characterIndex);
//         System.out.println(steps.length());
//         System.out.println(Arrays.toString(names));
//      }
//      return numberOfSteps;
      return 0L;
   }

   public static Long LCM(String nameToFind, ArrayList<fork> forkList, String steps)
   {
      Long numberOfSteps = 0L;
      int characterIndex = 0;
      while (nameToFind.charAt(2) != 'Z')
      {
            nameToFind = findNextFork(nameToFind, forkList, steps.charAt(characterIndex));

         if (characterIndex + 1 == steps.length())
         {
            characterIndex = 0;
         }
         else
         {
            characterIndex++;
         }
         numberOfSteps++;
      }
      return numberOfSteps;
   }

   public static String findNextFork(String nameToFind, ArrayList<fork> forkList, char direction)
   {
      fork tempFork = new fork(nameToFind, null, null);
      int index = forkList.indexOf(tempFork);
      if (direction == 'L')
      {
         return forkList.get(index).directions[0];
      }
      else if (direction == 'R')
      {
         return forkList.get(index).directions[1];
      }
      return null;
   }
}

