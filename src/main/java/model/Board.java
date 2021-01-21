package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {

    //Propriedade e posição no tabuleiro
    private Map<Integer, Property> board = new HashMap<Integer, Property>();
    private int propertiesQtd = 0;

    public Board(String gameFile){
        computeBoard(gameFile);
    }

    public void computeBoard(String gamefile){
        File file = new File(gamefile);
        Scanner sc = null;
        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()){
                //System.out.println(sc.nextLine());
                String line[] = sc.nextLine().split(" +");
                int selling_price = Integer.parseInt(line[0]);
                int loan_price = Integer.parseInt(line[1]);

                this.propertiesQtd++;
                Property property = new Property(selling_price, loan_price, propertiesQtd);
                board.put(this.propertiesQtd, property);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getPropertiesQtd(){
        return this.propertiesQtd;
    }

    public Map<Integer, Property> getBoard() {
        return board;
    }

    public void resetBoard(){
        for (Integer place : board.keySet()){
            Property property = board.get(place);
            property.resetProperty();
        }
    }

    @Override
    public String toString() {
        String st = "{propertiesQtd= " + propertiesQtd + ", board=[";
        for(Integer place : board.keySet()){
            st += "\n";
            Property property = board.get(place);
            st += property.toString() + ",";
        }
        st += "]";
        return st;
    }
}
