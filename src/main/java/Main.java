import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int input() {
        int input = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите модификатор: ");
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите целое число");
            input();
        }
        scanner.close();
        return input;
    }


    public static void main(final String[] args) {
        int input = input();
        final int size = 10;

        int[] arrayA = FilledArray.getFilledArray(size, input,
                (Integer::sum));
        System.out.println(Arrays.toString(arrayA));

        int[] arrayB = FilledArray.getFilledArray(size, input,
                ((i, modifier) ->
                        i * modifier));
        System.out.println(Arrays.toString(arrayB));

        int[] arrayC = FilledArray.getFilledArray(size, input,
                ((i, modifier) -> {
                    if (i % 2 == 0) {
                        return i / 2 + modifier;
                    } else {
                        return i * i - modifier;
                    }
                }));
        System.out.println(Arrays.toString(arrayC));

        // Квадрат итендификатора + квадрат модификатора
        int[] arrayD = FilledArray.getFilledArray(size, input,
                ((i, modifier) ->
                        i * i + modifier * modifier));
        System.out.println(Arrays.toString(arrayD));

        /* Если сумма итендификатора и модификатора четная, то элемент массива: итендификатор умножить
        на модификатор и отнять идентификатор. Если сумма нечетная: к произведению итендификатора и
        модификатора прибавить итендификатор
         */
        int[] arrayE = FilledArray.getFilledArray(size, input,
                ((i, modifier) -> {
                    if (i + modifier == 0) {
                        return i * modifier - i;
                    } else {
                        return i * modifier + i;
                    }
                }));
        System.out.println(Arrays.toString(arrayE));
    }
}
