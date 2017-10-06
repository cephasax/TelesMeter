package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ViewSummaryStation {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acpPanelVSS;

    @FXML
    private ImageView imgGotaVSS;

    @FXML
    private Button butBackVSS;

    @FXML
    private Button butExportVSS;

    @FXML
    private Text txtTitleVSS;

    @FXML
    private Text txtSubtitleVSS;

    @FXML
    private Hyperlink link_reusefiltersVSS;

    @FXML
    private MenuBar menuVSS;

    @FXML
    private Menu menFileVSS;

    @FXML
    private MenuItem menuiCloseVSS;

    @FXML
    private Menu menEditVSS;

    @FXML
    private MenuItem menuiDeleteVSS;

    @FXML
    private Menu menHelpVSS;

    @FXML
    private MenuItem menuiAboutVSS;

    @FXML
    private ProgressIndicator progssIndicatorVSS;

    @FXML
    private Text txtvAnswerVSS;

    @FXML
    private TitledPane titpPanelFiltersVSS;

    @FXML
    void backPreviousScreen(ActionEvent event) {

    }

    @FXML
    void closeEverything(ActionEvent event) {

    }

    @FXML
    void deleteEverything(ActionEvent event) {

    }

    @FXML
    void exportStations(ActionEvent event) {

    }

    @FXML
    void reuseFilters(ActionEvent event) {

    }

    @FXML
    void showAboutSystem(ActionEvent event) {

    }

    @FXML
    void showEditOptions(ActionEvent event) {

    }

    @FXML
    void showFileOptions(ActionEvent event) {

    }

    @FXML
    void showHelpOptions(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acpPanelVSS != null : "fx:id=\"acpPanelVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert imgGotaVSS != null : "fx:id=\"imgGotaVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert butBackVSS != null : "fx:id=\"butBackVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert butExportVSS != null : "fx:id=\"butExportVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert txtTitleVSS != null : "fx:id=\"txtTitleVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert txtSubtitleVSS != null : "fx:id=\"txtSubtitleVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert link_reusefiltersVSS != null : "fx:id=\"link_reusefiltersVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menuVSS != null : "fx:id=\"menuVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menFileVSS != null : "fx:id=\"menFileVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menuiCloseVSS != null : "fx:id=\"menuiCloseVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menEditVSS != null : "fx:id=\"menEditVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menuiDeleteVSS != null : "fx:id=\"menuiDeleteVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menHelpVSS != null : "fx:id=\"menHelpVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert menuiAboutVSS != null : "fx:id=\"menuiAboutVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert progssIndicatorVSS != null : "fx:id=\"progssIndicatorVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert txtvAnswerVSS != null : "fx:id=\"txtvAnswerVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";
        assert titpPanelFiltersVSS != null : "fx:id=\"titpPanelFiltersVSS\" was not injected: check your FXML file 'ViewSummaryStation.fxml'.";

    }
}
