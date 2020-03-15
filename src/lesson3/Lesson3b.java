package lesson3;

public class Lesson3b {

    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();

        telephoneBook.add("Petrov", "+7(900)-263-256");
        telephoneBook.add("Ivanov", "+7(900)-214-254");
        telephoneBook.add("Romanov", "+7(900)-235-569");
        telephoneBook.add("Alekseeva", "+7(900)-254-896");
        telephoneBook.add("Petrov", "+7(900)-781-856");
        telephoneBook.add("Ivanov", "+7(900)-147-852");
        telephoneBook.add("Ivanov", "+7(900)-123-586");

        telephoneBook.info();

        System.out.println("Телефоны, записанные на имя Ivanov" + telephoneBook.get("Ivanov"));
        System.out.println("Телефоны, записанные на имя Petrov" + telephoneBook.get("Petrov"));
        System.out.println("Телефоны, записанные на имя Alekseeva" + telephoneBook.get("Alekseeva"));
    }

}
