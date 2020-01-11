package com.company;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;


public class GraphicalUserInterface extends JFrame{
    
    public static void main(String[] args) {
        
    }
    
    public GraphicalUserInterface(){
        
        JFrame window = new JFrame();
        window.setTitle("Robot Turtle");
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setSize(1000, 700);
        window.setAlwaysOnTop(true);
        window.setLocationRelativeTo(null);
        window.getContentPane().setLayout(null);
        
        JLabel titreConteneur = new JLabel("ROBOT TURTLES");
       titreConteneur.setBounds(500
               , 43, 300, 20);
       window.getContentPane().add(titreConteneur);

       JButton buttonFinish = new JButton("J'ai fini");
       buttonFinish.setBounds(871, 624, 115, 30);
       buttonFinish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       window.getContentPane().add(buttonFinish);

       JButton BlueCard = new JButton("Avancer");
       BlueCard.setBounds(51, 500, 100, 155);
       window.getContentPane().add(BlueCard);

       JButton PurpleCard = new JButton("Gauche");
       PurpleCard.setBounds(133, 500, 100, 155);
       window.getContentPane().add(PurpleCard);

       JButton YellowCard = new JButton("Droite");
       YellowCard.setBounds(215, 500, 100, 155);
       fenetre.getContentPane().add(YellowCard);

       JButton LaserCard = new JButton("Laser");
       LaserCard.setBounds(296, 500, 100, 155);
       window.getContentPane().add(LaserCard);

       JButton Defausse = new JButton("Defausser");
       Defausse.setBounds(378, 500, 100, 155);
       window.getContentPane().add(Defausse);

       JButton btnValidCard = new JButton("Valider la carte");
       btnValidCard.setBounds(500, 624, 150, 30);
       window.getContentPane().add(btnValidCard);
        
}
