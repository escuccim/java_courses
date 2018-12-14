import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        ArrayList < Integer >  numbers = new ArrayList < Integer > ();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.remove(2);
        numbers.set(1, 0);
        numbers.add(5);
        numbers.remove(0);
        System.out.println(numbers);
    }

    public static void twoDimensions(int[][] numbers){
        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = 0; j < numbers[i].length - 1; j++){
                if (numbers[i][j] < numbers[i][j + 1]){
                    numbers[i][j] = numbers[i][j] + numbers[i + 1][j];
                    numbers[i + 1][j] = numbers[i + 1][j] / 2;
                }
            }
            System.out.println(Arrays.toString((numbers[i])));
        }

    }

    public static void change (int[] arr) {
        int k = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (k < arr[i]) {
                arr[0] = arr[i];
                arr[i] = k;
                k = arr[0];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void mystery3(ArrayList<Integer> list){
        for(int i = list.size() - 2; i > 0; i--){
            int a = list.get(i);
            int b = list.get(i + 1);
            list.set(i, a + b);
        }
        System.out.println(list);
    }

    public static int puzzle(int i, int j) {
        if (i == j) {
            return 0;
        } else {
            return 1 + puzzle(i - 2, j - 1);
        }
    }

    public static void intro(){
        Scanner input = new Scanner(System.in);

        // get name and destination
    }

    public static void budget(){
        Scanner input = new Scanner(System.in);
    }

    public static void time(){
        Scanner input = new Scanner(System.in);
    }

    public static void distance(){
        Scanner input = new Scanner(System.in);
    }
}
