/*Programmer: CrashFr[e]ak aka Michael Cuthbert
 *Date: 13/10/00
 * 
 * I'm just pumping out another Tetris clone, no difference to the original whatsoever
 * just need to know that I can do it.
 *
 * This class is just to build the interface
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Jetris extends JFrame {
   
  protected JMenuBar entirty;
  public JetCanvas topSideLeftLayer;
  public sideCanvas topSideRightLayer;
  protected Thread gameTime;
  protected int Score;
  protected int level;
  public boolean gameOn, SheetUp;
  
  public Jetris() {
     
    super("Jetris"); 
     
    Score = 0;
    level = 0;
    SheetUp = false;
    gameOn = false;
    gameTime = null;
     
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());	    
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch(Exception e) { System.out.println("Error: " + e); }
     
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent wE) {
         System.exit(0);
      }
    });
        
     
    entirty = makeMenuSystem();
    setJMenuBar(entirty);
    setContentPane(makeContentPane());
    getContentPane();
  }
  
  private Container makeContentPane() {
    JPanel bottomLayer = new JPanel();
    bottomLayer.setLayout(new BoxLayout(bottomLayer, BoxLayout.X_AXIS));
    
    topSideLeftLayer = new JetCanvas(this);
    topSideLeftLayer.addKeyListener(topSideLeftLayer);
    topSideLeftLayer.setLayout(null);
    topSideLeftLayer.setBackground(Color.black);
    topSideLeftLayer.setPreferredSize(new Dimension(300, 400)); 
    Border lowered = BorderFactory.createLoweredBevelBorder();
    topSideLeftLayer.setBorder(lowered);
    
    topSideRightLayer = new sideCanvas(this);
    topSideRightLayer.setEnabled(false);
    topSideRightLayer.setPreferredSize(new Dimension(150, 400));
    
    bottomLayer.add(topSideLeftLayer);
    bottomLayer.add(topSideRightLayer);
    return bottomLayer;
  }
  
  private JMenuBar makeMenuSystem() { 
     
    String[] mMenus = { "File", "Options", "About" };
    String[] sMenus1 = { "New Game", "HighScores", "Exit" };
    String[] sMenus2 = { "Restart", "Pause" };
    String[] sMenus3 = { "About", "Help" };
    
    JMenuBar theMenu = new JMenuBar();
    JMenu[] tM = new JMenu[3];
    tM[0] = new JMenu(mMenus[0]);
    tM[1] = new JMenu(mMenus[1]);
    tM[2] = new JMenu(mMenus[2]);
    for (int i = 0; i < sMenus1.length; i++) {
       JMenuItem temp = new JMenuItem(sMenus1[i]);
       temp.setActionCommand(sMenus1[i]);
       temp.addActionListener(new menuController(this));
       tM[0].add(temp);
       if (i == 1) tM[0].addSeparator();
    }
    for (int i = 0; i < sMenus2.length; i++) {
       if (i == 1) {
          JCheckBoxMenuItem temp = new JCheckBoxMenuItem(sMenus2[i]);
          temp.setActionCommand(sMenus2[i]);
          temp.addActionListener(new menuController(this));
          tM[1].add(temp);
       } else {
          JMenuItem temp = new JMenuItem(sMenus2[i]);
          temp.setActionCommand(sMenus2[i]);
          temp.addActionListener(new menuController(this));
          tM[1].add(temp);
       }
    }
    
    for (int i = 0; i < sMenus3.length; i++) {
       JMenuItem temp = new JMenuItem(sMenus3[i]);
       temp.setActionCommand(sMenus3[i]);
       temp.addActionListener(new menuController(this));
       tM[2].add(temp);
    }
    
    for (int i = 0; i < mMenus.length; i++) 
       theMenu.add(tM[i]);
    
    return theMenu;
  }
  
  private void loading() {
    JWindow startup = new JWindow();
  }
  
  public static void main(String [] args) {
    Jetris newGame = new Jetris();
    
    newGame.pack();
    newGame.setResizable(false);
    newGame.setBounds(50, 50, 500, 450);
    newGame.show();
  }
  
  public void startGame() {
    Score = 0;
    level = 0;
    gameOn = true;
    topSideLeftLayer.startDown();
    topSideLeftLayer.theBack.makeBlank();
  }
  
  public void pauseGame() {
      //topSideLeftLayer.gaming = false;
  }
  
  public void continueGame() {
     //topSideLeftLayer.gaming = true;
  }
}