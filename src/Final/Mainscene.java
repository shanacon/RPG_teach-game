package Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Mainscene{
	public Timeline terror1 = new Timeline();
	public Timeline terror2 = new Timeline();
	public Text error_text_1 = new Text("沒有存檔！！");
	public Text error_text_2 = new Text("存檔文件錯誤！！");
	public Scene mainscene;
	public int students;
	public boolean choose_student[] = new boolean[10];
	public AnchorPane anchor = new AnchorPane();
	public AnchorPane main1 = new AnchorPane();
	public AnchorPane main2 = new AnchorPane();
	//////////////////////////////////
	public ImageView background = new ImageView();
	public ImageView c_background = new ImageView();
	public ImageView img_start_normal = new ImageView();
	public ImageView img_start_pressed = new ImageView();
	public ImageView img_start_touch = new ImageView();
	public ImageView img_start_normal_1 = new ImageView();
	public ImageView img_start_pressed_1 = new ImageView();
	public ImageView img_start_touch_1 = new ImageView();
	public ImageView img_tutorial_normal = new ImageView();
	public ImageView img_tutorial_pressed = new ImageView();
	public ImageView img_tutorial_touch = new ImageView();
	public ImageView img_load_normal = new ImageView();
	public ImageView img_load_pressed = new ImageView();
	public ImageView img_load_touch = new ImageView();
	public ImageView img_exit_normal = new ImageView();
	public ImageView img_exit_pressed = new ImageView();
	public ImageView img_exit_touch = new ImageView();
	public ImageView img_back_normal = new ImageView();
	public ImageView img_back_pressed = new ImageView();
	public ImageView img_back_touch = new ImageView();
	public ImageView img_character[] = new ImageView[10];
	public Image icharacter[] = new Image[10];
	public ImageView img_character_touch[] = new ImageView[10];
	public Image icharacter_touch[] = new Image[10];
	public ImageView img_character_choose[] = new ImageView[10];
	public Image icharacter_choose[] = new Image[10];
	public ImageView img_character_intro[] = new ImageView[10];
	public Image icharacter_intro[] = new Image[10];
	public AudioClip Error;
	public AudioClip Cancel;
	public AudioClip Choose;
	public AudioClip Click;
	public AudioClip Choose2;
	public Button start = new Button();
	public Button start_1 = new Button();
	public Button tutorial = new Button();
	public Button load = new Button();
	public Button exit = new Button();
	public Button back = new Button();
	public Button character[] = new Button[10];
	public Text error_choose = new Text("請選擇三個學生！！");
	public Timeline t = new Timeline();
	public Timeline t2 = new Timeline();
	public Mainscene(int students,boolean choose_student[],AnchorPane anchor,AnchorPane main1,AnchorPane main2,
			ImageView background,ImageView c_background,ImageView img_start_normal,ImageView img_start_pressed,
			ImageView img_start_touch,ImageView img_start_normal_1,ImageView img_start_pressed_1,ImageView img_start_touch_1,
			ImageView img_tutorial_normal,ImageView img_tutorial_pressed,ImageView img_tutorial_touch,ImageView img_load_normal,
			ImageView img_load_pressed,ImageView img_load_touch,ImageView img_exit_normal,ImageView img_exit_pressed,
			ImageView img_exit_touch,ImageView img_back_normal,ImageView img_back_pressed,ImageView img_back_touch,
			ImageView img_character[],ImageView img_character_touch[],
			ImageView img_character_choose[],ImageView img_character_intro[],
			AudioClip Error,AudioClip Cancel,AudioClip Choose,AudioClip Click,AudioClip Choose2,Button start,Button start_1,
			Button tutorial,Button load,Button exit,Button back,Button character[],Timeline t,Timeline t2) {
		this.students = students;
		this.choose_student = choose_student;//
		this.anchor = anchor;
		this.main1 = main1;
		this.main2 = main2;
		this.background = background;
		this.c_background = c_background;
		this.img_start_normal = img_start_normal;
		this.img_start_pressed = img_start_pressed;
		this.img_start_touch = img_start_touch;
		this.img_start_normal_1 = img_start_normal_1;
		this.img_start_pressed_1 = img_start_pressed_1;
		this.img_start_touch_1 = img_start_touch_1;
		this.img_tutorial_normal = img_tutorial_normal;
		this.img_tutorial_pressed = img_tutorial_pressed;
		this.img_tutorial_touch = img_tutorial_touch;
		this.img_load_normal = img_load_normal;
		this.img_load_pressed = img_load_pressed;
		this.img_load_touch = img_load_touch;
		this.img_exit_normal = img_exit_normal;
		this.img_exit_pressed = img_exit_pressed;
		this.img_exit_touch = img_exit_touch;
		this.img_back_normal = img_back_normal;
		this.img_back_pressed = img_back_pressed;
		this.img_back_touch = img_back_touch;
		this.img_character = img_character;//
		this.img_character_touch = img_character_touch;//
		this.img_character_choose = img_character_choose;//
		this.img_character_intro = img_character_intro;//
		this.Error = Error;
		this.Cancel = Cancel;
		this.Choose = Choose;
		this.Click = Click;
		this.Choose2 = Choose2;
		this.start = start;
		this.start_1 = start_1;
		this.tutorial = tutorial;
		this.load = load;
		this.exit = exit;
		this.back = back;
		this.character = character;//
		this.t = t;
		this.t2 = t2;
		
	}
	public void execute() {
		character[8].setVisible(false);
		character[9].setVisible(false);
		terror1 = new Timeline();
		terror1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {error_text_1.setVisible(true);})
				,new KeyFrame(Duration.ZERO, new KeyValue(error_text_1.opacityProperty(), 0))
				,new KeyFrame(new Duration(300), new KeyValue(error_text_1.opacityProperty(), 1))
				,new KeyFrame(new Duration(600), new KeyValue(error_text_1.opacityProperty(), 0))
				,new KeyFrame(new Duration(600),(a)-> {error_text_1.setVisible(false);})
				);
		terror2 = new Timeline();
		terror2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {error_text_2.setVisible(true);})
				,new KeyFrame(Duration.ZERO, new KeyValue(error_text_2.opacityProperty(), 0))
				,new KeyFrame(new Duration(300), new KeyValue(error_text_2.opacityProperty(), 1))
				,new KeyFrame(new Duration(600), new KeyValue(error_text_2.opacityProperty(), 0))
				,new KeyFrame(new Duration(600),(a)-> {error_text_2.setVisible(false);})
				);
		error_text_1.setVisible(false);
		error_text_2.setVisible(false);
		error_text_1.setLayoutX(520);
		error_text_1.setLayoutY(450);
		error_text_1.setStyle("-fx-font-size: 40px;");
		error_text_2.setLayoutX(500);
		error_text_2.setLayoutY(450);
		error_text_2.setStyle("-fx-font-size: 40px;");
		///////////////////////////////
		error_choose.setLayoutX(520);
		error_choose.setLayoutY(400);
		error_choose.setFill(Color.RED);
		error_choose.setStyle("-fx-font-size: 40px;");
		error_choose.setVisible(false);
		///////////////////////////////
		for(int i = 0;i<10;i++) {
			choose_student[i] = false;
		}
		//////////////////////////////
		for(int i = 0;i < 10;i++) {
			img_character_intro[i].setLayoutX(277);
			img_character_intro[i].setLayoutY(-10);
			img_character_intro[i].setVisible(false);
		}
		/////////////////////////////
		c_background.setLayoutX(277);
		c_background.setLayoutY(0);
		c_background.setVisible(true);
		/////////////////////////////
		background.setLayoutX(0);
		background.setLayoutY(0);
		background.setEffect(new BoxBlur(10, 10, 30));
		////////////////////////////
		start.setLayoutX(559);
		start.setLayoutY(100);
		start.setGraphic(img_start_normal);
		///////////////////////////
		start_1.setLayoutX(1019);
		start_1.setLayoutY(93);
		start_1.setGraphic(img_start_normal_1);
		//////////////////////////
		tutorial.setLayoutX(527);
		tutorial.setLayoutY(575);
		tutorial.setGraphic(img_tutorial_normal);
		/////////////////////////
		load.setLayoutX(887);
		load.setLayoutY(575);
		load.setGraphic(img_load_normal);
		////////////////////////
		exit.setLayoutX(215);
		exit.setLayoutY(575);
		exit.setGraphic(img_exit_normal);
		////////////////////////
		back.setLayoutX(54);
		back.setLayoutY(93);
		back.setGraphic(img_back_normal);
		/////////////////////////
		for(int i = 0;i < 10;i++) {
			character[i].setGraphic(img_character[i]);
		}
		for(int i = 0;i < 10;i++) {
			character[i].setStyle("-fx-background-color: transparent");
		}
		for(int i = 0;i < 5;i++) {
			character[i].setLayoutY(231);
		}
		for(int i = 5;i < 10;i++) {
			character[i].setLayoutY(451);
		}
		character[0].setLayoutX(79);
		character[5].setLayoutX(79);
		character[1].setLayoutX(319);
		character[6].setLayoutX(319);
		character[2].setLayoutX(559);
		character[7].setLayoutX(559);
		character[3].setLayoutX(789);
		character[8].setLayoutX(789);
		character[4].setLayoutX(1019);
		character[9].setLayoutX(1019);
		////////////////////////
