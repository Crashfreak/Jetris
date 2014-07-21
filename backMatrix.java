/* Programmer: CrashFr[e]ak aka Michael Cuthbert
 * Date 31/05/2001
 *
 * This is the class the basically holds all the blocks where and when they
 * collide.
 */

import java.awt.*;
import java.awt.image.*;

public class backMatrix {
   
   public blocks backboard[][];
   public int backWidth, backHeight;
   JetCanvas appi;
   
   public backMatrix(JetCanvas app) {
      appi = app;
      backboard = new blocks[16][20];
      backWidth = 20;
      backHeight = 16;
      makeBlank();
   } //default constructor will create a 20X15 matrix for tetris playng area
   
   public backMatrix(JetCanvas app, int height, int width) {
      appi = app;
      backWidth = width/20;
      backHeight = height/20;
      backboard = new blocks[backHeight][backWidth];
   } //lets you create your own sized matrix, 20X20 blocks 
     //IE. a 400X300 pixel playing area will produce a 20X15 matrix
   
   public void makeBlank() {
      for (int i = 0; i < backHeight; i++) 
         for (int j = 0; j < backWidth; j++) 
            backboard[i][j] = new blocks(null, blocks.emptyBLOCK, appi);
   }  //simply empties the matrix
   
   public void drawBack(Graphics g, ImageObserver imob) {
      for (int i = 0; i < backHeight; i++) {
         for (int j = 0; j < backWidth; j++) {
            if (backboard[i][j].type == blocks.emptyBLOCK) {
               g.drawImage(appi.pic7, i*20, j*20, imob);
            } else {
               g.drawImage(backboard[i][j].block, i*20, j*20, imob);
            }
         }
      }
      //g.drawImage(appi.pic2, 20, 20, imob);
   } //draws the matrix blocks onto the screen.
   
   public int checkForRow() {
      int NoOfRows = 0;
      for (int i = 0; i < backWidth; i++) 
         if (checkForRow(i))
            NoOfRows++;
      return NoOfRows;
   }
   
   private boolean checkForRow(int row) {
      int rowCount = 0;
      boolean rowTrue = false;
      for (int j = 0; j < backHeight; j++) {
         if (backboard[j][row].type != blocks.emptyBLOCK)
            rowCount++;
      }
      if (rowCount > 15) {
         deleteRow(row);
         rowTrue = true;
      }
      return rowTrue;
   }
   
   private void deleteRow(int rowNo) {
      for (int i = 0; i < backHeight; i++)
         backboard[i][rowNo] = new blocks(null, blocks.emptyBLOCK, appi); 
      MoveAllDown(rowNo);
   } //deletes a specified row
   
   private void MoveAllDown(int rowNo) {
      for (int i = rowNo; i > -1; i--) {
         for (int j = 0; j < backHeight; j++) {
            if (backboard[j][i].type != blocks.emptyBLOCK) {
               insertIntoMatrix(backboard[j][i], j, i+1);
               deleteFromMatrix(j, i);
            }
         }
      }
   }
   
   public void insertIntoMatrix(blocks newB, int height, int width) {
      backboard[height][width] = newB;
   }  //inserts a block into a specified place in the matrix
   
   public void deleteFromMatrix(int height, int width) {
      backboard[height][width] = new blocks(null, blocks.emptyBLOCK, appi);
   }  //deletes a block from a specified place in the matrix
   
}
