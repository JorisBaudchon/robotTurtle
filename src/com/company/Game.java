package com.company;

import javax.swing.*;
import java.util.*;

class Game {
    private static Scanner scTxt = new Scanner(System.in);
    private static Scanner scNb = new Scanner(System.in);
    private int numberOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> orderedPlayers = new ArrayList<>();
    private Grid grid = new Grid();
    private GraphicalUserInterface graphicalUserInterface;
    private ArrayList<Player> finishedPlayers = new ArrayList<>();

    public void initGame() {
        System.out.println("Bienvenue au jeu ROBOT TURTLES !");
        boolean end = false;
        do {
            boolean newGame = askNewGame();
            if (!newGame) {
                System.out.println("Merci d'être venu !");
            } else {
                numberOfPlayers = askNumberOfPlayers();
                for (int i = 0; i < numberOfPlayers; i++) {
                    String newPlayer = askNewPlayer(i + 1);
                    Player player = new Player(newPlayer);
                    this.players.add(player);
                }
                graphicalUserInterface = new GraphicalUserInterface();
                initTurnOrder();
                showTurnOrder();
                grid.initGrid(numberOfPlayers, graphicalUserInterface);
                grid.placeTurtle(numberOfPlayers);
                grid.placeJewel(numberOfPlayers, graphicalUserInterface);

                grid.displayGridConsole();
                for (int i = 0; i < numberOfPlayers; i++) {
                    Player player = players.get(i);
                    player.initDeck();
                    player.initHand();
                    player.initWallHand();
                    player.createProgram();
                }
                while (!endGameCondition()) {
                    for (Player player : orderedPlayers) {
                        turn(player);
                    }
                }
                int point = numberOfPlayers - 1;
                for (int i = 0; i < numberOfPlayers - 1; i++) {
                    finishedPlayers.get(i).setScore(finishedPlayers.get(i).getScore() + point);
                    point = point--;
                }
                for (int i = 0; i < numberOfPlayers; i++) {
                    System.out.println("Le joueur " + orderedPlayers.get(i).getPseudo() + "a : " + orderedPlayers.get(i).getScore() +" points");
                }
            }
        } while (end);
    }

    private boolean askNewGame() {
        String entre;
        do {
            System.out.println("Souhaitez vous faire une partie de ROBOT TURTLES ?");
            entre = scTxt.nextLine();
        } while (!entre.equals("oui") && !entre.equals("non") && !entre.equals("o") && !entre.equals("n"));
        return entre.equals("oui") || entre.equals("o");
    }

    private int askNumberOfPlayers() {
        int entre = 1;
        do {
            try {
                System.out.println("Combien y aura t-il de joueurs ?");
                entre = Integer.parseInt(scNb.nextLine());
            } catch (Exception e) {
                entre = 1;
            }
        } while ((entre != 2) && (entre != 3) && (entre != 4));
        return entre;
    }

    private String askNewPlayer(int i) {
        String entre;
        do {
            System.out.println("Quel est le pseudo du joueur " + i + " ?");
            entre = scTxt.nextLine();
        } while (entre.isEmpty());
        return entre;
    }

