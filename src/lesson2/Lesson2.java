package lesson2;

import java.util.Random;

public class Lesson2 {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr2;
        arr2 = createArray();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }

        if (arr2.length != 4) {
            throw new MyArraySizeException(arr2.length);
        }

        int[][] arrInt = new int[arr2.length][arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                try {
                    arrInt[i][j] = Integer.parseInt(arr2[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("В ячейке " + i + "x" + j + " массива содержится символ вместо числа. Преобразование остановлено!");
                }
            }
        }
        System.out.println("Сумма элементов массива равна " + sumArrayElements(arrInt));
    }

    private static String[][] createArray() {
        int iMax = new Random().nextInt(3) + 3;
        String[][] arr2 = new String[iMax][iMax];
        String[] arr1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a"};
        for (int i = 0; i < iMax; i++)
            for (int j = 0; j < iMax; j++) {
                String a = arr1[new Random().nextInt(10)];
                arr2[i][j] = a;
            }
        return arr2;
    }

    private static int sumArrayElements(int arrInt[][]) {
        int a = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt.length; j++) {
                a = a + (arrInt[i][j]);
            }
            System.out.println();
        }
        return a;
    }


}
