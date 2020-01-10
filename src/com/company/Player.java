package com.company;

public class Player {
    
    private String couleur;
    public List<Carte> main = new ArrayList<Carte>();
    private List<Carte> pioche;
    private int playerTurn;
    private String pseudo;
    private char orientation;


    public Player(String pseudo, int playerTurn) {
        this.pseudo = pseudo;
        this.playerTurn = playerTurn;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
<<<<<<< HEAD

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
=======
    
    public String getPseudo() {
		return this.pseudo;
	}
    
    public String couleurPlayer() {
		return this.couleur;
	}
    
    public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}
    
	public List<Carte> getMain(){
		return this.main;
	}
    
>>>>>>> 514750729597b235a6fe52a52ede6ae85ee6102d
}
