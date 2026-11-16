package Controllers.Members;

import Model.BookDTO;
import Model.MemberDTO;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AddMemberPageController {
    public Button btnUpdate;
    public Button btnDelete;


    AddMemberController addMemberController=new AddMemberController();
    MemberDTO memberDTO=new MemberDTO();

    @FXML
    private Label lblMessage;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhone;

     MemberPageController    memberPageController=new MemberPageController();
    @FXML
    void AddbtnOnAction(ActionEvent event) {

        memberDTO.setName(txtFullName.getText().trim());
        memberDTO.setEmail(txtEmail.getText().trim());
        memberDTO.setPhonenumber(txtPhone.getText().trim());
        memberDTO.setAdress(txtAddress.getText().trim());

        if (
                memberDTO.getId().isBlank() ||
                        memberDTO.getName().isBlank() ||
                        memberDTO.getEmail().isBlank() ||
                        memberDTO.getPhonenumber().isBlank() ||
                        memberDTO.getAdress().isBlank()
        ) {

            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

        }

        boolean isadded = addMemberController.addMember(memberDTO);

        if (isadded) {

            new Alert(Alert.AlertType.INFORMATION, "New Member Added Successfully!").show();
            clearfields();

        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Add Member.").show();
        }
    }

    private void clearfields() {
        txtMemberId.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtAddress.clear();

    }

    @FXML
    void ResetbtnOnAction(ActionEvent event) {
    txtMemberId.clear();
    txtFullName.clear();
    txtEmail.clear();
    txtPhone.clear();
    txtEmail.clear();
    txtAddress.clear();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        memberDTO.setName(txtFullName.getText().trim());
        memberDTO.setEmail(txtEmail.getText().trim());
        memberDTO.setPhonenumber(txtPhone.getText().trim());
        memberDTO.setAdress(txtAddress.getText().trim());

        boolean isUpdate= addMemberController.UpdateMember(
                memberDTO.getName(),
                memberDTO.getEmail(),
                memberDTO.getAdress(),
                memberDTO.getPhonenumber()

        );
        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION," Member updated Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to update Member.").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        memberDTO.setName(txtFullName.getText().trim());
        memberDTO.setEmail(txtEmail.getText().trim());
        memberDTO.setPhonenumber(txtPhone.getText().trim());
        memberDTO.setAdress(txtAddress.getText().trim());

        boolean isDelete= addMemberController.deleteMember(
               memberDTO.getId()

        );
        if (isDelete){
            new Alert(Alert.AlertType.INFORMATION," Member Deleted Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to delete Member.").show();
        }
    }
    public void initialize(){
        txtMemberId.textProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    if (newValue==null||newValue.trim().isEmpty()){
                        clearfields();
                    }else {
                        loadMemberDetails(newValue.trim());
                    }
                })
        );
    }
    public void loadMemberDetails(String memberId){
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM members WHERE member_id=?;";
        try {
            PreparedStatement preparedStatement=  connection.prepareStatement(sql);
            preparedStatement.setString(1,memberId);

            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
            txtFullName.setText(resultSet.getString("full_name"));
            txtEmail.setText(resultSet.getString("email"));
            txtAddress.setText(resultSet.getString("adress"));
            txtPhone.setText(resultSet.getString("phone_number"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

