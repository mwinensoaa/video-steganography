/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.usergui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Tony
 */
public class ImagePanel  extends JComponent {
 
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
  
}
