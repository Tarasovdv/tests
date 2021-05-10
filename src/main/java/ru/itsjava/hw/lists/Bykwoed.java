package ru.itsjava.hw.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Bykwoed {
    public static void main(String[] args) {
        List<Book> booksEmptyCollection = new ArrayList<Book>(); // пустой размер 10
        List<Book> booksEmptyCollection_20 = new ArrayList<Book>(20); // пустой размер 20

        Book java = new Book("Философия Java", "Bruce Eckel");
        Book itsJava = new Book("itsJava", "Виталий Нежинский");
        Book musk = new Book("Elon Musk", "Eshley Vens");
        Book startup = new Book("Стартап на Милиард", "Максим Спиридонов");
        Book rich = new Book("Самый богатый человек в Вавилоне", "Джордж Клейсон");
        Book six = new Book("six", "six");
        Book seven = new Book("seven", "seven");


        List<Book> myBooks = new ArrayList<Book>(Arrays.asList(java, itsJava, musk, startup, rich));

//        System.out.println(myBooks.get(0));
//        System.out.println(myBooks.get(myBooks.size() - 1));

        System.out.println("Old List");
        printList(myBooks);

        System.out.println("\nNew List");
        myBooks.add(0, seven);
        myBooks.add(2, six);
        List<Book> secondList = new ArrayList<Book>();
        secondList.addAll(myBooks);
        printList(secondList);

        Iterator<Book> bookIterator = secondList.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getNaming().equals("seven")) {
                bookIterator.remove();
            }
        }

        secondList.remove(2);
        System.out.println("\nNext List");
        printList(secondList);

        System.out.println(secondList.contains(musk));


    }

    public static void printList(List<Book> list) {
        int count = 0;
        for (Object element : list) {
            System.out.println(count + ") : " + element);
            count++;
        }
    }


}


