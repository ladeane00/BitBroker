package com.LADLAB.LADLAB;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
 
//red blinking label class
public class BlinkLabelRed extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private static final int BLINKING_RATE = 300; // in ms

  private boolean blinkingOn = true;

  public BlinkLabelRed(String text) {
    super(text);
    Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
    timer.setInitialDelay(0);
    timer.start();
  }
  
  public void setBlinking(boolean flag) {
    this.blinkingOn = flag;
  }
  public boolean getBlinking(boolean flag) {
    return this.blinkingOn;
  }

  //sets up timer
  private class TimerListener implements ActionListener {
    private BlinkLabelRed bl;
    private Color bg;
    private Color fg;
    private boolean isForeground = true;
    
    public TimerListener(BlinkLabelRed bl) {
      this.bl = bl;
      fg = new Color(240, 20, 20);
      bg = new Color(250, 228, 180);
    }
 
    public void actionPerformed(ActionEvent e) {
      if (bl.blinkingOn) {
        if (isForeground) {
          bl.setForeground(fg);
        }
        else {
          bl.setForeground(bg);
        }
        isForeground = !isForeground;
      }
      else {
        // here we want to make sure that the label is visible
        // if the blinking is off.
        if (isForeground) {
          bl.setForeground(fg);
          isForeground = false;
        }
      }
    }
    
  }
}