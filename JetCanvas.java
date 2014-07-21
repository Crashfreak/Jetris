/* Programmer:  CrashFr[e]ak aka Michael Cuthbert
 * Date: Sunday 20th May 2001
 *
 * This is the actual playing panel.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.MediaTracker;
import java.awt.event.*;

public class JetCanvas extends JPanel implements KeyListener, Runnable {
   
   private int accer, level, quickDown, temptype;
   private boolean downYet;
   public boolean gaming;
   public int height;
   
   public Image oS;
   public blocks pic, nextPic;
   public GameEngine jEngine;
   MediaTracker allTheBlocks;
   Image pic1, pic2, pic3, pic4, pic5, pic6, pic7;
   private Graphics oG;
   boolean runOn, paintNow;
   Jetris App;
   backMatrix theBack;
   Thread downTime;
   
   public JetCanvas(Jetris appi) {
      super();
      App = appi;
      paintNow = false;
      runOn = false;
      downYet = false;
      accer = 500;
      quickDown = 500;
      level = 1; 
      //sets general needed information
      
      allTheBlocks = new MediaTracker(this);
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      pic1 = toolkit.getImage("images/blueBlock.gif");
      pic2 = toolkit.getImage("images/purpleblock.gif");
      pic3 = toolkit.getImage("images/redblock.gif");
      pic4 = toolkit.getImage("images/redpurpleblock.gif");
      pic5 = toolkit.getImage("images/squareblock.gif");
      pic6 = toolkit.getImage("images/yellowblock.gif");
      pic7 = toolkit.getImage("images/black.gif");
      allTheBlocks.addImage(pic1, 0);
      allTheBlocks.addImage(pic2, 1);
      allTheBlocks.addImage(pic3, 2);
      allTheBlocks.addImage(pic4, 3);
      allTheBlocks.addImage(pic5, 4);
      allTheBlocks.addImage(pic6, 5);
      allTheBlocks.addImage(pic7, 6);

      setSize(new Dimension(300, 400));
      setOpaque(true);
      setBackground(Color.black);
      //initiates the black background canvas
      
      grabFocus();
      jEngine = new GameEngine(this);
      theBack = new backMatrix(this);
      theBack.makeBlank();
      //creates the game engine and grabs the focus of the keyboard
   }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics newG = g;
      g.setColor(Color.black);
      jEngine.paint(g, this, theBack);
      App.topSideRightLayer.repaint();
      if (paintNow && !App.gameOn) 
         PaintGameOver(g);
      //paints the black canvas 
   }
   
   public void update(Graphics g) {
      if (oS == null) {
         oS = createImage(300, 400);
         oG = oS.getGraphics();
      }
      paint(oG);
      g.drawImage(oS, 0, 0, this);
      jEngine.paint(g, this, theBack);
      App.topSideRightLayer.repaint();
      //updates the painting of the canvas
   }
   
   public void PaintGameOver(Graphics g) {
      g.setColor(Color.red);
      Polygon G = new Polygon();
      
   }
   
   public void startDown() {
      downTime = new Thread(this);
      gaming = true;
      grabFocus();
      downTime.start();
      //starts the game thread
   }
   
   public void setAccer(int sA) {
      accer = sA;
   } //sets the accerleration of the blocks coming down
   
   public int getAccer() {
      return accer;
   } //returns the accerlaration to the user
   
   public blocks getNewBlock() {
      blocks tempBLOCK = null;
      int totalWeight = 7;
      String dBlo = "";
      double d = Math.random() * totalWeight;
      int r = ((int) Math.floor( d )) + 1;
      //gets random number between 1 and 7
      if (r == 1) { 
         dBlo = "longBlock"; temptype = blocks.longBLOCK; 
         tempBLOCK = new blocks(pic6, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 2) { 
         dBlo = "LShapedBlock"; temptype = blocks.lshapedBLOCK; 
         tempBLOCK = new blocks(pic1, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 3) { 
         dBlo = "STypeBlock"; temptype = blocks.stypeBLOCK; 
         tempBLOCK = new blocks(pic4, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 4) { 
         dBlo = "squareBlock"; temptype = blocks.squareBLOCK; 
         tempBLOCK = new blocks(pic4, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 5) { 
         dBlo = "MissEBlock"; temptype = blocks.misseBLOCK; 
         tempBLOCK = new blocks(pic3, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 6) { 
         dBlo = "STypeBlock2"; temptype = blocks.stypeBLOCK2; 
         tempBLOCK = new blocks(pic5, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      } else if (r == 7) { 
         dBlo = "LShapedBlock2"; temptype = blocks.lshapedBLOCK2; 
         tempBLOCK = new blocks(pic2, temptype, this);
         tempBLOCK.posX = 7; tempBLOCK.posY = 0;
      }
      //pic.type = blocks.longBLOCK;
      //sets the correct image for the random number. ie. for the blocks coming down
      return tempBLOCK;
   }
   
   public void run() { //the main game thread
      try { 
         allTheBlocks.waitForAll();
      } catch (InterruptedException e) {
         return;
      }
      pic = getNewBlock();
      while (App.gameOn) {
         runOn = true;
         nextPic = getNewBlock();
         setAccer(quickDown); //sets the accerlaration of the block
         pic.makeBlock(theBack, pic.posX, pic.posY);
         while (runOn) {
            if (pic.isCollidingDown(theBack) || pic.isCollidingLeft(theBack) 
                                             || pic.isCollidingRight(theBack)) 
               runOn = false;
            else {
               pic.moveBlockDown(theBack);
               repaint(); //repaints the canvas, ie. it goes down 20pixels
            }
            try {
               Thread.sleep(getAccer()); //sleeps for the set amount of time
               while (!gaming)
                  wait();
               gaming = true;
            } catch (InterruptedException e) {}
            if (pic.posY + pic.getBlockHeight() >= 20) 
               runOn = false;
            //just a check for the block hitting the bottom
            if (pic.posY == 0) {
               App.gameOn = false;
               paintNow = true;
               downTime.destroy();
            }
         }
         int rows = theBack.checkForRow();
         rows = rows * (rows+20);
         downYet = false; //checks to see if the block has hit the bottom yet
         App.Score += 5;
         App.Score += rows;
         pic = nextPic;
      }
   } 
      
   public void keyReleased(KeyEvent kE) {
   }
   
   public void keyPressed(KeyEvent kE) {
      
      if (App.gameOn) {
      
      if (kE.getKeyCode() == KeyEvent.VK_RIGHT ||
          kE.getKeyCode() == KeyEvent.VK_KP_RIGHT) {  
             if (pic.posX + pic.getRightLength() < 16)
               if (!pic.isCollidingRight(theBack)) pic.moveBlockRight(theBack);
             repaint();
      } else if (kE.getKeyCode() == KeyEvent.VK_LEFT ||
                 kE.getKeyCode() == KeyEvent.VK_KP_LEFT) {
                    if (pic.posX + pic.getLeftLength() > 3) 
                       if (!pic.isCollidingRight(theBack)) pic.moveBlockLeft(theBack);
                    repaint();
      } else if (kE.getKeyCode() == KeyEvent.VK_DOWN ||
                 kE.getKeyCode() == KeyEvent.VK_KP_DOWN) {
                       pic.rotateBlock(theBack);
      }
      if (kE.getKeyCode() == KeyEvent.VK_SPACE && !downYet) {
         quickDown = getAccer();
         setAccer(1);
         downYet = true;
      }
      
      }
   }
   
   public void keyTyped(KeyEvent kE) {
   }
   
}