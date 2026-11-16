package Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer book_id;
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

    public BookEntity(Integer book_id, String title, String author, String category, Integer year, Integer quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.quantity = quantity;
    }

    public Integer getBookid() {
        return book_id;
    }

    public void setBookid(Integer book_id) {
        this.book_id = book_id;
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
