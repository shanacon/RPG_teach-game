package Final;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class day {
	///////////////////////////////
	public Text save_text = new Text("已存檔！！");
	public config config = new config();
	///////////////////////////////
	public Scene scene;
	public AnchorPane main_day = new AnchorPane();
	public AnchorPane talent_pane = new AnchorPane();
	//////////////////////////////
	public static Student_data data = new Student_data();
	public Calendar calendar_pane = new Calendar();
	//////////////////////////////
	public Schedule students_schedule[] = new Schedule[3];
	//////////////////////////////
	public Text day_and_talentpoint = new Text();
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
	public static int use_setudent_number[] = new int[3];
	public static Student student[] = new Student[10];
	public static Student used_student[] = new Student[3];
	public ImageView img_calendar_normal = new ImageView();
	public ImageView img_calendar_pressed = new ImageView();
	public ImageView img_calendar_touch = new ImageView();
	public ImageView img_checkdata_normal = new ImageView();
	public ImageView img_checkdata_pressed = new ImageView();
	public ImageView img_checkdata_touch = new ImageView();
	public ImageView img_s_name_normal = new ImageView();
	public ImageView img_s_name_pressed = new ImageView();
	public ImageView img_s_name_touch = new ImageView();
	public ImageView img_set_normal = new ImageView();
	public ImageView img_set_pressed = new ImageView();
	public ImageView img_set_touch = new ImageView();
	public ImageView img_talent_normal = new ImageView();
	public ImageView img_talent_pressed = new ImageView();
	public ImageView img_talent_touch = new ImageView();
	public ImageView day_background = new ImageView();
	public ImageView img_teach_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/teach_normal.png")));
	public ImageView img_teach_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/teach_pressed.png")));
	public ImageView img_teach_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/teach_touch.png")));
	public Button teach = new Button();
	public static boolean talent_use[];
	public ImageView img_character[] = new ImageView[10];
	public ImageView img_character_touch[] = new ImageView[10];
	public Button students_button[] = new Button[3];
	////////////////////////////////////
	public ImageView img_talent_false_normal[] = new ImageView[15];
	public ImageView img_talent_false_choose[] = new ImageView[15];
	public ImageView img_talent_true_normal[] = new ImageView[15];
	public ImageView img_talent_true_choose[] = new ImageView[15];
	public ImageView img_unlock_normal = new ImageView();
	public ImageView img_unlock_pressed = new ImageView();
	public ImageView img_unlock_touch = new ImageView();
	public ImageView img_back_normal = new ImageView();
	public ImageView img_back_pressed = new ImageView();
	public ImageView img_back_touch = new ImageView();
	public ImageView img_talent_background = new ImageView();
	public Button talent_button[]  = new Button[15];
	public Button unlock = new Button();
	public Text talent_text[] = new Text[15];
	public Text talent_point_text = new Text();
	public Text error_text_1 = new Text("天賦點不足！！");
	public Text error_text_2 = new Text("尚未解鎖前一個天賦！！");
	public static int talent_point = 0;
	public Button talent_back = new Button();
	///////////////////////////////
	public S_name sname= new S_name();
	///////////////////////////////
	public AudioClip Choose;
	public AudioClip Click;
	public AudioClip Switch;
	public AudioClip Error;
	public Button calendar = new Button();
	public Button checkdata = new Button();
	public Button s_name = new Button();
	public Button set = new Button();
	public Button talent = new Button();
	///////////////////////////////////
	public static int day = 1;
	//////////////////////////////////
	public day(ImageView img_calendar_normal,ImageView img_calendar_pressed,ImageView img_calendar_touch,
			ImageView img_checkdata_normal,ImageView img_checkdata_pressed,ImageView img_checkdata_touch,
			ImageView img_s_name_normal,ImageView img_s_name_pressed,ImageView img_s_name_touch,ImageView img_set_normal,
			ImageView img_set_pressed,ImageView img_set_touch,ImageView img_talent_normal,ImageView img_talent_pressed,
			ImageView img_talent_touch,ImageView day_background,AudioClip Choose,AudioClip Click,ImageView img_talent_false_normal[],
			ImageView img_talent_false_choose[],ImageView img_talent_true_normal[],ImageView img_talent_true_choose[],
			ImageView img_unlock_normal,ImageView img_unlock_pressed,ImageView img_unlock_touch,ImageView img_talent_background,
			AudioClip Switch,boolean talent_use[],ImageView img_back_normal,ImageView img_back_pressed,ImageView img_back_touch,
			AudioClip Error,ImageView img_character[],ImageView img_character_touch[]){
		this.img_calendar_normal=img_calendar_normal;
		this.img_calendar_pressed=img_calendar_pressed;
		this.img_calendar_touch=img_calendar_touch;
		this.img_checkdata_normal=img_checkdata_normal;
		this.img_checkdata_pressed=img_checkdata_pressed;
		this.img_checkdata_touch=img_checkdata_touch;
		this.img_s_name_normal=img_s_name_normal;
		this.img_s_name_pressed=img_s_name_pressed;
		this.img_s_name_touch=img_s_name_touch;
		this.img_set_normal=img_set_normal;
		this.img_set_pressed=img_set_pressed;
		this.img_set_touch=img_set_touch;
		this.img_talent_normal=img_talent_normal;
		this.img_talent_pressed=img_talent_pressed;
		this.img_talent_touch=img_talent_touch;
		this.day_background=day_background;
		this.Choose=Choose;
		this.Click=Click;
		this.img_character = img_character;
		this.img_character_touch = img_character_touch;
		/////////////////////////////////
		this.img_talent_false_normal = img_talent_false_normal;
		this.img_talent_false_choose = img_talent_false_choose;
		this.img_talent_true_normal = img_talent_true_normal;
		this.img_talent_true_choose = img_talent_true_choose;
		this.img_unlock_normal = img_unlock_normal;
		this.img_unlock_pressed = img_unlock_pressed;
		this.img_unlock_touch =img_unlock_touch;
		this.img_talent_background = img_talent_background;
		this.Switch = Switch;
		this.talent_use = talent_use;
		this.img_back_normal = img_back_normal;
		this.img_back_pressed = img_back_pressed;
		this.img_back_touch = img_back_touch;
		this.Error = Error;
		//////////////////////////////////////////
	}
	public void setbutton(){
		save_text.setLayoutX(520);
		save_text.setLayoutY(400);
		save_text.setStyle("-fx-font-size: 40px;");
		save_text.setVisible(false);
		//////////////////////////////////
		day_and_talentpoint.setText("今天日期：5/"+day+"\n持有天賦點："+talent_point);
		day_and_talentpoint.setLayoutX(760);
		day_and_talentpoint.setLayoutY(50);
		day_and_talentpoint.setStyle("-fx-font-size: 35px;");
		//////////////////////////////////
		student[0] = new Student(350,250,15,170,10,200,20,1,img_character[0],img_character_touch[0],"追加解題：1","靈光乍現：30","靈光一閃：45","數學專精：1");
		student[1] = new Student(350,200,10,150,10,250,20,1,img_character[1],img_character_touch[1],"程式專精：2","自我回復：40","靈光一閃：75","--------------");
		student[2] = new Student(300,150,15,170,15,170,15,1,img_character[2],img_character_touch[2],"全體回復：20","全體回復：50","意見整合：40","意見整合：20");
		student[3] = new Student(300,100,10,300,20,100,10,1,img_character[3],img_character_touch[3],"語文專精：2","追加解題：2","--------------","--------------");
		student[4] = new Student(350,250,20,150,10,200,15,1,img_character[4],img_character_touch[4],"自我回復：80","自我回復：20","數學專精：1","靈光乍現：30");
		student[5] = new Student(350,150,15,150,10,150,30,1,img_character[5],img_character_touch[5],"靈光乍現：30","靈光乍現：30","靈光一閃：45","--------------");
		student[6] = new Student(400,250,15,25,5,250,20,1,img_character[6],img_character_touch[6],"數學專精：1","程式專精：1","追加解題：1","--------------");
		student[7] = new Student(450,150,30,150,30,150,25,1,img_character[7],img_character_touch[7],"全體回復：50","全體回復：50","--------------","--------------");
		student[8] = new Student(400,250,30,300,30,150,25,1,img_character[8],img_character_touch[8],"語文專精：2","數學專精：2","語文解題：1","追加解題：3");
		student[9] = new Student(500,300,20,300,20,300,20,1,img_character[9],img_character_touch[9],"全體解題：1","追加解題：3","追加解題：3","靈光一閃：75");
		//////////////////////////
		day_background.setLayoutX(0);
		day_background.setLayoutY(0);
		/////////////////////////
		set.setGraphic(img_set_normal);
		calendar.setGraphic(img_calendar_normal);
		talent.setGraphic(img_talent_normal);
		s_name.setGraphic(img_s_name_normal);
		checkdata.setGraphic(img_checkdata_normal);
		teach.setGraphic(img_teach_normal);
		/////////////////////////
		set.setLayoutX(36);
		set.setLayoutY(46);
		calendar.setLayoutX(178);
		calendar.setLayoutY(43);
		talent.setLayoutX(311);
		talent.setLayoutY(16);
		s_name.setLayoutX(456);
		s_name.setLayoutY(-16);
		checkdata.setLayoutX(614);
		checkdata.setLayoutY(6);
		teach.setLayoutX(1050);
		teach.setLayoutY(50);
		///////////////////////////
		set.setStyle("-fx-background-color: transparent");
		set.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			set.setGraphic(img_set_touch);
		});
		set.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(set.getGraphic()==img_set_touch) {
				set.setGraphic(img_set_normal);
			}
		});
		set.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(config.config_pane.getLayoutY()==-175) {
				Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
					config.config_pane.setLayoutY(config.config_pane.getLayoutY()+5);
				    }));
				t.setCycleCount(35);
				t.play();
			}
			set.setGraphic(img_set_pressed);
			Click.play();
		});
		set.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			set.setGraphic(img_set_touch);
		});
		set.setOnMouseExited(e->{
			set.setGraphic(img_set_normal);
		});
		////////////////
		config.save.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Timeline t = new Timeline();
			t.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO, (a)-> {save_text.setVisible(true);})
					,new KeyFrame(Duration.ZERO, new KeyValue(save_text.opacityProperty(), 0))
					,new KeyFrame(new Duration(300), new KeyValue(save_text.opacityProperty(), 1))
					,new KeyFrame(new Duration(600), (a)-> {save_text.setVisible(false);})
					,new KeyFrame(new Duration(600), new KeyValue(save_text.opacityProperty(), 0))
					);
			t.play();
			outputfile();
		});
		///////////////////////////
		calendar.setStyle("-fx-background-color: transparent");
		calendar.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			calendar.setGraphic(img_calendar_touch);
		});
		calendar.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(calendar.getGraphic()==img_calendar_touch) {
				calendar.setGraphic(img_calendar_normal);
			}
		});
		calendar.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			calendar.setGraphic(img_calendar_pressed);
			calendar_pane.goin();
			Click.play();
		});
		calendar.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			calendar.setGraphic(img_calendar_touch);
		});
		calendar.setOnMouseExited(e->{
			calendar.setGraphic(img_calendar_normal);
		});
		///////////////////////////
		talent.setStyle("-fx-background-color: transparent");
		talent.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			talent.setGraphic(img_talent_touch);
		});
		talent.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(talent.getGraphic()==img_talent_touch) {
				talent.setGraphic(img_talent_normal);
			}
		});
		talent.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			talent.setGraphic(img_talent_pressed);
			settalentnormal(talent_use,talent_button);
			talent_point_text.setText("現有天賦點："+talent_point);
			Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
				talent_pane.setLayoutX(talent_pane.getLayoutX()+10);
			    }));
			t.setCycleCount(128);
			t.play();
			Click.play();
		});
		talent.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			talent.setGraphic(img_talent_touch);
		});
		talent.setOnMouseExited(e->{
			talent.setGraphic(img_talent_normal);
		});
		///////////////////////////
		s_name.setStyle("-fx-background-color: transparent");
		s_name.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			s_name.setGraphic(img_s_name_touch);
		});
		s_name.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(s_name.getGraphic()==img_s_name_touch) {
				s_name.setGraphic(img_s_name_normal);
			}
		});
		s_name.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			s_name.setGraphic(img_s_name_pressed);
			talent_point_text.setText("現有天賦點："+talent_point);
			if(sname.S_name_pane.getLayoutX()==-1280) {
				Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
					sname.S_name_pane.setLayoutX(sname.S_name_pane.getLayoutX()+10);
				    }));
				t.setCycleCount(128);
				t.play();
			}
			Click.play();
		});
		s_name.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			s_name.setGraphic(img_s_name_touch);
		});
		s_name.setOnMouseExited(e->{
			s_name.setGraphic(img_s_name_normal);
		});
		///////////////////////////
		checkdata.setStyle("-fx-background-color: transparent");
		checkdata.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			checkdata.setGraphic(img_checkdata_touch);
		});
		checkdata.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(checkdata.getGraphic()==img_checkdata_touch) {
				checkdata.setGraphic(img_checkdata_normal);
			}
		});
		checkdata.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			checkdata.setGraphic(img_checkdata_pressed);
			if(data.Student_data.getLayoutX()==-1280) {
				Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
					data.Student_data.setLayoutX(data.Student_data.getLayoutX()+10);
				    }));
				t.setCycleCount(128);
				t.play();
			}
			Click.play();
		});
		checkdata.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			checkdata.setGraphic(img_checkdata_touch);
		});
		checkdata.setOnMouseExited(e->{
			checkdata.setGraphic(img_checkdata_normal);
		});
		///////////////////////////
		teach.setStyle("-fx-background-color: transparent");
		teach.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			teach.setGraphic(img_teach_touch);
		});
		teach.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(teach.getGraphic()==img_teach_touch) {
				teach.setGraphic(img_teach_normal);
			}
		});
		teach.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			teach.setGraphic(img_teach_pressed);
			for(int i = 0;i < 3;i++)
				sname.Student_data[i].checkskill();
			sname.setonskill();
			changeday();
			Click.play();
		});
		teach.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			teach.setGraphic(img_teach_touch);
		});
		teach.setOnMouseExited(e->{
			teach.setGraphic(img_teach_normal);
		});
		///////////////////////////
		talent_pane.setLayoutX(-1280);
		talent_pane.setLayoutY(0);
		//////////////////////////////
		for(int i = 0;i < 3;i++)
			students_button[i] = new Button();
		///////////////////////////
		main_day.getChildren().addAll(day_background,set,calendar,talent,s_name,checkdata,day_and_talentpoint,teach,config.config_pane,save_text);
		///////////////////////////
	}
	public void setstudent_2() {
		for(int i = 0;i < 3;i++) {
			used_student[i] = new Student();
			used_student[i] = student[use_setudent_number[i]];
		}
		students_button[0].setLayoutX(50);
		students_button[0].setLayoutY(400);
		students_button[1].setLayoutX(300);
		students_button[1].setLayoutY(400);
		students_button[2].setLayoutX(550);
		students_button[2].setLayoutY(400);
		for(int i = 0;i < 3;i++)
			students_button[i].setGraphic(used_student[i].img_student);
		for(int i = 0;i < 3;i++)
			students_button[i].setStyle("-fx-background-color: transparent");
		//////////////////////////////////////////////
		students_button[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[0].setGraphic(used_student[0].img_student_touch);
		});
		students_button[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[0].setGraphic(used_student[0].img_student);
		});
		students_button[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[0].goin();
			Click.play();
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[1].setGraphic(used_student[1].img_student_touch);
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[1].setGraphic(used_student[1].img_student);
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[1].goin();
			Click.play();
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[2].setGraphic(used_student[2].img_student_touch);
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[2].setGraphic(used_student[2].img_student);
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[2].goin();
			Click.play();
		});
		//////////////////////////////////////////////
		for(int i = 0;i < 3;i++)
			main_day.getChildren().add(students_button[i]);
	}
	public void setstudent(boolean use_student[]) {
		students_button[0].setLayoutX(50);
		students_button[0].setLayoutY(400);
		students_button[1].setLayoutX(300);
		students_button[1].setLayoutY(400);
		students_button[2].setLayoutX(550);
		students_button[2].setLayoutY(400);
		for(int i = 0,j = 0;i < 10;i++){
			if(use_student[i]==true) {
				use_setudent_number[j] = i;
				j++;
			}		
		}
		for(int i = 0;i < 3;i++) {
			used_student[i] = new Student();
			used_student[i] = student[use_setudent_number[i]];
		}
		for(int i = 0;i < 3;i++)
			students_button[i].setGraphic(used_student[i].img_student);
		for(int i = 0;i < 3;i++)
			students_button[i].setStyle("-fx-background-color: transparent");
		//////////////////////////////////////////////
		students_button[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[0].setGraphic(used_student[0].img_student_touch);
		});
		students_button[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[0].setGraphic(used_student[0].img_student);
		});
		students_button[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[0].goin();
			Click.play();
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[1].setGraphic(used_student[1].img_student_touch);
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[1].setGraphic(used_student[1].img_student);
		});
		students_button[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[1].goin();
			Click.play();
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			students_button[2].setGraphic(used_student[2].img_student_touch);
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				students_button[2].setGraphic(used_student[2].img_student);
		});
		students_button[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			students_schedule[2].goin();
			Click.play();
		});
		//////////////////////////////////////////////
		for(int i = 0;i < 3;i++)
			main_day.getChildren().add(students_button[i]);
	}
	public void settalent() {
		///////////////////////////
		error_text_1.setLayoutX(520);
		error_text_1.setLayoutY(400);
		error_text_1.setStyle("-fx-font-size: 40px;");
		error_text_1.setVisible(false);
		///////////////////////////
		error_text_2.setLayoutX(400);
		error_text_2.setLayoutY(400);
		error_text_2.setStyle("-fx-font-size: 40px;");
		error_text_2.setVisible(false);
		///////////////////////////
		talent_back.setGraphic(img_back_normal);
		talent_back.setLayoutX(30);
		talent_back.setLayoutY(600);
		///////////////////////////
		talent_back.setStyle("-fx-background-color: transparent");
		talent_back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			talent_back.setGraphic(img_back_touch);
		});
		talent_back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(talent_back.getGraphic()==img_back_touch) {
				talent_back.setGraphic(img_back_normal);
			}
		});
		talent_back.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			talent_back.setGraphic(img_back_pressed);
			Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
				talent_pane.setLayoutX(talent_pane.getLayoutX()-10);
			    }));
			t.setCycleCount(128);
			t.play();
			refresh_day_and_talentpoint();
			Cancel.play();
		});
		talent_back.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			talent_back.setGraphic(img_back_touch);
		});
		talent_back.setOnMouseExited(e->{
			talent_back.setGraphic(img_back_normal);
		});
		///////////////////////////
		unlock.setGraphic(img_unlock_normal);
		unlock.setLayoutX(900);
		unlock.setLayoutY(400);
		///////////////////////////
		unlock.setStyle("-fx-background-color: transparent");
		unlock.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			unlock.setGraphic(img_unlock_touch);
		});
		unlock.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(unlock.getGraphic()==img_unlock_touch) {
				unlock.setGraphic(img_unlock_normal);
			}
		});
		unlock.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			unlock.setGraphic(img_unlock_pressed);
			unlocktalent(talent_use,talent_button);
			refresh_day_and_talentpoint();
		});
		unlock.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			unlock.setGraphic(img_unlock_touch);
		});
		unlock.setOnMouseExited(e->{
			unlock.setGraphic(img_unlock_normal);
		});
		///////////////////////////
		img_talent_background.setLayoutX(0);
		img_talent_background.setLayoutY(0);
		for(int i = 0 ;i < 15;i++) {
			talent_button[i] = new Button();
			talent_button[i].setStyle("-fx-background-color: transparent");
			talent_button[i].setGraphic(img_talent_false_normal[i]);
		}
		talent_button[0].setLayoutX(442);
		talent_button[0].setLayoutY(323);
		talent_button[1].setLayoutX(330);
		talent_button[1].setLayoutY(243);
		talent_button[2].setLayoutX(218);
		talent_button[2].setLayoutY(163);
		talent_button[3].setLayoutX(108);
		talent_button[3].setLayoutY(82);
		talent_button[4].setLayoutX(-6);
		talent_button[4].setLayoutY(5);
		talent_button[5].setLayoutX(522);
		talent_button[5].setLayoutY(211);
		talent_button[6].setLayoutX(602);
		talent_button[6].setLayoutY(100);
		talent_button[7].setLayoutX(680);
		talent_button[7].setLayoutY(-9);
		talent_button[8].setLayoutX(553);
		talent_button[8].setLayoutY(403);
		talent_button[9].setLayoutX(665);
		talent_button[9].setLayoutY(483);
		talent_button[10].setLayoutX(777);
		talent_button[10].setLayoutY(563);
		talent_button[11].setLayoutX(888);
		talent_button[11].setLayoutY(639);
		talent_button[12].setLayoutX(362);
		talent_button[12].setLayoutY(435);
		talent_button[13].setLayoutX(282);
		talent_button[13].setLayoutY(547);
		talent_button[14].setLayoutX(204);
		talent_button[14].setLayoutY(657);
		////////////////////////////////////
		talent_button[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[0]==false)
				talent_button[0].setGraphic(img_talent_false_choose[0]);
			else if(talent_use[0]==true)
				talent_button[0].setGraphic(img_talent_true_choose[0]);
			talent_text[0].setVisible(true);
			Switch.play();
		});
		talent_button[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[1]==false)
				talent_button[1].setGraphic(img_talent_false_choose[1]);
			else if(talent_use[1]==true)
				talent_button[1].setGraphic(img_talent_true_choose[1]);
			talent_text[1].setVisible(true);
			Switch.play();
		});
		talent_button[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[2]==false)
				talent_button[2].setGraphic(img_talent_false_choose[2]);
			else if(talent_use[2]==true)
				talent_button[2].setGraphic(img_talent_true_choose[2]);
			talent_text[2].setVisible(true);
			Switch.play();
		});
		talent_button[3].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[3]==false)
				talent_button[3].setGraphic(img_talent_false_choose[3]);
			else if(talent_use[3]==true)
				talent_button[3].setGraphic(img_talent_true_choose[3]);
			talent_text[3].setVisible(true);
			Switch.play();
		});
		talent_button[4].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[4]==false)
				talent_button[4].setGraphic(img_talent_false_choose[4]);
			else if(talent_use[4]==true)
				talent_button[4].setGraphic(img_talent_true_choose[4]);
			talent_text[4].setVisible(true);
			Switch.play();
		});
		talent_button[5].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[5]==false)
				talent_button[5].setGraphic(img_talent_false_choose[5]);
			else if(talent_use[5]==true)
				talent_button[5].setGraphic(img_talent_true_choose[5]);
			talent_text[5].setVisible(true);
			Switch.play();
		});
		talent_button[6].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[6]==false)
				talent_button[6].setGraphic(img_talent_false_choose[6]);
			else if(talent_use[6]==true)
				talent_button[6].setGraphic(img_talent_true_choose[6]);
			talent_text[6].setVisible(true);
			Switch.play();
		});
		talent_button[7].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[7]==false)
				talent_button[7].setGraphic(img_talent_false_choose[7]);
			else if(talent_use[7]==true)
				talent_button[7].setGraphic(img_talent_true_choose[7]);
			talent_text[7].setVisible(true);
			Switch.play();
		});
		talent_button[8].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[8]==false)
				talent_button[8].setGraphic(img_talent_false_choose[8]);
			else if(talent_use[8]==true)
				talent_button[8].setGraphic(img_talent_true_choose[8]);
			talent_text[8].setVisible(true);
			Switch.play();
		});
		talent_button[9].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[9]==false)
				talent_button[9].setGraphic(img_talent_false_choose[9]);
			else if(talent_use[9]==true)
				talent_button[9].setGraphic(img_talent_true_choose[9]);
			talent_text[9].setVisible(true);
			Switch.play();
		});
		talent_button[10].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[10]==false)
				talent_button[10].setGraphic(img_talent_false_choose[10]);
			else if(talent_use[10]==true)
				talent_button[10].setGraphic(img_talent_true_choose[10]);
			talent_text[10].setVisible(true);
			Switch.play();
		});
		talent_button[11].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[11]==false)
				talent_button[11].setGraphic(img_talent_false_choose[11]);
			else if(talent_use[11]==true)
				talent_button[11].setGraphic(img_talent_true_choose[11]);
			talent_text[11].setVisible(true);
			Switch.play();
		});
		talent_button[12].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[12]==false)
				talent_button[12].setGraphic(img_talent_false_choose[12]);
			else if(talent_use[12]==true)
				talent_button[12].setGraphic(img_talent_true_choose[12]);
			talent_text[12].setVisible(true);
			Switch.play();
		});
		talent_button[13].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[13]==false)
				talent_button[13].setGraphic(img_talent_false_choose[13]);
			else if(talent_use[13]==true)
				talent_button[13].setGraphic(img_talent_true_choose[13]);
			talent_text[13].setVisible(true);
			Switch.play();
		});
		talent_button[14].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			settalentnormal(talent_use,talent_button);
			if(talent_use[14]==false)
				talent_button[14].setGraphic(img_talent_false_choose[14]);
			else if(talent_use[14]==true)
				talent_button[14].setGraphic(img_talent_true_choose[14]);
			talent_text[14].setVisible(true);
			Switch.play();
		});
		//////////////////////////////////////////
		settext();
		//////////////////////////////////////////
		talent_pane.getChildren().add(img_talent_background);
		for(int i = 0 ;i < 15;i++) {
			talent_pane.getChildren().add(talent_button[i]);
		}
		talent_pane.getChildren().addAll(unlock,talent_point_text,talent_back,error_text_1,error_text_2);
		for(int i = 0 ;i < 15;i++) {
			talent_pane.getChildren().add(talent_text[i]);
		}
		main_day.getChildren().add(talent_pane);
	}
	public void settalentnormal(boolean use[],Button talent[]) {
		for(int i  = 0;i < 15;i++) {
			if(use[i]==false)
				talent_button[i].setGraphic(img_talent_false_normal[i]);
			if(use[i]==true)
				talent_button[i].setGraphic(img_talent_true_normal[i]);
			talent_text[i].setVisible(false);
		}
	}
	public void unlocktalent(boolean use[],Button talent[]) {
		boolean flag = true;
		int num = 0;
		for(int i  = 0;i < 15;i++) {
			if(talent_button[i].getGraphic()==img_talent_false_choose[i]) {
				flag = false;
				num = i;
				break;
			}
			else if(talent_button[i].getGraphic()==img_talent_true_choose[i]) {
				flag = true;
				num = i;
				break;
			}
		}
		if(num==1&&flag==false) {
			if(talent_point>=10) {
				Teacher.teach_rate = Teacher.teach_rate + 0.15;
				talent_point = talent_point-10;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else
				talent_error_1();
		}
		else if(num==2&&flag==false) {
			if(talent_point>=30&&use[num-1] == true) {
				talent_point = talent_point-30;
				Teacher.teach_rate = Teacher.teach_rate + 0.2;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==3&&flag==false) {
			if(talent_point>=50&&use[num-1] == true) {
				talent_point = talent_point-50;
				Teacher.teach_rate = Teacher.teach_rate + 0.2;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==4&&flag==false) {
			if(talent_point>=70&&use[num-1] == true) {
				talent_point = talent_point-70;
				Teacher.teach_rate = Teacher.teach_rate + 0.2;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==5&&flag==false) {
			if(talent_point>=20) {
				talent_point = talent_point-20;
				for(int i = 0;i < 3;i++)
					sname.Student_data[i].s_name_button_0[1].setVisible(true);
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else
				talent_error_1();
		}
		else if(num==6&&flag==false) {
			if(talent_point>=40&&use[num-1] == true) {
				talent_point = talent_point-40;
				for(int i = 0;i < 3;i++)
					sname.Student_data[i].s_name_button_0[2].setVisible(true);
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==7&&flag==false) {
			if(talent_point>=60&&use[num-1] == true) {
				talent_point = talent_point-60;
				for(int i = 0;i < 3;i++)
					sname.Student_data[i].s_name_button_0[3].setVisible(true);
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==8&&flag==false) {
			if(talent_point>=5) {
				talent_point = talent_point-5;
				Teacher.test_rate = Teacher.test_rate + 0.1;
				Teacher.test_rate_talent = Teacher.test_rate_talent + 0;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else
				talent_error_1();
		}
		else if(num==9&&flag==false) {
			if(talent_point>=30&&use[num-1] == true) {
				talent_point = talent_point-30;
				Teacher.test_rate = Teacher.test_rate + 0.15;
				Teacher.test_rate_talent = Teacher.test_rate_talent + 1;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==10&&flag==false) {
			if(talent_point>=40&&use[num-1] == true) {
				talent_point = talent_point-40;
				Teacher.test_rate = Teacher.test_rate + 0.15;
				Teacher.test_rate_talent = Teacher.test_rate_talent + 0;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==11&&flag==false) {
			if(talent_point>=80&&use[num-1] == true) {
				talent_point = talent_point-80;
				Teacher.test_rate = Teacher.test_rate + 0.25;
				Teacher.test_rate_talent = Teacher.test_rate_talent + 1;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else
				talent_error_1();
		}
		else if(num==12&&flag==false) {
			if(talent_point>=20) {
				talent_point = talent_point-20;
				Teacher.talk_rate = Teacher.talk_rate + 1;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else
				talent_error_1();
		}
		else if(num==13&&flag==false) {
			if(talent_point>=40&&use[num-1] == true) {
				talent_point = talent_point-40;
				Teacher.talk_rate = Teacher.talk_rate + 1;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else 
				talent_error_1();
		}
		else if(num==14&&flag==false) {
			if(talent_point>=60&&use[num-1] == true) {
				talent_point = talent_point-60;
				Teacher.talk_rate = Teacher.talk_rate + 1;
				talent[num].setGraphic(img_talent_true_choose[num]);
				use[num] = true;
				talent_point_text.setText("現有天賦點："+talent_point);
				Click.play();
			}
			else if(use[num-1] == false)
				talent_error_2();
			else 
				talent_error_1();
		}
	}
	public void talent_error_1() {
		Error.play();
		Timeline t = new Timeline();
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {error_text_1.setVisible(true);})
				,new KeyFrame(Duration.ZERO, new KeyValue(error_text_1.opacityProperty(), 0))
				,new KeyFrame(new Duration(300), new KeyValue(error_text_1.opacityProperty(), 1))
				,new KeyFrame(new Duration(600), new KeyValue(error_text_1.opacityProperty(), 0))
				,new KeyFrame(new Duration(600),(a)-> {error_text_1.setVisible(false);})
				);
		t.play();
	}
	public void talent_error_2() {
		Error.play();
		Timeline t = new Timeline();
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {error_text_2.setVisible(true);})
				,new KeyFrame(Duration.ZERO, new KeyValue(error_text_2.opacityProperty(), 0))
				,new KeyFrame(new Duration(300), new KeyValue(error_text_2.opacityProperty(), 1))
				,new KeyFrame(new Duration(600), new KeyValue(error_text_2.opacityProperty(), 0))
				,new KeyFrame(new Duration(600),(a)-> {error_text_2.setVisible(false);})
				);
		t.play();
	}
	public void settext() {
		talent_point_text.setText("現有天賦點："+talent_point);
		talent_point_text.setStyle("-fx-font-size: 40px;");
		talent_point_text.setLayoutX(900);
		talent_point_text.setLayoutY(100);
		for(int i = 0;i < 15;i++) {
			talent_text[i] = new Text();
			talent_text[i].setLayoutX(900);
			talent_text[i].setLayoutY(300);
			talent_text[i].setStyle("-fx-font-size: 25px;");
			talent_text[i].setVisible(false);
		}
		talent_text[1].setText("教學效率+15%\n所需天賦點：10");
		talent_text[2].setText("教學效率+35%\n所需天賦點：30");
		talent_text[3].setText("教學效率+55%\n所需天賦點：50");
		talent_text[4].setText("教學效率+75%\n所需天賦點：70");
		talent_text[5].setText("可使用B級稱號\n所需天賦點：20");
		talent_text[6].setText("可使用A級稱號\n所需天賦點：40");
		talent_text[7].setText("可使用S級稱號\n所需天賦點：60");
		talent_text[8].setText("測驗效率\n天賦點增加量+0\n能力增加量+10%\n所需天賦點：5");
		talent_text[9].setText("測驗效率\n天賦點增加量+1\n能力增加量+25%\n所需天賦點：30");
		talent_text[10].setText("測驗效率\n天賦點增加量+1\n能力增加量+40%\n所需天賦點：40");
		talent_text[11].setText("測驗效率\n天賦點增加量+2\n能力增加量+65%\n所需天賦點：80");
		talent_text[12].setText("相談效率\n天賦點增加量+1\n所需天賦點：20");
		talent_text[13].setText("相談效率\n天賦點增加量+2\n所需天賦點：40");
		talent_text[14].setText("相談效率\n天賦點增加量+3\n所需天賦點：60");
	}
	public void setcalendar() {
		calendar_pane.setcalendar();
		main_day.getChildren().add(calendar_pane.calnedar_pane);
	}
	public void setschedule(){
		for(int i = 0;i < 3;i++) {
			students_schedule[i] = new Schedule();
			students_schedule[i].setbutton();
			main_day.getChildren().add(students_schedule[i].schedule_pane);
		}
	}
	public void setsname() {
		sname.set_S_name();
		main_day.getChildren().add(sname.S_name_pane);
	}
	public void setdata() {
		data.setStudent_data();
		main_day.getChildren().add(data.Student_data);
	}
	public void refresh_day_and_talentpoint() {
		day_and_talentpoint.setText("今天日期：5/"+day+"\n持有天賦點："+talent_point);
	}
	public void changeday() {
		day++;
		teachstudent();
		Timeline t = new Timeline();
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(main_day.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {refresh_day_and_talentpoint();})
				,new KeyFrame(new Duration(1000), new KeyValue(main_day.opacityProperty(), 1))
				);
		t.play();
	}
	public void teachstudent() {
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 6;j++) {
				if(used_student[i].hpnow > 80) {
					if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_math_arr[j])
						used_student[i].addmath(Teacher.teach_rate);
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_language_arr[j])
						used_student[i].addlanguage(Teacher.teach_rate);
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_program_arr[j])
						used_student[i].addprogram(Teacher.teach_rate);
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_rest_arr[j])
						used_student[i].addhpnow();
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_exercise_arr[j])
						used_student[i].addhp();
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_talk_arr[j])
						talent_point = talent_point + Teacher.talk_rate;
					else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_test_arr[j]) {
						used_student[i].addmath(0.3*Teacher.test_rate);
						used_student[i].addlanguage(0.3*Teacher.test_rate);
						used_student[i].addprogram(0.3*Teacher.test_rate);
						talent_point = talent_point + Teacher.test_rate_talent;
					}
				}
				else if(students_schedule[i].clss[j].getGraphic()==students_schedule[i].img_rest_arr[j])
					used_student[i].addhpnow();
			}
			used_student[i].refresh();
		}
	}
	public void outputfile() {
		String alldata = new String("");
		alldata = alldata + main.dif.get()+"\n";
		for(int i = 0;i < 3;i++)
			alldata = alldata + use_setudent_number[i]+"\n";
		for(int i = 0;i < 3;i++) {
			alldata = alldata + used_student[i].hp +"\n";
			alldata = alldata + used_student[i].math +"\n";
			alldata = alldata + used_student[i].language +"\n";
			alldata = alldata + used_student[i].program +"\n";
		}
		alldata = alldata + talent_point +"\n";
		alldata = alldata + day +"\n";
		for(int i = 0;i < 15;i++) {
			if(talent_use[i]==true)
				alldata = alldata + "1" +"\n";
			else if(talent_use[i]==false)
				alldata = alldata + "0" +"\n";
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 4;j < 8;j++)
				alldata = alldata + used_student[i].Skill[j].getText() +"\n";
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 4;j++) {
				if(sname.Student_data[i].s_name_button[j].getGraphic()==sname.Student_data[i].s_name_C[j])
					alldata = alldata + "C" +"\n";
				else if(sname.Student_data[i].s_name_button[j].getGraphic()==sname.Student_data[i].s_name_B[j])
					alldata = alldata + "B" +"\n";
				else if(sname.Student_data[i].s_name_button[j].getGraphic()==sname.Student_data[i].s_name_A[j])
					alldata = alldata + "A" +"\n";
				else if(sname.Student_data[i].s_name_button[j].getGraphic()==sname.Student_data[i].s_name_S[j])
					alldata = alldata + "S" +"\n";
				else
					alldata = alldata + "0" +"\n";
			}	
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 4;j++) {
				alldata = alldata + sname.Student_data[i].clickcount[j] +"\n";
			}	
		}
		alldata = alldata + Teacher.teach_rate +"\n";
		if(talent_use[5]==true)
			alldata = alldata + "1" +"\n";
		else
			alldata = alldata + "0" +"\n";
		if(talent_use[6]==true)
			alldata = alldata + "1" +"\n";
		else
			alldata = alldata + "0" +"\n";
		if(talent_use[7]==true)
			alldata = alldata + "1" +"\n";
		else
			alldata = alldata + "0" +"\n";
		alldata = alldata + Teacher.test_rate +"\n";
		alldata = alldata + Teacher.test_rate_talent +"\n";
		alldata = alldata + Teacher.talk_rate +"\n";
		try {
			FileOutputStream fos = new FileOutputStream("src/Final/save/save.txt");
			fos.write(alldata.getBytes("UTF-8"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void setscene() {
		scene = new Scene(main_day,1280,720);
	}
}
