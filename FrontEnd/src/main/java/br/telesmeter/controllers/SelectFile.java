package br.telesmeter.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SelectFile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acp_SF;

    @FXML
    private Button but_attachfileSF;

    @FXML
    private Button but_closeSF;

    @FXML
    private Text txtf_SF;

    @FXML
    private TextField txtbox_filenameSF;

    @FXML
    void AttachFileSF(ActionEvent event) {

    }

    @FXML
    void GetFileNameSF(ActionEvent event) {

    }

    @FXML
    void closeSF(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acp_SF != null : "fx:id=\"acp_SF\" was not injected: check your FXML file 'SelectFile.fxml'.";
        assert but_attachfileSF != null : "fx:id=\"but_attachfileSF\" was not injected: check your FXML file 'SelectFile.fxml'.";
        assert but_closeSF != null : "fx:id=\"but_closeSF\" was not injected: check your FXML file 'SelectFile.fxml'.";
        assert txtf_SF != null : "fx:id=\"txtf_SF\" was not injected: check your FXML file 'SelectFile.fxml'.";
        assert txtbox_filenameSF != null : "fx:id=\"txtbox_filenameSF\" was not injected: check your FXML file 'SelectFile.fxml'.";

    }
}

