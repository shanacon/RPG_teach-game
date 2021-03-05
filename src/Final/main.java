package Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.naming.Binding;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application {
	public static int clearflag1 = 0;
	public static int clearflag2 = 0;
	public static int clearout1;
	public static int clearout2;
	public static Stage mainStage;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage mainStage) {
		for(int i = 0;i < 10;i++)
			icharacter[i] = new Image(getClass().getResourceAsStream("picture/character/character_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 10;i++)
			img_character[i] = new ImageView(icharacter[i]);
		for(int i = 0;i < 10;i++)
			icharacter_touch[i] = new Image(getClass().getResourceAsStream("picture/character/character_touch_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 10;i++)
			img_character_touch[i] = new ImageView(icharacter_touch[i]);
		for(int i = 0;i < 10;i++)
			icharacter_choose[i] = new Image(getClass().getResourceAsStream("picture/character/character_choose_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 10;i++)
			img_character_choose[i] = new ImageView(icharacter_choose[i]);
		for(int i = 0;i < 10;i++)
			icharacter_intro[i] = new Image(getClass().getResourceAsStream("picture/character/char_intro_"+ Integer.toString(i+1) + ".png"));
		for(int i = 0;i < 10;i++)
			img_character_intro[i] = new ImageView(icharacter_intro[i]);
		for(int i = 0;i < 10;i++)
			character[i] = new Button();
		//////////////////////////////////////////////
		for(int i = 0;i < 15;i++) {
			img_talent_false_normal[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/talent/talent_false_normal.png")));
		}
		for(int i = 0;i < 15;i++) {
			img_talent_false_choose[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/talent/talent_false_choose.png")));
		}
		for(int i = 0;i < 15;i++) {
			img_talent_true_normal[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/talent/talent_true_normal.png")));
		}
		for(int i = 0;i < 15;i++) {
			img_talent_true_choose[i] =new ImageView(new Image(getClass().getResourceAsStream("picture/talent/talent_true_choose.png")));
		}
		for(int i = 0;i < 15;i++) {
			talent_use[0] = false;
		}

		Mainscene firstscene = new Mainscene(students,choose_student,anchor,main1,main2,
				background,c_background,img_start_normal,img_start_pressed,img_start_touch,
				img_start_normal_1,img_start_pressed_1,img_start_touch_1,img_tutorial_normal,
				img_tutorial_pressed,img_tutorial_touch,img_load_normal,img_load_pressed,
				img_load_touch,img_exit_normal,img_exit_pressed,img_exit_touch,img_back_normal,
				img_back_pressed,img_back_touch,img_character,img_character_touch,img_character_choose,
				img_character_intro,Error,Cancel,Choose,Click,Choose2,start,start_1,tutorial,
				load,exit,back,character,t,t2);
		firstscene.execute();
		FileInputStream fin;
		try {
			fin = new FileInputStream("src/Final/save/clear.txt");
			byte[] clearByte;
			clearByte = fin.readAllBytes();			
			String clearcontent = new String(clearByte, "UTF-8");
			String cleardata[] = clearcontent.split(" ");
			clearflag1 = Integer.valueOf(cleardata[0]);
			clearout1 = Integer.valueOf(cleardata[0]);
			clearflag2 = Integer.valueOf(cleardata[1]);
			clearout2 = Integer.valueOf(cleardata[1]);
			if(clearflag1==1)
				firstscene.character[8].setVisible(true);
			if(clearflag2==1)
				firstscene.character[9].setVisible(true);
		} catch (FileNotFoundException e2) {
		} catch (IOException e1) {
		}
		//////////////////////////////////////////
		Difficulty setdif = new Difficulty(img_easy_normal,img_easy_pressed,img_easy_touch,
				 img_normal_normal, img_normal_pressed, img_normal_touch,
				 img_hard_normal, img_hard_pressed, img_hard_touch,img_dif_background,
				Choose,Click);
		/////////////////////////////////////////
		day eneryteachday = new day(img_calendar_normal, img_calendar_pressed, img_calendar_touch,
				 img_checkdata_normal, img_checkdata_pressed, img_checkdata_touch,
				 img_s_name_normal, img_s_name_pressed, img_s_name_touch, img_set_normal,
				 img_set_pressed, img_set_touch, img_talent_normal, img_talent_pressed,
				 img_talent_touch, day_background,Choose,Click,img_talent_false_normal,img_talent_false_choose,
				 img_talent_true_normal,img_talent_true_choose,img_unlock_normal,img_unlock_pressed,img_unlock_touch,
				 img_talent_background,Switch,talent_use,img_back_normal,img_back_pressed,img_back_touch,Error,
				 img_character,img_character_touch);
		////////////////////////////////////////
		Formation f_1 = new Formation();
		Formation f_2 = new Formation();
		Formation f_3 = new Formation();
		Finalscene oneweekwin = new Finalscene("恭喜在第一周通關\n已解鎖新角色！！");
		Finalscene normalwin = new Finalscene("恭喜通關");
		normalwin.t.setLayoutX(580);
		normalwin.t.setLayoutY(330);
		Finalscene hardwin = new Finalscene("恭喜通關hard難度\n已解鎖新角色！！");
		Finalscene lose = new Finalscene("GAMEOVER");
		lose.t.setLayoutX(550);
		lose.t.setLayoutY(330);
		////////////////////////////////////////
		Examday exam1_1 = new Examday("數學");
		Examday exam1_2 = new Examday("語文");
		Examday exam1_3 = new Examday("程式");
		Examday exam1_4 = new Examday("混合題");
		Examday exam1_EX = new Examday("總決賽");
		Examday exam1_5 = new Examday("無參加資格");
		Examday exam2_1 = new Examday("數學");
		Examday exam2_2 = new Examday("語文");
		Examday exam2_3 = new Examday("程式");
		Examday exam2_4 = new Examday("混合題");
		Examday exam2_EX = new Examday("總決賽");
		Examday exam2_5 = new Examday("無參加資格");
		Examday exam3_1 = new Examday("數學");
		Examday exam3_2 = new Examday("語文");
		Examday exam3_3 = new Examday("程式");
		Examday exam3_4 = new Examday("混合題");
		Examday exam3_EX = new Examday("總決賽");
		Examday exam3_5 = new Examday("無參加資格");
		////////////////////////////////////////
		setenemy();
		Battlescene one_one = new Battlescene(hp1_1_1,1,atk1_1_1,1,40,0,0,0,false,"自我回復：40","--------------","--------------","--------------","基礎幾何",
											  hp1_1_2,1,atk1_1_2,2,0,0,0,0,false,"追加攻擊：1","--------------","--------------","--------------","四則運算",
											  hp1_1_3,1,atk1_1_3,1,0,20,0,0,false,"全體回復：20","--------------","--------------","--------------","基礎數線");
		Battlescene one_two = new Battlescene(hp1_2_1,2,atk1_2_1,1,0,20,0,0,false,"全體回復：20","--------------","--------------","--------------","唐詩三首",
											  hp1_2_2,2,atk1_2_2,1,0,0,0.3,0,false,"陷阱增加：30","--------------","--------------","--------------","倫語",
											  hp1_2_3,2,atk1_2_3,1,0,20,0,0,false,"全體回復：20","--------------","--------------","--------------","國學常識I");
		Battlescene one_three = new Battlescene(hp1_3_1,3,atk1_3_1,1,100,0,0,0,false,"自我回復：100","--------------","--------------","--------------","基礎C++",
											  hp1_3_2,3,atk1_3_2,1,0,0,0.4,0.4,false,"陷阱增加：40","陷阱難度：40","--------------","--------------","pythonI",
											  hp1_3_3,3,atk1_3_3,1,0,80,0,0,false,"全體回復：80","--------------","--------------","--------------","scratch");
		Battlescene one_four = new Battlescene(hp1_4_1,1,atk1_4_1,1,30,0,0,0,false,"自我回復：30","--------------","--------------","--------------","基礎數學I",
				  								hp1_4_2,3,atk1_4_2,1,0,0,0.2,0.2,false,"陷阱增加：20","陷阱難度：20","--------------","--------------","程式入門",
				  								hp1_4_3,2,atk1_4_3,1,0,0,0,0,false,"--------------","--------------","--------------","--------------","基礎國學");
		Battlescene one_EX = new Battlescene(hp1_EX_1,2,atk1_EX_1,1,0,100,0,0,false,"全體回復：100","--------------","--------------","--------------","高等文學I",
											 hp1_EX_2,2,atk1_EX_2,1,0,100,0,0,false,"全體回復：100","--------------","--------------","--------------","高等文學I",
											 hp1_EX_3,1,atk1_EX_3,3,400,0,0.3,0.3,false,"陷阱增加：30","陷阱難度：30","追加攻擊：2","自我回復：400","數學BOSSI");		
		/////////////
		Battlescene two_one = new Battlescene(hp2_1_1,1,atk2_1_1,1,250,0,0,0,false,"自我回復：250","--------------","--------------","--------------","先修幾何",
				  							hp2_1_2,1,atk2_1_2,3,0,0,0,0,false,"追加攻擊：2","--------------","--------------","--------------","三角函數",
				  								hp2_1_3,1,atk2_1_3,2,0,0,0,0,false,"追加攻擊：1","--------------","--------------","--------------","進階數線");
		Battlescene two_two = new Battlescene(hp2_2_1,2,atk2_2_1,1,0,100,0,0,false,"全體回復：100","--------------","--------------","--------------","唐詩三十首",
												hp2_2_2,2,atk2_2_2,1,0,0,0.5,0.5,false,"陷阱增加：50","陷阱難度：50","--------------","--------------","大學",
				  								hp2_2_3,2,atk2_2_3,1,0,100,0,0,false,"全體回復：100","--------------","--------------","--------------","英語會話");
		Battlescene two_three = new Battlescene(hp2_3_1,3,atk2_3_1,1,200,0,0.4,0,false,"自我回復：200","陷阱增加：40","--------------","--------------","進階C++",
				  								hp2_3_2,3,atk2_3_2,2,0,0,0.4,0.4,false,"陷阱增加：40","陷阱難度：40","追加攻擊：1","--------------","pythonII",
				  								hp2_3_3,3,atk2_3_3,2,0,100,0,0,false,"全體回復：100","追加攻擊：1","--------------","--------------","JAVA");
		Battlescene two_four = new Battlescene(hp2_4_1,1,atk2_4_1,1,200,0,0,0,false,"自我回復：200","--------------","--------------","--------------","進階數學I",
												hp2_4_2,3,atk2_4_2,1,0,0,0.4,0.4,false,"陷阱增加：40","陷阱難度：40","--------------","--------------","程式進階",
												hp2_4_3,2,atk2_4_3,1,0,100,0,0,false,"全體回復：100","--------------","--------------","--------------","進階英語");
		Battlescene two_EX = new Battlescene(hp2_EX_1,3,atk2_EX_1,1,300,200,0,0,false,"全體回復：200","自我回復：300","--------------","--------------","綜合程式",
												hp2_EX_2,3,atk2_EX_2,1,300,200,0,0,false,"全體回復：200","自我回復：300","--------------","--------------","綜合程式",
												hp2_EX_3,2,atk2_EX_3,1,0,0,0.2,0.2,true,"陷阱增加：20","陷阱難度：20","全體攻擊：1","--------------","語文BOSSI");
		/////////////
		Battlescene three_one = new Battlescene(hp3_1_1,1,atk3_1_1,1,500,0,0,0,false,"自我回復：500","--------------","--------------","--------------","向量",
				  							hp3_1_2,1,atk3_1_2,4,0,0,0,0,false,"追加攻擊：3","--------------","--------------","--------------","三角和差",
				  								hp3_1_3,1,atk3_1_3,3,0,0,0,0,false,"追加攻擊：2","--------------","--------------","--------------","微積分");
		Battlescene three_two = new Battlescene(hp3_2_1,2,atk3_2_1,1,0,300,0,0,false,"全體回復：300","--------------","--------------","--------------","唐詩三百首",
												hp3_2_2,2,atk3_2_2,2,0,0,0.6,0.6,false,"陷阱增加：60","陷阱難度：60","追加攻擊：1","--------------","中庸",
				  								hp3_2_3,2,atk3_2_3,1,0,300,0,0,false,"全體回復：300","--------------","--------------","--------------","英語閱讀");
		Battlescene three_three = new Battlescene(hp3_3_1,3,atk3_3_1,1,500,0,0.4,0,false,"自我回復：500","陷阱增加：40","--------------","--------------","進階C+++",
				  								hp3_3_2,3,atk3_3_2,3,0,0,0.4,0.4,false,"陷阱增加：40","陷阱難度：40","追加攻擊：2","--------------","pythonIII",
				  								hp3_3_3,3,atk3_3_3,2,0,300,0,0,false,"全體回復：300","追加攻擊：1","--------------","--------------","JAVAFX");
		Battlescene three_four = new Battlescene(hp3_4_1,1,atk3_4_1,1,500,0,0,0,false,"自我回復：500","--------------","--------------","--------------","商用數學I",
												hp3_4_2,3,atk3_4_2,2,0,0,0.4,0.4,false,"陷阱增加：40","陷阱難度：40","追加攻擊：1","--------------","程式進階II",
												hp3_4_3,2,atk3_4_3,1,0,300,0,0,false,"全體回復：300","--------------","--------------","--------------","進階英語");
		Battlescene three_EX = new Battlescene(hp3_EX_1,1,atk3_EX_1,1,600,400,0,0,false,"全體回復：400","自我回復：600","--------------","--------------","綜合數學",
												hp3_EX_2,1,atk3_EX_2,1,600,400,0,0,false,"全體回復：400","自我回復：600","--------------","--------------","綜合數學",
												hp3_EX_3,3,atk3_EX_3,3,0,0,0.8,0.8,false,"陷阱增加：80","陷阱難度：80","追加攻擊：2","--------------","程式BOSSI");
		////////////////////////////////////////
		tchg.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(firstscene.anchor.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(title.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(title.volumeProperty(), 0.1))
				,new KeyFrame(new Duration(500), new KeyValue(firstscene.anchor.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);title.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(0), new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 0.75))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				);
		tchg1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(firstscene.anchor.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(firstscene.anchor.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(setdif.scene);})
				,new KeyFrame(new Duration(500), new KeyValue(setdif.set.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(setdif.set.opacityProperty(), 1))
				);
		/////////////////////////////////////////
		tchg2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(setdif.set.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(title.volumeProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 0.75))
				,new KeyFrame(new Duration(500), new KeyValue(title.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(setdif.set.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);title.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				);
		/////////////////////////////////////////
		tchg_b1_0.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(f_1.scene);normal_battle.play();teach.stop();})
				,new KeyFrame(new Duration(500), new KeyValue(f_1.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(f_1.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 1))
				);
		tchg_e1_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(f_1.pane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(f_1.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_1.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_1.examday.opacityProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_b1_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_1.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(one_one.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(one_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(one_one.enemypane,one_one.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(one_one.battlepane.opacityProperty(), 1))
				);
		tchg_b1_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_2.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(one_two.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(one_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(one_two.enemypane,one_two.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(one_two.battlepane.opacityProperty(), 1))
				);
		tchg_b1_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_3.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(one_three.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(one_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(one_three.enemypane,one_three.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(one_three.battlepane.opacityProperty(), 1))
				);
		tchg_b1_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_4.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(one_four.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(one_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(one_four.enemypane,one_four.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(one_four.battlepane.opacityProperty(), 1))
				);
		tchg_b1_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(one_EX.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(one_EX.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(one_EX.enemypane,one_EX.studentpane);boss1.play();normal_battle.stop();})
				,new KeyFrame(new Duration(1000), new KeyValue(one_EX.battlepane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss1.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(boss1.volumeProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_e1_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(one_one.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(one_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_2.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_2.examday.opacityProperty(), 1))
				);
		tchg_e1_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(one_two.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(one_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_3.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_3.examday.opacityProperty(), 1))
				);
		tchg_e1_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(one_three.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(one_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_4.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_4.examday.opacityProperty(), 1))
				);
		tchg_e1_5.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(one_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(one_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_5.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_5.examday.opacityProperty(), 1))
				);
		tchg_e1_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(one_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(one_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam1_EX.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam1_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam1_EX.examday.opacityProperty(), 1))
				);
		tchgEX1_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);boss1.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss1.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss1.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 1))
				);
		tchgEX1_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(oneweekwin.scene);clearout1=1;outputfile();win.play();boss1.stop();})
				,new KeyFrame(new Duration(500), new KeyValue(oneweekwin.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(oneweekwin.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss1.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss1.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(win.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(win.volumeProperty(), 1))
				);
		//////////////////////////////////////////
		tchg1_back.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam1_5.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam1_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);normal_battle.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 1))
				);
		/////////////////////////////////////////
		/////////////////////////////////////////
		tchg_b2_0.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(f_2.scene);teach.stop();normal_battle.play();})
				,new KeyFrame(new Duration(500), new KeyValue(f_2.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(f_2.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 1))
				);
		tchg_e2_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(f_2.pane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(f_2.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_1.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_1.examday.opacityProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_b2_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_1.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(two_one.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(two_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(two_one.enemypane,two_one.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(two_one.battlepane.opacityProperty(), 1))
				);
		tchg_b2_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_2.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(two_two.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(two_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(two_two.enemypane,two_two.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(two_two.battlepane.opacityProperty(), 1))
				);
		tchg_b2_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_3.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(two_three.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(two_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(two_three.enemypane,two_three.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(two_three.battlepane.opacityProperty(), 1))
				);
		tchg_b2_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_4.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(two_four.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(two_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(two_four.enemypane,two_four.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(two_four.battlepane.opacityProperty(), 1))
				);
		tchg_b2_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(two_EX.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(two_EX.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(two_EX.enemypane,two_EX.studentpane);normal_battle.stop();boss2.play();})
				,new KeyFrame(new Duration(1000), new KeyValue(two_EX.battlepane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss2.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(boss2.volumeProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_e2_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_one.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_2.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_2.examday.opacityProperty(), 1))
				);
		tchg_e2_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_two.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_3.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_3.examday.opacityProperty(), 1))
				);
		tchg_e2_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_three.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_4.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_4.examday.opacityProperty(), 1))
				);
		tchg_e2_5.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_5.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_5.examday.opacityProperty(), 1))
				);
		tchg_e2_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam2_EX.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam2_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam2_EX.examday.opacityProperty(), 1))
				);
		tchgEX2_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);boss2.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss2.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss2.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 1))
				);
		tchgEX2_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(normalwin.scene);boss2.stop();win.play();})
				,new KeyFrame(new Duration(500), new KeyValue(normalwin.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(normalwin.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss2.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss2.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(win.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(win.volumeProperty(), 1))
				);
		tchgEX2_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(hardwin.scene);clearout2 = 1;outputfile();boss2.stop();win.play();})
				,new KeyFrame(new Duration(500), new KeyValue(hardwin.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(hardwin.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss2.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss2.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(win.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(win.volumeProperty(), 1))
				);
		//////////////////////////////////////////
		tchg2_back.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam2_5.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam2_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(eneryteachday.scene);normal_battle.stop();teach.play();})
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 1))
				);
		/////////////////////////////////////////
		tchg_b3_0.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(eneryteachday.main_day.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(eneryteachday.main_day.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(f_3.scene);teach.stop();normal_battle.play();})
				,new KeyFrame(new Duration(500), new KeyValue(f_3.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(f_3.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(teach.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(teach.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 1))
				);
		tchg_e3_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(f_3.pane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(f_3.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_1.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_1.examday.opacityProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_b3_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_1.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_1.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(three_one.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(three_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(three_one.enemypane,three_one.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(three_one.battlepane.opacityProperty(), 1))
				);
		tchg_b3_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_2.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(three_two.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(three_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(three_two.enemypane,three_two.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(three_two.battlepane.opacityProperty(), 1))
				);
		tchg_b3_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_3.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(three_three.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(three_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(three_three.enemypane,three_three.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(three_three.battlepane.opacityProperty(), 1))
				);
		tchg_b3_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_4.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(three_four.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(three_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(three_four.enemypane,three_four.studentpane);})
				,new KeyFrame(new Duration(1000), new KeyValue(three_four.battlepane.opacityProperty(), 1))
				);
		tchg_b3_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(three_EX.battlescene);})
				,new KeyFrame(new Duration(500), new KeyValue(three_EX.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000),(a)-> {battlepanein(three_EX.enemypane,three_EX.studentpane);normal_battle.stop();boss3.play();})
				,new KeyFrame(new Duration(1000), new KeyValue(three_EX.battlepane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss3.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(boss3.volumeProperty(), 1))
				);
		////////////////////////////////////////////
		tchg_e3_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(three_one.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(three_one.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_2.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_2.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_2.examday.opacityProperty(), 1))
				);
		tchg_e3_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(three_two.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(three_two.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_3.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_3.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_3.examday.opacityProperty(), 1))
				);
		tchg_e3_4.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(three_three.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(three_three.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_4.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_4.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_4.examday.opacityProperty(), 1))
				);
		tchg_e3_5.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_5.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_5.examday.opacityProperty(), 1))
				);
		tchg_e3_EX.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(two_four.battlepane.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(two_four.battlepane.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(exam3_EX.examscene);})
				,new KeyFrame(new Duration(500), new KeyValue(exam3_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(exam3_EX.examday.opacityProperty(), 1))
				);
		tchgEX3_1.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(lose.scene);boss3.stop();Gameover.play();})
				,new KeyFrame(new Duration(500), new KeyValue(lose.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(lose.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss3.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss3.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(Gameover.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(Gameover.volumeProperty(), 1))
				);
		tchgEX3_2.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(normalwin.scene);boss3.stop();win.play();})
				,new KeyFrame(new Duration(500), new KeyValue(normalwin.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(normalwin.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss3.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss3.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(win.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(win.volumeProperty(), 1))
				);
		tchgEX3_3.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_EX.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_EX.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(hardwin.scene);clearout2 = 1;outputfile();boss3.stop();win.play();})
				,new KeyFrame(new Duration(500), new KeyValue(hardwin.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(hardwin.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(boss3.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(boss3.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(win.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(win.volumeProperty(), 1))
				);
		//////////////////////////////////////////
		tchg3_back.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO, new KeyValue(exam3_5.examday.opacityProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(exam3_5.examday.opacityProperty(), 0))
				,new KeyFrame(new Duration(500),(a)-> {mainStage.setScene(lose.scene);normal_battle.stop();Gameover.play();})
				,new KeyFrame(new Duration(500), new KeyValue(lose.pane.opacityProperty(), 0))
				,new KeyFrame(new Duration(1000), new KeyValue(lose.pane.opacityProperty(), 1))
				,new KeyFrame(Duration.ZERO, new KeyValue(normal_battle.volumeProperty(), 1))
				,new KeyFrame(new Duration(500), new KeyValue(normal_battle.volumeProperty(), 0))
				,new KeyFrame(Duration.ZERO, new KeyValue(Gameover.volumeProperty(), 0))
				,new KeyFrame(new Duration(500), new KeyValue(Gameover.volumeProperty(), 1))
				);
		title.setCycleCount(AudioClip.INDEFINITE);
		title.play();
		teach.setCycleCount(AudioClip.INDEFINITE);
		normal_battle.setCycleCount(AudioClip.INDEFINITE);
		win.setCycleCount(AudioClip.INDEFINITE);
		boss1.setCycleCount(AudioClip.INDEFINITE);
		boss2.setCycleCount(AudioClip.INDEFINITE);
		boss3.setCycleCount(AudioClip.INDEFINITE);
		////////////////////////////////////////////
		setdif.setbutton();
		eneryteachday.setbutton();
		eneryteachday.setscene();
		mainStage.setScene(firstscene.mainscene);
		firstscene.load.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			try {
				FileInputStream fis = new FileInputStream("src/Final/save/save3week.txt");
				byte[] allByte = fis.readAllBytes();
				String content = new String(allByte, "UTF-8");
				String data[] = content.split("\n");
				dif.set(Integer.valueOf(data[0]));
				for(int i = 0;i < 3;i++)
					day.use_setudent_number[i] = Integer.valueOf(data[i+1]);
				eneryteachday.setstudent_2();
				eneryteachday.setdata();
				day.used_student[0].hp = Integer.valueOf(data[4]);
				day.used_student[0].math = Integer.valueOf(data[5]);
				day.used_student[0].language = Integer.valueOf(data[6]);
				day.used_student[0].program = Integer.valueOf(data[7]);
				day.used_student[1].hp = Integer.valueOf(data[8]);
				day.used_student[1].math = Integer.valueOf(data[9]);
				day.used_student[1].language = Integer.valueOf(data[10]);
				day.used_student[1].program = Integer.valueOf(data[11]);
				day.used_student[2].hp = Integer.valueOf(data[12]);
				day.used_student[2].math = Integer.valueOf(data[13]);
				day.used_student[2].language = Integer.valueOf(data[14]);
				day.used_student[2].program = Integer.valueOf(data[15]);
				day.talent_point = Integer.valueOf(data[16]);
				day.day = Integer.valueOf(data[17]);
				for(int i = 0;i < 15;i++) {
					if(Integer.valueOf(data[18+i])==0)
						day.talent_use[i]=false;
					else if(Integer.valueOf(data[18+i])==1)
						day.talent_use[i]=true;
				}
				eneryteachday.settalent();
				eneryteachday.setcalendar();
				eneryteachday.setschedule();
				eneryteachday.setsname();
				day.used_student[0].Skill[4].setText(data[33]);
				day.used_student[0].Skill[5].setText(data[34]);
				day.used_student[0].Skill[6].setText(data[35]);
				day.used_student[0].Skill[7].setText(data[36]);
				day.used_student[1].Skill[4].setText(data[37]);
				day.used_student[1].Skill[5].setText(data[38]);
				day.used_student[1].Skill[6].setText(data[39]);
				day.used_student[1].Skill[7].setText(data[40]);
				day.used_student[2].Skill[4].setText(data[41]);
				day.used_student[2].Skill[5].setText(data[42]);
				day.used_student[2].Skill[6].setText(data[43]);
				day.used_student[2].Skill[7].setText(data[44]);
				//////////////////
				eneryteachday.sname.Student_data[0].Skill[4].setText(data[33]);
				eneryteachday.sname.Student_data[0].Skill[5].setText(data[34]);
				eneryteachday.sname.Student_data[0].Skill[6].setText(data[35]);
				eneryteachday.sname.Student_data[0].Skill[7].setText(data[36]);
				eneryteachday.sname.Student_data[1].Skill[4].setText(data[37]);
				eneryteachday.sname.Student_data[1].Skill[5].setText(data[38]);
				eneryteachday.sname.Student_data[1].Skill[6].setText(data[39]);
				eneryteachday.sname.Student_data[1].Skill[7].setText(data[40]);
				eneryteachday.sname.Student_data[2].Skill[4].setText(data[41]);
				eneryteachday.sname.Student_data[2].Skill[5].setText(data[42]);
				eneryteachday.sname.Student_data[2].Skill[6].setText(data[43]);
				eneryteachday.sname.Student_data[2].Skill[7].setText(data[44]);
				////////////////
				for(int i = 0;i < 4;i++) {
					if(data[45+i].equals("C")==true)
						eneryteachday.sname.Student_data[0].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[0].s_name_C[i]);
					else if(data[45+i].equals("B")==true)
						eneryteachday.sname.Student_data[0].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[0].s_name_B[i]);
					else if(data[45+i].equals("A")==true)
						eneryteachday.sname.Student_data[0].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[0].s_name_A[i]);
					else if(data[45+i].equals("S")==true)
						eneryteachday.sname.Student_data[0].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[0].s_name_S[i]);
				}
				for(int i = 0;i < 4;i++) {
					if(data[49+i].equals("C")==true)
						eneryteachday.sname.Student_data[1].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[1].s_name_C[i]);
					else if(data[49+i].equals("B")==true)
						eneryteachday.sname.Student_data[1].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[1].s_name_B[i]);
					else if(data[49+i].equals("A")==true)
						eneryteachday.sname.Student_data[1].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[1].s_name_A[i]);
					else if(data[49+i].equals("S")==true)
						eneryteachday.sname.Student_data[1].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[1].s_name_S[i]);
				}		
				for(int i = 0;i < 4;i++) {
					if(data[53+i].equals("C")==true)
						eneryteachday.sname.Student_data[2].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[2].s_name_C[i]);
					else if(data[53+i].equals("B")==true)
						eneryteachday.sname.Student_data[2].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[2].s_name_B[i]);
					else if(data[53+i].equals("A")==true)
						eneryteachday.sname.Student_data[2].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[2].s_name_A[i]);
					else if(data[53+i].equals("S")==true)
						eneryteachday.sname.Student_data[2].s_name_button[i].setGraphic(eneryteachday.sname.Student_data[2].s_name_S[i]);
				}
				for(int i = 0;i < 3;i++)
					eneryteachday.sname.Student_data[i].checkskill();
				eneryteachday.sname.setonskill();
				for(int i = 0;i < 3;i++)
					day.used_student[i].refresh();	
				for(int i = 0;i < 3;i++)
					eneryteachday.sname.Student_data[i].refresh(day.used_student[i]);
				for(int i = 0;i < 3;i++) {
					for(int j = 0;j < 4;j++) {
						eneryteachday.sname.Student_data[i].clickcount[j] = Integer.valueOf(data[57+i*4+j]) ;
					}	
				}
				Teacher.teach_rate = Double.valueOf(data[70]);
				if(Integer.valueOf(data[70])==1) {
					for(int i = 0;i < 3;i++)
						eneryteachday.sname.Student_data[i].s_name_button_0[1].setVisible(true);;
				}
				if(Integer.valueOf(data[71])==1) {
					for(int i = 0;i < 3;i++)
						eneryteachday.sname.Student_data[i].s_name_button_0[2].setVisible(true);;
				}
				if(Integer.valueOf(data[72])==1) {
					for(int i = 0;i < 3;i++)
						eneryteachday.sname.Student_data[i].s_name_button_0[3].setVisible(true);;
				}
				Teacher.test_rate = Double.valueOf(data[73]);
				Teacher.test_rate_talent = Integer.valueOf(data[74]);
				Teacher.talk_rate = Integer.valueOf(data[75]);
				eneryteachday.refresh_day_and_talentpoint();
				exam1_1.setexamday();
				exam1_2.setexamday();
				exam1_3.setexamday();
				exam1_4.setexamday();
				exam1_5.setexamday();
				exam1_EX.setexamday();
				f_1.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				exam2_1.setexamday();
				exam2_2.setexamday();
				exam2_3.setexamday();
				exam2_4.setexamday();
				exam2_5.setexamday();
				exam2_EX.setexamday();
				f_2.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				exam3_1.setexamday();
				exam3_2.setexamday();
				exam3_3.setexamday();
				exam3_4.setexamday();
				exam3_5.setexamday();
				exam3_EX.setexamday();
				f_3.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				Click.play();
				tchg.play();
			} catch (FileNotFoundException e1) {
				Error.play();
				firstscene.terror1.play();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e1) {
				Error.play();
				firstscene.terror2.play();
			}catch (IllegalArgumentException e1) {
				Error.play();
				firstscene.terror2.play();
			}
			
		});
		
		firstscene.start_1.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(firstscene.students<3) {
				Error.play();
				Timeline t = new Timeline();
				t.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO,(a)-> {firstscene.error_choose.setVisible(true);})
						,new KeyFrame(Duration.ZERO, new KeyValue(firstscene.error_choose.opacityProperty(), 0))
						,new KeyFrame(new Duration(300), new KeyValue(firstscene.error_choose.opacityProperty(), 1))
						,new KeyFrame(new Duration(600), new KeyValue(firstscene.error_choose.opacityProperty(), 0))
						,new KeyFrame(new Duration(600),(a)-> {firstscene.error_choose.setVisible(false);})
						);
				t.play();
			}
			else {
				firstscene.Click.play();
				choose_student = firstscene.choose_student;
				eneryteachday.setstudent(choose_student);
				eneryteachday.setcalendar();
				eneryteachday.settalent();
				eneryteachday.setdata();
				eneryteachday.setschedule();
				eneryteachday.setsname();
				exam1_1.setexamday();
				exam1_2.setexamday();
				exam1_3.setexamday();
				exam1_4.setexamday();
				exam1_5.setexamday();
				exam1_EX.setexamday();
				f_1.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				exam2_1.setexamday();
				exam2_2.setexamday();
				exam2_3.setexamday();
				exam2_4.setexamday();
				exam2_5.setexamday();
				exam2_EX.setexamday();
				f_2.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				exam3_1.setexamday();
				exam3_2.setexamday();
				exam3_3.setexamday();
				exam3_4.setexamday();
				exam3_5.setexamday();
				exam3_EX.setexamday();
				f_3.setFormation(day.used_student[0].img_student,day.used_student[1].img_student,day.used_student[2].img_student,
								day.used_student[0].img_student_touch,day.used_student[1].img_student_touch,day.used_student[2].img_student_touch);
				tchg1.play();
			}
		});
		setdif.easy.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			dif.set(0);
			tchg2.play();
		});
		setdif.normal.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			dif.set(1);
			tchg2.play();
		});
		setdif.hard.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			dif.set(2);
			tchg2.play();
		});
		eneryteachday.teach.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(eneryteachday.day==6)
				tchg_b1_0.play();
			else if(eneryteachday.day==13)
				tchg_b2_0.play();
			else if(eneryteachday.day==20)
				tchg_b3_0.play();
		});
		f_1.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			f_1.startaction();
			tchg_e1_1.play();
		});
		exam1_1.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			one_one.setBattle();
			tchg_b1_1.play();
		});
		one_one.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(one_one.enemy[0].alive==false&&one_one.enemy[1].alive==false&&one_one.enemy[2].alive==false)
				tchg_e1_2.play();
			else if(one_one.student[0].alive==false&&one_one.student[1].alive==false&&one_one.student[2].alive==false)
				tchg_e1_2.play();
			else if(one_one.round==0)
				tchg_e1_2.play();
			one_one.score = (int) (((4500*((one_one.student[0].hp + one_one.student[1].hp + one_one.student[2].hp)*1.0/
					(one_one.student[0].maxhp + one_one.student[1].maxhp + one_one.student[2].maxhp)*1.0))-
					(2250*((one_one.enemy[0].hp + one_one.enemy[1].hp + one_one.enemy[2].hp)*1.0/
					(one_one.enemy[0].maxhp.intValue() + one_one.enemy[1].maxhp.intValue() + one_one.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+one_one.round*0.1));
			exam1_2.setscore(one_one.score);
		});
		exam1_2.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			one_two.setBattle();
			tchg_b1_2.play();
		});
		one_two.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(one_two.enemy[0].alive==false&&one_two.enemy[1].alive==false&&one_two.enemy[2].alive==false)
				tchg_e1_3.play();
			else if(one_two.student[0].alive==false&&one_two.student[1].alive==false&&one_two.student[2].alive==false)
				tchg_e1_3.play();
			else if(one_two.round==0)
				tchg_e1_3.play();
			one_two.score = (int)(((4500*((one_two.student[0].hp + one_two.student[1].hp + one_two.student[2].hp)*1.0/
					(one_two.student[0].maxhp + one_two.student[1].maxhp + one_two.student[2].maxhp)*1.0))-
					(2250*((one_two.enemy[0].hp + one_two.enemy[1].hp + one_two.enemy[2].hp)*1.0/
					(one_two.enemy[0].maxhp.intValue() + one_two.enemy[1].maxhp.intValue() + one_two.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+one_two.round*0.1));
			exam1_3.setscore(one_one.score+one_two.score);
		});
		exam1_3.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			one_three.setBattle();
			tchg_b1_3.play();
		});
		one_three.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(one_three.enemy[0].alive==false&&one_three.enemy[1].alive==false&&one_three.enemy[2].alive==false)
				tchg_e1_4.play();
			else if(one_three.student[0].alive==false&&one_three.student[1].alive==false&&one_three.student[2].alive==false)
				tchg_e1_4.play();
			else if(one_three.round==0)
				tchg_e1_4.play();
			one_three.score = (int)(((4500*((one_three.student[0].hp + one_three.student[1].hp + one_three.student[2].hp)*1.0/
					(one_three.student[0].maxhp + one_three.student[1].maxhp + one_three.student[2].maxhp)*1.0))-
					(2250*((one_three.enemy[0].hp + one_three.enemy[1].hp + one_three.enemy[2].hp)*1.0/
					(one_three.enemy[0].maxhp.intValue() + one_three.enemy[1].maxhp.intValue() + one_three.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+one_three.round*0.1));
			exam1_4.setscore(one_one.score+one_two.score+one_three.score);
		});
		exam1_4.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			one_four.setBattle();
			tchg_b1_4.play();
		});
		one_four.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(one_four.enemy[0].alive==false&&one_four.enemy[1].alive==false&&one_four.enemy[2].alive==false) {
				if(one_one.score+one_two.score+one_three.score+one_four.score<12000) {
					exam1_5.goback.setVisible(true);
					exam1_5.start.setVisible(false);
					tchg_e1_5.play();
				}
				else if(one_one.score+one_two.score+one_three.score+one_four.score>=12000)
					tchg_e1_EX.play();
			}	
			else if(one_four.student[0].alive==false&&one_four.student[1].alive==false&&one_four.student[2].alive==false) {
				 if(one_one.score+one_two.score+one_three.score+one_four.score>=12000)
					 tchg_e1_EX.play();
				else if(one_one.score+one_two.score+one_three.score+one_four.score<12000) {
					exam1_5.goback.setVisible(true);
					exam1_5.start.setVisible(false);
					tchg_e1_5.play();
				}
			}
			else if(one_four.round==0) {
				if(one_one.score+one_two.score+one_three.score+one_four.score<12000) {
					exam1_5.goback.setVisible(true);
					exam1_5.start.setVisible(false);
					tchg_e1_5.play();
				}
				else if(one_one.score+one_two.score+one_three.score+one_four.score>=12000)
					tchg_e1_EX.play();
			}
			one_four.score = (int)(((4500*((one_four.student[0].hp + one_four.student[1].hp + one_four.student[2].hp)*1.0/
					(one_four.student[0].maxhp + one_four.student[1].maxhp + one_four.student[2].maxhp)*1.0))-
					(2250*((one_four.enemy[0].hp + one_four.enemy[1].hp + one_four.enemy[2].hp)*1.0/
					(one_four.enemy[0].maxhp.intValue() + one_four.enemy[1].maxhp.intValue() + one_four.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+one_four.round*0.1));
			exam1_5.setscore(one_one.score+one_two.score+one_three.score+one_four.score);
			exam1_EX.setscore(one_one.score+one_two.score+one_three.score+one_four.score);
		});
		exam1_5.goback.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			eneryteachday.day = eneryteachday.day + 2;
			eneryteachday.refresh_day_and_talentpoint();
			tchg1_back.play();
		});
		exam1_EX.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			one_EX.setBattle();
			one_EX.img_enemy[2].setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_1.png")));
			one_EX.enemy[2].exam.setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_1.png")));
			tchg_b1_EX.play();
		});
		one_EX.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(one_EX.enemy[0].alive==false&&one_EX.enemy[1].alive==false&&one_EX.enemy[2].alive==false)
				tchgEX1_2.play();
			else if(one_EX.student[0].alive==false&&one_EX.student[1].alive==false&&one_EX.student[2].alive==false) {
				eneryteachday.day = eneryteachday.day + 2;
				eneryteachday.refresh_day_and_talentpoint();
				tchgEX1_1.play();
			}
			else if(one_EX.round==0) {
				eneryteachday.day = eneryteachday.day + 2;
				eneryteachday.refresh_day_and_talentpoint();
				tchgEX1_1.play();
			}
				
		});
		//////////////////////////////////////////////////
		f_2.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			f_2.startaction();
			tchg_e2_1.play();
		});
		exam2_1.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			two_one.setBattle();
			tchg_b2_1.play();
		});
		two_one.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(two_one.enemy[0].alive==false&&two_one.enemy[1].alive==false&&two_one.enemy[2].alive==false)
				tchg_e2_2.play();
			else if(two_one.student[0].alive==false&&two_one.student[1].alive==false&&two_one.student[2].alive==false)
				tchg_e2_2.play();
			else if(two_one.round==0)
				tchg_e2_2.play();
			two_one.score = (int)(((4500*((two_one.student[0].hp + two_one.student[1].hp + two_one.student[2].hp)*1.0/
					(two_one.student[0].maxhp + two_one.student[1].maxhp + two_one.student[2].maxhp)*1.0))-
					(2250*((two_one.enemy[0].hp + two_one.enemy[1].hp + two_one.enemy[2].hp)*1.0/
					(two_one.enemy[0].maxhp.intValue() + two_one.enemy[1].maxhp.intValue() + two_one.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+two_one.round*0.1));
			exam2_2.setscore(two_one.score);
		});
		exam2_2.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			two_two.setBattle();
			tchg_b2_2.play();
		});
		two_two.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(two_two.enemy[0].alive==false&&two_two.enemy[1].alive==false&&two_two.enemy[2].alive==false)
				tchg_e2_3.play();
			else if(two_two.student[0].alive==false&&two_two.student[1].alive==false&&two_two.student[2].alive==false)
				tchg_e2_3.play();
			else if(two_two.round==0)
				tchg_e2_3.play();
			two_two.score = (int)(((4500*((two_two.student[0].hp + two_two.student[1].hp + two_two.student[2].hp)*1.0/
					(two_two.student[0].maxhp + two_two.student[1].maxhp + two_two.student[2].maxhp)*1.0))-
					(2250*((two_two.enemy[0].hp + two_two.enemy[1].hp + two_two.enemy[2].hp)*1.0/
					(two_two.enemy[0].maxhp.intValue() + two_two.enemy[1].maxhp.intValue() + two_two.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+two_two.round*0.1));
			exam2_3.setscore(two_one.score+two_two.score);
		});
		exam2_3.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			two_three.setBattle();
			tchg_b2_3.play();
		});
		two_three.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(two_three.enemy[0].alive==false&&two_three.enemy[1].alive==false&&two_three.enemy[2].alive==false)
				tchg_e2_4.play();
			else if(two_three.student[0].alive==false&&two_three.student[1].alive==false&&two_three.student[2].alive==false)
				tchg_e2_4.play();
			else if(two_three.round==0)
				tchg_e2_4.play();
			two_three.score = (int)(((4500*((two_three.student[0].hp + two_three.student[1].hp + two_three.student[2].hp)*1.0/
					(two_three.student[0].maxhp + two_three.student[1].maxhp + two_three.student[2].maxhp)*1.0))-
					(2250*((two_three.enemy[0].hp + two_three.enemy[1].hp + two_three.enemy[2].hp)*1.0/
					(two_three.enemy[0].maxhp.intValue() + two_three.enemy[1].maxhp.intValue() + two_three.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+two_three.round*0.1));
			exam2_4.setscore(two_one.score+two_two.score+two_three.score);
		});
		exam2_4.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			two_four.setBattle();
			tchg_b2_4.play();
		});
		two_four.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(two_four.enemy[0].alive==false&&two_four.enemy[1].alive==false&&two_four.enemy[2].alive==false) {
				if(two_one.score+two_two.score+two_three.score+two_four.score<12000) {
					exam2_5.goback.setVisible(true);
					exam2_5.start.setVisible(false);
					tchg_e2_5.play();
				}
				else if(two_one.score+two_two.score+two_three.score+two_four.score>=12000)
					tchg_e2_EX.play();
			}	
			else if(two_four.student[0].alive==false&&two_four.student[1].alive==false&&two_four.student[2].alive==false) {
				 if(two_one.score+two_two.score+two_three.score+two_four.score>=12000)
					 tchg_e2_EX.play();
				else if(two_one.score+two_two.score+two_three.score+two_four.score<12000) {
					exam2_5.goback.setVisible(true);
					exam2_5.start.setVisible(false);
					tchg_e2_5.play();
				}
			}
			else if(two_four.round==0) {
				if(two_one.score+two_two.score+two_three.score+two_four.score<12000) {
					exam2_5.goback.setVisible(true);
					exam2_5.start.setVisible(false);
					tchg_e2_5.play();
				}
				else if(two_one.score+two_two.score+two_three.score+two_four.score>=12000)
					tchg_e2_EX.play();
			}
			two_four.score = (int)(((4500*((two_four.student[0].hp + two_four.student[1].hp + two_four.student[2].hp)*1.0/
					(two_four.student[0].maxhp + two_four.student[1].maxhp + two_four.student[2].maxhp)*1.0))-
					(2250*((two_four.enemy[0].hp + two_four.enemy[1].hp + two_four.enemy[2].hp)*1.0/
					(two_four.enemy[0].maxhp.intValue() + two_four.enemy[1].maxhp.intValue() + two_four.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+two_three.round*0.1));
			exam2_5.setscore(two_one.score+two_two.score+two_three.score+two_four.score);
			exam2_EX.setscore(two_one.score+two_two.score+two_three.score+two_four.score);
		});
		exam2_5.goback.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			eneryteachday.day = eneryteachday.day + 2;
			eneryteachday.refresh_day_and_talentpoint();
			tchg2_back.play();
		});
		exam2_EX.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			two_EX.setBattle();
			two_EX.img_enemy[2].setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_2.png")));
			two_EX.enemy[2].exam.setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_2.png")));
			tchg_b2_EX.play();
		});
		two_EX.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(two_EX.enemy[0].alive==false&&two_EX.enemy[1].alive==false&&two_EX.enemy[2].alive==false) {
				if(dif.intValue()==2)
					tchgEX2_3.play();
				else
					tchgEX2_2.play();
			}
			else if(two_EX.student[0].alive==false&&two_EX.student[1].alive==false&&two_EX.student[2].alive==false) {
				eneryteachday.day = eneryteachday.day + 2;
				eneryteachday.refresh_day_and_talentpoint();
				tchgEX2_1.play();
			}
			else if(two_EX.round==0) {
				eneryteachday.day = eneryteachday.day + 2;
				eneryteachday.refresh_day_and_talentpoint();
				tchgEX2_1.play();
			}
		});
		//////////////////////////////////////////////////
		f_3.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			f_3.startaction();
			tchg_e3_1.play();
		});
		exam3_1.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			three_one.setBattle();
			tchg_b3_1.play();
		});
		three_one.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(three_one.enemy[0].alive==false&&three_one.enemy[1].alive==false&&three_one.enemy[2].alive==false)
				tchg_e3_2.play();
			else if(three_one.student[0].alive==false&&three_one.student[1].alive==false&&three_one.student[2].alive==false)
				tchg_e3_2.play();
			else if(three_one.round==0)
				tchg_e3_2.play();
			three_one.score = (int)(((4500*((three_one.student[0].hp + three_one.student[1].hp + three_one.student[2].hp)*1.0/
					(three_one.student[0].maxhp + three_one.student[1].maxhp + three_one.student[2].maxhp)*1.0))-
					(2250*((three_one.enemy[0].hp + three_one.enemy[1].hp + three_one.enemy[2].hp)*1.0/
					(three_one.enemy[0].maxhp.intValue() + three_one.enemy[1].maxhp.intValue() + three_one.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+three_one.round*0.1));
			exam3_2.setscore(three_one.score);
		});
		exam3_2.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			three_two.setBattle();
			tchg_b3_2.play();
		});
		three_two.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(three_two.enemy[0].alive==false&&three_two.enemy[1].alive==false&&three_two.enemy[2].alive==false)
				tchg_e3_3.play();
			else if(three_two.student[0].alive==false&&three_two.student[1].alive==false&&three_two.student[2].alive==false)
				tchg_e3_3.play();
			else if(three_two.round==0)
				tchg_e3_3.play();
			three_two.score = (int)(((4500*((three_two.student[0].hp + three_two.student[1].hp + three_two.student[2].hp)*1.0/
					(three_two.student[0].maxhp + three_two.student[1].maxhp + three_two.student[2].maxhp)*1.0))-
					(2250*((three_two.enemy[0].hp + three_two.enemy[1].hp + three_two.enemy[2].hp)*1.0/
					(three_two.enemy[0].maxhp.intValue() + three_two.enemy[1].maxhp.intValue() + three_two.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+three_two.round*0.1));
			exam3_3.setscore(three_one.score+three_two.score);
		});
		exam3_3.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			three_three.setBattle();
			tchg_b3_3.play();
		});
		three_three.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(three_three.enemy[0].alive==false&&three_three.enemy[1].alive==false&&three_three.enemy[2].alive==false)
				tchg_e3_4.play();
			else if(three_three.student[0].alive==false&&three_three.student[1].alive==false&&three_three.student[2].alive==false)
				tchg_e3_4.play();
			else if(three_three.round==0)
				tchg_e3_4.play();
			three_three.score = (int)(((4500*((three_three.student[0].hp + three_three.student[1].hp + three_three.student[2].hp)*1.0/
					(three_three.student[0].maxhp + three_three.student[1].maxhp + three_three.student[2].maxhp)*1.0))-
					(2250*((three_three.enemy[0].hp + three_three.enemy[1].hp + three_three.enemy[2].hp)*1.0/
					(three_three.enemy[0].maxhp.intValue() + three_three.enemy[1].maxhp.intValue() + three_three.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+three_three.round*0.1));
			exam3_4.setscore(three_one.score+three_two.score+three_three.score);
		});
		exam3_4.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			three_four.setBattle();
			tchg_b3_4.play();
		});
		three_four.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(three_four.enemy[0].alive==false&&three_four.enemy[1].alive==false&&three_four.enemy[2].alive==false) {
				if(three_one.score+three_two.score+three_three.score+three_four.score<12000) {
					exam3_5.goback.setVisible(true);
					exam3_5.start.setVisible(false);
					tchg_e3_5.play();
				}
				else if(three_one.score+three_two.score+three_three.score+three_four.score>=12000)
					tchg_e3_EX.play();
			}	
			else if(three_four.student[0].alive==false&&three_four.student[1].alive==false&&three_four.student[2].alive==false) {
				 if(three_one.score+three_two.score+three_three.score+three_four.score>=12000)
					 tchg_e3_EX.play();
				else if(three_one.score+three_two.score+three_three.score+three_four.score<12000) {
					exam3_5.goback.setVisible(true);
					exam3_5.start.setVisible(false);
					tchg_e3_5.play();
				}
			}
			else if(three_four.round==0) {
				if(three_one.score+three_two.score+three_three.score+three_four.score<12000) {
					exam3_5.goback.setVisible(true);
					exam3_5.start.setVisible(false);
					tchg_e3_5.play();
				}
				else if(three_one.score+three_two.score+three_three.score+three_four.score>=12000)
					tchg_e3_EX.play();
			}
			three_four.score = (int)(((4500*((three_four.student[0].hp + three_four.student[1].hp + three_four.student[2].hp)*1.0/
					(three_four.student[0].maxhp + three_four.student[1].maxhp + three_four.student[2].maxhp)*1.0))-
					(2250*((three_four.enemy[0].hp + three_four.enemy[1].hp + three_four.enemy[2].hp)*1.0/
					(three_four.enemy[0].maxhp.intValue() + three_four.enemy[1].maxhp.intValue() + three_four.enemy[2].maxhp.intValue())*1.0)))
					*(0.5+three_three.round*0.1));
			exam3_5.setscore(three_one.score+three_two.score+three_three.score+three_four.score);
			exam3_EX.setscore(three_one.score+three_two.score+three_three.score+three_four.score);
		});
		exam3_5.goback.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			eneryteachday.day = eneryteachday.day + 2;
			eneryteachday.refresh_day_and_talentpoint();
			tchg3_back.play();
		});
		exam3_EX.start.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			for(int i = 0;i < 3;i++)
				day.used_student[i].refresh();
			three_EX.setBattle();
			three_EX.img_enemy[2].setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_2.png")));
			two_EX.enemy[2].exam.setImage(new Image(getClass().getResourceAsStream("picture/EX_enemy/EX_enemy_2.png")));
			tchg_b3_EX.play();
		});
		three_EX.next.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			if(three_EX.enemy[0].alive==false&&three_EX.enemy[1].alive==false&&three_EX.enemy[2].alive==false) {
				if(dif.intValue()==2)
					tchgEX3_3.play();
				else
					tchgEX3_2.play();
			}
			else if(three_EX.student[0].alive==false&&three_EX.student[1].alive==false&&three_EX.student[2].alive==false)
				tchgEX3_1.play();
			else if(three_EX.round==0)
				tchgEX3_1.play();
			eneryteachday.day = eneryteachday.day + 2;
		});
		firstscene.exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			mainStage.close();
		});
		normalwin.exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			mainStage.close();
		});
		hardwin.exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			mainStage.close();
		});
		lose.exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			mainStage.close();
		});
		oneweekwin.exit.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
			mainStage.close();
		});
		mainStage.show();
	}
	public void battlepanein(AnchorPane e,AnchorPane s) {
		Timeline t = new Timeline(new KeyFrame(Duration.millis(1),(a)-> {
			e.setLayoutX(e.getLayoutX()+5.03);
			s.setLayoutX(s.getLayoutX()-5.03);
	    })); 
		t.setCycleCount(100);
		t.play();
	}
	public void setenemy() {
		///////////////////////////////////
		hp1_1_1 = Bindings.add(Bindings.multiply(hprate, dif), 600);
		atk1_1_1 = Bindings.add(Bindings.multiply(atkrate, dif), 350);
		hp1_1_2 = Bindings.add(Bindings.multiply(hprate, dif), 650);
		atk1_1_2 = Bindings.add(Bindings.multiply(atkrate, dif), 300);
		hp1_1_3 = Bindings.add(Bindings.multiply(hprate, dif), 600);
		atk1_1_3 = Bindings.add(Bindings.multiply(atkrate, dif), 350);
		/////////////////////////
		hp1_2_1 = Bindings.add(Bindings.multiply(hprate, dif), 550);
		atk1_2_1 = Bindings.add(Bindings.multiply(atkrate, dif), 320);
		hp1_2_2 = Bindings.add(Bindings.multiply(hprate, dif), 550);
		atk1_2_2 = Bindings.add(Bindings.multiply(atkrate, dif), 300);
		hp1_2_3 = Bindings.add(Bindings.multiply(hprate, dif), 550);
		atk1_2_3 = Bindings.add(Bindings.multiply(atkrate, dif), 320);
		/////////////////////////
		hp1_3_1 = Bindings.add(Bindings.multiply(hprate, dif), 600);
		atk1_3_1 = Bindings.add(Bindings.multiply(atkrate, dif), 150);
		hp1_3_2 = Bindings.add(Bindings.multiply(hprate, dif), 450);
		atk1_3_2 = Bindings.add(Bindings.multiply(atkrate, dif), 250);
		hp1_3_3 = Bindings.add(Bindings.multiply(hprate, dif), 400);
		atk1_3_3 = Bindings.add(Bindings.multiply(atkrate, dif), 200);
		/////////////////////////
		hp1_4_1 = Bindings.add(Bindings.multiply(hprate, dif), 650);
		atk1_4_1 = Bindings.add(Bindings.multiply(atkrate, dif), 250);
		hp1_4_2 = Bindings.add(Bindings.multiply(hprate, dif), 400);
		atk1_4_2 = Bindings.add(Bindings.multiply(atkrate, dif), 200);
		hp1_4_3 = Bindings.add(Bindings.multiply(hprate, dif), 500);
		atk1_4_3 = Bindings.add(Bindings.multiply(atkrate, dif), 350);
		///////////////////////
		hp1_EX_1 = Bindings.add(Bindings.multiply(hprate, dif), 500);
		atk1_EX_1 = Bindings.add(Bindings.multiply(atkrate, dif), 300);
		hp1_EX_2 = Bindings.add(Bindings.multiply(hprate, dif), 500);
		atk1_EX_2 = Bindings.add(Bindings.multiply(atkrate, dif), 300);
		hp1_EX_3 = Bindings.add(Bindings.multiply(hprate, dif), 1000);
		atk1_EX_3 = Bindings.add(Bindings.multiply(atkrate, dif), 700);
		///////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////
		hp2_1_1 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_1_1 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		hp2_1_2 = Bindings.add(Bindings.multiply(hprate, dif), 1300);
		atk2_1_2 = Bindings.add(Bindings.multiply(atkrate, dif), 700);
		hp2_1_3 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_1_3 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		/////////////////////////
		hp2_2_1 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_2_1 = Bindings.add(Bindings.multiply(atkrate, dif), 740);
		hp2_2_2 = Bindings.add(Bindings.multiply(hprate, dif), 1250);
		atk2_2_2 = Bindings.add(Bindings.multiply(atkrate, dif), 700);
		hp2_2_3 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_2_3 = Bindings.add(Bindings.multiply(atkrate, dif), 740);
		/////////////////////////
		hp2_3_1 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_3_1 = Bindings.add(Bindings.multiply(atkrate, dif), 500);
		hp2_3_2 = Bindings.add(Bindings.multiply(hprate, dif), 900);
		atk2_3_2 = Bindings.add(Bindings.multiply(atkrate, dif), 700);
		hp2_3_3 = Bindings.add(Bindings.multiply(hprate, dif), 800);
		atk2_3_3 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		/////////////////////////
		hp2_4_1 = Bindings.add(Bindings.multiply(hprate, dif), 1500);
		atk2_4_1 = Bindings.add(Bindings.multiply(atkrate, dif), 600);
		hp2_4_2 = Bindings.add(Bindings.multiply(hprate, dif), 800);
		atk2_4_2 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		hp2_4_3 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk2_4_3 = Bindings.add(Bindings.multiply(atkrate, dif), 700);
		///////////////////////
		hp2_EX_1 = Bindings.add(Bindings.multiply(hprate, dif), 1500);
		atk2_EX_1 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		hp2_EX_2 = Bindings.add(Bindings.multiply(hprate, dif), 1500);
		atk2_EX_2 = Bindings.add(Bindings.multiply(atkrate, dif), 800);
		hp2_EX_3 = Bindings.add(Bindings.multiply(hprate, dif), 2500);
		atk2_EX_3 = Bindings.add(Bindings.multiply(atkrate, dif), 1600);
		///////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////
		hp3_1_1 = Bindings.add(Bindings.multiply(hprate, dif), 2000);
		atk3_1_1 = Bindings.add(Bindings.multiply(atkrate, dif), 1500);
		hp3_1_2 = Bindings.add(Bindings.multiply(hprate, dif), 2500);
		atk3_1_2 = Bindings.add(Bindings.multiply(atkrate, dif), 1300);
		hp3_1_3 = Bindings.add(Bindings.multiply(hprate, dif), 2000);
		atk3_1_3 = Bindings.add(Bindings.multiply(atkrate, dif), 1400);
		/////////////////////////
		hp3_2_1 = Bindings.add(Bindings.multiply(hprate, dif), 2400);
		atk3_2_1 = Bindings.add(Bindings.multiply(atkrate, dif), 1600);
		hp3_2_2 = Bindings.add(Bindings.multiply(hprate, dif), 2500);
		atk3_2_2 = Bindings.add(Bindings.multiply(atkrate, dif), 1400);
		hp3_2_3 = Bindings.add(Bindings.multiply(hprate, dif), 2400);
		atk3_2_3 = Bindings.add(Bindings.multiply(atkrate, dif), 1500);
		/////////////////////////
		hp3_3_1 = Bindings.add(Bindings.multiply(hprate, dif), 2000);
		atk3_3_1 = Bindings.add(Bindings.multiply(atkrate, dif), 1000);
		hp3_3_2 = Bindings.add(Bindings.multiply(hprate, dif), 1800);
		atk3_3_2 = Bindings.add(Bindings.multiply(atkrate, dif), 1500);
		hp3_3_3 = Bindings.add(Bindings.multiply(hprate, dif), 1800);
		atk3_3_3 = Bindings.add(Bindings.multiply(atkrate, dif), 1200);
		/////////////////////////
		hp3_4_1 = Bindings.add(Bindings.multiply(hprate, dif), 1600);
		atk3_4_1 = Bindings.add(Bindings.multiply(atkrate, dif), 1500);
		hp3_4_2 = Bindings.add(Bindings.multiply(hprate, dif), 1200);
		atk3_4_2 = Bindings.add(Bindings.multiply(atkrate, dif), 1200);
		hp3_4_3 = Bindings.add(Bindings.multiply(hprate, dif), 1400);
		atk3_4_3 = Bindings.add(Bindings.multiply(atkrate, dif), 1000);
		///////////////////////
		hp3_EX_1 = Bindings.add(Bindings.multiply(hprate, dif), 2500);
		atk3_EX_1 = Bindings.add(Bindings.multiply(atkrate, dif), 1600);
		hp3_EX_2 = Bindings.add(Bindings.multiply(hprate, dif), 2500);
		atk3_EX_2 = Bindings.add(Bindings.multiply(atkrate, dif), 1600);
		hp3_EX_3 = Bindings.add(Bindings.multiply(hprate, dif), 4000);
		atk3_EX_3 = Bindings.add(Bindings.multiply(atkrate, dif), 2000);
	}
	///////////////////////////
	public void outputfile() {
		String alldata = new String(clearout1+" "+clearout2);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("src/Final/save/clear.txt");
			fos.write(alldata.getBytes("UTF-8"));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static IntegerProperty dif = new SimpleIntegerProperty(0);
	public IntegerProperty hprate = new SimpleIntegerProperty(100);
	public IntegerProperty atkrate = new SimpleIntegerProperty(50);
	public NumberBinding hp1_1_1 ;
	public NumberBinding atk1_1_1;
	public NumberBinding hp1_1_2 ;
	public NumberBinding atk1_1_2;
	public NumberBinding hp1_1_3 ;
	public NumberBinding atk1_1_3;
	public NumberBinding hp1_2_1 ;
	public NumberBinding atk1_2_1;
	public NumberBinding hp1_2_2 ;
	public NumberBinding atk1_2_2;
	public NumberBinding hp1_2_3 ;
	public NumberBinding atk1_2_3;
	public NumberBinding hp1_3_1 ;
	public NumberBinding atk1_3_1;
	public NumberBinding hp1_3_2 ;
	public NumberBinding atk1_3_2;
	public NumberBinding hp1_3_3 ;
	public NumberBinding atk1_3_3;
	public NumberBinding hp1_4_1 ;
	public NumberBinding atk1_4_1;
	public NumberBinding hp1_4_2 ;
	public NumberBinding atk1_4_2;
	public NumberBinding hp1_4_3 ;
	public NumberBinding atk1_4_3;
	public NumberBinding hp1_EX_1 ;
	public NumberBinding atk1_EX_1;
	public NumberBinding hp1_EX_2 ;
	public NumberBinding atk1_EX_2;
	public NumberBinding hp1_EX_3 ;
	public NumberBinding atk1_EX_3;
	///////////////////////
	public NumberBinding hp2_1_1 ;
	public NumberBinding atk2_1_1;
	public NumberBinding hp2_1_2 ;
	public NumberBinding atk2_1_2;
	public NumberBinding hp2_1_3 ;
	public NumberBinding atk2_1_3;
	public NumberBinding hp2_2_1 ;
	public NumberBinding atk2_2_1;
	public NumberBinding hp2_2_2 ;
	public NumberBinding atk2_2_2;
	public NumberBinding hp2_2_3 ;
	public NumberBinding atk2_2_3;
	public NumberBinding hp2_3_1 ;
	public NumberBinding atk2_3_1;
	public NumberBinding hp2_3_2 ;
	public NumberBinding atk2_3_2;
	public NumberBinding hp2_3_3 ;
	public NumberBinding atk2_3_3;
	public NumberBinding hp2_4_1 ;
	public NumberBinding atk2_4_1;
	public NumberBinding hp2_4_2 ;
	public NumberBinding atk2_4_2;
	public NumberBinding hp2_4_3 ;
	public NumberBinding atk2_4_3;
	public NumberBinding hp2_EX_1 ;
	public NumberBinding atk2_EX_1;
	public NumberBinding hp2_EX_2 ;
	public NumberBinding atk2_EX_2;
	public NumberBinding hp2_EX_3 ;
	public NumberBinding atk2_EX_3;
	///////////////////////
	public NumberBinding hp3_1_1 ;
	public NumberBinding atk3_1_1;
	public NumberBinding hp3_1_2 ;
	public NumberBinding atk3_1_2;
	public NumberBinding hp3_1_3 ;
	public NumberBinding atk3_1_3;
	public NumberBinding hp3_2_1 ;
	public NumberBinding atk3_2_1;
	public NumberBinding hp3_2_2 ;
	public NumberBinding atk3_2_2;
	public NumberBinding hp3_2_3 ;
	public NumberBinding atk3_2_3;
	public NumberBinding hp3_3_1 ;
	public NumberBinding atk3_3_1;
	public NumberBinding hp3_3_2 ;
	public NumberBinding atk3_3_2;
	public NumberBinding hp3_3_3 ;
	public NumberBinding atk3_3_3;
	public NumberBinding hp3_4_1 ;
	public NumberBinding atk3_4_1;
	public NumberBinding hp3_4_2 ;
	public NumberBinding atk3_4_2;
	public NumberBinding hp3_4_3 ;
	public NumberBinding atk3_4_3;
	public NumberBinding hp3_EX_1 ;
	public NumberBinding atk3_EX_1;
	public NumberBinding hp3_EX_2 ;
	public NumberBinding atk3_EX_2;
	public NumberBinding hp3_EX_3 ;
	public NumberBinding atk3_EX_3;
	///////////////////////////
	public static int students;
	public boolean startflag = false;
	public boolean choose_student[] = new boolean[10];
	public AudioClip Error = new AudioClip(getClass().getResource("SE/Buzzer1.mp3").toString());
	public AudioClip Gameover = new AudioClip(getClass().getResource("SE/Gameover.mp3").toString());
	public AudioClip Cancel = new AudioClip(getClass().getResource("SE/Cancel.mp3").toString());
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
	public AudioClip Click = new AudioClip(getClass().getResource("SE/Chime2.mp3").toString());
	public AudioClip Choose2 = new AudioClip(getClass().getResource("SE/Decision2.mp3").toString());
	public AudioClip Switch = new AudioClip(getClass().getResource("SE/Switch02.mp3").toString());
	public Button start = new Button();
	public Button start_1 = new Button();
	public Button tutorial = new Button();
	public Button load = new Button();
	public Button exit = new Button();
	public Button back = new Button();
	public Button character[] = new Button[10];
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/classroom.png")));
	public ImageView c_background = new ImageView(new Image(getClass().getResourceAsStream("picture/character_background.jpg")));
	public ImageView img_start_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/started_normal.png")));
	public ImageView img_start_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/started_pressed.png")));
	public ImageView img_start_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/started_touch.png")));
	public ImageView img_start_normal_1 = new ImageView(new Image(getClass().getResourceAsStream("picture/started_normal.png")));
	public ImageView img_start_pressed_1 = new ImageView(new Image(getClass().getResourceAsStream("picture/started_pressed.png")));
	public ImageView img_start_touch_1 = new ImageView(new Image(getClass().getResourceAsStream("picture/started_touch.png")));
	public ImageView img_tutorial_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/tutorial_normal.png")));
	public ImageView img_tutorial_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/tutorial_pressed.png")));
	public ImageView img_tutorial_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/tutorial_touch.png")));
	public ImageView img_load_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/load_normal.png")));
	public ImageView img_load_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/load_pressed.png")));
	public ImageView img_load_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/load_touch.png")));
	public ImageView img_exit_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_normal.png")));
	public ImageView img_exit_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_pressed.png")));
	public ImageView img_exit_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/exit_touch.png")));
	public ImageView img_back_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/back_normal.png")));
	public ImageView img_back_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/back_pressed.png")));
	public ImageView img_back_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/back_touch.png")));
	/////////////////////////////////////////////////////
	public ImageView img_talent_false_normal[] = new ImageView[15];
	public ImageView img_talent_false_choose[] = new ImageView[15];
	public ImageView img_talent_true_normal[] = new ImageView[15];
	public ImageView img_talent_true_choose[] = new ImageView[15];
	public ImageView img_unlock_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/talent/unlock_normal.png")));
	public ImageView img_unlock_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/talent/unlock_pressed.png")));
	public ImageView img_unlock_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/talent/unlock_touch.png")));
	public ImageView img_talent_background = new ImageView(new Image(getClass().getResourceAsStream("picture/talent/talent_background.png")));
	public boolean talent_use[] = new boolean[15];
	//////////////////////////////////////////////////
	public AnchorPane anchor = new AnchorPane();
	public AnchorPane main1 = new AnchorPane();
	public AnchorPane main2 = new AnchorPane();
	public ImageView img_character[] = new ImageView[10];
	public Image icharacter[] = new Image[10];
	public ImageView img_character_touch[] = new ImageView[10];
	public Image icharacter_touch[] = new Image[10];
	public ImageView img_character_choose[] = new ImageView[10];
	public Image icharacter_choose[] = new Image[10];
	public ImageView img_character_intro[] = new ImageView[10];
	public Image icharacter_intro[] = new Image[10];
	public Timeline t = new Timeline();
	public Timeline t2 = new Timeline();
	//////////////////////////////////////
	public Timeline tchg = new Timeline();
	public Timeline tchg1 = new Timeline();
	public Timeline tchg2 = new Timeline();
	public Timeline tchg_b1_0 = new Timeline();
	public Timeline tchg_b1_1 = new Timeline();
	public Timeline tchg_b1_2 = new Timeline();
	public Timeline tchg_b1_3 = new Timeline();
	public Timeline tchg_b1_4 = new Timeline();
	public Timeline tchg_b1_EX = new Timeline();
	public Timeline tchg_e1_1 = new Timeline();
	public Timeline tchg_e1_2 = new Timeline();
	public Timeline tchg_e1_3 = new Timeline();
	public Timeline tchg_e1_4 = new Timeline();
	public Timeline tchg_e1_5 = new Timeline();
	public Timeline tchg_e1_EX = new Timeline();
	public Timeline tchgEX1_1 = new Timeline();
	public Timeline tchgEX1_2 = new Timeline();
	public Timeline tchg1_back = new Timeline();
	///////////////////////////////////
	public Timeline tchg_b2_0 = new Timeline();
	public Timeline tchg_b2_1 = new Timeline();
	public Timeline tchg_b2_2 = new Timeline();
	public Timeline tchg_b2_3 = new Timeline();
	public Timeline tchg_b2_4 = new Timeline();
	public Timeline tchg_b2_EX = new Timeline();
	public Timeline tchg_e2_1 = new Timeline();
	public Timeline tchg_e2_2 = new Timeline();
	public Timeline tchg_e2_3 = new Timeline();
	public Timeline tchg_e2_4 = new Timeline();
	public Timeline tchg_e2_5 = new Timeline();
	public Timeline tchg_e2_EX = new Timeline();
	public Timeline tchgEX2_1 = new Timeline();
	public Timeline tchgEX2_2 = new Timeline();
	public Timeline tchgEX2_3 = new Timeline();
	public Timeline tchg2_back = new Timeline();
	/////////////////////////////////
	public Timeline tchg_b3_0 = new Timeline();
	public Timeline tchg_b3_1 = new Timeline();
	public Timeline tchg_b3_2 = new Timeline();
	public Timeline tchg_b3_3 = new Timeline();
	public Timeline tchg_b3_4 = new Timeline();
	public Timeline tchg_b3_EX = new Timeline();
	public Timeline tchg_e3_1 = new Timeline();
	public Timeline tchg_e3_2 = new Timeline();
	public Timeline tchg_e3_3 = new Timeline();
	public Timeline tchg_e3_4 = new Timeline();
	public Timeline tchg_e3_5 = new Timeline();
	public Timeline tchg_e3_EX = new Timeline();
	public Timeline tchgEX3_1 = new Timeline();
	public Timeline tchgEX3_2 = new Timeline();
	public Timeline tchgEX3_3 = new Timeline();
	public Timeline tchg3_back = new Timeline();
	//////////////////////////////////////
	public ImageView img_easy_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/EASY_normal.png")));
	public ImageView img_easy_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/EASY_pressed.png")));
	public ImageView img_easy_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/EASY_touch.png")));
	public ImageView img_normal_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/NORMAL_normal.png")));
	public ImageView img_normal_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/NORMAL_pressed.png")));
	public ImageView img_normal_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/NORMAL_touch.png")));
	public ImageView img_hard_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/HARD_normal.png")));
	public ImageView img_hard_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/HARD_pressed.png")));
	public ImageView img_hard_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/HARD_touch.png")));
	public ImageView img_dif_background = new ImageView(new Image(getClass().getResourceAsStream("picture/dif/background.jpg")));
	/////////////////////////////////
	public ImageView img_calendar_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/calendar_normal.png")));
	public ImageView img_calendar_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/calendar_pressed.png")));
	public ImageView img_calendar_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/calendar_touch.png")));
	public ImageView img_checkdata_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_normal.png")));
	public ImageView img_checkdata_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_pressed.png")));
	public ImageView img_checkdata_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/checkdata_touch.png")));
	public ImageView img_s_name_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/s_name_normal.png")));
	public ImageView img_s_name_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/s_name_pressed.png")));
	public ImageView img_s_name_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/s_name_touch.png")));
	public ImageView img_set_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/set_normal.png")));
	public ImageView img_set_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/set_pressed.png")));
	public ImageView img_set_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/set_touch.png")));
	public ImageView img_talent_normal = new ImageView(new Image(getClass().getResourceAsStream("picture/day/talent_normal.png")));
	public ImageView img_talent_pressed = new ImageView(new Image(getClass().getResourceAsStream("picture/day/talent_pressed.png")));
	public ImageView img_talent_touch = new ImageView(new Image(getClass().getResourceAsStream("picture/day/talent_touch.png")));
	public ImageView day_background = new ImageView(new Image(getClass().getResourceAsStream("picture/day/day_background.png")));
	public AudioClip normal_battle = new AudioClip(getClass().getResource("BGM/normal_battle.mp3").toString());
	public AudioClip boss1 = new AudioClip(getClass().getResource("BGM/boss1.mp3").toString());
	public AudioClip boss2 = new AudioClip(getClass().getResource("BGM/boss2.mp3").toString());
	public AudioClip boss3 = new AudioClip(getClass().getResource("BGM/boss3.mp3").toString());
	public AudioClip teach = new AudioClip(getClass().getResource("BGM/teach.mp3").toString());
	public AudioClip title = new AudioClip(getClass().getResource("BGM/title.mp3").toString());
	public AudioClip win = new AudioClip(getClass().getResource("BGM/win.mp3").toString());
}
