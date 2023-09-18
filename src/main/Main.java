package main;

import book.Book;
import book.Library;
import enums.Status;
import member.Member;
import member.Subscription;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(0, "The Lord of the Rings", "J. R. R. Tolkien", "", null, 1954, null);
        Book book2 = new Book(1, "The Hobbit", "J. R. R. Tolkien", "", null, 1937, null);

        Member member1 = new Member(1, "John", "Doe", Status.LIVE);

        Library database = new Library();
        database.addNewBook(book1);
        database.addNewBook(book2);
        System.out.println("--------------");
        System.out.println(database.getByName("The Hobbit"));
        System.out.println(database.getAllBooks());
        Subscription memberList = new Subscription();
        memberList.addNewMember(member1);
    }
}