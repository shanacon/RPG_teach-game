package Final;

public class Teacher {
	public static double teach_rate = 1;
	public static int talk_rate = 1;
	public static int test_rate_talent = 0;
	public static double test_rate = 1;
	public static void refresh_all_rate() {
		teach_rate = 0;
		talk_rate = 1;
		test_rate_talent = 0;
		test_rate = 0;
	}
	public static void plus_teach_rate(double a) {
		teach_rate = teach_rate + a;
	}
	public static void plus_talk_rate(int a) {
		talk_rate = talk_rate + a;
	}
	public static void plus_test(int a,double b) {
		test_rate_talent = test_rate_talent + a;
		test_rate = test_rate +b;
	}
}
