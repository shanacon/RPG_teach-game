package Final;

import java.util.Random;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Battle_enemy_data {
	public NumberBinding maxhp;
	public int hp;
	public int subject;
	public NumberBinding atk;
	public int atknum;
	public int selfrecover;
	public int allrecover;
	public double critrate;
	public double critdmg;
	public boolean allatk = false;
	public boolean alive = true;
	public Text skill[] = new Text[4];
	public Text name = new Text();
	public Text hp_text = new Text();
	public Text atk_text = new Text();
	public AnchorPane pane = new AnchorPane();
	public Rectangle maxhp_back = new Rectangle();
	public Rectangle nowhp = new Rectangle();
	public ImageView background = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/img_background.png")));
	public ImageView img_back = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/battle_role_back.png")));
	public ImageView exam = new ImageView(new Image(getClass().getResourceAsStream("picture/battle/exam.png")));
	public Battle_enemy_data() {
		
	}
	public Battle_enemy_data(NumberBinding maxhp,int subject,NumberBinding atk,int atknum,int selfrecover,int allrecover,double critrate,double critdmg
			,boolean allatk,String skill1,String skill2,String skill3,String skill4,String name) {
		this.maxhp = maxhp;
		this.subject = subject;
		this.atk = atk;
		this.atknum = atknum;
		this.selfrecover = selfrecover;
		this.allrecover = allrecover;
		this.critrate = critrate;
		this.critdmg = critdmg;
		this.allatk = allatk;
		this.name.setText(name);
		for(int i = 0;i < 4;i++)
			skill[i] = new Text();
		skill[0].setText(skill1);
		skill[1].setText(skill2);
		skill[2].setText(skill3);
		skill[3].setText(skill4);
	}
	public void setbattledata() {
		hp = maxhp.intValue();
		background.setLayoutX(0);
		background.setLayoutY(0);
		img_back.setLayoutX(0);
		img_back.setLayoutY(0);
		hp_text.setText(hp+"/"+maxhp.intValue());
		hp_text.setStyle("-fx-font-size: 24px;");
		hp_text.setLayoutX(5);
		hp_text.setLayoutY(25);
		atk_text.setText("§ðÀ»¤O¡G"+atk.intValue());
		atk_text.setStyle("-fx-font-size: 24px;");
		atk_text.setLayoutX(5);
		atk_text.setLayoutY(55);
		name.setText("¬ì¥Ø¡G"+name.getText());
		name.setStyle("-fx-font-size: 20px;");
		name.setLayoutX(5);
		name.setLayoutY(85);
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
		exam.setLayoutX(0);
		exam.setLayoutY(163);
		pane.getChildren().addAll(background,hp_text,atk_text,name,maxhp_back,nowhp,exam,img_back);
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
		if(hp > maxhp.intValue())
			hp = maxhp.intValue();
	}
	public void allrecover(Battle_enemy_data s1,Battle_enemy_data s2) {
		hp = hp + allrecover;
		if(hp > maxhp.intValue())
			hp = maxhp.intValue();
		if(s1.alive==true)
			s1.hp = s1.hp + allrecover;
		if(s2.alive==true)
			s2.hp = s2.hp + allrecover;
		if(s1.hp > s1.maxhp.intValue())
			s1.hp = s1.maxhp.intValue();
		if(s2.hp > s2.maxhp.intValue())
			s2.hp = s2.maxhp.intValue();
	}
	public void refresh() {
		if(hp<=0) {
			hp=0;
			alive = false;
		}
		hp_text.setText(hp+"/"+maxhp.intValue());
		if(152*hp/maxhp.intValue()>0)
			nowhp.setWidth(152*hp/maxhp.intValue());
		else
			nowhp.setWidth(0);
	}
}
