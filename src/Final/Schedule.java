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

public class Schedule {
	public Schedule() {	
	}
	public void setbutton() {
		for(int i = 0;i < 6;i++)
			schedule_choose[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/schedule_choose.png")));
		for(int i = 0;i < 6;i++)
			img_math_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/math.png")));
		for(int i = 0;i < 6;i++)
			img_language_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/language.png")));
		for(int i = 0;i < 6;i++)
			img_program_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/program.png")));
		for(int i = 0;i < 6;i++)
			img_rest_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/rest.png")));
		for(int i = 0;i < 6;i++)
			img_exercise_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/exercise.png")));
		for(int i = 0;i < 6;i++)
			img_talk_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/talk.png")));
		for(int i = 0;i < 6;i++)
			img_test_arr[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/test.png")));
		for(int i = 0;i < 6;i++)
			class_background[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/class.png")));
		schedule_background.setLayoutX(0);
		schedule_background.setLayoutY(0);
		////////////////////////
		for(int i = 0;i < 6;i++) {
			clss[i] = new Button();
			clss[i].setLayoutX(27);
			clss[i].setPrefSize(226,95);
			clss[i].setStyle("-fx-background-color: transparent");
			clss[i].setGraphic(class_background[i]);
		}
		clss[0].setLayoutY(38);
		clss[1].setLayoutY(135);
		clss[2].setLayoutY(229);
		clss[3].setLayoutY(378);
		clss[4].setLayoutY(475);
		clss[5].setLayoutY(576);
		//////////////////////////////////////
		reset_button.setStyle("-fx-background-color: transparent");
		reset_button.setGraphic(img_reset_normal);
		math_button.setStyle("-fx-background-color: transparent");
		math_button.setGraphic(img_math_normal);
		language_button.setStyle("-fx-background-color: transparent");
		language_button.setGraphic(img_language_normal);
		program_button.setStyle("-fx-background-color: transparent");
		program_button.setGraphic(img_program_normal);
		rest_button.setStyle("-fx-background-color: transparent");
		rest_button.setGraphic(img_rest_normal);
		exercise_button.setStyle("-fx-background-color: transparent");
		exercise_button.setGraphic(img_exercise_normal);
		talk_button.setStyle("-fx-background-color: transparent");
		talk_button.setGraphic(img_talk_normal);
		test_button.setStyle("-fx-background-color: transparent");
		test_button.setGraphic(img_test_normal);
		/////////////////////////////////
		reset_button.setLayoutX(351);
		reset_button.setLayoutY(20);
		math_button.setLayoutX(351);
		math_button.setLayoutY(80);
		language_button.setLayoutX(351);
		language_button.setLayoutY(160);
		program_button.setLayoutX(351);
		program_button.setLayoutY(240);
		rest_button.setLayoutX(351);
		rest_button.setLayoutY(320);
		exercise_button.setLayoutX(351);
		exercise_button.setLayoutY(400);
		talk_button.setLayoutX(351);
		talk_button.setLayoutY(480);
		test_button.setLayoutX(351);
		test_button.setLayoutY(560);
		/////////////////////////////////
		reset_button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			reset_button.setGraphic(img_reset_touch);
		});
		reset_button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(reset_button.getGraphic()==img_reset_touch) {
				reset_button.setGraphic(img_reset_normal);
			}
		});
		reset_button.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Choose2.play();
			resetclass();
		});
		////////////////////////////////////
		math_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(math_button.getGraphic()==img_math_normal) {
				setclassnormal();
				math_button.setGraphic(img_math_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_math_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_math_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_math_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_math_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_math_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_math_arr[5]);
					Switch.play();
				});
			}	
			else if(math_button.getGraphic()==img_math_touch) {
				math_button.setGraphic(img_math_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		language_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(language_button.getGraphic()==img_language_normal) {
				setclassnormal();
				language_button.setGraphic(img_language_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_language_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_language_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_language_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_language_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_language_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_language_arr[5]);
					Switch.play();
				});
			}	
			else if(language_button.getGraphic()==img_language_touch) {
				language_button.setGraphic(img_language_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		program_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(program_button.getGraphic()==img_program_normal) {
				setclassnormal();
				program_button.setGraphic(img_program_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_program_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_program_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_program_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_program_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_program_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_program_arr[5]);
					Switch.play();
				});
			}	
			else if(program_button.getGraphic()==img_program_touch) {
				program_button.setGraphic(img_program_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		rest_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(rest_button.getGraphic()==img_rest_normal) {
				setclassnormal();
				rest_button.setGraphic(img_rest_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_rest_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_rest_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_rest_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_rest_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_rest_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_rest_arr[5]);
					Switch.play();
				});
			}	
			else if(rest_button.getGraphic()==img_rest_touch) {
				rest_button.setGraphic(img_rest_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		exercise_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(exercise_button.getGraphic()==img_exercise_normal) {
				setclassnormal();
				exercise_button.setGraphic(img_exercise_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_exercise_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_exercise_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_exercise_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_exercise_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_exercise_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_exercise_arr[5]);
					Switch.play();
				});
			}	
			else if(exercise_button.getGraphic()==img_exercise_touch) {
				exercise_button.setGraphic(img_exercise_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		talk_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(talk_button.getGraphic()==img_talk_normal) {
				setclassnormal();
				talk_button.setGraphic(img_talk_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_talk_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_talk_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_talk_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_talk_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_talk_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_talk_arr[5]);
					Switch.play();
				});
			}	
			else if(talk_button.getGraphic()==img_talk_touch) {
				talk_button.setGraphic(img_talk_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		test_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(test_button.getGraphic()==img_test_normal) {
				setclassnormal();
				test_button.setGraphic(img_test_touch);
				clss[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[0].setGraphic(img_test_arr[0]);
					Switch.play();
				});
				clss[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[1].setGraphic(img_test_arr[1]);
					Switch.play();
				});
				clss[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[2].setGraphic(img_test_arr[2]);
					Switch.play();
				});
				clss[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[3].setGraphic(img_test_arr[3]);
					Switch.play();
				});
				clss[4].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[4].setGraphic(img_test_arr[4]);
					Switch.play();
				});
				clss[5].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clss[5].setGraphic(img_test_arr[5]);
					Switch.play();
				});
			}	
			else if(test_button.getGraphic()==img_test_touch) {
				test_button.setGraphic(img_test_normal);
			}
			Switch.play();
		});
		/////////////////////////////////
		clss[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[0].getGraphic()==class_background[0])
				clss[0].setGraphic(schedule_choose[0]);
		});
		clss[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[0].getGraphic()==schedule_choose[0])
				clss[0].setGraphic(class_background[0]);
		});
		clss[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[1].getGraphic()==class_background[1])
				clss[1].setGraphic(schedule_choose[1]);
		});
		clss[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[1].getGraphic()==schedule_choose[1])
				clss[1].setGraphic(class_background[1]);
		});
		clss[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[2].getGraphic()==class_background[2])
				clss[2].setGraphic(schedule_choose[2]);
		});
		clss[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[2].getGraphic()==schedule_choose[2])
				clss[2].setGraphic(class_background[2]);
		});
		clss[3].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[3].getGraphic()==class_background[3])
				clss[3].setGraphic(schedule_choose[3]);
		});
		clss[3].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[3].getGraphic()==schedule_choose[3])
				clss[3].setGraphic(class_background[3]);
		});
		clss[4].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[4].getGraphic()==class_background[4])
				clss[4].setGraphic(schedule_choose[4]);
		});
		clss[4].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[4].getGraphic()==schedule_choose[4])
				clss[4].setGraphic(class_background[4]);
		});
		clss[5].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(clss[5].getGraphic()==class_background[5])
				clss[5].setGraphic(schedule_choose[5]);
		});
		clss[5].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(clss[5].getGraphic()==schedule_choose[5])
				clss[5].setGraphic(class_background[5]);
		});
		////////////////////////////////
		back.setGraphic(img_back_normal);
		back.setStyle("-fx-background-color: transparent");
		back.setLayoutX(351);
		back.setLayoutY(640);
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
		////////////////////////////////
		schedule_pane.setLayoutX(1280);
		schedule_pane.setLayoutY(0);
		/////////////////////////////////
		schedule_pane.getChildren().addAll(schedule_background,reset_button,math_button,language_button,program_button,rest_button
				,exercise_button,talk_button,test_button,back);
		for(int i = 0;i < 6;i++)
			schedule_pane.getChildren().add(clss[i]);
	}
	public void goback() {
		if(schedule_pane.getLayoutX()!=1280) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(3),(a)-> {
				schedule_pane.setLayoutX(schedule_pane.getLayoutX()+4);
			    }));
			t.setCycleCount(142);
			t.play();
		}
	}
	public void goin() {
		if(schedule_pane.getLayoutX()==1280) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(3),(a)-> {
				schedule_pane.setLayoutX(schedule_pane.getLayoutX()-4);
			    }));
			t.setCycleCount(142);
			t.play();
		}
	}
	public void setclassnormal() {
		math_button.setGraphic(img_math_normal);
		language_button.setGraphic(img_language_normal);
		program_button.setGraphic(img_program_normal);
		rest_button.setGraphic(img_rest_normal);
		exercise_button.setGraphic(img_exercise_normal);
		talk_button.setGraphic(img_talk_normal);
		test_button.setGraphic(img_test_normal);
	}
	public void resetclass() {
		for(int i = 0;i < 6;i++)
			clss[i].setGraphic(class_background[i]);
	}
	double getmousex;
	double getmousey;
	public AnchorPane schedule_pane = new AnchorPane();
	public Button reset_button = new Button();
	public Button math_button = new Button();
	public Button language_button = new Button();
	public Button program_button = new Button();
	public Button rest_button = new Button();
	public Button exercise_button = new Button();
	public Button talk_button = new Button();
	public Button test_button = new Button();
	public Button clss[] = new Button[6];
	public Button back = new Button();
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public AudioClip Choose2 = new AudioClip(getClass().getResource("SE/Decision2.mp3").toString());
	public ImageView img_reset_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset.png")));
	public ImageView img_reset_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset_touch.png")));
	public ImageView img_math_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/math_button_normal.png")));
	public ImageView img_math_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/math_button_touch.png")));
	public ImageView img_language_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/language_button_normal.png")));
	public ImageView img_language_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/language_button_touch.png")));
	public ImageView img_program_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/program_button_normal.png")));
	public ImageView img_program_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/program_button_touch.png")));
	public ImageView img_rest_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/rest_button_normal.png")));
	public ImageView img_rest_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/rest_button_touch.png")));
	public ImageView img_exercise_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/exercise_button_normal.png")));
	public ImageView img_exercise_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/exercise_button_touch.png")));
	public ImageView img_talk_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/talk_button_normal.png")));
	public ImageView img_talk_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/talk_button_touch.png")));
	public ImageView img_test_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/test_button_normal.png")));
	public ImageView img_test_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/test_button_touch.png")));
	public ImageView schedule_background = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/schedule_background.png")));
	public ImageView schedule_choose[] = new ImageView[6];
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/back_normal.png")));
	public ImageView img_back_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/back_pressed.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/back_touch.png")));
	///////////////////////////////////////
	public ImageView class_background[] = new ImageView[6];
	public ImageView img_math_arr[] = new ImageView[6];
	public ImageView img_language_arr[] = new ImageView[6];
	public ImageView img_program_arr[] = new ImageView[6];
	public ImageView img_rest_arr[] = new ImageView[6];
	public ImageView img_exercise_arr[] = new ImageView[6];
	public ImageView img_talk_arr[] = new ImageView[6];
	public ImageView img_test_arr[] = new ImageView[6];
}
