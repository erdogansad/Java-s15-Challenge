package member;

import java.util.Arrays;
import java.util.Objects;

import book.Book;
import enums.Status;

public class Member {
    private int memberId;
    private String name;
    private String lastName;
    private Status status;
    private int[] borrowedBooks;
    private Book book;

    public Member(int memberId, String name, String lastName, Status status) {
        this.memberId = memberId;
        this.name = name;
        this.lastName = lastName;
        this.status = status;
        this.borrowedBooks = new int[5];
    }

    public int getMemberId() {
        return memberId;
    }

    public int[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBorrowedBooks(int[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("memberId:" + memberId + "\n");
        builder.append("Name:" + name + "\n");
        builder.append("LastName:" + lastName + "\n");
        builder.append("Status:" + status + "\n");
        builder.append("BorrowedBooks:" + Arrays.toString(borrowedBooks) + "\n");

        return builder.toString();
    }
}
