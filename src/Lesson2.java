package lesson2;

import java.util.Random;

public class Lesson2 {
    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr2 = createArray();
//        String[][] correctArray = {
//                {"1", "2", "3", "4"},
//                {"5", "6", "7", "8"},
//                {"9", "10", "11", "12"},
//                {"13", "14", "15", "16"},
//        };
//        String[][] incorrectArray = {
//                {"1", "2", "3", "4"},
//                {"5", "6", "o", "8"},
//                {"9", "10", "11", "12"},
//                {"13", "14", "15", "16"},
//        };


        try {
            int sum = sumArrayElements(arr2);
//            int sum = sumArrayElements(correctArray);
//            int sum = sumArrayElements(incorrectArray);
            System.out.println("Сумма элементов массива равна " + sum);

        } catch (MyArraySizeException e) {
            System.out.println("Некорректный размер массива!");
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println("В ячейке массива содержится символ вместо числа!");
            System.out.println(e.getMessage());

        }
    }


    private static String[][] createArray() {
        int iMax = new Random().nextInt(2) + 3;
        int jMax = new Random().nextInt(2) + 3;
        String[][] arr2 = new String[iMax][jMax];
        String[] arr1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "s1", "s2"};
        for (int i = 0; i < iMax; i++)
            for (int j = 0; j < jMax; j++) {
                String a = arr1[new Random().nextInt(11)];
                arr2[i][j] = a;
            }
        return arr2;
    }

    private static int sumArrayElements(String[][] arrString) throws MyArraySizeException {
        printArray(arrString);
        int rows = arrString.length;
        int column = arrString[0].length;

        if (rows != Lesson2.ARRAY_SIZE || column != Lesson2.ARRAY_SIZE) {
            throw new MyArraySizeException(Lesson2.ARRAY_SIZE, rows, column);
        }

        int sum = 0;
        for (int i = 0; i < arrString.length; i++) {
            for (int j = 0; j < arrString.length; j++) {
                try {
                    sum += Integer.parseInt(arrString[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке %dx%d массива содержится символ '%s' вместо числа. Преобразование остановлено!", i, j, arrString[i][j]));
                }
            }
        }
        return sum;
    }

    private static void printArray(String[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }

}
