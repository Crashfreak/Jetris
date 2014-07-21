package crashfreak;
/* Programmer: CrashFr[e]ak aka Michael Cuthbert
 * Date: 29/05/01
 *
 * This is the game engine that controls all the animation and images on
 * the screen
 */

import java.awt.*;
import java.awt.image.*;
import java.awt.image.MemoryImageSource;
import java.applet.*;
import java.awt.geom.*;

public class GameEngine {
   
   int width, height, x, y; //image information for the block
   int BoundWidth, BoundHeight; //boundaries for the sprites
   public Image Dbuffer; //used for double buffering
   Graphics pad;
   Component Parent; //Just so that I can use variables that I want in the Parent class
   
   public GameEngine(Component c) {
      BoundWidth = 0;
      BoundHeight = 0;
      Parent = c;
   } //default constructor
   
   public void rotateMOB(blocks toRot, int x, int y, int wdth, int hgt) {
      //rotates the block 90 degrees
      
   } // TODO : Fix this it isn't working
   
   public boolean detectCollision(blocks dBloc) {
      //This is a object collision detection method
      boolean contact = false;
      return contact;
   } // TODO : Create this method
   
   public void paint(Graphics g, ImageObserver imob, backMatrix bM) {
      
      Dbuffer = Parent.createImage(Parent.getSize().width, Parent.getSize().height);
      pad = Dbuffer.getGraphics(); 
      //creates the offscreen buffer
      pad.setColor(Parent.getBackground());
      pad.fillRect(0, 0, Parent.getWidth(), Parent.getHeight());
      //makes the background black

      bM.drawBack(pad, imob);

      g.drawImage(Dbuffer, 0, 0, imob); //draws the offscreen buffer to the screen
   }
}