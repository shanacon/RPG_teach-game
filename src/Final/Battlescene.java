package Final;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Battlescene {
	public int clickcount = 0;
	public AnchorPane battlepane = new AnchorPane();
	public AnchorPane enemypane = new AnchorPane();
	public AnchorPane studentpane = new AnchorPane();
	public Text student_skill[][] = new Text[3][8];
	public AnchorPane student_skillpane[] = new AnchorPane[3];
	public Text enemy_skill[][] = new Text[3][4];
	public AnchorPane enemy_skillpane[] = new AnchorPane[3];
	public Scene battlescene;
	public int round = 5;
	public Text round_text = new Text();
	public ImageView studentskill_background[] = new ImageView[3];
	public Image istudentskill_background[] = new Image[3];
	public ImageView enemyskill_background[] = new ImageView[3];
	public Image ienemyskill_background[] = new Image[3];
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/exam/exam.png")));
	public ImageView img_enemy_background = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/enemy_pane_back.png")));
	public ImageView img_student_background = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/enemy_pane_back.png")));
	public ImageView img_fight_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/fight_normal.png")));
	public ImageView img_fight_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/fight_touch.png")));
	public ImageView img_atk_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/mode_atk_normal.png")));
	public ImageView img_atk_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/mode_atk_touch.png")));
	public ImageView img_next_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/next_normal.png")));
	public ImageView img_next_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/next_touch.png")));
	public ImageView img_def_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/mode_def_normal.png")));
	public ImageView img_def_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/mode_def_touch.png")));
	public int score;
	public Battle_Student_data student[] = new Battle_Student_data[3];
	public Battle_enemy_data enemy[] = new Battle_enemy_data[3];
	public Button fight = new Button();
	public Button mode = new Button();
	public Button next = new Button();
	public Button enygetatk = new Button();
	public Button stdgetatk = new Button();
	public int atknum = 0;
	public double modeatkrate = 1.2;
	public double modedefrate = 1;
	/////////////////////////////////////////////////
	public ImageView img_enemy[] = new ImageView[3];
	public ImageView img_student[] = new ImageView[3];
	public ImageView img_enemy_focus[] = new ImageView[3];
	public ImageView img_student_focus[] = new ImageView[3];
	////////////////////////////////////////////////
	public Battlescene() {
	}
	public Battlescene(NumberBinding maxhp1,int subject1,NumberBinding atk1,int atknum1,int selfrecover1,int allrecover1,double critrate1,double critdmg1
			,boolean allatk1,String skill1_1,String skill1_2,String skill1_3,String skill1_4,String name1,
			NumberBinding maxhp2,int subject2,NumberBinding atk2,int atknum2,int selfrecover2,int allrecover2,double critrate2,double critdmg2,boolean allatk2,
			String skill2_1,String skill2_2,String skill2_3,String skill2_4,String name2,
			NumberBinding maxhp3,int subject3,NumberBinding atk3,int atknum3,int selfrecover3,int allrecover3,double critrate3,double critdmg3,boolean allatk3,
			String skill3_1,String skill3_2,String skill3_3,String skill3_4,String name3) {
		for(int i = 0;i <3;i++) {
			enemy[i] = new Battle_enemy_data();
			student[i] = new Battle_Student_data();
			img_enemy[i] = new ImageView();
			img_student[i] = new ImageView();
			img_enemy_focus[i] = new ImageView();
			img_student_focus[i] = new ImageView();
		}
		enemy[0] = new Battle_enemy_data(maxhp1,subject1,atk1,atknum1,selfrecover1,allrecover1,critrate1,critdmg1,allatk1,skill1_1,skill1_2,skill1_3,skill1_4,name1);
		enemy[1] = new Battle_enemy_data(maxhp2,subject2,atk2,atknum2,selfrecover2,allrecover2,critrate2,critdmg2,allatk2,skill2_1,skill2_2,skill2_3,skill2_4,name2);
		enemy[2] = new Battle_enemy_data(maxhp3,subject3,atk3,atknum3,selfrecover3,allrecover3,critrate3,critdmg3,allatk3,skill3_1,skill3_2,skill3_3,skill3_4,name3);
		for(int i = 0;i <3;i++) {
			img_enemy[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/exam.png")));
			img_enemy_focus[i] = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/exam.png")));
			img_enemy_focus[i].setFitHeight(284);
			img_enemy_focus[i].setFitWidth(243);
		}
		for(int i = 0;i < 3;i++)
			istudentskill_background[i] = new Image(getClass().getResourceAsStream("picture/battle/student_skillpane.png"));
		for(int i = 0;i < 3;i++)
			studentskill_background[i] = new ImageView(istudentskill_background[i]);
		for(int i = 0;i < 3;i++)
			ienemyskill_background[i] = new Image(getClass().getResourceAsStream("picture/battle/enemy_skillpane.png"));
		for(int i = 0;i < 3;i++)
			enemyskill_background[i] = new ImageView(ienemyskill_background[i]);
	}
	public void setBattle() {
		for(int i = 0;i <3;i++)
			student[i] = new Battle_Student_data(day.used_student[Formation.order[i]]);
		for(int i = 0;i <3;i++) {
			img_student[i] = new ImageView(day.used_student[Formation.order[i]].img_student.getImage());
			img_student_focus[i] = new ImageView(day.used_student[Formation.order[i]].img_student.getImage());
			img_student_focus[i].setFitHeight(284);
			img_student_focus[i].setFitWidth(243);
			student_skillpane[i] = new AnchorPane();
			enemy_skillpane[i] = new AnchorPane();
			student_skillpane[i].setVisible(false);
			enemy_skillpane[i].setVisible(false);
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 8;j++) {
				student_skill[i][j] = new Text();
				student_skill[i][j].setText(day.used_student[Formation.order[i]].Skill[j].getText());
				student_skill[i][j].setStyle("-fx-font-size: 24px;");
			}
		}
		for(int i = 0;i < 3;i++) {
			for(int j = 0;j < 4;j++) {
				enemy_skill[i][j] = new Text();
				enemy_skill[i][j].setStyle("-fx-font-size: 24px;");
				enemy_skill[i][j].setText(enemy[i].skill[j].getText());
			}
			studentskill_background[i].setLayoutX(0);
			studentskill_background[i].setLayoutY(0);
			enemyskill_background[i].setLayoutX(0);
			enemyskill_background[i].setLayoutY(0);
		}
		for(int i = 0;i < 3;i++) {
			student_skill[i][0].setLayoutX(17);
			student_skill[i][0].setLayoutY(40);
			student_skill[i][1].setLayoutX(17);
			student_skill[i][1].setLayoutY(75);
			student_skill[i][2].setLayoutX(17);
			student_skill[i][2].setLayoutY(110);
			student_skill[i][3].setLayoutX(17);
			student_skill[i][3].setLayoutY(145);
			student_skill[i][4].setLayoutX(17);
			student_skill[i][4].setLayoutY(180);
			student_skill[i][5].setLayoutX(17);
			student_skill[i][5].setLayoutY(215);
			student_skill[i][6].setLayoutX(17);
			student_skill[i][6].setLayoutY(250);
			student_skill[i][7].setLayoutX(17);
			student_skill[i][7].setLayoutY(285);
			enemy_skill[i][0].setLayoutX(17);
			enemy_skill[i][0].setLayoutY(45);
			enemy_skill[i][1].setLayoutX(17);
			enemy_skill[i][1].setLayoutY(80);
			enemy_skill[i][2].setLayoutX(17);
			enemy_skill[i][2].setLayoutY(115);
			enemy_skill[i][3].setLayoutX(17);
			enemy_skill[i][3].setLayoutY(150);
			student_skillpane[i].setLayoutY(93);
			enemy_skillpane[i].setLayoutY(220);
		}
		enemy_skillpane[0].setLayoutX(0);
		enemy_skillpane[1].setLayoutX(152);
		enemy_skillpane[2].setLayoutX(302);
		student_skillpane[0].setLayoutX(828);
		student_skillpane[1].setLayoutX(980);
		student_skillpane[2].setLayoutX(1095);
		for(int i = 0;i < 3;i++) {
			student_skillpane[i].getChildren().add(studentskill_background[i]);
			enemy_skillpane[i].getChildren().add(enemyskill_background[i]);
			for(int j = 0;j < 8;j++)
				student_skillpane[i].getChildren().add(student_skill[i][j]);
			for(int j = 0;j < 4;j++)
				enemy_skillpane[i].getChildren().add(enemy_skill[i][j]);
		}
		round_text.setLayoutX(500);
		round_text.setLayoutY(50);
		round_text.setText("剩餘回合數："+round);
		round_text.setStyle("-fx-font-size: 35px;");
		for(int i = 0;i < 6;i++)
			iatk[i] = new Image(getClass().getResourceAsStream("picture/battle/atk_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 6;i++)
			atk[i] = new ImageView(iatk[i]);
		for(int i = 0;i < 6;i++)
			iatk1[i] = new Image(getClass().getResourceAsStream("picture/battle/atk_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 6;i++)
			atk1[i] = new ImageView(iatk[i]);
		enygetatk.setLayoutX(100);
		enygetatk.setLayoutY(100);
		stdgetatk.setLayoutX(950);
		stdgetatk.setLayoutY(100);
		enygetatk.setGraphic(atk[5]);
		stdgetatk.setGraphic(atk1[5]);
		enygetatk.setStyle("-fx-background-color: transparent");
		stdgetatk.setStyle("-fx-background-color: transparent");
		atkact.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {enygetatk.setGraphic(atk[0]);})
				,new KeyFrame(new Duration(50),(a)-> {enygetatk.setGraphic(atk[1]);})
				,new KeyFrame(new Duration(100),(a)-> {enygetatk.setGraphic(atk[2]);})
				,new KeyFrame(new Duration(150),(a)-> {enygetatk.setGraphic(atk[3]);})
				,new KeyFrame(new Duration(200),(a)-> {enygetatk.setGraphic(atk[4]);})
				,new KeyFrame(new Duration(250),(a)-> {enygetatk.setGraphic(atk[5]);})
				);
		atkact1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO,(a)-> {stdgetatk.setGraphic(atk1[0]);})
				,new KeyFrame(new Duration(50),(a)-> {stdgetatk.setGraphic(atk1[1]);})
				,new KeyFrame(new Duration(100),(a)-> {stdgetatk.setGraphic(atk1[2]);})
				,new KeyFrame(new Duration(150),(a)-> {stdgetatk.setGraphic(atk1[3]);})
				,new KeyFrame(new Duration(200),(a)-> {stdgetatk.setGraphic(atk1[4]);})
				,new KeyFrame(new Duration(250),(a)-> {stdgetatk.setGraphic(atk1[5]);})
				);
		background.setLayoutX(0);
		background.setLayoutY(0);
		next.setLayoutX(515);
		next.setLayoutY(524);
		next.setVisible(false);
		for(int i = 0;i <3;i++) {
			enemy[i].pane.setLayoutY(394);
			student[i].pane.setLayoutY(394);
			student[i].refreshdata(day.used_student[Formation.order[i]]);
		}
		for(int i = 0;i <3;i++) {
			for(int j = 0;j <3;j++) {
				student[j].math = student[j].math + student[i].allstudentplus;
				student[j].language = student[j].language + student[i].allstudentplus;
				student[j].program = student[j].program + student[i].allstudentplus;
			}
		}
		for(int i = 0;i <3;i++) {
			enemy[i].setbattledata();
			student[i].setbattledata();
		}
		enemy[0].pane.setLayoutX(0);
		enemy[1].pane.setLayoutX(152);
		enemy[2].pane.setLayoutX(304);
		student[0].pane.setLayoutX(828);
		student[1].pane.setLayoutX(980);
		student[2].pane.setLayoutX(1132);
		fight.setLayoutX(515);
		fight.setLayoutY(524);
		mode.setLayoutX(515);
		mode.setLayoutY(615);
		fight.setStyle("-fx-background-color: transparent");
		fight.setGraphic(img_fight_normal);
		mode.setStyle("-fx-background-color: transparent");
		mode.setGraphic(img_atk_normal);
		next.setGraphic(img_next_normal);
		next.setStyle("-fx-background-color: transparent");
		next.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			next.setGraphic(img_next_touch);
		});
		next.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			next.setGraphic(img_next_normal);
		});
		next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(clickcount<3) {
				atkeny(clickcount);
				clickcount++;
			}	
			else if(clickcount<6) {
				atksdt(clickcount-3);
				clickcount++;
			}
			else {
				next.setVisible(false);
				fight.setVisible(true);
				mode.setVisible(true);
				recover();
				clickcount = 0;
				score = (int)(student[0].hp + student[1].hp + student[2].hp+
						(enemy[0].maxhp.intValue()-enemy[0].hp)+(enemy[1].maxhp.intValue()-enemy[1].hp)+(enemy[2].maxhp.intValue()-enemy[2].hp)*(0.5+round*0.1));
				round--;
				round_text.setText("剩餘回合數："+round);
				refresh();
			}
		});
		fight.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			fight.setGraphic(img_fight_touch);
		});
		fight.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			fight.setGraphic(img_fight_normal);
		});
		fight.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			next.setVisible(true);
			fight.setVisible(false);
			mode.setVisible(false);
			Click.play();
		});
		mode.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			Choose.play();
			if(mode.getGraphic()==img_atk_normal)
				mode.setGraphic(img_atk_touch);
			else if(mode.getGraphic()==img_def_normal)
				mode.setGraphic(img_def_touch);
		});
		mode.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			if(mode.getGraphic()==img_atk_touch)
				mode.setGraphic(img_atk_normal);
			else if(mode.getGraphic()==img_def_touch)
				mode.setGraphic(img_def_normal);
		});
		mode.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(mode.getGraphic()==img_atk_touch) {
				mode.setGraphic(img_def_touch);
				modedefrate=1.2;
				modeatkrate=1;
			}
			else if(mode.getGraphic()==img_def_touch) {
				mode.setGraphic(img_atk_touch);
				modedefrate=1;
				modeatkrate=1.2;
			}
			Switch.play();
		});
		////////////////////////////////////
		student[0].pane.setOnMouseEntered(e->{
			student_skillpane[0].setVisible(true);
		});
		student[0].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		student[1].pane.setOnMouseEntered(e->{
			student_skillpane[1].setVisible(true);
		});
		student[1].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		student[2].pane.setOnMouseEntered(e->{
			student_skillpane[2].setVisible(true);
		});
		student[2].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		enemy[0].pane.setOnMouseEntered(e->{
			enemy_skillpane[0].setVisible(true);
		});
		enemy[0].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		enemy[1].pane.setOnMouseEntered(e->{
			enemy_skillpane[1].setVisible(true);
		});
		enemy[1].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		enemy[2].pane.setOnMouseEntered(e->{
			enemy_skillpane[2].setVisible(true);
		});
		enemy[2].pane.setOnMouseExited(e->{
			setskillpane_normal();
		});
		/////////////////////////////////////
		img_enemy[0].setLayoutX(12);
		img_enemy[0].setLayoutY(194);
		img_enemy[1].setLayoutX(175);
		img_enemy[1].setLayoutY(22);
		img_enemy[2].setLayoutX(320);
		img_enemy[2].setLayoutY(194);
		for(int i = 0;i < 3;i++) {
			img_enemy_focus[i].setVisible(false);
			img_enemy_focus[i].setLayoutX(115);
			img_enemy_focus[i].setLayoutY(60);
		}
		for(int i = 0;i < 3;i++)
			enemypane.getChildren().addAll(img_enemy[i],img_enemy_focus[i]);
		enemypane.setLayoutX(-503);
		enemypane.setLayoutY(0);
		//////////////////////////////////////
		img_student[0].setLayoutX(12);
		img_student[0].setLayoutY(194);
		img_student[1].setLayoutX(175);
		img_student[1].setLayoutY(22);
		img_student[2].setLayoutX(320);
		img_student[2].setLayoutY(194);
		for(int i = 0;i < 3;i++) {
			img_student_focus[i].setVisible(false);
			img_student_focus[i].setLayoutX(130);
			img_student_focus[i].setLayoutY(60);
		}
		for(int i = 0;i < 3;i++)
			studentpane.getChildren().addAll(img_student[i],img_student_focus[i]);
		studentpane.setLayoutX(1279);
		studentpane.setLayoutY(0);
		/////////////////////////////////////
		battlepane.getChildren().addAll(background,enemypane,studentpane);
		for(int i = 0;i < 3;i++)
			battlepane.getChildren().addAll(enemy[i].pane,student[i].pane);
		battlepane.getChildren().addAll(next,fight,mode,enygetatk,stdgetatk,round_text);
		for(int i = 0;i < 3;i++)
			battlepane.getChildren().addAll(student_skillpane[i],enemy_skillpane[i]);
		battlescene = new Scene(battlepane,1280,720);
	}
	public void recover() {
		for(int i = 0;i < 3;i++) {
			if(student[i].alive==true)
				student[i].recoverself();
		}
		for(int i = 0;i < 3;i++) {
			if(enemy[i].alive==true)
				enemy[i].recoverself();
		}
		if(student[0].alive==true)
			student[0].allrecover(student[1], student[2]);
		if(student[1].alive==true)
			student[1].allrecover(student[0], student[2]);
		if(student[2].alive==true)
			student[2].allrecover(student[0], student[1]);
		if(enemy[0].alive==true)
			enemy[0].allrecover(enemy[1], enemy[2]);
		if(enemy[1].alive==true)
			enemy[1].allrecover(enemy[0], enemy[2]);
		if(enemy[2].alive==true)
			enemy[2].allrecover(enemy[0], enemy[1]);
		for(int i = 0;i < 3;i++) {
			student[i].refresh();
			enemy[i].refresh();
		}
	}
	public void atkeny(int a) {
		if(student[a].alive==true) {
			for(int i = 0;i <student[a].atknum;i++) {
				boolean math_alive = false;
				boolean language_alive = false;
				boolean program_alive = false;
				boolean alratk = false;
				for(int j = 0;j < 3;j++) {
					if(enemy[j].subject==1&&enemy[j].alive==true)
						math_alive=true;
					if(enemy[j].subject==2&&enemy[j].alive==true)
						language_alive=true;
					if(enemy[j].subject==3&&enemy[j].alive==true)
						program_alive=true;
				}
				if(student[a].mathatk==true&&math_alive==true) {
					for(int j = 0;j < 3;j++) {
						if(enemy[j].subject==1&&enemy[j].alive==true) {
							atkenemy(student[a],enemy[j]);
							satkani(img_student[a]);
							atkact.play();
							enemy[j].refresh();
						}
					}
					alratk=true;
				}
				if(student[a].languageatk==true&&language_alive==true) {
					for(int j = 0;j < 3;j++) {
						if(enemy[j].subject==2&&enemy[j].alive==true) {
							atkenemy(student[a],enemy[j]);
							satkani(img_student[a]);
							atkact.play();
							enemy[j].refresh();
						}
					}
					alratk=true;
				}
				if(student[a].programatk==true&&program_alive==true) {
					for(int j = 0;j < 3;j++) {
						if(enemy[j].subject==3&&enemy[j].alive==true) {
							atkenemy(student[a],enemy[j]);
							satkani(img_student[a]);
							atkact.play();
							enemy[j].refresh();
						}
					}
					alratk=true;
				}
				if(alratk==false){
					for(int j = 0;j < 3;j++) {
						if(enemy[j].alive==true) {
							atkenemy(student[a],enemy[j]);
							satkani(img_student[a]);
							atkact.play();
							enemy[j].refresh();
							break;
						}
					}
				}
			}
		}
	}
	public void atksdt(int a) {
		if(enemy[a].alive==true) {
			for(int i = 0;i <enemy[a].atknum;i++) {
				if(enemy[a].allatk==true) {
					for(int j = 0;j < 3;j++) {
						if(student[j].alive==true) {
							atkstudent(enemy[a],student[j]);
							eatkani(img_enemy[a]);
							atkact1.play();
							student[j].refresh();
						}
					}
				}
				else {
					for(int j = 0;j < 3;j++) {
						if(student[j].alive==true) {
							atkstudent(enemy[a],student[j]);
							eatkani(img_enemy[a]);
							atkact1.play();
							student[j].refresh();
							break;
						}
					}
				}
			}
		}
	}
	public void atkenemy(Battle_Student_data s,Battle_enemy_data e) {
		if(e.subject==1){
			boolean B_crit = s.crit(s.critrate);
			if(B_crit==true) {
				if(((int)((1.5+s.critdmg) * s.math * s.mathrate)*modeatkrate-e.atk.intValue()*2/3)>0) {
					e.hp = (int)(e.hp-(((1.5+s.critdmg) * s.math * s.mathrate)*modeatkrate-e.atk.intValue()*2/3));
					critatk.play();
				}
				else
					atkfail.play();
			}	
			else {
				 if(s.math * s.mathrate*modeatkrate-e.atk.intValue()*2/3>0) {
					 e.hp = (int) (e.hp - (s.math * s.mathrate*modeatkrate-e.atk.intValue()*2/3));
					 normalatk.play();
				 }
				 else
					atkfail.play();
			}
		}
		else if(e.subject==2){
			boolean B_crit = s.crit(s.critrate);
			if(B_crit==true) {
				if(((int)((1.5+s.critdmg) * s.language * s.languagerate)*modeatkrate-e.atk.intValue()*2/3)>0) {
					e.hp = (int) (e.hp - (((1.5+s.critdmg) * s.language * s.languagerate)*modeatkrate-e.atk.intValue()*2/3));
					critatk.play();
				}
				else
					atkfail.play();
			}		
			else {
				if(s.language * s.languagerate-e.atk.intValue()*2/3>0) {
					e.hp = (int) (e.hp - (s.language * s.languagerate-e.atk.intValue()*2/3));
					normalatk.play();
				}	
				else
					atkfail.play();
			}
		}
		else if(e.subject==3){
			boolean B_crit = s.crit(s.critrate);
			if(B_crit==true) {
				if(((int)((1.5+s.critdmg) * s.program * s.programrate*modeatkrate)-e.atk.intValue()*2/3)>0) {
					e.hp = (int) (e.hp - (((1.5+s.critdmg) * s.program * s.programrate)*modeatkrate-e.atk.intValue()*2/3));
					critatk.play();
				}
				else
					atkfail.play();	
			}	
			else {
				if(s.program * s.programrate*modeatkrate-e.atk.intValue()*2/3>0) {
					e.hp = (int) (e.hp - (s.program * s.programrate*modeatkrate-e.atk.intValue()*2/3));
					normalatk.play();
				}
				else
					atkfail.play();	
			}
		}
		if(e.hp<0)
			e.hp = 0;
	}
	public void atkstudent(Battle_enemy_data e,Battle_Student_data s) {
		boolean B_crit = e.crit(e.critrate);
		if(e.subject==1) {
			if(B_crit==true) {
				if(((int)((2+e.critdmg) * e.atk.intValue())-s.math*0.7*modedefrate)>0) {
					s.hp = s.hp - ((int)((2+e.critdmg) * e.atk.intValue())-(int)(s.math*0.7*modedefrate));
					critatk.play();
				}
				else
					atkfail.play();
			}	
			else {
				if(e.atk.intValue()-s.math*0.7*modedefrate>0) {
					s.hp = s.hp - (int)(e.atk.intValue()-s.math*0.7*modedefrate);
					normalatk.play();
				}
				else
					atkfail.play();
			}
		}
		else if(e.subject==2) {
			if(B_crit==true) {
				if(((int)((2+e.critdmg) * e.atk.intValue())-s.language*0.7*modedefrate)>0) {
					s.hp = s.hp - ((int)((2+e.critdmg) * e.atk.intValue())-(int)(s.language*0.7*modedefrate));
					critatk.play();
				}
			}	
			else {
				if(e.atk.intValue()-s.language*0.7*modedefrate>0) {
					s.hp = s.hp - (int)(e.atk.intValue()-s.language*0.7*modedefrate);
					normalatk.play();
				}	
				else
					atkfail.play();
			}
		}
		else if(e.subject==3) {
			if(B_crit==true) {
				if(((int)((2+e.critdmg) * e.atk.intValue())-s.program*0.7*modedefrate)>0)
					s.hp = s.hp - ((int)((2+e.critdmg) * e.atk.intValue())-(int)(s.program*0.7*modedefrate));
				critatk.play();
			}	
			else {
				if(e.atk.intValue()-s.program*0.7*modedefrate>0) {
				s.hp = s.hp - (int)(e.atk.intValue()-s.program*0.7*modedefrate);
				normalatk.play();
				}
				else
					atkfail.play();
			} 
		}
	}
	public void refresh() {
		for(int i = 0;i < 3;i++) {
			if(student[i].alive==false)
				img_student[i].setVisible(false);
			else
				img_student[i].setVisible(true);
		}
		for(int i = 0;i < 3;i++) {
			if(enemy[i].alive==false)
				img_enemy[i].setVisible(false);
			else
				img_enemy[i].setVisible(true);
		}
	}
	public void setskillpane_normal() {
		for(int i = 0;i < 3;i++) {
			student_skillpane[i].setVisible(false);
			enemy_skillpane[i].setVisible(false);
		}
	}
	public void satkani(ImageView s) {
		Timeline t = new Timeline();
		Timeline t1 = new Timeline(new KeyFrame(Duration.millis(1),(a)-> {
			s.setLayoutX(s.getLayoutX()-10);
		    }));
		t1.setCycleCount(70);
		Timeline t2 = new Timeline(new KeyFrame(Duration.millis(1),(a)-> {
			s.setLayoutX(s.getLayoutX()+10);
		    }));
		t2.setCycleCount(70);
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, (a)-> {t1.play();})
				,new KeyFrame(new Duration(70),(a)-> {t2.play();;})
				);
		t.play();
	}
	public void eatkani(ImageView e) {
		Timeline t = new Timeline();
		Timeline t1 = new Timeline(new KeyFrame(Duration.millis(1),(a)-> {
			e.setLayoutX(e.getLayoutX()+10);
		    }));
		t1.setCycleCount(70);
		Timeline t2 = new Timeline(new KeyFrame(Duration.millis(1),(a)-> {
			e.setLayoutX(e.getLayoutX()-10);
		    }));
		t2.setCycleCount(70);
		t.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, (a)-> {t1.play();})
				,new KeyFrame(new Duration(70),(a)-> {t2.play();;})
				);
		t.play();
	}
	public ImageView atk[] = new ImageView[6];
	public Image iatk[] = new Image[6];
	public ImageView atk1[] = new ImageView[6];
	public Image iatk1[] = new Image[6];
	public Timeline atkact = new Timeline();
	public Timeline atkact1 = new Timeline();
	public AudioClip atkfail = new AudioClip(getClass().getResource("SE/Attack09.mp3").toString());
	public AudioClip normalatk = new AudioClip(getClass().getResource("SE/Attack06.mp3").toString());
	public AudioClip critatk = new AudioClip(getClass().getResource("SE/Attack08.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
}
