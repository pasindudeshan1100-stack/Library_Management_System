package Controllers.Books;

import Model.IssueBookDTO;
import Model.ReturnBookDTO;
import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class BookHistoryPageController {


    public TableView historyTable;
    public TableColumn colMemberId;
    public TableColumn colBookId;
    public TableColumn colBookTitle;
    public TableColumn colIssueDate;
    public TableColumn colDueDate;
    public TableColumn colReturnDate;
    public TableColumn colStatus;

    public void DashboardbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Dashboard/home.fxml");

    }

    public void BooksbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_page.fxml");

    }

    public void MemberbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Members/member_page.fxml");

    }

    public void IssuebtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/issue_book_page.fxml");

    }

    public void ReturnbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/return_book_page.fxml");

    }

    public void HistorybtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_history_page.fxml");

    }
}
