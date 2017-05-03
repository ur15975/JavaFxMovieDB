import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        primaryStage.setTitle("影视剧情问答系统数据库");
        primaryStage.setScene(new Scene(root, 380, 209));
        primaryStage.show();
    }
}
