package Controllers.Members;

import Entity.BookEntity;
import Entity.MemberEntity;
import Model.BookDTO;
import Model.MemberDTO;
import Service.AddMemberService;
import Service.AddMemberServiceImpl;
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

    AddMemberService service=new AddMemberServiceImpl();
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


    @FXML
    void AddbtnOnAction(ActionEvent event) {

        memberDTO.setName(txtFullName.getText().trim());
        memberDTO.setEmail(txtEmail.getText().trim());
        memberDTO.setPhonenumber(txtPhone.getText().trim());
        memberDTO.setAdress(txtAddress.getText().trim());

        if (
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

        boolean isadded = service.addMemberDetails(memberDTO);

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

        memberDTO.setId(txtMemberId.getText().trim());
        memberDTO.setName(txtFullName.getText().trim());
        memberDTO.setEmail(txtEmail.getText().trim());
        memberDTO.setPhonenumber(txtPhone.getText().trim());
        memberDTO.setAdress(txtAddress.getText().trim());

        boolean isUpdate= service.updateMemberDetails(memberDTO);
        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION," Member updated Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to update Member.").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        memberDTO.setId(txtMemberId.getText().trim());

        boolean isDelete=service.deletememberDetails (
                Integer.valueOf(memberDTO.getId())

        );
        if (isDelete){
            new Alert(Alert.AlertType.INFORMATION," Member Deleted Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to delete Member.").show();
        }
    }
    public  void  searchMemberDetails(ActionEvent actionEvent){
        try {
            Integer id = Integer.valueOf(txtMemberId.getText().trim());
            Entity.MemberEntity member = service.searchMemberDetails(id);
            if (member != null) {
                txtFullName.setText(member.getName());
                txtEmail.setText(member.getEmail());
                txtAddress.setText(member.getAdress());
                txtPhone.setText(member.getPhoneNumber());
            } else {
                new Alert(Alert.AlertType.WARNING, "Member Not Found!").showAndWait();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Invalid Member ID!").showAndWait();
        }


    }
    public void initialize(){
        txtMemberId.setOnAction(actionEvent ->searchMemberDetails(actionEvent)  );
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

