package lesson5;

import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) throws InterruptedException {
        final int size = 10000000;
        final float inputValue = 1.0f;
        float[] arrFirst = method1(size, inputValue);
        float[] arrSecond = method2(size, inputValue);
        System.out.println(Arrays.equals(arrFirst, arrSecond));

    }

    private synchronized static float[] method1(int size, float inputValue) {
        float[] arr = new float[size];
        Arrays.fill(arr, inputValue);
        long start;

        start = System.currentTimeMillis();
        calculation(arr);
        long duration = System.currentTimeMillis() - start;
        System.out.println("Длительность расчета одним потоком: " + duration);

        return arr;
    }

    private synchronized static float[] method2(int size, float inputValue) throws InterruptedException {
        float[] arr = new float[size];
        int half = size / 2;
        Arrays.fill(arr, inputValue);

        long start;
        start = System.currentTimeMillis();

        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);
//      Создание двух потоков для ускорения расчета
        Thread thread1 = new Thread(() -> calculation(arr1), "T1");
        Thread thread2 = new Thread(() -> calculation2(arr2), "T2");
//      Запуск потоков
        thread1.start();
        thread2.start();
//      Ожидание завершения работы потоков
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        long duration = System.currentTimeMillis() - start;
        System.out.println("Длительность расчета двумя потоками: " + duration);
        return arr;
    }

    private static void calculation(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void calculation2(float[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) ((arr[i]) * Math.sin(0.2f + (n + i) / 5) * Math.cos(0.2f + (n + i) / 5) * Math.cos(0.4f + (n + i) / 2));
        }
    }


}