//		main1.getChildren().addAll(tutorial);
		main1.getChildren().addAll(start,exit,load,error_text_1,error_text_2);
		main2.getChildren().addAll(back,start_1,c_background);
		for(int i = 0;i < 10;i++){
			main2.getChildren().add(character[i]);
		}
		main2.getChildren().add(error_choose);
		main2.setVisible(false);
		///////////////////////
		start.setStyle("-fx-background-color: transparent");
		start.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			start.setGraphic(img_start_touch);
		});
		start.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(start.getGraphic()==img_start_touch) {
				start.setGraphic(img_start_normal);
			}
		});
		///////////////////////
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(main1.opacityProperty(), 1))
				,new KeyFrame(new Duration(200), new KeyValue(main1.opacityProperty(), 0))
				,new KeyFrame(new Duration(200),(e)-> {main1.setVisible(false);})
				,new KeyFrame(Duration.ZERO, new KeyValue(main2.opacityProperty(), 0))
				,new KeyFrame(Duration.millis(200), new KeyValue(main2.opacityProperty(), 0))
				,new KeyFrame(Duration.millis(400), new KeyValue(main2.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO,(e)-> {main2.setVisible(true);})
				);
		/////////////////////////////
		start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
			start.setGraphic(img_start_pressed);
			t.play();
			for(int i = 0;i < 8;i++) {
				character[i].setVisible(true);
			}
			if(main.clearflag1==1)
				character[8].setVisible(true);
			if(main.clearflag2==1)
				character[9].setVisible(true);
		});
		start.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			start.setGraphic(img_start_touch);
		});
		start.setOnMouseExited(e->{
			start.setGraphic(img_start_normal);
		});
		////////////////////////////
		start_1.setStyle("-fx-background-color: transparent");
		start_1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			start_1.setGraphic(img_start_touch_1);
		});
		start_1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(start_1.getGraphic()==img_start_touch_1) {
				start_1.setGraphic(img_start_normal_1);
			}
		});
		start_1.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			start_1.setGraphic(img_start_pressed_1);
		});
		start_1.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			start_1.setGraphic(img_start_touch_1);
		});
		start_1.setOnMouseExited(e->{
			start_1.setGraphic(img_start_normal_1);
		});
		//////////////////
		tutorial.setStyle("-fx-background-color: transparent");
		tutorial.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			tutorial.setGraphic(img_tutorial_touch);
		});
		tutorial.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(tutorial.getGraphic()==img_tutorial_touch) {
				tutorial.setGraphic(img_tutorial_normal);
			}
		});
		tutorial.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			tutorial.setGraphic(img_tutorial_pressed);
			Click.play();
		});
		tutorial.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			tutorial.setGraphic(img_tutorial_touch);
		});
		tutorial.setOnMouseExited(e->{
			tutorial.setGraphic(img_tutorial_normal);
		});
		/////////////////
		

		load.setStyle("-fx-background-color: transparent");
		load.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			load.setGraphic(img_load_touch);
		});
		load.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(load.getGraphic()==img_load_touch) {
				load.setGraphic(img_load_normal);
			}
		});
		load.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			load.setGraphic(img_load_pressed);
		});
		load.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			load.setGraphic(img_load_touch);
		});
		load.setOnMouseExited(e->{
			load.setGraphic(img_load_normal);
		});
		/////////////////////
		exit.setStyle("-fx-background-color: transparent");
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
	///////////////////
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
		t2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(main1.opacityProperty(), 0))
				,new KeyFrame(new Duration(200), new KeyValue(main1.opacityProperty(), 0))
				,new KeyFrame(new Duration(400), new KeyValue(main1.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO,(e)-> {main1.setVisible(true);})
				,new KeyFrame(Duration.ZERO, new KeyValue(main2.opacityProperty(), 1))
				,new KeyFrame(Duration.millis(200), new KeyValue(main2.opacityProperty(), 0))
				,new KeyFrame(Duration.millis(200),(e)-> {main2.setVisible(false);})
				);
		back.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			t2.play();
			back.setGraphic(img_back_pressed);
			Cancel.play();
		});
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			back.setGraphic(img_back_touch);
		});
		back.setOnMouseExited(e->{
			back.setGraphic(img_back_normal);
		});
		////////////////////////////////////////////////////////////////////////////////
		character[0].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[0].getGraphic()!=img_character_choose[0]&&students<3) {
				character[0].setGraphic(img_character_choose[0]);
				students++;
				choose_student[0] = true;
				Choose2.play();
			}		
			else if(character[0].getGraphic()==img_character_choose[0]&&students>0) {
				students--;
				character[0].setGraphic(img_character_touch[0]);
				choose_student[0] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[1].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[1].getGraphic()!=img_character_choose[1]&&students<3) {
				character[1].setGraphic(img_character_choose[1]);
				students++;
				choose_student[1] = true;
				Choose2.play();
			}		
			else if(character[1].getGraphic()==img_character_choose[1]&&students>0) {
				students--;
				character[1].setGraphic(img_character_touch[1]);
				choose_student[1] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[2].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[2].getGraphic()!=img_character_choose[2]&&students<3) {
				character[2].setGraphic(img_character_choose[2]);
				students++;
				choose_student[2] = true;
				Choose2.play();
			}		
			else if(character[2].getGraphic()==img_character_choose[2]&&students>0) {
				students--;
				character[2].setGraphic(img_character_touch[2]);
				choose_student[2] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[3].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[3].getGraphic()!=img_character_choose[3]&&students<3) {
				character[3].setGraphic(img_character_choose[3]);
				students++;
				choose_student[3] = true;
				Choose2.play();
			}		
			else if(character[3].getGraphic()==img_character_choose[3]&&students>0) {
				students--;
				character[3].setGraphic(img_character_touch[3]);
				choose_student[3] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[4].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[4].getGraphic()!=img_character_choose[4]&&students<3) {
				character[4].setGraphic(img_character_choose[4]);
				students++;
				choose_student[4] = true;
				Choose2.play();
			}		
			else if(character[4].getGraphic()==img_character_choose[4]&&students>0) {
				students--;
				character[4].setGraphic(img_character_touch[4]);
				choose_student[4] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[5].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[5].getGraphic()!=img_character_choose[5]&&students<3) {
				character[5].setGraphic(img_character_choose[5]);
				students++;
				choose_student[5] = true;
				Choose2.play();
			}		
			else if(character[5].getGraphic()==img_character_choose[5]&&students>0) {
				students--;
				character[5].setGraphic(img_character_touch[5]);
				choose_student[5] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[6].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[6].getGraphic()!=img_character_choose[6]&&students<3) {
				character[6].setGraphic(img_character_choose[6]);
				students++;
				choose_student[6] = true;
				Choose2.play();
			}		
			else if(character[6].getGraphic()==img_character_choose[6]&&students>0) {
				students--;
				character[6].setGraphic(img_character_touch[6]);
				choose_student[6] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[7].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[7].getGraphic()!=img_character_choose[7]&&students<3) {
				character[7].setGraphic(img_character_choose[7]);
				students++;
				choose_student[7] = true;
				Choose2.play();
			}		
			else if(character[7].getGraphic()==img_character_choose[7]&&students>0) {
				students--;
				character[7].setGraphic(img_character_touch[7]);
				choose_student[7] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[8].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[8].getGraphic()!=img_character_choose[8]&&students<3) {
				character[8].setGraphic(img_character_choose[8]);
				students++;
				choose_student[8] = true;
				Choose2.play();
			}		
			else if(character[8].getGraphic()==img_character_choose[8]&&students>0) {
				students--;
				character[8].setGraphic(img_character_touch[8]);
				choose_student[8] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		character[9].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			if(character[9].getGraphic()!=img_character_choose[9]&&students<3) {
				character[9].setGraphic(img_character_choose[9]);
				students++;
				choose_student[9] = true;
				Choose2.play();
			}		
			else if(character[9].getGraphic()==img_character_choose[9]&&students>0) {
				students--;
				character[9].setGraphic(img_character_touch[9]);
				choose_student[9] = false;
				Choose2.play();
			}
			else {
				Error.play();
			}
		});
		//////////////////////
		character[0].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[0].setVisible(true);
			if(character[0].getGraphic()!=img_character_choose[0])
				character[0].setGraphic(img_character_touch[0]);
			Choose.play();
		});
		character[1].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[1].setVisible(true);
			if(character[1].getGraphic()!=img_character_choose[1])
				character[1].setGraphic(img_character_touch[1]);
			Choose.play();
		});
		character[2].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[2].setVisible(true);
			if(character[2].getGraphic()!=img_character_choose[2])
				character[2].setGraphic(img_character_touch[2]);
			Choose.play();
		});
		character[3].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[3].setVisible(true);
			if(character[3].getGraphic()!=img_character_choose[3])
				character[3].setGraphic(img_character_touch[3]);
			Choose.play();
		});
		character[4].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[4].setVisible(true);
			if(character[4].getGraphic()!=img_character_choose[4])
				character[4].setGraphic(img_character_touch[4]);
			Choose.play();
		});
		character[5].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[5].setVisible(true);
			if(character[5].getGraphic()!=img_character_choose[5])
				character[5].setGraphic(img_character_touch[5]);
			Choose.play();
		});
		character[6].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[6].setVisible(true);
			if(character[6].getGraphic()!=img_character_choose[6])
				character[6].setGraphic(img_character_touch[6]);
			Choose.play();
		});
		character[7].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[7].setVisible(true);
			if(character[7].getGraphic()!=img_character_choose[7])
				character[7].setGraphic(img_character_touch[7]);
			Choose.play();
		});
		character[8].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[8].setVisible(true);
			if(character[8].getGraphic()!=img_character_choose[8])
				character[8].setGraphic(img_character_touch[8]);
			Choose.play();
		});
		character[9].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			img_character_intro[9].setVisible(true);
			if(character[9].getGraphic()!=img_character_choose[9])
				character[9].setGraphic(img_character_touch[9]);
			Choose.play();
		});
		/////////////////////
		character[0].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[0].setVisible(false);
			if(character[0].getGraphic()!=img_character_choose[0])
				character[0].setGraphic(img_character[0]);
		});
		character[1].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[1].setVisible(false);
			if(character[1].getGraphic()!=img_character_choose[1])
				character[1].setGraphic(img_character[1]);
		});
		character[2].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[2].setVisible(false);
			if(character[2].getGraphic()!=img_character_choose[2])
				character[2].setGraphic(img_character[2]);
		});
		character[3].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[3].setVisible(false);
			if(character[3].getGraphic()!=img_character_choose[3])
				character[3].setGraphic(img_character[3]);
		});
		character[4].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[4].setVisible(false);
			if(character[4].getGraphic()!=img_character_choose[4])
				character[4].setGraphic(img_character[4]);
		});
		character[5].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[5].setVisible(false);
			if(character[5].getGraphic()!=img_character_choose[5])
				character[5].setGraphic(img_character[5]);
		});
		character[6].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[6].setVisible(false);
			if(character[6].getGraphic()!=img_character_choose[6])
				character[6].setGraphic(img_character[6]);
		});
		character[7].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[7].setVisible(false);
			if(character[7].getGraphic()!=img_character_choose[7])
				character[7].setGraphic(img_character[7]);
		});
		character[8].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[8].setVisible(false);
			if(character[8].getGraphic()!=img_character_choose[8])
				character[8].setGraphic(img_character[8]);
		});
		character[9].addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent e) -> {
			img_character_intro[9].setVisible(false);
			if(character[9].getGraphic()!=img_character_choose[9])
				character[9].setGraphic(img_character[9]);
		});
		anchor.getChildren().addAll(background,main1,main2);
		for(int i = 0;i < 10;i++) {
			anchor.getChildren().add(img_character_intro[i]);
		}
		/////////////////////
		mainscene = new Scene(anchor,1280,720);
	}
}
