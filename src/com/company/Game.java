package com.company;

import java.util.*;

import static com.company.Verifications.*;

public class Game {
    private int numberOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();
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
                System.out.println(this.players.get(i));
            }
            InitTurnOrder();
            showTurnOrder();
            grid.initGrid(numberOfPlayers);
            grid.placeTurtle(numberOfPlayers);
            grid.placeJewel(numberOfPlayers);
            grid.displayGridConsole();
            //InitDeck(numberOfPlayers);

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

    private void InitTurnOrder() {
        Random rand = new Random();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            index.add(i + 1);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(index);
            int randomIndex = rand.nextInt(index.size());
            Player player = this.players.get(i);
            player.setPlayerTurn(index.get(randomIndex));
            index.remove(randomIndex);
        }
    }

    private void showTurnOrder() {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println((players.get(i)).getPlayerTurn());
        }
    }
    
    public void execute(){
        
    }
    
    public void buildWall(){
        
    }
    
    public void completeProgramme(){
        
    }

}
