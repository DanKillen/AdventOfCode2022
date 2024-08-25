package AoC2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Daniel Killen on 21/03/2023
 * The filesystem consists of a tree of files (plain data) and directories (which can contain other directories or
 * files). The outermost directory is called /. You can navigate around the filesystem, moving into or out of
 * directories and listing the contents of the directory you're currently in.
 * Within the terminal output, lines that begin with $ are commands you executed, very much like some modern computers:
 * cd means change directory. This changes which directory is the current directory, but the specific result depends on
 * the argument:
 * * cd x moves in one level: it looks in the current directory for the directory named x and makes it the current
 * directory.
 * cd .. moves out one level: it finds the directory that contains the current directory, then makes that directory
 * the current directory.
 * cd / switches the current directory to the outermost directory, /.
 * ls means list. It prints out all of the files and directories immediately contained by the current directory:
 * 123 abc means that the current directory contains a file named abc with size 123.
 * dir xyz means that the current directory contains a directory named xyz.
 **/
public class Day7 {
   static HashMap<String, Day7Directory> directoryMap = new HashMap<>();

   public static void readDisk(BufferedReader pBuffer) throws IOException {
      Day7Directory dir = new Day7Directory(null, "/");
      directoryMap.put("/", dir);
      String disk = pBuffer.readLine();
      Day7Directory child;
      while (disk != null) {
         if (Character.isDigit(disk.charAt(0))) {
            int endOfNumber = 1;
            for (int j = 0; disk.charAt(j) != ' '; j++) {
               endOfNumber = j;
            }
            int size = Integer.parseInt(disk.substring(0, endOfNumber + 1));
            if (dir == null)
            {
               dir = directoryMap.get("/");
            }
            dir.addToSize(size);
            disk = pBuffer.readLine();
         } else if (disk.startsWith("dir")) {
            child = new Day7Directory(dir, disk.substring(4));
            if (dir == null)
            {
               dir = directoryMap.get("/");
            }
            dir.children.add(child);
            String pathname = dir.name + "/" + child.name;
            directoryMap.put(pathname, child);
            disk = pBuffer.readLine();
         } else if (disk.startsWith("$ ls")) {
            disk = pBuffer.readLine();
         } else if (disk.startsWith("$ cd ..")) {
            String pathname;
            if (dir.root == null || dir.root.root == null)
            {
               pathname = "/";
            }
            else
            {
               pathname = dir.root.root.name + "/" + dir.root.name;
            }
            dir = directoryMap.get(pathname);
            disk = pBuffer.readLine();
         } else if (disk.startsWith("$ cd ")) {
            if (dir.name.equals("/"))
               System.out.print("/");
            String pathname = dir.name + "/" + disk.substring(5);
            dir = directoryMap.get(pathname);
            disk = pBuffer.readLine();
         }
      }
   }

   public static void workOutSizes(Day7Directory check) {
      if (!check.finalSize) {
         for (Day7Directory child : check.children) {
            if (!child.finalSize) {
               workOutSizes(child);
            }
         }
         for (Day7Directory child : check.children) {
            check.addToSize(child.size);
         }
         check.finalSize = true;
      }
   }

   public static void main(String[] args) throws IOException {
      FileReader input = new FileReader("day7input.txt");
      BufferedReader buffer = new BufferedReader(input);
      readDisk(buffer);
      workOutSizes(directoryMap.get("/"));

      int total_size = 0;

      for (Day7Directory dir : directoryMap.values()) {
         if (dir.size <= 100000) {
            total_size += dir.size;
         }
      }
      System.out.println(directoryMap.values());
      System.out.println(total_size);

      System.out.println("PART TWO");
      for (Day7Directory dir : directoryMap.values()) {
         if (dir.size >= 2558312 && dir.size <= 2599912) {
            System.out.println(dir.size);
         }
      }
   }
}