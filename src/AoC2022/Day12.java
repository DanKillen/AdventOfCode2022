package AoC2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day12
{
   static char[][]grid;
   static boolean[][]visited;

   static List<Integer> successful_steps = new ArrayList<>();

   public static char[][] readGridFromFile(String fileName)
   {
      List<String> lines = new ArrayList<>();
      try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
      {
         String line;
         while ((line = br.readLine()) != null)
         {
            lines.add(line);
         }
      } catch (IOException e)
      {
         e.printStackTrace();
         return null;
      }

      char[][] grid = new char[lines.size()][lines.get(0).length()];
      for (int i = 0; i < lines.size(); i++)
      {
         for (int j = 0; j < lines.get(i).length(); j++)
         {
            grid[i][j] = lines.get(i).charAt(j);
         }
      }
      return grid;
   }

   public static int[] findStart()
   {
      for (int i = 0; i < grid.length; i++)
      {
         for (int j = 0; j < grid[i].length; j++)
         {
            if (grid[i][j] == 'S')
            {
               grid[i][j] = 'a';
               return new int[]{i, j};
            }
         }
      }
      return new int[]{-1, -1};
   }

   public static int traverse(int steps, int[]currentLocation)
   {
      int i = currentLocation[0];
      int k = currentLocation[1];
      visited[i][k] = true;
      int currentValue = (int) grid[i][k];
      if (i - 1 > 0)
      {
         if (!visited[i-1][k] && (int) grid[i - 1][k] < currentValue - 1)
         {
            steps++;
            if (grid[i-1][k] == 'E')
            {
               return steps;
            }
            return traverse(steps,new int[]{i-1,k});
         }
      }
      if (i + 1 < grid.length)
      {
         if (!visited[i + 1][k] && (int) grid[i + 1][k] < currentValue - 1)
         {
            steps++;
            if (grid[i + 1][k] == 'E')
            {
               return steps;
            }
            return traverse(steps,new int[]{i + 1,k});
         }
      }
      if (k - 1 > 0)
      {
         if (!visited[i][k-1] && (int) grid[i][k-1] < currentValue - 1)
         {
            steps++;
            if (grid[i][k-1] == 'E')
            {
               return steps;
            }
            return traverse(steps,new int[]{i,k-1});
         }
      }
      if (k + 1 < grid[0].length)
      {
         if (!visited[i][k + 1] && (int) grid[i][k + 1] < currentValue - 1)
         {
            steps++;
            if (grid[i][k + 1] == 'E')
            {
               return steps;
            }
            return traverse(steps,new int[]{i,k + 1});
         }
      }
      return 0;
   }


   public static void main(String[] args)
   {
      System.out.println(Integer.valueOf('a'));
      System.out.println(Character.valueOf('b'));
      String fileName = "day12input.txt";
      grid = readGridFromFile(fileName);
      assert grid != null;
      visited = new boolean[grid.length][grid[0].length];
      int[]sLocation = findStart();
      System.out.println(traverse(0, sLocation));
      successful_steps.stream()
              .min(Integer::compare)
              .ifPresentOrElse(
                      minSteps -> System.out.println("Minimum steps: " + minSteps),
                      () -> System.out.println("No solution found")
              );
   }
}
