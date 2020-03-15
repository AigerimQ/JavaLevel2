package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TelephoneBook {
//    Создаем новую коллекцию telephoneBook.
//    Так как под одной фамилией может быть несколько номеров, коллекция HashMap включает в себя еще одну коллекцию Set(коллекция номеров).
    private HashMap<String, Set<String>> telephoneBook = new HashMap<>();


    public void add(String surname, String telephoneNumber) {
        Set<String> telNumberList = telephoneBook.get(surname);
//      Если список номеров под данной фамилией не был создан, то создается новый список.
        if (telNumberList == null) telNumberList = new HashSet<>();
        telNumberList.add(telephoneNumber);
        telephoneBook.put(surname, telNumberList);
    }

    public Set<String> get(String surname) {
        return telephoneBook.get(surname);
    }

    public void info() {
        System.out.println("Телефонный справочник" + telephoneBook);
    }
}
