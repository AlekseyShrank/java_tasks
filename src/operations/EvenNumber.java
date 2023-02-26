package operations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EvenNumber {
/*
Создать программу, которая будет сообщать, является ли целое число, введённое пользователем, чётным или нет.
Ввод числа осуществлять с помощью класса Scanner.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

    public static void main(String[] args) {
        System.out.println("Введите целое число.");
        int number = 0;

        while (true){
            Scanner sc=new Scanner(System.in);
            if (sc.hasNextInt()){
                number = sc.nextInt();
                ifEven(number);
                sc.close();
                return;
            }
            System.out.println("Это не целое число!!! Попробуй ещё раз");
        }
    }
    public static void ifEven(int number){
        String answer = "не четное";
        if(number % 2 == 0){answer = "четное";}

        //то же самое
        //answer = number%2==0 ? "четное":"не четное";

        System.out.println("Это число "+ answer );
    }
}
