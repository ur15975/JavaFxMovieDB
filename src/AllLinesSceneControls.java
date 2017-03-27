import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AllLinesSceneControls implements Initializable {

    @FXML
    private TableView<DataModels> tableData;

    @FXML
    private TableColumn<DataModels,String> columnChineseLines;

    @FXML
    private TableColumn<DataModels,Integer> columnTime;

    @FXML
    private TableColumn<DataModels,String> columnEnglishLines;

    @FXML
    private Button buttonLoad;

    @FXML
    private Button returnButton;


    private ObservableList<DataModels>data;
    private DbConnection dbConnection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbConnection = new DbConnection();
        try {
            ResultSet resultSet;
            Connection connection = dbConnection.connection();
            data = FXCollections.observableArrayList();
            if (!StartSceneControls.linesChinese.trim().equals("")){
                resultSet = connection.createStatement().executeQuery("SELECT * FROM sheet1 WHERE sheet1.chineseLine LIKE '%" + StartSceneControls.getLinesChinese().trim() + "%'");
            }
            else if(!StartSceneControls.linesEnglish.trim().equals("")){
                resultSet = connection.createStatement().executeQuery("SELECT * FROM sheet1 WHERE sheet1.englishLine LIKE '%" + StartSceneControls.getLinesEnglish().trim() + "%'");
            }
            else {
                resultSet = connection.createStatement().executeQuery("SELECT * FROM sheet1");
            }
            while (resultSet.next()) {
                data.add(new DataModels(resultSet.getString(3),resultSet.getString(
                        2),resultSet.getInt(1),"",""));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

        columnChineseLines.setCellValueFactory(new PropertyValueFactory<>("chineseLine"));
        columnEnglishLines.setCellValueFactory(new PropertyValueFactory<>("englishLine"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        tableData.setItems(null);
        tableData.setItems(data);
    }

    @FXML
    private void returnHomePage(ActionEvent event) throws IOException{
        Parent homeNode = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        Scene homeScene = new Scene(homeNode, 380, 209);
        Stage homeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homeStage.hide();
        homeStage.setScene(homeScene);
        homeStage.show();
    }

    @FXML
    private void playMovie(ActionEvent event) throws IOException {
        DataModels dataModels = tableData.getSelectionModel().getSelectedItem();
        System.out.println(dataModels.getTime());

        Parent playNode = FXMLLoader.load(getClass().getResource("player.fxml"));
        Scene playScene = new Scene(playNode, 1280, 720);
        Stage playStage = new Stage();
        playStage.setScene(playScene);
        playStage.show();
    }
}