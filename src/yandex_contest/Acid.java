package yandex_contest;

import java.io.*;
import java.util.Random;

/*
Андрей работает в секретной химической лаборатории, в которой производят опасную кислоту с удивительными свойствами. У Андрея есть n
 бесконечно больших резервуаров, расположенных в один ряд. Изначально в каждом резервуаре находится некоторое количество кислоты. Начальство Андрея требует, чтобы во всех резервуарах содержался одинаковый объем кислоты. К сожалению, разливающий аппарат несовершенен. За одну операцию он способен разлить по одному литру кислоты в каждый из первых
k (1≤k≤n) резервуаров. Обратите внимание, что для разных операций k могут быть разными. Поскольку кислота очень дорогая, Андрею не разрешается выливать кислоту из резервуаров. Андрей просит вас узнать, можно ли уравнять объемы кислоты в резервуарах, и, если это возможно, то посчитать минимальное количество операций, которое потребуется, чтобы этого достичь.
Формат ввода
Первая строка содержит число n (1≤n≤100000) — количество резервуаров.
Во второй строке содержатся n целых чисел ai (1≤ai≤109), где ai означает исходный объём кислоты в i-м резервуаре в литрах.

Формат вывода
Если объемы кислоты в резервуарах можно уравнять, выведите минимальное количество операций, необходимых для этого.
Если это невозможно, выведите «-1».
 */

public class Acid {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String ns = "",as = "";
        int n;
        try {
            ns = bufferedReader.readLine();
            as = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

//        String[] test = test();
//        System.out.println(test[0]+ "\n"+test[1]);
//        ns = test[0];
//        as = test[1];

        if(ns.isEmpty() || as.isEmpty()){
            System.out.println(-1);
            System.exit(0);
        }

        String asm[] = as.split(" ");
        if(asm.length<2){
            System.out.println(0);
            System.exit(0);
        }
        int a[] =new int[asm.length];
        try {
            n = Integer.parseInt(ns);
            for(int i = 0; i < n; i++){
                a[i]=Integer.parseInt(asm[i]);
            }
        } catch (NumberFormatException nu) {
            nu.printStackTrace();
            System.exit(1);
        }

        int max;
        int min = max = a[0];
//        int i = 1;
//        while (min == max){
//            if(min < a[i]){
//                max=a[i];
//                break;
//            }
//            if(min > a[i]){
//                System.out.println(-1);
//                System.exit(0);
//            }
//            if(i == a.length -1){
//                System.out.println(0);
//                System.exit(0);
//            }
//            i++;
//        }
//
//
//        for(int q = i; q < a.length; q++){
//            if(a[q] != max){
//                System.out.println(-1);
//                System.exit(0);
//            }
//        }

        for (int q = 1; q < a.length; q++){
            if(max > a[q]){
                System.out.println(-1);
                System.exit(0);
            }
            if(max < a[q]){
                max = a[q];
            }
        }

        System.out.println(max-min);



    }

    static String[] test(){
        String[] test = new String[2];
        Random ran = new Random();
        int i = ran.nextInt(4);
        test[0] = Integer.toString(i);
        test[1] = Integer.toString(ran.nextInt(5));
        for (int j = 0; j < i-1; j++) {
            test[1] = test[1] + " " + ran.nextInt(5);
        }
        return test;
    }
}
