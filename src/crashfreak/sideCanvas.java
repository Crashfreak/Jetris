package crashfreak;
/* Programmer: CrashFr[e]ak aka Michael Cuthbert
 * Date: 03/06/2001
 * 
 * This is a very small JPanel class that holds the righthandside JPanel.
 * In this Panel is the Following:
 * 1. Your Score
 * 2. The current Top Scorer
 * 3. The next block that is going to be coming down
 * 4. A Play and Pause button
 */

import java.awt.*;
import javax.swing.*;

public class sideCanvas extends JPanel {
   
   private Jetris appi;
   private Image pic1, pic2, pic3, pic4, pic5, pic6, pic7, back;
   private Image dBuffer;
   private Graphics Pad;
   
   public sideCanvas(Jetris app) {
      appi = app;
      loadImages();
   }
   
   public void loadImages() {
      Toolkit tK = Toolkit.getDefaultToolkit();
      back = tK.getImage("images/sideBack.gif");
      pic1 = tK.getImage("images/longBlock.gif");
      pic2 = tK.getImage("images/LShapedBlock.gif");
      pic3 = tK.getImage("images/LShapedBlock2.gif");
      pic4 = tK.getImage("images/squareBlock.gif");
      pic5 = tK.getImage("images/STypeBlock.gif");
      pic6 = tK.getImage("images/STypeBlock2.gif");
      pic7 = tK.getImage("images/MissEBlock.gif");
      
   }
   
   public void paintComponent(Graphics g) {
      g.setColor(Color.black);
      g.fillRect(0, 0, 250, 450);
      
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image backI = tk.getImage("images/sideBack.gif");
      dBuffer = createImage(250, 450);
      Pad = dBuffer.getGraphics();
      Pad.drawImage(backI, 0, 0, this);
      g.drawImage(dBuffer, 0, 0, this); 
      g.drawString("" + appi.Score, 80, 60);
      blocks tempB = appi.topSideLeftLayer.nextPic;
      if (tempB != null) {
         if (tempB.type == blocks.longBLOCK) 
            g.drawImage(pic1, 50, 100, this);
         else if (tempB.type == blocks.lshapedBLOCK)
            g.drawImage(pic2, 50, 100, this);
         else if (tempB.type == blocks.lshapedBLOCK2)
            g.drawImage(pic3, 50, 100, this);
         else if (tempB.type == blocks.squareBLOCK)
            g.drawImage(pic4, 50, 100, this);
         else if (tempB.type == blocks.stypeBLOCK)
            g.drawImage(pic6, 50, 100, this);
         else if (tempB.type == blocks.stypeBLOCK2)
            g.drawImage(pic5, 50, 100, this);
         else if (tempB.type == blocks.misseBLOCK)
            g.drawImage(pic7, 50, 100, this);
      }
   }

   public void update(Graphics g) {
      g.drawString("" + appi.Score, 80, 60);
   }
}