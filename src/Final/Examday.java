package Final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Examday {
	public Scene examscene;
	public Text subject = new Text();
	public Text score = new Text();
	public Button start = new Button();
	public Button goback = new Button();
	public Button check_data = new Button();
	public Student_data data = new Student_data();
	public AnchorPane examday = new AnchorPane();
	public Examday(String subject) {
		this.subject.setText("下科考試："+subject);
	}
	public void setexamday() {
		data.setStudent_data();
		//////////////////////////
		background.setLayoutX(-15);
		background.setLayoutY(0);
		//////////////////////////
		subject.setFill(Color.WHITE);
		subject.setLayoutX(520);
		subject.setLayoutY(330);
		subject.setStyle("-fx-font-size: 35px;");
		////////////////////
		start.setLayoutX(570);
		start.setLayoutY(500);
		start.setGraphic(img_start_normal);
		/////////////////////////////////
		goback.setLayoutX(555);
		goback.setLayoutY(500);
		goback.setGraphic(img_goback_normal);
		/////////////////////////////////
		score.setLayoutX(700);
		score.setLayoutY(100);
		score.setStyle("-fx-font-size: 35px;");
		///////////////////////
		start.setStyle("-fx-background-color: transparent");
		start.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			System.out.println(score.getText());
			Choose.play();
			start.setGraphic(img_start_touch);
		});
		start.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(start.getGraphic()==img_start_touch) {
				start.setGraphic(img_start_normal);
			}
		});
		start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
			start.setGraphic(img_start_pressed);
		});
		start.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			start.setGraphic(img_start_touch);
		});
		start.setOnMouseExited(e->{
			start.setGraphic(img_start_normal);
		});
		/////////////////////////////////////
		goback.setStyle("-fx-background-color: transparent");
		goback.setVisible(false);
		goback.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			System.out.println(score.getText());
			Choose.play();
			goback.setGraphic(img_goback_touch);
		});
		goback.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(goback.getGraphic()==img_goback_touch) {
				goback.setGraphic(img_goback_normal);
			}
		});
		goback.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
		});
		///////////////////
		check_data.setLayoutX(580);
		check_data.setLayoutY(50);
		check_data.setGraphic(img_checkdata_normal);
		///////////////////////////
		check_data.setStyle("-fx-background-color: transparent");
		check_data.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			check_data.setGraphic(img_checkdata_touch);
		});
		check_data.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(check_data.getGraphic()==img_checkdata_touch) {
				check_data.setGraphic(img_checkdata_normal);
			}
		});
		check_data.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			check_data.setGraphic(img_checkdata_pressed);
			if(data.Student_data.getLayoutX()==-1280) {
				Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
					data.Student_data.setLayoutX(data.Student_data.getLayoutX()+10);
				    }));
				t.setCycleCount(128);
				t.play();
			}
			Click.play();
		});
		check_data.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			check_data.setGraphic(img_checkdata_touch);
		});
		check_data.setOnMouseExited(e->{
			check_data.setGraphic(img_checkdata_normal);
		});
		examday.getChildren().addAll(background,subject,start,check_data,data.Student_data,score,goback);
		examscene = new Scene(examday,1280,720);
	}
	public void setscore(int a) {
		score.setText("目前總得分："+a);
	}
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/exam/exam.png")));
	public ImageView img_start_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/started_normal.png")));
	public ImageView img_start_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/started_pressed.png")));
	public ImageView img_goback_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/goback_normal.png")));
	public ImageView img_goback_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/goback_touch.png")));
	public ImageView img_start_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/started_touch.png")));
	public ImageView img_checkdata_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_normal.png")));
	public ImageView img_checkdata_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_pressed.png")));
	public ImageView img_checkdata_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_touch.png")));
}
