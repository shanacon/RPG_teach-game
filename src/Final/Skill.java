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
		C_sname[0] = new Text("�ƾǥ[�j�G10");
		C_sname[1] = new Text("�y��[�j�G10");
		C_sname[2] = new Text("�{���[�j�G10");
		C_sname[3] = new Text("����[�j�G3");
		C_sname[4] = new Text("�ۧڦ^�_�G20");
		C_sname[5] = new Text("����^�_�G5");
		/////
		B_sname[0] = new Text("�ƾǥ[�j�G25");
		B_sname[1] = new Text("�y��[�j�G25");
		B_sname[2] = new Text("�{���[�j�G25");
		B_sname[3] = new Text("����[�j�G10");
		B_sname[4] = new Text("�l�[���D�G1");
		B_sname[5] = new Text("�ƾǱM��G1");
		B_sname[6] = new Text("�y��M��G1");
		B_sname[7] = new Text("�{���M��G1");
		B_sname[8] = new Text("�ۧڦ^�_�G40");
		B_sname[9] = new Text("����^�_�G20");
		B_sname[10] = new Text("�F���E�{�G20");
		B_sname[11] = new Text("�F���@�{�G25");
		/////
		A_sname[0] = new Text("�ƾǥ[�j�G50");
		A_sname[1] = new Text("�y��[�j�G50");
		A_sname[2] = new Text("�{���[�j�G50");
		A_sname[3] = new Text("����[�j�G25");
		A_sname[4] = new Text("�l�[���D�G2");
		A_sname[5] = new Text("�ƾǱM��G2");
		A_sname[6] = new Text("�y��M��G2");
		A_sname[7] = new Text("�{���M��G2");
		A_sname[8] = new Text("�ƾǸ��D�G1");
		A_sname[9] = new Text("�y����D�G1");
		A_sname[10] = new Text("�{�����D�G1");
		A_sname[11] = new Text("�ۧڦ^�_�G80");
		A_sname[12] = new Text("����^�_�G50");
		A_sname[13] = new Text("�N����X�G20");
		A_sname[14] = new Text("�F���E�{�G30");
		A_sname[15] = new Text("�F���@�{�G45");
		/////
		S_sname[0] = new Text("�ƾǥ[�j�G80");
		S_sname[1] = new Text("�y��[�j�G80");
		S_sname[2] = new Text("�{���[�j�G80");
		S_sname[3] = new Text("����[�j�G50");
		S_sname[4] = new Text("�l�[���D�G3");
		S_sname[5] = new Text("������D�G1");
		S_sname[6] = new Text("�ۧڦ^�_�G150");
		S_sname[7] = new Text("����^�_�G100");
		S_sname[8] = new Text("�N����X�G40");
		S_sname[9] = new Text("�F���E�{�G50");
		S_sname[10] = new Text("�F���@�{�G75");
	}
}
