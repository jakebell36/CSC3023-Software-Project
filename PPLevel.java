//Puzzle Projecet Level class
//Written by Harrison Kairalla, Jake Bell, and Hudson Herr
import java.util.*;
import java.io.*;

public class PPLevel
{
   private String fileName; 
   private int levelData[][] = new int[40][40];
   private String nextData[] = new String[4];
   private int x;
   private int y;
   private int data;
   private int nextLoc;
   private String next;
    
   public PPLevel(String fileName_in)//Constructor with string parameter for file name
   {
      fileName = fileName_in;
      try //Try catch loop to catch fnfe
      {
         File inputFile = new File(fileName);
         Scanner readFile = new Scanner(inputFile);//scanner to read in the file
      
         for(int i = 0; i < 40; i++)//reading values into 2D array list "levelData"
         {
            for(int j = 0; j < 40; j++)
            {
               levelData[i][j] = readFile.nextInt();
            }
         }
      
         for(int i = 0; i < 4; i++)//reading values into array list "nextData"
            nextData[i] = readFile.next();
       }
       catch(FileNotFoundException fnfe)
      {
      }

   }
   
   public int getData(int x_in, int y_in)//accessor to get particulat x,y pair
   {
      x = x_in;
      y = y_in;
      data = levelData[x][y];
      return data;
   }
   
   //accessors to get next loading direction
   public String nextUp()
   {
       String up = nextData[0];
       return up;
   }
   public String nextLeft()
   {
       String left = nextData[1];
       return left;
   }
   public String nextDown()
   {
       String down = nextData[2];
       return down;
   }
   public String nextRight()
   {
       String right = nextData[3];
       return right;
   }


}
