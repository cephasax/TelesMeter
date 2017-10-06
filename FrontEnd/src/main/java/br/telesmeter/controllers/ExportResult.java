package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ExportResult {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acpPanelER;

    @FXML
    private TextField txtBoxNameFileER;

    @FXML
    private Button butBackER;

    @FXML
    private Button butSaveER;

    @FXML
    private SplitMenuButton slpMenuTypeER;

    @FXML
    private MenuItem menuITxtER;

    @FXML
    private MenuItem menuIPdfER;

    @FXML
    private MenuItem menuICsvER;

    @FXML
    private MenuItem menuIJsonER;

    @FXML
    private ImageView imgGotaER;

    @FXML
    private MenuBar menuBarER;

    @FXML
    private Menu menuFileER;

    @FXML
    private MenuItem menuiCloseER;

    @FXML
    private Menu menuEditER;

    @FXML
    private MenuItem menuiDeleteER;

    @FXML
    private Menu menuHelpER;

    @FXML
    private MenuItem menuiAboutER;

    @FXML
    void backPreviousScreen(ActionEvent event) {

    }

    @FXML
    void chooseTypeFile(ActionEvent event) {

    }

    @FXML
    void closeEverything(ActionEvent event) {

    }

    @FXML
    void deleteEverything(ActionEvent event) {

    }

    @FXML
    void exportFile(ActionEvent event) {

    }

    @FXML
    void putFileName(ActionEvent event) {

    }

    @FXML
    void saveAsCsv(ActionEvent event) {

    }

    @FXML
    void saveAsJson(ActionEvent event) {

    }

    @FXML
    void saveAsPdf(ActionEvent event) {

    }

    @FXML
    void saveAsTxt(ActionEvent event) {

    }

    @FXML
    void showAboutSystem(ActionEvent event) {

    }

    @FXML
    void showEditOption(ActionEvent event) {

    }

    @FXML
    void showFileOption(ActionEvent event) {

    }

    @FXML
    void showHelpOption(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acpPanelER != null : "fx:id=\"acpPanelER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert txtBoxNameFileER != null : "fx:id=\"txtBoxNameFileER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert butBackER != null : "fx:id=\"butBackER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert butSaveER != null : "fx:id=\"butSaveER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert slpMenuTypeER != null : "fx:id=\"slpMenuTypeER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuITxtER != null : "fx:id=\"menuITxtER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuIPdfER != null : "fx:id=\"menuIPdfER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuICsvER != null : "fx:id=\"menuICsvER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuIJsonER != null : "fx:id=\"menuIJsonER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert imgGotaER != null : "fx:id=\"imgGotaER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuBarER != null : "fx:id=\"menuBarER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuFileER != null : "fx:id=\"menuFileER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuiCloseER != null : "fx:id=\"menuiCloseER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuEditER != null : "fx:id=\"menuEditER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuiDeleteER != null : "fx:id=\"menuiDeleteER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuHelpER != null : "fx:id=\"menuHelpER\" was not injected: check your FXML file 'ExportResults.fxml'.";
        assert menuiAboutER != null : "fx:id=\"menuiAboutER\" was not injected: check your FXML file 'ExportResults.fxml'.";

    }
}
