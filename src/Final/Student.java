package Final;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Student{
	public int hp;
	public int math;
	public int mathlearn;
	public int language;
	public int languagelearn;
	public int program;
	public int programlearn;
	public int atknum = 1;
	public int selfrecover = 0;
	public int allrecover = 0;
	public double critrate = 0;
	public double critdmg = 0;
	////////
	public int hpnow;
	////////
	public int final_hp;
	public int final_math;
	public int final_language;
	public int final_program;
	public int final_atknum;
	public int final_selfrecover = 0;
	public int final_allrecover = 0;
	public double final_critrate = 0;
	public double final_critdmg = 0;
	////////
	public int plushp = 0;
	public int plusmath = 0;
	public int pluslanguage = 0;
	public int plusprogram = 0;
	public int plusatknum = 0;
	public int plusselfrecover = 0;
	public int plusallrecover = 0;
	public boolean mathatk = false;
	public boolean languageatk = false;
	public boolean programatk = false;
	public double pluscritrate = 0;
	public double pluscritdmg = 0;
	public int allstudentplus = 0;
	public double mathrate = 1;
	public double languagerate = 1;
	public double programrate = 1;
	//////////
	public Text hp_text = new Text("體力："+final_hp);
	public Text math_text = new Text("數學："+final_math);
	public Text language_text = new Text("語文："+final_language);
	public Text program_text = new Text("程式："+final_program);
	public Text Skill[] = new Text[8];
	public ImageView img_student;
	public ImageView img_student_touch;
	public Student() {
	}
	public Student(int hp,int math,int mathlearn,int language,int languagelearn,
					int program,int programlearn,int atknum,ImageView img_student,
					ImageView img_student_touch,String skill1,String skill2,String skill3,String skill4){
		this.hp = hp;
		this.math = math;
		this.mathlearn =mathlearn;
		this.language = language;
		this.languagelearn = languagelearn;
		this.program = program;
		this.programlearn = programlearn;
		this.atknum = atknum;
		this.img_student = img_student;
		this.img_student_touch = img_student_touch;
		for(int i = 0;i < 4;i++) {
			Skill[i] = new Text();
		}
		Skill[0].setText(skill1);
		Skill[1].setText(skill2);
		Skill[2].setText(skill3);
		Skill[3].setText(skill4);
		for(int i = 4;i < 8;i++) {
			Skill[i] = new Text("--------------");
		}
		hpnow = hp;
	}
	public void addmath(double a) {
		math = math + (int)(mathlearn*a);
		hpnow = hpnow - 80;
	}
	public void addlanguage(double a) {
		language = language + (int)(languagelearn*a);
		hpnow = hpnow - 80;
	}
	public void addprogram(double a) {
		program = program + (int)(programlearn*a);
		hpnow = hpnow - 80;
	}
	public void addhpnow() {
		hpnow = hpnow + 100;
		if(hpnow > hp)
			hpnow = hp;
	}
	public void addhp() {
		hp = hp + 25;
	}
	public void refresh() {
		hpnow = hp;
		final_hp = hp + plushp;
		final_math = math + plusmath;
		final_language = language + pluslanguage;
		final_program = program + plusprogram;
		final_atknum = atknum + plusatknum;
		final_selfrecover = selfrecover + plusselfrecover;
		final_allrecover = allrecover + plusallrecover;
		final_critrate = critrate + pluscritrate;
		final_critdmg = critdmg + pluscritdmg;
		hp_text.setText("體力："+final_hp);
		math_text.setText("數學："+final_math);
		language_text.setText("語文："+final_language);
		program_text.setText("程式："+final_program);
	}
}
