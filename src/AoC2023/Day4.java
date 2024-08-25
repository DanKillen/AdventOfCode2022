package AoC2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class Day4
{
   public static void main(String[] args) throws IOException
   {
      FileReader input = new FileReader("2023day4input.txt");
      BufferedReader buffer = new BufferedReader(input);
      int[] numberofEachCard = new int[219];
      int answer = 0, gameNumber = 0;
      Long answerB = 219L;
      String cardGame;
      while ((cardGame = buffer.readLine()) != null)
      {
         int currentAnswer = 0;
         String yourNumbers = cardGame.substring(cardGame.indexOf(':'), cardGame.indexOf('|'));
         String winningNumbers = cardGame.substring(cardGame.indexOf('|'));
         int[] yourNumbersInt = new int[10];
         for (int i = 0, k = 2; i < 10; i++, k = k + 3)
         {
            yourNumbersInt[i] = Integer.parseInt(yourNumbers.substring(k, k + 2).replaceAll(" ",""));
         }
         int[] winningNumbersInt = new int[25];
         for (int i = 0, k = 2; i < 25; i++, k = k + 3)
         {
            winningNumbersInt[i] = Integer.parseInt(winningNumbers.substring(k, k + 2).replaceAll(" ",""));
         }
         currentAnswer += workOutScore(yourNumbersInt,winningNumbersInt);
         answer += currentAnswer;
         for (int i = -1; i < numberofEachCard[gameNumber];i++)
         {
            workOutScorePart2(gameNumber, currentAnswer, numberofEachCard);
         }
         gameNumber++;
      }
      for (int i = 0; i < numberofEachCard.length; i++)
      {
         answerB += numberofEachCard[i];
      }
      System.out.println(answer);
      System.out.println(answerB);
   }

   public static int workOutScore(int[] numbersToCheck, int[] winningNumbers)
   {
      int totalScore = 0;
      for (int i = 0; i < numbersToCheck.length; i++)
      {
         for (int k = 0; k < winningNumbers.length; k++)
         {
            if (numbersToCheck[i] == winningNumbers[k])
               totalScore++;
         }
      }
      return totalScore;
   }

   public static void workOutScorePart2(int currentCard, int score, int[]numberOfCardsPerGame)
   {  if (score > 0)
      {
         for (int i = 1; i <= score; i++)
         {
            numberOfCardsPerGame[currentCard + i] += 1;
         }
      }
   }
}

