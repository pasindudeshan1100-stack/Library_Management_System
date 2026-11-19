package Entity;

import jakarta.persistence.*;

public class BookHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "issue_date", nullable = false)
    private  IssueBookEntity issueDate;

    @ManyToOne
    @JoinColumn(name = "due_date", nullable = false)
    private IssueBookEntity dueDate;

    @ManyToOne
    @JoinColumn(name = "return_id",nullable = false)
    private ReturnBookEntity returnDate;

    @Column(name = "status", nullable = false)
    private String status;

    public BookHistoryEntity() {
    }

    public BookHistoryEntity(Integer historyId, BookEntity book, MemberEntity member, IssueBookEntity issueDate, IssueBookEntity dueDate, ReturnBookEntity returnDate, String status) {
        this.historyId = historyId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

    public IssueBookEntity getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(IssueBookEntity issueDate) {
        this.issueDate = issueDate;
    }

    public IssueBookEntity getDueDate() {
        return dueDate;
    }

    public void setDueDate(IssueBookEntity dueDate) {
        this.dueDate = dueDate;
    }

    public ReturnBookEntity getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(ReturnBookEntity returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
