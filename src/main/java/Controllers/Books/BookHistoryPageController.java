package Controllers.Books;

import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class BookHistoryPageController {



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
