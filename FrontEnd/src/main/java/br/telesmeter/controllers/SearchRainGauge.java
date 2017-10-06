package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SearchRainGauge {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane acpPanelSRG;

    @FXML
    private Button butBackSRG;

    @FXML
    private Button butSearchSRG;

    @FXML
    private TextField txtBoxNameSRG;

    @FXML
    private TextField txtBoxStateSRG;

    @FXML
    private TextField txtBoxCitySRG;

    @FXML
    private ComboBox<?> cmbRegionSRG;

    @FXML
    private Text textinfoSRG;

    @FXML
    private MenuBar menuBarSRG;

    @FXML
    private Menu menuFileSRG;

    @FXML
    private MenuItem menuiCloseSRG;

    @FXML
    private Menu menuEditSRG;

    @FXML
    private MenuItem menuiDeleteSRG;

    @FXML
    private Menu menuHelpSRG;

    @FXML
    private MenuItem menuiAboutSRG;

    @FXML
    private TextField txtBoxLatitudeSRG;

    @FXML
    private TextField txtBoxLongitudeSRG;

    @FXML
    private ImageView imgMapSRG;

    @FXML
    private Hyperlink linkMoreNamesSRG;

    @FXML
    private Hyperlink linkMoreLatitudeSRG;

    @FXML
    private Hyperlink linkMoreLongitudeSRG;

    @FXML
    private Hyperlink linkMoreRegionSRG;

    @FXML
    private Hyperlink linkMoreStatesSRG;

    @FXML
    private Hyperlink linkMoreCitysSRG;

    @FXML
    private TitledPane titPaneNamesSRG;

    @FXML
    private TitledPane titPaneRegionsSRG;

    @FXML
    private TitledPane titPaneStatesSRG;

    @FXML
    private TitledPane titPaneCitysSRG;

    @FXML
    private TitledPane titPaneLatitudeSRG;

    @FXML
    private TitledPane titPaneLongitudeSRG;

    @FXML
    void addFilterCity(ActionEvent event) {

    }

    @FXML
    void addFilterLatitude(ActionEvent event) {

    }

    @FXML
    void addFilterLongitude(ActionEvent event) {

    }

    @FXML
    void addFilterName(ActionEvent event) {

    }

    @FXML
    void addFilterRegion(ActionEvent event) {

    }

    @FXML
    void addFilterState(ActionEvent event) {

    }

    @FXML
    void backPreviousScreen(ActionEvent event) {

    }

    @FXML
    void chooseRegion(ActionEvent event) {

    }

    @FXML
    void closeEverything(ActionEvent event) {

    }

    @FXML
    void deleteEverything(ActionEvent event) {

    }

    @FXML
    void putCity(ActionEvent event) {

    }

    @FXML
    void putLatitude(ActionEvent event) {

    }

    @FXML
    void putLongitude(ActionEvent event) {

    }

    @FXML
    void putName(ActionEvent event) {

    }

    @FXML
    void putState(ActionEvent event) {

    }

    @FXML
    void searchRainGauge(ActionEvent event) {

    }

    @FXML
    void showAboutSystem(ActionEvent event) {

    }

    @FXML
    void showEditOption(ActionEvent event) {

    }

    @FXML
    void showFileOptions(ActionEvent event) {

    }

    @FXML
    void showHelpOption(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert acpPanelSRG != null : "fx:id=\"acpPanelSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert butBackSRG != null : "fx:id=\"butBackSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert butSearchSRG != null : "fx:id=\"butSearchSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert txtBoxNameSRG != null : "fx:id=\"txtBoxNameSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert txtBoxStateSRG != null : "fx:id=\"txtBoxStateSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert txtBoxCitySRG != null : "fx:id=\"txtBoxCitySRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert cmbRegionSRG != null : "fx:id=\"cmbRegionSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert textinfoSRG != null : "fx:id=\"textinfoSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuBarSRG != null : "fx:id=\"menuBarSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuFileSRG != null : "fx:id=\"menuFileSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuiCloseSRG != null : "fx:id=\"menuiCloseSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuEditSRG != null : "fx:id=\"menuEditSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuiDeleteSRG != null : "fx:id=\"menuiDeleteSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuHelpSRG != null : "fx:id=\"menuHelpSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert menuiAboutSRG != null : "fx:id=\"menuiAboutSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert txtBoxLatitudeSRG != null : "fx:id=\"txtBoxLatitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert txtBoxLongitudeSRG != null : "fx:id=\"txtBoxLongitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert imgMapSRG != null : "fx:id=\"imgMapSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreNamesSRG != null : "fx:id=\"linkMoreNamesSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreLatitudeSRG != null : "fx:id=\"linkMoreLatitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreLongitudeSRG != null : "fx:id=\"linkMoreLongitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreRegionSRG != null : "fx:id=\"linkMoreRegionSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreStatesSRG != null : "fx:id=\"linkMoreStatesSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert linkMoreCitysSRG != null : "fx:id=\"linkMoreCitysSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneNamesSRG != null : "fx:id=\"titPaneNamesSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneRegionsSRG != null : "fx:id=\"titPaneRegionsSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneStatesSRG != null : "fx:id=\"titPaneStatesSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneCitysSRG != null : "fx:id=\"titPaneCitysSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneLatitudeSRG != null : "fx:id=\"titPaneLatitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";
        assert titPaneLongitudeSRG != null : "fx:id=\"titPaneLongitudeSRG\" was not injected: check your FXML file 'SearchRainGauge.fxml'.";

    }
}
