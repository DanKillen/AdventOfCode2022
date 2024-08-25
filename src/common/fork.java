package common;

import java.util.Objects;

/**
 * Created by DanKillen on 26/12/2022
 * Find the top three Elves carrying the most Calories.
 * How many Calories are those Elves carrying in total?
 **/
public class fork
{
   String name;
   public String[] directions = new String[2];

   public fork(String pName, String left, String right)
   {
      name = pName;
      directions[0] = left;
      directions[1] = right;
   }


   public String getName()
   {
      return this.name;
   }

   public String goLeft(fork fork)
   {
      return fork.directions[0];
   }

   public String goRight(fork fork)
   {
      return fork.directions[1];
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      fork other = (fork) obj;
      return name.equals(other.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }

   @Override
   public String toString()
   {
      return name + " = (" + directions[0] + ", " + directions[1] + ")";
   }
}
