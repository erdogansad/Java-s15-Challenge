package member;

import java.util.*;

import book.Book;
import enums.Availability;
import enums.Status;

public class Subscription implements Borrowable {
    private LinkedList memberList;
    private Book book;

    public Subscription() {
        this.memberList = new LinkedList();
    }

    public void addNewMember(Member member) {
        if (!memberList.contains(member)) {
            memberList.add(member);
        }
    }

    public Map<Integer, Member> getAllMembers() {
        Map<Integer, Member> allMemberMap = new HashMap<>();
        Iterator iterator = memberList.iterator();
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            if (!member.getStatus().name().equals(Status.CLOSED.name())) {
                allMemberMap.put(member.getMemberId(), member);
            }
        }
        return allMemberMap;
    }

    public Map<Integer, Member> getMemberById(int Id) {
        Map<Integer, Member> filteredId = new HashMap<>();
        Iterator iterator = memberList.iterator();
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            if (member.getMemberId() == (Id)) {
                filteredId.put(member.getMemberId(), member);
            }
        }
        return filteredId;
    }

    public Map<Integer, Member> removeMemberById(int Id) {
        Map<Integer, Member> allMemberMap = new HashMap<>();
        Iterator iterator = memberList.iterator();
        while (iterator.hasNext()) {
            Member member = (Member) iterator.next();
            if (!member.getStatus().name().equals(Status.CLOSED.name()) && member.getMemberId() == (Id)) {
                iterator.remove();
                member.setStatus(Status.CLOSED);
            }
        }
        return allMemberMap;
    }

    @Override
    public boolean checkMemberStatus(int memberId) {
        Member member = getAllMembers().get(memberId);
        return member.getStatus().name().equals(Status.LIVE.name());

    }

    @Override
    public boolean checkBookAvailability(Book book) {
        return book.getAvailability().name().equals(Availability.AVAILABLE.name());

    }

    public void borrowBook(int memberId, Book book) {
        Member member = getAllMembers().get(memberId);
        try {
            if (member.getMemberId() == memberId && checkMemberStatus(memberId) && checkBookAvailability(book)) {
                int[] bookList = member.getBorrowedBooks();
                for (int i = 0; i < 5; i++) {
                    if (bookList[i] == 0) {
                        bookList[i] = book.getId();
                        book.setAvailability(Availability.BORROWED);
                        book.setLastMemberId(memberId);
                        break;
                    } else {
                        System.out.println("The member reach to the borrowing limit");
                    }

                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("The member can not borrow a book");
        }
    }

    public void returnBook(int memberId, Book book) {

        Map<Integer, Member> memberIdMap = getAllMembers();
        Iterator iterator = memberIdMap.values().iterator();
        Member member = memberIdMap.get(memberId);
        int[] bookList = member.getBorrowedBooks();
        if (member.getMemberId() == memberId) {
            int index = -1;
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i] == book.getId()) {
                    index = i;
                    break;
                }
            }
            bookList[index] = 0;
            member.setBorrowedBooks(bookList);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
