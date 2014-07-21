package crashfreak;
/* Programmer: CrashFr[e]ak aka Michael Cuthbert
 * Date: Sunday 20th May 2001
 *
 * This is the class that controls and draws the blocks for the tetris game
    * NB* This is were the image problem lies 
    *     work on this class
    * the problem lies in the numbers.
    * Compile and run it and you will see what I mean.
 */

import java.awt.*;
import java.awt.image.*;
import java.net.*;

public class blocks {
   //This is a small class that holds the block that will come down the canvas
   
   public static final int longBLOCK = 0;
   public static final int lshapedBLOCK = 1;
   public static final int stypeBLOCK = 2;
   public static final int squareBLOCK = 3;
   public static final int lshapedBLOCK2 = 4;
   public static final int stypeBLOCK2 = 5;
   public static final int misseBLOCK = 6;
   public static final int emptyBLOCK = 7;
   //final values for easy access to figure out what type of block it is
   
   public static final int UP = 0;
   public static final int RIGHT = 1;
   public static final int DOWN = 2;
   public static final int LEFT = 3;
   //final values to check what position the block is in
   
   public Image block;
   public int type;
   public int posX, posY;
   public int currentPos;
   protected JetCanvas app;
   //integer values for the image and co-ordinates of the block
   
   public blocks(Image bT, int blockType, JetCanvas blk) {
      block = bT;
      type = blockType;
      currentPos = blocks.LEFT;
      app = blk;
   } //default constructor
   
