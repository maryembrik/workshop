package Controllers;

import Models.User;
import Services.UserServices;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


import java.awt.event.ActionEvent;

public class view {
    UserServices US;

    view(){
        US=new UserServices();

    }

    @FXML
    private TextField lastnameText;

    @FXML
    private TextField firstnameText;

    @FXML
    private TextField ageText;

    @FXML
    void Save(ActionEvent event) {
        User U =new User();
        U.setFirstName(firstnameText.getText());
        U.setLastName(lastnameText.getText());
        U.setAge(Integer.parseInt(ageText.getText()));
        try {
            US.insert(U);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("User Added successfully");
            alert.showAndWait();
        }

    }



}