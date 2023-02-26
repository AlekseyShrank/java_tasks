package algorithms;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Bubble {
    public static void main(String[] args) {
        int[] mass = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            mass[i] = rand.nextInt(10000);
        }
        bubbleSort(mass);
    }
    static void bubbleSort(int[] mass){
        long start = System.currentTimeMillis();
        for (int q = 1; q < mass.length; q++) {
            for (int i = 0; i < mass.length-q; i++) {
                int buff = mass[i+1];
                if (mass[i] > mass[i+1]) {
                    mass[i+1] = mass[i];
                    mass[i] = buff;
                }
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "мсек");
        System.out.println(Arrays.toString(mass));
    }
}
