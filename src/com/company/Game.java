package com.company;

import java.util.*;

public class Game {
    public static Scanner scTxt = new Scanner(System.in);
    public static Scanner scNb = new Scanner(System.in);
    private int numberOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> orderedPlayers = new ArrayList<>();
    private Grid grid = new Grid();

    public void initGame() {
        System.out.println("Bienvenue au jeu ROBOT TURTLES !");
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
            initTurnOrder();
            showTurnOrder();
            grid.initGrid(numberOfPlayers);
            grid.placeTurtle(numberOfPlayers);
            grid.placeJewel(numberOfPlayers);
            grid.displayGridConsole();
            for (int i = 0; i < numberOfPlayers; i++) {
                Player player = players.get(i);
                player.initDeck();
                player.initHand();
                player.initWallHand();
            }
            while (!endGameCondition()) {
                for (Player player : orderedPlayers) {
                    turn(player);
                }
            }

        }
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
        int entre;
        do {
            System.out.println("Combien y aura t-il de joueurs ?");
            entre = scNb.nextInt();
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
            index.remove(randomIndex);
        }
    }

    private void showTurnOrder() {
        System.out.println("Voici l'ordre de jeu :");
        for (int i = 0; i < numberOfPlayers + 1; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (players.get(j).getPlayerTurn() == i) {
                    System.out.println((players.get(j)).getPlayerTurn() + ". " + (players.get(j)).getPseudo());
                    this.orderedPlayers.add(players.get(j));
                }
            }
        }
    }

    public boolean endGameCondition() {
        int nbFinishedPlayers = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players.get(i).isFinished()) {
                nbFinishedPlayers = nbFinishedPlayers + 1;
            }
        }
        if (nbFinishedPlayers < (numberOfPlayers - 1)) {
            return false;
        } else {
            return true;
        }
    }

    public void turn(Player player) {
        int entre;
        System.out.println("C'est le tour de " + player.getPseudo());
        //System.out.println(player.getHand());
        //showHand(player);
        //System.out.println(player.getWallCardHand());
        showWallCardHand(player);
        System.out.println("Que souhaitez vous faire ?");
        System.out.println("Entrez 1 pour COMPLETER LE PROGRAMME");
        System.out.println("Entrez 2 pour CONSTRUIRE UN MUR");
        System.out.println("Entrez 3 pour EXECUTER LE PROGRAMME");
        do {
            entre = scNb.nextInt();
        } while (!(entre == 1) && !(entre == 2) && !(entre == 3));
        switch (entre) {
            case 1:
                break;
            case 2:
                int wallCardChoosed;
                System.out.println("Quel mur voulez vous jouer ?");
                for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
                    System.out.print((i + 1) + ". ");
                    System.out.println(player.wallCardHand.get(i).getWallCardType());
                }
                wallCardChoosed = scNb.nextInt();
                int xWall;
                int yWall;
                boolean WallValide = false;
                do {
                    System.out.println("A quelles coordonnées souhaitez vous le placer ?");
                    System.out.println("X ?");
                    xWall = scNb.nextInt();
                    System.out.println("Y ?");
                    yWall = scNb.nextInt();
                    if (grid.grid[xWall][yWall].getState() == 'E') {
                        grid.grid[xWall][yWall].setState(player.wallCardHand.get(wallCardChoosed).getWallCardType());
                    } else {
                        System.out.println("Cet emplacement n'est pas valide, choisissez en un autre.");
                        WallValide = true;
                    }
                } while (WallValide == false);
                System.out.println("mouvement validé");
                break;
            case 3:
                break;
        }
    }

    public void showWallCardHand(Player player) {
        System.out.print("Voici vos murs disponibles :");
        for (int i = 0; i < (player.getWallCardHand()).size(); i++) {
            System.out.print(player.wallCardHand.get(i).getWallCardType()+"  ");
        }
    }
}
