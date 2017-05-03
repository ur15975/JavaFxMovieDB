import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerControls implements Initializable{

    public static int timeStartPlay;
    private static MediaPlayer mediaPlayer;
    @FXML
    private Slider volumeSlider;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider timeSlider;
    private String filePath;

    public static void setTimeStartPlay(int second) {
        timeStartPlay = second;
    }

    public static void stopPlay() {
        mediaPlayer.stop();
    }

    @FXML
    private void openfile(ActionEvent event) {
        mediaPlayer.stop();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp4)", ".mp4");
        File file = fileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
        playMovie();
    }

    @FXML
    private void pauseVideo(ActionEvent event) {
        mediaPlayer.pause();
        mediaPlayer.setRate(1);
    }

    @FXML
    private void playVideo(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void stopVideo(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    private void fastVideo(ActionEvent event) {
        mediaPlayer.setRate(1.5);
    }

    @FXML
    private void fasterVideo(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void slowVideo(ActionEvent event) {
        mediaPlayer.setRate(.75);
    }

    @FXML
    private void slowerVideo(ActionEvent event) {
        mediaPlayer.setRate(.5);
    }

    @FXML
    private void exitVideo(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        String myurl = "D:\\movie.mp4";
        File file = new File(myurl);
        filePath = file.toURI().toString();
//        String filePath = "http://122.112.245.36:888/student2013_6/wp-content/uploads/2017/04/movie.mp4";
        playMovie();
    }

    private void playMovie() {
        if (filePath != null) {
            Media media = new Media(filePath);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();
            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            volumeSlider.setValue(mediaPlayer.getVolume() * 100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue() / 100);
                }
            });

            mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    timeSlider.setValue(mediaPlayer.getCurrentTime().toMillis() / mediaPlayer.getTotalDuration().toMillis() * 1000.0);
                }
            });

            timeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    if (timeSlider.isPressed()) {
                        mediaPlayer.seek(mediaPlayer.getMedia().getDuration().multiply(timeSlider.getValue() / 1000));
                    }
                }
            });

            if (timeStartPlay != 0){
                mediaPlayer.setAutoPlay(true);
//                mediaPlayer.seek(Duration.seconds(timeStartPlay / 1000));
                mediaPlayer.startTimeProperty().setValue(Duration.seconds(timeStartPlay));//这里控制开始的时间
//                timeSlider.setValue((timeStartPlay / 8553.0 * 1000.0));

//                System.out.println(mediaPlayer.getTotalDuration());
//                System.out.println(timeStartPlay / 8553.0 * 1000.0);
//                System.out.println(timeStartPlay);
//                mediaPlayer.seek(Duration.seconds(timeStartPlay));
            }
            else
                mediaPlayer.play();
        }
    }
}