   public int getBlockHeight() {
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) 
            return 1;
         else if (currentPos == blocks.DOWN || currentPos == blocks.UP)
            return 3;
      } else if (type == blocks.lshapedBLOCK || type == blocks.lshapedBLOCK2 || type == blocks.misseBLOCK)  {
         if (currentPos == blocks.LEFT || currentPos == blocks.DOWN || currentPos == blocks.UP)
            return 2;
         else if (currentPos == blocks.RIGHT)
            return 1;
      } else if (type == blocks.squareBLOCK) {
         return 2;
      } else if (type == blocks.stypeBLOCK || type == blocks.stypeBLOCK2) {
         return 2;
      }
      return 2;
   }
   
   public int getRightLength() {
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) 
            return 3;
         else if (currentPos == blocks.DOWN || currentPos == blocks.UP)
            return 1;
      } else if (type == blocks.lshapedBLOCK || type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT || currentPos == blocks.DOWN) 
            return 2;
         else if (currentPos == blocks.UP) 
            return 1;
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT || currentPos == blocks.DOWN)
            return 2;
         else if (currentPos == blocks.UP) 
            return 1;
      } else if (type == blocks.squareBLOCK) {
         return 2;
      } else if (type == blocks.stypeBLOCK || type == blocks.stypeBLOCK2) {
         if (type == blocks.stypeBLOCK2 && (currentPos == blocks.UP || currentPos == blocks.DOWN))
            return 1;
         else
            return 2;
      }
      return 3;
   }
   
   public int getLeftLength() {
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) 
            return 2;
         else if (currentPos == blocks.DOWN || currentPos == blocks.UP)
            return 3;
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.DOWN)
            return 3;
         else
            return 2;
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.DOWN)
            return 3;
         else
            return 2; 
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.DOWN) 
            return 3;
         else
            return 2;
      } else if (type == blocks.squareBLOCK) {
         return 3;
      } else if (type == blocks.stypeBLOCK || type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            if (type == blocks.stypeBLOCK2) 
               return 2;
            else if (type == blocks.stypeBLOCK)
               return 3;
         }
         else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT)
            return 2;
      }
      return 2;
   }
   
   public void makeBlock(backMatrix putIn, int x, int y) {
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x+2, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x, y+2);
         }
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.LEFT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x-1, y+1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
         } else if (currentPos == blocks.UP) {
            putIn.insertIntoMatrix(this, x-1, y-1);
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
         } else if (currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x+1, y-1);
         } else if (currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x+1, y+1);
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.LEFT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x+1, y+1);
         } else if (currentPos == blocks.UP) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x-1, y+1);
         } else if (currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y-1);
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
         } else if (currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x+1, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.LEFT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x, y+1);
         } else if (currentPos == blocks.UP) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x-1, y);
         } else if (currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x, y-1);
         } else if (currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x, y+1);
         }
      } else if (type == blocks.squareBLOCK) {
         putIn.insertIntoMatrix(this, x, y);
         putIn.insertIntoMatrix(this, x+1, y);
         putIn.insertIntoMatrix(this, x, y+1);
         putIn.insertIntoMatrix(this, x+1, y+1);
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y+1);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x+1, y);
            putIn.insertIntoMatrix(this, x+1, y+1);
         }
      } else if (type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x, y+1);
            putIn.insertIntoMatrix(this, x+1, y+1);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            putIn.insertIntoMatrix(this, x, y-1);
            putIn.insertIntoMatrix(this, x, y);
            putIn.insertIntoMatrix(this, x-1, y);
            putIn.insertIntoMatrix(this, x-1, y+1);
         }
      }
   }
   
   public void moveBlockDown(backMatrix bM) {
      int x = posX;
      int y = posY;
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x+2, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.insertIntoMatrix(this, x, y+3);
         }
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x-1, y-1);
            bM.deleteFromMatrix(x, y-1);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y-1);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x, y+1);
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y-1);
            makeBlock(bM, x, y+1);
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         }
      } else if (type == blocks.squareBLOCK) {
         bM.deleteFromMatrix(x, y);
         bM.deleteFromMatrix(x+1, y);
         makeBlock(bM, x, y+1);
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x, y+1);
         }
      } else if (type == blocks.stypeBLOCK2) {
          if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x, y+1);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            makeBlock(bM, x, y+1);
         }
      }
      posY++;
   }
   
   public void moveBlockRight(backMatrix bM) { 
      int x = posX;
      int y = posY;
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y);
            bM.insertIntoMatrix(this, x+3, y);
         } else if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            bM.deleteFromMatrix(x, y+2);
            makeBlock(bM, x+1, y);
         }
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x-1, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x+1, y-1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y-1);
            bM.deleteFromMatrix(x-1, y);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         }
      } else if (type == blocks.squareBLOCK) {
         bM.deleteFromMatrix(x, y);
         bM.deleteFromMatrix(x, y+1);
         makeBlock(bM, x+1, y);
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.RIGHT || currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y+1);
            bM.deleteFromMatrix(x, y);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x+1, y);
         }
      } else if (type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.RIGHT || currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x+1, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x-1, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x+1, y);
         }
      }
      posX++;
   }
   
   public void moveBlockLeft(backMatrix bM) {
      int x = posX;
      int y = posY;
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x+2, y);
            bM.insertIntoMatrix(this, x-2, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            bM.deleteFromMatrix(x, y+2);
            makeBlock(bM, x-1, y);
         }
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x+1, y-1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x-1, y);
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x-1, y-1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x+1, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.UP) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.RIGHT) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x, y+1);
            makeBlock(bM, x-1, y);
         }
      } else if (type == blocks.squareBLOCK) {
         bM.deleteFromMatrix(x+1, y);
         bM.deleteFromMatrix(x+1, y+1);
         makeBlock(bM, x-1, y);
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.RIGHT || currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x, y+1);
            bM.deleteFromMatrix(x+1, y);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x+1, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x-1, y);
         }
      } else if (type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.RIGHT || currentPos == blocks.LEFT) {
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x+1, y+1);
            makeBlock(bM, x-1, y);
         } else if (currentPos == blocks.UP || currentPos == blocks.DOWN) {
            bM.deleteFromMatrix(x, y-1);
            bM.deleteFromMatrix(x, y);
            bM.deleteFromMatrix(x-1, y+1);
            makeBlock(bM, x-1, y);
         }
      }
      posX--;
   }
   
   public void rotateBlock(backMatrix bM) {
      int x = posX;
      int y = posY;
      
      if (type == blocks.longBLOCK && (currentPos == blocks.UP || currentPos == blocks.DOWN)) {
         if (posX == 15 || posX == 14) posX = 13;
         else if (posX == 0) posX = 1;
      } else if (type == blocks.stypeBLOCK && (currentPos == blocks.UP || currentPos == blocks.DOWN)) {
         if (posX == 0) posX = 1;
      } else if (type == blocks.stypeBLOCK2 && (currentPos == blocks.DOWN || currentPos == blocks.UP)) {
         if (posX == 15) posX = 14;
      } else if ((type == blocks.lshapedBLOCK || type == blocks.lshapedBLOCK2) 
                  && (currentPos == blocks.DOWN || currentPos == blocks.UP)) {
         if (posX == 15 && currentPos == blocks.UP) posX = 14;
         else if (posX == 0 && currentPos == blocks.DOWN) posX = 1;
      } else if (type == blocks.misseBLOCK && (currentPos == blocks.UP || currentPos == blocks.DOWN)) {
         if (posX == 15 && currentPos == blocks.UP) posX = 14;
         else if (posX == 0 && currentPos == blocks.DOWN) posX = 1;
      }
      
      if (isCollidingLeft(bM) || isCollidingRight(bM))
         ; //don't do anything
      else {
         if (type == blocks.longBLOCK) {
            if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x+2, y);
            } else if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x, y+2);
            }
         } else if (type == blocks.lshapedBLOCK) {
            if (currentPos == blocks.LEFT) {
               bM.deleteFromMatrix(x-1, y+1);
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
            } else if (currentPos == blocks.UP) {
               bM.deleteFromMatrix(x-1, y-1);
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
            } else if (currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x+1, y-1);
            } else if (currentPos == blocks.DOWN) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x+1, y+1);
            }
         } else if (type == blocks.lshapedBLOCK2) {
            if (currentPos == blocks.LEFT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x+1, y+1);
            } else if (currentPos == blocks.UP) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x-1, y+1);
            } else if (currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y-1);
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
            } else if (currentPos == blocks.DOWN) {
               bM.deleteFromMatrix(x+1, y-1);
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
            }
         } else if (type == blocks.misseBLOCK) {
            if (currentPos == blocks.LEFT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x, y+1);
            } else if (currentPos == blocks.UP) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y+1);
            } else if (currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x, y-1);
            } else if (currentPos == blocks.DOWN) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x+1, y);
            }
         } else if (type == blocks.stypeBLOCK) {
            if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y+1);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
            } else if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x+1, y);
               bM.deleteFromMatrix(x+1, y+1);
            }        
         } else if (type == blocks.stypeBLOCK2) {
            if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x, y+1);
               bM.deleteFromMatrix(x+1, y+1);
            } else if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
               bM.deleteFromMatrix(x, y-1);
               bM.deleteFromMatrix(x, y);
               bM.deleteFromMatrix(x-1, y);
               bM.deleteFromMatrix(x-1, y+1);
            }
         }
      }
      if (currentPos == blocks.LEFT)
         currentPos = blocks.UP;
      else
         currentPos++; 
      x = posX;      
      makeBlock(bM, x, y);
   } 
   
   public boolean isCollidingDown(backMatrix bM) {
      int x = posX;
      int y = posY;
      int TH = y + getBlockHeight();
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            if (bM.backboard[x][TH].type != blocks.emptyBLOCK) 
               return true;
            else 
               return false;
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+2][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         }
      } else if (type == blocks.lshapedBLOCK) {
         TH--;
         if (currentPos == blocks.DOWN) {
            if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH+1].type != blocks.emptyBLOCK)
               return true;
            else 
               return false;
         } else if (currentPos == blocks.LEFT) {
            if (bM.backboard[x-1][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.RIGHT) {
            TH++;
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else 
               return false;
         } else if (currentPos == blocks.UP) {
            if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x-1][TH-1].type != blocks.emptyBLOCK) 
               return true;
            else
               return false;
         }
      } else if (type == blocks.lshapedBLOCK2) {
         TH--;
         if (currentPos == blocks.DOWN) {
            if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH-1].type != blocks.emptyBLOCK)
               return true;
            else 
               return false;
         } else if (currentPos == blocks.LEFT) {
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH+1].type != blocks.emptyBLOCK)
               return true;
            else 
               return false;
         } else if (currentPos == blocks.RIGHT) {
            TH++;
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.UP) {
            if (bM.backboard[x-1][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         }
      } else if (type == blocks.misseBLOCK) {
         TH--;
         if (currentPos == blocks.DOWN) {
            if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.LEFT) {
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.RIGHT) {
            TH++;
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.UP) {
            if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x-1][TH].type != blocks.emptyBLOCK)
               return true;
            else 
               return false;
         }
      } else if (type == blocks.squareBLOCK) {
         TH--;
         if (bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
             bM.backboard[x+1][TH+1].type != blocks.emptyBLOCK)
            return true;
         else
            return false;
      } else if (type == blocks.stypeBLOCK) {
         TH--;
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            if (bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH+1].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            if (bM.backboard[x-1][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         }
      } else if (type == blocks.stypeBLOCK2) {
         TH--;
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            if (bM.backboard[x-1][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            if (bM.backboard[x-1][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x+1][TH+1].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         }
      }
      return false;
   }
      
   public boolean isCollidingRight(backMatrix bM) {
      int x = posX;
      int y = posY;
      int TH = y + getRightLength();
      if (type == blocks.longBLOCK) {
         /*if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
            /*if (bM.backboard[x][TH].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH-1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK ||
                bM.backboard[x][TH+1].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
            if (bM.backboard[x][TH].type != blocks.emptyBLOCK)
               return true;
            else
               return false;
         }*/
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.squareBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
         }
      } else if (type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
         }
      }
      return false;
   }
      
   public boolean isCollidingLeft(backMatrix bM) {
      int x = posX;
      int y = posY;
      if (type == blocks.longBLOCK) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
         }
      } else if (type == blocks.lshapedBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.lshapedBLOCK2) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.misseBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.squareBLOCK) {
         if (currentPos == blocks.DOWN) {
         } else if (currentPos == blocks.LEFT) {
         } else if (currentPos == blocks.RIGHT) {
         } else if (currentPos == blocks.UP) {
         }
      } else if (type == blocks.stypeBLOCK) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
         }
      } else if (type == blocks.stypeBLOCK2) {
         if (currentPos == blocks.DOWN || currentPos == blocks.UP) {
         } else if (currentPos == blocks.LEFT || currentPos == blocks.RIGHT) {
         }
      }
      return false;
   }
}
