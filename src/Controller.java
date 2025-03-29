import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.effect.Lighting;

public class Controller {
    private int playerScore, computerScore = 0;
    private String[] path = { "res/Rock2.png", "res/Paper2.png", "res/Scissors2.png" };
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView computerImage;
    @FXML
    private Text playerTitle;
    @FXML
    private Text computerTitle;
    @FXML
    private Text roundWinnerMessage;
    @FXML
    private Button rockButton;
    @FXML
    private Button paperButton;
    @FXML
    private Button scissorsButton;
    @FXML
    private Button rematchButton;
    @FXML
    private Button exitButton;

    private void centerRoundWinnerMessage() {
        double parentWidth = roundWinnerMessage.getParent().getLayoutBounds().getWidth();
        double textWidth = roundWinnerMessage.getLayoutBounds().getWidth();
        roundWinnerMessage.setLayoutX((parentWidth - textWidth) / 2);
    }

    public void rematch(ActionEvent e) {
        playerScore = 0;
        computerScore = 0;
        playerTitle.setText("Player: 0");
        computerTitle.setText("Computer: 0");
        roundWinnerMessage.setOpacity(0);
        rematchButton.setOpacity(0);
        rematchButton.setDisable(true);
        exitButton.setOpacity(0);
        exitButton.setDisable(true);
        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);
    }

    public void exitGame(ActionEvent e) {
        System.exit(0);
    }

    private void showEndGameOptions() {
        rematchButton.setOpacity(1);
        rematchButton.setDisable(false);
        exitButton.setOpacity(1);
        exitButton.setDisable(false);
    }

    public void rock(ActionEvent e) {
        rockButton.setEffect(new Lighting());
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);
        playerImage.setOpacity(1);
        computerImage.setOpacity(1);
        playerImage.setImage(new Image(new File(path[0]).toURI().toString()));
        computerImage.setImage(new Image(new File(path[(int) (Math.random() * 3)]).toURI().toString()));
        String result = GameLogic.winner(
                new File(playerImage.getImage().getUrl()).getName().replace("2.png", ""),
                new File(computerImage.getImage().getUrl()).getName().replace("2.png", ""));
        if (result.equals("Player wins!")) {
            playerScore++;
        } else if (result.equals("Computer wins!")) {
            computerScore++;
        }
        playerTitle.setText("Player: " + playerScore);
        computerTitle.setText("Computer: " + computerScore);
        if (playerScore == 5 || computerScore == 5) {
            roundWinnerMessage.setText(playerScore == 5 ? "Player wins the game!" : "Computer wins the game!");
            centerRoundWinnerMessage();
            roundWinnerMessage.setOpacity(1);
            rockButton.setDisable(true);
            paperButton.setDisable(true);
            scissorsButton.setDisable(true);
            showEndGameOptions();
            return;
        }
        roundWinnerMessage.setText(result);
        centerRoundWinnerMessage();
        roundWinnerMessage.setOpacity(1);
        PauseTransition pauseMessage = new PauseTransition(Duration.seconds(1));
        pauseMessage.setOnFinished(event -> {
            roundWinnerMessage.setOpacity(0);
            playerImage.setOpacity(0);
            computerImage.setOpacity(0);
            rockButton.setEffect(null);
            rockButton.setDisable(false);
            paperButton.setDisable(false);
            scissorsButton.setDisable(false);
        });
        pauseMessage.play();
    }

    public void Paper(ActionEvent e) {
        paperButton.setEffect(new Lighting());
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);
        playerImage.setOpacity(1);
        computerImage.setOpacity(1);
        playerImage.setImage(new Image(new File(path[1]).toURI().toString()));
        computerImage.setImage(new Image(new File(path[(int) (Math.random() * 3)]).toURI().toString()));
        String result = GameLogic.winner(
                new File(playerImage.getImage().getUrl()).getName().replace("2.png", ""),
                new File(computerImage.getImage().getUrl()).getName().replace("2.png", ""));
        if (result.equals("Player wins!")) {
            playerScore++;
        } else if (result.equals("Computer wins!")) {
            computerScore++;
        }
        playerTitle.setText("Player: " + playerScore);
        computerTitle.setText("Computer: " + computerScore);
        if (playerScore == 5 || computerScore == 5) {
            roundWinnerMessage.setText(playerScore == 5 ? "Player wins the game!" : "Computer wins the game!");
            centerRoundWinnerMessage();
            roundWinnerMessage.setOpacity(1);
            rockButton.setDisable(true);
            paperButton.setDisable(true);
            scissorsButton.setDisable(true);
            showEndGameOptions();
            return;
        }
        roundWinnerMessage.setText(result);
        centerRoundWinnerMessage();
        roundWinnerMessage.setOpacity(1);
        PauseTransition pauseMessage = new PauseTransition(Duration.seconds(1));
        pauseMessage.setOnFinished(event -> {
            roundWinnerMessage.setOpacity(0);
            playerImage.setOpacity(0);
            computerImage.setOpacity(0);
            paperButton.setEffect(null);
            rockButton.setDisable(false);
            paperButton.setDisable(false);
            scissorsButton.setDisable(false);
        });
        pauseMessage.play();
    }

    public void Scissors(ActionEvent e) {
        scissorsButton.setEffect(new Lighting());
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);
        playerImage.setOpacity(1);
        computerImage.setOpacity(1);
        playerImage.setImage(new Image(new File(path[2]).toURI().toString()));
        computerImage.setImage(new Image(new File(path[(int) (Math.random() * 3)]).toURI().toString()));
        String result = GameLogic.winner(
                new File(playerImage.getImage().getUrl()).getName().replace("2.png", ""),
                new File(computerImage.getImage().getUrl()).getName().replace("2.png", ""));
        if (result.equals("Player wins!")) {
            playerScore++;
        } else if (result.equals("Computer wins!")) {
            computerScore++;
        }
        playerTitle.setText("Player: " + playerScore);
        computerTitle.setText("Computer: " + computerScore);
        if (playerScore == 5 || computerScore == 5) {
            roundWinnerMessage.setText(playerScore == 5 ? "Player wins the game!" : "Computer wins the game!");
            centerRoundWinnerMessage();
            roundWinnerMessage.setOpacity(1);
            rockButton.setDisable(true);
            paperButton.setDisable(true);
            scissorsButton.setDisable(true);
            showEndGameOptions();
            return;
        }
        roundWinnerMessage.setText(result);
        centerRoundWinnerMessage();
        roundWinnerMessage.setOpacity(1);
        PauseTransition pauseMessage = new PauseTransition(Duration.seconds(1));
        pauseMessage.setOnFinished(event -> {
            roundWinnerMessage.setOpacity(0);
            playerImage.setOpacity(0);
            computerImage.setOpacity(0);
            scissorsButton.setEffect(null);
            rockButton.setDisable(false);
            paperButton.setDisable(false);
            scissorsButton.setDisable(false);
        });
        pauseMessage.play();
    }
}