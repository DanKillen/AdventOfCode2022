import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Daniel Killen on 26/03/2023
 * addx V takes two cycles to complete. After two cycles, the X register is increased by V. (V can be negative.)
 * noop takes one cycle to complete. It has no other effect.
 **/
public class Day10
{
   static int total = 0;
   static int cycle = 0;
   static char[][] crtGrid = new char [6][40];
   public static int readDisk(BufferedReader pBuffer) throws IOException {
      String disk = pBuffer.readLine();
      int x = 1;
      while (disk != null)
      {
         if (disk.equals("noop"))
         {
            checkCycle(x);
            if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 170 || cycle == 219)
            {
               addCycle(cycle,x);
            }
            disk = pBuffer.readLine();
         }
         else
         {
            checkCycle(x);
            {
               if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 170 || cycle == 219)
               {
                  addCycle(cycle,x);
               }
            }
            checkCycle(x);
            int addX = Integer.parseInt(disk.substring(5));
            x += addX;
            if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 170 || cycle == 219)
            {
               addCycle(cycle,x);
            }
            disk = pBuffer.readLine();
         }
      }
      return total;
   }

   public static void addCycle(int cycle, int x)
   {
         System.out.println("Cycle: " + cycle + ". X Value: " + x);
         total += x * cycle;
   }

   public static void checkCycle(int x)
   {
      int gridLocation = cycle % 40;
      if (gridLocation == x || gridLocation == x - 1 || gridLocation == x + 1)
      {
         crtGrid[cycle / 40][gridLocation] = '#';
      }
      else
      {
         crtGrid[cycle / 40][gridLocation] = '.';
      }
      cycle++;
   }


   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("day10input.txt");
      BufferedReader buffer = new BufferedReader(input);
      System.out.println(readDisk(buffer));
      for (int i = 0; i < 6; i++)
      {
         System.out.println(crtGrid[i]);
      }
   }
}