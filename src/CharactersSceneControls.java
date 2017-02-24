import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/2/23.
 */
public class CharactersSceneControls implements Initializable {

    @FXML
    private TableView<DataModels> tableCharacters;

    @FXML
    private TableColumn<DataModels,String> columnChineseLines;

    @FXML
    private TableColumn<DataModels,Integer> columnTime;

    @FXML
    private TableColumn<DataModels,String> columnCharacters;

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
            String character = StartSceneControls.getCharacters();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM sheet1 WHERE characterId = " + character);
            System.out.println(character);
            while (resultSet.next()) {
                data.add(new DataModels(resultSet.getString(3),resultSet.getString(2),resultSet.getInt(1),resultSet.getString(4),""));
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

        columnChineseLines.setCellValueFactory(new PropertyValueFactory<>("chineseLine"));
        columnCharacters.setCellValueFactory(new PropertyValueFactory<>("character"));
        columnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        tableCharacters.setItems(null);
        tableCharacters.setItems(data);
    }
}
