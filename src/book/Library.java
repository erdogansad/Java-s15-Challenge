package book;

import java.util.*;

import enums.Availability;

public class Library {
    private LinkedList<Book> database;

    public Library() {
        database = new LinkedList<>();
    }

    public void addNewBook(Book book) {
        if (!database.contains(book)) {
            database.add(book);
        } else {
            System.out.println("This id has been already entried. ");
        }

    }

    public Map<Integer, Book> getAllBooks() {
        Map<Integer, Book> allBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (!book.getAvailability().name().equals(Availability.DELETED.name())) {
                allBookMap.put(book.getId(), book);
            }
        }
        return allBookMap;
    }

    public Map<Integer, Book> getAvailableBooks() {
        Map<Integer, Book> availableBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getAvailability().name().equals(Availability.AVAILABLE.name())) {
                availableBookMap.put(book.getId(), book);
            }

        }
        return availableBookMap;
    }

    public Map<Integer, Book> getBorrowedBooks() {
        Map<Integer, Book> borrowedBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getAvailability().name().equals(Availability.BORROWED.name())) {
                borrowedBookMap.put(book.getId(), book);
            }

        }
        return borrowedBookMap;

    }

    public Map<Integer, Book> getLostBooks() {
        Map<Integer, Book> lostBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getAvailability().name().equals(Availability.LOST.name())) {
                lostBookMap.put(book.getId(), book);
            }

        }
        return lostBookMap;
    }

    public Map<Integer, Book> getDeletedBooks() {
        Map<Integer, Book> deletedBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getAvailability().name().equals(Availability.DELETED.name())) {
                deletedBookMap.put(book.getId(), book);
            }

        }
        return deletedBookMap;
    }

    public Map<Integer, Book> getByWriter(String writer) {
        Map<Integer, Book> availableBooks = getAvailableBooks();
        Map<Integer, Book> filteredWriters = new HashMap<>();
        Iterator iterator = availableBooks.values().iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getWriter().equals(writer)) {
                filteredWriters.put(book.getId(), book);
            }
        }
        return filteredWriters;
    }

    public Map<Integer, Book> getByName(String name) {
        Map<Integer, Book> availableBooks = getAvailableBooks();
        Map<Integer, Book> filteredNames = new HashMap<>();
        Iterator iterator = availableBooks.values().iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getName().equals(name)) {
                filteredNames.put(book.getId(), book);
            }
        }
        return filteredNames;
    }

    public Map<Integer, Book> getBookById(int Id) {
        Map<Integer, Book> filteredId = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.getId() == (Id)) {
                filteredId.put(book.getId(), book);
            }
        }
        return filteredId;
    }

    public Map<Integer, Book> removeBookById(int Id) {
        Map<Integer, Book> allBookMap = new HashMap<>();
        Iterator iterator = database.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (!book.getAvailability().name().equals(Availability.DELETED.name()) && book.getId() == (Id)) {
                iterator.remove();
                book.setAvailability(Availability.DELETED);
            }
        }

        return allBookMap;
    }

}