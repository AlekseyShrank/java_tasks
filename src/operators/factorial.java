package operators;

/*
Реализовать подсчет факториала используя цикл for. Число n задается случайным образом (используйте Math.random()). Оно должно быть в диапазоне от 0 до 5
 */

public class factorial {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 5);
        int ns = n;
        System.out.println(n);
        for (int i = 1; i < ns; i++) {
            n=n*i;
        }
        if(n==0){
            System.out.println(1);
        }else {
            System.out.println(n);
        }
    }
}
