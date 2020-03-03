package lesson2;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(int arrayLength) {
        super("Размер массива не соответствует размеру 4х4! Размер исходного массива " + arrayLength + "х" + arrayLength);
    }
}
