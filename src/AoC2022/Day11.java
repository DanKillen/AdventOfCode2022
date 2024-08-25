package AoC2022;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Daniel Killen on 27/03/2023
 * Figure out which monkeys to chase by counting how many items they inspect over 20 rounds.
 * What is the level of monkey business after 20 rounds of stuff-slinging simian shenanigans?
 **/
public class Day11
{
   static int ROUNDS = 10000;
   static int monkey0Checks = 0;
   static int monkey1Checks = 0;
   static int monkey2Checks = 0;
   static int monkey3Checks = 0;
   static int monkey4Checks = 0;
   static int monkey5Checks = 0;
   static int monkey6Checks = 0;
   static int monkey7Checks = 0;
   static List<Long> monkey0List;
   static List<Long> monkey1List;
   static List<Long> monkey2List;
   static List<Long> monkey3List;
   static List<Long> monkey4List;
   static List<Long> monkey5List;
   static List<Long> monkey6List;
   static List<Long> monkey7List;

   static long part2Modulo = (13 * 7 * 3 * 19 * 5 * 2 * 11 * 17);

   public static void monkey0(long item)
   {
      monkey0Checks++;
      long newItem = item * 11;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey0List.remove(0);
      if (newItem % 13 == 0)
      {
         ;
         monkey1List.add(newItem);
      }
      else
      {
         monkey7List.add(newItem);
      }
   }
   public static void monkey1(long item)
   {
      monkey1Checks++;
      long newItem = item + 1;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey1List.remove(0);
      if (newItem % 7 == 0)
      {
         ;
         monkey3List.add(newItem);
      }
      else
      {
         monkey6List.add(newItem);
      }
   }
   public static void monkey2(long item)
   {
      monkey2Checks++;
      long newItem = item * item;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey2List.remove(0);
      if (newItem % 3 == 0)
      {
         monkey5List.add(newItem);
      }
      else
      {
         monkey4List.add(newItem);
      }
   }
   public static void monkey3(long item)
   {
      monkey3Checks++;
      long newItem = item + 2;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey3List.remove(0);
      if (newItem % 19 == 0)
      {
         ;
         monkey2List.add(newItem);
      }
      else
      {
         monkey6List.add(newItem);
      }
   }
   public static void monkey4(long item)
   {
      monkey4Checks++;
      long newItem = item + 6;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey4List.remove(0);
      if (newItem % 5 == 0)
      {
         ;
         monkey0List.add(newItem);
      }
      else
      {
         monkey5List.add(newItem);
      }
   }
   public static void monkey5(long item)
   {
      monkey5Checks++;
      long newItem = item + 7;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey5List.remove(0);
      if (newItem % 2 == 0)
      {
         monkey7List.add(newItem);
      }
      else
      {
         monkey0List.add(newItem);
      }
   }
   public static void monkey6(long item)
   {
      monkey6Checks++;
      long newItem = item * 7;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey6List.remove(0);
      if (newItem % 11 == 0)
      {
         ;
         monkey2List.add(newItem);
      }
      else
      {
         monkey4List.add(newItem);
      }
   }
   public static void monkey7(long item)
   {
      monkey7Checks++;
      long newItem = item + 8;
      //newItem /= 3;
      newItem = checkModule(newItem);
      monkey7List.remove(0);
      if (newItem % 17 == 0)
      {
         ;
         monkey1List.add(newItem);
      }
      else
      {
         monkey3List.add(newItem);
      }
   }

   public static void initialiseExampleItems()
   {
//      monkey0List = Stream.of(79, 98).collect(Collectors.toList());
//      monkey1List = Stream.of(54, 65, 75, 74).collect(Collectors.toList());
//      monkey2List = Stream.of(79, 60, 97).collect(Collectors.toList());
//      monkey3List = Stream.of(74).collect(Collectors.toList());
   }
   public static void initialiseActualItems()
   {
      monkey0List = Stream.of(71L, 56L, 50L, 73L).collect(Collectors.toList());
      monkey1List = Stream.of(70L, 89L, 82L).collect(Collectors.toList());
      monkey2List = Stream.of(52L, 95L).collect(Collectors.toList());
      monkey3List = Stream.of(94L, 64L, 69L, 87L, 70L).collect(Collectors.toList());
      monkey4List = Stream.of(98L, 72L, 98L, 53L, 97L, 51L).collect(Collectors.toList());
      monkey5List = Stream.of(79L).collect(Collectors.toList());
      monkey6List = Stream.of(77L, 55L, 63L, 93L, 66L, 90L, 88L, 71L).collect(Collectors.toList());
      monkey7List = Stream.of(54L, 97L, 87L, 70L, 59L, 82L, 59L).collect(Collectors.toList());
   }

   public static long checkModule(long check)
   {
      if (check > part2Modulo)
         return check % part2Modulo;
      return check;
   }

   public static void main(String[] args) throws IOException
   {
//      FileReader fr = new FileReader("day11input.txt");
//      BufferedReader buffer = new BufferedReader(fr);
      initialiseActualItems();
      //initialiseExampleItems();
      for (int i = 0; i < ROUNDS; i++) {
         while (!monkey0List.isEmpty()) {
            monkey0(monkey0List.get(0));
         }
         while (!monkey1List.isEmpty()) {
            monkey1(monkey1List.get(0));
         }
         while (!monkey2List.isEmpty()) {
            monkey2(monkey2List.get(0));
         }
         while (!monkey3List.isEmpty()) {
            monkey3(monkey3List.get(0));
         }
         while (!monkey4List.isEmpty()) {
            monkey4(monkey4List.get(0));
         }
         while (!monkey5List.isEmpty()) {
            monkey5(monkey5List.get(0));
         }
         while (!monkey6List.isEmpty()) {
            monkey6(monkey6List.get(0));
         }
         while (!monkey7List.isEmpty()) {
            monkey7(monkey7List.get(0));
         }

//         System.out.println("========== \n End of round " + (i + 1));
//         System.out.println("Monkey 0 : " + monkey0List);
//         System.out.println("Monkey 1 : " + monkey1List);
//         System.out.println("Monkey 2 : " + monkey2List);
//         System.out.println("Monkey 3 : " + monkey3List);
      }
      System.out.println("Monkey 0: " + monkey0Checks);
      System.out.println("Monkey 1: " + monkey1Checks);
      System.out.println("Monkey 2: " + monkey2Checks);
      System.out.println("Monkey 3: " + monkey3Checks);
      System.out.println("Monkey 4: " + monkey4Checks);
      System.out.println("Monkey 5: " + monkey5Checks);
      System.out.println("Monkey 6: " + monkey6Checks);
      System.out.println("Monkey 7: " + monkey7Checks);
   }
}