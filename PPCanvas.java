//Puzzle Project Canvas
//Written by Harrison Kairalla, Jake Bell, and Hudson Herr
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import java.util.*;
import java.net.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.scene.image.*;
import javafx.scene.control.*;

public class PPCanvas extends Canvas
{
   //instantiate graphics context "gc"
   GraphicsContext gc = getGraphicsContext2D();
   
   //x and y vars for moving zack
   int x;
   int y;
   
   PPLevel level;
    
   private String fileName = "test.txt";//starting file name for program
   
   private String levelName = fileName;//instantiate level name
      
   public PPCanvas()   
   {
      level = new PPLevel(levelName);

      setWidth(500);//set width
      setHeight(500);//set heigth
      draw(gc);//run draw method
      
      //x and y variables for player
      x = 100;
      y = 100;
      
      //Set up event handler
      setOnKeyPressed(new KeyHandler());
      
      draw(gc);
   }
   
   public void draw(GraphicsContext gc)//method to draw the level
   {      
      for(int i=0; i<10; i++)
      {
         for(int j=0; j<10; j++)
         {
            if(level.getData(i,j) == 0)//if value is 0 draw white square at i,j
            {
               gc.setFill(Color.WHITE);
               gc.fillRect(j*50.0, i*50.0, 50, 50);  
            }
            if(level.getData(i,j)==1)//if value is 1 draw black square at i,j
            {
               gc.setFill(Color.BLACK);
               gc.fillRect(j*50.0, i*50.0, 50, 50);  
            }
         }
      }
      
      gc.setFill(Color.YELLOW);
      gc.fillRect(x, y, 50, 50);
   }

   public class KeyHandler implements EventHandler<KeyEvent>
   {
      public void handle(KeyEvent event)
      {
         if(event.getCode() == KeyCode.UP)//if up key is pressed
         {
            y=y-10; //move square up by subtracting y coordinate by 3
         
            if(y<5)
            {
               String upCheck = level.nextUp();
            
               if(upCheck.equals("NONE"))
               {
                  y=5;
               }
               /*else
               {
                  fileName = level.nextUp();
                  y=495;
                  level = new LAB7Level(fileName);
               }*/
            }
         }
      
         if(event.getCode() == KeyCode.LEFT)//if left key is pressed
         {
            x=x-10; //move square left by subtracting x coordinate by 3
         
            if(x<5)
            {
               String leftCheck = level.nextLeft();
            
               if(leftCheck.equals("NONE"))
               {
                  x=5;
               }
              /* else
              {
                  fileName = level.nextLeft();
                  x=350;
                  level = new LAB7Level(fileName);
               }*/
            }
         }
      
         if(event.getCode() == KeyCode.DOWN)//if down key is pressed
         {
            y=y+10; //move square down by adding y coordinate by 3
         
            if(y>450)
            {
               String downCheck = level.nextDown();
            
               if(downCheck.equals("NONE"))
               {
                  y=450;
               }
               /*else
               {
                  fileName = level.nextDown();
                  y=50;
                  level = new LAB7Level(fileName);
               }*/
            }
         }
      
         if(event.getCode() == KeyCode.RIGHT)//if right key is pressed
         {
            x=x+10; //move square down by adding y coordinate by 3
         
            if(x>450)
            {
               String rightCheck = level.nextRight();
            
               if(rightCheck.equals("NONE"))
               {
                  x=450;
               }
               /*else
               {
                  fileName = level.nextRight();
                  x=50;
                  level = new LAB7Level(fileName);
               }*/
            }
         }
      
      draw(gc);
      }
      
      
   }


}
