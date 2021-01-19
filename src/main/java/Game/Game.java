package Game;

import Model.Board;
import Model.Player;
import PurchaseExecution.PurchaseCautious;
import PurchaseExecution.PurchaseInpulsive;
import PurchaseExecution.PurchasePicky;
import PurchaseExecution.PurchaseRandom;
import Util.Dice;

public class Game {

    public Player winner;
    public int rounds;

    public static void main(String[] args) {
        Board board = new Board("gameConfig.txt");
        Dice dice = new Dice(1,6);

        Player player1 = new Player("Player1", new PurchaseInpulsive());
        Player player2 = new Player("Player2", new PurchasePicky());
        Player player3 = new Player("Player3", new PurchaseCautious());
        Player player4 = new Player("Player4", new PurchaseRandom());
    }
}
