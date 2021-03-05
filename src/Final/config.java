package Final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class config {
	public AnchorPane config_pane = new AnchorPane();
	public Button save = new Button();
	public Button back = new Button();
	public config() {
		img_back.setLayoutX(0);
		img_back.setLayoutY(0);
		save.setStyle("-fx-background-color: transparent");
		back.setStyle("-fx-background-color: transparent");
		save.setGraphic(img_save_normal);
		back.setGraphic(img_back_normal);
		save.setLayoutY(50);
		back.setLayoutY(100);
		save.setLayoutX(550);
		back.setLayoutX(1015);
		save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			save.setGraphic(img_save_touch);
		});
		save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(save.getGraphic()==img_save_touch)
				save.setGraphic(img_save_normal);
		});
		save.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			saveed.play();
		});
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			back.setGraphic(img_back_touch);
		});
		back.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
			if(config_pane.getLayoutY()==0) {
				Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
					config_pane.setLayoutY(config_pane.getLayoutY()-5);
				    }));
				t.setCycleCount(35);
				t.play();
			}
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(back.getGraphic()==img_back_touch)
				back.setGraphic(img_back_normal);
		});
		config_pane.setLayoutX(0);
		config_pane.setLayoutY(-175);
		config_pane.getChildren().addAll(img_back,save,back);
	}
	public AudioClip saveed = new AudioClip(getClass().getResource("SE/save.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/back_normal.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/back_touch.png")));
	public ImageView img_save_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/save_normal.png")));
	public ImageView img_save_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/save_touch.png")));
	public ImageView img_title_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/title_normal.png")));
	public ImageView img_title_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/title_touch.png")));
	public ImageView img_back = new ImageView(new Image(getClass().getResourceAsStream("picture/day/config_back.png")));
}
