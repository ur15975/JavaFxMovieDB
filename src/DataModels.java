import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2017/2/24.
 */
public class DataModels {
    private final StringProperty englishLine;
    private final StringProperty chineseLine;
    private final IntegerProperty time;
    private final StringProperty character;
    private final StringProperty scene;

    public DataModels(String englishLine, String chineseLine, int time, String character, String scene) {
        this.englishLine = new SimpleStringProperty(englishLine);
        this.chineseLine = new SimpleStringProperty(chineseLine);
        this.time = new SimpleIntegerProperty(time);
        this.character = new SimpleStringProperty(character);
        this.scene = new SimpleStringProperty(scene);
    }

    public String getEnglishLine() {
        return englishLine.get();
    }

    public void setEnglishLine(String englishLine) {
        this.englishLine.set(englishLine);
    }

    public StringProperty englishLineProperty() {
        return englishLine;
    }

    public String getChineseLine() {
        return chineseLine.get();
    }

    public void setChineseLine(String chineseLine) {
        this.chineseLine.set(chineseLine);
    }

    public StringProperty chineseLineProperty() {
        return chineseLine;
    }

    public int getTime() {
        return time.get();
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public IntegerProperty timeProperty() {
        return time;
    }

    public String getCharacter() {
        return character.get();
    }

    public void setCharacter(String character) {
        this.character.set(character);
    }

    public StringProperty characterProperty() {
        return character;
    }

    public String getScene() {
        return scene.get();
    }

    public void setScene(String scene) {
        this.scene.set(scene);
    }

    public StringProperty sceneProperty() {
        return scene;
    }
}
