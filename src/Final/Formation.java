package Final;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

public class Formation {
	public Scene scene;
	public static int order[] = new int[3];
	public AnchorPane pane = new AnchorPane();
	public Button choosef[] = new Button[3];
	public Button chooses[] = new Button[3];
	public Button start = new Button();
	public Button reset = new Button();
	public Text choose = new Text("½Ð¿ï¾Ü°}«¬"+"\n");
	public ImageView frame[] = new ImageView[3];
	public Image iframe[] = new Image[3];
	public ImageView choose_normal[] = new ImageView[3];
	public Image ichoose_normal[] = new Image[3];
	public ImageView choose_touch[] = new ImageView[3];
	public Image ichoose_touch[] = new Image[3];
	public boolean student_used[] = new boolean[3];
	public Formation() {
	}
	public void setFormation(ImageView s1,ImageView s2,ImageView s3,ImageView s1_1,ImageView s2_1,ImageView s3_1) {
		for(int i = 0;i < 3;i++) {
			student_used[i] = false;
			iframe[i] = new Image(getClass().getResourceAsStream("picture/Formation/chooese_student_frame.png"));
			frame[i] = new ImageView(iframe[i]);
			ichoose_normal[i] = new Image(getClass().getResourceAsStream("picture/Formation/chooese_student_normal.png"));
			ichoose_touch[i] = new Image(getClass().getResourceAsStream("picture/Formation/chooese_student_touch.png"));
			choose_normal[i] = new ImageView(ichoose_normal[i]);
			choose_touch[i] = new ImageView(ichoose_touch[i]);
			choosef[i] = new Button();
			chooses[i] = new Button();
			order[i] = i;
			choose_0[i] = new ImageView(s1.getImage());
			choose_0[i].setFitHeight(226);
			choose_0[i].setFitWidth(180);
			choose_1[i] = new ImageView(s2.getImage());
			choose_1[i].setFitHeight(226);
			choose_1[i].setFitWidth(180);
			choose_2[i] = new ImageView(s3.getImage());
			choose_2[i].setFitHeight(226);
			choose_2[i].setFitWidth(180);
			choosef[i].setStyle("-fx-background-color: transparent");
			chooses[i].setStyle("-fx-background-color: transparent");
		}
		reset.setStyle("-fx-background-color: transparent");
		reset.setLayoutX(100);
		reset.setLayoutY(350);
		reset.setGraphic(img_reset_normal);
		start.setGraphic(img_start_normal);
		start.setLayoutX(579);
		start.setStyle("-fx-background-color: transparent");
		start.setLayoutY(650);
		choose_s[0] = new ImageView(s1.getImage());
		choose_s[1] = new ImageView(s2.getImage());
		choose_s[2] = new ImageView(s3.getImage());
		choose_s_touch[0] = new ImageView(s1_1.getImage());
		choose_s_touch[1] = new ImageView(s2_1.getImage());
		choose_s_touch[2] = new ImageView(s3_1.getImage());
		for(int i = 0;i < 3;i++) {
			choosef[i].setGraphic(choose_normal[i]);
			chooses[i].setGraphic(choose_s[i]);
		}
		background.setLayoutX(0);
		background.setLayoutY(0);
		choose.setStyle("-fx-font-size: 40px;");
		choose.setLayoutX(570);
		choose.setLayoutY(300);
		frame[0].setLayoutX(270);
		frame[1].setLayoutX(579);
		frame[2].setLayoutX(888);
		frame[0].setLayoutY(386);
		frame[1].setLayoutY(386);
		frame[2].setLayoutY(386);
		choosef[0].setLayoutX(264);
		choosef[1].setLayoutX(573);
		choosef[2].setLayoutX(882);
		choosef[0].setLayoutY(386);
		choosef[1].setLayoutY(386);
		choosef[2].setLayoutY(386);
		chooses[0].setLayoutX(270);
		chooses[0].setLayoutY(20);
		chooses[1].setLayoutX(579);
		chooses[1].setLayoutY(20);
		chooses[2].setLayoutX(888);
		chooses[2].setLayoutY(20);
		//////////////////////////////////
		start.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
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
		//////////////////////////////////
		reset.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			reset.setGraphic(img_reset_touch);
			Choose.play();
		});
		reset.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			reset.setGraphic(img_reset_normal);
		});
		reset.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Click.play();
			resetF();
		});
		/////////////////////////////////
		chooses[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			setsnormal();
			chooses[0].setGraphic(choose_s_touch[0]);
			Switch.play();
			choosef[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[0]==false&&chooses[0].getGraphic()==choose_s_touch[0]) {
					choosef[0].setGraphic(choose_0[0]);
					chooses[0].setVisible(false);
					student_used[0]=true;
					Switch.play();
				}
			});
			choosef[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[0]==false&&chooses[0].getGraphic()==choose_s_touch[0]) {
					choosef[1].setGraphic(choose_0[1]);
					chooses[0].setVisible(false);
					student_used[0]=true;
					Switch.play();
				}
			});
			choosef[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[0]==false&&chooses[0].getGraphic()==choose_s_touch[0]) {
					choosef[2].setGraphic(choose_0[2]);
					chooses[0].setVisible(false);
					student_used[0]=true;
					Switch.play();
				}
			});
		});
		chooses[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			setsnormal();
			chooses[1].setGraphic(choose_s_touch[1]);
			Switch.play();
			choosef[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[1]==false&&chooses[1].getGraphic()==choose_s_touch[1]) {
					choosef[0].setGraphic(choose_1[0]);
					chooses[1].setVisible(false);
					student_used[1]=true;
					Switch.play();
				}
			});
			choosef[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[1]==false&&chooses[1].getGraphic()==choose_s_touch[1]) {
					choosef[1].setGraphic(choose_1[1]);
					chooses[1].setVisible(false);
					student_used[1]=true;
					Switch.play();
				}
			});
			choosef[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[1]==false&&chooses[1].getGraphic()==choose_s_touch[1]) {
					choosef[2].setGraphic(choose_1[2]);
					chooses[1].setVisible(false);
					student_used[1]=true;
					Switch.play();
				}
			});
		});
		chooses[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			setsnormal();
			chooses[2].setGraphic(choose_s_touch[2]);
			Switch.play();
			choosef[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[2]==false&&chooses[2].getGraphic()==choose_s_touch[2]) {
					choosef[0].setGraphic(choose_2[0]);
					chooses[2].setVisible(false);
					student_used[2]=true;
					Switch.play();
				}
			});
			choosef[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[2]==false&&chooses[2].getGraphic()==choose_s_touch[2]) {
					choosef[1].setGraphic(choose_2[1]);
					chooses[2].setVisible(false);
					student_used[2]=true;
					Switch.play();
				}
			});
			choosef[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				if(student_used[2]==false&&chooses[2].getGraphic()==choose_s_touch[2]) {
					choosef[2].setGraphic(choose_2[2]);
					chooses[2].setVisible(false);
					student_used[2]=true;
					Switch.play();
				}
			});
		});
		choosef[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(choosef[0].getGraphic()==choose_normal[0])
				choosef[0].setGraphic(choose_touch[0]);
		});
		choosef[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(choosef[0].getGraphic()==choose_touch[0])
				choosef[0].setGraphic(choose_normal[0]);
		});
		choosef[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(choosef[1].getGraphic()==choose_normal[1])
				choosef[1].setGraphic(choose_touch[1]);
		});
		choosef[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(choosef[1].getGraphic()==choose_touch[1])
				choosef[1].setGraphic(choose_normal[1]);
		});
		choosef[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(choosef[2].getGraphic()==choose_normal[2])
				choosef[2].setGraphic(choose_touch[2]);
		});
		choosef[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(choosef[2].getGraphic()==choose_touch[2])
				choosef[2].setGraphic(choose_normal[2]);
		});
		/////////////////////////
		pane.getChildren().addAll(background,choose,start,reset);
		for(int i = 0;i < 3;i++)
			pane.getChildren().addAll(frame[i],choosef[i],chooses[i]);
		scene = new Scene(pane,1280,720);
	}
	public void startaction() {
		for(int i = 0;i < 3;i++) {
			if(choosef[i].getGraphic()==choose_0[i])
				order[i] = 0;
			else if(choosef[i].getGraphic()==choose_1[i])
				order[i] = 1;
			else if(choosef[i].getGraphic()==choose_2[i])
				order[i] = 2;
		}
	}
	public void setsnormal() {
		for(int i = 0;i < 3;i++)
			chooses[i].setGraphic(choose_s[i]);
	}
	public void resetF() {
		for(int i = 0;i < 3;i++) {
			choosef[i].setGraphic(choose_normal[i]);
			chooses[i].setGraphic(choose_s[i]);
			chooses[i].setVisible(true);
			student_used[i] = false;
		}	
	}
	public ImageView img_reset_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset.png")));
	public ImageView img_reset_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset_touch.png")));
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/exam/exam.png")));
	public AudioClip Error = new AudioClip(getClass().getResource("SE/Buzzer1.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public ImageView choose_s[] = new ImageView[3];
	public ImageView choose_s_touch[] = new ImageView[3];
	public ImageView choose_0[] = new ImageView[3];
	public ImageView choose_1[] = new ImageView[3];
	public ImageView choose_2[] = new ImageView[3];
	public ImageView img_start_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/started_normal.png")));
	public ImageView img_start_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/started_pressed.png")));
	public ImageView img_start_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/started_touch.png")));
}
