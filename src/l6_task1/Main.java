package l6_task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Anonymn and Functional
        NumbersService numbersService = new NumbersService() {
            @Override
            public int chetNechet(int a) {
                if(a % 2 == 0){
                    System.out.print("Chet: ");
                    return a;
                } else {
                    System.out.print("Nechet: ");
                    return a;
                }
            }
        };
        System.out.print("1) Enter the number: ");
        System.out.println(numbersService.chetNechet(new Scanner(System.in).nextInt()));
        //Lambda
        NumbersService nLambda = a -> {
            if(a % 2 == 0){
                System.out.print("Chet: ");
                return a;
            } else {
                System.out.print("Nechet: ");
                return a;
            }
        };
        System.out.print("2) Enter the number: ");
        System.out.println(nLambda.chetNechet(new Scanner(System.in).nextInt()));
    }
}
