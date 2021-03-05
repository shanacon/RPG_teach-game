package Final;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

public class Student_data_for_sname {
	public AnchorPane student_data_pane = new AnchorPane();
	public Text hp_text = new Text();
	public Text math_text = new Text();
	public Text language_text = new Text();
	public Text program_text = new Text();
	public Text Skill[] = new Text[8];
	public Skill allskill = new Skill();
	public int clickcount[] = new int[4];
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/student_data.png")));
	public Student_data_for_sname(){
	}
	public void setdata(Student student) {
		reset_button.setLayoutX(71);
		reset_button.setLayoutY(170);
		reset_button.setStyle("-fx-background-color: transparent");
		reset_button.setGraphic(img_reset_normal);
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
		});
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
		allskill.setskill();
		for(int i = 0;i < 4;i++) {
			s_name_C[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/C_normal.png")));
			s_name_B[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/B_normal.png")));
			s_name_A[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/A_normal.png")));
			s_name_S[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/S_normal.png")));
			name_back[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/s_name_back.png")));
			name_back_1[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/s_name_back_1.png")));
			change_normal[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/change_normal.png")));
			change_touch[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/change_touch.png")));
			change_skill[i] = new Button();
			s_name_button[i] = new Button();
			s_name_button_0[i] = new Button();
		}
		for(int i = 0;i < 4;i++) {
			s_name_button[i].setLayoutY(238);
			s_name_button_0[i].setLayoutY(38);
			s_name_button[i].setGraphic(name_back_1[i]);
			s_name_button_0[i].setStyle("-fx-background-color: transparent");
			s_name_button[i].setStyle("-fx-background-color: transparent");
			change_skill[i].setGraphic(change_normal[i]);
			change_skill[i].setStyle("-fx-background-color: transparent");
		}
		s_name_button_0[0].setGraphic(img_C_normal);
		s_name_button_0[1].setGraphic(img_B_normal);
		s_name_button_0[2].setGraphic(img_A_normal);
		s_name_button_0[3].setGraphic(img_S_normal);
		s_name_button_0[0].setLayoutX(71);
		s_name_button_0[1].setLayoutX(237);
		s_name_button_0[2].setLayoutX(400);
		s_name_button_0[3].setLayoutX(562);
		s_name_button[0].setLayoutX(71);
		s_name_button[1].setLayoutX(237);
		s_name_button[2].setLayoutX(400);
		s_name_button[3].setLayoutX(562);
		s_name_button_0[1].setVisible(false);
		s_name_button_0[2].setVisible(false);
		s_name_button_0[3].setVisible(false);
		//////////////////////////////
		for(int i = 0;i<4;i++) {
			clickcount[i] = 0;
		}
		change_skill[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			change_skill[0].setGraphic(change_touch[0]);
		});
		change_skill[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			change_skill[0].setGraphic(change_normal[0]);
		});
		change_skill[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Switch.play();
		});
		change_skill[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			change_skill[1].setGraphic(change_touch[1]);
		});
		change_skill[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			change_skill[1].setGraphic(change_normal[1]);
		});
		change_skill[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Switch.play();
		});
		change_skill[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			change_skill[2].setGraphic(change_touch[2]);
		});
		change_skill[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			change_skill[2].setGraphic(change_normal[2]);
		});
		change_skill[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Switch.play();
		});
		change_skill[3].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			change_skill[3].setGraphic(change_touch[3]);
		});
		change_skill[3].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			change_skill[3].setGraphic(change_normal[3]);
		});
		change_skill[3].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			Switch.play();
		});
		//////////////////////////////
		s_name_button_0[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(s_name_button_0[0].getGraphic()==img_C_normal) {
				setsnamenormal();
				s_name_button_0[0].setGraphic(img_C_choose);
				s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clickcount[0] = 0;
					s_name_button[0].setGraphic(s_name_C[0]);
					Switch.play();
				});
				s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
					clickcount[1] = 0;
					s_name_button[1].setGraphic(s_name_C[1]);
					Switch.play();
				});
				s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[2] = 0;
					s_name_button[2].setGraphic(s_name_C[2]);
					Switch.play();
				});
				s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[3] = 0;
					s_name_button[3].setGraphic(s_name_C[3]);
					Switch.play();
				});
				}
			Switch.play();
		});
		s_name_button_0[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(s_name_button_0[1].getGraphic()==img_B_normal) {
				setsnamenormal();
				s_name_button_0[1].setGraphic(img_B_choose);
				s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[0] = 0;
					s_name_button[0].setGraphic(s_name_B[0]);
					Switch.play();
				});
				s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[1] = 0;
					s_name_button[1].setGraphic(s_name_B[1]);
					Switch.play();
				});
				s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[2] = 0;
					s_name_button[2].setGraphic(s_name_B[2]);
					Switch.play();
				});
				s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[3] = 0;
					s_name_button[3].setGraphic(s_name_B[3]);
					Switch.play();
				});
				}
			Switch.play();
		});
		s_name_button_0[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(s_name_button_0[2].getGraphic()==img_A_normal) {
				setsnamenormal();
				s_name_button_0[2].setGraphic(img_A_choose);
				s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[0] = 0;
					s_name_button[0].setGraphic(s_name_A[0]);
					Switch.play();
				});
				s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[1] = 0;
					s_name_button[1].setGraphic(s_name_A[1]);
					Switch.play();
				});
				s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[2] = 0;
					s_name_button[2].setGraphic(s_name_A[2]);
					Switch.play();
				});
				s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[3] = 0;
					s_name_button[3].setGraphic(s_name_A[3]);
					Switch.play();
				});
				}
			Switch.play();
		});
		s_name_button_0[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			if(s_name_button_0[3].getGraphic()==img_S_normal) {
				setsnamenormal();
				s_name_button_0[3].setGraphic(img_S_choose);
				s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[0] = 0;
					s_name_button[0].setGraphic(s_name_S[0]);
					Switch.play();
				});
				s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[1] = 0;
					s_name_button[1].setGraphic(s_name_S[1]);
					Switch.play();
				});
				s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[2] = 0;
					s_name_button[2].setGraphic(s_name_S[2]);
					Switch.play();
				});
				s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
					clickcount[3] = 0;
					s_name_button[3].setGraphic(s_name_S[3]);
					Switch.play();
				});
				}
			Switch.play();
		});
		//////////////////////////
		s_name_button[0].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(s_name_button[0].getGraphic()==name_back_1[0])
				s_name_button[0].setGraphic(name_back[0]);
		});
		s_name_button[0].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(s_name_button[0].getGraphic()==name_back[0])
				s_name_button[0].setGraphic(name_back_1[0]);
		});
		s_name_button[1].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(s_name_button[1].getGraphic()==name_back_1[1])
				s_name_button[1].setGraphic(name_back[1]);
		});
		s_name_button[1].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(s_name_button[1].getGraphic()==name_back[1])
				s_name_button[1].setGraphic(name_back_1[1]);
		});
		s_name_button[2].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(s_name_button[2].getGraphic()==name_back_1[2])
				s_name_button[2].setGraphic(name_back[2]);
		});
		s_name_button[2].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(s_name_button[2].getGraphic()==name_back[2])
				s_name_button[2].setGraphic(name_back_1[2]);
		});
		s_name_button[3].addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent a) -> {
			if(s_name_button[3].getGraphic()==name_back_1[3])
				s_name_button[3].setGraphic(name_back[3]);
		});
		s_name_button[3].addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent a) -> {
			if(s_name_button[3].getGraphic()==name_back[3])
				s_name_button[3].setGraphic(name_back_1[3]);
		});
		//////////////////////////////
		background.setLayoutX(0);
		background.setLayoutY(0);
		hp_text.setLayoutX(121);
		hp_text.setLayoutY(451);
		hp_text.setStyle("-fx-font-size: 28px;");
		math_text.setLayoutX(121);
		math_text.setLayoutY(500);
		math_text.setStyle("-fx-font-size: 28px;");
		language_text.setLayoutX(121);
		language_text.setLayoutY(547);
		language_text.setStyle("-fx-font-size: 28px;");
		program_text.setLayoutX(121);
		program_text.setLayoutY(595);
		program_text.setStyle("-fx-font-size: 28px;");
		Skill[0].setLayoutX(300);
		Skill[0].setLayoutY(451);
		Skill[1].setLayoutX(300);
		Skill[1].setLayoutY(500);
		Skill[2].setLayoutX(300);
		Skill[2].setLayoutY(547);
		Skill[3].setLayoutX(300);
		Skill[3].setLayoutY(595);
		Skill[4].setLayoutX(485);
		Skill[4].setLayoutY(451);
		Skill[5].setLayoutX(485);
		Skill[5].setLayoutY(500);
		Skill[6].setLayoutX(485);
		Skill[6].setLayoutY(547);
		Skill[7].setLayoutX(485);
		Skill[7].setLayoutY(595);
		change_skill[0].setLayoutX(476);
		change_skill[0].setLayoutY(424);
		change_skill[1].setLayoutX(476);
		change_skill[1].setLayoutY(473);
		change_skill[2].setLayoutX(476);
		change_skill[2].setLayoutY(520);
		change_skill[3].setLayoutX(476);
		change_skill[3].setLayoutY(568);
		student_data_pane.getChildren().addAll(background,hp_text,math_text,language_text,program_text,reset_button);
		for(int i=0;i<8;i++)
			student_data_pane.getChildren().add(Skill[i]);
		for(int i=0;i<4;i++) {
			student_data_pane.getChildren().add(s_name_button_0[i]);
			student_data_pane.getChildren().add(s_name_button[i]);
			student_data_pane.getChildren().add(change_skill[i]);
		}
	}
	public void setsnamenormal() {
		s_name_button_0[0].setGraphic(img_C_normal);
		s_name_button_0[1].setGraphic(img_B_normal);
		s_name_button_0[2].setGraphic(img_A_normal);
		s_name_button_0[3].setGraphic(img_S_normal);
	}
	public void resetsname() {
		for(int i = 0;i < 4;i++) {
			s_name_button[i].setGraphic(name_back_1[i]);
			Skill[i+4].setText("--------------");
		}
		checkskill();
	}
	public void refresh(Student student) {
		this.hp_text.setText(student.hp_text.getText());
		this.math_text.setText(student.math_text.getText());
		this.language_text.setText(student.language_text.getText());
		this.program_text.setText(student.program_text.getText());
		for(int i = 0;i < 8;i++)
			this.Skill[i].setText(student.Skill[i].getText());
	} 
	public void checkskill() {
		for(int j = 4;j < 8;j++) {
			for(int i = 0;i < 45;i++) {
				allskill.used_sname[j][i] = false;
			}
		}
		for(int j = 0;j < 8;j++) {
			for(int k = 0;k < 6;k++){
				if(Skill[j].getText().equals(allskill.C_sname[k].getText())==true) {
					allskill.used_sname[j][k] = true;
					break;
				}
			}
			for(int k = 0;k < 12;k++){
				if(Skill[j].getText().equals(allskill.B_sname[k].getText())==true) {
					allskill.used_sname[j][k+6] = true;
					break;
				}
					
			}
			for(int k = 0;k < 16;k++){
				if(Skill[j].getText().equals(allskill.A_sname[k].getText())==true) {
					allskill.used_sname[j][k+18] = true;
					break;
				}
					
			}
			for(int k = 0;k < 11;k++){
				if(Skill[j].getText().equals(allskill.S_sname[k].getText())==true) {
					allskill.used_sname[j][k+34] = true;
					break;
				}
			}
		}	
	}
	public Button s_name_button_0[] = new Button[4];
	public Button s_name_button[] = new Button[4];
	public Button change_skill[] = new Button[4];
	public Button reset_button = new Button();
	public ImageView s_name_C[] = new ImageView[4];
	public ImageView s_name_B[] = new ImageView[4];
	public ImageView s_name_A[] = new ImageView[4];
	public ImageView s_name_S[] = new ImageView[4];
	public ImageView change_normal[] = new ImageView[4];
	public ImageView change_touch[] = new ImageView[4];
	public AudioClip Choose2 = new AudioClip(getClass().getResource("SE/Decision2.mp3").toString());
	public ImageView img_reset_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset.png")));
	public ImageView img_reset_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/schedule/reset_touch.png")));
	public ImageView img_C_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/C_normal.png")));
	public ImageView img_C_choose = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/C_choose.png")));
	public ImageView img_B_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/B_normal.png")));
	public ImageView img_B_choose = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/B_choose.png")));
	public ImageView img_A_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/A_normal.png")));
	public ImageView img_A_choose = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/A_choose.png")));
	public ImageView img_S_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/S_normal.png")));
	public ImageView img_S_choose = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/S_choose.png")));
	public ImageView name_back[] = new ImageView[4];
	public ImageView name_back_1[] = new ImageView[4];
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
}
