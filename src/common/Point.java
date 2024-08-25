package common;

/**
 * Two dimensional cartesian point.
 */
public class Point
{
   public int x;
   public int y;

   public Point(int px, int py)
   {
      x = px;
      y = py;
   }

   public int getX(Point point)
   {
      return x;
   }

   public int getY(Point point)
   {
      return y;
   }
}
