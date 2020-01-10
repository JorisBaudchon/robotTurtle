package com.company;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;



public class GraphicalUserInterface {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setTitle("Robot Turtle");
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setSize(1000, 700);
        window.setAlwaysOnTop(true);
    }
}
