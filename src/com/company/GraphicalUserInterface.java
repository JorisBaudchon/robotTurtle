package com.company;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;


public class GraphicalUserInterface extends JFrame {

    JTextPane textPane = new JTextPane();
    private JFrame window = new JFrame();
    public JButton[][] btnGrid = new JButton[8][8];
    public JLabel nbOfIceWall = new JLabel("1");
    public JLabel nbOfWall = new JLabel("1");
    private boolean NoIceWall = false;
    private boolean NoWall = false;
    private String alertPlayer;
    private static String selectedWall;
    private boolean actionWall;
    private boolean actionGrid;
    private boolean actionHand;
    private boolean actionBtnValidCard;
    private int[] coord = new int[2];
    private int indexHand;
    ImageIcon YellowCard = new ImageIcon(new ImageIcon("images/cards/YellowCard.png").getImage().getScaledInstance(85, 150, Image.SCALE_DEFAULT));
    ImageIcon BlueCard = new ImageIcon(new ImageIcon("images/cards/BlueCard.png").getImage().getScaledInstance(85, 150, Image.SCALE_DEFAULT));
    ImageIcon LaserCard = new ImageIcon(new ImageIcon("images/cards/LaserCard.png").getImage().getScaledInstance(85, 150, Image.SCALE_DEFAULT));
    ImageIcon PurpleCard = new ImageIcon(new ImageIcon("images/cards/PurpleCard.png").getImage().getScaledInstance(85, 150, Image.SCALE_DEFAULT));
    ImageIcon IceWall = new ImageIcon(new ImageIcon("images/ICE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon Wall = new ImageIcon(new ImageIcon("images/WALL.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon GreenJewel = new ImageIcon(new ImageIcon("images/GreenJewel.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon BlueJewel = new ImageIcon(new ImageIcon("images/BlueJewel.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon PurpleJewel = new ImageIcon(new ImageIcon("images/PurpleJewel.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon orangeTurtleS = new ImageIcon(new ImageIcon("images/orangeTurtleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon orangeTurtleN = new ImageIcon(new ImageIcon("images/orangeTurtleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon orangeTurtleO = new ImageIcon(new ImageIcon("images/orangeTurtleO.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon orangeTurtleE = new ImageIcon(new ImageIcon("images/orangeTurtleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon greenTurtleS = new ImageIcon(new ImageIcon("images/greenTurtleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon greenTurtleN = new ImageIcon(new ImageIcon("images/greenTurtleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon greenTurtleO = new ImageIcon(new ImageIcon("images/greenTurtleO.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon greenTurtleE = new ImageIcon(new ImageIcon("images/greenTurtleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon blueTurtleS = new ImageIcon(new ImageIcon("images/blueTurtleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon blueTurtleN = new ImageIcon(new ImageIcon("images/blueTurtleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon blueTurtleO = new ImageIcon(new ImageIcon("images/blueTurtleO.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon blueTurtleE = new ImageIcon(new ImageIcon("images/blueTurtleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon yellowTurtleS = new ImageIcon(new ImageIcon("images/yellowTurtleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon yellowTurtleN = new ImageIcon(new ImageIcon("images/yellowTurtleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon yellowTurtleO = new ImageIcon(new ImageIcon("images/yellowTurtleO.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon yellowTurtleE = new ImageIcon(new ImageIcon("images/yellowTurtleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));

    public void setNbOfIceWall(JLabel nbOfIceWall){
        this.nbOfIceWall = nbOfIceWall;
    }
    public void setNbOfWall(JLabel nbOfWall){
        this.nbOfWall = nbOfWall;
    }

    JPanel panelGrid = new JPanel(new GridLayout(8, 8)) {
        @Override
        public void paintComponent(Graphics g) {
            //Plateau
            try {
                Image img = ImageIO.read(new File("images/Grid.png"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Grid error : " + e.getMessage());
            }
        }
    };


    ImageIcon imgBackground = new ImageIcon("images/background.jpeg");
    //Image img = background.getImage();

    JPanel panelWall = new JPanel();
    JLayeredPane bigPanel = new JLayeredPane();


    public GraphicalUserInterface() {

        //Fenêtre
        this.window.setResizable(false);
        this.window.setSize(new Dimension(1200, 850));
        this.window.setTitle("Robot Turtles");
        this.window.setName("gameWindow");
        this.window.setLocationRelativeTo(null);
        this.window.getContentPane().setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panels
        this.bigPanel.setBounds(15, 16, 1200, 750);
        this.window.getContentPane().add(this.bigPanel);
        this.bigPanel.setLayout(null);

        this.panelGrid.setBounds(300, 60, 500, 500);
        this.bigPanel.add(this.panelGrid);



        //Boutons du plateau
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton btn = new JButton();
                btn.setOpaque(false);
                btn.setVisible(true);
                btn.setContentAreaFilled(false);
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton) e.getSource();
                        String[] temp = b.getName().split(";");
                        coord[0] = Integer.parseInt(temp[0]);
                        coord[1] = Integer.parseInt(temp[1]);
                        actionGrid = true;
                    }
                });
                btnGrid[i][j] = btn;
                this.panelGrid.add(btnGrid[i][j]);
            }
        }



        this.textPane.setBounds(810, 65, 207, 403);
        this.textPane.setBackground(null);
        bigPanel.add(this.textPane);

        this.panelWall.setBounds(1100, 287, 54, 110);

        bigPanel.add(this.panelWall);
        this.panelWall.setLayout(new GridLayout(2, 1, 0, 0));
        JButton btnWall = new JButton();
        btnWall.addActionListener(new ActionListener() {
     
            public void actionPerformed(ActionEvent arg0) {
                selectedWall = "Mur";
                if (!NoWall) {
                    actionWall = true;
                } else {
                    msgConsole("Les réserves de mur sont épuisés");
                    System.out.println(alertPlayer);
                }
                System.out.println(selectedWall);
            }
        });
        btnWall.setIcon(Wall);
        btnWall.setVisible(true);
        panelWall.add(btnWall);

        JButton btnIceWall = new JButton();
        btnIceWall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedWall = "Mur de Glace";
                if (!NoIceWall) {
                    actionWall = true;
                } else {
                    msgConsole("Les réserves de mur de glace sont épuisés");
                }
                System.out.println(selectedWall);
            }
        });
        btnIceWall.setIcon(IceWall);
        btnIceWall.setVisible(true);
        panelWall.add(btnIceWall);


        nbOfWall.setFont(new Font("Roboto", Font.BOLD, 30));
        nbOfWall.setBounds(1060, 290, 50, 56);
        bigPanel.add(nbOfWall);

        nbOfIceWall.setFont(new Font("Roboto", Font.BOLD, 30));
        nbOfIceWall.setBounds(1060, 320, 100, 100);
        bigPanel.add(nbOfIceWall);

        this.window.setVisible(true);

    }

    
    
    public void setNbWall(int[] gridNbOfWall) {
        nbOfIceWall.setText(":" + gridNbOfWall[1]);
        nbOfWall.setText(":" + gridNbOfWall[0]);
        for (int i = 0; i < 3; i++) {
            if (gridNbOfWall[i] == 0) {
                if (i == 0) {
                    NoWall = true;
                } else NoWall = false;
                if (i == 1) {
                    NoWall = true;
                } else NoWall = false;
                if (i == 2) {
                    NoIceWall = true;
                } else NoIceWall = false;
            }
        }

    }
    

    public void msgConsole(String msgConsole) {
        this.textPane.setText(msgConsole);
    }

    


}
