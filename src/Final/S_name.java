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

public class S_name {
	public AnchorPane S_name_pane = new AnchorPane();
	public Button student_button[] = new Button[3];
	public  static Student_data_for_sname Student_data[] = new Student_data_for_sname[3];
	public S_name() {
		Student_data[0] = new Student_data_for_sname();
		Student_data[1] = new Student_data_for_sname();
		Student_data[2] = new Student_data_for_sname();
	}
	public void set_S_name(){
		for(int i = 0;i < 3;i++) {
			img_student_normal[i] = new ImageView(day.used_student[i].img_student.getImage());
			img_student_touch[i] = new ImageView(day.used_student[i].img_student_touch.getImage());
		}
		////////////////////////////////////
		back.setGraphic(img_back_normal);
		back.setStyle("-fx-background-color: transparent");
		back.setLayoutX(1000);
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
			savesname();
			goback();
			Cancel.play();
		});
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			back.setGraphic(img_back_touch);
		});
		back.setOnMouseExited(e->{
			back.setGraphic(img_back_normal);
		});
		/////////////////////////////////////////
		Student_data[0].setdata(day.used_student[0]);
		Student_data[1].setdata(day.used_student[1]);
		Student_data[2].setdata(day.used_student[2]);
		name_background.setLayoutX(0);
		name_background.setLayoutY(0);
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
		////////////////////////////////////
		student_button[0].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
			student_button[0].setGraphic(img_student_touch[0]);
			Student_data[0].student_data_pane.setVisible(true);
			Switch.play();
		});
		student_button[0].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		student_button[1].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
			student_button[1].setGraphic(img_student_touch[1]);
			Student_data[1].student_data_pane.setVisible(true);
			Switch.play();
		});
		student_button[1].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		student_button[2].addEventHandler(MouseEvent.MOUSE_PRESSED,(MouseEvent e) -> {
			setdatapane_normal();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
			student_button[2].setGraphic(img_student_touch[2]);
			Student_data[2].student_data_pane.setVisible(true);
			Switch.play();
		});
		student_button[2].addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent e) -> {
			Choose.play();
		});
		////////////////////////////////////
		Student_data[0].change_skill[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(0,0);
			Student_data[0].checkskill();
			setonskill();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
		});
		Student_data[0].change_skill[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(0,1);
			Student_data[0].checkskill();
			setonskill();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
		});
		Student_data[0].change_skill[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(0,2);
			Student_data[0].checkskill();
			setonskill();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
		});
		Student_data[0].change_skill[3].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(0,3);
			Student_data[0].checkskill();
			setonskill();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
		});
		Student_data[1].change_skill[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(1,0);
			Student_data[1].checkskill();
			setonskill();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
		});
		Student_data[1].change_skill[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(1,1);
			Student_data[1].checkskill();
			setonskill();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
		});
		Student_data[1].change_skill[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(1,2);
			Student_data[1].checkskill();
			setonskill();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
		});
		Student_data[1].change_skill[3].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(1,3);
			Student_data[1].checkskill();
			setonskill();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
		});
		Student_data[2].change_skill[0].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(2,0);
			Student_data[2].checkskill();
			setonskill();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
		});
		Student_data[2].change_skill[1].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(2,1);
			Student_data[2].checkskill();
			setonskill();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
		});
		Student_data[2].change_skill[2].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(2,2);
			Student_data[2].checkskill();
			setonskill();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
		});
		Student_data[2].change_skill[3].addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			changeskill(2,3);
			Student_data[2].checkskill();
			setonskill();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
		});
		Student_data[0].s_name_button_0[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[0].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[4].setText(Student_data[0].allskill.C_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[5].setText(Student_data[0].allskill.C_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[6].setText(Student_data[0].allskill.C_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[7].setText(Student_data[0].allskill.C_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
		});
		Student_data[0].s_name_button_0[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[0].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[4].setText(Student_data[0].allskill.B_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[5].setText(Student_data[0].allskill.B_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[6].setText(Student_data[0].allskill.B_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[7].setText(Student_data[0].allskill.B_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
		});
		Student_data[0].s_name_button_0[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[0].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[4].setText(Student_data[0].allskill.A_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[5].setText(Student_data[0].allskill.A_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[6].setText(Student_data[0].allskill.A_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[7].setText(Student_data[0].allskill.A_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
		});
		Student_data[0].s_name_button_0[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[0].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[4].setText(Student_data[0].allskill.S_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[0].Skill[5].setText(Student_data[0].allskill.S_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[6].setText(Student_data[0].allskill.S_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
			Student_data[0].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[0].Skill[7].setText(Student_data[0].allskill.S_sname[0].getText());
				Student_data[0].checkskill();
				setonskill();
				day.used_student[0].refresh();
				Student_data[0].refresh(day.used_student[0]);
			});
		});
		//////////
		Student_data[1].s_name_button_0[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[1].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[4].setText(Student_data[1].allskill.C_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[5].setText(Student_data[1].allskill.C_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[6].setText(Student_data[1].allskill.C_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[7].setText(Student_data[1].allskill.C_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
		});
		Student_data[1].s_name_button_0[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[1].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[4].setText(Student_data[1].allskill.B_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[5].setText(Student_data[1].allskill.B_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[6].setText(Student_data[1].allskill.B_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[7].setText(Student_data[1].allskill.B_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
		});
		Student_data[1].s_name_button_0[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[1].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[4].setText(Student_data[1].allskill.A_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[5].setText(Student_data[1].allskill.A_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[6].setText(Student_data[1].allskill.A_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[7].setText(Student_data[1].allskill.A_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
		});
		Student_data[1].s_name_button_0[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[1].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[4].setText(Student_data[1].allskill.S_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[1].Skill[5].setText(Student_data[1].allskill.S_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[6].setText(Student_data[1].allskill.S_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
			Student_data[1].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[1].Skill[7].setText(Student_data[1].allskill.S_sname[0].getText());
				Student_data[1].checkskill();
				setonskill();
				day.used_student[1].refresh();
				Student_data[1].refresh(day.used_student[1]);
			});
		});
		//////////
		Student_data[2].s_name_button_0[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[2].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[4].setText(Student_data[2].allskill.C_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[5].setText(Student_data[2].allskill.C_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[6].setText(Student_data[2].allskill.C_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[7].setText(Student_data[2].allskill.C_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
		});
		Student_data[2].s_name_button_0[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[2].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[4].setText(Student_data[2].allskill.B_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[5].setText(Student_data[2].allskill.B_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[6].setText(Student_data[2].allskill.B_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[7].setText(Student_data[2].allskill.B_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
		});
		Student_data[2].s_name_button_0[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[2].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[4].setText(Student_data[2].allskill.A_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[5].setText(Student_data[2].allskill.A_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[6].setText(Student_data[2].allskill.A_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[7].setText(Student_data[2].allskill.A_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
		});
		Student_data[2].s_name_button_0[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
			Student_data[2].s_name_button[0].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[4].setText(Student_data[2].allskill.S_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[1].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
				Student_data[2].Skill[5].setText(Student_data[2].allskill.S_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[2].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[6].setText(Student_data[2].allskill.S_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
			Student_data[2].s_name_button[3].addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {					
				Student_data[2].Skill[7].setText(Student_data[2].allskill.S_sname[0].getText());
				Student_data[2].checkskill();
				setonskill();
				day.used_student[2].refresh();
				Student_data[2].refresh(day.used_student[2]);
			});
		});
		Student_data[0].reset_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
			Student_data[0].resetsname();
			setonskill();
			day.used_student[0].refresh();
			Student_data[0].refresh(day.used_student[0]);
		});
		Student_data[1].reset_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
			Student_data[1].resetsname();
			setonskill();
			day.used_student[1].refresh();
			Student_data[1].refresh(day.used_student[1]);
		});
		Student_data[2].reset_button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent a) -> {
			Student_data[2].resetsname();
			setonskill();
			day.used_student[2].refresh();
			Student_data[2].refresh(day.used_student[2]);
		});
		///////////////////////////////////
		for(int i = 0;i < 3;i++) {
			Student_data[i].student_data_pane.setLayoutX(333);
			Student_data[i].student_data_pane.setLayoutY(18);
		}
		for(int i = 0;i < 3;i++)
			Student_data[i].student_data_pane.setVisible(false);
		Student_data[0].student_data_pane.setVisible(true);
		student_button[0].setGraphic(img_student_touch[0]);
		S_name_pane.getChildren().addAll(name_background,back);
		for(int i = 0;i < 3;i++) {
			S_name_pane.getChildren().add(Student_data[i].student_data_pane);
			S_name_pane.getChildren().add(student_button[i]);
		}		
		S_name_pane.setLayoutX(-1280);
		S_name_pane.setLayoutY(0);
	}
	public void setdatapane_normal() {
		for(int i = 0;i < 3;i++) {
			Student_data[i].student_data_pane.setVisible(false);
			student_button[i].setGraphic(img_student_normal[i]);
		}
	}
	public void goback() {
		if(S_name_pane.getLayoutX()==0) {
			Timeline t = new Timeline(new KeyFrame(Duration.millis(5),(a)-> {
				S_name_pane.setLayoutX(S_name_pane.getLayoutX()-10);
			    }));
			t.setCycleCount(128);
			t.play();
		}
	}
	public void setonskill() {
		for(int i = 0;i < 3;i++) {
			day.used_student[i].plusmath = 0;
			day.used_student[i].pluslanguage = 0;
			day.used_student[i].plusprogram = 0;
			day.used_student[i].allstudentplus = 0;
			day.used_student[i].plusallrecover = 0;
			day.used_student[i].plusatknum = 0;
			day.used_student[i].pluscritdmg = 0;
			day.used_student[i].pluscritrate = 0;
			day.used_student[i].plushp = 0;
			day.used_student[i].plusselfrecover = 0;
			day.used_student[i].mathrate = 1;
			day.used_student[i].languagerate = 1;
			day.used_student[i].programrate = 1;
			day.used_student[i].mathatk = false;
			day.used_student[i].languageatk = false;
			day.used_student[i].programatk = false;
			//////////////////C
			for(int j = 0;j < 8;j++) {
				if(Student_data[i].allskill.used_sname[j][0]==true)
					day.used_student[i].plusmath = day.used_student[i].plusmath + 10;
				if(Student_data[i].allskill.used_sname[j][1]==true)
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 10;
				if(Student_data[i].allskill.used_sname[j][2]==true)
					day.used_student[i].plusprogram = day.used_student[i].plusprogram +10;
				if(Student_data[i].allskill.used_sname[j][3]==true) {
					day.used_student[i].plusmath = day.used_student[i].plusmath + 3;
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 3;
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 3;
				}
				if(Student_data[i].allskill.used_sname[j][4]==true)
					day.used_student[i].plusselfrecover = day.used_student[i].plusselfrecover + 20;
				if(Student_data[i].allskill.used_sname[j][5]==true)
					day.used_student[i].plusallrecover = day.used_student[i].plusallrecover + 5;
				////////////////B
				if(Student_data[i].allskill.used_sname[j][6]==true)
					day.used_student[i].plusmath = day.used_student[i].plusmath + 25;
				if(Student_data[i].allskill.used_sname[j][7]==true)
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 25;
				if(Student_data[i].allskill.used_sname[j][8]==true)
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 25;
				if(Student_data[i].allskill.used_sname[j][9]==true) {
					day.used_student[i].plusmath = day.used_student[i].plusmath + 10;
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 10;
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 10;
				}
				if(Student_data[i].allskill.used_sname[j][10]==true)
					day.used_student[i].plusatknum = day.used_student[i].plusatknum + 1;
				if(Student_data[i].allskill.used_sname[j][11]==true)
					day.used_student[i].mathrate = day.used_student[i].mathrate + 0.2;
				if(Student_data[i].allskill.used_sname[j][12]==true)
					day.used_student[i].languagerate = day.used_student[i].languagerate + 0.2;
				if(Student_data[i].allskill.used_sname[j][13]==true)
					day.used_student[i].programrate = day.used_student[i].programrate + 0.2;
				if(Student_data[i].allskill.used_sname[j][14]==true)
					day.used_student[i].plusselfrecover = day.used_student[i].plusselfrecover + 40;
				if(Student_data[i].allskill.used_sname[j][15]==true)
					day.used_student[i].plusallrecover = day.used_student[i].plusallrecover + 20;
				if(Student_data[i].allskill.used_sname[j][16]==true)
					day.used_student[i].pluscritrate = day.used_student[i].pluscritrate + 0.2;
				if(Student_data[i].allskill.used_sname[j][17]==true)
					day.used_student[i].pluscritdmg = day.used_student[i].pluscritdmg + 0.25;
				///////////////A
				if(Student_data[i].allskill.used_sname[j][18]==true)
					day.used_student[i].plusmath = day.used_student[i].plusmath + 50;
				if(Student_data[i].allskill.used_sname[j][19]==true)
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 50;
				if(Student_data[i].allskill.used_sname[j][20]==true)
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 50;
				if(Student_data[i].allskill.used_sname[j][21]==true) {
					day.used_student[i].plusmath = day.used_student[i].plusmath + 25;
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 25;
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 25;
				}
				if(Student_data[i].allskill.used_sname[j][22]==true)
					day.used_student[i].plusatknum = day.used_student[i].plusatknum + 2;
				if(Student_data[i].allskill.used_sname[j][23]==true)
					day.used_student[i].mathrate = day.used_student[i].mathrate + 0.4;
				if(Student_data[i].allskill.used_sname[j][24]==true)
					day.used_student[i].languagerate = day.used_student[i].languagerate + 0.4;
				if(Student_data[i].allskill.used_sname[j][25]==true)
					day.used_student[i].programrate = day.used_student[i].programrate + 0.4;
				if(Student_data[i].allskill.used_sname[j][26]==true)
					day.used_student[i].mathatk = true;
				if(Student_data[i].allskill.used_sname[j][27]==true)
					day.used_student[i].languageatk = true;
				if(Student_data[i].allskill.used_sname[j][28]==true)
					day.used_student[i].programatk = true;
				if(Student_data[i].allskill.used_sname[j][29]==true)
					day.used_student[i].plusselfrecover = day.used_student[i].plusselfrecover + 80;
				if(Student_data[i].allskill.used_sname[j][30]==true)
					day.used_student[i].plusallrecover = day.used_student[i].plusallrecover + 50;
				if(Student_data[i].allskill.used_sname[j][31]==true)
					day.used_student[i].allstudentplus = day.used_student[i].allstudentplus + 20;
				if(Student_data[i].allskill.used_sname[j][32]==true)
					day.used_student[i].pluscritrate = day.used_student[i].pluscritrate + 0.3;
				if(Student_data[i].allskill.used_sname[j][33]==true)
					day.used_student[i].pluscritdmg = day.used_student[i].pluscritdmg + 0.45;
				/////////////////S
				if(Student_data[i].allskill.used_sname[j][34]==true)
					day.used_student[i].plusmath = day.used_student[i].plusmath + 80;
				if(Student_data[i].allskill.used_sname[j][35]==true)
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 80;
				if(Student_data[i].allskill.used_sname[j][36]==true)
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 80;
				if(Student_data[i].allskill.used_sname[j][37]==true) {
					day.used_student[i].plusmath = day.used_student[i].plusmath + 50;
					day.used_student[i].pluslanguage = day.used_student[i].pluslanguage + 50;
					day.used_student[i].plusprogram = day.used_student[i].plusprogram + 50;
				}
				if(Student_data[i].allskill.used_sname[j][38]==true)
					day.used_student[i].plusatknum = day.used_student[i].plusatknum + 3;
				if(Student_data[i].allskill.used_sname[j][39]==true) {
					day.used_student[i].mathatk = true;
					day.used_student[i].languageatk = true;
					day.used_student[i].programatk = true;
				}
				if(Student_data[i].allskill.used_sname[j][40]==true)
					day.used_student[i].plusselfrecover = day.used_student[i].plusselfrecover + 150;
				if(Student_data[i].allskill.used_sname[j][41]==true)
					day.used_student[i].plusallrecover = day.used_student[i].plusallrecover + 100;
				if(Student_data[i].allskill.used_sname[j][42]==true)
					day.used_student[i].allstudentplus = day.used_student[i].allstudentplus + 40;
				if(Student_data[i].allskill.used_sname[j][43]==true)
					day.used_student[i].pluscritrate = day.used_student[i].pluscritrate + 0.5;
				if(Student_data[i].allskill.used_sname[j][44]==true)
					day.used_student[i].pluscritdmg = day.used_student[i].pluscritdmg + 0.75;
				day.used_student[i].refresh();
			}	
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 8;j++) {
				day.used_student[i].Skill[j].setText(Student_data[i].Skill[j].getText());
			}
		}
	}
	public void savesname() {
		for(int i = 0;i < 3;i++) {
			for(int j = 4;j < 8;j++) {
				day.used_student[i].Skill[j].setText(Student_data[i].Skill[j].getText());
			}
		}
	}
	public void changeskill(int i,int a) {
		if(Student_data[i].s_name_button[a].getGraphic()==Student_data[i].s_name_C[a]) {
			Student_data[i].clickcount[a] = Student_data[i].clickcount[a] + 1;
			if(Student_data[i].clickcount[a]>5)
				Student_data[i].clickcount[a] = Student_data[i].clickcount[a]%6;
			Student_data[i].Skill[a+4].setText(Student_data[i].allskill.C_sname[Student_data[i].clickcount[a]].getText());
		}
		else if(Student_data[i].s_name_button[a].getGraphic()==Student_data[i].s_name_B[a]) {
			Student_data[i].clickcount[a] = Student_data[i].clickcount[a] + 1;
			if(Student_data[i].clickcount[a]>11)
				Student_data[i].clickcount[a] = Student_data[i].clickcount[a]%12;
			Student_data[i].Skill[a+4].setText(Student_data[i].allskill.B_sname[Student_data[i].clickcount[a]].getText());
		}
		else if(Student_data[i].s_name_button[a].getGraphic()==Student_data[i].s_name_A[a]) {
			Student_data[i].clickcount[a] = Student_data[i].clickcount[a] + 1;
			if(Student_data[i].clickcount[a]>15)
				Student_data[i].clickcount[a] = Student_data[i].clickcount[a]%16;
			Student_data[i].Skill[a+4].setText(Student_data[i].allskill.A_sname[Student_data[i].clickcount[a]].getText());
		}
		else if(Student_data[i].s_name_button[a].getGraphic()==Student_data[i].s_name_S[a]) {
			Student_data[i].clickcount[a] = Student_data[i].clickcount[a] + 1;
			if(Student_data[i].clickcount[a]>10)
				Student_data[i].clickcount[a] = Student_data[i].clickcount[a]%11;
			Student_data[i].Skill[a+4].setText(Student_data[i].allskill.S_sname[Student_data[i].clickcount[a]].getText());
		}
	}
	public Button back = new Button();
	public ImageView img_student_normal[] = new ImageView[3];
	public ImageView img_student_touch[] = new ImageView[3];
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/back_normal.png")));
	public ImageView img_back_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/back_pressed.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/back_touch.png")));
	public ImageView name_background = new ImageView(new Image(getClass().getResourceAsStream("picture/S_name/s_name_background.png")));
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
}
