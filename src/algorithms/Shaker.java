package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Shaker {
    public static void main(String[] args) {
        int[] mass = new int[10000];
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            mass[i] = rand.nextInt(10000);
        }
        shakerSort(mass);
    }
    static void shakerSort(int[] mass){
        long start = System.currentTimeMillis();
        int qup=1;
        int qdwn=0;

        while (qdwn + qup != mass.length){
            for (int i = qdwn; i < mass.length-qup; i++) {
                int buff = mass[i+1];
                if (mass[i] > mass[i+1]) {
                    mass[i+1] = mass[i];
                    mass[i] = buff;
                }
            }
            qup++;
            if(qdwn + qup == mass.length){
                break;
            }
            for (int i = mass.length-qup; i > qdwn; i--) {
                int buff = mass[i-1];
                if (mass[i] < mass[i-1]) {
                    mass[i-1] = mass[i];
                    mass[i] = buff;
                }
            }
            qdwn++;
        }

        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "мсек");
        System.out.println(Arrays.toString(mass));
    }
}
