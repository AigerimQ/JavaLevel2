package lesson2;

public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException(int arraySize, int rowsIndex, int columnIndex) {
        super(String.format("Размер массива не соответствует размеру %dх%d! Размер массива %dх%d", arraySize, arraySize, rowsIndex, columnIndex));
    }
}
