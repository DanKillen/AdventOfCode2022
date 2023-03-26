import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Daniel Killen on 24/03/2023
 After simulating the rope, you can count up all of the positions the tail visited at least once.
 In this diagram, s again marks the starting position (which the tail also visited) and # marks other positions the tail
 visited:

 So, there are 13 positions the tail visited at least once.

 Simulate your complete hypothetical series of motions. How many positions does the tail visit at least once?

 To begin, get your puzzle input.
 **/
public class Day9
{
   static int SIZE_OF_MAP = 600;
   static boolean[][] mapNotTerritory = new boolean[SIZE_OF_MAP][SIZE_OF_MAP];
   static int[] ropeH = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope1 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope2 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope3 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope4 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope5 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope6 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope7 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] rope8 = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};
   static int[] ropeT = {SIZE_OF_MAP / 2,SIZE_OF_MAP / 2};

   static int iteration = 0;
   static int count = 1;

   public static char interpretInstruction (String pInstruction)
   {
      iteration = Integer.parseInt(pInstruction.substring(2));
      return pInstruction.charAt(0);
   }

   public static void carryOutDirections(char direction)
   {
      for (int i = 0; i < iteration; i++)
      {
         if (direction == 'U')
         {
            ropeH[1]++;
         }
         if (direction == 'D')
         {
            ropeH[1]--;

         }
         if (direction == 'R')
         {
            ropeH[0]++;

         }
         if (direction == 'L')
         {
            ropeH[0]--;
         }
         moveT(ropeH, rope1);
         moveT(rope1, rope2);
         moveT(rope2, rope3);
         moveT(rope3, rope4);
         moveT(rope4, rope5);
         moveT(rope5, rope6);
         moveT(rope6, rope7);
         moveT(rope7, rope8);
         moveT(rope8, ropeT);
      }
   }

   public static void moveT(int[] pRopeH, int[] pRopeT)
   {
      if ((pRopeH[0] > pRopeT[0] && pRopeH[1] > pRopeT[1] + 1)||(pRopeH[0] > pRopeT[0] + 1 && pRopeH[1] > pRopeT[1]))
      {
         pRopeT[0]++;
         pRopeT[1]++;
      }
      else if ((pRopeH[0] > pRopeT[0] && pRopeH[1] < pRopeT[1] - 1)||(pRopeH[0] > pRopeT[0] + 1 && pRopeH[1] < pRopeT[1]))
      {
         pRopeT[0]++;
         pRopeT[1]--;
      }
      else if ((pRopeH[0] < pRopeT[0] && pRopeH[1] < pRopeT[1] - 1)||(pRopeH[0] < pRopeT[0] - 1 && pRopeH[1] < pRopeT[1]))
      {
         pRopeT[0]--;
         pRopeT[1]--;
      }
      else if ((pRopeH[0] < pRopeT[0] && pRopeH[1] > pRopeT[1] + 1)||(pRopeH[0] < pRopeT[0] - 1 && pRopeH[1] > pRopeT[1]))
      {
         pRopeT[0]--;
         pRopeT[1]++;
      }
      else if(pRopeH[0] < pRopeT[0] - 1)
      {
         pRopeT[0]--;
      }
      else if(pRopeH[0] > pRopeT[0] + 1)
      {
         pRopeT[0]++;
      }
      else if(pRopeH[1] < pRopeT[1] - 1)
      {
         pRopeT[1]--;
      }
      else if(pRopeH[1] > pRopeT[1] + 1)
      {
         pRopeT[1]++;
      }
      if (!mapNotTerritory[ropeT[0]][ropeT[1]])
      {
         mapNotTerritory[ropeT[0]][ropeT[1]] = true;
         count++;
      }
   }

   public static void main(String[] args) throws IOException {
      mapNotTerritory[SIZE_OF_MAP / 2][SIZE_OF_MAP / 2] = true;
      FileReader input = new FileReader("day9input.txt");
      BufferedReader buffer = new BufferedReader(input);
      String instruction = buffer.readLine();
      while (instruction != null)
      {
         carryOutDirections(interpretInstruction(instruction));
         instruction = buffer.readLine();
      }
      System.out.println(count);
   }
}