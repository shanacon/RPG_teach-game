package Final;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Calendar {
	public AnchorPane calnedar_pane = new AnchorPane();
	public Button back = new Button();
	public Calendar() {
	}
	public void setcalendar() {
		background.setLayoutX(0);
		background.setLayoutY(0);
		calendar.setLayoutX(0);
		calendar.setLayoutY(0);
		//////////////
		back.setGraphic(img_back_normal);
		back.setLayoutX(530);
		back.setLayoutY(620);
		//////////////
		back.setStyle("-fx-background-color: transparent");
		back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			back.setGraphic(img_back_touch);
		});
		back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(back.getGraphic()==img_back_touch) {
				back.setGraphic(img_back_normal);
			}
		});
		back.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			back.setGraphic(img_back_pressed);
			goback();
			Cancel.play();
		});
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			back.setGraphic(img_back_touch);
		});
		back.setOnMouseExited(e->{
			back.setGraphic(img_back_normal);
		});
		//////////////////////
		calnedar_pane.setLayoutX(-720);
		calnedar_pane.setLayoutY(0);
		calnedar_pane.getChildren().addAll(background,calendar,back);
	}
	public void goin() {
		if(calnedar_pane.getLayoutX()==-720) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(3),(a)-> {
				calnedar_pane.setLayoutX(calnedar_pane.getLayoutX()+8);
			    }));
			t.setCycleCount(90);
			t.play();
		}
	}
	public void goback() {
		if(calnedar_pane.getLayoutX()==0) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(3),(a)-> {
				calnedar_pane.setLayoutX(calnedar_pane.getLayoutX()-8);
			    }));
			t.setCycleCount(90);
			t.play();
		}
	}
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/day/calendar_background.jpg")));
	public ImageView calendar = new ImageView(new Image(getClass().getResourceAsStream("picture/day/calendar_5.png")));
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/back_normal.png")));
	public ImageView img_back_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/back_pressed.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/back_touch.png")));
}
