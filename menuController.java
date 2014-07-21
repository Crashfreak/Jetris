/* Programmer: CrashFr[e]ak aka Michael Cuthbert
 * Date: Sunday 20th May 2001
 *
 * This is to control the Menu System.
 */

import java.awt.event.*;
import javax.swing.*;

public class menuController implements ActionListener {
   
   protected Jetris Jayris;
   public String command;
   
   public menuController(Jetris jV) {
      Jayris = jV;
   }//default constructor
   
   public void actionPerformed(ActionEvent aE) {
   //----------------------------------------------------------------------//
   // This action listener will mainly only pick up the menu controls, so  //
   // when you click on New Game or Exit the control will come here and    //
   // this bit of code will tell it what to do next                        //
   //----------------------------------------------------------------------//
      
      command = aE.getActionCommand();
      if (command.equals("Exit")) {
         System.exit(0);
      }
      
      else if (command.equals("New Game")) {
         Jayris.startGame();
      }
      
      else if (command.equals("Pause")) {
         JCheckBoxMenuItem source = (JCheckBoxMenuItem)(aE.getSource());
         if (source.getState()) 
            Jayris.pauseGame();
         else 
            Jayris.continueGame();
      }
      
      else if (command.equals("HighScores")) {
         HScores HS = new HScores(Jayris, "NA");
         HS.setBounds(60, 60, 400, 300);
         HS.setResizable(false);
         HS.pack();
         HS.show();
         Jayris.setEnabled(false);
         Jayris.SheetUp = true;
      }
      
      else if (command.equals("Restart")) { 
         Jayris.startGame();
      }
      
   }
   
   private void writeToHSSheet(String file) {
   }
}
