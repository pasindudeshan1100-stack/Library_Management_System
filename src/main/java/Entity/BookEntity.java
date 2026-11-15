package Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Audited;

@Entity
@Table(name ="book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String book_id;
    @Column(name ="book_title",nullable = false,length =150 )
    private  String book_title;
    @Column(name = "author",nullable = false)
    private  String author;
    @Column(name = "category",nullable = false)
    private String  category;
    @Column(name = "published_year",nullable = false)
    private Integer published_year;
    @Column(name = "quantity",nullable = false)
    private  Integer quantity;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
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

    public Integer getPublished_year() {
        return published_year;
    }

    public void setPublished_year(Integer published_year) {
        this.published_year = published_year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BookEntity() {
    }

    public BookEntity(String book_id, String book_title, String author, String category, Integer published_year, Integer quantity) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.category = category;
        this.published_year = published_year;
        this.quantity = quantity;
    }
}
