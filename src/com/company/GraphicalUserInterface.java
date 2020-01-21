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
    public JButton[] btnCard = new JButton[5];
    public JButton[][] btnGrid = new JButton[8][8];
    private JLabel nbOfIceWall = new JLabel("1");
    private JLabel nbOfWall = new JLabel("1");
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
    public ImageIcon OrangeTurtle = new ImageIcon(new ImageIcon("images/OrangeTurtle.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon GreenTurtle = new ImageIcon(new ImageIcon("images/GreenTurtle.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon BlueTurtle = new ImageIcon(new ImageIcon("images/BlueTurtle.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    ImageIcon YellowTurtle = new ImageIcon(new ImageIcon("images/YellowTurtle.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));

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

    public void setNbOfIceWall(JLabel nbOfIceWall) {
        this.nbOfIceWall = nbOfIceWall;
    }

    public void setNbOfWall(JLabel nbOfWall) {
        this.nbOfWall = nbOfWall;
    }

    JPanel panelHand = new JPanel(new GridLayout(1, 5));
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

        this.panelHand.setBounds(350, 600, 410, 146);
        this.bigPanel.add(this.panelHand);


        //Boutons de la main du joueur
        for (int i = 0; i < btnCard.length; i++) {
            JButton button = new JButton();
            button.setVisible(true);
            button.setName(i + ";0");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton buttonH = (JButton) e.getSource();
                    if (buttonH.getIcon() == null) {
                        actionHand = false;
                    } else {
                        String[] temp = buttonH.getName().split(";");
                        indexHand = Integer.parseInt(temp[0]);
                        actionHand = true;
                    }
                }
            });
            btnCard[i] = button;
            this.panelHand.add(btnCard[i]);
        }


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


        JButton btnValidCard = new JButton("Valider");
        btnValidCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnValidCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionBtnValidCard = true;
            }
        });
        btnValidCard.setBounds(830, 650, 150, 50);
        this.bigPanel.add(btnValidCard);

        JButton btnDiscard = new JButton("Defausser");
        btnDiscard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDiscard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnDiscard.setBounds(1030, 650, 115, 50);
        this.bigPanel.add(btnDiscard);


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
                    message("Les réserves de mur sont épuisés");
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
                    message("Les réserves de mur de glace sont épuisés");
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

    

    public void setHand(List<Card> playerHand) {
        if (playerHand.size() < 5) {
            for (int i = playerHand.size(); i < 5; i++) {
                btnCard[i].setBackground(null);
                btnCard[i].setIcon(null);
            }
        }

        for (int i = 0; i < playerHand.size(); i++) {
            switch (playerHand.get(i).cardType) {
                case 'B':
                    btnCard[i].setIcon(BlueCard);
                    break;
                case 'Y':
                    btnCard[i].setIcon(YellowCard);
                    break;
                case 'P':
                    btnCard[i].setIcon(PurpleCard);
                    break;
                case 'L':
                    btnCard[i].setIcon(LaserCard);
                    break;
            }
        }
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
    

    public void message(String message) {
        this.textPane.setText(message);
    }

    public int getSelectedCard() {
        actionGrid = false; // on met l'action false car le mur a été lu
        actionHand = false; // on met toutes les actions à faux
        actionWall = false;
        return indexHand;
    }

    public String getSelectedWall() {
        actionGrid = false;
        actionHand = false;
        actionWall = false;
        return selectedWall;
    }

    public int[] getCoord() {
        actionWall = false;
        actionGrid = false;
        actionHand = false;
        return coord;
    }

    public boolean getActionWall() {
        return actionWall;
    }

    public boolean getActionGrid() {
        return actionGrid;
    }

    public boolean getActionHand() {
        return actionHand;
    }

    public boolean getActionFinish() {
        if (actionBtnValidCard) {
            actionGrid = false;
            actionHand = false;
            actionWall = false;
            actionBtnValidCard = false;
            return true;
        } else {
            return false;
        }

    }


}
