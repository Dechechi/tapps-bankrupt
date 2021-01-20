package Game;

import Model.Board;
import Model.Player;
import Model.Property;
import PurchaseExecution.PurchaseCautious;
import PurchaseExecution.PurchaseInpulsive;
import PurchaseExecution.PurchasePicky;
import PurchaseExecution.PurchaseRandom;
import Util.Dice;

import java.util.*;

public class Round {

    public Board board;
    public Dice dice;
    public List<Player> players = new ArrayList<Player>();
    public List<Player> deadPlayers = new ArrayList<Player>();
    public Player winner;
    public int roundsQtd;

    public Round(Board board, Dice dice, List<Player> players){
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public int getRoundsQtd() {
        return roundsQtd;
    }

    public void setRoundsQtd(int value){
        this.roundsQtd = value;
    }

    public List<Player> getDeadPlayers() {
        return deadPlayers;
    }

    public Board getBoard() {
        return board;
    }

    public void playRound(boolean logs){
        boolean gameOver = false;
        for(roundsQtd = 1; roundsQtd <= 1000 && !gameOver; roundsQtd++){
            Iterator<Player> iterator = players.iterator();
            while (iterator.hasNext()) {
                Player player = iterator.next();
                    player.walk(dice.runDice(), board.getPropertiesQtd());
                    Property property = board.getBoard().get(player.getPosition());
                    if(property.getOwner() == null){
                        if(player.executePurchase(property)){
                            property.setOwner(player);
                        }
                    } else {
                        if(property.getOwner() != player){
                            player.payLoan(property);
                            if(!player.isAlive()){
                                player.resetProperties();
                                deadPlayers.add(player);
                                iterator.remove();
                            }
                        }
                    }
            }
            gameOver = checkEndGame(gameOver);
        }
        roundsQtd--;
        if(!gameOver){
            getGameWinner();
        }
        if(logs){
            endGameStatus();
        }
    }

    public boolean checkEndGame(boolean status){
        if(players.size() == 1){
            status = true;
            winner = players.get(0);
        }
        return status;
    }

    public void getGameWinner(){
        winner = players.get(0);
        for(int i = 1; i < players.size(); i++){
            deadPlayers.add(winner);
            winner = players.get(i);
        }
    }

    public void resetRound(List<Player> newPlayers){
        board.resetBoard();
        roundsQtd = 1;
        players = newPlayers;
        deadPlayers = new ArrayList<Player>();
        winner = null;
    }

    public void endGameStatus(){
        System.out.println("##################### GAME OVER STATUS #####################\n");
        System.out.println("BOARD:");
        System.out.println(board + "\n");
        System.out.println("LOOSERS:");
        for(Player player : deadPlayers){
            System.out.println(player);
        }
        System.out.println("");
        System.out.println("WINNER:");
        System.out.println(winner + "\n");
        System.out.println("ROUNDS PLAYED: " + roundsQtd);
    }

    public static void main(String[] args) {
        Board board = new Board("gameConfig.txt");
        Dice dice = new Dice(1,6);

        Player player1 = new Player("Player1", new PurchaseInpulsive());
        Player player2 = new Player("Player2", new PurchasePicky());
        Player player3 = new Player("Player3", new PurchaseCautious());
        Player player4 = new Player("Player4", new PurchaseRandom());

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        Round round = new Round(board, dice, players);

        boolean gameOver = false;
        int qtd;
        for(qtd = 1; qtd <= 1000 && !gameOver; qtd++){
            Iterator<Player> iterator = players.iterator();
            while (iterator.hasNext()) {
                Player player = iterator.next();
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ PLAYER $$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
                System.out.println(player);
                player.walk(dice.runDice(), board.getPropertiesQtd());
                System.out.println("Rodando o dado.................. " + dice.getValue());
                Property property = board.getBoard().get(player.getPosition());
                if(property.getOwner() == null){
                    System.out.println("Propriedade sem dono: " + property + "\n");
                    if(player.executePurchase(property)){
                        property.setOwner(player);
                        System.out.println("O player decidiu comprar!!!!!!!!!!!\n");
                    } else {
                        System.out.println("O player decidiu NAO comprar!!!!!!!\n");
                    }
                } else {
                    if(property.getOwner() != player){
                        System.out.println("Propriedade com dono: " + property);
                        player.payLoan(property);
                        System.out.println("O player " + player.getName() + " teve de pagar aluguel para o player " + property.getOwner().getName() + "\n");
                        if(!player.isAlive()){
                            player.resetProperties();
                            round.getDeadPlayers().add(player);
                            iterator.remove();
                            System.out.println("O player " + player.getName() + " ficou com saldo negativo e perdeu o jogo\n");
                        }
                    }
                }
            }
            System.out.println("############### ENDED ROUND " + qtd + " ###############\n");
            gameOver = round.checkEndGame(gameOver);
        }
        qtd--;
        round.setRoundsQtd(qtd);
        if(!gameOver){
            round.getGameWinner();
        }
        round.endGameStatus();
    }
}
