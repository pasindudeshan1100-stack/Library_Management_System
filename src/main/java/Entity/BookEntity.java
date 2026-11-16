package Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookid;
    @Column(name ="book_title",nullable = false,length =150 )
    private  String title;
    @Column(name = "author",nullable = false)
    private  String author;
    @Column(name = "category",nullable = false)
    private String  category;
    @Column(name = "published_year",nullable = false)
    private Integer year;
    @Column(name = "quantity",nullable = false)
    private  Integer quantity;

    public BookEntity() {
    }

    public BookEntity(String bookid, String title, String author, String category, Integer year, Integer quantity) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.quantity = quantity;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
