package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Board {

    //Propriedade e posição no tabuleiro
    private Map<Property, Integer> board;

    public Board(String gameFile){
        computeBoard(gameFile);
    }

    public static void computeBoard(String gamefile){
        File file = new File(gamefile);
        Scanner sc = null;
        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()){
                //System.out.println(sc.nextLine());
                String line[] = sc.nextLine().split(" +");
                int selling_price = Integer.parseInt(line[0]);
                int loan_price = Integer.parseInt(line[1]);

                Property property = new Property(null, selling_price, loan_price, false);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Board tabuleiro = new Board("gameConfig.txt");
    }

}
