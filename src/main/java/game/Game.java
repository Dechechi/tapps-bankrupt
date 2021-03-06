package game;

import model.Board;
import model.Player;
import purchase.PurchaseCautious;
import purchase.PurchaseInpulsive;
import purchase.PurchasePicky;
import purchase.PurchaseRandom;
import util.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    public static List<String> winners = new ArrayList<>();
    public static List<Integer> rounds = new ArrayList<>();

    public Game(){
    }

    public static int calcAverage(List<Integer> rounds){
        int sum = 0;
        for(Integer round : rounds){
            sum += round;
        }
        return sum / rounds.size();
    }

    public static void main(String[] args) {
        int roundsToPlay = 300; // trocar valor para validar diferentes quantidades de partidas
        for(int i = 0; i < roundsToPlay; i++){

            Board board = new Board("gameConfig.txt");
            Dice dice = new Dice(1,6); // altere os valores dos dados para jogr com dados com mais faces (Valores inclusivos)

            //Nesse campo pode-se criar quantos jogadores desejar, basta depois adiciona-los na lista de players

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

            round.playRound(false); // coloque true para ter um print com o status final de cada partida executada
            winners.add(round.getWinner().getName());
            rounds.add(round.roundsQtd);
        }

        int p1Ocurrancies = Collections.frequency(winners, "Player1");
        int p2Ocurrancies = Collections.frequency(winners, "Player2");
        int p3Ocurrancies = Collections.frequency(winners, "Player3");
        int p4Ocurrancies = Collections.frequency(winners, "Player4");

        int average = calcAverage(rounds);
        int ocurrancies = Collections.frequency(rounds, 1000);

        System.out.println("Resultados para a simulação de 300 partidas!");
        System.out.println("Numero de vitorias do Player1 (Comportamento impulsivo).....: " + p1Ocurrancies);
        System.out.println("Numero de vitorias do Player2 (Comportamento exigente)......: " + p2Ocurrancies);
        System.out.println("Numero de vitorias do Player3 (Comportamento cauteloso).....: " + p3Ocurrancies);
        System.out.println("Numero de vitorias do Player4 (Comportamento aleatorio).....: " + p4Ocurrancies);
        System.out.println("Numero medio de rodadas para a partida acabar: " + average);
        System.out.println("Numero de vezes que a partida acabou na milessima rodada: " + ocurrancies);
    }
}
