package AoC2023;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import common.common;

public class Day9
{
   public static void main(String[] args) throws IOException
   {
      ArrayList<List<Integer>> sequences = new ArrayList<List<Integer>>();
      FileReader input;
      {
         try
         {
            BufferedReader br = new common().readFileAsBufferedReader("2023day9input.txt");
            String line = br.readLine();
            while (line != null)
            {
               List<Integer> sequence = Arrays.stream(line.split(" "))
                       .map(Integer::parseInt).collect(Collectors.toList());
               System.out.println(sequence);
               revList(sequence);
               System.out.println(sequence);
               sequences.add(sequence);
               line = br.readLine();
            }
         } catch (FileNotFoundException e)
         {
            throw new RuntimeException(e);
         }
      }
      long total = 0L;
      for (int i = 0; i < sequences.size(); i++)
      {
         List<Integer> currentSequence = sequences.get(i);
         int lastOff = currentSequence.get(currentSequence.size() - 1);
         //System.out.println("lastOff: " + lastOff);
         Long answer = (long) (workOutNextIteration(sequences.get(i)) + lastOff);
         total += answer;
         System.out.println(sequences.get(i));
         System.out.println("Sequence " + (i + 1) + ": " + answer);
      }
      System.out.println(total);
   }

   public static int workOutNextIteration(List<Integer> sequence) {
      ArrayList<Integer> differenceSequence = new ArrayList<>();
      for (int i = 0; i < (sequence.size() - 1); i++) {
         int difference = sequence.get(i + 1) - sequence.get(i);
         differenceSequence.add(difference);
      }

      // Check if all elements of differenceSequence are zero
      boolean allZero = differenceSequence.stream().allMatch(i -> i == 0);
      if (allZero) {
         return 0;
      }

      return differenceSequence.get(differenceSequence.size() - 1) + workOutNextIteration(differenceSequence);
   }

   public static <T> void revList(List<T> list)
   {
      // base condition when the list size is 0
      if (list.size() <= 1 || list == null)
         return;


      T value = list.remove(0);

      // call the recursive function to reverse
      // the list after removing the first element
      revList(list);

      // now after the rest of the list has been
      // reversed by the upper recursive call,
      // add the first value at the end
      list.add(value);
   }
}

