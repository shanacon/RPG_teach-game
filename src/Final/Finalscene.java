package Final;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Finalscene {
	public Text t = new Text();
	public AnchorPane pane = new AnchorPane();
	public Scene scene;
	public Button title = new Button();
	public Finalscene(String content) {
		t.setFill(Color.ANTIQUEWHITE);
		t.setText(content);
		t.setLayoutX(500);
		t.setLayoutY(300);
		t.setStyle("-fx-font-size: 40px;");
		background.setLayoutX(0);
		background.setLayoutY(0);
		exit.setStyle("-fx-background-color: transparent");
		exit.setLayoutX(600);
		exit.setLayoutY(500);
		exit.setGraphic(img_exit_normal);
		exit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			exit.setGraphic(img_exit_touch);
		});
		exit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(exit.getGraphic()==img_exit_touch) {
				exit.setGraphic(img_exit_normal);
			}
		});
		exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			exit.setGraphic(img_exit_pressed);
			Click.play();
			//////////////////
		});
		exit.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			exit.setGraphic(img_exit_touch);
		});
		exit.setOnMouseExited(e->{
			exit.setGraphic(img_exit_normal);
		});
		title.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			title.setGraphic(img_title_touch);
		});
		title.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(title.getGraphic()==img_title_touch)
				title.setGraphic(img_title_normal);
		});
		title.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
		});
		pane.getChildren().addAll(background,t,exit);
		scene = new Scene(pane,1280,720);
	}
	public Button exit = new Button();
	public ImageView img_exit_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_normal.png")));
	public ImageView img_exit_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_pressed.png")));
	public ImageView img_exit_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_touch.png")));
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/exam/exam.png")));
	public ImageView img_title_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/title_normal.png")));
	public ImageView img_title_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/title_touch.png")));
}
