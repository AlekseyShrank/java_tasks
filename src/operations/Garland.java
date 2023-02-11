package operations;

import java.util.Random;

/*
Имеется гирлянда, состоящая из 32 лампочек. Каждая лампочка имеет два состояния - включена или выключена.
В начале работы программы случайным образом задайте какие лампочки будут включены. Напишите следующие методы:

метод blink, который будет мигать лампочками гирлянды один раз (операция ~);
метод run, который будет запускать гирлянду в режим бегущей строки (операция << или >>);
метод isFirstLampOn, который будет выяснять включена ли лампочка в первой позиции (наложение маски с помощью &);
Используйте побитовые операции.
 */

public class Garland {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt()*-1; //В отрицательных числах, при выводе бинарного кода отображаются все 32 бита из-за первой единицы. Это чисто для наглядности работы программы.
        System.out.println(Integer.toBinaryString(num));
        num = blink(num);
        run(num);
    }

    public static int blink(int num){
        System.out.println(Integer.toBinaryString(~num));
        return ~num;
    }

    public static void run(int num){
        for (int i = 0; i < 32; i++) {
            if(num<0){
                num = num<<1;
                num++;
            }else {
                num = num<<1;
            }
            System.out.println(Integer.toBinaryString(num));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isFirstLampOn(int num){
        if((num & -2147483648) == 0){
            return false;
        }else {
            return true;
        }
    }
}
