import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by Administrator on 2017/1/15.
 */
public class MainGUI extends Application {
    @Override
    public void start(Stage primaryStage) {

        Label labelChinese = new Label("中文台词:");
        TextField textFieldChinese = new TextField();
        HBox hBox1stLine = new HBox(15);
        hBox1stLine.setAlignment(Pos.CENTER_RIGHT);
        hBox1stLine.setPadding(new Insets(15, 15, 0, 15));
        hBox1stLine.getChildren().addAll(labelChinese, textFieldChinese);

        Label labelEnglish = new Label("外文台词:");
        TextField textFieldEnglish = new TextField();
        HBox hBox2ndLine = new HBox(15);
        hBox2ndLine.setAlignment(Pos.CENTER_RIGHT);
        hBox2ndLine.setPadding(new Insets(15, 15, 0, 15));
        hBox2ndLine.getChildren().addAll(labelEnglish, textFieldEnglish);

        Label labelCharacter = new Label("角色:");
        TextField textFieldCharacter = new TextField();
        HBox hBox3rdLine = new HBox(15);
        hBox3rdLine.setAlignment(Pos.CENTER_RIGHT);
        hBox3rdLine.setPadding(new Insets(15, 15, 0, 15));
        hBox3rdLine.getChildren().addAll(labelCharacter, textFieldCharacter);

        Button buttonStage = new Button("场景列表");
        Button buttonSearch = new Button();
        Button buttonSearchAll = new Button("查询所有");
        HBox hBox4thLine = new HBox(30);
        hBox4thLine.setAlignment(Pos.CENTER);
        hBox4thLine.setPadding(new Insets(15, 15, 15, 15));
        hBox4thLine.getChildren().addAll(buttonStage, buttonSearch, buttonSearchAll);

        VBox vBox = new VBox( );
        vBox.getChildren().addAll(hBox1stLine,hBox2ndLine,hBox3rdLine,hBox4thLine);

        Pane pane = new Pane();
        pane.getChildren().add(vBox);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("HEHE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
