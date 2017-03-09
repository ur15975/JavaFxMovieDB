import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ScenesSceneControls implements Initializable {

    @FXML
    private TableView<DataModels> tableScene;

    @FXML
    private TableColumn<DataModels,String> columnChineseLines;

    @FXML
    private TableColumn<DataModels,Integer> columnTime;

    @FXML
    private TableColumn<DataModels,String> columnScene;

    @FXML
    private Button buttonLoad;

    private ObservableList<DataModels>data;
    private DbConnection dbConnection;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbConnection = new DbConnection();
    }

    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            Connection connection = dbConnection.connection();
            data = FXCollections.observableArrayList();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT time,chineseLine,englishLine,characterId,sceneName\n" +
                    "FROM sheet1 JOIN sheet3 USING (sceneId)");
            while (resultSet.next()) {
                data.add(new DataModels(resultSet.getString(3),resultSet.getString(2),resultSet.getInt(1),"",resultSet.getString(5)));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

        columnChineseLines.setCellValueFactory(new PropertyValueFactory<>("chineseLine"));
        columnScene.setCellValueFactory(new PropertyValueFactory<>("scene"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        tableScene.setItems(null);
        tableScene.setItems(data);
    }

    @FXML
    private void returnHomePage(ActionEvent event) throws IOException {
        Parent homeNode = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        Scene homeScene = new Scene(homeNode, 394, 283);
        Stage homeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        homeStage.hide();
        homeStage.setScene(homeScene);
        homeStage.show();
    }
}