    private void initTurnOrder() {
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            index.add(i + 1);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            int randomIndex = rand.nextInt(index.size());
            Player player = this.players.get(i);
            player.setPlayerTurn(index.get(randomIndex));
            player.setOrientation('S');
            index.remove(randomIndex);
        }
        for (int i = 0; i < numberOfPlayers + 1; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (players.get(j).getPlayerTurn() == i) {
                    this.orderedPlayers.add(players.get(j));
                }
            }
        }
        switch (numberOfPlayers) {
            case 2:
                orderedPlayers.get(0).setPositionX(0);
                orderedPlayers.get(0).setPositionY(1);
                orderedPlayers.get(0).setColor("orange");
                graphicalUserInterface.btnGrid[0][1].setIcon(graphicalUserInterface.orangeTurtleS);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(5);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][5].setIcon(graphicalUserInterface.greenTurtleS);
                break;
            case 3:
                orderedPlayers.get(0).setPositionX(0);
                orderedPlayers.get(0).setPositionY(0);
                orderedPlayers.get(0).setColor("orange");
                graphicalUserInterface.btnGrid[0][0].setIcon(graphicalUserInterface.orangeTurtleS);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(3);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][3].setIcon(graphicalUserInterface.greenTurtleS);
                orderedPlayers.get(2).setPositionX(0);
                orderedPlayers.get(2).setPositionY(6);
                orderedPlayers.get(2).setColor("blue");
                graphicalUserInterface.btnGrid[0][6].setIcon(graphicalUserInterface.blueTurtleS);
                break;
            case 4:
                orderedPlayers.get(0).setPositionX(0);
                orderedPlayers.get(0).setPositionY(0);
                orderedPlayers.get(0).setColor("orange");
                graphicalUserInterface.btnGrid[0][0].setIcon(graphicalUserInterface.orangeTurtleS);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(2);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][2].setIcon(graphicalUserInterface.greenTurtleS);
                orderedPlayers.get(2).setPositionX(0);
                orderedPlayers.get(2).setPositionY(5);
                orderedPlayers.get(2).setColor("blue");
                graphicalUserInterface.btnGrid[0][5].setIcon(graphicalUserInterface.blueTurtleS);
                orderedPlayers.get(3).setPositionX(0);
                orderedPlayers.get(3).setPositionY(7);
                orderedPlayers.get(3).setColor("yellow");
                graphicalUserInterface.btnGrid[0][7].setIcon(graphicalUserInterface.yellowTurtleS);
                break;
        }

    }

    private void showTurnOrder() {
        System.out.println("Voici l'ordre de jeu :");
        for (int i = 0; i < numberOfPlayers + 1; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (players.get(j).getPlayerTurn() == i) {
                    System.out.println((players.get(j)).getPlayerTurn() + ". " + (players.get(j)).getPseudo());
                }
            }
        }
    }

    private boolean endGameCondition() {
        int nbFinishedPlayers = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players.get(i).isFinished()) {
                nbFinishedPlayers = nbFinishedPlayers + 1;
            }
        }
        if (nbFinishedPlayers >= players.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    private void turn(Player player) {
        int entre = 0;
        System.out.println("C'est le tour de " + player.getPseudo());
        grid.displayGridConsole();
        showCardHand(player);
        showWallCardHand(player);
        showProgram(player);
        do {
            entre = 0;
            try {
                System.out.println("Que souhaitez vous faire ?");
                System.out.println("Entrez 1 pour COMPLETER LE PROGRAMME");
                System.out.println("Entrez 2 pour CONSTRUIRE UN MUR");
                System.out.println("Entrez 3 pour EXECUTER LE PROGRAMME");
                entre = Integer.parseInt(scNb.nextLine());
            } catch (Exception e) {
                entre = 0;
            }
        } while (!(entre == 1) && !(entre == 2) && !(entre == 3));
        switch (entre) {
            case 1:
                int programCard = 0;
                String wantChangeProgram = "";
                do {
                    for (int i = 0; i < (player.getCardHand()).size(); i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(player.hand.get(i).getCardType());
                    }
                    do {
                        try {
                            System.out.println("Quelle carte voulez vous ajouter au programme ?");
                            programCard = Integer.parseInt(scNb.nextLine());
                        } catch (Exception e) {
                            programCard = -1;
                        }
                    } while (programCard <= 0 || programCard >= player.getCardHand().size() + 1);
                    programCard = programCard - 1;
                    player.program.add(player.getCardHand().get(programCard));
                    player.discardCard(programCard);
                    if (!player.hand.isEmpty()) {
                        System.out.println("Voulez vous ajouter une autre carte ?");
                        do {
                            wantChangeProgram = scTxt.nextLine();
                        } while (!wantChangeProgram.equals("oui") && !wantChangeProgram.equals("non") && !wantChangeProgram.equals("o") && !wantChangeProgram.equals("n"));
                    } else {
                        wantChangeProgram = "n";
                    }
                } while (wantChangeProgram.equals("oui") || wantChangeProgram.equals("o"));
                discardEndTurn(player);
                break;
            case 2:
                if (!player.wallCardHand.isEmpty()) {
                    int wallCardChoosed = 0;
                    for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(player.wallCardHand.get(i).getWallCardType());
                    }
                    do {
                        try {
                            System.out.println("Quel mur voulez vous jouer ?");
                            wallCardChoosed = Integer.parseInt(scNb.nextLine());
                        } catch (Exception e) {
                        }
                    } while (wallCardChoosed <= 0 || wallCardChoosed > player.wallCardHand.size());
                    int xWall;
                    int yWall;
                    boolean wallValide = false;
                    do {
                        xWall = 0;
                        yWall = 0;
                        grid.displayGridConsole();
                        System.out.println("A quelles coordonnées souhaitez vous le placer ?");
                        do {
                            try {
                                System.out.println("X ?");
                                xWall = scNb.nextInt();
                            } catch (Exception e) {
                            }
                        } while (xWall < 0 || xWall > 7);
                        do {
                            try {
                                System.out.println("Y ?");
                                yWall = scNb.nextInt();
                            } catch (Exception e) {
                            }
                        } while (yWall < 0 || yWall > 7);
                        wallCardChoosed = wallCardChoosed - 1;
                        if (grid.grid[xWall][yWall].getState() == 'E') {
                            System.out.println(player.wallCardHand.get(wallCardChoosed).getWallCardType());
                            grid.grid[xWall][yWall].setState(player.wallCardHand.get(wallCardChoosed).getWallCardType());
                            System.out.println(grid.grid[xWall][yWall].getState());
                            player.wallCardHand.remove(wallCardChoosed);
                            switch (player.wallCardHand.get(wallCardChoosed).getWallCardType()) {
                                case 'S':
                                    graphicalUserInterface.btnGrid[xWall][yWall].setIcon(graphicalUserInterface.Wall);
                                    break;
                                case 'I':
                                    graphicalUserInterface.btnGrid[xWall][yWall].setIcon(graphicalUserInterface.IceWall);
                                    break;
                            }
                            wallValide = true;
                        } else {
                            System.out.println("Cet emplacement n'est pas valide, choisissez en un autre.");
                        }
                    } while (!wallValide);
                    grid.displayGridConsole();
                    showCardHand(player);
                    discardEndTurn(player);
                    showCardHand(player);
                } else {
                    System.out.println("Vous ne possédez plus de murs à jouer !");
                }
                break;
            case 3:
                for (Card card : player.program) {
                    Move move = new Move();
                    switch (card.getCardType()) {
                        case 'B':
                            move.moveForward(player, grid, numberOfPlayers, finishedPlayers, players, graphicalUserInterface);
                            break;
                        case 'Y':
                            move.rightRotation(player, graphicalUserInterface);
                            break;
                        case 'P':
                            move.leftRotation(player, graphicalUserInterface);
                            break;
                        case 'L':
                            move.laserShot(player, players, numberOfPlayers, grid, graphicalUserInterface);
                            break;
                    }
                }
                discardEndTurn(player);
                showCardHand(player);
                break;
        }
        player.drawUntilHandIsFull(player.getCardHand().size());
    }


    private void showWallCardHand(Player player) {
        System.out.print("Voici vos murs disponibles :");
        int w = 0;
        int j = 0;
        graphicalUserInterface.bigPanel.remove(graphicalUserInterface.nbOfWall);
        graphicalUserInterface.bigPanel.remove(graphicalUserInterface.nbOfIceWall);
        for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
            System.out.print(player.wallCardHand.get(i).getWallCardType() + "  ");
            if (player.wallCardHand.get(i).getWallCardType() == 'W') {
                w = w + 1;
            } else {
                j = j + 1;
            }
        }
        graphicalUserInterface.setNbOfIceWall(new JLabel("" + w + ""));
        graphicalUserInterface.setNbOfIceWall(new JLabel("" + j + ""));
        graphicalUserInterface.bigPanel.add(graphicalUserInterface.nbOfWall);
        graphicalUserInterface.bigPanel.add(graphicalUserInterface.nbOfIceWall);
    }

    private void showCardHand(Player player) {
        System.out.print("Voici votre main :");
        for (int i = 0; i < (player.getCardHand()).size(); i++) {
            System.out.print(player.hand.get(i).getCardType() + "  ");
            switch (player.getCardHand().get(i).cardType) {
                case 'B':
                    graphicalUserInterface.btnCard[i].setIcon(graphicalUserInterface.BlueCard);
                    break;
                case 'P':
                    graphicalUserInterface.btnCard[i].setIcon(graphicalUserInterface.PurpleCard);
                    break;
                case 'Y':
                    graphicalUserInterface.btnCard[i].setIcon(graphicalUserInterface.YellowCard);
                    break;
                case 'L':
                    graphicalUserInterface.btnCard[i].setIcon(graphicalUserInterface.LaserCard);
                    break;
            }
        }
    }

    private void discardEndTurn(Player player) {
        if (player.getCardHand().isEmpty()) {
            System.out.println("Votre main est vide, vous ne pouvez rien défausser.");
        } else {
            String wantDefausse;
            System.out.println("Souhaitez vous défausser des cartes ?");
            do {
                wantDefausse = scTxt.nextLine();
            } while (!wantDefausse.equals("oui") && !wantDefausse.equals("non") && !wantDefausse.equals("o") && !wantDefausse.equals("n"));
            if (wantDefausse.equals("oui") || wantDefausse.equals("o")) {
                showCardHand(player);
                int discardedCard = -1;
                String wantToDiscard;
                int deletedCardCount = 0;
                do {
                    for (int i = 0; i < (player.getCardHand()).size(); i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(player.hand.get(i).getCardType());
                    }
                    do {
                        try {
                            System.out.println("Quelle carte voulez vous défausser ?");
                            discardedCard = Integer.parseInt(scNb.nextLine());
                        } catch (Exception e) {
                        }
                    } while (discardedCard <= 0 || discardedCard > player.getCardHand().size() + 1);
                    discardedCard = discardedCard - 1;
                    deletedCardCount = deletedCardCount + 1;
                    player.discardCard(discardedCard);
                    System.out.println("Voulez vous supprimer une nouvelle carte ?");
                    do {
                        wantToDiscard = scTxt.nextLine();
                    } while (!wantToDiscard.equals("oui") && !wantToDiscard.equals("non") && !wantToDiscard.equals("o") && !wantToDiscard.equals("n"));
                } while (wantToDiscard.equals("oui") || wantToDiscard.equals("o"));
                player.drawUntilHandIsFull(player.getCardHand().size());
            }
        }
    }

    private void showProgram(Player player) {
        System.out.print("Voici votre programme :");
        for (int i = 0; i < (player.getProgram()).size(); i++) {
            System.out.print(player.program.get(i).getCardType() + "  ");
        }
    }
}
