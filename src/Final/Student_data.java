package Final;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Student_data {
	public Student_data_pane data_pane[] = new Student_data_pane[3];
	public Button student_button[] = new Button[3];
	public AnchorPane Student_data = new AnchorPane();
	public Button back = new Button();
	public Student_data(){
		data_pane[0] = new Student_data_pane();
		data_pane[1] = new Student_data_pane();
		data_pane[2] = new Student_data_pane();
		for(int i = 0;i < 3;i++) {
			data_pane[i].student_pane.setLayoutX(369);
			data_pane[i].student_pane.setLayoutY(136);
		}
	}
	public void setStudent_data() {
		back.setGraphic(img_back_normal);
		back.setLayoutX(1090);
		back.setLayoutY(620);
		/////////////////////////
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
		/////////////////////////
		for(int i = 0;i < 3;i++) {
			img_student_normal[i] = new ImageView(day.used_student[i].img_student.getImage());
			img_student_touch[i] = new ImageView(day.used_student[i].img_student_touch.getImage());
		}
		data_pane[0].setdatapane(day.used_student[0]);
		data_pane[1].setdatapane(day.used_student[1]);
		data_pane[2].setdatapane(day.used_student[2]);
		for(int i = 0;i < 3;i++) {
			 student_button[i] = new Button();
			 student_button[i].setGraphic(img_student_normal[i]);
			 student_button[i].setLayoutX(33);
		}
		student_button[0].setLayoutY(8);
		student_button[1].setLayoutY(232);
		student_button[2].setLayoutY(454);
		////////////////////////////////////
		student_button[0].setStyle("-fx-background-color: transparent");
		student_button[1].setStyle("-fx-background-color: transparent");
		student_button[2].setStyle("-fx-background-color: transparent");
		student_button[0].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[0].refresh();
			data_pane[0].refresh(day.used_student[0]);
			student_button[0].setGraphic(img_student_touch[0]);
			data_pane[0].student_pane.setVisible(true);
			Switch.play();
		});
		student_button[0].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		student_button[1].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[1].refresh();
			data_pane[1].refresh(day.used_student[1]);
			student_button[1].setGraphic(img_student_touch[1]);
			data_pane[1].student_pane.setVisible(true);
			Switch.play();
		});
		student_button[1].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		student_button[2].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[2].refresh();
			data_pane[2].refresh(day.used_student[2]);
			student_button[2].setGraphic(img_student_touch[2]);
			data_pane[2].student_pane.setVisible(true);
			Switch.play();
		});
		student_button[2].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		Student_data.getChildren().addAll(background,back);
		for(int i = 0;i < 3;i++)
			data_pane[i].student_pane.setVisible(false);
		for(int i = 0;i < 3;i++) {
			Student_data.getChildren().add(data_pane[i].student_pane);
			Student_data.getChildren().add(student_button[i]);
		}		
		Student_data.setLayoutX(-1280);
		Student_data.setLayoutY(0);
	}
	public void setdatapane_normal() {
		for(int i = 0;i < 3;i++) {
			data_pane[i].student_pane.setVisible(false);
			student_button[i].setGraphic(img_student_normal[i]);
		}
	}
	public void goback() {
		if(Student_data.getLayoutX()==0) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
				Student_data.setLayoutX(Student_data.getLayoutX()-10);
			    }));
			t.setCycleCount(128);
			t.play();
		}
	}
	///////////////////////////////////
	public class Student_data_pane {
		public Text hp_text = new Text();
		public Text math_text = new Text();
		public Text language_text = new Text();
		public Text program_text = new Text();
		public Text Skill[] = new Text[8];
		public AnchorPane student_pane = new AnchorPane();
		public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/student_data/student_data_back.png")));
		public Student_data_pane() {
		}
		public void setdatapane(Student student) {
			this.hp_text.setText(student.hp_text.getText());
			this.math_text.setText(student.math_text.getText());
			this.language_text.setText(student.language_text.getText());
			this.program_text.setText(student.program_text.getText());
			for(int i = 0;i < 8;i++) {
				Skill[i] = new Text();
				this.Skill[i].setText(student.Skill[i].getText());
			}
			for(int i = 0;i < 8;i++)
				Skill[i].setStyle("-fx-font-size: 28px;");
			background.setLayoutX(0);
			background.setLayoutY(0);
			background.setLayoutX(0);
			background.setLayoutY(0);
			hp_text.setLayoutX(121);
			hp_text.setLayoutY(151);
			hp_text.setStyle("-fx-font-size: 28px;");
			math_text.setLayoutX(121);
			math_text.setLayoutY(200);
			math_text.setStyle("-fx-font-size: 28px;");
			language_text.setLayoutX(121);
			language_text.setLayoutY(247);
			language_text.setStyle("-fx-font-size: 28px;");
			program_text.setLayoutX(121);
			program_text.setLayoutY(295);
			program_text.setStyle("-fx-font-size: 28px;");
			Skill[0].setLayoutX(300);
			Skill[0].setLayoutY(151);
			Skill[1].setLayoutX(300);
			Skill[1].setLayoutY(200);
			Skill[2].setLayoutX(300);
			Skill[2].setLayoutY(247);
			Skill[3].setLayoutX(300);
			Skill[3].setLayoutY(295);
			Skill[4].setLayoutX(485);
			Skill[4].setLayoutY(151);
			Skill[5].setLayoutX(485);
			Skill[5].setLayoutY(200);
			Skill[6].setLayoutX(485);
			Skill[6].setLayoutY(247);
			Skill[7].setLayoutX(485);
			Skill[7].setLayoutY(295);
			student_pane.getChildren().addAll(background,hp_text,math_text,language_text,program_text);
			for(int i=0;i<8;i++)
				student_pane.getChildren().add(Skill[i]);
		}
		public void refresh(Student student) {
			this.hp_text.setText(student.hp_text.getText());
			this.math_text.setText(student.math_text.getText());
			this.language_text.setText(student.language_text.getText());
			this.program_text.setText(student.program_text.getText());
			for(int i = 0;i < 8;i++) {
				this.Skill[i].setText(student.Skill[i].getText());
			}
			for(int i = 0;i < 8;i++)
				Skill[i].setStyle("-fx-font-size: 28px;");
		}
	}
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/student_data/student_data.jpg")));
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/back_normal.png")));
	public ImageView img_back_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/back_pressed.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/back_touch.png")));
	public ImageView img_student_normal[] = new ImageView[3];
	public ImageView img_student_touch[] = new ImageView[3];
}
