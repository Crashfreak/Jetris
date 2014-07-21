package crashfreak;
/*Programmer: CrashFr[e]ak aka Michael Cuthbert
 *Date: 27/06/00
 *
 * This is the class that creates the frame for the highscores window. 
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class HScores extends JFrame {
   
   File HScoresFile;
   String HS1, HS2, HS3, HS4, HS5, HS6, HS7, HS8, HS9, HS10;
   int hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10;
   
   public HScores(Jetris J, String data) {
      //HScoresFile = data;
      //openDataFile(HScoresFile);
      setLayout(new BorderLayout());
      JTextField heading = new JTextField();
      heading.disable();
      heading.setEditable(false);
      heading.setEnabled(false);
      heading.setForeground(Color.blue);
      heading.setText("HighScores");
      heading.setSize(300, 50);
      heading.setFont(new Font("Serif", Font.ITALIC, 32));
      JButton OK = new JButton("OK");
      OK.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent aE) {
            //J.SheetUp = false;
            dispose();
         }
      });
      add(heading, BorderLayout.NORTH);
      
      add(OK, BorderLayout.SOUTH);
      getContentPane();
   }
   
   private void openDataFile(File data) {
      BufferedReader dataFile = null;
      try {
         dataFile = new BufferedReader(new FileReader(data));
      } catch (FileNotFoundException e) {}
      StringTokenizer str;
      String oneline = "";
      try {
         while (dataFile != null)
            oneline += dataFile.readLine();
      } catch (IOException e) {
      }
   }
}
