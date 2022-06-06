package game;

import javax.swing.*;

public class Frame extends JFrame {

  public Frame(int w, int h) {
    this.add(new Panel(w, h));
    this.setVisible(true); //lets you see it
    this.pack();
    this.setResizable(false); //so that it looks ok
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // ends when you click X on the Jframe
    this.setTitle("Treasure & Fame");
    
  }
  
}
