package Final;

import javafx.scene.text.Text;

public class Skill {
	public Text C_sname[] = new Text[6];
	public Text B_sname[] = new Text[12];
	public Text A_sname[] = new Text[16];
	public Text S_sname[] = new Text[11];
	public boolean used_sname[][] = new boolean[8][45];
	public Skill() {
		
	}
	public void setskill() {
		for(int j = 0;j < 8;j++) {
			for(int i = 0;i < 45;i++) {
			used_sname[j][i] = false;
			}
		}
		C_sname[0] = new Text("數學加強：10");
		C_sname[1] = new Text("語文加強：10");
		C_sname[2] = new Text("程式加強：10");
		C_sname[3] = new Text("全科加強：3");
		C_sname[4] = new Text("自我回復：20");
		C_sname[5] = new Text("全體回復：5");
		/////
		B_sname[0] = new Text("數學加強：25");
		B_sname[1] = new Text("語文加強：25");
		B_sname[2] = new Text("程式加強：25");
		B_sname[3] = new Text("全科加強：10");
		B_sname[4] = new Text("追加解題：1");
		B_sname[5] = new Text("數學專精：1");
		B_sname[6] = new Text("語文專精：1");
		B_sname[7] = new Text("程式專精：1");
		B_sname[8] = new Text("自我回復：40");
		B_sname[9] = new Text("全體回復：20");
		B_sname[10] = new Text("靈光乍現：20");
		B_sname[11] = new Text("靈光一閃：25");
		/////
		A_sname[0] = new Text("數學加強：50");
		A_sname[1] = new Text("語文加強：50");
		A_sname[2] = new Text("程式加強：50");
		A_sname[3] = new Text("全科加強：25");
		A_sname[4] = new Text("追加解題：2");
		A_sname[5] = new Text("數學專精：2");
		A_sname[6] = new Text("語文專精：2");
		A_sname[7] = new Text("程式專精：2");
		A_sname[8] = new Text("數學解題：1");
		A_sname[9] = new Text("語文解題：1");
		A_sname[10] = new Text("程式解題：1");
		A_sname[11] = new Text("自我回復：80");
		A_sname[12] = new Text("全體回復：50");
		A_sname[13] = new Text("意見整合：20");
		A_sname[14] = new Text("靈光乍現：30");
		A_sname[15] = new Text("靈光一閃：45");
		/////
		S_sname[0] = new Text("數學加強：80");
		S_sname[1] = new Text("語文加強：80");
		S_sname[2] = new Text("程式加強：80");
		S_sname[3] = new Text("全科加強：50");
		S_sname[4] = new Text("追加解題：3");
		S_sname[5] = new Text("全體解題：1");
		S_sname[6] = new Text("自我回復：150");
		S_sname[7] = new Text("全體回復：100");
		S_sname[8] = new Text("意見整合：40");
		S_sname[9] = new Text("靈光乍現：50");
		S_sname[10] = new Text("靈光一閃：75");
	}
}
