package com.company;

import java.util.*;

class Game {
    private static Scanner scTxt = new Scanner(System.in);
    private static Scanner scNb = new Scanner(System.in);
    private int numberOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> orderedPlayers = new ArrayList<>();
    private Grid grid = new Grid();
    private GraphicalUserInterface graphicalUserInterface;

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
                graphicalUserInterface.btnGrid[0][1].setIcon(graphicalUserInterface.OrangeTurtle);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(5);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][5].setIcon(graphicalUserInterface.GreenTurtle);
                break;
            case 3:
                orderedPlayers.get(0).setPositionX(0);
                orderedPlayers.get(0).setPositionY(0);
                orderedPlayers.get(0).setColor("orange");
                graphicalUserInterface.btnGrid[0][0].setIcon(graphicalUserInterface.OrangeTurtle);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(3);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][3].setIcon(graphicalUserInterface.GreenTurtle);
                orderedPlayers.get(2).setPositionX(0);
                orderedPlayers.get(2).setPositionY(6);
                orderedPlayers.get(2).setColor("blue");
                graphicalUserInterface.btnGrid[0][6].setIcon(graphicalUserInterface.BlueTurtle);
                break;
            case 4:
                orderedPlayers.get(0).setPositionX(0);
                orderedPlayers.get(0).setPositionY(0);
                orderedPlayers.get(0).setColor("orange");
                graphicalUserInterface.btnGrid[0][0].setIcon(graphicalUserInterface.OrangeTurtle);
                orderedPlayers.get(1).setPositionX(0);
                orderedPlayers.get(1).setPositionY(2);
                orderedPlayers.get(1).setColor("green");
                graphicalUserInterface.btnGrid[0][2].setIcon(graphicalUserInterface.GreenTurtle);
                orderedPlayers.get(2).setPositionX(0);
                orderedPlayers.get(2).setPositionY(5);
                orderedPlayers.get(2).setColor("blue");
                graphicalUserInterface.btnGrid[0][5].setIcon(graphicalUserInterface.BlueTurtle);
                orderedPlayers.get(3).setPositionX(0);
                orderedPlayers.get(3).setPositionY(7);
                orderedPlayers.get(3).setColor("yellow");
                graphicalUserInterface.btnGrid[0][7].setIcon(graphicalUserInterface.YellowTurtle);
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
        if (numberOfPlayers == 2) {
            if (nbFinishedPlayers == 1) {
                return true;
            } else {
                return false;
            }
        } else if (numberOfPlayers == 3 || numberOfPlayers == 4) {
            if (nbFinishedPlayers == 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void turn(Player player) {
        int entre;
        System.out.println("C'est le tour de " + player.getPseudo());
        showCardHand(player);
        showWallCardHand(player);
        showProgram(player);
        do {
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
                int programCard;
                String wantChangeProgram;
                do {
                    for (int i = 0; i < (player.getCardHand()).size(); i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(player.hand.get(i).getCardType());
                    }
                    programCard = 0;
                    try {
                        System.out.println("Quelle carte voulez vous ajouter au programme ?");
                        programCard = Integer.parseInt(scNb.nextLine());
                    } catch (Exception e) {
                    }
                    programCard = programCard - 1;
                    player.program.add(player.hand.get(programCard));
                    player.discardCard(programCard);
                    do {
                        wantChangeProgram = "o";
                        if (!player.hand.isEmpty()) {
                            System.out.println("Voulez vous ajouter une autre carte ?");
                            wantChangeProgram = scTxt.nextLine();
                        }
                    } while (!wantChangeProgram.equals("oui") && !wantChangeProgram.equals("non") && !wantChangeProgram.equals("o") && !wantChangeProgram.equals("n"));
                } while (wantChangeProgram.equals("oui") || wantChangeProgram.equals("o"));
                discardEndTurn(player);
                break;
            case 2:
                if (!player.wallCardHand.isEmpty()) {
                    int wallCardChoosed = 0;
                    try {
                        System.out.println("Quel mur voulez vous jouer ?");
                        for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
                            System.out.print((i + 1) + ". ");
                            System.out.println(player.wallCardHand.get(i).getWallCardType());
                        }
                        wallCardChoosed = Integer.parseInt(scNb.nextLine());
                    } catch (Exception e) {
                    }
                    int xWall;
                    int yWall;
                    boolean wallValide = false;
                    do {
                        xWall = 0;
                        yWall = 0;
                        grid.displayGridConsole();
                        System.out.println("A quelles coordonnées souhaitez vous le placer ?");
                        try {
                            System.out.println("X ?");
                            xWall = scNb.nextInt();
                        } catch (Exception e) {
                        }
                        try {
                            System.out.println("Y ?");
                            yWall = scNb.nextInt();
                        } catch (Exception e) {
                        }
                        if (grid.grid[xWall][yWall].getState() == 'E') {
                            System.out.println(player.wallCardHand.get(wallCardChoosed).getWallCardType());
                            grid.grid[xWall][yWall].setState(player.wallCardHand.get(wallCardChoosed).getWallCardType());
                            System.out.println(grid.grid[xWall][yWall].getState());
                            wallValide = true;
                        } else {
                            System.out.println("Cet emplacement n'est pas valide, choisissez en un autre.");
                        }
                    } while (!wallValide);
                    grid.displayGridConsole();
                    showCardHand(player);
                    discardEndTurn(player);
                    showCardHand(player);
                }
                break;
            case 3:
                for (Card card : player.program) {
                    Move move = new Move();
                    switch (card.getCardType()) {
                        case 'B':
                            move.moveForward(player, grid);
                            break;
                        case 'Y':
                            move.leftRotation(player);
                            break;
                        case 'P':
                            move.rightRotation(player);
                            break;
                        case 'L':
                            move.laserShot(player, players, numberOfPlayers, grid);
                            break;
                    }
                }
                discardEndTurn(player);
                showCardHand(player);
                break;
        }
    }

    private void showWallCardHand(Player player) {
        System.out.print("Voici vos murs disponibles :");
        for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
            System.out.print(player.wallCardHand.get(i).getWallCardType() + "  ");
        }
    }

    private void showCardHand(Player player) {
        System.out.print("Voici votre main :");
        for (int i = 0; i < (player.getCardHand()).size(); i++) {
            System.out.print(player.hand.get(i).getCardType() + "  ");
        }
    }

    private void discardEndTurn(Player player) {
        String wantDefausse;
        System.out.println("Souhaitez vous défausser des cartes ?");
        do {
            wantDefausse = scTxt.nextLine();
        } while (!wantDefausse.equals("oui") && !wantDefausse.equals("non") && !wantDefausse.equals("o") && !wantDefausse.equals("n"));
        if (wantDefausse.equals("oui") || wantDefausse.equals("o")) {
            showCardHand(player);
            int discardedCard;
            String wantToDiscard;
            int deletedCardCount = 0;
            do {
                System.out.println("Quelle carte voulez vous défausser ?");
                for (int i = 0; i < (player.getCardHand()).size(); i++) {
                    System.out.print((i + 1) + ". ");
                    System.out.println(player.hand.get(i).getCardType());
                }
                discardedCard = scNb.nextInt();
                discardedCard = discardedCard - 1;
                deletedCardCount = deletedCardCount + 1;
                player.discardCard(discardedCard);
                System.out.println("Voulez vous supprimer une nouvelle carte ?");
                do {
                    wantToDiscard = scTxt.nextLine();
                } while (!wantToDiscard.equals("oui") && !wantToDiscard.equals("non") && !wantToDiscard.equals("o") && !wantToDiscard.equals("n"));
            } while (wantToDiscard.equals("oui") || wantToDiscard.equals("o"));
            player.drawUntilHandIsFull(deletedCardCount);
        }

    }

    private void showProgram(Player player) {
        System.out.print("Voici votre programme :");
        for (int i = 0; i < (player.getProgram()).size(); i++) {
            System.out.print(player.program.get(i).getCardType() + "  ");
        }
    }
}
