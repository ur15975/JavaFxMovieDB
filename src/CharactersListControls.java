import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ur15975@outlook.com on 2017/3/26.
 */
public class CharactersListControls implements Initializable{

    public static String select = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleAndyButton(ActionEvent event) throws IOException {
        select = "andy";
        handleButtonLines(event);
    }

    @FXML
    public void handleredButton(ActionEvent event) throws IOException {
        select = "red";
        handleButtonLines(event);
    }

    @FXML
    public void handleheywoodButton(ActionEvent event) throws IOException{
        select = "heywood";
        handleButtonLines(event);
    }

    @FXML
    public void handlenortonButton(ActionEvent event) throws IOException{
        select = "norton";
        handleButtonLines(event);
    }

    @FXML
    public void handlehadleyButton(ActionEvent event) throws IOException{
        select = "hadley";
        handleButtonLines(event);
    }

    @FXML
    public void handletommyButton(ActionEvent event) throws IOException{
        select = "tommy";
        handleButtonLines(event);
    }

    @FXML
    public void handlebrooksButton(ActionEvent event) throws IOException{
        select = "brooks";
        handleButtonLines(event);
    }

    @FXML
    public void handlebogsButton(ActionEvent event) throws IOException{
        select = "bogs";
        handleButtonLines(event);
    }

    @FXML
    public void handleothersButton(ActionEvent event) throws IOException{
        select = "others";
        handleButtonLines(event);
    }

    @FXML
    private void returnHomePage(ActionEvent event) throws IOException {
        Parent homeNode = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        Scene homeScene = new Scene(homeNode, 380, 209);
        Stage homeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homeStage.hide();
        homeStage.setScene(homeScene);
        homeStage.show();
    }

    public void handleButtonLines(ActionEvent event) throws IOException {
        Parent characterNode = FXMLLoader.load(getClass().getResource("CharactersScene.fxml"));
        Scene characterScene = new Scene(characterNode, 1082, 692);
        Stage thisPage = (Stage)((Node)event.getSource()).getScene().getWindow();
        thisPage.hide();
        thisPage.setScene(characterScene);
        thisPage.show();
    }

}
