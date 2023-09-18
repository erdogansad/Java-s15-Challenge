package member;

import book.Book;

public interface Borrowable {
    boolean checkMemberStatus(int memberId);

    boolean checkBookAvailability(Book book);
}
