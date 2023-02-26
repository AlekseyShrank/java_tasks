package operations;

/*
Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых пользователем вещественных чисел.
Для вычисления модуля используйте тернарную условную операцию.
Для ввода чисел используем класс Scanner.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MoreLess {
    public static void main(String[] args) {

        System.out.println("Введите 3 числа");
        ArrayList<Double> numbers = new ArrayList<Double>();
        while (numbers.size() < 3){
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextDouble()){
                numbers.add(sc.nextDouble());
            }else{
                System.out.println("Это не число");
            }
        }
        double min = numbers.get(0);
        min = min<0 ? min*(-1.0) : min;
        int id_min = 0;
        int i = 0;
        for (double n : numbers){
            double abs = n<0 ? n*(-1.0) : n;
            if(abs < min){
                min = abs;
                id_min = i;
            }
            i++;
        }
        System.out.println("Наименьшее число по модулю: "+numbers.get(id_min));
    }
}
