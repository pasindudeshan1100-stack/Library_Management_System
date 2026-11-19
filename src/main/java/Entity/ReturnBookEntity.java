package Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "returnBook")
public class ReturnBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer returnId;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    public ReturnBookEntity() {
    }

    public ReturnBookEntity(Integer returnId, MemberEntity member, BookEntity book, LocalDate returnDate) {
        this.returnId = returnId;
        this.member = member;
        this.book = book;
        this.returnDate = returnDate;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
