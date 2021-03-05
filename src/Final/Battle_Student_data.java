package Final;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class Battle_Student_data {
	public int maxhp;
	public int hp;
	public int math;
	public int language;
	public int program;
	public int atknum;
	public int selfrecover;
	public int allrecover;
	public double critrate;
	public double critdmg;
	public boolean mathatk;
	public boolean languageatk;
	public boolean programatk;
	public boolean alive = true;
	public double mathrate;
	public double languagerate;
	public double programrate;
	public ImageView img_student;
	public int allstudentplus = 0;
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/img_background.png")));
	public ImageView img_back = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/battle_role_back.png")));
	public AnchorPane pane = new AnchorPane();
	public Text hp_text = new Text();
	public Text math_text = new Text();
	public Text language_text = new Text();
	public Text program_text = new Text();
	public Rectangle maxhp_back = new Rectangle();
	public Rectangle nowhp = new Rectangle();
	public Battle_Student_data(){
	}
	public Battle_Student_data(Student student){
		maxhp = student.final_hp;
		hp = student.final_hp;
		math = student.final_math;
		language = student.final_language;
		program = student.final_program;
		selfrecover = student.final_selfrecover;
		allrecover = student.final_allrecover;
		atknum = student.final_atknum;
		critrate = student.final_critrate;
		critdmg = student.final_critdmg;
		mathatk = student.mathatk;
		programatk = student.programatk;
		languageatk = student.languageatk;
		mathrate = student.mathrate;
		languagerate = student.languagerate;
		programrate = student.programrate;
		allstudentplus = student.allstudentplus;
		img_student = new ImageView(student.img_student.getImage());
	}
	public void setbattledata() {
		background.setLayoutX(0);
		background.setLayoutY(0);
		img_back.setLayoutX(0);
		img_back.setLayoutY(0);
		hp_text.setText(hp+"/"+maxhp);
		hp_text.setStyle("-fx-font-size: 24px;");
		hp_text.setLayoutX(5);
		hp_text.setLayoutY(25);
		math_text.setText("數學："+math);
		math_text.setStyle("-fx-font-size: 24px;");
		math_text.setLayoutX(5);
		math_text.setLayoutY(55);
		language_text.setText("語文："+language);
		language_text.setStyle("-fx-font-size: 24px;");
		language_text.setLayoutX(5);
		language_text.setLayoutY(85);
		program_text.setText("程式："+program);
		program_text.setStyle("-fx-font-size: 24px;");
		program_text.setLayoutX(5);
		program_text.setLayoutY(115);
		maxhp_back.setHeight(5);
		maxhp_back.setWidth(152);
		maxhp_back.setLayoutX(0);
		maxhp_back.setLayoutY(0);
		maxhp_back.setFill(Color.RED);
		nowhp.setHeight(5);
		nowhp.setWidth(152);
		nowhp.setLayoutX(0);
		nowhp.setLayoutY(0);
		nowhp.setFill(Color.GREEN);
		img_student.setLayoutX(0);
		img_student.setLayoutY(130);
		pane.getChildren().addAll(background,hp_text,math_text,language_text,program_text,maxhp_back,nowhp,img_student,img_back);
	}
	public boolean crit(double critrate) {
		Random ran = new Random();
		int i = ran.nextInt(100)+1;
		if((int)(critrate*100)>=i)
			return true;
		else
			return false;
	}
	
	public void recoverself(){
		hp = hp + selfrecover;
		if(hp > maxhp)
			hp = maxhp;
	}
	public void allrecover(Battle_Student_data s1,Battle_Student_data s2) {
		hp = hp + allrecover;
		if(hp > maxhp)
			hp = maxhp;
		if(s1.alive==true)
			s1.hp = s1.hp + allrecover;
		if(s2.alive==true)
			s2.hp = s2.hp + allrecover;
		if(s1.hp > s1.maxhp)
			s1.hp = s1.maxhp;
		if(s2.hp > s2.maxhp)
			s2.hp = s2.maxhp;
	}
	public void refresh() {
		if(hp<=0) {
			hp=0;
			alive = false;
		}
		hp_text.setText(hp+"/"+maxhp);
		if(152*hp/maxhp>0)
			nowhp.setWidth(152*hp/maxhp);
		else
			nowhp.setWidth(0);
	}
	public void refreshdata(Student student) {
		maxhp = student.final_hp;
		hp = student.final_hp;
		math = student.final_math;
		language = student.final_language;
		program = student.final_program;
		selfrecover = student.final_selfrecover;
		allrecover = student.final_allrecover;
		atknum = student.final_atknum;
		critrate = student.final_critrate;
		critdmg = student.final_critdmg;
		mathatk = student.mathatk;
		programatk = student.programatk;
		languageatk = student.languageatk;
		mathrate = student.mathrate;
		languagerate = student.languagerate;
		programrate = student.programrate;
		allstudentplus = student.allstudentplus;
		img_student = new ImageView(student.img_student.getImage());
	}
	public AudioClip Choose = new AudioClip(getClass().getResource("SE/Decision1.mp3").toString());
}
