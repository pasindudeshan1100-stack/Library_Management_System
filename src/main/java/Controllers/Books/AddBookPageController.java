package Controllers.Books;

import Entity.BookEntity;
import Model.BookDTO;
import Service.AddBookService;
import Service.AddBookServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookPageController  implements Initializable {

    AddBookService service=new AddBookServiceImpl();

    public Button btnUpdate;
    public Button btnDelete;

    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;

    @FXML
    void addBookOnAction(ActionEvent event) {

        if (txtAuthor.getText().trim().isBlank()
                || txtBookTitle.getText().trim().isBlank()
                || cmbCategory.getValue() == null
                || txtQuantity.getText().trim().isBlank()
                || txtPublishedYear.getText().trim().isBlank()) {

            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

            return;
        }

        try {
            BookDTO book = new BookDTO();
            book.setAuthor(txtAuthor.getText().trim());
            book.setTitle(txtBookTitle.getText().trim());
            book.setCategory(cmbCategory.getValue());
            book.setYear(Integer.valueOf(txtPublishedYear.getText().trim()));
            book.setQuantity(Integer.valueOf(txtQuantity.getText().trim()));

            boolean isAdded=service.addBookDetails(book);

            if (isAdded){
                new Alert(Alert.AlertType.INFORMATION,"New Book added Successfully!").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"Failed to add Book").show();
            }

        } catch (NumberFormatException e) {

            new Alert(
                    Alert.AlertType.ERROR,
                    "Please enter valid numbers for Year and Quantity!"
            ).showAndWait();

        } catch (Exception e) {

            e.printStackTrace();

            new Alert(
                    Alert.AlertType.ERROR,
                    "Error: " + e.getMessage()
            ).showAndWait();
        }
        clearFields();
    }


    @FXML
    void clearFields() {
        txtAuthor.clear();
        txtBookId.clear();
        txtBookTitle.clear();
        txtQuantity.clear();
        txtPublishedYear.clear();
        cmbCategory.setValue(null);

    }

    public void searchBook(ActionEvent event) {

//        Connection connection= DBConnection.getInstance().getConnection();
//
//        String sql="SELECT * FROM books WHERE book_id = ?;";
//        try {
//            PreparedStatement preparedStatement= connection.prepareStatement(sql);
//            preparedStatement.setString(1,bookId);
//            ResultSet resultSet= preparedStatement.executeQuery();
//            if (resultSet.next()){
//                txtAuthor.setText(resultSet.getString("author"));
//                txtBookTitle.setText(resultSet.getString("book_title"));
//                cmbCategory.setValue(resultSet.getString("category"));
//                txtPublishedYear.setText(String.valueOf(resultSet.getInt("published_year")));
//                txtQuantity.setText(String.valueOf(resultSet.getInt("quantity")));
//
//            }
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
        try {

            Integer id = Integer.valueOf(txtBookId.getText().trim());
            BookEntity bookEntity = service.searchBookDetails(id);
            if (bookEntity != null) {
                txtAuthor.setText(bookEntity.getAuthor());
                txtBookTitle.setText(bookEntity.getTitle());
                cmbCategory.setValue(bookEntity.getCategory());
                txtQuantity.setText(String.valueOf(bookEntity.getQuantity()));
                txtPublishedYear.setText(String.valueOf(bookEntity.getYear()));
            } else {
                new Alert(Alert.AlertType.WARNING, "Book Not Found!").showAndWait();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Invalid Book ID!").showAndWait();
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {

        if (txtAuthor.getText().trim().isBlank()
                || txtBookTitle.getText().trim().isBlank()
                || cmbCategory.getValue() == null
                || txtQuantity.getText().trim().isBlank()
                || txtPublishedYear.getText().trim().isBlank()) {

            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

            return;
        }

        try {

            BookDTO book = new BookDTO();
            book.setBookid(txtBookId.getText().trim());
            book.setAuthor(txtAuthor.getText().trim());
            book.setTitle(txtBookTitle.getText().trim());
            book.setCategory(cmbCategory.getValue());
            book.setYear(Integer.valueOf(txtPublishedYear.getText().trim()));
            book.setQuantity(Integer.valueOf(txtQuantity.getText().trim()));

            boolean isUpdated = service.updateBookdetails(book);

            if (isUpdated) {
                new Alert(
                        Alert.AlertType.INFORMATION,
                        "Updated Book Successfully!"
                ).showAndWait();

                clearFields();

            } else {
                new Alert(
                        Alert.AlertType.ERROR,
                        "Failed to update Book!"
                ).showAndWait();
            }

        } catch (NumberFormatException e) {

            new Alert(
                    Alert.AlertType.ERROR,
                    "Please enter valid numbers for Year and Quantity!"
            ).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    public void DeleteOnAction(ActionEvent actionEvent) {
//       String id=txtBookId.getText().trim();
//
//      boolean isDeleted= addBookController.deleteBooks(id);
//      if (isDeleted){
//          new Alert(Alert.AlertType.INFORMATION,"Delete Book Successfully!").show();
//
//      }else {
//          new Alert(Alert.AlertType.ERROR,"Failed to delete Book!").show();
//      }
//     clearFields();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCategory.getItems().addAll(
                "Fiction",
                "Non-Fiction",
                "Science",
                "Technology",
                "Computer Science",
                "Education",
                "History",
                "Biography",
                "Mystery",
                "Fantasy",
                "Romance",
                "Horror",
                "Adventure",
                "Self-Help",
                "Business",
                "Mathematics",
                "Literature",
                "Reference"
        );
        txtBookId.setOnAction(event -> searchBook(event));
    }
}



