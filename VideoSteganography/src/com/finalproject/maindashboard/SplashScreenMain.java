/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.maindashboard; 

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SplashScreenMain {

  SplashScreen screen;

  public SplashScreenMain() {
    // initialize the splash screen
    splashScreenInit();
    // do something here to simulate the program doing something that
    // is time consuming
    for (int i = 0; i <= 500; i++)
    {
      for (long j=0; j<20000; ++j)
      {
        String poop = " " + (j + i);
      }
      // run either of these two -- not both
      screen.setProgress("LAUNCHING " + i, i);  // progress bar with a message
      //screen.setProgress(i);           // progress bar with no message
    }
    splashScreenDestruct(); 
    JFrame frame = new JFrame("VIDEO STEGANOGRAPHY");
          frame.setSize(700, 450);
          frame.setResizable(false);
          frame.setLocationRelativeTo(null);
         frame.add(new SteganographyPanel() );
         frame.setVisible(true);
    screen.dispose(); 
  }

  private void splashScreenDestruct() {
    screen.setScreenVisible(false);
  }

  private void splashScreenInit() {
    ImageIcon myImage = new ImageIcon(com.finalproject.maindashboard.SplashScreenMain.class.getResource("/resources/splash.png"));
    screen = new SplashScreen(myImage);
    screen.setLocationRelativeTo(null);
    screen.setProgressMax(100);
    screen.setScreenVisible(true);
  }

  public static void main(String[] args)
  {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    new SplashScreenMain();
  }

}
