package operators;

/*
Распечатать все числа от 1 до 100, которые делятся на 5 без остатка.
 */

public class DivFive {
    public static void main(String[] args) {
        int i=0;
        while (100 > i++){
            if(i%5==0){
                System.out.println(i);
            }
        }
    }
}
