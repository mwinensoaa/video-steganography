/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.maindashboard; 
  
import java.awt.*;
import javax.swing.*;
  
public class Splash_Screen extends JWindow
{
    public Splash_Screen(int time)
{
    ImageIcon ii;
        ii = new ImageIcon("resources/logo.png");
JScrollPane jsp = new JScrollPane(new JLabel(ii));
getContentPane().add(jsp);
setSize(315,210);
centerScreen();
setVisible(true);
if(time !=0)
{try
{Thread.sleep(time); 
dispose();
}
catch(InterruptedException ie)
{
}
}
}
  
private void centerScreen()
{Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
int x = (int) ((d.getWidth() - getWidth()) / 2);
int y = (int) ((d.getHeight() - getHeight()) / 2);
setLocation(x, y);
}

public static void main(String[] args)
  {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    new Splash_Screen(5000);
    new SteganographyPanel();
  }

}