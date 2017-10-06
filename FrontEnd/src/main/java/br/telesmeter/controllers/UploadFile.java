package br.telesmeter.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class UploadFile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acp_UF;

    @FXML
    private SplitPane slp_loadingUF;

    @FXML
    private ProgressBar progss_loadingUF;

    @FXML
    private Text txtf_loadingUF;

    @FXML
    private Text txtf_instructionUF;

    @FXML
    private Button but_cancelUF;

    @FXML
    private Button but_okUF;

    @FXML
    void CancelUploadUF(ActionEvent event) {

    }

    @FXML
    void UploadFileUF(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acp_UF != null : "fx:id=\"acp_UF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert slp_loadingUF != null : "fx:id=\"slp_loadingUF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert progss_loadingUF != null : "fx:id=\"progss_loadingUF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert txtf_loadingUF != null : "fx:id=\"txtf_loadingUF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert txtf_instructionUF != null : "fx:id=\"txtf_instructionUF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert but_cancelUF != null : "fx:id=\"but_cancelUF\" was not injected: check your FXML file 'UploadFile.fxml'.";
        assert but_okUF != null : "fx:id=\"but_okUF\" was not injected: check your FXML file 'UploadFile.fxml'.";

    }
}
