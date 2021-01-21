package util;

import java.util.Random;

public class Dice {

    private int value;
    private int min;
    private int max;

    public Dice(int min, int max){
        this.min = min;
        this.max = max;
        this.value = runDice();
    }

    public int runDice(){
        Random random = new Random();
        this.value = random.nextInt(this.max + 1 - this.min) + this.min;
        return this.value;
    }

    public int getValue() {
        return this.value;
    }

    /*public static void main(String arg[]){
        Dice dado = new Dice(1,6);
        System.out.println(dado.value);

        for (int i =0; i < 100; i++){
            Dice dados = new Dice(1,6);
            System.out.println("Dado " + i + ": " + dados.value + " E busquei valor: " + dados.getValue());
        }
    }*/

}
