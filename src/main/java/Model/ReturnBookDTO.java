package Model;

import java.util.Date;

public class ReturnBookDTO {
    private String memberId;
    private  String bookId;
    private  String booktitle;
    private Date returnDate;

    public ReturnBookDTO() {
    }

    public ReturnBookDTO(String memberId, String bookId, String booktitle, Date returnDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.booktitle = booktitle;
        this.returnDate = returnDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
