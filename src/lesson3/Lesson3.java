package lesson3;

import java.util.*;

public class Lesson3 {
    public static void main(String[] args) {
        String[] fruitBoxArray = {"Apple", "Orange", "Kiwi", "Banana", "Grape", "Apple", "Mango", "Peach", "Pear", "Orange", "Banana", "Melon", "Kiwi", "Apple", "Watermelon", "Orange"};

//        В принципе с задачей вывода уникальных значений справляется и HashMap))
//        Set<String> fruitBox = new HashSet<>(Arrays.asList(fruitBoxArray));
//        System.out.println(fruitBox);

//        Создаем пустой Map, где будет записано в первую чередь - название фрукта, во вторую очередь - количество дубликатов
        Map<String, Integer> fruitMap = new HashMap<>();
        for (String fruit : fruitBoxArray)
            if (fruitMap.containsKey(fruit)) {
                fruitMap.put(fruit, fruitMap.get(fruit) + 1);
            } else {
                fruitMap.put(fruit, 1);
            }
        System.out.println(fruitMap);
    }
}
