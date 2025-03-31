import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class Controller {
    private int pScore, cScore = 0, pWins, cWins = 0;
    private String[] images = { "res/Rock2.png", "res/Paper2.png", "res/Scissors2.png" };
    @FXML
    private ImageView pImg;
    @FXML
    private ImageView cImg;
    @FXML
    private Text pText;
    @FXML
    private Text cText;
    @FXML
    private Text resultMsg;
    @FXML
    private Text scoreText;
    @FXML
    private Button rockBtn;
    @FXML
    private Button paperBtn;
    @FXML
    private Button scissorBtn;
    @FXML
    private Button rematchBtn;
    @FXML
    private Button exitBtn;

    public void rematch(ActionEvent e) {
        pScore = 0;
        cScore = 0;
        pText.setText("Player: 0");
        cText.setText("Computer: 0");
        scoreText.setText(pWins + " : " + cWins);
        resultMsg.setOpacity(0);
        rematchBtn.setOpacity(0);
        rematchBtn.setDisable(true);
        exitBtn.setOpacity(0);
        exitBtn.setDisable(true);
        rockBtn.setDisable(false);
        paperBtn.setDisable(false);
        scissorBtn.setDisable(false);
    }

    public void exit(ActionEvent e) {
        System.exit(0);
    }

    private void showOptions() {
        rematchBtn.setOpacity(1);
        rematchBtn.setDisable(false);
        exitBtn.setOpacity(1);
        exitBtn.setDisable(false);
    }

    public void playRock(ActionEvent e) {
        play(0, rockBtn);
    }

    public void playPaper(ActionEvent e) {
        play(1, paperBtn);
    }

    public void playScissors(ActionEvent e) {
        play(2, scissorBtn);
    }

    private void play(int choice, Button btn) {
        rockBtn.setDisable(true);
        paperBtn.setDisable(true);
        scissorBtn.setDisable(true);
        pImg.setOpacity(1);
        cImg.setOpacity(1);
        pImg.setImage(new Image(new File(images[choice]).toURI().toString()));
        cImg.setImage(new Image(new File(images[(int) (Math.random() * 3)]).toURI().toString()));
        String result = GameLogic.winner(
                new File(pImg.getImage().getUrl()).getName().replace("2.png", ""),
                new File(cImg.getImage().getUrl()).getName().replace("2.png", ""));
        if (result.equals("Player wins!")) {
            pScore++;
        } else if (result.equals("Computer wins!")) {
            cScore++;
        }
        pText.setText("Player: " + pScore);
        cText.setText("Computer: " + cScore);
        if (pScore == 5 || cScore == 5) {
            if (pScore == 5) {
                resultMsg.setText("Player wins the game!");
                pWins++;
            } else {
                resultMsg.setText("Computer wins the game!");
                cWins++;
            }
            double parentWidth = resultMsg.getParent().getLayoutBounds().getWidth();
            double textWidth = resultMsg.getLayoutBounds().getWidth();
            resultMsg.setLayoutX((parentWidth - textWidth) / 2);
            resultMsg.setOpacity(1);
            rockBtn.setDisable(true);
            paperBtn.setDisable(true);
            scissorBtn.setDisable(true);
            showOptions();
            return;
        }
        resultMsg.setText(result);
        double parentWidth = resultMsg.getParent().getLayoutBounds().getWidth();
        double textWidth = resultMsg.getLayoutBounds().getWidth();
        resultMsg.setLayoutX((parentWidth - textWidth) / 2);
        resultMsg.setOpacity(1);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            resultMsg.setOpacity(0);
            pImg.setOpacity(0);
            cImg.setOpacity(0);
            rockBtn.setDisable(false);
            paperBtn.setDisable(false);
            scissorBtn.setDisable(false);
        });
        pause.play();
    }
}