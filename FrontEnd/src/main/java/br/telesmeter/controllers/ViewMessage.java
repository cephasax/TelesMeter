package br.telesmeter.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ViewMessage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acp_VM;

    @FXML
    private ImageView img_sucessVM;

    @FXML
    private Text txtf_messageVM;

    @FXML
    private Button but_closeVM;

    @FXML
    private Button but_addnewfileVM;

    @FXML
    void AddNewFileVM(ActionEvent event) {

    }

    @FXML
    void CloseVM(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acp_VM != null : "fx:id=\"acp_VM\" was not injected: check your FXML file 'ViewMessage.fxml'.";
        assert img_sucessVM != null : "fx:id=\"img_sucessVM\" was not injected: check your FXML file 'ViewMessage.fxml'.";
        assert txtf_messageVM != null : "fx:id=\"txtf_messageVM\" was not injected: check your FXML file 'ViewMessage.fxml'.";
        assert but_closeVM != null : "fx:id=\"but_closeVM\" was not injected: check your FXML file 'ViewMessage.fxml'.";
        assert but_addnewfileVM != null : "fx:id=\"but_addnewfileVM\" was not injected: check your FXML file 'ViewMessage.fxml'.";

    }
}
