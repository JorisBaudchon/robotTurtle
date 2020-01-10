package com.company;

import java.util.*;

import static com.company.Verifications.*;

import com.company.Player.*;

import static com.company.Grid.*;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> Players;

    public void initGame() {
        System.out.println("Bienvenue au jeu ROBOT TURTLE !");
        boolean newGame = AskNewGame();
        if (!newGame) {
            System.out.println("Merci d'être venu !");
        } else {
            ArrayList<Player> Players = new ArrayList<Player>();
            numberOfPlayers = AskNumberOfPlayers();
            for (int i = 0; i < numberOfPlayers; i++) {
                String newPlayer = AskNewPlayer(i + 1);
                Player player = new Player(newPlayer, 1);
                Players.add(player);
            }
            InitTurnOrder();
            InitGrid(numberOfPlayers);
            PlaceTurtle(numberOfPlayers);
            PlaceJewel(numberOfPlayers);
            //InitDeck(numberOfPlayers);

        }
    }

    private boolean AskNewGame() {
        String entre;
        do {
            System.out.println("Souhaitez vous faire une partie de ROBOT TURTLE ?");
            entre = scTxt.nextLine();
        } while (!entre.equals("oui") && !entre.equals("non") && !entre.equals("o") && !entre.equals("n"));
        return entre.equals("oui") || entre.equals("o");
    }

    private int AskNumberOfPlayers() {
        int entre;
        do {
            System.out.println("Combien y aura t-il de joueurs ?");
            entre = scNb.nextInt();
        } while ((entre != 2) && (entre != 3) && (entre != 4));
        return entre;
    }

    private String AskNewPlayer(int i) {
        String entre;
        do {
            System.out.println("Quel est le pseudo du joueur " + i + " ?");
            entre = scTxt.nextLine();
        } while (entre.isEmpty());
        return entre;
    }

    private void InitTurnOrder() {
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            index.add(i + 1);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            int randomIndex = rand.nextInt(index.size());
            System.out.println(Players);
            Player player = Players.get(i);
            System.out.println(player);
            player.setPlayerTurn(randomIndex);
            index.remove(randomIndex);
        }
    }
}