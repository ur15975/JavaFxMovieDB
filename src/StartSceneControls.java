import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/2/22.
 */
public class StartSceneControls implements Initializable{

    public static String characters = "";
    public static String linesChinese = "";
    public static String linesEnglish = "";
    public static String scenes = "";
    public static Stage searchStage;
    @FXML
    private Button buttonCharacters;
    @FXML
    private Button buttonChinese;
    @FXML
    private Button buttonEnglish;
    @FXML
    private TextField textFieldChinese;
    @FXML
    private TextField textFieldEnglish;
    @FXML
    private TextField textFieldCharacter;

    public static String getCharacters() {
        return characters;
    }

    public static String getLinesChinese() {
        return linesChinese;
    }

    public static String getLinesEnglish() {
        return linesEnglish;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonCharacters(ActionEvent event) throws IOException {
        Parent characterNode = FXMLLoader.load(getClass().getResource("CharactersList.fxml"));
        Scene characterScene = new Scene(characterNode, 1082, 692);
        Stage homePage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homePage.hide();
        homePage.setScene(characterScene);
        homePage.show();
    }

    public void handleButtonLines(ActionEvent event) throws IOException {
        linesChinese = textFieldChinese.getText();
        linesEnglish = textFieldEnglish.getText();
        Parent chineseNode = FXMLLoader.load(getClass().getResource("AllLinesScene.fxml"));
        Scene chineseScene = new Scene(chineseNode, 1082, 692);
        Stage homePage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homePage.hide();
        homePage.setScene(chineseScene);
        homePage.show();
    }

    public void handleButtonScene(ActionEvent event) throws IOException {
        Parent sceneNode = FXMLLoader.load(getClass().getResource("ScenesScene.fxml"));
        Scene sceneScene = new Scene(sceneNode, 1082, 692);
        Stage homePage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homePage.hide();
        homePage.setScene(sceneScene);
        homePage.show();
    }
}
