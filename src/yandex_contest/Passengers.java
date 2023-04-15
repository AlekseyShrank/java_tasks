package yandex_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 В самолете n рядов и по три кресла слева и справа в каждом ряду. Крайние кресла (A и F) находятся у окна, центральные (C и D) – у прохода.
 На регистрацию приходят группы из одного, двух или трех пассажиров. Они желают сидеть рядом, то есть на одном ряду и на одной стороне: левой или правой.
 Например, группа из двух пассажиров может сесть на кресла B и C, но не может сесть на кресла C и D, потому что они разделены проходом,
 а также не может сесть на кресла A и C, потому что тогда они окажутся не рядом.
 Кроме того, один из пассажиров каждой группы очень требовательный – он хочет сесть либо у окна, либо у прохода.
 Конечно же, каждая группа из пассажиров хочет занять места в ряду с как можно меньшим номером, ведь тогда они скорее выйдут из самолета после посадки.
 Для каждой группы пассажиров определите, есть ли места в самолете, подходящие для них.

 Формат ввода

 Первая строка содержит число
n (1≤n≤100) – количество рядов в самолете. Далее в n строках вводится изначальная рассадка в самолете по рядам (от первого до n-го), где символами . (точка) обозначены свободные места,
символами # (решетка) обозначены занятые места, а символами _ (нижнее подчеркивание) обозначен проход между креслами C и D каждого ряда.
Следующая строка содержит число m (1≤m≤100) – количество групп пассажиров. Далее в m строках содержатся описания групп пассажиров. Формат описания такой: numsideposition, где num – количество пассажиров
(число 1, 2 или 3), side – желаемая сторона самолета (строка left или right), position
 – желаемое место требовательного пассажира (строка aisle или window).

 Формат вывода

 Если группа может сесть на места, удовлетворяющие ее требованиям, то выведите строку Passengers can take seats: и список их мест в формате rowletter, упорядоченный по возрастанию буквы места.
 Затем выведите в n строках получившуюся рассадку в самолете, в формате, описанном выше, причем места, занятые текущей группой пассажиров, должны быть обозначены символом X.
Если группа не может найти места, удовлетворяющие ее требованиям, то выведите строку Cannot fulfill passengers requirements.

пример ввода
4
..._.#.
.##_...
.#._.##
..._...
7
2 left aisle
3 right window
2 left window
3 left aisle
1 right window
2 right window
1 right window

вывод

Passengers can take seats: 1B 1C
.XX_.#.
.##_...
.#._.##
..._...
Passengers can take seats: 2D 2E 2F
.##_.#.
.##_XXX
.#._.##
..._...
Passengers can take seats: 4A 4B
.##_.#.
.##_###
.#._.##
XX._...
Cannot fulfill passengers requirements
Passengers can take seats: 1F
.##_.#X
.##_###
.#._.##
##._...
Passengers can take seats: 4E 4F
.##_.##
.##_###
.#._.##
##._.XX
Cannot fulfill passengers requirements


 */

public class Passengers {
    public static void seats(int seats[][], String rule){
        String out = "";
        int pas_sum = Integer.parseInt(rule.subSequence(0,1).toString());
        int side = 1;
        int sup_place = 2;
        if(rule.contains("left")){
            side = 0;
        }
        if(rule.contains("window")){
            sup_place *= side;
        }else {
            sup_place = sup_place - 2*side;
        }
        int row = 0;
        int occ_place[] = {0,0,0};
        String seats_out = seatsToString(seats);


        for (int i = side; i < seats.length; i += 2) {
            if(seats[i][sup_place] == 0){
                if(pas_sum == 1){
                    row = (i/2) + 1;
                    occ_place[sup_place] = 1;
                    out += "Passengers can take seats:";
                    seats_out = seatsToString(seats,i,occ_place);
                    seats[i][sup_place] = 1;
                    break;
                }else if(pas_sum == 2){
                    if(seats[i][1] == 0){
                        row = (i/2) + 1;
                        occ_place[sup_place] = 1;
                        occ_place[1] = 1;
                        out += "Passengers can take seats:";
                        seats_out = seatsToString(seats,i,occ_place);
                        seats[i][sup_place] = 1;
                        seats[i][1] = 1;
                        break;
                    }
                }else if(pas_sum == 3){
                    if(seats[i][1] == 0 && seats[i][Math.abs(sup_place-2)] == 0){
                        row = (i/2) + 1;
                        occ_place[sup_place] = 1;
                        occ_place[1] = 1;
                        occ_place[Math.abs(sup_place-2)] = 1;
                        out += "Passengers can take seats:";
                        seats_out = seatsToString(seats,i,occ_place);
                        seats[i][sup_place] = 1;
                        seats[i][1] = 1;
                        seats[i][Math.abs(sup_place-2)] = 1;
                        break;
                    }
                }
            }
        }

        if(row == 0){
            System.out.println("Cannot fulfill passengers requirements");
        }else {
            for (int i = 0; i < 3; i++) {
                if(occ_place[i] == 1){
                    char ch = 'A';
                    ch += (i+(3*side));
                    out = out + " " + row + ch;
                }
            }
            System.out.println(out);
            System.out.print(seats_out);
        }
    }

    static String seatsToString(int p[][]){
        String out="";
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(p[i][j]==0){
                    out = out + ".";
                }else {
                    out = out + "#";
                }
            }
            if(i%2==0){
                out = out + "_";
            }else{
                out = out + "\n";
            }
        }
        return out;
    }

    static String seatsToString(int p[][], int row, int occ[]){
        String out="";
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==row){
                    if(p[i][j]==0 && occ[j]==0){
                        out = out + ".";
                    }else if(p[i][j]==0 && occ[j]==1){
                        out = out + "X";
                    }else {
                    out = out + "#";
                    }
                }else{
                    if(p[i][j]==0 ){
                        out = out + ".";
                    }else {
                        out = out + "#";
                    }
                }
            }
            if(i%2==0){
                out = out + "_";
            }else{
                out = out + "\n";
            }
        }
        return out;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        int p[][];
        String rules[];
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            p = new int[n*2][3];
            for (int i = 0; i < n; i++) {
                String s[] = bufferedReader.readLine().split("_");
                for (int j = 0; j < 3; j++) {
                    if(s[0].charAt(j)=='.'){
                        p[i*2][j] = 0;
                    }else {
                        p[i*2][j] = 1;
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if(s[1].charAt(j)=='.'){
                        p[i*2+1][j] = 0;
                    }else {
                        p[i*2+1][j] = 1;
                    }
                }
            }
            m = Integer.parseInt(bufferedReader.readLine());
            rules = new String[m];
            for (int i = 0; i < m; i++) {
                rules[i] = bufferedReader.readLine();
            }
            for (int i = 0; i < m; i++) {
                seats(p,rules[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
