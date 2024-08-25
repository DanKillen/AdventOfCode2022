package AoC2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day8
{

   public static int[][] readGridFromFile(String fileName)
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

      int[][] grid = new int[lines.size()][lines.get(0).length()];
      for (int i = 0; i < lines.size(); i++)
      {
         for (int j = 0; j < lines.get(i).length(); j++)
         {
            grid[i][j] = lines.get(i).charAt(j) - '0';
         }
      }
      return grid;
   }

   public static int countVisibleTrees(int[][] grid)
   {
      int visibleTrees = 0;

      for (int i = 0; i < grid.length; i++)
      {
         for (int j = 0; j < grid[i].length; j++)
         {
            if (isVisible(grid, i, j))
            {
               visibleTrees++;
            }
         }
      }
      return visibleTrees;
   }

   public static boolean isVisible(int[][] grid, int row, int col)
   {
      int height = grid[row][col];
      return isMaxInDirection(grid, row, col, -1, 0) || // Up
              isMaxInDirection(grid, row, col, 1, 0) ||  // Down
              isMaxInDirection(grid, row, col, 0, -1) || // Left
              isMaxInDirection(grid, row, col, 0, 1);    // Right
   }

   public static boolean isMaxInDirection(int[][] grid, int row, int col, int rowStep, int colStep)
   {
      int height = grid[row][col];
      while (true)
      {
         row += rowStep;
         col += colStep;

         if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length)
         {
            return true;
         }
         if (grid[row][col] >= height)
         {
            return false;
         }
      }
   }
   public static int workOutScenicScore(int[][] grid, int i, int j)
   {
      int houseHeight = grid[i][j];
      int U = 0, D = 0, L = 0, R = 0;
      for (int left = i - 1; left > 0; left--)
      {
         L++;
         if (houseHeight <= grid[left][j])
         {
            break;
         }
      }
      for (int right = i + 1; right < grid.length; right++)
      {
         R++;
         if (houseHeight <= grid[right][j])
         {
            break;
         }
         for (int up = j + 1; up < grid.length; up++)
         {
            U++;
            if (houseHeight <= grid[i][up])
            {
               break;
            }
         }
         for (int down = j - 1; down < grid.length; down++)
         {
            D++;
            if (houseHeight <= grid[i][down])
            {
               break;
            }
         }

      }
      return (R * L * U * D);
   }

   public static int topScenicScore(int[][] grid)
   {
      int topScenicScore = 0;
      for (int i = 1; i < grid.length - 1; i++)
      {
         for (int j = 1; j < grid[i].length - 1; j++)
         {
            int currentScenicScore = workOutScenicScore(grid, i, j);
            if (currentScenicScore > topScenicScore)
            {
               topScenicScore = currentScenicScore;
            }
         }
      }
      return topScenicScore;
   }

   public static void main(String[] args) {
      String fileName = "day8input.txt";
      int[][] grid = readGridFromFile(fileName);

      if (grid != null) {
         int visibleTrees = countVisibleTrees(grid);
         System.out.println("Number of visible trees: " + visibleTrees);
      }
      System.out.println("===PART TWO===");
      int[][] grid2 = readGridFromFile(fileName);
      assert grid2 != null;
      System.out.println(topScenicScore(grid2));
   }
}
