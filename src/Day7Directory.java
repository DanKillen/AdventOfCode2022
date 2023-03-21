import java.util.ArrayList;

/**
 * Created by Daniel Killen on 21/03/2023
 * UPDATE COMMENTS ABOUT PROGRAM HERE
 **/
public class Day7Directory
{
   public Day7Directory root;
   public String name;
   public int size;
   public ArrayList<Day7Directory> children;

   public boolean finalSize;

   public Day7Directory(Day7Directory pRoot, String pName)
   {
      root = pRoot;
      name = pName;
      children = new ArrayList<>();
      finalSize = false;
   }

   public void addToSize(int pSize)
   {
      this.size += pSize;
   }

   public String toString()
   {
      return "Name: " + name + " Size: " + size + "\n";
   }
}