package Final;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;

public class Difficulty {
	public Scene scene;
	public ImageView img_easy_normal = new ImageView();
	public ImageView img_easy_pressed = new ImageView();
	public ImageView img_easy_touch = new ImageView();
	public ImageView img_normal_normal = new ImageView();
	public ImageView img_normal_pressed = new ImageView();
	public ImageView img_normal_touch = new ImageView();
	public ImageView img_hard_normal = new ImageView();
	public ImageView img_hard_pressed = new ImageView();
	public ImageView img_hard_touch = new ImageView();
	public ImageView img_dif_background = new ImageView();
	public AudioClip Choose;
	public AudioClip Click;
	public Button easy = new Button();
	public Button normal = new Button();
	public Button hard = new Button();
	public AnchorPane set = new AnchorPane();
	public Difficulty(ImageView img_easy_normal,ImageView img_easy_pressed,ImageView img_easy_touch,
			ImageView img_normal_normal,ImageView img_normal_pressed,ImageView img_normal_touch,
			ImageView img_hard_normal,ImageView img_hard_pressed,ImageView img_hard_touch,ImageView img_dif_background,
			AudioClip Choose,AudioClip Click) {
		this.img_easy_normal = img_easy_normal;
		this.img_easy_pressed = img_easy_pressed;
		this.img_easy_touch = img_easy_touch;
		this.img_normal_normal = img_normal_normal;
		this.img_normal_pressed = img_normal_pressed;
		this.img_normal_touch = img_normal_touch;
		this.img_hard_normal = img_hard_normal;
		this.img_hard_pressed = img_hard_pressed;
		this.img_hard_touch = img_hard_touch;
		this.Choose = Choose;
		this.Click = Click;
		this.img_dif_background = img_dif_background;
	}
	public void setbutton() {
		img_dif_background.setLayoutX(0);
		img_dif_background.setLayoutY(0);
		/////////////////////////
		easy.setLayoutX(135);
		easy.setLayoutY(0);
		normal.setLayoutX(135);
		normal.setLayoutY(230);
		hard.setLayoutX(135);
		hard.setLayoutY(460);
		///////////////////////////
		easy.setGraphic(img_easy_normal);
		normal.setGraphic(img_normal_normal);
		hard.setGraphic(img_hard_normal);
		///////////////////////////
		easy.setStyle("-fx-background-color: transparent");
		easy.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			easy.setGraphic(img_easy_touch);
		});
		easy.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(easy.getGraphic()==img_easy_touch) {
				easy.setGraphic(img_easy_normal);
			}
		});
		easy.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			easy.setGraphic(img_easy_pressed);
			Click.play();
		});
		easy.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			easy.setGraphic(img_easy_touch);
		});
		easy.setOnMouseExited(e->{
			easy.setGraphic(img_easy_normal);
		});
		///////////////////////////
		normal.setStyle("-fx-background-color: transparent");
		normal.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			normal.setGraphic(img_normal_touch);
		});
		normal.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(normal.getGraphic()==img_normal_touch) {
				normal.setGraphic(img_normal_normal);
			}
		});
		normal.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			normal.setGraphic(img_normal_pressed);
			Click.play();
		});
		normal.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			normal.setGraphic(img_normal_touch);
		});
		normal.setOnMouseExited(e->{
			normal.setGraphic(img_normal_normal);
		});
		////////////////////////
		hard.setStyle("-fx-background-color: transparent");
		hard.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			hard.setGraphic(img_hard_touch);
		});
		hard.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(hard.getGraphic()==img_hard_touch) {
				hard.setGraphic(img_hard_normal);
			}
		});
		hard.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			hard.setGraphic(img_hard_pressed);
			Click.play();
		});
		hard.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			hard.setGraphic(img_hard_touch);
		});
		hard.setOnMouseExited(e->{
			hard.setGraphic(img_hard_normal);
		});
		/////////////////////////
		set.getChildren().addAll(img_dif_background,easy,normal,hard);
		scene = new Scene(set,1280,720);
	}
	//////////////////////////////
	public void setscene() {
		scene = new Scene(set,1280,720);
	}
}
