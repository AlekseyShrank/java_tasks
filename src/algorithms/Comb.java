package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Comb {
    public static void main(String[] args) {
        int[] mass = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            mass[i] = rand.nextInt(10000);
        }
        combSort(mass);
    }
    static void combSort(int[] mass){
        double factor = 1.247;
        int step = mass.length-1;

        long start = System.currentTimeMillis();
        while (step >= 1){
            for (int i = 0; i + step < mass.length; i++) {
                int buff = mass[i+step];
                if (mass[i] > mass[i+step]) {
                    mass[i+step] = mass[i];
                    mass[i] = buff;
                }
            }
            step /= factor;
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "мсек");
        System.out.println(Arrays.toString(mass));
    }
}
